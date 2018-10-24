package com.adobe.utils;

import java.io.IOException;

import org.testng.annotations.Test;

public class PropertyRead {
	
	
	static PropReader reader;
	
	@Test
	public static void readProp() throws IOException{
		reader = new PropReader();
	System.out.println("We are in th readProp method");	
	
	System.out.println("Value prop:" +reader.getProperty("sdq") );
	
		
	}
}
