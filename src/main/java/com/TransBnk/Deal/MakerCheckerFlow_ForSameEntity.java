package com.TransBnk.Deal;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;

public class MakerCheckerFlow_ForSameEntity {
	public WebDriver driver;

	@FindBy(xpath = "//button[text()=' Submit for Verification ']")
	private WebElement SubmitForVerification;

	@FindBy(xpath = "//a[text()='Deal Verification']")
	private WebElement DealVerificationOption;

	@FindBy(xpath = " //button[text()=' Return for Correction ']")
	private WebElement ClickOnReturnForVerificationButton;

	@FindBy(xpath = "//*[@id=\"returnForCorrection\"]/div/div/div[2]/form/div/div[2]/textarea")
	private WebElement EnterReasonBox;

	@FindBy(xpath = "//*[@id=\"returnForCorrection\"]/div/div/div[3]/button[2]")
	private WebElement ClickOnConfirmButton;

	@FindBy(xpath = "(//*[@id=\"headingTwo\"]/h5/a/div/div/span[3]/img)[1]")
	private WebElement ClickOnEditButton;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party1_Party_Address;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div//form//div[5]/div[2]/input")
	private WebElement Party1_PartyBranch;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[4]/div/button")
	private WebElement ClickOnUpdateButton;

	@FindBy(xpath = "//div[2]/div/main/app-add-agreement-detail/div[1]/app-section-header/div//div[2]/div/app-button[2]/button")
	private WebElement ClickOnProceedButton;

	@FindBy(xpath = "//button[contains(.,'Proceed')]")
	private WebElement ProceedButton;

	public MakerCheckerFlow_ForSameEntity(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnSubmitForVerificationButton() throws InterruptedException {
		Thread.sleep(2000);

		System.out
				.println("Executing method :" + "MakerCheckerFlow_ForSameEntity.ClickOnSubmitForVerificationButton()");
		try {
			// click on submit for verification button
			if (SubmitForVerification.isDisplayed()) {

				Assert.assertTrue(SubmitForVerification.isDisplayed(),
						"Submit for verification button is not  present on the screen");

				SubmitForVerification.click();

				System.out.println("Submit for verification button is Present on screen");

			} else {
//			System.out.println("Submit for verification button is not present on screen");

			}

			Thread.sleep(2000);
		} catch (Exception e) {
			System.err.println(
					"Error in method :" + "MakerCheckerFlow_ForSameEntity.ClickOnSubmitForVerificationButton()");
			System.err.println(e);
		}
	}

	public void ClickOnDealVerificationOption() throws InterruptedException {
		System.out.println("Executing method :" + "MakerCheckerFlow_ForSameEntity.ClickOnDealVerificationOption()");
		Thread.sleep(700);
		try {
			DealVerificationOption.click();
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error in method " + "MakerCheckerFlow_ForSameEntity.ClickOnDealVerificationOption()");
		}
	}

	// ** Deal Correction ** //

	public void ReturnDealForCorrection() throws Exception {
		System.out.println("Executing method :" + "MakerCheckerFlow_ForSameEntity.ReturnDealForCorrection()");
		try {
			// click on return for correction button

			Thread.sleep(1000);

			ClickOnReturnForVerificationButton.click();

			// enter reason in popup

			EnterReasonBox.sendKeys(UtilityClass.getDatafromPropertyFile("Enter_Reason"));

			// click on confirm button
			Thread.sleep(400);

			ClickOnConfirmButton.click();
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("Error in method :" + "MakerCheckerFlow_ForSameEntity.ReturnDealForCorrection()");
		}
	}

	// ** Edit party details for deal correction flow ** //

	public void ClickOnProceedButton() throws InterruptedException {
		Thread.sleep(1500);

		System.out.println("executing method :" + "MakerCheckerFlow_ForSameEntity.ClickOnProceedButton()");

		try {
			ProceedButton.click();

		} catch (Exception e) {
			System.err.println("Error in method " + "MakerCheckerFlow_ForSameEntity.ClickOnProceedButton()");
			System.err.println(e);
		}
	}

	public void Edit_partyDetails_forDealCorrection() throws Exception {
		System.out
				.println("Executing method :" + "MakerCheckerFlow_ForSameEntity.Edit_partyDetails_forDealCorrection()");

		try {
			// edit 1st party details //

			// click on Edit Button of party 1

			Thread.sleep(3000);
			Assert.assertTrue(ClickOnEditButton.isDisplayed());
			ClickOnEditButton.click();

			// click on expand button

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

			System.out.println("hi");
			// Edit Party Address
			Thread.sleep(500);

			Party1_Party_Address.clear();

			Party1_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_PartyAddress"));

			// edit Party Branch
			Thread.sleep(300);

			Party1_PartyBranch.clear();

			Party1_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("Edit_partyBranch"));

			// click on update button

			Thread.sleep(400);

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(400);

			try {

				ClickOnUpdateButton.click();

			} catch (ElementNotInteractableException e) {
				driver.findElement(By.xpath("//*[@id=\"collapse1\"]/div/div/form/div[3]/div/button")).click();

			}
			// click on proceed button
			Thread.sleep(1000);

			action.sendKeys(Keys.PAGE_UP).build().perform();

			action.sendKeys(Keys.PAGE_UP).build().perform();

			Thread.sleep(1000);

			ClickOnProceedButton.click();

		} catch (Exception e) {
			System.err.println(
					"error in method :" + "MakerCheckerFlow_ForSameEntity.Edit_partyDetails_forDealCorrection()");

			System.err.println(e);
		}

	}

}
