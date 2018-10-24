package com.adobe.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropReader {

	static Properties prop = new Properties();
	static String filePath = "src/test/resources/Config/config.properties";
	static Decoder decorder = Base64.getDecoder();

	public PropReader() throws IOException {
		try {
			FileInputStream input = new FileInputStream(filePath);

			prop.load(input);

			System.out.println("Sadiq");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("finally condition");

		}
	}

	public static String getProperty(String key) {
		String keyValue = prop.getProperty(key);
		return keyValue;

	}

	@Test
	public static String getDecoderProperty(String key) {
		String key1 = PropReader.getProperty(key);
		String decorderValue = new String(decorder.decode(key1));
		return decorderValue;
	}

}
