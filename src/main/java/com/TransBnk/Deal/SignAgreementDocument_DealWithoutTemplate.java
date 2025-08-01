package com.TransBnk.Deal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignAgreementDocument_DealWithoutTemplate {

	public WebDriver driver;

	@FindBy(xpath = "//button[contains(.,'verify')]")
	private WebElement VerifyButton;

	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	private WebElement CheckBox;

	@FindBy(xpath = "//button[contains(.,' Proceed to Sign ')]")
	private WebElement ProceedToSignButton;

	@FindBy(xpath = "//button[contains(.,' Allow ')]")
	private WebElement clickOnAllowButtonOnPopup;

	public SignAgreementDocument_DealWithoutTemplate(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void ClickOnVerifyButton() throws InterruptedException {

		System.out.println("executing method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnVerifyButton()");

		try {
			// click on Verify button
			Thread.sleep(500);

			VerifyButton.click();

		} catch (Exception e) {

			System.err.println("Error in method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnVerifyButton()");
			System.err.println(e);
		}
	}

	public void ClickOnCheckBox() throws InterruptedException {

		System.out.println("Executing method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnCheckBox()");
		try {
			// click on checkBox
			Thread.sleep(2000);
			Actions actions = new Actions(driver);

			// Simulate pressing the "Tab" key three times using a loop
			int tabCount = 3;
			for (int i = 0; i < tabCount; i++) {
				actions.sendKeys(Keys.TAB).build().perform();
			}

			// Simulate pressing the "Space" key
			actions.sendKeys(Keys.SPACE).click().build().perform();

		} catch (Exception e) {
			System.err.println("Error in method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnCheckBox()");
			System.err.println(e);
		}
	}

	public void ClickOnProceedToSignButton() throws Exception {

		System.out.println(
				"Executing method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnProceedToSignButton()");

		try {
			// click on proceed to sign button
			Thread.sleep(500);

			ProceedToSignButton.click();

		} catch (Exception e) {
			System.out.println(
					"Error in Method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnProceedToSignButton()");
			System.err.println(e);
		}
	}

	public void ClickOnCheckBoxOnAdharCard() throws InterruptedException {

		System.out.println(
				"Executing method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnCheckBoxOnAdharCard()");

		try {
			Thread.sleep(5000);

			String pagesource = driver.getPageSource();

//			System.out.println(pagesource);
			String msg = "Transbnk Solutions Private Limited";

			if (pagesource.contains(msg)) {

				Assert.assertTrue(true, "After click on Send OTP button esign NSDL page is NOT displayed on screen");

				System.out.println("esign NSDL page is displayed on screen");

				driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();

			} else {
				Assert.fail("After click on Send OTP button " + "'esign NSDL page is NOT displayed on screen");
			}

		} catch (Exception e) {
			System.err.println(
					"error in method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnCheckBoxOnAdharCard()");
			System.err.println(e);

			Assert.fail("error in method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnCheckBoxOnAdharCard()");
		}
	}

	// ** enter adhar number ** //

	public void EnterAdharNumber() throws InterruptedException {
		System.out.println("Executing method :" + "SignAgreementDocument_DealWithoutTemplate.EnterAdharNumber()");

		try {

			Thread.sleep(500);

			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.TAB).build().perform();
//			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(500);
			actions.sendKeys("371074617099").build().perform();

		} catch (Exception e) {
			System.err.println("Error in method :" + "SignAgreementDocument_DealWithoutTemplate.EnterAdharNumber()");
			System.err.println(e);
		}
	}

	public void ClickOnSendOTPbutton() throws InterruptedException {
		System.out.println("Executing method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnSendOTPbutton()");

		try {
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(500);
			actions.sendKeys(Keys.SPACE).click().build().perform();

			Thread.sleep(30000);

//			driver.close();

		} catch (Exception e) {
			System.err
					.println("Error in method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnSendOTPbutton()");

			System.err.println(e);

			Assert.fail("Error in method :" + "SignAgreementDocument_DealWithoutTemplate.ClickOnSendOTPbutton()");
		}
	}

	// ---------GEO LOCATION --------------//

	public void geoLocationClickOnAllowButtonOnPopup() {

		System.out.println(
				"Executing Method : SignAgreementDocument_DealWithoutTemplate.geoLocationClickOnAllowButtonOnPopup()");

		try {

			Thread.sleep(2000);

			if (clickOnAllowButtonOnPopup.isDisplayed()) {

				System.out.println(
						"After click on PROCEED TO SIGN Button ,Location Capture Popup is displayed on screen ");

				clickOnAllowButtonOnPopup.click();

			} else {
				System.err.println(
						"Error in method : After click on PROCEED TO SIGN Button ,Location Capture Popup is NOT displayed on screen ");
				Assert.fail(
						"Error in method : After click on PROCEED TO SIGN Button ,Location Capture Popup is NOT displayed on screen ");
			}

		} catch (Exception e) {

			System.err.println(e);

			System.err.println(
					"Error in method : After click on PROCEED TO SIGN Button ,Location Capture Popup is NOT displayed on screen ");
			Assert.fail(
					"Error in method : After click on PROCEED TO SIGN Button ,Location Capture Popup is NOT displayed on screen ");
		}

	}

	public void geoLocationAllowLocationPopup() {

		System.out.println(
				"Executing method : SignAgreementDocument_DealWithoutTemplate.geoLocationAllowLocationPopup()");

		try {

			Alert alert = driver.switchTo().alert();

			// Accept the popup
			alert.accept();

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
