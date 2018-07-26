package com.otm.core.services;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class MailerImpl implements MailerService {

	@Autowired
	private MailConstant mailConstant;

	@Autowired
	MailService mailService;

	@Autowired
	private JavaMailSender emailSender;

	@Value("${welcomemessage}")
	private String welcomeMSG;

	@Value("${welcomesubject}")
	public String welcomeSUB;

	@Value("${buttonregistration}")
	public String buttonRegistration;

	@Autowired
	private SpringTemplateEngine templateEngine;

	public void sendWelcomeMail(MailDetail mailDetail, Customer customer, String token) throws Exception {

		// Map<String, Object> model = new HashMap<String, Object>();
		String Name = customer.getCustomerDetail().getFirstName() + customer.getCustomerDetail().getLastName();
		String tokenURL = mailConstant.getDomain() + mailConstant.getVerifyURL() + token;
		Map<String, Object> model = new HashMap<>();
		model.put("contentmessage", this.welcomeMSG);
		model.put("buttonMessage", this.buttonRegistration);
		model.put("name", Name);
		// String url = request.getScheme() + "://" + request.getServerName() + ":" +
		// request.getServerPort();
		// model.put("resetUrl"," http://localhost:8080"+mailConstant.verifyURL+token);
		String token1= "http://"+tokenURL+"/"+customer.getId();
		model.put("resetUrl",token1);
		System.out.println(" Token :"+token1);
		sendMail(mailDetail, model);
	}

	public void sendMail(MailDetail mailDetail, Map model) throws MessagingException {
		Context context = new Context();
		context.setVariables(model);
		String html = templateEngine.process("email-template", context);
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.setTo(mailDetail.getTo());
		helper.setText(html, true);
		System.out.println(" mail.getSubject() " + mailDetail.getSubject());
		helper.setSubject(mailDetail.getSubject());
		helper.setFrom(mailConstant.getEMailFrom());
		System.out.println(" Mail send");
		emailSender.send(message);

	}

	@Override
	public List<MailDetail> getUnSendMail() {
		List<MailDetail> mailtoSent = mailService.getUnSendMail();
		return mailtoSent;
	}

}
