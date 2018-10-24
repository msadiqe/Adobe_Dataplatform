package com.pages;

import com.adobe.framework.BrowserConfig;
import com.adobe.utils.PropReader;
import com.adobe.utils.WebSelector;
import com.webelement.Xpath;

public class LoginPage extends BrowserConfig {
	public static void enterCredentials() {
		driver.get(PropReader.getDecoderProperty("login"));
		WebSelector
				.send(Xpath.login, PropReader.getDecoderProperty("userName"));
		WebSelector.send(Xpath.password,
				PropReader.getDecoderProperty("userPassword"));
		WebSelector.click(Xpath.submit);
	}

	public static void login() {
		enterCredentials();
	}
}
