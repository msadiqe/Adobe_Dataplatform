package com.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.WebSelector;
import com.webelement.Xpath;

public class WorkflowSearch extends BrowserConfig{
	
	public static void searchWorkflow(String workflowName){
		
		WebSelector.click(Xpath.dropdown);
		wait.until(ExpectedConditions.elementToBeClickable(WebSelector.xPath(Xpath.dropdownAll)));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Xpath.dropdownAll))));
		WebSelector.click(Xpath.dropdownAll);
		String workfowSearchXpath = Xpath.workflowSearch +"'"+workflowName + "')])[1]";
		WebSelector.send(Xpath.searchInput, workflowName);
		wait.until(ExpectedConditions.elementToBeClickable(WebSelector.xPath(workfowSearchXpath)));
		WebSelector.click(workfowSearchXpath);
		System.out.println("Workflow searched successfully: " +workflowName);
	}
}
