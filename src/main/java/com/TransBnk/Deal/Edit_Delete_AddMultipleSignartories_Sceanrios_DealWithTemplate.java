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

public class Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate {
	public WebDriver driver;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[1]")
	private WebElement ClickOnEditButton_Party01;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[2]")
	private WebElement ClickOnEditButton_Party02;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[3]")
	private WebElement ClickOnEditButton_Party03;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party1_Party_Address;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party2_Party_Address;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party3_Party_Address;

	@FindBy(xpath = "(//input[@formcontrolname=\"partyBranch\"])[1]")
	private WebElement Party1_PartyBranch;

	@FindBy(xpath = "(//*[@id=\"location\"])[1]")
	private WebElement Party2_PartyBranch;

	@FindBy(xpath = "(//*[@id=\"location\"])[1]")
	private WebElement Party3_PartyBranch;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div//form/div[1]/div/div[6]/div[2]/input")
	private WebElement Signing_Sequence_party1;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div//form/div[1]/div/div[6]/div[2]/input")
	private WebElement Signing_Sequence_party2;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div//form/div[1]/div/div[6]/div[2]/input")
	private WebElement Signing_Sequence_party3;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[7]/div[2]/input")
	private WebElement Party1_MinNoofSignatories;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[1]/div/div[7]/div[2]/input")
	private WebElement Party2_MinNoofSignatories;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[7]/div[2]/input")
	private WebElement Party3_MinNoofSignatories;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	private WebElement Party1_SaveButton;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	private WebElement Party2_SaveButton;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	private WebElement Party3_SaveButton;

	@FindBy(xpath = "(//input[@formcontrolname=\"partyName\"])[1]")
	private WebElement Party2_PartyName;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[2]/div[2]/div/input")
	private WebElement Party3_PartyName;

	@FindBy(xpath = "(//select[@formcontrolname=\"partyConstituentType\"])[1]")
	private WebElement Party2_PartyConstituentType;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[3]/div[2]/select")
	private WebElement Party3_PartyConstituentType;

	@FindBy(xpath = "//button[contains(.,'details')]")
	private WebElement Agreement_Details;

	@FindBy(xpath = "(//input[@type=\"date\" and @placeholder=\"Enter Value\"] )[1]")
	private WebElement Facilityletterdate;

	@FindBy(xpath = "(//input[@type=\"date\" and @placeholder=\"Enter Value\"] )[2]")
	private WebElement SD_Date;

	@FindBy(xpath = "//button[contains(.,'Next')]")
	private WebElement NextButton;

	@FindBy(xpath = "//button[contains(.,'Additional Details ')]")
	private WebElement AdditionalDetailsButton;

	@FindBy(xpath = "//button[contains(.,' Add Details ')]")
	private WebElement AddDetailsButton;

	@FindBy(xpath = "(//input[@id=\"field\"])")
	private WebElement EnterPartyPartnumber_1;

	@FindBy(xpath = "(//input[@id=\"field\"])[2]")
	private WebElement EnterPartyPartnumber_2;

	@FindBy(xpath = "(//input[@id=\"field\"])[3]")
	private WebElement EnterPartyPartnumber_3;

	@FindBy(xpath = "(//button[text()=\" Save \"])[2]")
	private WebElement ClickOnSaveButton_PartyCount;

	@FindBy(xpath = "//button[contains(.,'parties')]")
	private WebElement clickOnPartiesOption;

	@FindBy(xpath = "(//input[@formcontrolname=\"customFieldParty\"])[1]")
	private WebElement Party_synonym_1;

	@FindBy(xpath = "(//input[@formcontrolname=\"customFieldParty\"])[1]")
	private WebElement Party_synonym_2;

	@FindBy(xpath = "(//input[@formcontrolname=\"customFieldParty\"])[1]")
	private WebElement Party_synonym_3;

	@FindBy(xpath = "(//*[@id=\"collapse1\"]/div/div/form//div/button)[1]")
	private WebElement UpdateButton_party1;

	@FindBy(xpath = "(//*[@id=\"collapse2\"]/div/div/form//div/button)[1]")
	private WebElement UpdateButton_party2;

