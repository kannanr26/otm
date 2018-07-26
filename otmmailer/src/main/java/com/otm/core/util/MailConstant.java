package com.otm.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailConstant {

	
	@Value("${spring.mail.username}")
	public   String eMailFrom;


	@Value("${domain}")
	public  String domain;
	
	@Value("${verifyURL}")
	public  String verifyURL;
	
	/*@Value("${welcomesubject}")
	public  String welcomeSUB;
	
	@Value("${welcomemessage}")
	
	public  String welcomeMSG;
*/
	public String getEMailFrom() {
		return eMailFrom;
	}

	public String getDomain() {
		return this.domain;
	}
/*
	public String getWelcomeSUB() {
		return welcomeSUB;
	}

	public String getWelcomeMSG() {
		return welcomeMSG;
	}
*/
	public void setEMailFrom(String eMailFrom) {
		this.eMailFrom = eMailFrom;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
/*
	public void setWelcomeSUB(String welcomeSUB) {
		this.welcomeSUB = welcomeSUB;
	}

	public void setWelcomeMSG(String welcomeMSG) {
		this.welcomeMSG = welcomeMSG;
	}

*/	public String getVerifyURL() {
		System.out.println(":::::"+this.verifyURL);
		return this.verifyURL;
	}

	public void setVerifyURL(String verifyURL) {
		this.verifyURL = verifyURL;
	}


}
