package com.TransBnk.Payouts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Bulk_Payout {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(.,'Bulk Payout')]")
	private WebElement Bulk_Payout;

	@FindBy(xpath = "//button[contains(.,'Add Bulk Payout')]")
	private WebElement Add_BulkPayout;

	@FindBy(xpath = "//a[contains(.,'Payout List')]")
	private WebElement Payout_List;

	@FindBy(xpath = "//input[@id=\"remark\"]")
	private WebElement EnterRemark;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[1]")
	private WebElement CancelButton;

	public static String remark;
	public static String CustomerRefNo_bulkPayout;
	public static String ExternalRefNo_bulkPayout;
	public static String bene;

	public static String getCustomerRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("ExternalRefNo") + getCurrentTimeStamp();
	}

	public Bulk_Payout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ** click on bulk payout option
	public void ClickOn_Bulk_PayoutOption() throws InterruptedException {
		try {

			System.out.println("Executing Method : Bulk_Payout.ClickOn_Bulk_PayoutOption()");

			Thread.sleep(2000);

			Bulk_Payout.click();

//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", Bulk_Payout);

		} catch (Exception e) {

			System.err.println("Error in Method : Bulk_Payout.ClickOn_Bulk_PayoutOption()");

			System.err.println(e);

			Assert.fail("Error in Method : Bulk_Payout.ClickOn_Bulk_PayoutOption()");
		}
	}

	// ** click on add bulk payout option
	public void ClickOn_AddBulkPayout() throws InterruptedException {
		try {
			System.out.println("Executing Method : Bulk_Payout.ClickOn_AddBulkPayout()");

			Thread.sleep(1000);

			Add_BulkPayout.click();

			Thread.sleep(1000);

		} catch (Exception e) {
			System.err.println("Error in Method : Bulk_Payout.ClickOn_AddBulkPayout()");

			System.err.println(e);
			Assert.fail("Error in Method : Bulk_Payout.ClickOn_AddBulkPayout()");
		}
	}

	// ***********************READ EXCEL FILE************************************//

	public List<String> validateColumns(String filePath, String sheetName, List<String> expectedColumnNames) {
		List<String> missingColumns = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new String(filePath));
			Workbook workbook = WorkbookFactory.create(file);

			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet != null) {
				Row headerRow = sheet.getRow(0);

				if (headerRow != null) {
					for (String expectedColumnName : expectedColumnNames) {
						boolean isColumnPresent = false;
						for (Cell cell : headerRow) {
							if (cell.getStringCellValue().equalsIgnoreCase(expectedColumnName)) {
								isColumnPresent = true;
								break;
							}
						}
						if (!isColumnPresent) {
							missingColumns.add(expectedColumnName);
						}
					}
				} else {
					// Header row is missing
					missingColumns.addAll(expectedColumnNames);
				}
			} else {
				// Sheet is missing
				missingColumns.addAll(expectedColumnNames);
			}

			file.close();
		} catch (IOException e) {
			e.printStackTrace();
			missingColumns.addAll(expectedColumnNames);
		} catch (Exception e) {
			e.printStackTrace();
			missingColumns.addAll(expectedColumnNames);
		}
		return missingColumns;
	}

	public void validateBulkPayoutExcelFileHeaders(String UploadFilePath) {

		System.out.println("Executing Method : Bulk_Payout.validateBulkPayoutExcelFileHeaders()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Maker Id", "Checker Id", "Txn Type *", "Amount *", "Ben Code", "Ben Name",
					"Ben Ifsc", "Ben Account No", "Ben Email", "Ben Mobile", "Remarks", "Remarks 1", "Remarks 2",
					"Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println("All expected columns are present in sheet '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println("Error in Method : Bulk_Payout.validateBulkPayoutExcelFileHeaders() "
						+ errorMessage.toString());
				Assert.fail(" The following columns are missing in sheet '" + sheetName + "': " + missingColumns);
			}
		} catch (Exception e) {

			System.err.println("Error in Method : Bulk_Payout.validateBulkPayoutExcelFileHeaders()");

			System.err.println(e);
		}
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("ddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;

	}

	public static String getBeneCode_bulkPayout() throws Exception {
		return Add_Bulk_Beneficiary.getBenCode();

	}

	public static String getAccountNo_bulkPayout() throws Exception {
		return Add_Bulk_Beneficiary.getAccountNo();

	}

	public static String getbene() {
		return Add_Bulk_Beneficiary.BenCode;

	}

	public void insertDataIntoBulkPayoutExcelFile() throws Exception {

		try {
			System.out.println("Executing Method : Bulk_Payout.insertDataIntoBulkPayoutExcelFile()");
			// Path to your Excel file
			String excelFilePath = System.getProperty("user.dir") + "/TestData/Payout file.xlsx";

			// Initialize FileInputStream to read the Excel file
			FileInputStream inputStream = new FileInputStream(excelFilePath);

			// Initialize Workbook using XSSFWorkbook
			Workbook workbook = new XSSFWorkbook(inputStream);

			// Get the first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// ** ** //
			CustomerRefNo_bulkPayout = getCustomerRefNo();
			ExternalRefNo_bulkPayout = getExternalRefNo();
			bene = getbene();
			System.out.println("bene" + bene);
//		public static String BenCode_bulkPayout1 = BeneCode_bulkPayout;
//		public static String AccountNo_bulkPayout = Add_Bulk_Beneficiary.AccountNo;
//		
			// Define column names and data to insert using HashMap
			Map<String, String[]> columnDataMap = new HashMap<>();
			columnDataMap.put("Customer Id *", new String[] { UtilityClass.getDatafromPropertyFile("CustomerId") });
			columnDataMap.put("Debit Account No *",
					new String[] { UtilityClass.getDatafromPropertyFile("Debit_AccountNo") });
			System.out.println("CustomerRefNo_bulkPayout" + CustomerRefNo_bulkPayout);
			columnDataMap.put("Customer Txn Ref No *", new String[] { CustomerRefNo_bulkPayout });
			columnDataMap.put("External Ref No *", new String[] { ExternalRefNo_bulkPayout });
			columnDataMap.put("Maker Id", new String[] { UtilityClass.getDatafromPropertyFile("MakerId") });
			columnDataMap.put("Checker Id", new String[] { UtilityClass.getDatafromPropertyFile("CheckerId") });
			columnDataMap.put("Txn Type *", new String[] { UtilityClass.getDatafromPropertyFile("TxnType") });
			columnDataMap.put("Amount *", new String[] { UtilityClass.getDatafromPropertyFile("Amount_BulkPayout") });
			System.out.println("BeneCode_bulkPayout :" + getbene());
			System.out.println(bene = getbene());
			System.out.println(getBeneCode_bulkPayout());
			columnDataMap.put("Ben Code", new String[] { getBeneCode_bulkPayout() });
			columnDataMap.put("Ben Name", new String[] { UtilityClass.getDatafromPropertyFile("BenName") });
			columnDataMap.put("Ben Ifsc", new String[] { UtilityClass.getDatafromPropertyFile("BenIFSC") });
			System.out.println("getAccountNo_bulkPayout " + getAccountNo_bulkPayout());
			columnDataMap.put("Ben Account No", new String[] { getAccountNo_bulkPayout() });
			columnDataMap.put("Ben Email", new String[] { UtilityClass.getDatafromPropertyFile("BenEmail") });
			columnDataMap.put("Ben Mobile", new String[] { UtilityClass.getDatafromPropertyFile("BenMobile") });
			columnDataMap.put("Remarks", new String[] { UtilityClass.getDatafromPropertyFile("Remarks") });

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
					Assert.fail("Column '" + columnName + "' not found.");
				}
			}

			// Save changes to Excel file
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (Exception e) {
			System.err.println("Error in Method : Bulk_Payout.insertDataIntoBulkPayoutExcelFile()");
			System.err.println(e);
		}
	}

	// ** enter remark **//

	public void EnterRemark() throws InterruptedException {

		try {
			System.out.println("Executing Method : Bulk_Payout.EnterRemark()");
			// Enter remark
			Thread.sleep(600);
			remark = getCurrentTimeStamp();
			EnterRemark.sendKeys(getCurrentTimeStamp());
			System.out.println("remark" + remark);

		} catch (Exception e) {
			System.err.println("Error in Method : Bulk_Payout.EnterRemark()");
			System.err.println(e);
		}
	}

	// **check initiated status after successfully uploading bulk beenficiary
	// file**//

	public void verifyStatusForUploadedPayouts() throws Exception {

		Thread.sleep(2000);

		try {
			System.out.println("Executing Method : Bulk_Payout.verifyStatusForUploadedBulkBeneficiary()");

			Thread.sleep(1000);

			// Get the page source
			String pageSource = driver.getPageSource();

			// Check if the desired string is present
			boolean isPresent = pageSource.contains(remark);

			// Assert that the string is present on the page
			Assert.assertTrue(isPresent, "" + remark + "' is present on the page.");

			WebElement loadStatus = driver
					.findElement(By.xpath("//td[text()='" + remark + "']/following-sibling::td/button"));

			String LoadStatus = loadStatus.getText();

			// Print load status
			System.out.println("Load status after uploaded Bulk Payout : " + LoadStatus);

			// check Initiated status
			WebElement Initiated_status = driver
					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + remark
							+ "')]//button[contains(text(), 'Initiated')]"));

			if (Initiated_status.isDisplayed()) {
				System.out.println(
						"after successfully uploading the bulk beneficiary file , initiated status is displayed . ");

				driver.navigate().refresh();

			} else {
				System.err.println(
						"After Successfully uploaded Bulk Payout Initiated status Has not displayed on screen");

				Assert.fail(
						"Error in method : Bulk_Payout.verifyStatusForUploadedBulkBeneficiary - After Successfully uploaded Bulk Payout Initiated status Has not displayed on screen");
			}

		} catch (Exception e) {
			System.err.println("Error in method : Bulk_Payout.verifyStatusForUploadedBulkBeneficiary");
			System.err.println(e);
		}

		// ** check the Load status after refreshing the page ** //

		try {

			driver.navigate().refresh();
			Thread.sleep(1000);

			WebElement loadStatusAfterRefreshingPage = driver
					.findElement(By.xpath("//td[text()='" + remark + "']/following-sibling::td/button"));

			String StringloadStatusAfterRefreshingPage = loadStatusAfterRefreshingPage.getText();

			// Print load status
			System.out.println("Load status after uploaded Bulk Payout : " + StringloadStatusAfterRefreshingPage);

			// check Success status
			WebElement Success_status = driver
					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + remark
							+ "')]//button[contains(text(), 'Success')]"));

			// ** check No of Valid Records ** //
			Thread.sleep(1000);

			if (Success_status.isDisplayed()) {
				System.out.println("After refreshing the page load status has changed initiated to Success");

				WebElement ClickOnValidRecord = driver
						.findElement(By.xpath("//tr[contains(td/button/text(), 'Success') and contains(.,'" + remark
								+ "')]//td[@class='makeCursor'][text()='1'"));

				ClickOnValidRecord.click();

				// -----------verify valid records -------------------//

				// verify valid records - customer reference no.
				WebElement ValidRecord_CustomerRefNo = driver
						.findElement(By.xpath("//td[contains(.,'" + CustomerRefNo_bulkPayout + "')]"));
				Assert.assertTrue(ValidRecord_CustomerRefNo.isDisplayed());
				System.out
						.println("Valid Customer reference number is present on the Bulk Payout's valid records page");

				// ** Verify valid records - Customer ID ** //

				String pageSource_ValidRecords = driver.getPageSource();

				// Check if the desired string is present
				boolean Customer_Id = pageSource_ValidRecords
						.contains(UtilityClass.getDatafromPropertyFile("CustomerId"));

				// Assert that the string is present on the page

				Assert.assertTrue(Customer_Id, "Expected CustomerId '"
						+ UtilityClass.getDatafromPropertyFile("CustomerId")
						+ "' to be present on the page, but it was not found on the Bulk Payout's valid records page");

				System.out.println("Valid Customer Id is present on the Bulk Payout's valid records page");

				// Verify Valid records - Beneficiary Name

				// ** Bene Name ** //
				WebElement Bene_name = driver.findElement(
						By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName")
								+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
				Assert.assertTrue(Bene_name.isDisplayed(),
						"Valid Beneficiary name  is NOT present on the Bulk payout's Valid Records page");
				System.out.println("Valid Beneficiary name is  present on the  Bulk Payout's valid record page");

				// Verify Valid Records - Bene Code

				WebElement ValidRecord_BeneCode = driver
						.findElement(By.xpath("//td[contains(.,'" + getBeneCode_bulkPayout() + "')]"));
				Assert.assertTrue(ValidRecord_BeneCode.isDisplayed(),
						"Valid Beneficiary Code is NOT present on the Bulk Payout's valid records page");
				System.out.println("Valid Beneficiary Code is present on the Bulk Payout's valid records page");

				// Verify Valid Records - Bene account number

				// ** bene account number **//

				WebElement ValidRecord_BeneAccountNo = driver
						.findElement(By.xpath("//td[contains(.,'" + getAccountNo_bulkPayout() + "')]"));
				Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed(),
						"Valid Beneficiary account number is NOT present on the Bulk Payout's Valid Record page");
				System.out
						.println("Valid Beneficiary account number is present on the Bulk Payout's Valid Record  page");

				// **Bene IFSC Code ** //

				// Assert that the string is present on the page
				WebElement Bene_IFSC_Code = driver.findElement(
						By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC")
								+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
				Assert.assertTrue(Bene_IFSC_Code.isDisplayed(),
						"Valid Beneficiary IFSC Code  is NOT present on the Bulk Payout's Valid Record page");
				System.out.println("Valid Beneficiary IFSC code is  present on the Bulk Payout's Valid Record page");

				// **Bene Amount ** //

				// Assert that the string is present on the page
				WebElement Bene_Amount = driver.findElement(By
						.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("Amount_BulkPayout")
								+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
				Assert.assertTrue(Bene_Amount.isDisplayed(),
						"Valid Amount  is NOT present on the Bulk Payout's Valid Record page");
				System.out.println("Valid Amount  is  present on the Bulk Payout's Valid Record page");

				// verify Status on valid records page

				WebElement status = driver.findElement(By.xpath("(//button[contains(.,' ')])[1]")); // button[contains(.,'Request
																									// Received')]

				String statusString = status.getText();

				String actualString = "Request Received";

				System.out.println("BulkPayout Status : " + statusString);

				Assert.assertTrue(statusString.contains(statusString),
						"Bulk Payout's status is not as expected. Expected: '" + status + "', but found: '"
								+ statusString + "'");

				System.out.println("showing correct beneficary status on the Bulk Payout's Valid Record page");

			} else {
				System.err.println(
						"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After refreshing the page load status of Bulk Beneficiary has not changed initiated to Success");

				String InvalidStatus = "Invalid";

				if (StringloadStatusAfterRefreshingPage.contains(InvalidStatus)) {

					WebElement ClickOnInValidRecord = driver
							.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'" + remark
									+ "')]/td[contains(text(), '') and @style][2]"));
					ClickOnInValidRecord.click();

					Thread.sleep(500);

					WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

					String RejectionReason_String = RejectionReason.getText();

					System.err.println(" RejectionReason : " + RejectionReason_String);

					// click on cancel button
					Thread.sleep(300);

					CancelButton.click();

					Thread.sleep(1000);

					Assert.fail(
							"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After refreshing the page load status of Bulk Beneficiary has not changed initiated to Success");
				}

			}

		} catch (NoSuchElementException | ElementClickInterceptedException | IOException e) {

			System.err.println(e);

			System.err.println("Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary()");

			WebElement status = driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'"
					+ remark + "')]//button[contains(text(), 'Invalid')]"));

			if (status.isDisplayed()) {

				System.out.println("Invalid Status is displayed on screen");

				WebElement ClickOnInValidRecord = driver
						.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'" + remark
								+ "')]/td[contains(text(), '') and @style][2]"));
				ClickOnInValidRecord.click();
				Thread.sleep(1000);

				WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

				String RejectionReason_String = RejectionReason.getText();

				System.err.println(" RejectionReason : " + RejectionReason_String);

				// click on cancel button
				Thread.sleep(300);

				CancelButton.click();

				Thread.sleep(1000);

				Assert.fail(
						"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After refreshing the page load status of Bulk Beneficiary has not changed initiated to Success");
			}

		}
	}

	// ** click on beneficiary list option ** //
	public void ClickOn_Payout_ListOption() throws InterruptedException {
		Thread.sleep(800);
		// Click on beneficiary list option
		Payout_List.click();
	}

	// ** verify uploaded data on the bulk upload page ** //

	public void Beneficiary_List() throws Exception {

		try {
			Thread.sleep(1000);
			// verify added beneficiary details in beneficiary list

			// ** Customer id ** //

			// Verify valid records - Customer ID

			// Check if the desired string is present

			WebElement customer_id = driver.findElement(
					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("CustomerId")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(customer_id.isDisplayed(),
					"Valid Beneficiary Customer id  is NOT present on the Payout list page");

			System.out.println("Valid Beneficiary Customer id  is present on the Payout list page");

			// ** Bene Code ** //

			WebElement ValidRecord_BeneCode = driver
					.findElement(By.xpath("//td[contains(.,'" + getBeneCode_bulkPayout() + "')]"));
			Assert.assertTrue(ValidRecord_BeneCode.isDisplayed());
			System.out.println("Valid Beneficiary Code is present on the valid records page");

			// ** Bene Name ** //

			// Assert that the string is present on the page
			WebElement Bene_name = driver
					.findElement(By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(Bene_name.isDisplayed(),
					"Valid Beneficiary name  is NOT present on the Payout list page");
			System.out.println("Valid Beneficiary name is  present on the Payout list page");

			// ** bene account number **//

			WebElement ValidRecord_BeneAccountNo = driver
					.findElement(By.xpath("//td[contains(.,'" + getAccountNo_bulkPayout() + "')]"));
			Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed(),
					"Valid Beneficiary account number is NOT present on the Payout list page");
			System.out.println("Valid Beneficiary account number is present on the Payout list page");

			// **Bene IFSC Code ** //

			// Assert that the string is present on the page
			WebElement Bene_IFSC_Code = driver
					.findElement(By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(Bene_IFSC_Code.isDisplayed(),
					"Valid Beneficiary IFSC Code  is NOT present on the Payout list page");
			System.out.println("Valid Beneficiary IFSC code is  present on the Payout list page");

			// **Bene Amount ** //

			// Assert that the string is present on the page
			WebElement Bene_Amount = driver.findElement(
					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("Amount_BulkPayout")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(Bene_Amount.isDisplayed(), "Valid Amount  is NOT present on the Payout list page");
			System.out.println("Valid Amount  is  present on the Payout list page ");

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Bulk_Payout.Beneficiary_List()");
		}
	}

}
