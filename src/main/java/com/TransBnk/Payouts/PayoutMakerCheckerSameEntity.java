package com.TransBnk.Payouts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class PayoutMakerCheckerSameEntity {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(.,'Bulk Payout')]")
	private WebElement Bulk_Payout;

	@FindBy(xpath = "//button[contains(.,'Add Bulk Payout')]")
	private WebElement Add_BulkPayout;

	@FindBy(xpath = "//a[contains(.,'Payout List')]")
	private WebElement Payout_List;

	@FindBy(xpath = "//input[@id=\"remark\"]")
	private WebElement EnterRemark;

	@FindBy(xpath = "//a[contains(.,'Payout Approval List')]")
	private WebElement clickOnPayoutApprovalListOption;

	@FindBy(xpath = "//*[@id=\"reason\"]")
	private WebElement enterApprovalReason;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/div[5]/button[2]")
	private WebElement clickConfirmButtonOnApproveTransactionPopup;

	@FindBy(xpath = "//div[contains(@class, 'tab-header') and contains(text(), 'All Actions')]")
	private WebElement clickOnAllActions;

	public static String payout_Remark;
	public static String CustomerRefNo_bulkPayout;
	public static String ExternalRefNo_bulkPayout;
	public static String bene;

	public PayoutMakerCheckerSameEntity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ** Upload Payout ** //

	public static String getRemark() throws IOException {

		return UtilityClass.getDatafromPropertyFile("payoutRemark") + getCurrentTimeStamp();
	}

	public static String getCustomerRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("CustomerRefNo") + getCurrentTimeStamp();
	}

	public static String getExternalRefNo() throws Exception {
		return UtilityClass.getDatafromPropertyFile("ExternalRefNo") + getCurrentTimeStamp();
	}

	public static String getBeneCode() throws IOException {
		return UtilityClass.getDatafromPropertyFile("beneCodeForPayoutMakerChecker");
	}

	// ** click on bulk payout option
	public void ClickOn_Bulk_PayoutOption() throws InterruptedException {
		Thread.sleep(400);
		Bulk_Payout.click();
	}

	// ** click on add bulk payout option
	public void ClickOn_AddBulkPayout() throws InterruptedException {
		Thread.sleep(800);
		Add_BulkPayout.click();
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

	// ** verify bulk payout excel file headers ** //
	public void validateBeneficiaryExcelFileHeaders() {
		String filePath = System.getProperty("user.dir") + "/TestData/Payout file.xlsx";
		String sheetName = "Payout Template";
		List<String> expectedColumnNames = List.of("Customer Id *", "Debit Account No *", "Customer Ref No *",
				"External Ref No *", "Maker Id", "Checker Id", "Txn Type *", "Amount *", "Req Mode *", "Ben Code",
				"Ben Name", "Ben Ifsc", "Ben Account No", "Ben Email", "Ben Mobile", "Remarks");

		List<String> missingColumns = validateColumns(filePath, sheetName, expectedColumnNames);

		if (missingColumns.isEmpty()) {
			System.out.println("All expected columns are present in sheet '" + sheetName + "'.");
		} else {
			System.err.println("The following columns are missing in sheet '" + sheetName + "':");
			for (String columnName : missingColumns) {
				System.err.println("- " + columnName);
			}
		}
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("ddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;

	}

	public void insertDataIntoExcel(String excelFilePath) throws Exception {

		// Initialize FileInputStream to read the Excel file
		FileInputStream inputStream = new FileInputStream(excelFilePath);

		// Initialize Workbook using XSSFWorkbook
		Workbook workbook = new XSSFWorkbook(inputStream);

		// Get the first sheet from the workbook
		Sheet sheet = workbook.getSheetAt(0);

		// ** ** //
		CustomerRefNo_bulkPayout = getCustomerRefNo();
		ExternalRefNo_bulkPayout = getExternalRefNo();
		payout_Remark = getRemark();

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
		System.out.println(getBeneCode());
		columnDataMap.put("Ben Code", new String[] { getBeneCode() });
		columnDataMap.put("Ben Name", new String[] { UtilityClass.getDatafromPropertyFile("BenName") });
		columnDataMap.put("Ben Ifsc", new String[] { UtilityClass.getDatafromPropertyFile("BenIFSC") });
		columnDataMap.put("Ben Account No",
				new String[] { UtilityClass.getDatafromPropertyFile("beneAccountNoForPayoutMakerChecker") });
		columnDataMap.put("Ben Email", new String[] { UtilityClass.getDatafromPropertyFile("BenEmail") });
		columnDataMap.put("Ben Mobile", new String[] { UtilityClass.getDatafromPropertyFile("BenMobile") });
		columnDataMap.put("Remarks", new String[] { payout_Remark });

		for (Map.Entry<String, String[]> entry : columnDataMap.entrySet()) {
			String columnName = entry.getKey();
			String[] data = entry.getValue();

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

	// ** check initiated status after successfully uploading Payout file ** //

	public void checkSuccessStatusForPayoutMakerCheckerSameEntity() throws Exception {

		System.out.println(
				"Executing methos : PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity()");

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Get the page source
		String pageSource = driver.getPageSource();

		// Check if the desired string is present
		boolean isPresent = pageSource.contains(payout_Remark);

		// Assert that the string is present on the page
		Assert.assertTrue(isPresent, "" + payout_Remark + "' is present on the page.");
		System.out.println(payout_Remark + " is present on the page.");

		try {
			// Check Initiated status
			WebElement Initiated_status = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'"
							+ payout_Remark + "')]//button[contains(text(), 'Success')]")));

			if (Initiated_status.isDisplayed()) {

				System.out.println(
						"PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity() -- after successfully uploading the bulk Payout file , initiated status is displayed . ");

				driver.navigate().refresh();

			} else {

				Assert.fail("Error in Method : PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity() -- Initiated status is not displayed on the screen for " + payout_Remark);

			}
			// ** check the Load status after refreshing the page ** //

			// check Success status
			WebElement Success_status = driver
					.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + payout_Remark
							+ "')]//button[contains(text(), 'Success')]"));

			// ** check No of Valid Records ** //
			Thread.sleep(1000);

			if (Success_status.isDisplayed()) {
				System.out.println("PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity() -- After refreshing the page load status has changed initiated to Success");

				WebElement ClickOnValidRecord = driver
						.findElement(By.xpath("//tr[contains(td/button/text(), 'Success') and contains(.,'"
								+ payout_Remark + "')]/td[contains(text(), '1') and @style]"));

				ClickOnValidRecord.click();

			} else {
				// If the Success status is not displayed, assert failure
				Assert.fail("Error in Method : PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity() --  Success status is not displayed on the screen after refreshing for " + payout_Remark);

				// ** if status shows as failed click on Invalid records , and print the failure
				// reason ** //
				WebElement ClickOnInValidRecord = driver
						.findElement(By.xpath("//td[contains(@class, 'makeShortReason')]"));

				ClickOnInValidRecord.click();

				Thread.sleep(1000);

				System.err.println("Error in Method : PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity() --  Failed Status reason : " + ClickOnInValidRecord);
			}
		} catch (Exception e) {

			System.err.println("Error in method : "
					+ "PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity()");
			throw e;
		}
	}
	// ** click on payout approval list ** //

	public void clickOnPayoutApprovalListOption() throws InterruptedException {

		Thread.sleep(500);

		clickOnPayoutApprovalListOption.click();
	}

	// ** approve payout from checker 1

	public void approvePayoutFromCheckerUser_01() throws InterruptedException {

		System.out.println("Executing Method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_01()");

		Thread.sleep(3000);
		try {

			WebElement clickOnApprove = driver.findElement(
					By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + payout_Remark + "')]"));

			if (clickOnApprove.isDisplayed()) {

				Assert.assertTrue(true, payout_Remark);
				System.out.println("Payout is displaying in payout approval list for Payout checker user 01");

				// ** Click on Approve button to approve the payout ** //

				WebElement clickOnApproveOption = driver.findElement(By.xpath("//td[text()='" + payout_Remark
						+ "']/following-sibling::td[@class='text-center']/img[@src='assets/icons/svg/rightclick.svg']"));
				clickOnApproveOption.click();

				// ** enter reason in approve transaction popup ** //
				Thread.sleep(500);
				enterApprovalReason
						.sendKeys(UtilityClass.getDatafromPropertyFile("enterPayoutRemarkForChecker_User01"));

				// ** Click on Confirm button ** //
				Thread.sleep(500);
				clickConfirmButtonOnApproveTransactionPopup.click();

				System.out.println("PayoutMakerCheckerSameEntity.checkSuccessStatusForPayoutMakerCheckerSameEntity() --  Payout approved successfully from checker user : "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"));

			} else {
				System.err.println("Error in method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_01()");

				Assert.fail("Payout is Not displaying in payout approval list for Payout checker user 01");

			}

		} catch (Exception e) {
			System.err.println("Error in method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_01()");

			System.err.println(e);
		}
	}

	// ** approve payout from checker 2

	public void approvePayoutFromCheckerUser_02() throws InterruptedException {

		System.out.println("Executing Method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_02()");

		Thread.sleep(3000);
		try {

			WebElement clickOnApprove = driver.findElement(
					By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + payout_Remark + "')]"));

			if (clickOnApprove.isDisplayed()) {

				Assert.assertTrue(true, payout_Remark);
				System.out.println("Payout is displaying in payout approval list for Payout checker user 02");

				// ** Click on Approve button to approve the payout ** //

				WebElement clickOnApproveOption = driver.findElement(By.xpath("//td[text()='" + payout_Remark
						+ "']/following-sibling::td[@class='text-center']/img[@src='assets/icons/svg/rightclick.svg']"));
				clickOnApproveOption.click();

				// ** enter reason in approve transaction popup ** //
				Thread.sleep(500);
				enterApprovalReason
						.sendKeys(UtilityClass.getDatafromPropertyFile("enterPayoutRemarkForChecker_User02"));

				// ** Click on Confirm button ** //
				Thread.sleep(500);
				clickConfirmButtonOnApproveTransactionPopup.click();

				System.out.println("Payout approved successfully from checker user : "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser02"));

			} else {
				System.err.println("Error in method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_02()");

				Assert.fail("Payout is Not displaying in payout approval list for Payout checker user 02");

			}

		} catch (Exception e) {
			System.err.println("Error in method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_02()");

			System.err.println(e);
		}
	}

	// ** approve payout from checker 3

	public void approvePayoutFromCheckerUser_03() throws InterruptedException {

		System.out.println("Executing Method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_02()");

		Thread.sleep(3000);
		try {

			WebElement clickOnApprove = driver.findElement(
					By.xpath("//tbody[@class='ng-star-inserted']//tr[contains(.,'" + payout_Remark + "')]"));

			if (clickOnApprove.isDisplayed()) {

				Assert.assertTrue(true, payout_Remark);
				System.out.println("Payout is displaying in payout approval list for Payout checker user 03");

				// ** Click on Approve button to approve the payout ** //

				WebElement clickOnApproveOption = driver.findElement(By.xpath("//td[text()='" + payout_Remark
						+ "']/following-sibling::td[@class='text-center']/img[@src='assets/icons/svg/rightclick.svg']"));
				clickOnApproveOption.click();

				// ** enter reason in approve transaction popup ** //
				Thread.sleep(500);
				enterApprovalReason
						.sendKeys(UtilityClass.getDatafromPropertyFile("enterPayoutRemarkForChecker_User03"));

				// ** Click on Confirm button ** //
				Thread.sleep(500);
				clickConfirmButtonOnApproveTransactionPopup.click();

				System.out.println("Payout approved successfully from checker user : "
						+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser03"));

			} else {
				System.err.println("Error in method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_03()");

				Assert.fail("Payout is Not displaying in payout approval list for Payout checker user 03");

			}

		} catch (Exception e) {
			System.err.println("Error in method : PayoutMakerCheckerSameEntity.approvePayoutFromUser_03()");

			System.err.println(e);
		}
	}

	public void clickOnAllActions_CheckerUser() throws InterruptedException {

		Thread.sleep(2000);

		clickOnAllActions.click();
	}
	
	// ** check payout status after approving the payout from same user approval list **//
		public void verify_ApprovalStatusInAllActionsFor_SameEntityApprovalUser() throws IOException, InterruptedException {

			Thread.sleep(2000);

			System.out.println(
					"Executing Method : PayoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_SameEntityApprovalUser()");

			String xpath = "//tr[td[contains(text(), '" + payout_Remark + "')]]/td[2]/button[text()=' Success ']";
			WebElement Status = driver.findElement(By.xpath(xpath));

			// Check if the status is displayed
			boolean isDisplayed = Status.isDisplayed();
			System.out.println(isDisplayed + " - Status is displayed for User : "
					+ UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01"));

			// Assert that the status is displayed
			Assert.assertTrue(isDisplayed, "Status is not displayed as expected for User: "
					+ UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01"));

		}

	// ** check payout status after approving the payout from user 1 **//

	public void verify_ApprovalStatusInAllActionsFor_CheckerUser01() throws IOException, InterruptedException {

		Thread.sleep(2000);

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_CheckerUser01()");

		String xpath = "//tr[td[contains(text(), '" + payout_Remark + "')]]/td[2]/button[text()=' Pending Approval ']";
		WebElement Status = driver.findElement(By.xpath(xpath));

		// Check if the status is displayed
		boolean isDisplayed = Status.isDisplayed();
		System.out.println(isDisplayed + " - Status is displayed for User : "
				+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"));

		// Assert that the status is displayed
		Assert.assertTrue(isDisplayed, "Status is not displayed as expected for User: "
				+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"));

	}
	
	// ** check payout status after approving the payout from user 2 **//

	public void verify_ApprovalStatusInAllActionsFor_CheckerUser02() throws IOException, InterruptedException {

		Thread.sleep(2000);

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_CheckerUser02()");

		String xpath = "//tr[td[contains(text(), '" + payout_Remark + "')]]/td[2]/button[text()=' Pending Approval ']";
		WebElement Status = driver.findElement(By.xpath(xpath));

		// Check if the status is displayed
		boolean isDisplayed = Status.isDisplayed();
		System.out.println(isDisplayed + " - Status is displayed for User : "
				+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"));

		// Assert that the status is displayed
		Assert.assertTrue(isDisplayed, "Status is not displayed as expected for User: "
				+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"));

	}

	
	// ** check payout status after approving the payout from user 3 **//
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser03() throws IOException, InterruptedException {

		Thread.sleep(2000);

		System.out.println(
				"Executing Method : PayoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_CheckerUser03()");

		String xpath = "//tr[td[contains(text(), '" + payout_Remark + "')]]/td[2]/button[text()=' Success ']";
		WebElement Status = driver.findElement(By.xpath(xpath));

		// Check if the status is displayed
		boolean isDisplayed = Status.isDisplayed();
		System.out.println(isDisplayed + " - Status is displayed for User : "
				+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser03"));

		// Assert that the status is displayed
		Assert.assertTrue(isDisplayed, "Status is not displayed as expected for User: "
				+ UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser03"));

	}

}
