package com.otm.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Constant {
	
	
	public static String eMail_pending="PENDING";
	public static String eMail_verified="VERIFIED";
	public static String eMail_expired="EXPIRED";
	public static String eMail_tokenError="TOKENERROR";
	
		@Value("${welcomesubject}")
	public  String welcomeSUB;
	
	@Value("${welcomemessage}")
	
	public  String welcomeMSG;
	
	public String getWelcomeSUB() {
		return welcomeSUB;
	}

	public String getWelcomeMSG() {
		return welcomeMSG;
	}

	public void setWelcomeSUB(String welcomeSUB) {
		this.welcomeSUB = welcomeSUB;
	}

	public void setWelcomeMSG(String welcomeMSG) {
		this.welcomeMSG = welcomeMSG;
	}

}
