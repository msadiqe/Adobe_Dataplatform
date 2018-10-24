package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.PropReader;
import com.adobe.utils.WebSelector;


public class TableData extends BrowserConfig {

	static By monitoring = By.xpath("//span[contains(text(),'Monitoring')]");
	static By search 	= By.xpath("//input[@placeholder='Search...']");
	static By dropdown	= By.xpath("(//span[@class='nlui-dropdown-header-text-wrapper'])[1]");
	static By dropdownAll = By
			.xpath("(//span[@class='nlui-dropdown-item-label-wrapper'] [contains(text(),'All')])[3]");
	static String  tableValue = "//span[@class='nlui-button-inner']//span[contains(text(),";
	static By STARTWORKFLOW = By
			.xpath("//span[contains(text(),'Start the workflow')]");
	static By POPUPOK = By
			.xpath("//span[@class='nlui-button-wrapper']//span[contains(text(),'OK')]");
	static By LOGBUTTON = By.xpath("//a[contains(text(),'Hide/display')]");
	static By LOGHEADER = By
			.xpath("//table[@class='cellContent']/tbody//tr//th");
	static By AUDITCONTAINER = By.xpath("//table[@class='content']/tbody/tr");
	static By PROECESSING_TIME = By
			.xpath("//td[contains(text(),'Last processing')]/following-sibling::td");
	

	static WebDriverWait wait;
	
	//static String tableName 	= "Table_Store_Classes";
	//static String tableName	= "Table Community Metrics";
	static String tableName		= "Automation Encryption";
	
	//static PropReader reader;
	//static String tableName = ConfigFile.getProperty("TableName");
	
	
	
	
	
	@Test
	public static void storeClasses() throws IOException {
		LoginPage.login();
		searchTable(reader.getProperty("TableName"));
		selectWorkflow();
		startWorkfow();
		auditLog();
	}

	public static void searchTable(String tableName) {
		
		
		driver.findElement(monitoring).click();
		String tableXPath = tableValue +"'"+tableName+ "')]";
		driver.findElement(search).sendKeys(tableName);
		wait = new WebDriverWait(driver, 30);
		driver.findElement(dropdown).click();
		wait.until(ExpectedConditions.elementToBeClickable(dropdownAll));
		driver.findElement(dropdownAll).click();
		driver.findElement(By.xpath(tableXPath)).click();
		
	}
	public static void selectWorkflow() {
		//driver.findElement(TABLE_STORECLASSES).click();
		//driver.findElement(TABLE_COMMUNITYMETRICS).click();
		
		
		
	}
	public static void startWorkfow(){
		driver.findElement(STARTWORKFLOW).click();
		driver.findElement(POPUPOK).click();
	}
	public static void auditLog() {
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.findElement(LOGBUTTON).click();
		

		wait.until(ExpectedConditions.elementToBeClickable((By
				.xpath("//td[contains(text(),'Workflow finished')]"))));
		List<WebElement> logHeader = driver.findElements(LOGHEADER);
		for (WebElement logHeaderValue : logHeader) {
			System.out.print(logHeaderValue.getText());
			System.out.print("\t\t");
		}
		List<WebElement> logContent = driver.findElements(AUDITCONTAINER);
		int log_Size = logContent.size();
		System.out.println("initial list size:" + log_Size);
		int container_lenth = 0;
		String processing_time = driver.findElement(PROECESSING_TIME).getText();
		String[] processTime = processing_time.split(":");
		String wfStartTime = processTime[1] + ":" + processTime[2];
		System.out.println("Time" + wfStartTime);
		for (int i = log_Size; i > 1; i--) {
			String date_value = "//table[@class='content']/tbody//tr[" + i
					+ "]/td[1]/div";
			// System.out.println(":"+
			// driver.findElement(By.xpath(date_value)).getText());
			String get_dateValue = driver.findElement(By.xpath(date_value))
					.getText();
			if (get_dateValue.contains(wfStartTime)) {
				container_lenth = i;
				System.out.println("We are in a loop");
				break;
			}
		}
		System.out.println("We are out of loop:" + container_lenth);
		
		for (int i = container_lenth-1; i >= 1; i--) {
			String message_x = "//table[@class='content']/tbody//tr[" + i
					+ "]/td[3]";
			String getMessage_x = driver.findElement(By.xpath(message_x))
					.getText();
			if (getMessage_x.contains("record(s)")) {
				System.out.println(getMessage_x);
				break;
			}
			//else{System.out.println("no records are found for inseretion"); }
		}
	}
	
	

}