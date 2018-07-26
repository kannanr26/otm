package com.otm.core.mailer;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.otm.core.model.MailDetail;
import com.otm.core.services.CustomerService;
import com.otm.core.services.MailService;
import com.otm.core.services.MailerService;

@Component
public class mailer {

	@Autowired
	MailerService mailerService;
	
	@Autowired
	CustomerService customerService;
	@Autowired
	MailService mailService;


	
	@Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
		 System.out.println("Cron Task :: Execution Time - {}"+LocalDateTime.now());
		List<MailDetail> mails=mailerService.getUnSendMail();
		System.out.println(" Mail list :"+mails.size());
		
		 ExecutorService executor = Executors.newFixedThreadPool(5);
	        for (int i = 0; i < mails.size(); i++) {
	            Runnable worker = new MailThread(mails.get(i),mailerService,mailService,customerService);
	            executor.execute(worker);
	          }
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	        }

		
    }
}
