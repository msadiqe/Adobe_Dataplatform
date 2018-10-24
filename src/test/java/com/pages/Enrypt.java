package com.pages;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.testng.annotations.Test;

public class Enrypt {
	
	public static void encrption(String strClearText, String strKey) throws IllegalBlockSizeException, BadPaddingException {
		
		String strDate="";
		try {
			
			SecretKeySpec skeyspace = new SecretKeySpec(strKey.getBytes(), "blowfish");
			Cipher cipher = Cipher.getInstance("blowfish");
			cipher.init(cipher.ENCRYPT_MODE, skeyspace);
			byte[] encyrpted = cipher.doFinal(strClearText.getBytes());
			strDate = new String(encyrpted);
			
			System.out.println("Here is the value: " +strDate);
			
			
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public static void calling() throws IllegalBlockSizeException, BadPaddingException{
		 String strcleartext = "secretkeyValue";
		 String STRKEY = "secretKey";
		 
		encrption(strcleartext, STRKEY);
	}
	
	

}
