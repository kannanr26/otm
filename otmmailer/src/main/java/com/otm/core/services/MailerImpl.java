package com.otm.core.services;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;
import com.otm.core.util.MailConstant;


@Service
public  class MailerImpl implements MailerService {

	@Autowired
	private MailConstant mailConstant;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	public void sendWelcomeMail(MailDetail mailDetail, Customer customer, String token) throws Exception {

//		Map<String, Object> model = new HashMap<String, Object>();
		String Name=customer.getCustomerDetail().getFirstName() + customer.getCustomerDetail().getLastName();
		/*
		 * model.put("location", "Belgium"); model.put("signature", "ht");
		 */
	//	mailDetail.setModel(model);
		String TokenURL=mailConstant.getDomain()+mailConstant.getVerifyURL() + token ;
		System.out.println(" Name :::"+Name+"  ::"+TokenURL);

		Context context = new Context();
		context.setVariable("name", Name);
		context.setVariable("subject", mailConstant.welcomeMSG);
		context.setVariable("token1",mailConstant.verifyURL+token);
		context.setVariable("token",TokenURL);
		context.setVariable("token2",token);
		// context.setVariables(mail.getModel());

		String html = templateEngine.process("email-template", context);
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.addAttachment("logo.png", new ClassPathResource("memorynotfound-logo.png"));

		helper.setTo(mailDetail.getTo());
		helper.setText(html, true);
		System.out.println(" mail.getSubject() "+mailDetail.getSubject());
		helper.setSubject(mailDetail.getSubject());
		helper.setFrom(mailConstant.getEMailFrom());
		emailSender.send(message);
	}

	@Override
	public List<MailDetail>  getUnSendMail() {
		List<MailDetail> mailtoSent=mailService.getUnSendMail();
		return mailtoSent;
	}

}
