package com.TransBnk.Payouts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Accounts_Master {
	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"PAYOUTS\"]")
	private WebElement Payouts;

	@FindBy(xpath = "//a[contains(.,'Accounts Master')]")
	private WebElement AccountMaster;

	@FindBy(xpath = "//button[contains(.,'Upload')]")
	private WebElement UploadBUtton;

	@FindBy(xpath = "//input[@id=\"fileUpload\"]")
	private WebElement ClickOn_BrowseFilesToUpload;

	@FindBy(xpath = "//*[@id=\"toast-container\" and contains(.,'No Data For Upload')]/div")
	private WebElement ErrorValidationForUploading_BlankFile;

	public Accounts_Master(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOn_PayoutsOption() throws InterruptedException {
		Thread.sleep(1000);

		Payouts.click();
	}

	public void ClickOn_AccountMasterOption() throws InterruptedException {
		Thread.sleep(500);
		AccountMaster.click();

	}

	public void ClickOn_UploadButton() throws InterruptedException {
		Thread.sleep(1000);

		UploadBUtton.click();
	}

	// ** upload blank file ** //
	public void Upload_BlankFile() throws InterruptedException {

		Thread.sleep(1000);

		// click on browse files to upload blank file

		ClickOn_BrowseFilesToUpload
				.sendKeys(System.getProperty("user.dir") + "/TestData/Accounts Blank File Upload.xlsx");
	}

	public void Check_ErrorValidationForUploading_BlankFile() {

		// checking error validation message for uploading blank file
		String String_ErrorValidationForUploading_BlankFile = ErrorValidationForUploading_BlankFile.getText();

		Assert.assertTrue(ErrorValidationForUploading_BlankFile.isDisplayed());

		System.out.println("Error validation message is displayed after uploading blank file "
				+ String_ErrorValidationForUploading_BlankFile);
	}

	
}
