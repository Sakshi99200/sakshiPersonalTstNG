package com.TransBnk.Deal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class AutoSign_Signatories_DealWithout_Template {

	public WebDriver driver;

	@FindBy(xpath = "//h6[text()='Party Signatories']")
	private WebElement PartySignatoires_option;

	@FindBy(xpath = "//button[text()=' Pending Signing ']")
	private WebElement Deal_status;

	@FindBy(xpath = "( //button[contains(.,'Add Signatories ')])[1]")
	private WebElement AddSignatoriesButton_Party1;

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

	@FindBy(xpath = "//*[@id=\"fromSignatory\"]/div//div[2]/div[2]/button[2]")
	private WebElement ClickOnConfirmButtonAfterEnterSignatioriesDetails;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/div[2]/div[2]/div/span")
	private WebElement AddCustomSignatories;

	public AutoSign_Signatories_DealWithout_Template(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Check_AutoSign_PartySignatoires() throws InterruptedException {
		System.out.println(
				"Executing Method : " + "AutoSign_Signatories_DealWithout_Template.Check_AutoSign_PartySignatoires()");

		Thread.sleep(7000);

		// click on dropdwon of party 1
		driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

		Actions action = new Actions(driver);

		action.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(3000);

		// check if auto sign is visible for party or not..

		if (PartySignatoires_option.isDisplayed()) {
			System.out.println("Party Signatories is visible for party 1 ");
			System.out.println("Auto Sign is visible for party 1");
		} else {
			System.err.println("auto sign is not visible for party 1 ");
		}

		Assert.assertTrue(PartySignatoires_option.isDisplayed(), "Error : AutoSign field is not Present on Screen");

		Thread.sleep(1000);
	}

	public void AddCustomSignatories_ForAutoSignParty() throws Exception {
		try {
			System.out.println("Executing Method :"
					+ "AutoSign_Signatories_DealWithout_Template.AddCustomSignatories_ForAutoSignParty()");

			AddSignatoriesButton_Party1.click();

			// click on add custom signatories

			Thread.sleep(1000);

			AddCustomSignatories.click();

			Thread.sleep(1000);

			EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party1"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);

			EnterSignatories_EmailAddress
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty1"));

			EnterSignatories_MobileNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party1"));

			ClickOnConfirmButton.click();
			Thread.sleep(400);

			ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

			Thread.sleep(4000);
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("error in Method :"
					+ "AutoSign_Signatories_DealWithout_Template.AddCustomSignatories_ForAutoSignParty()");
		}
	}

}
