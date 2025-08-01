package com.TransBnk.Deal;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Edit_Delete_AddMultipleSignartories_Sceanrios {

	public WebDriver driver;

	@FindBy(xpath = "( //button[contains(.,'Add Signatories ')])[2]")
	private WebElement AddSignatoriesButton_Party2;

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

	@FindBy(xpath = "//*[@id=\"fromSignatory\"]/div//div[2]/div[2]/button[2]")
	private WebElement ClickOnConfirmButtonAfterEnterSignatioriesDetails;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[1]")
	private WebElement ClickOnEditButton_Party01;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[2]")
	private WebElement ClickOnEditButton_Party02;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[3]")
	private WebElement ClickOnEditButton_Party03;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement EditPartyAddress_party01;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement EditPartyAddress_party02;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement EditPartyAddress_party03;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[5]/div[2]/input")
	private WebElement EditParty1_PartyBranch;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[1]/div/div[5]/div[2]/input")
	private WebElement EditParty2_PartyBranch;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[5]/div[2]/input")
	private WebElement EditParty3_PartyBranch;

	@FindBy(xpath = "(//*[@id=\"collapse1\"]/div/div/form//div/button)[1]")
	private WebElement UpdateButton_party1;

	@FindBy(xpath = "(//*[@id=\"collapse2\"]/div/div/form//div/button)[1]")
	private WebElement UpdateButton_party2;

	@FindBy(xpath = "(//*[@id=\"collapse3\"]/div/div/form//div/button)[1]")
	private WebElement UpdateButton_party3;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[2]/img)[1]")
	private WebElement Delete_party01;

