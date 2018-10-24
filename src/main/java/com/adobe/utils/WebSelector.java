package com.adobe.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adobe.framework.BrowserConfig;

public class WebSelector extends BrowserConfig {
	
	public static void click(String locator){
		driver.findElement(By.xpath(locator)).click();
	}

	public static WebElement xPath(String locator) {
		WebElement xPath = driver.findElement(By.xpath(locator));
		return xPath;
		
	}
	public static void send(String locator, String value){
		driver.findElement(By.xpath(locator)).sendKeys(value);
		
	}
	
	
	

}
