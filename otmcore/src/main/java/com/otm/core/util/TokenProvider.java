package com.otm.core.util;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Value;

import com.otm.core.model.Customer;

public class TokenProvider {

	@Value("${mailerkey}")
	public static  String mailerKey;
	
	@Value("${mailermessage}")
	
	public static  String mailerMessage;
	
  public static String getToken(String keyPass,String secure,ValidationEnum enumValue) {
  	try {
  		System.out.println(" KEY :: & MESSAGE ::"+mailerKey+" :: &::"+mailerMessage);
	    String key = mailerKey+keyPass+enumValue.toString()+System.currentTimeMillis();
	    String message = mailerMessage+secure+System.currentTimeMillis();
	    
	    Mac hasher = Mac.getInstance("HmacSHA256");
	    hasher.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
	    
	    byte[] hash = hasher.doFinal(message.getBytes());
	    
	    // to lowercase hexits
	// System.out.println(   DatatypeConverter.printHexBinary(hash));
	    
	    // to base64
	 //System.out.println(      DatatypeConverter.printBase64Binary(hash));
	    return  DatatypeConverter.printHexBinary(hash);
  	}
  	catch (NoSuchAlgorithmException e) {}
  	catch (InvalidKeyException e) {}
  	return null;
  }
}