package com.webelement;

public class Xpath {
	
	//- - - Login Page - - - 
	public static String login 		= "//input[@id='login']";
	public static String password	= "//input[@id='password']";
	public static String submit		= "//button[@type='submit']";
	//- - - Start Adobe Campaign home page - - - 
	public static String monitoring	= "//span[text()='Monitoring']";
	//- - - Search workflow in input box - - - 
	public static String dropdown	= "(//span[@class='nlui-dropdown-header-text-wrapper'])[1]";
	public static String dropdownAll= "(//span[@class='nlui-dropdown-item-label-wrapper'][contains(text(),'All')])[3]";
	public static String searchInput= "(//input[@placeholder='Search...'])[1]";
	public static String workflowSearch	= "(//span[@class='nlui-button-inner']//span[contains(text(),";
	//- - - Workflow Home Page - - - 
	public static String workflowStart= "//span[text()='Start the workflow']";
	public static String okPopup	=	"//span[text()='OK']";
	public static String displayLog	=	"//a[text()='Hide/display logs']";
	//- - - Audit Log
	public static String logHeader	= "//table[@class='cellContent']/tbody//tr//th";
	public static String logTable	= "//table[@class='content']/tbody//tr";
	
}
