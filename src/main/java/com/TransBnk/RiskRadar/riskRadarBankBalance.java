package com.TransBnk.RiskRadar;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class riskRadarBankBalance {

	private static final Object currentDate = null;

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"LMS\"]/img[1]")
	private WebElement clickOnRiskRadar;

	@FindBy(xpath = "//a[contains(.,'Bank Balance')]")
	private WebElement clickOnBankBalance;

	@FindBy(xpath = "//h5[contains(.,'Bank Account Master')]")
	private WebElement bankBalancePage;

	@FindBy(xpath = "//button[contains(.,'Fetch')]")
	private WebElement clickOnFetchButton;

	@FindBy(xpath = "//a[contains(.,'Transactions')]")
	private WebElement clickOnTransactionOption;

	public riskRadarBankBalance(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// ** click on risk radar option **//
	public void clickOnRiskRadar() throws InterruptedException {

		System.out.println("Executing method : " + "riskRadarBankBalance.clickOnRiskRadar()");

		Thread.sleep(1500);

		clickOnRiskRadar.click();

	}

	// ** Clcik on Bank balance ** //

	public void clickOnBankBalance() throws InterruptedException {

		System.out.println("Executing method : " + "riskRadarBankBalance.clickOnBankBalance()");

		Thread.sleep(200);

		clickOnBankBalance.click();

	}

	// ** verifying after click on bank balance navigating on correct page or not

	public void verifyBankBalancePage() throws InterruptedException {

		System.out.println("Executing method : " + "riskRadarBankBalance.verifyBankBalancePage()");

		Thread.sleep(500);

		String stringBankBalancePage = bankBalancePage.getText();

		String expectedPage = "Bank Account Master";

		Assert.assertEquals(stringBankBalancePage, expectedPage,
				"After clicking on the bank balance option, the page did not display the expected text.");

	}

	public static String getCurrentDateTime() {
		// Get current date
		Date currentDate = new Date();

		// Format date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDateTime = dateFormat.format(currentDate);
		System.out.println("Current Date and Time : " + formattedDateTime);

		return formattedDateTime;
	}

	public static String currentDateTime = getCurrentDateTime();

	public static String yesterdaysDate() throws InterruptedException {
		System.out.println("current date : " + currentDateTime);
		// Get today's date
		LocalDate currentDate = LocalDate.now();

		// Subtract one day to get yesterday's date
		LocalDate yesterdayDate = currentDate.minusDays(1);

		// Format the date if needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String formattedYesterdayDate = yesterdayDate.format(formatter);

		return formattedYesterdayDate;
	}

	// ** click on fetch button ** //

	public void clickOnFetchButton() throws InterruptedException, IOException {

		System.out.println("executing Method : riskRadarBankBalance.clickOnFetchButton()");
		try {
			// click on fetch button
			Thread.sleep(300);

			clickOnFetchButton.click();

			Thread.sleep(2000);

			System.out.println("clicked on Fetch button");

			//
			// //tbody/tr[.//td[contains(., '18450200003603')]]/td[contains(., '06-03-2024
			// 08:15:35')]

//		// Get all rows containing the entries
//		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
//		// Iterate through each row
//		for (int i = 0; i < rows.size(); i++) {
//			// Get the text containing the date and time
//			String dateTimeText = rows.get(i).findElement(By.xpath("./td[last()-1]")).getText();
//
//			// Check if the text matches the expected value "06-03-2024 08:15:35"
//			if (dateTimeText.equals("06-03-2024 08:15:35")) {
//				System.out.println("For entry at row " + (i + 1) + ", the value has not changed.");
//			} else {
//				System.out.println("For entry at row " + (i + 1) + ", the value has changed.");
//			}
//		}
//	}
		} catch (NoSuchElementException e) {
			System.err.println(e);
			System.err.println("Error in Method : riskRadarBankBalance.clickOnFetchButton()");
		}
	}

	// ** check Balance fetch on date and time ** //

	public void checkBalanceFetchDateAndTime_Bank_INDB() throws IOException, InterruptedException {

		System.out.println("executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime()");

		Thread.sleep(3000);

		try {
			// ** bank INDB ** //
			WebElement customerNoINDB = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoINDB")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(customerNoINDB.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoINDB")
							+ " in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoINDB") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ " After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoINDB")
					+ " in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}
	}

	// ** bank UTIB ** //

	public void checkBalanceFetchDateAndTime_Bank_UTIB() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_UTIB()");

		try {

			WebElement accountNoUTIB = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoUTIB")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoUTIB.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoUTIB")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoUTIB") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ " After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoUTIB")
					+ " in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}
	}

	// ** bank RATN ** //

	public void checkBalanceFetchDateAndTime_Bank_RATN() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_RATN()");

		try {

			WebElement accountNoRATN = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoRATN")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoRATN.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoRATN")
							+ " in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoRATN") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ " After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoRATN")
					+ " in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}
	}

	// ** Bank YES**//

	public void checkBalanceFetchDateAndTime_Bank_YesBank() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_YesBank()");

		try {
			WebElement accountICIC = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoYesBank")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountICIC.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoYesBank")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoYesBank") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoYesBank")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}
	}

	// ** Bank ICIC**//

	public void checkBalanceFetchDateAndTime_Bank_ICICI() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_ICICI()");

		try {
			WebElement accountICIC = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountICIC")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountICIC.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountICIC")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountICIC") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountICIC")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}

	}

	// ** Federal Bank**//

	public void checkBalanceFetchDateAndTime_Bank_Federal() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_Federal()");

		try {
			WebElement accountNoFDRL = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoFDRL")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoFDRL.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoFDRL")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoFDRL") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoFDRL")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}

	}

	// ** YES Bank**//

	public void checkBalanceFetchDateAndTime_Bank_YES() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_YES()");

		try {
			WebElement accountNoYesBank = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoYesBank")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoYesBank.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoYesBank")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoYesBank") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoYesBank")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}

	}

	// ** AXIS Bank**//

	public void checkBalanceFetchDateAndTime_Bank_AXIS() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_AXIS()");

		try {
			WebElement accountNoAXIS = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoAXIS")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoAXIS.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoAXIS")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoAXIS") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoAXIS")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}

	}

	// ** KOTAK mahendra Bank**//

	public void checkBalanceFetchDateAndTime_Bank_KKBK() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_KKBK()");

		try {
			WebElement accountNoKKBK = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoKKBK")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoKKBK.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoKKBK")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoKKBK") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoKKBK")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}

	}

	// ** HDFC Bank**//

	public void checkBalanceFetchDateAndTime_Bank_HDFC() throws IOException {

		System.out.println("Executing method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_HDFC()");

		try {
			WebElement accountNoHDFC = driver.findElement(
					By.xpath("//tbody//tr[td[contains(.,'" + UtilityClass.getDatafromPropertyFile("accountNoHDFC")
							+ "')]]/td[contains(.,'" + currentDateTime + "')]"));

			Assert.assertTrue(accountNoHDFC.isDisplayed(),
					"After click on Fetch button , for account number "
							+ UtilityClass.getDatafromPropertyFile("accountNoHDFC")
							+ "in Balance fetched On column Current date and Timing has not changed");

			System.out.println("Displaying the correct date and time for the bank account  number "
					+ UtilityClass.getDatafromPropertyFile("accountNoHDFC") + "");

		} catch (Exception e) {
			System.err.println("Error in  method : " + "riskRadarBankBalance.checkBalanceFetchDateAndTime() "
					+ "After click on Fetch button , for account number "
					+ UtilityClass.getDatafromPropertyFile("accountNoHDFC")
					+ "in Balance fetched On column Current date and Timing has not changed");

			System.err.println(e);
		}

	}

	// **Verify if the balance has been fetched for the uploaded bank account** //

	public void checkBankBalance() {

		System.out.println("executing method :" + "riskRadarBankBalance.checkBankBalance()");
		try {

			// ** Bank INDB ** //
			WebElement bankBalanceINDB = driver.findElement(
					By.xpath("//tbody/tr/td[2][contains(., '" + UtilityClass.getDatafromPropertyFile("accountNoINDB")
							+ "')]/following-sibling::td[5][normalize-space() != '']"));

			String bankBalanceValue = bankBalanceINDB.getText().trim();

			// check Assert that the bank balance value is not null
			if (bankBalanceValue.isEmpty()) {
				System.err.println("Bank balance value is null for bank account number "
						+ UtilityClass.getDatafromPropertyFile("accountNoINDB") + "");
			} else {
				System.out.println("Bank balance value : " + bankBalanceValue + " For Bank Account Number : "
						+ UtilityClass.getDatafromPropertyFile("accountNoINDB"));
			}

			// ** Bank RATN ** //
			WebElement accountNoRATN = driver.findElement(
					By.xpath("//tbody/tr/td[2][contains(., '" + UtilityClass.getDatafromPropertyFile("accountNoRATN")
							+ "')]/following-sibling::td[5][normalize-space() != '']"));

			String bankBalanceValue1 = accountNoRATN.getText().trim();

			// check Assert that the bank balance value is not null
			if (bankBalanceValue1.isEmpty()) {
				System.err.println("Bank balance value is null for bank account number "
						+ UtilityClass.getDatafromPropertyFile("accountNoRATN") + "");
			} else {
				System.out.println("Bank balance value : " + bankBalanceValue1 + " For Bank Account Number : "
						+ UtilityClass.getDatafromPropertyFile("accountNoRATN"));
			}

			// ** Bank UTIB ** //

			WebElement accountNoUTIB = driver.findElement(
					By.xpath("//tbody/tr/td[2][contains(., '" + UtilityClass.getDatafromPropertyFile("accountNoUTIB")
							+ "')]/following-sibling::td[5][normalize-space() != '']"));

			String bankBalanceValue2 = accountNoUTIB.getText().trim();

			// check Assert that the bank balance value is not null
			if (bankBalanceValue2.isEmpty()) {
				System.err.println("Bank balance value is null for bank account number "
						+ UtilityClass.getDatafromPropertyFile("accountNoUTIB") + "");
			} else {
				System.out.println("Bank balance value : " + bankBalanceValue2 + " For Bank Account Number : "
						+ UtilityClass.getDatafromPropertyFile("accountNoUTIB"));
			}

			// ** Bank ICIC

			WebElement accountICIC = driver.findElement(
					By.xpath("//tbody/tr/td[2][contains(., '" + UtilityClass.getDatafromPropertyFile("accountICIC")
							+ "')]/following-sibling::td[5][normalize-space() != '']"));

			String bankBalanceValue3 = accountICIC.getText().trim();

			// check Assert that the bank balance value is not null
			if (bankBalanceValue3.isEmpty()) {
				System.err.println("Bank balance value is null for bank account number "
						+ UtilityClass.getDatafromPropertyFile("accountICIC") + "");
			} else {
				System.out.println("Bank balance value : " + bankBalanceValue3 + " For Bank Account Number : "
						+ UtilityClass.getDatafromPropertyFile("accountICIC"));
			}

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error in method :" + "riskRadarBankBalance.checkBankBalance()");
		}
	}

	public void clickOnTransactionOption() throws InterruptedException {

		System.out.println("Executing method : " + "riskRadarBankBalance.clickOnTransactionOption()");

		Thread.sleep(500);

		clickOnTransactionOption.click();
	}

	// click on fetch button on transaction page

	public void clickOnFetchButtonOntransactionPage() throws InterruptedException {

		clickOnFetchButton.click();

		System.out.println("Clicked on Fetch button on Transaction page");

		Thread.sleep(5000);
	}

	public void checkTransactionAccountBal() throws InterruptedException {

		Thread.sleep(2000);

		System.out.println("Executing Method : " + " riskRadarBankBalance.checkTransactionAccountBal()");
		int page = 1;
		boolean isTrue = true;
		while (true) {
//			System.out.println("Checking page " + page);

			// Find all transaction rows
			List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
//			System.out.println("Found " + rows.size() + " transaction rows on page " + page);
			for (int i = 0; i < rows.size(); i++) {

				try {
					WebElement row = rows.get(i);
					// Re-find the transaction amount element within the row
					WebElement transactionAmountElement = row.findElement(By.xpath("td[6]"));
					// Extract the transaction amount
					String transactionAmountString = transactionAmountElement.getText();

					// Check if the transaction amount starts with "INR"
					if (transactionAmountString.startsWith("INR")) {
//						System.out.println("Transaction amount found for row " + (i + 1) + " on page " + page + ": "
//								+ transactionAmountString);
					} else {
						isTrue = false;
						System.err.println("Transaction amount not found for row " + (i + 1) + " on page " + page);
					}

				} catch (StaleElementReferenceException e) {
					// If the element becomes stale, retry finding it
					rows = driver.findElements(By.cssSelector("tbody tr"));
					i--;

				} catch (NoSuchElementException e) {
					// If the element is not found, log and continue to the next row
					System.out.println("Element not found for row " + (i + 1) + " on page " + page
							+ ". Continuing to the next row...");
					System.err.println(e);
				}
			}

			// Check if the "Next" button exists
			try {
//				System.out.println("Checking for the 'Next' button...");
				WebElement nextButton = driver
						.findElement(By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
//				System.out.println("Clicking the 'Next' button...");
				// Click the "Next" button
				nextButton.click();
				Thread.sleep(100);
			} catch (Exception e) {

				System.err.println("Error in method: " + "riskRadarBankBalance.checkTransactionAccountBal()"
						+ " The 'Next' button is not found. Exiting the loop.");
				break;
			}

			// Increment the page counter
			page++;
		}
		if (!isTrue) {
			Assert.fail("Transaction amount not found on page " + page);
		}

		// ** click on page number 1 ** //
		driver.findElement(By.xpath("//*[@id=\"transactionPagination\"]/pagination-template/ul/li[3]")).click();

	}

	public void checkNullorZeroTransAmountForBankTransaction() throws InterruptedException {

		Thread.sleep(3000);

		System.out.println("Executing Method: riskRadarBankBalance.checkNullorZeroTransAmountForBankTransaction()");
		int page = 1;
		boolean isTrue = true;
		boolean isNextButtonVisible = true; // to control the loop

		while (isNextButtonVisible) {
			// Find all transaction rows
			List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
//			System.out.println("Found " + rows.size() + " transaction rows on page " + page);

			for (int i = 0; i < rows.size(); i++) {
				try {
					WebElement row = rows.get(i);
					// Store bank name
					WebElement bankElement = row.findElement(By.xpath("td[1]"));
					String bank = bankElement.getText();

					// Find the transaction amount element within the row
					WebElement transactionAmountElement = row.findElement(By.xpath("td[6]"));

					// Extract the transaction amount
					String transactionAmountString = transactionAmountElement.getText();
//					
//					System.out.println("Original Transaction Amount: " + transactionAmountString);

					// Remove "INR" prefix and trim the result

					String transactionAmountWithoutINR = transactionAmountString.replace("INR", "").trim();

//					System.out.println(" Transaction Amount: " + transactionAmountWithoutINR);

					// ** Check if the transaction amount is null or empty **
					if (transactionAmountWithoutINR == null || transactionAmountWithoutINR.isEmpty()) {
						System.err.println("Found Null Transaction Amount for " + bank + " , row " + (i + 1)
								+ " on page " + page + ": " + transactionAmountString);
						isTrue = false;

					} else {
//						System.out.println("Transaction is not null");
					}
				} catch (StaleElementReferenceException e) {
					// If the element becomes stale, retry finding it
//					System.err.println(
//							"StaleElementReferenceException for row " + (i + 1) + " on page " + page + ". Retrying...");
					rows = driver.findElements(By.cssSelector("tbody tr"));
					i--; // Decrement i to retry the same row

				} catch (NoSuchElementException e) {
					// If the element is not found, log and continue to the next row
					System.err.println(
							"NoSuchElementException for row " + (i + 1) + " on page " + page + ". Skipping...");
				}
			}

			// Check if the "Next" button exists and is enabled
			try {
				WebElement nextButton = driver
						.findElement(By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
				if (nextButton.isDisplayed() && nextButton.isEnabled()) {
					nextButton.click();
					Thread.sleep(500);
					page++;
				} else {
					isNextButtonVisible = false;
				}
			} catch (NoSuchElementException e) {
//				System.err.println("The 'Next' button is not found or disabled. Exiting the loop.");
				isNextButtonVisible = false;
			} catch (Exception e) {
//				System.err.println("Unexpected error occurred: " + e.getMessage());
				break;
			}
		}

		if (!isTrue) {
			Assert.fail("Invalid transaction amount detected.");
		}

		// Click on page number 1 to return to the first page
		try {
			driver.findElement(By.xpath("//*[@id=\"transactionPagination\"]/pagination-template/ul/li[3]")).click();
		} catch (NoSuchElementException e) {
//			System.err.println("Page number 1 button not found. Please check the pagination element.");
		}

	}
//	
//	// ** check Duplicate Ref NO
//
//		public void checkDuplicateTransactionEntries() throws InterruptedException {
//			Thread.sleep(2000);
//			System.out.println("Executing Method: riskRadarBankBalance.checkDuplicateTransactionEntries()");
//			int page = 1;
//			boolean isTrue = true;
//			Set<String> combinations = new HashSet<>();
//
//			while (true) {
//				List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
//
//				for (WebElement row : rows) {
//					try {
//						// Find elements within the row
//						WebElement bankElement = row.findElement(By.xpath("td[1]"));
//						WebElement accountNoElement = row.findElement(By.xpath("td[2]"));
//						WebElement refNoElement = row.findElement(By.xpath("td[5]"));
//						WebElement transAmountElement = row.findElement(By.xpath("td[6]"));
//						WebElement transDateElement = row.findElement(By.xpath("td[9]"));
//						WebElement remarksElement = row.findElement(By.xpath("td[10]"));
//						WebElement transTypeElement = row.findElement(By.xpath("td[7]"));
//
//						// Get text values
//						String bank = bankElement.getText();
//						String accountNo = accountNoElement.getText();
//						String refNo = refNoElement.getText();
//						String transAmount = transAmountElement.getText();
//						String transDate = transDateElement.getText();
//						String remarks = remarksElement.getText();
//						String transType = transTypeElement.getText();
//
//						// Check if reference number is null
//						if (refNo.equals("Null")) {
//							// Create a combination string based on other attributes
//							String combination = "account no - " + accountNo + " , Trans Date - " + "Trans Amount - "
//									+ transAmount + "," + "Trans Type : " + transType + " , Remarks : " + remarks
//									+ " ,Bank : ";
//
//							// Check if combination already exists
//							if (combinations.contains(combination)) {
//								System.err.println("Duplicate combination found for NULL reference number: " + combination
//										+ " on page - " + page);
//								isTrue = false;
//							} else {
//								combinations.add(combination);
//							}
//						} else {
//							// Create a combination string
//							String combination = "account no - " + accountNo + " , Ref No - " + refNo + " , Trans Date - "
//									+ "Trans Amount - " + transAmount + ";" + transDate + "Trans Type : " + transType
//									+ "  , Remarks - " + remarks + " , Bank - " + bank;
//
//							// Check if combination already exists
//							if (combinations.contains(combination)) {
////									System.err.println(accountNo + "," + refNo);
//								System.err.println("Duplicate combination found for reference number " + refNo + ": "
//										+ combination + " on page " + page + " For " + bank);
//
//								isTrue = false;
//
//							} else {
//								combinations.add(combination);
//							}
//						}
//
//					} catch (StaleElementReferenceException e) {
//						rows = driver.findElements(By.cssSelector("tbody tr"));
//					}
//				}
//
//				// Check if the "Next" button exists and is enabled
//				WebElement nextButton = null;
//				try {
//					nextButton = driver
//							.findElement(By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
//				} catch (Exception e) {
////							System.err.println(
////									"Error in method: riskRadarBankBalance.checkDuplicateCombination() The 'Next' button is not found. Exiting the loop.");
//					break;
//				}
//
//				String disabledAttribute = nextButton.getAttribute("disabled");
//				if (disabledAttribute != null && disabledAttribute.equals("true")) {
//					break;
//				}
//
//				// ** Click the "Next" button
//				nextButton.click();
//				Thread.sleep(300);
//				page++;
//			}
//
//			if (!isTrue) {
//				Assert.fail("Duplicate combination found on page " + page);
//			}
//		}

	public void checkTransactionAccountDate() throws InterruptedException {
		Thread.sleep(3000);

		System.out.println("Executing Method : " + "riskRadarBankBalance.checkTransactionAccountDate()");

		DateTimeFormatter initialFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Get yesterday's date
		LocalDate yesterdayDate = LocalDate.now().minusDays(1);
		String formattedYesterdayDate = yesterdayDate.format(outputFormatter);
		int page = 1;
		boolean isTrue = false; // Initialize the flag to false

		while (true) {
//			System.out.println("Checking page " + page);

			// Find all transaction rows
			List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
//			System.out.println("Found " + rows.size() + " transaction rows on page " + page);

			for (int i = 0; i < rows.size(); i++) {

				try {

					WebElement row = rows.get(i);
					WebElement transactionDateElement = row.findElement(By.xpath("td[9]"));

					String transactionDateString = transactionDateElement.getText();

					// Parse the initial string to LocalDate
					LocalDate transactionDate = LocalDate.parse(transactionDateString, initialFormatter);

					// Format transactionDate to match currentDate format
					String formattedTransactionDate = transactionDate.format(outputFormatter);

//					System.out.println("formattedTransactionDate " + formattedTransactionDate);
//					System.out.println("currentdate" + currentDateTime);

					if (formattedTransactionDate.equals(formattedYesterdayDate)
							|| formattedTransactionDate.equals(currentDateTime)) {
						// System.out.println(
//								"Transaction found on date for row : " + transactionDateString + " on page " + page);
						isTrue = true; // Set the flag to true if any transaction is found on yesterday's date

					} else {
						isTrue = false;
						System.err.println("Transaction not found for row  " + (i + 1) + " On date : "
								+ transactionDateString + " on page " + page);

					}
				} catch (StaleElementReferenceException e) {
					// If the element becomes stale, retry finding it
					rows = driver.findElements(By.cssSelector("tbody tr"));
					i--;
				} catch (NoSuchElementException e) {
					// If the element is not found, log and continue to the next row
					System.out.println("Element not found for row " + (i + 1) + ". Continuing to the next row...");
					System.err.println(e);
				} catch (DateTimeParseException e) {
					System.err.println("Error parsing transaction date for row " + (i + 1) + ": " + e.getMessage());
					System.err.println(e);
				}
			}

			// Check if the "Next" button exists
			try {
				WebElement nextButton = driver
						.findElement(By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
				nextButton.click(); // Click the "Next" button
				Thread.sleep(100);

			} catch (Exception e) {
				System.err.println("The 'Next' button is not found. Exiting the loop.");
				break;
			}

			// Increment the page counter
			page++;
		}

		if (!isTrue) {
			Assert.fail("Transaction not found on current date for row " + " on page " + page);
		}

	}

	public void clickOnFirstPage() throws InterruptedException {

		Thread.sleep(800);

		System.out.println("Executing Method : " + "riskRadarBankBalance.clickOnFirstPage()");
		// ** click on page number 1 ** //

		WebElement firstPage = driver
				.findElement(By.xpath("//*[@id=\"transactionPagination\"]/pagination-template/ul/li[3]"));

		Actions action = new Actions(driver);

		action.moveToElement(firstPage).click().build().perform();

	}

	// ** check Duplicate Ref NO

	public void checkDuplicateTransactionEntries() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Executing Method: riskRadarBankBalance.checkDuplicateTransactionEntries()");
		int page = 1;
		boolean isTrue = true;
		Set<String> combinations = new HashSet<>();

		while (true) {
			List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

			for (WebElement row : rows) {
				try {
					// Find elements within the row
					WebElement bankElement = row.findElement(By.xpath("td[1]"));
					WebElement accountNoElement = row.findElement(By.xpath("td[2]"));
					WebElement refNoElement = row.findElement(By.xpath("td[5]"));
					WebElement transAmountElement = row.findElement(By.xpath("td[6]"));
					WebElement transDateElement = row.findElement(By.xpath("td[9]"));
					WebElement remarksElement = row.findElement(By.xpath("td[10]"));
					WebElement transTypeElement = row.findElement(By.xpath("td[7]"));

					// Get text values
					String bank = bankElement.getText();
					String accountNo = accountNoElement.getText();
					String refNo = refNoElement.getText();
					String transAmount = transAmountElement.getText();
					String transDate = transDateElement.getText();
					String remarks = remarksElement.getText();
					String transType = transTypeElement.getText();

					// Check if reference number is null
					if (refNo.equals("Null")) {
						// Create a combination string based on other attributes
						String combination = "account no - " + accountNo + " , Trans Date - " + "Trans Amount - "
								+ transAmount + "," + "Trans Type : " + transType + " , Remarks : " + remarks
								+ " ,Bank : ";

						// Check if combination already exists
						if (combinations.contains(combination)) {
							System.err.println("Duplicate combination found for NULL reference number: " + combination
									+ " on page - " + page);
							isTrue = false;
						} else {
							combinations.add(combination);
						}
					} else {
						// Create a combination string
						String combination = "account no - " + accountNo + " , Ref No - " + refNo + " , Trans Date - "
								+ "Trans Amount - " + transAmount + ";" + transDate + "Trans Type : " + transType
								+ "  , Remarks - " + remarks + " , Bank - " + bank;

						// Check if combination already exists
						if (combinations.contains(combination)) {
//							System.err.println(accountNo + "," + refNo);
							System.err.println("Duplicate combination found for reference number " + refNo + ": "
									+ combination + " on page " + page + " For " + bank);

							isTrue = false;

						} else {
							combinations.add(combination);
						}
					}

				} catch (StaleElementReferenceException e) {
					rows = driver.findElements(By.cssSelector("tbody tr"));
				}
			}

			// Check if the "Next" button exists and is enabled
			WebElement nextButton = null;
			try {
				nextButton = driver
						.findElement(By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
			} catch (Exception e) {
//					System.err.println(
//							"Error in method: riskRadarBankBalance.checkDuplicateCombination() The 'Next' button is not found. Exiting the loop.");
				break;
			}

			String disabledAttribute = nextButton.getAttribute("disabled");
			if (disabledAttribute != null && disabledAttribute.equals("true")) {
				break;
			}

			// ** Click the "Next" button
			nextButton.click();
			Thread.sleep(300);
			page++;
		}

		if (!isTrue) {
			Assert.fail("Duplicate combination found on page " + page);
		}
	}

	public void checkNullAccountBalForBankTransaction() throws InterruptedException {

		System.out.println("Executing Method: riskRadarBankBalance.checkNullAccountBalForBankTransaction()");
		int page = 1;
		boolean isTrue = true;
		boolean isNextButtonVisible = true; // to control the loop

		while (isNextButtonVisible) {

			// Find all transaction rows
			List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
//			System.out.println("Found " + rows.size() + " transaction rows on page " + page);

			for (int i = 0; i < rows.size(); i++) {
				try {
					WebElement row = rows.get(i);

					// Store bank name
					WebElement bankElement = row.findElement(By.xpath("td[1]"));
					String bank = bankElement.getText();

					// Find the transaction Bal element within the row
					WebElement transactionAmountElement = row.findElement(By.xpath("td[8]"));

					// Extract the transaction Bal

					String transactionAmountString = transactionAmountElement.getText();
//					System.out.println("Original Transaction Bal: " + transactionAmountString);

					// Remove "INR" prefix and trim the result
					String transactionBalWithoutINR = transactionAmountString.replace("INR", "").trim();
//					System.out.println("Processed Transaction Amount: " + transactionBalWithoutINR);

					// ** Check if the transaction Bal is null or empty **
					if (transactionBalWithoutINR == null || transactionBalWithoutINR.isEmpty()) {
						System.err.println("Found Null Transaction for " + bank + " , row " + (i + 1) + " on page "
								+ page + ": " + transactionAmountString);
						isTrue = false;
					} else {
//						System.out.println("Transaction is not null");
					}
				} catch (StaleElementReferenceException e) {
					// If the element becomes stale, retry finding it
//					System.err.println(
//							"StaleElementReferenceException for row " + (i + 1) + " on page " + page + ". Retrying...");
					rows = driver.findElements(By.cssSelector("tbody tr"));
					i--; // Decrement i to retry the same row

				} catch (NoSuchElementException e) {
					// If the element is not found, log and continue to the next row
					System.err.println(
							"NoSuchElementException for row " + (i + 1) + " on page " + page + ". Skipping...");
				}
			}

			// Check if the "Next" button exists and is enabled
			try {
				WebElement nextButton = driver
						.findElement(By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
				if (nextButton.isDisplayed() && nextButton.isEnabled()) {
					nextButton.click();
					Thread.sleep(500);
					page++;
				} else {
					isNextButtonVisible = false;
				}
			} catch (NoSuchElementException e) {
//				System.err.println("The 'Next' button is not found or disabled. Exiting the loop.");
				isNextButtonVisible = false;
			} catch (Exception e) {
//				System.err.println("Unexpected error occurred: " + e.getMessage());
				break;
			}
		}

		if (!isTrue) {
			Assert.fail("Error in method : Invalid transaction Bal detected.");
		}

		// Click on page number 1 to return to the first page
		try {
			driver.findElement(By.xpath("//*[@id=\"transactionPagination\"]/pagination-template/ul/li[3]")).click();
		} catch (NoSuchElementException e) {
//			System.err.println("Page number 1 button not found. Please check the pagination element.");
		}
	}
}
