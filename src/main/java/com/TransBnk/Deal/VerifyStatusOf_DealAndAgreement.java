package com.TransBnk.Deal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyStatusOf_DealAndAgreement {
	public WebDriver driver;

	@FindBy(xpath = "//button[text()=' Initiated ']")
	private WebElement Agremment_Status;

	@FindBy(xpath = "//button[text()=' Pending Signing ']")
	private WebElement Deal_status;

	@FindBy(xpath = "(//button[text()=' Cancelled '])[1]")
	private WebElement DealStatus_afterCancelAgreement;

	@FindBy(xpath = "(//button[text()=' Cancelled '])[2]")
	private WebElement AgreementStatus_afterCancelAgreement;

	public VerifyStatusOf_DealAndAgreement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Verify_AgreementStatus() throws InterruptedException {

		System.out.println("Executing method :" + "VerifyStatusOf_DealAndAgreement.Verify_AgreementStatus()");

		Thread.sleep(10000);
		// Refresh the page
		driver.navigate().refresh();

		// to verify agreement status
		try {
			String Actual_Agreement_status = Agremment_Status.getText();
			String Expected_agreement_status = "Initiated";

			Assert.assertEquals(Expected_agreement_status, Actual_Agreement_status);


		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error occur in Verify_AgreementStatus method");
			System.err.println("Agreement status has not changed.");
		}
	}

	public void Verify_DealStatus() throws InterruptedException {
		System.out.println("Executing method :" + "VerifyStatusOf_DealAndAgreement.Verify_DealStatus()");

		Thread.sleep(3000);
		// to verify deal status.
		try {
			String Actual_Deal_status = Deal_status.getText();
			System.out.println(Actual_Deal_status);
			
			String Expected_Deal_status = "Pending Signing";

			Assert.assertEquals(Expected_Deal_status, Actual_Deal_status, "deal status has not changed.");


		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error occur in Verify_DealStatus method");
			System.err.println("Deal status has not changed.");
		}

	}

	public void Verify_DealStatus_AfterCancelAgreement() throws InterruptedException {

		System.out.println(
				"executing method :" + "VerifyStatusOf_DealAndAgreement.Verify_DealStatus_AfterCancelAgreement()");

		Thread.sleep(3000);

		// to verify deal status after cancel agreement.
		try {
			String Actual_Deal_status = DealStatus_afterCancelAgreement.getText();
			System.out.println(Actual_Deal_status);
			String Expected_Deal_status = "Cancelled";

			Assert.assertEquals(Expected_Deal_status, Actual_Deal_status,
					"after agreement cancellation Deal status has not changed.");

			Assert.assertTrue(true, Actual_Deal_status);

		} catch (Exception e) {
			System.out.println(e);
			System.err.println("error occur in Verify_DealStatus_AfterCancelAgreement()");
			System.out.println("Deal status has not changed after click on cancel agreement button.");
		}

	}

	public void Verify_AgreementStatus_AfterCancelAgreement() throws InterruptedException {

		System.out.println(
				"executing method :" + "VerifyStatusOf_DealAndAgreement.Verify_AgreementStatus_AfterCancelAgreement()");
		Thread.sleep(300);

		// to verify Agreement status after cancel agreement.
		try {

			String Actual_Deal_status = AgreementStatus_afterCancelAgreement.getText();
			System.out.println(Actual_Deal_status);
			String Expected_Deal_status = "Cancelled";

			Assert.assertEquals(Expected_Deal_status, Actual_Deal_status,
					"after deal cancelllation deal agreement status has not changed");

			Assert.assertTrue(true, Actual_Deal_status);

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error occur in Verify_AgreementStatus_AfterCancelAgreement()");
			System.err.println("agreement status has not changed after click on cancel agreement button.");
		}

	}

}
