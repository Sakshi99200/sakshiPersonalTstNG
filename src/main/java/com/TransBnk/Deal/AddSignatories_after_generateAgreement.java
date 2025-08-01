package com.TransBnk.Deal;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class AddSignatories_after_generateAgreement {

	public WebDriver driver;

	@FindBy(xpath = "(//button[text()=' Add Signatories '])[1]")
	private WebElement AddSignatoryButton;
	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/div[2]/div[2]/div/span")
	private WebElement AddCustomSignatories;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryName\"]")
	private WebElement EnterSignatories_FullName;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryEmail\"]")
	private WebElement EnterSignatories_EmailAddress;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryMobile\"]")
	private WebElement EnterSignatories_MobileNumber;

	@FindBy(xpath = "//input[@id=\"YearofBirth\"]")
	private WebElement EnterSignatories_DateOfBirth;

	@FindBy(xpath = "//*[@id=\"confirmSignatory\"]/div//div[2]//div/button[2]")
	private WebElement ClickOnConfirmButton;

	@FindBy(xpath = "//*[@id=\"fromSignatory\"]/div//div[2]/div[2]/div[3]/button[2]")
	private WebElement ClickOnConfirmButtonAfterEnterSignatioriesDetails;

	public AddSignatories_after_generateAgreement(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// ** Click On Add Signatories ** //
	public void ClickOnAddSignatoriesButton() throws InterruptedException {

		System.out.println(
				"Executing  method :" + "AddSignatories_after_generateAgreement.ClickOnAddSignatoriesButton()");

		Assert.assertTrue(AddSignatoryButton.isDisplayed(), "Add SIgnatory option is not visible on screen");

		Thread.sleep(2000);
		AddSignatoryButton.click();

	}

	// ** enter details in signatories field ** //
	public void EnterDetails_InSignatories() throws Exception {

		try {
			Thread.sleep(1000);

			AddCustomSignatories.click();

			Thread.sleep(1000);

			EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party3"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);

			EnterSignatories_EmailAddress
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty3"));

			EnterSignatories_MobileNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party3"));

			ClickOnConfirmButton.click();
			Thread.sleep(400);

			ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

			Thread.sleep(400);
		} catch (Exception e) {
			System.err.println(e);
			System.err
					.println("error occur in " + "AddSignatories_after_generateAgreement.EnterDetails_InSignatories()");
		}
	}

}
