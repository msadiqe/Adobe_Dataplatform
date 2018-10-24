package com.adobe.app;

import org.testng.annotations.Test;

import com.adobe.framework.BrowserConfig;
import com.pages.ErrorLogs;
import com.pages.LoginPage;

public class Applicatioon extends BrowserConfig{
	//WebDriver driver;
	String AdobeURL = "https://sephora-mkt-stage2.campaign.adobe.com/view/home?";
	String userNamev	 = "sadiq_Admin";
	String pssword		 = "123456";
	@Test
	public void app(){
		System.out.println("We are in APP");
		
		
		//driver.get(AdobeURL);
		LoginPage.login();
		//Workflows.selectWorkflow();
		//Workflows.tableForLogs();
		//ErrorLogs.getErrorLogHeader();
		//ErrorLogs.getErrorLog();
		//ErrorLogs.getErrorLogFailure();
		ErrorLogs.processingTime();
		
		
		
	}
	
	

}
