package com.otm.core.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Constant {
	
	
	public static String pending="PENDING";
	public static String registrationVerified="REG_VERIFIED";
	public static String resetPasswordVerified="PWD_VERIFIED";
	public static String expired="EXPIRED";
	public static String invalid="INVALID";
	public static String tokenError="TOKENERROR";
	public static String verified="VERIFIED";
	
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
