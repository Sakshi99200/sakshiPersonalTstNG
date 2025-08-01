
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Add_Bulk_Beneficiary {
	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"PAYOUTS\"]")
	private WebElement Payouts;

	@FindBy(xpath = "//a[contains(.,'Bulk Beneficiary')]")
	private WebElement Bulk_Beneficiary;

	@FindBy(xpath = "//button[contains(.,'Add Bulk Beneficiary')]")
	private WebElement Add_Bulk_Beneficiary_Button;

	@FindBy(xpath = "//button[contains(.,'Upload')]")
	private WebElement UploadBUtton;

	@FindBy(xpath = "//input[@id=\"fileUpload\"]")
	private WebElement ClickOn_UploadBulkBeneficiaryFile;

	@FindBy(xpath = "//*[@id=\"toast-container\" and contains(.,'No Data For Upload')]/div/div")
	private WebElement ErrorValidationForUploading_BlankFile;

	@FindBy(xpath = "//button[contains(.,' Cancel ')]")
	private WebElement ClickOn_CloseOption;

	@FindBy(xpath = "//select[@id=\"bank\"]")
	private WebElement BankDropDown;

	@FindBy(xpath = "//input[@id=\"remark\"]")
	private WebElement EnterRemark;

	@FindBy(xpath = "//button[contains(.,' Confirm ')]")
	private WebElement ClickOnConfirmButton;

	@FindBy(xpath = "//a[contains(.,'Beneficiary List')]")
	private WebElement Beneficiary_list;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[1]")
	private WebElement CancelButton;

	public static String remark;
	public static String CustomerRefNo;
	public static String ExternalRefNo;
	public static String BenCode;
	public static String AccountNo;

	public Add_Bulk_Beneficiary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on payout option
	public void ClickOn_PayoutsService() throws InterruptedException {
		try {

			System.out.println("Executing Method : ClickOn_PayoutsService()");
			Thread.sleep(1000);

			Payouts.click();

		} catch (Exception e) {
			System.err.println("Error in Method : ClickOn_PayoutsService()");
			System.err.println(e);
		}
	}

	// click on bulk beneficiary option
	public void ClickOn_Bulk_BeneficiaryOption() throws InterruptedException {
		try {

			System.out.println("Executing Method : Add_Bulk_Beneficiary.ClickOn_Bulk_BeneficiaryOption()");
			Thread.sleep(500);
			Bulk_Beneficiary.click();

		} catch (Exception e) {
			System.err.println("Error in Method : Add_Bulk_Beneficiary.ClickOn_Bulk_BeneficiaryOption()");
			System.err.println(e);
		}

	}

	// click on add bulk beneficiary button
	public void ClickOn_Add_Bulk_Beneficiary_Button() throws InterruptedException {

		try {

			System.out.println("Executing Method : Add_Bulk_Beneficiary.ClickOn_Add_Bulk_Beneficiary_Button()");
			Thread.sleep(700);
			Add_Bulk_Beneficiary_Button.click();
		} catch (Exception e) {
			System.err.println("Error in Method : Add_Bulk_Beneficiary.ClickOn_Add_Bulk_Beneficiary_Button()");
			System.err.println(e);
		}
	}

	// ** upload blank file **//
	public void Upload_File(String ExcelFile) throws InterruptedException {

		try {

			System.out.println("Executing Method : .Upload_File()");
			Thread.sleep(500);

			// click on choose file to upload blank file
			ClickOn_UploadBulkBeneficiaryFile.sendKeys(ExcelFile);

		} catch (Exception e) {
			System.err.println("Error in Method : Upload_File()");
			System.err.println(e);
		}
	}

	// checking error validation message for uploading blank file

	public void Check_ErrorValidationForUploading_BlankFile() {
		try {

			System.out.println("Executing Method : Add_Bulk_Beneficiary.Check_ErrorValidationForUploading_BlankFile()");

			// checking error validation message for uploading blank file
			String String_ErrorValidationForUploading_BlankFile = ErrorValidationForUploading_BlankFile.getText();

			Assert.assertTrue(ErrorValidationForUploading_BlankFile.isDisplayed());

			System.out.println("Error validation message is displayed after uploading bulk Beneficiary blank file  "
					+ String_ErrorValidationForUploading_BlankFile);

		} catch (Exception e) {
			System.err.println("Error in Method : Add_Bulk_Beneficiary.Check_ErrorValidationForUploading_BlankFile()");
			System.err.println(e);
		}
	}

	// Click on X button to close screen

	public void ClickOn_CancelButton() throws InterruptedException {

		try {
			System.out.println("Executing method : Add_Bulk_Beneficiary.ClickOn_CancelButton()");
			Thread.sleep(500);

			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN);

			// Click on Close Option
			ClickOn_CloseOption.click();
		} catch (Exception e) {
			System.err.println("Error in Method : ClickOn_CancelButton()");
			System.err.println(e);
		}
	}

	// **************************READ EXCEL FILE*********************************//

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

	public void validateBeneficiaryExcelFileHeaders(String UploadFilePath) {
		System.out.println("Executing Method : Add_Bulk_Beneficiary.validateBeneficiaryExcelFileHeaders()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Beneficiary Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Customer Ref No *", "External Ref No *",
					"Maker Id", "Checker Id", "Req Mode *", "Ben Code *", "Ben Name *", "Ben IFSC *", "Account No*",
					"Ben Email *", "Ben Mobile *", "Remarks", "Txn Type *");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {

				System.out.println("All expected columns are present in sheet '" + sheetName + "'.");

			} else {

				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");

				for (String columnName : missingColumns) {

					errorMessage.append("- ").append(columnName).append("\n");
				}

				System.err.println("Error in Method : Add_Bulk_Beneficiary.validateBeneficiaryExcelFileHeaders() "
						+ errorMessage.toString());
				Assert.fail(" The following columns are missing in sheet '" + sheetName + "': " + missingColumns);
			}
		} catch (Exception e) {

			System.err.println("Error in Method : Add_Bulk_Beneficiary.validateBeneficiaryExcelFileHeaders()");

			System.err.println(e);
		}
	}

	// store dynamic value in methos
	public static String getremark() {

		return getCurrentTimeStamp();
	}

	public static String getAccountNo() throws Exception {

		return UtilityClass.getDatafromPropertyFile("AccountNo") + getCurrentTimeStamp();

	}

	public static String getCustomerRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("ExternalRefNo") + getCurrentTimeStamp();
	}

	public static String getBenCode() throws Exception {
		return UtilityClass.getDatafromPropertyFile("BenCode") + getCurrentTimeStamp();
	}

	public void insertDataIntoBulkBeneficiaryExcelFile() throws Exception {

		try {
			System.out.println("Executing Method : Add_Bulk_Beneficiary.insertDataIntoBulkBeneficiaryExcelFile()");

			// Path to your Excel file
			String excelFilePath = System.getProperty("user.dir") + "/TestData/Beneficiary file.xlsx";

			// Initialize FileInputStream to read the Excel file
			FileInputStream inputStream = new FileInputStream(excelFilePath);

			// Initialize Workbook using XSSFWorkbook
			Workbook workbook = new XSSFWorkbook(inputStream);

			// Get the first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// ** ** //

			CustomerRefNo = getCustomerRefNo();

			ExternalRefNo = getExternalRefNo();

			BenCode = getBenCode();
			System.out.println(getBenCode() + " : BenCode");

			AccountNo = getAccountNo();

			remark = getremark();

			// Define column names and data to insert using HashMap
			Map<String, String[]> columnDataMap = new HashMap<>();
			columnDataMap.put("Customer Id *", new String[] { UtilityClass.getDatafromPropertyFile("CustomerId") });
			columnDataMap.put("Customer Ref No *", new String[] { getCustomerRefNo() });
			columnDataMap.put("External Ref No *", new String[] { getExternalRefNo() });
			columnDataMap.put("Maker Id", new String[] { UtilityClass.getDatafromPropertyFile("MakerId") });
			columnDataMap.put("Checker Id", new String[] { UtilityClass.getDatafromPropertyFile("CheckerId") });
			columnDataMap.put("Req Mode *", new String[] { UtilityClass.getDatafromPropertyFile("ReqMode") });
			columnDataMap.put("Ben Code *", new String[] { getBenCode() });
			columnDataMap.put("Ben Name *", new String[] { UtilityClass.getDatafromPropertyFile("BenName") });
			columnDataMap.put("Ben IFSC *", new String[] { UtilityClass.getDatafromPropertyFile("BenIFSC") });
			columnDataMap.put("Account No*", new String[] { getAccountNo() });
			columnDataMap.put("Ben Email *", new String[] { UtilityClass.getDatafromPropertyFile("BenEmail") });
			columnDataMap.put("Ben Mobile *", new String[] { UtilityClass.getDatafromPropertyFile("BenMobile") });
			columnDataMap.put("Remarks", new String[] { UtilityClass.getDatafromPropertyFile("Remarks") });
			columnDataMap.put("Txn Type *", new String[] { UtilityClass.getDatafromPropertyFile("TxnType") });

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
			System.err.println("Error in Method : Add_Bulk_Beneficiary.insertDataIntoBulkBeneficiaryExcelFile()");
			System.err.println(e);
		}
	}

