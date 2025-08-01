package com.TransBnk.Deal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Estamp_agreement {
	public WebDriver driver;

	@FindBy(xpath = "//a[text()=' Estamp_agreement ']")
	private WebElement ClickOnEstamp_AgreementPdf_option;

	public Estamp_agreement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOn_AgreementPdf_option() throws InterruptedException {
		Thread.sleep(6000);
		System.out.println("Executing method :" + "Estamp_agreement.ClickOn_AgreementPdf_option()");
		try {
			// Refresh the page
			driver.navigate().refresh();
			if (ClickOnEstamp_AgreementPdf_option.isDisplayed()) {
				// click on agreement pdf option to open pdf
				ClickOnEstamp_AgreementPdf_option.click();
			} else {
				System.out.println("Estamp_Agreement Pdf option is not present on screen ");

			}
		} catch (Exception e) {
			System.err.println("Error occur in ClickOn_AgreementPdf_option method");
			System.err.println(e);
		}
	}
}
