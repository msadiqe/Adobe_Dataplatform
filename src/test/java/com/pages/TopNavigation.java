package com.pages;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.WebSelector;
import com.webelement.Xpath;

public class TopNavigation extends BrowserConfig {
	//clicking on on of the Top Navigation option
	public static void monitoring(){
		WebSelector.click(Xpath.monitoring);
	}

}
