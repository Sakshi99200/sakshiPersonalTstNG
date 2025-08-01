package com.TransBnk.RiskRadar;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckFilterOptionRiskRadar {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"filter-btn\"]")
	private WebElement clickOnFilterOnBankBalancePage;

	@FindBy(xpath = "//*[@id=\"bankCode\"]")
	private WebElement clickOnBankOption;

	@FindBy(xpath = "//*[@id=\"accountNumber\"]")
	private WebElement clickOnAccountNumberOption;

	@FindBy(xpath = "//*[@id=\"overlay\"]/div/div/form/div[3]/input")
	private WebElement clickOnCustomerReferenceNumberOption;

	@FindBy(xpath = "//*[@id=\"overlay\"]/div/div/form/div[4]/input")
	private WebElement clickOnCustomerNameOption;

	@FindBy(xpath = "//*[@id=\"overlay\"]/div/div/div[2]/div[1]")
	private WebElement clickOnResetButton;

	@FindBy(xpath = "//*[@id=\"overlay\"]/div/div/form/div[1]/input")
	private WebElement clickOnBankOptionOnTransactionPage;

	@FindBy(xpath = "//*[@id=\"filter-btn\"]/button")
	private WebElement clickOnFilterOnTransactionPageOnTransactionPage;

	public CheckFilterOptionRiskRadar(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// bankNames as a class-level variable
	private Set<String> bankNames = new HashSet<>();

	// Check filter on bank balance
	public void checkBankFilterOnBankBalancePage() {
		System.out.println("Executing method: CheckFilterOptionRiskRadar.checkFilterOnBankBalancePage()");
		try {

			Thread.sleep(1500);
//			// Extract bank names
			bankNames = extractUniqueBankNames();

			// Validate bank names in the filter dropdown
			validateBankNamesInDropdown(bankNames);

			Thread.sleep(1500);

			// bank name
			for (String bank : bankNames) {
				// Apply filter option
				applyFilterBankName(bank);

				Thread.sleep(2000);

				// Check if the filtered result contains the expected bank name
				boolean isBankPresent = isBankPresentInFilteredResults(bank);

				Assert.assertTrue(isBankPresent, "Bank " + bank + " not found in filtered results.");
			}

		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.checkFilterOnBankBalancePage()");
			System.out.println(e);
		}
	}

	private Set<String> extractUniqueBankNames() {

		try {

			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));

			for (WebElement row : rows) {

				String bankName = row.findElement(By.xpath("./td[1]")).getText().trim();
				bankNames.add(bankName);
				System.out.println("bank name :" + bankName);
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.extractUniqueBankNames()");
			System.out.println(e);
		}
		return bankNames;
	}

	private void applyFilterBankName(String bankName) {
		try {
			// ** click on filter option
			Thread.sleep(2000);
			// ** click on filter option
			Thread.sleep(2000);
			clickOnFilterOnBankBalancePage.click();
			// ** click on Bank option
			Thread.sleep(2000);
			clickOnBankOption.click();
			boolean found = false;

			List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id=\"bankCode\"]/option"));

			// Iterate through the options and click on the one that matches the bank name
			for (WebElement option : dropdownOptions) {
				if (option.getText().trim().equalsIgnoreCase(bankName)) {
					option.click();
					found = true;
					break;
				}
			}

			Assert.assertTrue(found, "Bank name '" + bankName + "' not found in dropdown options.");

			// ** Click on apply filter button
			WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/div[2]/div[2]"));
			applyButton.click();
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.applyFilter()");
			System.out.println(e);
		}
	}

	private void validateBankNamesInDropdown(Set<String> bankNames) {
		try {
			Thread.sleep(1500);
			// ** dropdown options
			List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id=\"bankCode\"]/option"));

			// ** Collect bank names from dropdown options
			Set<String> dropdownBankNames = new HashSet<>();
			for (WebElement option : dropdownOptions) {
				dropdownBankNames.add(option.getText().trim());
			}

			// ** Fail the test if any bank name is duplicated in the dropdown options
			for (String bankName : dropdownBankNames) {
				int occurrences = Collections.frequency(dropdownBankNames, bankName);
				Assert.assertEquals(occurrences, 1, "Bank name '" + bankName + "' is duplicated in dropdown options.");
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.validateBankNamesInDropdown()");
			System.out.println(e);
		}
	}

	private boolean isBankPresentInFilteredResults(String bankName) {
		try {
			// Check if the bank name is present in the filtered results
			List<WebElement> filteredRows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));
			for (WebElement row : filteredRows) {
				String displayedBankName = row.findElement(By.xpath("./td[1]")).getText().trim();
				if (displayedBankName.equalsIgnoreCase(bankName)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.isBankPresentInFilteredResults()");
			System.out.println(e);
		}
		return false;
	}

	// ** to click on Reset option

	public void clickOnResetButton() throws InterruptedException {

		// click on Filter option

		Thread.sleep(1000);
		clickOnFilterOnBankBalancePage.click();

		Thread.sleep(1000);

		// click on reset button

		clickOnResetButton.click();
	}

	// ** Check Account number filter on bank balance

	public void checkAccountNumberFilterOnBankBalancePage() {

		System.out.println("Executing method: CheckFilterOptionRiskRadar.checkFilterOnBankBalancePage()");

		try {

			Thread.sleep(1500);
			// Extract unique account numbers from the table
			Set<String> accountNumbers = extractUniqueAccountNumbers();

			// Iterate through each account number
			for (String accountNumber : accountNumbers) {
				// Apply filter option
				applyFilter(accountNumber);

				Thread.sleep(2000);
				// Check if the filtered result contains the expected account number
				boolean isAccountNumberPresent = isAccountNumberPresentInFilteredResults(accountNumber);

				// Assert that the account number is present in filtered results
				Assert.assertTrue(isAccountNumberPresent,
						"Account number " + accountNumber + " not found in filtered results.");
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.checkFilterOnBankBalancePage()");
			System.out.println(e);
		}
	}

	private Set<String> extractUniqueAccountNumbers() {
		Set<String> accountNumbers = new HashSet<>();
		try {

			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));

			// Iterate over each row
			for (WebElement row : rows) {
				// Extract the account number from the second column
				String accountNumber = row.findElement(By.xpath("./td[2]")).getText().trim();
				accountNumbers.add(accountNumber);
				System.out.println("Account number :" + accountNumber);
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.extractUniqueAccountNumbers()");
			System.out.println(e);
		}
		return accountNumbers;
	}

	private void applyFilter(String accountNumber) {
		try {

			// ** click on filter option
			Thread.sleep(2000);

			// ** click on filter option
			Thread.sleep(2000);
			clickOnFilterOnBankBalancePage.click();

			// ** click on Account Number option
			Thread.sleep(2000);

			clickOnAccountNumberOption.click();
			boolean found = false;

			// Locate the input field for the account number
			WebElement accountNumberField = driver.findElement(By.xpath("//input[@id='accountNumber']"));

			// Clear any existing text in the field
			accountNumberField.clear();

			// Enter the account number into the field
			accountNumberField.sendKeys(accountNumber);

			// Click on apply filter button
			WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/div[2]/div[2]"));
			applyButton.click();
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.applyFilter()");

			System.out.println(e);
		}
	}

	private boolean isAccountNumberPresentInFilteredResults(String accountNumber) {
		try {
			// Check if the account number is present in the filtered results
			List<WebElement> filteredRows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));
			for (WebElement row : filteredRows) {
				String displayedAccountNumber = row.findElement(By.xpath("./td[2]")).getText().trim();
				if (displayedAccountNumber.equalsIgnoreCase(accountNumber)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.isAccountNumberPresentInFilteredResults()");
			System.out.println(e);
		}
		return false;
	}

	// ** customer reference number

	// Check Customer Reference Number filter on bank balance
	public void checkCustomerReferenceNumberFilterOnBankBalancePage() {
		System.out.println(
				"Executing method: CheckFilterOptionRiskRadar.checkCustomerReferenceNumberFilterOnBankBalancePage()");

		try {
			Thread.sleep(1500);
			// Extract unique customer reference numbers from the table
			Set<String> customerReferenceNumbers = extractUniqueCustomerReferenceNumbers();

			// Iterate through each customer reference number
			for (String customerRefNumber : customerReferenceNumbers) {
				// Apply filter option
				applyFilterByCustomerReferenceNumber(customerRefNumber);

				Thread.sleep(2000);
				// Check if the filtered result contains the expected customer reference number
				boolean isCustomerRefNumberPresent = isCustomerReferenceNumberPresentInFilteredResults(
						customerRefNumber);

				// Assert that the customer reference number is present in filtered results
				Assert.assertTrue(isCustomerRefNumberPresent,
						"Customer reference number " + customerRefNumber + " not found in filtered results.");
			}
		} catch (Exception e) {
			System.out.println(
					"Error in Method: CheckFilterOptionRiskRadar.checkCustomerReferenceNumberFilterOnBankBalancePage()");
			System.out.println(e);
		}
	}

	private Set<String> extractUniqueCustomerReferenceNumbers() {
		Set<String> customerRefNumbers = new HashSet<>();
		try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));

			// Iterate over each row
			for (WebElement row : rows) {
				// Extract the customer reference number from the third column
				String customerRefNumber = row.findElement(By.xpath("./td[3]")).getText().trim();
				customerRefNumbers.add(customerRefNumber);
				System.out.println("Customer Reference Number: " + customerRefNumber);
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.extractUniqueCustomerReferenceNumbers()");
			System.out.println(e);
		}
		return customerRefNumbers;
	}

	private void applyFilterByCustomerReferenceNumber(String customerRefNumber) {
		try {
			// Click on filter option
			Thread.sleep(2000);
			clickOnFilterOnBankBalancePage.click();

			// Click on Customer Reference Number option
			Thread.sleep(2000);
			clickOnCustomerReferenceNumberOption.click();

			// Locate the input field for the customer reference number
			WebElement customerRefNumberField = driver
					.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/form/div[3]/input"));

			// Clear any existing text in the field
			customerRefNumberField.clear();

			// Enter the customer reference number into the field
			customerRefNumberField.sendKeys(customerRefNumber);

			// Click on apply filter button
			WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/div[2]/div[2]"));

			applyButton.click();

			Thread.sleep(700);

		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.applyFilterByCustomerReferenceNumber()");
			System.out.println(e);
		}
	}

	private boolean isCustomerReferenceNumberPresentInFilteredResults(String customerRefNumber) {
		boolean isCustomerRefNumberPresent = false;
		try {
			// Check if the customer reference number is present in the filtered results
			List<WebElement> filteredRows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));
			for (WebElement row : filteredRows) {
				String displayedCustomerRefNumber = row.findElement(By.xpath("./td[3]")).getText().trim();
				if (displayedCustomerRefNumber.equalsIgnoreCase(customerRefNumber)) {

					isCustomerRefNumberPresent = true;

				}
			}
			// Print a message if the customer name is not found
			if (!isCustomerRefNumberPresent) {
				System.out.println("Customer name '" + customerRefNumber + "' not found in filtered results.");
				isCustomerRefNumberPresent = false;

			}
		} catch (Exception e) {
			System.out.println(
					"Error in method: CheckFilterOptionRiskRadar.isCustomerReferenceNumberPresentInFilteredResults()");
			System.out.println(e);
		}
		return false;
	}

	// ** check Customer Reference Number filter

	// Check Customer Name filter on bank balance
	public void checkCustomerNameFilterOnBankBalancePage() {

		System.out.println("Executing method: CheckFilterOptionRiskRadar.checkCustomerNameFilterOnBankBalancePage()");

		try {
			Thread.sleep(1500);
			// Extract unique customer names from the table
			Set<String> customerNames = extractUniqueCustomerNames();

			// Iterate through each customer name
			for (String customerName : customerNames) {
				// Apply filter option
				applyFilterByCustomerName(customerName);

				Thread.sleep(2000);
				// Check if the filtered result contains the expected customer name
				boolean isCustomerNamePresent = isCustomerNamePresentInFilteredResults(customerName);

				// Assert that the customer name is present in filtered results
				Assert.assertTrue(isCustomerNamePresent,
						"Customer name " + customerName + " not found in filtered results.");
			}
		} catch (Exception e) {
			System.out
					.println("Error in Method: CheckFilterOptionRiskRadar.checkCustomerNameFilterOnBankBalancePage()");
			System.out.println(e);
		}
	}

	private Set<String> extractUniqueCustomerNames() {
		Set<String> customerNames = new HashSet<>();
		try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));

			// Iterate over each row
			for (WebElement row : rows) {
				// Extract the customer name from the fourth column
				String customerName = row.findElement(By.xpath("./td[4]")).getText().trim();
				customerNames.add(customerName);
				System.out.println("Customer Name: " + customerName);
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.extractUniqueCustomerNames()");
			System.out.println(e);
		}
		return customerNames;
	}

	private void applyFilterByCustomerName(String customerName) {
		try {
			// Click on filter option
			Thread.sleep(2000);
			clickOnFilterOnBankBalancePage.click();

			// Click on Customer Name option
			Thread.sleep(2000);
			clickOnCustomerNameOption.click();

			// Locate the input field for the customer name
			WebElement customerNameField = driver
					.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/form/div[4]/input"));

			// Clear any existing text in the field
			customerNameField.clear();

			// Enter the customer name into the field
			customerNameField.sendKeys(customerName);

			// Click on apply filter button
			WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/div[2]/div[2]"));
			applyButton.click();
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.applyFilterByCustomerName()");
			System.out.println(e);
		}
	}

	private boolean isCustomerNamePresentInFilteredResults(String customerName) {
		boolean isCustomerNamePresent = false;
		try {
			// Check if the customer name is present in the filtered results
			List<WebElement> filteredRows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));
			for (WebElement row : filteredRows) {
				String displayedCustomerName = row.findElement(By.xpath("./td[4]")).getText().trim();
				if (displayedCustomerName.equalsIgnoreCase(customerName)) {
					isCustomerNamePresent = true;
					break;
				}
			}
			// Print a message if the customer name is not found
			if (!isCustomerNamePresent) {
				System.out.println("Customer name '" + customerName + "' not found in filtered results.");
				isCustomerNamePresent = false;
			}
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.isCustomerNamePresentInFilteredResults()");
			System.out.println(e);
		}
		return isCustomerNamePresent;
	}

	// ** TRANSACTION PAGE FILTER ** //

	// ** bank name filter ** //

	// ** bank filter on transaction page
	public void checkBankFilterOnTransactionPage() {
		System.out.println("Executing method: CheckFilterOptionRiskRadar.checkBankFilterOnTransactionPage()");
		try {
			Thread.sleep(1500);

			for (String bank : bankNames) {
				applyBankFilterOnTransactionPage(bank);

				Thread.sleep(2000);

				boolean isBankNamePresent = isBankPresentInCurrentPageOnTransactionPage(bank);

				if (!isBankNamePresent) {
					System.out.println("Bank " + bank + " not found.");
					printRowNumbersWithoutBankName(bank);
				}
			}
		} catch (Exception e) {
			System.out.println("Error in Method: CheckFilterOptionRiskRadar.checkBankFilterOnTransactionPage()");
			System.out.println(e);
		}
	}

	// Method to apply bank filter on transaction page
	private boolean applyBankFilterOnTransactionPage(String bankName) {
		System.out.println("Executing Method: CheckFilterOptionRiskRadar.applyBankFilterOnTransactionPage()");
		try {
			Thread.sleep(2000);
			clickOnFilterOnTransactionPageOnTransactionPage.click();
			Thread.sleep(2000);
			clickOnBankOptionOnTransactionPage.click();
			clickOnBankOptionOnTransactionPage.clear();
			clickOnBankOptionOnTransactionPage.sendKeys(bankName);
			Thread.sleep(400);
			WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"overlay\"]/div/div/div[2]/div[2]"));
			applyButton.click();

			Thread.sleep(2000);

			// Loop through pages
			int page = 1;
			while (true) {
				if (isBankPresentInCurrentPageOnTransactionPage(bankName)) {
					return true; // Bank found on this page
				}

				// Check if the "Next" button exists and is enabled
				WebElement nextButton = null;
				try {
					nextButton = driver.findElement(
							By.xpath("//pagination-controls//li[@class='pagination-next ng-star-inserted']"));
				} catch (Exception e) {
					System.err.println(
							"Error in method: CheckFilterOptionRiskRadar.applyBankFilterOnTransactionPage(). The 'Next' button is not found. Exiting the loop.");
					break;
				}

				// Click the "Next" button
				nextButton.click();
				Thread.sleep(1500);
				page++;
			}

			System.out.println("Bank " + bankName + " not found on any page.");
			return false; // Bank not found on any page
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.applyBankFilterOnTransactionPage()");
			System.out.println(e);
		}
		return false;
	}

	// Method to check if bank name is present in current page on transaction page
	private boolean isBankPresentInCurrentPageOnTransactionPage(String bankName) {
		try {
			List<WebElement> filteredRows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));
			for (WebElement row : filteredRows) {
				String displayedBankName = row.findElement(By.xpath("./td[1]")).getText().trim();
				if (displayedBankName.equalsIgnoreCase(bankName)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error in method: CheckFilterOptionRiskRadar.isBankPresentInFilteredResults()");
			System.out.println(e);
		}
		return false;
	}

	// Method to print row numbers where the bank name is not found
	private void printRowNumbersWithoutBankName(String bankName) {
		try {
			int rowNumber = 1;
			List<WebElement> filteredRows = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr"));
			boolean bankFound = false;
			for (WebElement row : filteredRows) {
				String displayedBankName = row.findElement(By.xpath("./td[1]")).getText().trim();
				if (!displayedBankName.equalsIgnoreCase(bankName)) {
					System.out.println("Bank " + bankName + " not found on row " + rowNumber);
				}
				rowNumber++;

				if (!bankFound) {
					System.out.println("Bank " + bankName + " not found in filtered rows.");
				}
			}
		} catch (Exception e) {
			System.out.println("Error while printing row numbers without bank name: " + e.getMessage());
		}
	}
//	private void validateBankNamesInDropdownOnTransactionPage(Set<String> bankNames) {
//		try {
//			// ** dropdown options
//			List<WebElement> dropdownOptions = driver.findElements(By.xpath("//*[@id=\"bankCode\"]/option"));
//
//			// ** Collect bank names from dropdown options
//			Set<String> dropdownBankNames = new HashSet<>();
//			for (WebElement option : dropdownOptions) {
//				dropdownBankNames.add(option.getText().trim());
//			}
// ** Fail the test if any bank name is duplicated in the dropdown options
//			for (String bankName : dropdownBankNames) {
//				int occurrences = Collections.frequency(dropdownBankNames, bankName);
//				Assert.assertEquals(occurrences, 1, "Bank name '" + bankName + "' is duplicated in dropdown options.");
//			}
//		} catch (Exception e) {
//			System.out.println(
//					"Error in Method: CheckFilterOptionRiskRadar.validateBankNamesInDropdownOnTransactionPage()");
//			System.out.println(e);
//		}
//	}
}
