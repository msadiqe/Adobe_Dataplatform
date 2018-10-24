package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.WebSelector;
import com.webelement.Xpath;

public class AuditTab extends BrowserConfig {

	public static void auditTab() {

		driver.navigate().refresh();
		WebSelector.click(Xpath.displayLog);
		// Log Header
		List<WebElement> logAudit = new ArrayList<WebElement>();
		logAudit = driver.findElements(By.xpath(Xpath.logTable));
		for (WebElement getLogAudit : logAudit) {
			System.out.println("size of the log: " + getLogAudit.getSize());
			//getAuditLog(logAudit );	
		}
	}
	public static void getAuditLog(List<WebElement> logAudit) {
		
		
		List<WebElement> logHeader = new ArrayList<WebElement>();
		for(WebElement getLogHeader : logHeader){
			System.out.println("Header: " +getLogHeader.getText());
		}
		
		//String logHeader	= Xpath.logHeader;
		//String date			= 
		
		
		
	}
}