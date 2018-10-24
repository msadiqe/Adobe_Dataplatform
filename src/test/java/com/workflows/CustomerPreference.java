package com.workflows;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.PropReader;
import com.pages.LoginPage;
import com.pages.TopNavigation;
import com.pages.WorkflowSearch;
import org.testng.annotations.Test;

public class CustomerPreference extends BrowserConfig {
	
	@Test
	public static void startCustomerPreference(){
		
		String workflowName= PropReader.getProperty("workflowName");
		System.out.println("We are in Customer Preference Workflow: ");
		LoginPage.login();
		System.out.println("succefully Loged-in in Adobe Campaign");
		TopNavigation.monitoring();
		System.out.println("succefully clicked on Monitoring button");
		WorkflowSearch.searchWorkflow(workflowName);
		
		
		
		
	}

}
