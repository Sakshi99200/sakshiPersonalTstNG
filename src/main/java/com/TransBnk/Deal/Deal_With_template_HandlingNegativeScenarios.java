package com.TransBnk.Deal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Deal_With_template_HandlingNegativeScenarios {

	public WebDriver driver;

	public Deal_With_template_HandlingNegativeScenarios(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