//	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[2]/img)[2]")
//	private WebElement Delete_party02;
//
//	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[2]/img)[3]")
//	private WebElement Delete_party03;

	@FindBy(xpath = "//button[text()=' Cancel Agreement ']")
	private WebElement ClickOnCancelAgreementButton;

	@FindBy(xpath = "//*[@id=\"popupForDealModalDelete\"]/div/div/div[3]/button[1]")
	private WebElement ClickOnYes_popup;

	@FindBy(xpath = "//textarea[@placeholder=\"Enter Reason Here\"]")
	private WebElement EnterReasonforCancellation;

	@FindBy(xpath = "//button[text()=' Proceed ']")
	private WebElement ClickOnProceed;

	@FindBy(xpath = "(//div[contains(.,' Party Signatories should not exceed 6 ')])[2]")
	private WebElement errorValidationMsg_ForAddingMultipleSignatoires;

	@FindBy(xpath = "//button[contains(.,'Send for Execution ')]")
	private WebElement SendForExecution;

	@FindBy(xpath = "//*[@id=\"sendForExecution\"]//div[2]/button[2]")
	private WebElement ConfirmButton;

	public Edit_Delete_AddMultipleSignartories_Sceanrios(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ** Add Multiple signatories for party 2 ** //

	public void AddCustomSignatories_Multiple_times(String Signatories_EmailAddress) throws Exception {

		System.out.println("Executing method :"
				+ "Edit_Delete_AddMultipleSignartories_Sceanrios.AddCustomSignatories_Multiple_times()");

		Thread.sleep(3000);

		try {
			AddSignatoriesButton_Party2.click();

			// click on add custom signatories

			Thread.sleep(1500);

			AddCustomSignatories.click();

			Thread.sleep(1500);

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_UP).build().perform();

			EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party3"));

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1500);

			EnterSignatories_EmailAddress.sendKeys(Signatories_EmailAddress);

			EnterSignatories_MobileNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party3"));

			ClickOnConfirmButton.click();
			Thread.sleep(400);

			ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

		} catch (Exception e) {

			System.out.println("Error in method :"
					+ "Edit_Delete_AddMultipleSignartories_Sceanrios.AddCustomSignatories_Multiple_times()");

			System.err.println(e);
		}
	}

	// after saved the party details edit party details

	public void EditParty_01_Details() throws Exception {

		System.out
				.println("Executing method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.EditParty_01_Details()");

		Thread.sleep(5000);

		try {

//			Actions action = new Actions(driver);
//
//			action.sendKeys(Keys.PAGE_UP).build().perform();
			Assert.assertTrue(ClickOnEditButton_Party01.isDisplayed());
			ClickOnEditButton_Party01.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

			// edit party address

			Thread.sleep(400);
			EditPartyAddress_party01.click();

			EditPartyAddress_party01.clear();
			Thread.sleep(400);
			EditPartyAddress_party01.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_PartyAddress"));

			// edit branch name

			Thread.sleep(700);
			EditParty1_PartyBranch.click();
			EditParty1_PartyBranch.clear();
			EditParty1_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_partyBranch"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(2000);
			UpdateButton_party1.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.EditParty_01_Details()");
			System.err.println("error occur while editing party 01 details");
		}

	}

	public void EditParty_02_Details() throws Exception {

		System.out
				.println("Executing method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.EditParty_02_Details()");
		try {
			Thread.sleep(2000);

			// click on edit button
			ClickOnEditButton_Party02.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();

			// edit party address

			Thread.sleep(400);

			EditPartyAddress_party02.click();

			EditPartyAddress_party02.clear();
			EditPartyAddress_party02.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_PartyAddress"));

			// edit branch name

			Thread.sleep(1000);

			EditParty2_PartyBranch.click();

			EditParty2_PartyBranch.clear();
			EditParty2_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_partyBranch"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(2000);
			UpdateButton_party2.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.EditParty_02_Details()");
			System.err.println("error occur while editing party 02 details");
		}
	}

	public void EditParty_03_Details() throws Exception {

		System.out
				.println("executing method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.EditParty_03_Details()");

		try {
			Thread.sleep(1000);

			// click on edit button
			ClickOnEditButton_Party03.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[3]")).click();

			// edit party address

			Thread.sleep(400);

			EditPartyAddress_party03.click();

			EditPartyAddress_party03.clear();

			EditPartyAddress_party03.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_PartyAddress"));

			// edit branch name

			Thread.sleep(700);

			EditParty3_PartyBranch.click();

			EditParty3_PartyBranch.clear();

			EditParty3_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_partyBranch"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			UpdateButton_party3.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.EditParty_03_Details()");
			System.err.println("error occur while editing party 03 details");
		}
	}

	// ** delete party details ** //

	public void Delete_Party01_Details() throws InterruptedException {

		System.out.println(
				"Executing method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party01_Details()");
		try {

			Thread.sleep(2000);
			Delete_party01.click();
			Thread.sleep(700);
			Assert.assertTrue(ClickOnYes_popup.isDisplayed());

			ClickOnYes_popup.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party01_Details()");
			System.err.println("error occur while Deleting party 01 details");
		}
	}

	public void Delete_Party02_Details() throws InterruptedException {

		System.out.println(
				"Executing method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party02_Details()");
		try {

			Thread.sleep(2000);
			Delete_party01.click();
			Thread.sleep(700);
			Assert.assertTrue(ClickOnYes_popup.isDisplayed());

			ClickOnYes_popup.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party02_Details()");
			System.err.println("error occur while Deleting party 02 details");
		}
	}

	public void Delete_Party03_Details() throws InterruptedException {

		System.out.println(
				"Executing method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party03_Details()");
		try {

			Thread.sleep(2000);
			Delete_party01.click();
			Thread.sleep(700);
			Assert.assertTrue(ClickOnYes_popup.isDisplayed());

			ClickOnYes_popup.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party03_Details()");
			System.err.println("error occur while Deleting party 03 details");
		}
	}

	public void RefreshPage() throws InterruptedException {
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	public void ErrorValidationMsg_ForAddingMultipleSignatoires() throws InterruptedException {

		System.out.println("Executing method :"
				+ "Edit_Delete_AddMultipleSignartories_Sceanrios.ErrorValidationMsg_ForAddingMultipleSignatoires()");

		if (SendForExecution.isDisplayed()) {

			Assert.assertTrue(SendForExecution.isDisplayed(), "Error: SendForExecution Button is not displayed.");

			SendForExecution.click();

			Thread.sleep(400);

			// click on confirm button

			ConfirmButton.click();
			Thread.sleep(400);

		} else {

			System.err.println("Error : indicating an issue while initiating the deal.");

		}
		try {
			Thread.sleep(200);
			// ** Error validation message for adding multiple custome signatoires ** //

			String ErrorValidationMsg_ForAddingMultipleSignatoires = errorValidationMsg_ForAddingMultipleSignatoires
					.getText();

			System.out.println(ErrorValidationMsg_ForAddingMultipleSignatoires);

			Assert.assertTrue(errorValidationMsg_ForAddingMultipleSignatoires.isDisplayed(),
					"Party Signatories should not exceed 6");

		} catch (Exception e) {
			System.err.println(e);
			System.err.println(
					"Edit_Delete_AddMultipleSignartories_Sceanrios.ErrorValidationMsg_ForAddingMultipleSignatoires()");
		}
	}

	public void Cancel_Agreement() {

		System.out.println("Executing Method :" + "Edit_Delete_AddMultipleSignartories_Sceanrios.Cancel_Agreement()");

		try {
			Thread.sleep(3000);

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Assert.assertTrue(ClickOnCancelAgreementButton.isDisplayed(),
					"Cancel agreement button is not visible on screen");

			Thread.sleep(300);

			ClickOnCancelAgreementButton.click();

			Thread.sleep(300);

			// enter reason for cancellation

			EnterReasonforCancellation.sendKeys(UtilityClass.getDatafromPropertyFile("ReasonForCancellation"));

			// click on proceed button

			Thread.sleep(200);

			ClickOnProceed.click();
			Thread.sleep(200);
			System.out.println(" Agreement cancelled successfully..");

		} catch (Exception e) {

			System.err.println(e);
			System.err.println("Edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party03_Details()");
		}
	}

}
