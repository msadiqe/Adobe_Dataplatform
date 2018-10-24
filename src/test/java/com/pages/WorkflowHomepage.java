package com.pages;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.WebSelector;
import com.webelement.Xpath;

public class WorkflowHomepage extends BrowserConfig{
	
	public static void starWorkflow(){
		
		
	}
	
	public static void clickOnWorkflow(){
		WebSelector.click(Xpath.workflowStart);
		WebSelector.click(Xpath.okPopup);
		
		
		WebSelector.click(Xpath.displayLog);
	}
	

}
