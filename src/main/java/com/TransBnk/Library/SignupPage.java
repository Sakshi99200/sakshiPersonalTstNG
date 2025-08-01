package com.TransBnk.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	public WebDriver driver;

	public SignupPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

}