	@FindBy(xpath = "(//*[@id=\"collapse3\"]/div/div/form//div/button)[1]")
	private WebElement UpdateButton_party3;

	public Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// after saved the party details edit party details

	public void EditParty_01_Details() throws Exception {
		Thread.sleep(300);

		System.out.println("executing method :"
				+ "Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate.EditParty_01_Details()");
		try {

//			Actions action = new Actions(driver);
//
//			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(400);

			Assert.assertTrue(ClickOnEditButton_Party01.isDisplayed());

			ClickOnEditButton_Party01.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

			// enter Party Address
			Thread.sleep(500);

			Party1_Party_Address.click();

			Party1_Party_Address.clear();

			Party1_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));

			// Party Branch
			Thread.sleep(400);

			Party1_PartyBranch.click();

			Party1_PartyBranch.clear();

			Party1_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));

			// Signing Sequence

			Signing_Sequence_party1.click();

			Signing_Sequence_party1.clear();

			Signing_Sequence_party1.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party1"));

			// Min no of Signatories
			Thread.sleep(400);

			Party1_MinNoofSignatories.click();

			Party1_MinNoofSignatories.clear();

			Party1_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

			// enter Party synonym
			Thread.sleep(400);

			Party_synonym_1.click();

			Party_synonym_1.clear();

			Party_synonym_1.sendKeys(UtilityClass.getDatafromPropertyFile("Party_Synonym_1"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(2000);

			UpdateButton_party1.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error in method :"
					+ "Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate.EditParty_01_Details()");
		}
	}

	public void EditParty_02_Details() throws Exception {

		System.out.println("Executing method :"
				+ "Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate.EditParty_02_Details()");
		try {
			Thread.sleep(2000);

			// click on edit button
			ClickOnEditButton_Party02.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();

			// edit party address

			Thread.sleep(400);

			Party2_Party_Address.click();

			Party2_Party_Address.clear();

			Party2_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));
			Thread.sleep(500);

			// Party Branch

			Party2_PartyBranch.click();

			Party2_PartyBranch.clear();

			Party2_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));

			// Signing Sequence
			Thread.sleep(400);

			Signing_Sequence_party2.click();

			Signing_Sequence_party2.clear();

			Signing_Sequence_party2.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party2"));

			// Min no of Signatories

			Party2_MinNoofSignatories.click();

			Party2_MinNoofSignatories.clear();

			Party2_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

			// enter Party synonym
			Thread.sleep(400);

			Party_synonym_2.click();

			Party_synonym_2.clear();

			Party_synonym_2.sendKeys(UtilityClass.getDatafromPropertyFile("Party_Synonym_2"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(2000);
			UpdateButton_party2.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error in method : "
					+ "Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate.EditParty_02_Details()");
		}
	}

	public void EditParty_03_Details() throws Exception {
		System.out.println("executing method :"
				+ "Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate.EditParty_03_Details()");

		try {
			Thread.sleep(1000);

			// click on edit button
			ClickOnEditButton_Party03.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[3]")).click();

			Thread.sleep(2000);

			// enter Party Address

			Party3_Party_Address.click();
			Party3_Party_Address.clear();
			Party3_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));
			Thread.sleep(500);

			// Party Branch

			Party3_PartyBranch.click();
			Party3_PartyBranch.clear();
			Party3_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));
			Thread.sleep(500);

			// Signing sequence
			Signing_Sequence_party3.click();
			Signing_Sequence_party3.clear();
			Signing_Sequence_party3.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party3"));

			// Min no of Signatories
			Party3_MinNoofSignatories.click();
			Party3_MinNoofSignatories.clear();
			Party3_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

			// enter Party synonym
			Party_synonym_3.click();
			Party_synonym_3.clear();
			Party_synonym_3.sendKeys(UtilityClass.getDatafromPropertyFile("Party_Synonym_3"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			UpdateButton_party3.click();

		} catch (Exception e) {
			System.err.println("error in method :"
					+ "Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate.EditParty_03_Details()");

			System.err.println(e);
		}
	}

}
