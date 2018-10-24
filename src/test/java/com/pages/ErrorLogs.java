package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adobe.framework.BrowserConfig;

public class ErrorLogs extends BrowserConfig {
	static String processingTime = "(started on 09/22/2018 12:36:22 AM)";

	public static void processingTime() {
		// processingTime =
		// driver.findElement(By.xpath("//div//table//tbody//tr//td//span[@class='nlui-state-label']")).getText();
		// String[] splitValue = processingTime.split("(started on ");
		// System.out.println(splitValue[1]);
		// System.out.println("size of: "+splitValue.length);
		if (processingTime.contains("12:36")) {
			System.out.println("String Split");
		}
	}

	public static void getErrorLogHeader() {
		// get error date column
		List<WebElement> tableHeader = driver.findElements(By
				.xpath("//div/table[@class='cellContent']/tbody/tr/th"));
		for (WebElement gettableHeader : tableHeader) {
			System.out.print("Table Header" + gettableHeader.getText());
		}

	}

	public static void getErrorLog() {
		// Get error message
		List<WebElement> tableError = driver.findElements(By
				.xpath("//div/table[@class='content']/tbody/tr/td[3]"));
		for (WebElement getTableError : tableError) {
			System.out.println("Below are the error logs");
			System.out.println(getTableError.getText());
		}
	}

	public static void getErrorLogFailure() {
		// get failure error
		List<WebElement> tableErrorFailure = driver
				.findElements(By
						.xpath("//div//table[@class='content']/tbody/tr/td[1]/div/img[contains(@src,'logerr.png')]"));
		for (WebElement getTableErrorFailure : tableErrorFailure) {
			System.out.println("Below records gets failed");
			System.out.println(getTableErrorFailure.getTagName());
			System.out.println("Current Location"
					+ getTableErrorFailure.getLocation().getX());
		}
	}

}