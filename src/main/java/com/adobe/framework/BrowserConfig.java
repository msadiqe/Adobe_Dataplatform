package com.adobe.framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.adobe.utils.PropReader;
import com.adobe.utils.WebSelector;

public class BrowserConfig {
	
	
	public static WebDriver driver;
	
	protected static PropReader reader;
	public static WebDriverWait wait;
	
	
	
	@BeforeTest
	public static void setBorwser() throws IOException{
				
		System.out.println("BeforeTest");
		reader = new PropReader();
		
		if (PropReader.getProperty("BROWSERNAME").equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver", "src/main/resources/browser/chromedriver.exe");
			driver = new ChromeDriver();
			//wait = new WebDriverWait(driver, 30);
		} else if (PropReader.getProperty("BROWSERNAME").equalsIgnoreCase("FIREFOX")){
			System.setProperty("webdriver.gecko.driver", "src/main/resources/browser/firefox.exe");
			driver = new FirefoxDriver();
			
		} else if (PropReader.getProperty("BRWOSERNAME").equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "src/main/resources/browser/firefox.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		
		
		
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("after browser Config: ");
		
		
	}
	
	@AfterTest
	public static void tearDown(){
		//driver.quit();
	}

}
