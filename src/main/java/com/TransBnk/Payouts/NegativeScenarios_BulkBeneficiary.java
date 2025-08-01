package com.TransBnk.Payouts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class NegativeScenarios_BulkBeneficiary {

	public WebDriver driver;
	@FindBy(xpath = "//input[@id=\"remark\"]")
	private WebElement EnterRemark;

	@FindBy(xpath = "//button[contains(.,' Confirm ')]")
	private WebElement ClickOnConfirmButton;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[1]")
	private WebElement CancelButton_row2;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[2]")
	private WebElement CancelButton_row3;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[3]")
	private WebElement CancelButton_row4;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[4]")
	private WebElement CancelButton_row5;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[5]")
	private WebElement CancelButton_row6;

	public static String remark;
	public static String CustomerRefNo;
	public static String ExternalRefNo;
	public static String BenCode;
	public static String InvalidAccountNo_row3;
	public String CustomerRefNo_row3;
	public String CustomerRefNo_row4;
	public String CustomerRefNo_row5;
	public String BeneCode_row2;
	public String BeneCode_row3;
	public String BeneCode_row5;
	public String BeneCode_row6;
	public String ExternalRefNo_row3;
	public String ExternalRefNo_row4;
	public String ExternalRefNo_row5;
	public String AccountNo_row6;

	public NegativeScenarios_BulkBeneficiary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("ddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;

	}

	// store dynamic value in methos
	public static String getAccountNo() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("AccountNo") + getCurrentTimeStamp();

	}

	public static String getInvalidAccountNo_Row3() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("InvalidAccountNo_bulkbeneficiary_row3") + getCurrentTimeStamp();
	}

	public static String getAccountNo_Row4() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("AccountNo") + getCurrentTimeStamp();

	}

	public static String getAccountNo_Row6() throws Exception {
		Thread.sleep(1000);
		return UtilityClass.getDatafromPropertyFile("AccountNo") + getCurrentTimeStamp();

	}

	public static String getCustomerRefNo_Row2() throws Exception {
		Thread.sleep(200);

		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getCustomerRefNo_Row3() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getCustomerRefNo_Row4() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getCustomerRefNo_Row5() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getCustomerRefNo_Row6() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo_Row3() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("ExternalRefNo") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo_Row4() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("ExternalRefNo") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo_Row5() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("ExternalRefNo") + getCurrentTimeStamp();
	}

	public static String getBenCode_Row2() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("BenCode") + getCurrentTimeStamp();
	}

	public static String getBenCode_Row3() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("BenCode") + getCurrentTimeStamp();
	}

	public static String getBenCode_Row5() throws Exception {
		Thread.sleep(1000);

		return UtilityClass.getDatafromPropertyFile("BenCode") + getCurrentTimeStamp();
	}

	public static String getBenCode_Row6() throws Exception {
		Thread.sleep(1200);

		return UtilityClass.getDatafromPropertyFile("BenCode") + getCurrentTimeStamp();
	}

	public void insertDataIntoExcel() throws Exception {
		Thread.sleep(1000);

		// Path to your Excel file
		String excelFilePath = System.getProperty("user.dir") + "/TestData/Bulk Beneficiary negative Scenarios.xlsx";

		// Initialize FileInputStream to read the Excel file
		FileInputStream inputStream = new FileInputStream(excelFilePath);

		// Initialize Workbook using XSSFWorkbook
		Workbook workbook = new XSSFWorkbook(inputStream);

		// Get the first sheet from the workbook
		Sheet sheet = workbook.getSheetAt(0);

		// ** ** //

		ExternalRefNo = getExternalRefNo_Row3();

		InvalidAccountNo_row3 = getInvalidAccountNo_Row3();

		remark = getCurrentTimeStamp();

		// negative scenarios data

		String Invalid_CustomerID_row2 = UtilityClass.getDatafromPropertyFile("InvalidCustomerID_BulkBeneficiary_row2");

		// customer ref no **
		CustomerRefNo_row3 = getCustomerRefNo_Row3();
		CustomerRefNo_row4 = getCustomerRefNo_Row4();
		CustomerRefNo_row5 = getCustomerRefNo_Row5();

		// ben code **
		BeneCode_row2 = getBenCode_Row2();
		BeneCode_row3 = getBenCode_Row3();
		BeneCode_row5 = getBenCode_Row5();
		BeneCode_row6 = getBenCode_Row6();

//		--
		// external ref no.

		ExternalRefNo_row3 = getExternalRefNo_Row3();
		ExternalRefNo_row4 = getExternalRefNo_Row4();
		ExternalRefNo_row5 = getExternalRefNo_Row5();

		// account number
		AccountNo_row6 = getAccountNo_Row6();

		// Define column names and data to insert using HashMap
		Map<String, String[]> columnDataMap = new HashMap<>();
		columnDataMap.put("Customer Id *",
				new String[] { Invalid_CustomerID_row2, UtilityClass.getDatafromPropertyFile("CustomerId"), "",
						UtilityClass.getDatafromPropertyFile("CustomerId"),
						UtilityClass.getDatafromPropertyFile("CustomerId"), });

		columnDataMap.put("Customer Ref No *",
				new String[] { "", CustomerRefNo_row3, CustomerRefNo_row4, CustomerRefNo_row5, CustomerRefNo_row3 });

		columnDataMap.put("External Ref No *",
				new String[] { "", ExternalRefNo_row3, ExternalRefNo_row4, ExternalRefNo_row5, ExternalRefNo_row3 });

		columnDataMap.put("Maker Id", new String[] { UtilityClass.getDatafromPropertyFile("MakerId"),
				UtilityClass.getDatafromPropertyFile("MakerId"), UtilityClass.getDatafromPropertyFile("MakerId"),
				UtilityClass.getDatafromPropertyFile("InvalidMakerID_BulkBeneficiary_row4"), });

		columnDataMap.put("Checker Id", new String[] { UtilityClass.getDatafromPropertyFile("CheckerId"),
				UtilityClass.getDatafromPropertyFile("CheckerId"), UtilityClass.getDatafromPropertyFile("CheckerId"),
				UtilityClass.getDatafromPropertyFile("InvalidCheckerID_BulkBeneficiary_row4"), });

		columnDataMap.put("Req Mode *", new String[] { UtilityClass.getDatafromPropertyFile("ReqMode"), "",
				UtilityClass.getDatafromPropertyFile("ReqMode"), UtilityClass.getDatafromPropertyFile("ReqMode"),
				UtilityClass.getDatafromPropertyFile("ReqMode") });

		columnDataMap.put("Ben Code *", new String[] { BeneCode_row2, BeneCode_row3, BeneCode_row5, BeneCode_row6 });

		columnDataMap.put("Ben Name *", new String[] { UtilityClass.getDatafromPropertyFile("BenName"),
				UtilityClass.getDatafromPropertyFile("BenName"), UtilityClass.getDatafromPropertyFile("BenName"), "",
				UtilityClass.getDatafromPropertyFile("BenName") });

		columnDataMap.put("Ben IFSC *",
				new String[] { UtilityClass.getDatafromPropertyFile("InvalidBen_IFSC_BulkBeneficiary_row2"),
						UtilityClass.getDatafromPropertyFile("BenIFSC"),
						UtilityClass.getDatafromPropertyFile("BenIFSC"), "",
						UtilityClass.getDatafromPropertyFile("BenIFSC") });

		columnDataMap.put("Account No*",
				new String[] { getAccountNo(), InvalidAccountNo_row3, getAccountNo_Row4(), "", AccountNo_row6 });

		columnDataMap.put("Ben Email *",
				new String[] { UtilityClass.getDatafromPropertyFile("BenEmail"), "",
						UtilityClass.getDatafromPropertyFile("BenEmail"),
						UtilityClass.getDatafromPropertyFile("InvalidBenEmail_bulkbeneficiary_row3"),
						UtilityClass.getDatafromPropertyFile("InvalidBenEmail_bulkbeneficiary_row3") });

		columnDataMap.put("Ben Mobile *",
				new String[] { UtilityClass.getDatafromPropertyFile("BenMobile"), "",
						UtilityClass.getDatafromPropertyFile("BenMobile"),
						UtilityClass.getDatafromPropertyFile("InvalidBenMobileNo_bulkbeneficiary_row3"),
						UtilityClass.getDatafromPropertyFile("InvalidBenMobileNo_bulkbeneficiary_row3") });

		columnDataMap.put("Remarks", new String[] { UtilityClass.getDatafromPropertyFile("Remarks"), "",
				UtilityClass.getDatafromPropertyFile("Remarks"), UtilityClass.getDatafromPropertyFile("Remarks"),
				UtilityClass.getDatafromPropertyFile("Remarks") });

		columnDataMap.put("Txn Type *", new String[] { UtilityClass.getDatafromPropertyFile("TxnType"), "",
				UtilityClass.getDatafromPropertyFile("TxnType"), UtilityClass.getDatafromPropertyFile("TxnType"),
				UtilityClass.getDatafromPropertyFile("TxnType") });

		// Iterate through each column name and data ..
		for (Map.Entry<String, String[]> entry : columnDataMap.entrySet()) {
			String columnName = entry.getKey();
			String[] data = entry.getValue();

			// Validate if the column exists in the first row....
			Row headerRow = sheet.getRow(0);
			int columnIndex = -1;
			Iterator<Cell> cellIterator = headerRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getStringCellValue().equals(columnName)) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}

			// If column exists, insert data into respective cells....
			if (columnIndex != -1) {
				for (int i = 0; i < data.length; i++) {
					Row row = sheet.getRow(i + 1); // Start from the second row
					if (row == null) {
						row = sheet.createRow(i + 1);
					}
					Cell cell = row.createCell(columnIndex);
					cell.setCellValue(data[i]);
				}
			} else {
				System.out.println("Column '" + columnName + "' not found.");
			}
		}

		// Save changes to Excel file
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	// ** enter remark **//

	public void EnterRemark() throws InterruptedException {
		// Enter remark
		Thread.sleep(600);
		EnterRemark.sendKeys(remark);
		System.out.println("remark : " + remark);
	}

	// ** click on confirm button **//

	public void ClickOnConfirmButton() throws InterruptedException {
		// click on confirm button
		Thread.sleep(600);
		ClickOnConfirmButton.click();

		Thread.sleep(600);

		System.out.println("File Uploaded Successfully..");

	}

	public void Check_InvalidStatus() throws Exception {
		try {
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			System.out.println(remark);
			// Get the page source
			String pageSource = driver.getPageSource();

			// Check if the desired string is present
			boolean isPresent = pageSource.contains(remark);

			// Assert that the string is present on the page
			Assert.assertTrue(isPresent, "" + remark + "' is present on the page.");

			// check Initiated status
			WebElement Invalid_status = driver.findElement(
					By.xpath("//td[text()='" + remark + "']/following-sibling::td/button[text()=' Invalid ']"));

			if (Invalid_status.isDisplayed()) {

				System.out.println("Invalid Status is displayed on screen");

				WebElement ClickOnInValidRecord = driver
						.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'" + remark
								+ "')]/td[contains(text(), '') and @style][2]"));
				ClickOnInValidRecord.click();

				Thread.sleep(1000);

			} else {

				Assert.fail("number of Invalid record field is not clickable");

			}

		} catch (Exception e) {
			System.err.println(e);
			System.out.println("NegativeScenarios_BulkBeneficiary.Check_InvalidStatus()");
		}
	}

	// ** check invalid records ** //

	// check invalid record reason row2 //

	public void verify_InvladiRecords_BulkBeneficiary_Row2() throws Exception {

		try {
			Thread.sleep(1000);

			// Check if the desired string is present

			WebElement row2_RejectionReason = driver.findElement(By.xpath("//td[text()='"
					+ UtilityClass.getDatafromPropertyFile("InvalidCustomerID_BulkBeneficiary_row2")
					+ "']/following-sibling::td/button[@class='btn btn-sm down-redStatus']/ancestor::tr//td[@class=\"makeShortReason\"]"));

			Assert.assertTrue(row2_RejectionReason.isDisplayed(), "row2_RejectionReason is not clickable");

			row2_RejectionReason.click();
			Thread.sleep(1000);

			WebElement row2_Rejection_ActualReason = driver.findElement(By.xpath("//p[contains(text(),'"
					+ UtilityClass.getDatafromPropertyFile("row2_Rejection_ExpectedReason") + "')]"));

			String row2_Rejection_ActualReason_String = row2_Rejection_ActualReason.getText();
			
			System.out.println(row2_Rejection_ActualReason_String + " row2_Rejection_ActualReason_String");

			String row2_Rejection_expectedReason = UtilityClass
					.getDatafromPropertyFile("row2_Rejection_ExpectedReason");

			Assert.assertEquals(row2_Rejection_ActualReason_String, row2_Rejection_expectedReason,
					"row 2 Rejection reason does not match");

			// click on cancel button
			Thread.sleep(300);
			CancelButton_row2.click();
//			System.out.println("2");
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("NegativeScenarios_BulkBeneficiary.verify_InvladiRecords_BulkBeneficiary_row2()");
		}
	}

	// Check invalid record reason row3

	public void verify_InvladiRecords_BulkBeneficiary_Row3() throws Exception {

		Thread.sleep(1500);
		// Check if the desired string is present

		WebElement row3_RejectionReason = driver.findElement(By.xpath("//td[text()='" + InvalidAccountNo_row3
				+ "']/following-sibling::td/button[@class='btn btn-sm down-redStatus']/ancestor::tr//td[@class=\"makeShortReason\"]"));

		Assert.assertTrue(row3_RejectionReason.isDisplayed(), "row3_RejectionReason is not clickable");

		Thread.sleep(1000);

		row3_RejectionReason.click();
		Thread.sleep(1000);

		WebElement row3_Rejection_ActualReason = driver.findElement(By.xpath("//p[contains(text(),'"
				+ UtilityClass.getDatafromPropertyFile("row3_Rejection_ExpectedReason") + "')]"));

		String row3_Rejection_ActualReason_String = row3_Rejection_ActualReason.getText();
		System.out.println(row3_Rejection_ActualReason_String + "row3_Rejection_ActualReason_String");

		String row3_Rejection_expectedReason = UtilityClass.getDatafromPropertyFile("row3_Rejection_ExpectedReason");

		Assert.assertEquals(row3_Rejection_ActualReason_String, row3_Rejection_expectedReason,
				"row 3 Rejection reason does not match");

		// click on cancel button
		Thread.sleep(300);
		CancelButton_row3.click();
		System.out.println("3");

	}

	// Check invalid record reason row 4

	public void verify_InvladiRecords_BulkBeneficiary_Row4() throws Exception {
		Thread.sleep(1000);

		// Check if the desired string is present

		WebElement row4_RejectionReason = driver.findElement(
				By.xpath("//td[text()='" + CustomerRefNo_row4 + "']/ancestor::tr//td[@class=\"makeShortReason\"]"));

		Assert.assertTrue(row4_RejectionReason.isDisplayed(), "row4_RejectionReason is not clickable");

		Thread.sleep(1000);

		row4_RejectionReason.click();

		Thread.sleep(1000);
		System.out.println(UtilityClass.getDatafromPropertyFile("row4_Rejection_ExpectedReason" + "sak"));
		WebElement row4_Rejection_ActualReason = driver.findElement(By.xpath("//p[contains(text(),'"
				+ UtilityClass.getDatafromPropertyFile("row4_Rejection_ExpectedReason") + "')]"));

		String row4_Rejection_ActualReason_String = row4_Rejection_ActualReason.getText();
		System.out.println(row4_Rejection_ActualReason_String + " row4_Rejection_ActualReason_String");

		String row4_Rejection_expectedReason = UtilityClass.getDatafromPropertyFile("row4_Rejection_ExpectedReason");

		Assert.assertEquals(row4_Rejection_ActualReason_String, row4_Rejection_expectedReason,
				"row 4 Rejection reason does not match");

		// click on cancel button
		Thread.sleep(300);
		CancelButton_row4.click();
		System.out.println("4");

	}

	// Check invalid record reason row 5

	public void verify_InvladiRecords_BulkBeneficiary_Row5() throws Exception {
		Thread.sleep(1000);

		// Check if the desired string is present

		WebElement row5_RejectionReason = driver.findElement(
				By.xpath("//td[text()='" + CustomerRefNo_row5 + "']/ancestor::tr//td[@class=\"makeShortReason\"]"));

		Assert.assertTrue(row5_RejectionReason.isDisplayed(), "row5_RejectionReason is not clickable");

		Thread.sleep(1000);

		row5_RejectionReason.click();
		Thread.sleep(1000);

		WebElement row5_Rejection_ActualReason = driver.findElement(By.xpath("//p[contains(text(),'"
				+ UtilityClass.getDatafromPropertyFile("row5_Rejection_ExpectedReason") + "')]"));

		String row5_Rejection_ActualReason_String = row5_Rejection_ActualReason.getText();

		System.out.println(row5_Rejection_ActualReason_String + "row5_Rejection_ActualReason_String");

		String row5_Rejection_expectedReason = UtilityClass.getDatafromPropertyFile("row5_Rejection_ExpectedReason");

		Assert.assertEquals(row5_Rejection_ActualReason_String, row5_Rejection_expectedReason,
				"row 5 Rejection reason does not match");

		// click on cancel button
		Thread.sleep(300);
		CancelButton_row5.click();
		System.out.println("5");

	}
	// Check invalid record reason row 6

	public void verify_InvladiRecords_BulkBeneficiary_Row6() throws Exception {
		Thread.sleep(1000);

		Actions action = new Actions(driver);

		action.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(500);

		// Check if the desired string is present

		WebElement row6_RejectionReason = driver.findElement(
				By.xpath("//td[text()='" + AccountNo_row6 + "']/ancestor::tr//td[@class=\"makeShortReason\"]"));

		Assert.assertTrue(row6_RejectionReason.isDisplayed(), "row6_RejectionReason is not clickable");

		Thread.sleep(1000);

		row6_RejectionReason.click();
		Thread.sleep(1000);

		WebElement row6_Rejection_ActualReason = driver.findElement(By.xpath("//p[contains(text(),'"
				+ UtilityClass.getDatafromPropertyFile("row6_Rejection_ExpectedReason") + "')]"));

		String row6_Rejection_ActualReason_String = row6_Rejection_ActualReason.getText();
		System.out.println(row6_Rejection_ActualReason_String + " row6_Rejection_ActualReason_String");

		String row6_Rejection_expectedReason = UtilityClass.getDatafromPropertyFile("row6_Rejection_ExpectedReason");

		Assert.assertEquals(row6_Rejection_ActualReason_String, row6_Rejection_expectedReason,
				" row 6 Rejection reason does not match");

		// click on cancel button
		Thread.sleep(300);
		CancelButton_row6.click();
		System.out.println("6");
		Thread.sleep(300);

	}

}
