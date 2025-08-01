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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class PayoutMakerCheckerSameEntity_RBLBank {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(.,'Bulk Payout')]")
	private WebElement Bulk_Payout_RBL_Bank;

	@FindBy(xpath = "//button[contains(.,'Add Bulk Payout')]")
	private WebElement Add_BulkPayout;

	@FindBy(xpath = "//a[contains(.,'Payout List')]")
	private WebElement Payout_List;

	@FindBy(xpath = "//input[@id=\"remark\"]")
	private WebElement EnterDescription;

	@FindBy(xpath = "(//button[@class=\"close\" and @aria-label=\"Close\"])[1]")
	private WebElement CancelButton;

	@FindBy(xpath = "//a[contains(.,'Payout Approval List')]")
	private WebElement clickOnPayoutApprovalListOption;

	@FindBy(xpath = "//*[@id=\"reason\"]")
	private WebElement enterApprovalReason;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/div[5]/button[2]")
	private WebElement clickConfirmButtonOnApproveTransactionPopup;

	@FindBy(xpath = "//div[contains(@class, 'tab-header') and contains(text(), 'All Actions')]")
	private WebElement clickOnAllActions;

	public static String Description;
	public static String CustomerRefNo_bulkPayout;
	public static String ExternalRefNo_bulkPayout;
	public static String bene;

	public static String getCustomerRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("CustomerRefNo_bulkPayout_RBL") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("ExternalRefNo_bulkPayout_RBL") + getCurrentTimeStamp();
	}

	public PayoutMakerCheckerSameEntity_RBLBank(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ** click on bulk payout option
	public void ClickOn_Bulk_Payout_RBL_BankOption() throws InterruptedException {
		try {

			System.out.println(
					"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.ClickOn_Bulk_Payout_RBL_BankOption()");

			Thread.sleep(400);
			Bulk_Payout_RBL_Bank.click();

		} catch (Exception e) {
			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.ClickOn_Bulk_Payout_RBL_BankOption()");
		}
	}

	// ** click on add bulk payout option
	public void ClickOn_AddBulkPayout() throws InterruptedException {
		try {
			System.out.println("Executing Method : PayoutMakerCheckerSameEntity_RBLBank.ClickOn_AddBulkPayout()");
			Thread.sleep(800);

			Add_BulkPayout.click();

		} catch (Exception e) {
			System.err.println("Error in Method : PayoutMakerCheckerSameEntity_RBLBank.ClickOn_AddBulkPayout()");
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

	public void validateBulkPayoutExcelFileHeaders_For_DBSBankFile(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_DBSBankFile()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Ben Name", "Ben IFSC", "Ben Acct No", "Description",
					"Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println("All expected columns are present in DBS Bank Excel File '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_DBSBankFile() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in DBS Bank Excel File '" + sheetName + "': "
						+ missingColumns);
			}
		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_DBSBankFile()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_IDFCBankFile(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_IDFCBankFile()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Ben Name", "Ben IFSC", "Ben Acct No", "Description",
					"Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println("All expected columns are present in IDFC Bank Excel File '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_IDFCBankFile() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in IDFC Bank Excel File '" + sheetName + "': "
						+ missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_IDFCBankFile()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_InduslndBankFile(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_InduslndBankFile()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Ben Name", "Ben IFSC", "Ben Acct No", "Description",
					"Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println("All expected columns are present in Induslnd Bank Excel File '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_InduslndBankFile() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in Induslnd Bank Excel File '" + sheetName + "': "
						+ missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_InduslndBankFile()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_NSDL_PaymentsBankFile(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_NSDL_PaymentsBankFile()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Ben Name", "Ben IFSC", "Ben Acct No", "Description",
					"Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println(
						"All expected columns are present in NSDL Payment Bank Excel File '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_NSDL_PaymentsBankFile() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in NSDL Payment Bank Excel File '" + sheetName + "': "
						+ missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_NSDL_PaymentsBankFile()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_RBLBankFile(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_RBLBankFile()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Maker Id", "Checker Id", "Ben Name", "Ben IFSC",
					"Ben Acct No", "Ben Mobile", "Description", "Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println("All expected columns are present in RBL Bank Excel File '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_RBLBankFile() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in RBL Bank Excel File '" + sheetName + "': "
						+ missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_RBLBankFile()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_AxisBankFile(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_AxisBankFile()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Ben Name", "Ben IFSC", "Ben Acct No", "Description",
					"Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println("All expected columns are present in Axis Bank Excel File '" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_AxisBankFile() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in Axis Bank Excel File '" + sheetName + "': "
						+ missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_AxisBankFile()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Txn Type *", "Amount *", "Ben Name", "Ben IFSC", "Ben Acct No", "Description",
					"Remarks 1", "Remarks 2", "Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println(
						"All expected columns are present in Yes Bank Excel File Account payout'" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in Yes Bank Excel File Account payout '" + sheetName
						+ "': " + missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout()");

			System.err.println(e);
		}
	}

	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout(String UploadFilePath) {

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout()");
		try {
			String filePath = UploadFilePath;
			String sheetName = "Payout Template";
			List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Txn Ref No *",
					"External Ref No *", "Amount *", "Ben Name *", "Ben VPA *", "Description", "Remarks 1", "Remarks 2",
					"Remarks 3");

			List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

			if (missingColumns.isEmpty()) {
				System.out.println(
						"All expected columns are present in Yes Bank Excel File VPA payout'" + sheetName + "'.");
			} else {
				StringBuilder errorMessage = new StringBuilder("The following columns are missing in sheet '")
						.append(sheetName).append("':\n");
				for (String columnName : missingColumns) {
					errorMessage.append("- ").append(columnName).append("\n");
				}
				System.err.println(
						"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout() "
								+ errorMessage.toString());
				Assert.fail(" The following columns are missing in Yes Bank Excel File VPA payout '" + sheetName + "': "
						+ missingColumns);
			}

		} catch (Exception e) {

			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout()");

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

	public void insertDataIntoBulkPayoutExcelFile(String payoutFile) throws Exception {

		try {
			System.out.println(
					"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.insertDataIntoBulkPayoutExcelFile()");
			// Path to your Excel file
			String excelFilePath = payoutFile;

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
			columnDataMap.put("Customer Id *", new String[] { UtilityClass.getDatafromPropertyFile("CustomerId_RBL") });
			columnDataMap.put("Debit Account No *",
					new String[] { UtilityClass.getDatafromPropertyFile("Debit_AccountNo_RBL") });
			System.out.println("CustomerRefNo_bulkPayout : " + CustomerRefNo_bulkPayout);
			columnDataMap.put("Customer Txn Ref No *", new String[] { CustomerRefNo_bulkPayout });
			columnDataMap.put("External Ref No *", new String[] { ExternalRefNo_bulkPayout });
			System.out.println("CustomerExtNo_bulkPayout : " + ExternalRefNo_bulkPayout);
			columnDataMap.put("Txn Type *", new String[] { UtilityClass.getDatafromPropertyFile("TxnType") });
			columnDataMap.put("Amount *",
					new String[] { UtilityClass.getDatafromPropertyFile("Amount_BulkPayout_RBL") });
			columnDataMap.put("Maker Id", new String[] { UtilityClass.getDatafromPropertyFile("MakerId_RBL") });
			columnDataMap.put("Checker Id", new String[] { UtilityClass.getDatafromPropertyFile("CheckerId_RBL") });
			columnDataMap.put("Ben Name", new String[] { UtilityClass.getDatafromPropertyFile("BenName_RBL") });
			columnDataMap.put("Ben IFSC", new String[] { UtilityClass.getDatafromPropertyFile("BenIFSC_RBL") });
			columnDataMap.put("Ben Acct No",
					new String[] { UtilityClass.getDatafromPropertyFile("BenAccntNo_forRBLBank") });
			columnDataMap.put("Ben Mobile", new String[] { UtilityClass.getDatafromPropertyFile("BenMobile_RBL") });
			columnDataMap.put("Description", new String[] { UtilityClass.getDatafromPropertyFile("Description") });

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
			System.err.println(
					"Error in Method : PayoutMakerCheckerSameEntity_RBLBank.insertDataIntoBulkPayoutExcelFile()");
		}
	}

	// ** enter remark **//

	public void EnterDescription() throws InterruptedException {

		try {
			System.out.println("Executing Method : PayoutMakerCheckerSameEntity_RBLBank.EnterDescription()");
			// Enter remark
			Thread.sleep(600);
			Description = getCurrentTimeStamp();
			EnterDescription.sendKeys(getCurrentTimeStamp());
			System.out.println("Description : " + Description);

		} catch (Exception e) {
			System.err.println("Error in Method : PayoutMakerCheckerSameEntity_RBLBank.EnterDescription()");
			System.err.println(e);
		}
	}

	// -----------------------MAKER CHECKER------------------//

// **check initiated status after successfully uploading bulk payout file**//

	public void verifyStatusForUploadedPayouts_MakerCheckerFlow() throws Exception {

		Thread.sleep(2000);

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts_MakerCheckerFlow()");

		Thread.sleep(1000);

		// Get the page source
		String pageSource = driver.getPageSource();

		// Check if the desired string is present
		boolean isPresent = pageSource.contains(Description);

		// Assert that the string is present on the page
		Assert.assertTrue(isPresent, "" + Description + "' is present on the page.");

		WebElement loadStatus = driver
				.findElement(By.xpath("//td[text()='" + Description + "']/following-sibling::td/button"));

		String LoadStatus = loadStatus.getText();

		// Print load status
		System.out.println("Load status after uploaded Bulk Payout Maker Checker Flow Same Entity : " + LoadStatus);

		// check Initiated status
		WebElement Initiated_status = driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'"
				+ Description + "')]//button[contains(text(), 'Initiated')]"));

		if (Initiated_status.isDisplayed()) {
			System.out.println(
					"After successfully uploading the bulk Payout for Maker Checker Flow Same Entity , initiated status is displayed . ");

			driver.navigate().refresh();

		} else {
			System.err.println(
					"After Successfully uploaded Bulk Payout for Maker Checker Flow Same Entity , Initiated status Has not displayed on screen");

			Assert.fail(
					"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts_MakerCheckerFlow - After Successfully uploaded Bulk Payout for Maker Checker Flow Same Entity ,Initiated status has not displayed on screen");
		}

		// ** check the Load status after refreshing the page ** //
	}

	// **check initiated status after successfully uploading bulk beenficiary
	// file**//

	public void verifyStatusForUploadedPayouts() throws Exception {

		Thread.sleep(2000);

		try {
			System.out.println(
					"Executing Method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts()");

			Thread.sleep(1000);

			// Get the page source
			String pageSource = driver.getPageSource();

			// Check if the desired string is present
			boolean isPresent = pageSource.contains(Description);

			// Assert that the string is present on the page
			Assert.assertTrue(isPresent, "" + Description + "' is present on the page.");

			WebElement loadStatus = driver
					.findElement(By.xpath("//td[text()='" + Description + "']/following-sibling::td/button"));

			String LoadStatus = loadStatus.getText();

			// Print load status
			System.out.println("Load status after uploaded Bulk Payout : " + LoadStatus);

			// check Initiated status
			WebElement Initiated_status = driver
					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + Description
							+ "')]//button[contains(text(), 'Initiated')]"));

			if (Initiated_status.isDisplayed()) {
				System.out.println(
						"after successfully uploading the bulk Payout file , initiated status is displayed . ");

				driver.navigate().refresh();

			} else {
				System.err.println(
						"After Successfully uploaded Bulk Payout Initiated status Has not displayed on screen");

				Assert.fail(
						"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts - After Successfully uploaded Bulk Payout Initiated status Has not displayed on screen");
			}

		} catch (Exception e) {
			System.err.println("Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts");
			System.err.println(e);
		}

		// ** check the Load status after refreshing the page ** //
	}

	public void ValidRecords() throws InterruptedException {

		try {
			System.out.println("PayoutMakerCheckerSameEntity_RBLBank.ValidRecords()");

			driver.navigate().refresh();
			Thread.sleep(3000);

			WebElement loadStatusAfterRefreshingPage = driver
					.findElement(By.xpath("//td[text()='" + Description + "']/following-sibling::td/button"));
			String StringloadStatusAfterRefreshingPage = loadStatusAfterRefreshingPage.getText();

			// Print load status
			System.out.println("Load status after uploaded Bulk Payout : " + StringloadStatusAfterRefreshingPage);

			// Check Success status
			try {

				List<WebElement> Success_status = driver
						.findElements(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + Description
								+ "')]//button[contains(text(), 'Success')]"));

				if (!Success_status.isEmpty() && Success_status.get(0).isDisplayed()) {

					Thread.sleep(1000);

					System.out.println("After refreshing the page load status has changed initiated to Success");
					Thread.sleep(1000);
//					WebElement ClickOnValidRecord = driver
//							.findElement(By.xpath("//tr[contains(td/button/text(), 'Success') and contains(.,'"
//									+ Description + "')]/td[contains(text(), '1') and @style]"));
					// tr[td[button[contains(@class, 'down-darkGreenStatus') and text()=' Success
					// ']] and td[text()='30170418']]//td[@class='makeCursor'][text()='1'][1]

					WebElement ClickOnValidRecord = driver.findElement(By.xpath(
							"//tr[td[button[contains(@class, 'down-darkGreenStatus') and text()=' Success ']] and td[text()='"
									+ Description + "']]//td[@class='makeCursor'][text()='1'][1]"));
					Thread.sleep(1000);
					ClickOnValidRecord.click();

					// Verify valid records - customer reference no.
					WebElement ValidRecord_CustomerRefNo = driver
							.findElement(By.xpath("//td[contains(.,'" + CustomerRefNo_bulkPayout + "')]"));
					Assert.assertTrue(ValidRecord_CustomerRefNo.isDisplayed());
					System.out.println(
							"Valid Customer reference number is present on the Bulk Payout's valid records page");

					// Verify valid records - Customer ID
					String pageSource_ValidRecords = driver.getPageSource();
					boolean Customer_Id = pageSource_ValidRecords
							.contains(UtilityClass.getDatafromPropertyFile("CustomerId_RBL"));
					Assert.assertTrue(Customer_Id, "Expected CustomerId '"
							+ UtilityClass.getDatafromPropertyFile("CustomerId_RBL")
							+ "' to be present on the page, but it was not found on the Bulk Payout's valid records page");

					System.out.println("Valid Customer Id is present on the Bulk Payout's valid records page");

					// Verify valid records - Beneficiary Name
					WebElement Bene_name = driver.findElement(
							By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName_RBL")
									+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
					Assert.assertTrue(Bene_name.isDisplayed(),
							"Valid Beneficiary name is NOT present on the Bulk payout's Valid Records page");
					System.out.println("Valid Beneficiary name is present on the Bulk Payout's valid record page");

					// Verify valid records - Bene account number
					WebElement ValidRecord_BeneAccountNo = driver.findElement(By.xpath("//td[contains(.,'"
							+ UtilityClass.getDatafromPropertyFile("BenAccntNo_forRBLBank") + "')]"));
					Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed(),
							"Valid Bulk Payout account number is NOT present on the Bulk Payout's Valid Record page");
					System.out.println(
							"Valid Bulk Payout account number is present on the Bulk Payout's Valid Record page");

					// Verify valid records - Bene IFSC Code
					WebElement Bene_IFSC_Code = driver.findElement(
							By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC_RBL")
									+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
					Assert.assertTrue(Bene_IFSC_Code.isDisplayed(),
							"Valid Bulk Payout IFSC Code is NOT present on the Bulk Payout's Valid Record page");
					System.out.println("Valid Bulk Payout IFSC code is present on the Bulk Payout's Valid Record page");

					// Verify valid records - Bene Amount
					WebElement Bene_Amount = driver.findElement(By.xpath(
							"//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("Amount_BulkPayout_RBL")
									+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
					Assert.assertTrue(Bene_Amount.isDisplayed(),
							"Valid Amount is NOT present on the Bulk Payout's Valid Record page");
					System.out.println("Valid Amount is present on the Bulk Payout's Valid Record page");

					// Verify status on valid records page
					WebElement status = driver.findElement(By.xpath("(//button[contains(.,' ')])[1]"));
					String statusString = status.getText();
					String actualString = "Pending Approval";

					System.out.println("BulkPayout Status : " + statusString);

					Assert.assertTrue(statusString.contains(actualString),
							"Bulk Payout's status is not as expected. Expected: '" + status + "', but found: '"
									+ statusString + "'");

					System.out.println("showing correct Bulk payout status on the Bulk Payout's Valid Record page");

				} else {
					handleInvalidStatus(StringloadStatusAfterRefreshingPage);
				}
			} catch (NoSuchElementException e) {
				handleInvalidStatus(StringloadStatusAfterRefreshingPage);
			}
		} catch (IOException e) {
			System.err.println("Error in method : PayoutMakerCheckerSameEntity_RBLBank.ValidRecords()");
			System.err.println(e);
			handleInvalidStatus("");
		}
	}

	private void handleInvalidStatus(String StringloadStatusAfterRefreshingPage) throws InterruptedException {
		System.err.println(
				"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts() - After refreshing the page load status of Bulk Payout has not changed initiated to Success");

		String InvalidStatus = "Invalid";

		if (StringloadStatusAfterRefreshingPage.contains(InvalidStatus)) {
			WebElement ClickOnInValidRecord = driver.findElement(By
					.xpath("//tr[td[button[contains(@class, 'down-redStatus') and text()=' Invalid ']] and td[text()='"
							+ Description + "']]//td[@class='makeCursor'][text()='1'][1]"));

			ClickOnInValidRecord.click();

			Thread.sleep(2000);

			WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

			Thread.sleep(1000);

			RejectionReason.click();

			Thread.sleep(1000);

			WebElement getRejectionReason = driver.findElement(
					By.xpath("//div[contains(@class, 'modal-content')]//div[contains(@class, 'reject-reason')]//p"));

			String getRejectionReason_string = getRejectionReason.getText();

			System.err.println(" RejectionReason : " + getRejectionReason_string);

			// click on cancel button
			Thread.sleep(300);

			CancelButton.click();

			Thread.sleep(1000);

			Assert.fail(
					"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts() - After refreshing the page load status of Bulk Payout has not changed initiated to Success");
		} else {
			System.err.println("Invalid Status is displayed on screen");
			WebElement ClickOnInValidRecord = driver.findElement(By
					.xpath("//tr[td[button[contains(@class, 'down-redStatus') and text()=' Invalid ']] and td[text()='"
							+ Description + "']]//td[@class='makeCursor'][text()='1'][1]"));

			ClickOnInValidRecord.click();

			Thread.sleep(2000);

			WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));

			Thread.sleep(1000);

			RejectionReason.click();

			Thread.sleep(1000);

			WebElement getRejectionReason = driver.findElement(
					By.xpath("//div[contains(@class, 'modal-content')]//div[contains(@class, 'reject-reason')]//p"));

			String getRejectionReason_string = getRejectionReason.getText();

			System.err.println(" RejectionReason : " + getRejectionReason_string);

			// click on cancel button
			Thread.sleep(300);

			CancelButton.click();

			Thread.sleep(1000);

			Assert.fail(
					"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts() - After refreshing the page load status of Bulk Payout has not changed initiated to Success");
		}
	}

//	public void ValidRecords() throws InterruptedException {
//
//		try {
//			System.out.println("PayoutMakerCheckerSameEntity_RBLBank.ValidRecords()");
//
//			driver.navigate().refresh();
//
//			Thread.sleep(3000);
//
//			WebElement loadStatusAfterRefreshingPage = driver
//					.findElement(By.xpath("//td[text()='" + Description + "']/following-sibling::td/button"));
//
//			String StringloadStatusAfterRefreshingPage = loadStatusAfterRefreshingPage.getText();
//
//			// Print load status
//			System.out.println("Load status after uploaded Bulk Payout : " + StringloadStatusAfterRefreshingPage);
//
//				
//			// check Success status
//			WebElement Success_status = driver
//					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + Description
//							+ "')]//button[contains(text(), 'Success')]"));
//			System.out.println("hi");
//			// ** check No of Valid Records ** //
//
//			Thread.sleep(1000);
//
//			if (Success_status.isDisplayed()) {
//				System.out.println("After refreshing the page load status has changed initiated to Success");
//
//				WebElement ClickOnValidRecord = driver
//						.findElement(By.xpath("//tr[contains(td/button/text(), 'Success') and contains(.,'"
//								+ Description + "')]/td[contains(text(), '1') and @style]"));
//
//				ClickOnValidRecord.click();
//
//				// -----------verify valid records -------------------//
//
//				// verify valid records - customer reference no.
//				WebElement ValidRecord_CustomerRefNo = driver
//						.findElement(By.xpath("//td[contains(.,'" + CustomerRefNo_bulkPayout + "')]"));
//				Assert.assertTrue(ValidRecord_CustomerRefNo.isDisplayed());
//				System.out
//						.println("Valid Customer reference number is present on the Bulk Payout's valid records page");
//
//				// ** Verify valid records - Customer ID ** //
//
//				String pageSource_ValidRecords = driver.getPageSource();
//
//				// Check if the desired string is present
//				boolean Customer_Id = pageSource_ValidRecords
//						.contains(UtilityClass.getDatafromPropertyFile("CustomerId"));
//
//				// Assert that the string is present on the page
//
//				Assert.assertTrue(Customer_Id, "Expected CustomerId '"
//						+ UtilityClass.getDatafromPropertyFile("CustomerId_RBL")
//						+ "' to be present on the page, but it was not found on the Bulk Payout's valid records page");
//
//				System.out.println("Valid Customer Id is present on the Bulk Payout's valid records page");
//
//				// Verify Valid records - Beneficiary Name
//
//				// ** Bene Name ** //
//				WebElement Bene_name = driver.findElement(
//						By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName_RBL")
//								+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
//				Assert.assertTrue(Bene_name.isDisplayed(),
//						"Valid Beneficiary name  is NOT present on the Bulk payout's Valid Records page");
//				System.out.println("Valid Beneficiary name is  present on the  Bulk Payout's valid record page");
//
//				// Verify Valid Records - Bene account number
//
//				// ** bene account number **//
//
//				WebElement ValidRecord_BeneAccountNo = driver.findElement(By.xpath(
//						"//td[contains(.,'" + UtilityClass.getDatafromPropertyFile("BenAccntNo_forRBLBank") + "')]"));
//
//				Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed(),
//						"Valid Bulk Payout account number is NOT present on the Bulk Payout's Valid Record page");
//
//				System.out
//						.println("Valid Bulk Payout account number is present on the Bulk Payout's Valid Record  page");
//
//				// **Bene IFSC Code ** //
//
//				// Assert that the string is present on the page
//				WebElement Bene_IFSC_Code = driver.findElement(
//						By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC_RBL")
//								+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
//
//				Assert.assertTrue(Bene_IFSC_Code.isDisplayed(),
//						"Valid Bulk Payout IFSC Code  is NOT present on the Bulk Payout's Valid Record page");
//
//				System.out.println("Valid Bulk Payout IFSC code is  present on the Bulk Payout's Valid Record page");
//
//				// **Bene Amount ** //
//
//				// Assert that the string is present on the page
//				WebElement Bene_Amount = driver.findElement(By.xpath(
//						"//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("Amount_BulkPayout_RBL")
//								+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
//
//				Assert.assertTrue(Bene_Amount.isDisplayed(),
//						"Valid Amount  is NOT present on the Bulk Payout's Valid Record page");
//
//				System.out.println("Valid Amount  is  present on the Bulk Payout's Valid Record page");
//
//				// verify Status on valid records page
//
//				WebElement status = driver.findElement(By.xpath("(//button[contains(.,' ')])[1]")); // button[contains(.,'Request
//																									// Received')]
//
//				String statusString = status.getText();
//
//				String actualString = "Request Received";
//
//				System.out.println("BulkPayout Status : " + statusString);
//
//				Assert.assertTrue(statusString.contains(actualString),
//						"Bulk Payout's status is not as expected. Expected: '" + status + "', but found: '"
//								+ statusString + "'");
//
//				System.out.println("showing correct Bulk payout status on the Bulk Payout's Valid Record page");
//
//			} else {
//				System.err.println(
//						"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts() - After refreshing the page load status of Bulk Payout has not changed initiated to Success");
//
//				String InvalidStatus = "Invalid";
//
//				if (StringloadStatusAfterRefreshingPage.contains(InvalidStatus)) {
//
//					WebElement ClickOnInValidRecord = driver
//							.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'"
//									+ Description + "')]/td[contains(text(), '') and @style][2]"));
//					ClickOnInValidRecord.click();
//
//					Thread.sleep(500);
//
//					WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));
//
//					String RejectionReason_String = RejectionReason.getText();
//
//					System.err.println(" RejectionReason : " + RejectionReason_String);
//
//					// click on cancel button
//					Thread.sleep(300);
//
//					CancelButton.click();
//
//					Thread.sleep(1000);
//
//					Assert.fail(
//							"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts() - After refreshing the page load status of Bulk Payout has not changed initiated to Success");
//				}
//
//			}
//
//		} catch (IOException e) {
//			System.err.println("Error in method : PayoutMakerCheckerSameEntity_RBLBank.ValidRecords()");
//
//			System.err.println(e);
//
//			WebElement status = driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'"
//					+ Description + "')]//button[contains(text(), 'Invalid')]"));
//
//			if (status.isDisplayed()) {
//
//				System.out.println("Invalid Status is displayed on screen");
//
//				WebElement ClickOnInValidRecord = driver
//						.findElement(By.xpath("//tr[contains(td/button/text(), 'Invalid') and contains(.,'"
//								+ Description + "')]/td[contains(text(), '') and @style][2]"));
//				ClickOnInValidRecord.click();
//				Thread.sleep(1000);
//
//				WebElement RejectionReason = driver.findElement(By.xpath("//td[@class=\"makeShortReason\"]"));
//
//				String RejectionReason_String = RejectionReason.getText();
//
//				System.err.println(" RejectionReason : " + RejectionReason_String);
//
//				// click on cancel button
//				Thread.sleep(300);
//
//				CancelButton.click();
//
//				Thread.sleep(1000);
//
//				Assert.fail(
//						"Error in method : PayoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts() - After refreshing the page load status of Bulk Payout has not changed initiated to Success");
//			}
//
//		}
//	}

	// ** click on beneficiary list option ** //
	public void ClickOn_Payout_ListOption() throws InterruptedException {
		Thread.sleep(800);
		// Click on beneficiary list option
		Payout_List.click();
	}

	// ** verify uploaded data on the bulk upload page ** //

	public void VerifyFieldsOnPayoutListPage() throws Exception {

		try {
			System.out
					.println("Executing Method : PayoutMakerCheckerSameEntity_RBLBank.VerifyFieldsOnPayoutListPage()");
			Thread.sleep(1000);
			// verify added beneficiary details in beneficiary list

			// ** Customer id ** //

			// Verify valid records - Customer ID

			// Check if the desired string is present

			WebElement customer_id = driver.findElement(
					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("CustomerId_RBL")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(customer_id.isDisplayed(),
					"Valid Beneficiary Customer id  is NOT present on the Payout list page");

			System.out.println("Valid Beneficiary Customer id  is present on the Payout list page");

			// ** Bene Name ** //

			// Assert that the string is present on the page
			WebElement Bene_name = driver.findElement(
					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenName_RBL")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(Bene_name.isDisplayed(),
					"Valid Beneficiary name  is NOT present on the Payout list page");
			System.out.println("Valid Beneficiary name is  present on the Payout list page");

			// ** bene account number **//

			WebElement ValidRecord_BeneAccountNo = driver.findElement(By.xpath(
					"//td[contains(.,'" + UtilityClass.getDatafromPropertyFile("BenAccntNo_forRBLBank") + "')]"));
			Assert.assertTrue(ValidRecord_BeneAccountNo.isDisplayed(),
					"Valid Beneficiary account number is NOT present on the Payout list page");
			System.out.println("Valid Beneficiary account number is present on the Payout list page");

			// **Bene IFSC Code ** //

			// Assert that the string is present on the page
			WebElement Bene_IFSC_Code = driver.findElement(
					By.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("BenIFSC_RBL")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(Bene_IFSC_Code.isDisplayed(),
					"Valid Beneficiary IFSC Code  is NOT present on the Payout list page");
			System.out.println("Valid Beneficiary IFSC code is  present on the Payout list page");

			// **Bene Amount ** //

			// Assert that the string is present on the page
			WebElement Bene_Amount = driver.findElement(By
					.xpath("//tr[td[contains(text(), '" + UtilityClass.getDatafromPropertyFile("Amount_BulkPayout_RBL")
							+ "')]]/td[contains(text(), '" + CustomerRefNo_bulkPayout + "')]"));
			Assert.assertTrue(Bene_Amount.isDisplayed(), "Valid Amount  is NOT present on the Payout list page");
			System.out.println("Valid Amount  is  present on the Payout list page ");

			// verify Bene Status on valid records page

			WebElement BulkPayoutStatusOnPayoutListPage = driver
					.findElement(By.xpath("//button[contains(.,'Pending Approval')]"));

			String statusString = BulkPayoutStatusOnPayoutListPage.getText();

			System.out.println("BulkPayoutStatusOnPayoutListPage : " + statusString);

			Assert.assertTrue(BulkPayoutStatusOnPayoutListPage.isDisplayed());

			System.out.println("showing correct beneficary status on the Beneficiary list page");

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error in method : PayoutMakerCheckerSameEntity_RBLBank.VerifyFieldsOnPayoutListPage()");
		}
	}

	// ** click on payout approval list ** //

	public void clickOnPayoutApprovalListOption() throws InterruptedException {

		System.out.println("Executing Method : clickOnPayoutApprovalListOption()");

		try {
			Thread.sleep(500);

			clickOnPayoutApprovalListOption.click();

		} catch (Exception e) {

			System.out.println("Error in Method : clickOnPayoutApprovalListOption()");
		}
	}
	// ** approve payout from checker 1

	public void approvePayoutFromSameCheckerUser() throws InterruptedException {

		System.out
				.println("Executing Method : PayoutMakerCheckerSameEntity_RBLBank.approvePayoutFromSameCheckerUser()");

		Thread.sleep(3000);
		try {
			List<WebElement> clickOnApprove = driver.findElements(
					By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + CustomerRefNo_bulkPayout + "')]"));

			if (!clickOnApprove.isEmpty() && clickOnApprove.get(0).isDisplayed()) {

				Assert.assertTrue(true, CustomerRefNo_bulkPayout);
				System.out.println("Payout is displaying in payout approval list for Payout checker user 01");

				// ** Click on Approve button to approve the payout ** //

				WebElement clickOnApproveOption = driver.findElement(By.xpath("//td[text()='" + CustomerRefNo_bulkPayout
						+ "']/following-sibling::td[@class='text-center']/img[@src='assets/icons/svg/rightclick.svg']"));

				clickOnApproveOption.click();

				// ** enter reason in approve transaction popup ** //
				Thread.sleep(500);

				enterApprovalReason
						.sendKeys(UtilityClass.getDatafromPropertyFile("enterPayoutRemarkForChecker_User01"));

				// ** Click on Confirm button ** //
				Thread.sleep(500);
				clickConfirmButtonOnApproveTransactionPopup.click();

				System.out.println("Payout approved successfully from checker user : "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01_RBL"));

			} else {

				System.err.println(
						"Error in method : PayoutMakerCheckerSameEntity_RBLBank.approvePayoutFromSameCheckerUser()");

				Assert.fail("Payout is Not displaying in payout approval list for Payout Same Checker User");

			}

		} catch (Exception e) {

			System.err.println(
					"Error in method : PayoutMakerCheckerSameEntity_RBLBank.approvePayoutFromSameCheckerUser()");

			System.err.println(e);

			Assert.fail("Payout is Not displaying in payout approval list for Payout Same Checker User");

		}
	}

	public void clickOnAllActions_CheckerUserSameUserAprroval() throws InterruptedException {

		Thread.sleep(2000);
		System.out.println(
				"Executing method : PayoutMakerCheckerSameEntity_RBLBank.clickOnAllActions_CheckerUserSameUserAprroval()");
		try {
			clickOnAllActions.click();

		} catch (Exception e) {
			System.out.println(
					"Error in method : PayoutMakerCheckerSameEntity_RBLBank.clickOnAllActions_CheckerUserSameUserAprroval()"
							+ e);
		}
	}

	// ** check payout status after approving the payout from user 3 **//
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser01() throws IOException, InterruptedException {
		try {
			System.out.println(
					"Executing method: PayoutMakerCheckerSameEntity_RBLBank.verify_ApprovalStatusInAllActionsFor_CheckerUser01()");

			Thread.sleep(2000);

			List<WebElement> statusList = driver.findElements(By.xpath("//tr[td[contains(text(), '"
					+ CustomerRefNo_bulkPayout + "')]]/td[2]/button[text()=' Request Received ']"));

			if (!statusList.isEmpty() && statusList.get(0).isDisplayed()) {
				// Check if the status is displayed for the first element in the list
				WebElement status = statusList.get(0);
				boolean isDisplayed = status.isDisplayed();
				System.out.println(isDisplayed + " - Status is displayed for User: "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"));

				// Assert that the status is displayed
				Assert.assertTrue(isDisplayed, "Status is not displayed as expected for User: "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01_RBL"));
			} else {
				System.err.println(
						"Error in method: PayoutMakerCheckerSameEntity_RBLBank.verify_ApprovalStatusInAllActionsFor_CheckerUser01()");
				Assert.fail("Status is not displayed as expected for User: "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01_RBL"));
			}
		} catch (Exception e) {
			System.err.println(
					"Error in method: PayoutMakerCheckerSameEntity_RBLBank.verify_ApprovalStatusInAllActionsFor_CheckerUser01()");
			System.err.println(e);
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}

}
