package com.TransBnk.Deal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class uploadValid_InvalidFileFormat {
	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div//div[2]/div[3]/button[2]")
	private WebElement ClickOnConfrimButton;

	public uploadValid_InvalidFileFormat(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
