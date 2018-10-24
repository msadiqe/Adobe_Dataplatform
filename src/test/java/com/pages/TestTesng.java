package com.pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTesng {
	
	@BeforeTest
	public static void beforeT(){
		System.out.println("Before Test1");
	}
	
	@AfterTest
	public static void afterT(){
		System.out.println("After Test1");
	}
	
	@Test(description="First method", alwaysRun=true)
	public static void first(){
		System.out.println("First Method");
	}
	
	@Test(description="Second method", priority=2)
	public static void second(){
		System.out.println("Second Method");
	}
	
	@Test(description="Third method", priority=3)
	public static void third(){
		System.out.println("Third Method");
	}
	
	@Test(description="fourth method", priority=4)
	public static void fourth(){
		System.out.println("Fourth Method");
	}

}
