package com.TransBnk.Deal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Agreement_Pdf_DealWithout_template {
	public WebDriver driver;

	@FindBy(xpath = "//a[text()=' Agreement.pdf ']")
	private WebElement ClickOnAgreementPdf_option;

	public Agreement_Pdf_DealWithout_template(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ** ClickOn Agreemetn pdf option **//
	public void ClickOn_AgreementPdf_option() throws InterruptedException {
		
		Thread.sleep(2000);
		try {
			if (ClickOnAgreementPdf_option.isDisplayed()) {
				ClickOnAgreementPdf_option.click();
			} else {
				System.err.println("Agreement Pdf option is not Displayed on screen ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occur in ClickOn_AgreementPdf_option method");

		}
	}
}
