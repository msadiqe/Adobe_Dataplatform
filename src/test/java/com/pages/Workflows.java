package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adobe.framework.BrowserConfig;
import com.adobe.framework.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Workflows extends BrowserConfig {
	static String 
	workflowURL = "https://sephora-mkt-stage2.campaign.adobe.com/view/workflow?id=24216228&__universe=social&__securitytoken=%40bOs-BMLQ6TFD9OBOfN7z-WWitdoVNo2JaqsNwMHy8menswKXMljRNgKNsvCsAtrFz10yi9cCcn9bnwf5eGbg0GBDZsCrfmAXXwRHoeBM-6s%3D";
	static By startWorkflow 		= By.xpath("//span[text()='Start the workflow']");
	static By OkButtonForWorkflow 	= By.xpath("//span[text()='OK']");
	static By hideDisplay 			= By.xpath("//a[text()='Hide/display logs']");
	
	static By tableLogs				= By.xpath("//div//table[@class='content']/tbody/tr");
	// Extents Report
	ExtentHtmlReporter htmlReporter;
	ExtentReport extents;
	ExtentTest test;
	
	public static void selectWorkflow(){
		driver.get(workflowURL);
		String title="//div[@id='sectionHeader']/div/div[2]/div";
		String titleValue = driver.findElement(By.xpath(title)).getText();
		System.out.println("Current Workflow: " +titleValue);
		//click on start worklow button
		driver.findElement(startWorkflow).click();
		driver.findElement(OkButtonForWorkflow).click();
		//Refresh a page 
		
		driver.navigate().refresh();
		driver.navigate().refresh();
		
		driver.findElement(hideDisplay).click();	
		
	}
	
	public static void tableForLogs(){
		WebElement tableBody = driver.findElement(tableLogs);
		//String tableTag =	driver.findElement(tableLogs).getTagName();
		String tableValue =	driver.findElement(tableLogs).getSize().toString();
		//System.out.println("LogTable: "+tableTag);
		System.out.println("getSizeValues: "+tableValue);
	
		//driver.findElement(By.xpath("//div[@id='jobDetail24172218']/table[2]/tbody"));
		
		List<WebElement> tablerow = driver.findElements(By.xpath("//div[@class='nlui-section-base-contents nlui-section-contents']/table/tbody/tr"));
		System.out.println("lenght: " +tablerow.size());
		for (WebElement getrow: tablerow){
			System.out.println("get the tag name: "+getrow.getTagName());
		}
		List <WebElement> tableHeader = driver.findElements(By.xpath("//div/table[@class='cellContent']/tbody/tr/th"));
		System.out.println("lenght: " +tableHeader.size());
		for(WebElement getHeaderValue: tableHeader){
			System.out.print("    "+getHeaderValue.getText());
		}
		System.out.println(" ");
		//Display Log Message
		List <WebElement> logTable = driver.findElements(By.xpath("//div//table[@class='content']/tbody/tr/td[3]"));
		System.out.println("TbaleLog size: " +logTable.size());
		
		for(WebElement getlogTable : logTable){
			
			String tringTableLog = getlogTable.getText();
			if (tringTableLog.contains("run")){
				
				System.out.println("Log: "+getlogTable.getText());
			}
			
			else {}
			
		}
		//Trying to get Erorr logo
		
		List <WebElement> logTableEror = driver.findElements(By.xpath("//div//table[@class='content']/tbody/tr/td[1]"));
		System.out.println("TbaleLog Eror size: " +logTableEror.size());
		
		for(WebElement getlogTableEror : logTableEror){
			
			//System.out.println("Error value: "+getlogTableEror.getText());
			
		}
		
		// Seatching error log image in the first columns
		List <WebElement> logTableErorImage = driver.findElements(By.xpath("//div//table[@class='content']/tbody/tr/td[1]/div/img[contains(@src,'logerr.png')]"));
		System.out.println("TbaleLog Error image size: " +logTableErorImage.size());
		
		for(WebElement getlogTableErorImage : logTableErorImage){
					
			System.out.println("Error value: "+getlogTableErorImage.getText());
						
		}
		
	}
	public void extentReport(){
		htmlReporter = new ExtentHtmlReporter("");
		extents = new ExtentReport();
		
		
		
		
	}
		
}