//	// Method to generate unique data for a given number of entries
//	private int[] generateUniqueData(int count) {
//		int[] uniqueData = new int[count];
//		Random random = new Random();
//		for (int i = 0; i < count; i++) {
//			uniqueData[i] = random.nextInt(1000);
//		}
//		return uniqueData;
//	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("ddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;

	}

	// ** select bank name after uploading the excel file ** //

	public void SelectBankName(String bankName) throws Exception {
		System.out.println("Executing Method  : Add_Bulk_Beneficiary.SelectBankName()");

		try {
			// click on bank dropdown

			Thread.sleep(1000);
			BankDropDown.click();

			Thread.sleep(700);
			List<WebElement> bank = driver.findElements(By.xpath("//*[@id=\"bank\"]/option"));
			for (int i = 0; i < bank.size(); i++) {
				WebElement BankString = bank.get(i);
				String BankName = BankString.getText();
//				System.out.println(BankName);
				if (BankName.contains(bankName)) {
					driver.findElement(By.xpath("(//option[contains(.,' " + (bankName) + " ')])[2]")).click();

					break;

				} else {

//					System.out.println(" Bank name is not matched");

				}
			}
		} catch (Exception e) {

			System.out.println("Error in Method : Add_Bulk_Beneficiary.SelectBankName()");

			System.err.println(e);

		}
	}

	// ** enter remark **//

	public void EnterRemark() throws InterruptedException {
		try {

			System.out.println("Executing Method  : EnterRemark()");
			// Enter remark
			Thread.sleep(600);
			EnterRemark.sendKeys(remark);

			System.out.println("remark : " + remark);

		} catch (Exception e) {

			System.err.println("Erro in method : EnterRemark()");

			System.err.println(e);
		}
	}

	// ** click on confirm button **//

	public void ClickOnConfirmButton() throws InterruptedException {

		try {

			System.out.println("Executing Method : Add_Bulk_Beneficiary.ClickOnConfirmButton()");
			// click on confirm button
			Thread.sleep(600);
			ClickOnConfirmButton.click();

			System.out.println("File Uploaded Successfully..");

		} catch (Exception e) {

			System.err.println("Error in Method : Add_Bulk_Beneficiary.ClickOnConfirmButton()");

			System.err.println(e);
		}

	}

	// ** check initiated status after successfully uploading bulk beenficiary file
	// ** //

	public void verifyStatusForUploadedBulkBeneficiary() throws Exception {
		try {
			System.out.println("Executing Method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary()");

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
			System.out.println("Load status after uploaded Bulk Beneficiary : " + LoadStatus);

			// check Initiated status
			WebElement Initiated_status = driver
					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + remark
							+ "')]//button[contains(text(), 'Initiated')]"));

			if (Initiated_status.isDisplayed()) {
				System.out.println(
						"After successfully uploading the bulk beneficiary file , initiated status is displayed . ");

				driver.navigate().refresh();

			} else {

				System.err.println(
						"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After refreshing the page load status of Bulk Beneficiary has not changed initiated to Initiated");

				String InvalidStatus = "Invalid";

				if (LoadStatus.contains(InvalidStatus)) {

					WebElement ClickOnInValidRecord = driver
							.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'" + remark
									+ "')]/td[contains(text(), '') and @style][2]"));
					ClickOnInValidRecord.click();

					Thread.sleep(1000);

					WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

					String RejectionReason_String = RejectionReason.getText();

					System.err.println(" Bulk Beneficiary RejectionReason : " + RejectionReason_String);

					// click on cancel button
					Thread.sleep(300);

					CancelButton.click();

					Thread.sleep(1000);

					Assert.fail(
							"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After refreshing the page load status of Bulk Beneficiary has not changed initiated to Success");
				}
				Assert.fail(
						"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After Successfully uploaded Bulk Beneficiary Initiated status Has not displayed on screen");
			}

		} catch (Exception e) {
			System.err.println("Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary()");
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
			System.out.println("Load status after uploaded Bulk Beneficiary : " + StringloadStatusAfterRefreshingPage);

//			// check Success status
//			WebElement Success_status = driver
//					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + remark
//							+ "')]//button[contains(text(), 'Success')]"));

			// Check Success status
			List<WebElement> successStatusElements = driver
					.findElements(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + remark
							+ "')]//button[contains(text(), 'Success')]"));

			// ** check No of Valid Records ** //
			Thread.sleep(1000);

			if (!successStatusElements.isEmpty() && successStatusElements.get(0).isDisplayed()) {
				System.out.println("After refreshing the page load status has changed initiated to Success");

				WebElement ClickOnValidRecord = driver
						.findElement(By.xpath("//tr[contains(td/button/text(), 'Success') and contains(.,'" + remark
								+ "')]/td[contains(text(), '1') and @style]"));

				ClickOnValidRecord.click();

				// -----------verify valid records -------------------//

				// verify valid records - customer reference no.
				WebElement ValidRecord_CustomerRefNo = driver
						.findElement(By.xpath("//td[contains(.,'" + CustomerRefNo + "')]"));
				Assert.assertTrue(ValidRecord_CustomerRefNo.isDisplayed());
				System.out.println("Valid Customer reference number is present on the valid records page");

				// ** Verify valid records - Customer ID ** //

				String pageSource_ValidRecords = driver.getPageSource();

				// Check if the desired string is present
				boolean Customer_Id = pageSource_ValidRecords
						.contains(UtilityClass.getDatafromPropertyFile("CustomerId"));

				// Assert that the string is present on the page
				Assert.assertTrue(Customer_Id, "valid " + Customer_Id + "' is present on the page.");

				// Verify Valid records - Beneficiary Name

				boolean BeneficiaryName = pageSource_ValidRecords
						.contains(UtilityClass.getDatafromPropertyFile("BenName"));

				// Assert that the string is present on the page
				Assert.assertTrue(BeneficiaryName, "valid " + BeneficiaryName + "' is present on the page.");

				// Verify Valid Records - Bene Code

				WebElement ValidRecord_BeneCode = driver.findElement(By.xpath("//td[contains(.,'" + BenCode + "')]"));
				Assert.assertTrue(ValidRecord_BeneCode.isDisplayed());
				System.out.println("Valid Beneficiary Code is present on the valid records page");

				// Verify valid Record - Bene IFSC Code

				boolean Bene_IFSCCode = pageSource_ValidRecords
						.contains(UtilityClass.getDatafromPropertyFile("BenIFSC"));

				// Assert that the string is present on the page
				Assert.assertTrue(Bene_IFSCCode, "valid " + Bene_IFSCCode + "' is present on the page.");

				// Verify Valid Records - Bene Account No

				WebElement ValidRecord_BeneAccountNo = driver
						.findElement(By.xpath("//td[contains(.,'" + AccountNo + "')]"));
				Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed());

				System.out.println("Valid Beneficiary account number is present on the valid records page");

				// verify Bene Status on valid records page

				WebElement BeneStatus = driver.findElement(By.xpath("//button[contains(.,'Request Received')]"));

				Assert.assertTrue(BeneStatus.isDisplayed());

				System.out.println("showing correct beneficary status on the valid records page ");

			} else {
				System.err.println(
						"Error in method : Add_Bulk_Beneficiary.verifyStatusForUploadedBulkBeneficiary() - After refreshing the page load status of Bulk Beneficiary has not changed initiated to Success");

				String InvalidStatus = "Invalid";
				Thread.sleep(500);

				if (StringloadStatusAfterRefreshingPage.contains(InvalidStatus)) {

					Thread.sleep(2000);

					WebElement ClickOnInValidRecord = driver
							.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'" + remark
									+ "')]/td[contains(text(), '') and @style][2]"));
					ClickOnInValidRecord.click();

					Thread.sleep(2000);

					WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

					Thread.sleep(1000);

					RejectionReason.click();

					Thread.sleep(1000);

					WebElement getRejectionReason = driver.findElement(By.xpath(
							"//div[contains(@class, 'modal-content')]//div[contains(@class, 'reject-reason')]//p"));

					String getRejectionReason_string = getRejectionReason.getText();

					System.err.println(" RejectionReason : " + getRejectionReason_string);

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

			List<WebElement> statusElements = driver
					.findElements(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + remark
							+ "')]//button[contains(text(), 'Invalid')]"));
			Thread.sleep(2000);

			if (!statusElements.isEmpty() && statusElements.get(0).isDisplayed()) {
				System.out.println("Invalid Status is displayed on screen");

				WebElement clickOnInvalidRecord = driver
						.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'" + remark
								+ "')]/td[contains(text(), '') and @style][2]"));
				clickOnInvalidRecord.click();

				Thread.sleep(2000);

				WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

				Thread.sleep(1000);

				RejectionReason.click();

				Thread.sleep(1000);

				WebElement getRejectionReason = driver.findElement(By
						.xpath("//div[contains(@class, 'modal-content')]//div[contains(@class, 'reject-reason')]//p"));

				String getRejectionReason_string = getRejectionReason.getText();

				System.err.println(" RejectionReason : " + getRejectionReason_string);

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
	public void ClickOn_BeneficiaryListOption() throws InterruptedException {

		try {

			System.out.println("Executing Method : Add_Bulk_Beneficiary.ClickOn_BeneficiaryListOption()");

			Thread.sleep(500);
			// Click on beneficiary list option
			Beneficiary_list.click();

		} catch (Exception e) {

			System.err.println("Error in Method : Add_Bulk_Beneficiary.ClickOn_BeneficiaryListOption()");

			System.err.println(e);
		}
	}

	public void ValidateValidRecords() throws Exception {

		try {
			System.out.println("Executing Method : Add_Bulk_Beneficiary.ValidateValidRecords()");
			Thread.sleep(1000);
			// verify added beneficiary details in beneficiary list

			// ** Customer id ** //

//			// Verify valid records - Customer ID
//
//			String pageSource_ValidRecords = driver.getPageSource();
//
//			// Check if the desired string is present
//
//			WebElement customer_id = driver.findElement(
//					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("CustomerId")
//							+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]"));
//			Assert.assertTrue(customer_id.isDisplayed(),
//					"Valid Beneficiary Customer id  is NOT present on the Beneficiary list page");
//
//			System.out.println("Valid Beneficiary Customer id  is present on the Beneficiary list page");
//
//			// ** Bene Code ** //
//
//			WebElement ValidRecord_BeneCode = driver.findElement(By.xpath("//td[contains(.,'" + BenCode + "')]"));
//			Assert.assertTrue(ValidRecord_BeneCode.isDisplayed());
//			System.out.println("Valid Beneficiary Code is present on the valid records page");
//
//			// ** Bene Name ** //
//
//			// Assert that the string is present on the page
//			WebElement Bene_name = driver
//					.findElement(By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName")
//							+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]"));
//			Assert.assertTrue(Bene_name.isDisplayed(),
//					"Valid Beneficiary name  is NOT present on the Beneficiary list page");
//			System.out.println("Valid Beneficiary name is  present on the Beneficiary list page");
//
//			// ** bene account number **//
//
//			WebElement ValidRecord_BeneAccountNo = driver
//					.findElement(By.xpath("//td[contains(.,'" + AccountNo + "')]"));
//			Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed(),
//					"Valid Beneficiary account number is NOT present on the Beneficiary list page");
//			System.out.println("Valid Beneficiary account number is present on the Beneficiary list page");
//
//			// **Bene IFSC Code ** //
//
//			// Assert that the string is present on the page
//			WebElement Bene_IFSC_Code = driver
//					.findElement(By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC")
//							+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]"));
//			Assert.assertTrue(Bene_IFSC_Code.isDisplayed(),
//					"Valid Beneficiary IFSC Code  is NOT present on the Beneficiary list page");
//			System.out.println("Valid Beneficiary IFSC code is  present on the Beneficiary list page");
//
//			// ** Bene email address ** //
//
//			// Assert that the string is present on the page
//			WebElement Bene_EmailID = driver.findElement(
//					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenEmail")
//							+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]"));
//			Assert.assertTrue(Bene_EmailID.isDisplayed(),
//					"Valid Beneficiary Email Address  is NOT present on the Beneficiary list page");
//			System.out.println("Valid Beneficiary Email address is  present on the Beneficiary list page");
//
//			// ** customer reference no. ** //
//
//			WebElement ValidRecord_CustomerRefNo = driver
//					.findElement(By.xpath("//td[contains(.,'" + CustomerRefNo + "')]"));
//			Assert.assertTrue(ValidRecord_CustomerRefNo.isDisplayed());
//			System.out.println("Valid Customer reference number is present on the Beneficiary list page");
//
//			// ** Bene Mobile number ** //
//
//			// Check if the desired string is present
//
//			WebElement Bene_MobileNumber = driver.findElement(
//					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenMobile")
//							+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]"));
//			Assert.assertTrue(Bene_MobileNumber.isDisplayed(),
//					"Valid Beneficiary Mobile number  is NOT present on the Beneficiary list page");
//			System.out.println("Valid Beneficiary Mobile number is  present on the Beneficiary list page");
//
//			// verify Bene Status on valid records page
//
//			WebElement BeneStatus = driver.findElement(By.xpath("//button[contains(.,'Request Received')]"));
//
//			Assert.assertTrue(BeneStatus.isDisplayed());
//			System.out.println("showing correct beneficary status on the Beneficiary list page");

			// Verify valid records - Customer ID
			String customerId = "//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("CustomerId")
					+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]";
			List<WebElement> customerIdElements = driver.findElements(By.xpath(customerId));
			Assert.assertFalse(customerIdElements.isEmpty(),
					"Valid Beneficiary Customer id is NOT present on the Beneficiary list page");
			System.out.println("Valid Beneficiary Customer id is present on the Beneficiary list page");

			// Bene Code
			String beneCode = "//td[contains(.,'" + BenCode + "')]";
			List<WebElement> beneCodeElements = driver.findElements(By.xpath(beneCode));
			Assert.assertFalse(beneCodeElements.isEmpty(),
					"Valid Beneficiary Code is NOT present on the valid records page");
			System.out.println("Valid Beneficiary Code is present on the valid records page");

			// Bene Name
			String beneName = "//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName")
					+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]";
			List<WebElement> beneNameElements = driver.findElements(By.xpath(beneName));
			Assert.assertFalse(beneNameElements.isEmpty(),
					"Valid Beneficiary name is NOT present on the Beneficiary list page");
			System.out.println("Valid Beneficiary name is present on the Beneficiary list page");

			// Bene Account Number
			String beneAccountNo = "//td[contains(.,'" + AccountNo + "')]";
			List<WebElement> beneAccountNoElements = driver.findElements(By.xpath(beneAccountNo));
			Assert.assertFalse(beneAccountNoElements.isEmpty(),
					"Valid Beneficiary account number is NOT present on the Beneficiary list page");
			System.out.println("Valid Beneficiary account number is present on the Beneficiary list page");

			// Bene IFSC Code
			String beneIfsc = "//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC")
					+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]";
			List<WebElement> beneIfscElements = driver.findElements(By.xpath(beneIfsc));
			Assert.assertFalse(beneIfscElements.isEmpty(),
					"Valid Beneficiary IFSC Code is NOT present on the Beneficiary list page");
			System.out.println("Valid Beneficiary IFSC code is present on the Beneficiary list page");

			// Bene Email Address
			String beneEmail = "//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenEmail")
					+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]";
			List<WebElement> beneEmailElements = driver.findElements(By.xpath(beneEmail));
			Assert.assertFalse(beneEmailElements.isEmpty(),
					"Valid Beneficiary Email Address is NOT present on the Beneficiary list page");
			System.out.println("Valid Beneficiary Email address is present on the Beneficiary list page");

			// Customer Reference Number
			String customerRefNo = "//td[contains(.,'" + CustomerRefNo + "')]";
			List<WebElement> customerRefNoElements = driver.findElements(By.xpath(customerRefNo));
			Assert.assertFalse(customerRefNoElements.isEmpty(),
					"Valid Customer reference number is NOT present on the Beneficiary list page");
			System.out.println("Valid Customer reference number is present on the Beneficiary list page");

			// Bene Mobile Number
			String beneMobile = "//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenMobile")
					+ "')]]/td[contains(text(), '" + CustomerRefNo + "')]";
			List<WebElement> beneMobileElements = driver.findElements(By.xpath(beneMobile));
			Assert.assertFalse(beneMobileElements.isEmpty(),
					"Valid Beneficiary Mobile number is NOT present on the Beneficiary list page");
			System.out.println("Valid Beneficiary Mobile number is present on the Beneficiary list page");

			// Bene Status
			String beneStatus = "//button[contains(.,'Request Received')]";
			List<WebElement> beneStatusElements = driver.findElements(By.xpath(beneStatus));
			Assert.assertFalse(beneStatusElements.isEmpty(),
					"Correct beneficiary status is NOT present on the Beneficiary list page");
			System.out.println("Showing correct beneficiary status on the Beneficiary list page");

		} catch (Exception e) {

			System.err.println("Error in Method : Add_Bulk_Beneficiary.ValidateValidRecords()");

			System.err.println(e);

		}
	}

}
