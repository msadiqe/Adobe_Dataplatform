package com.sample.data;

import org.testng.annotations.Test;

public class SampleTestScript {

	@Test
	public static void string(){
		String processing = "10/01/2018 2:13:59 PM";
		System.out.println("trim: "+processing.trim());
		System.out.println("split"+processing.split(":"));
		String[] strngList =  processing.split(":");
			
		
		System.out.println("String lengh:" +strngList.length);
		
		for(int i=0; i<strngList.length; i++ ){
			String newkey = strngList[i];
			System.out.println(i +":"+newkey);
			
		}
		
		
	}
}
