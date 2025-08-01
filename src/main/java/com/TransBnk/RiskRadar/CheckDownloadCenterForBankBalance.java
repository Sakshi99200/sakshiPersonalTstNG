package com.TransBnk.RiskRadar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckDownloadCenterForBankBalance {

	public WebDriver driver;

	@FindBy(xpath = "//button[contains(.,'Export')]")
	private WebElement clickOnExportButtonOnBankBalancePage;

	@FindBy(xpath = "//*[@id=\"DOWNLOAD_CENTER\"]")
	private WebElement clickOnDownloadCenterService;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[9]/ul/a")
	private WebElement reportOption;

	public CheckDownloadCenterForBankBalance(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// ** click on export button ** //
	public void clickOnExportButtonOnBankBalancePage() throws InterruptedException {
		try {
			System.out.println(
					"Executing method : CheckDownloadCenterForBankBalance.clickOnexportButtonOnBankBalancePage()");

			Thread.sleep(3000);

			clickOnExportButtonOnBankBalancePage.click();

			// click on close button

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"cancelPopUp\"]")).click();

		} catch (Exception e) {
			System.out.println(
					"Error in Method : CheckDownloadCenterForBankBalance.clickOnExportButtonOnBankBalancePage()");
			System.err.println(e);
		}
	}

	// ** click on download center option to check bank balance report ** //

	public void clickOnDownloadCenterOption() throws InterruptedException {

		System.out.println("Executing method : CheckDownloadCenterForBankBalance.clickOnDownloadCenterOption()");

		try {
			// click Download center service

			Thread.sleep(4000);

			Actions a = new Actions(driver);

			a.moveToElement(clickOnDownloadCenterService).build().perform();

			Assert.assertTrue(clickOnDownloadCenterService.isDisplayed(),
					"Download center service is Not displayed on screen");

			clickOnDownloadCenterService.click();

			System.out.println("download center service is  displayed on screen");
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error in method : CheckDownloadCenterForBankBalance.clickOnDownloadCenterOption()"
					+ "download center service is not displayed on screen");
		}
	}

	public void clickReportsOption() throws InterruptedException {

		System.out.println("Executing method : CheckDownloadCenterForBankBalance.clickReportsOption()");

		// click Reports option

		try {
			Thread.sleep(4000);

			Actions a = new Actions(driver);

			a.moveToElement(reportOption).build().perform();

			Assert.assertTrue(reportOption.isDisplayed(), "report option is Not displayed on Bank Balance Page");

			reportOption.click();

			System.out.println("report option is  displayed on Bank Balance Page");
		} catch (Exception e) {
			System.out.println("Error in method : CheckDownloadCenterForBankBalance.clickReportsOption()");
			System.err.println(e);
		}

	}

	// to enter todays date
	public static String TodaysDate;

	public static String getCurrentDate() {

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Define the format you want (dd-MM-yyyy)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Format the current date
		String TodaysDate = currentDate.format(formatter);

		// Print the formatted date
		System.out.println("Current date in custom format (dd-MM-yyyy): " + TodaysDate);

		return TodaysDate;

	}

	public void checkStatusInDownloadCenterForBankBalanceReport() throws InterruptedException {

		System.out.println(
				"Execting method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport()");

		WebElement checkQueuedStatus;
		try {
			// check status in downlad center for bank balance //

			Thread.sleep(3000);

			checkQueuedStatus = driver.findElement(
					By.xpath("(//tr[td[text()='Bank Balance '] and td[text()='Risk Radar'] and td[contains(text(), '"
							+ getCurrentDate()
							+ "')]]//button[contains(@class, 'btn-sm') and contains(@class, 'down-orangeStatus') and text()=' Queued '])[1]"));

			if (checkQueuedStatus.isDisplayed()) {
				String checkQueuedStatusText = checkQueuedStatus.getText();
				System.out.println("Check Status In Download Center For BankBalance Report : " + checkQueuedStatusText);
				System.out.println("Transaction report is displayed in Download Center with Queued status ");
				Assert.assertTrue(true, "Transaction report is displayed in Download Center with Queued status");
			} else {
				System.out.println(
						"Transaction report For BankBalance Report not displayed in Download Center with Queued status");
				Assert.fail(
						"Transaction report For BankBalance Report not displayed in Download Center with Queued status");
			}

		} catch (Exception e) {

			System.err.println(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
							+ e);
			Assert.fail(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
							+ e.getMessage());

		}
		WebElement checkStatusafter4Minutes;
		try {
			// Wait for 4 minutes.
			Thread.sleep(200000);

			driver.navigate().refresh();

			Thread.sleep(2000);

			checkStatusafter4Minutes = driver.findElement(
					By.xpath("(//tr[td[text()='Bank Balance '] and td[text()='Risk Radar'] and td[contains(text(), '"
							+ getCurrentDate()
							+ "')]]//button[contains(@class, 'btn-sm') and contains(@class, 'down-darkGreenStatus') and text()=' Ready '])[1]"));

			if (checkStatusafter4Minutes.isDisplayed()) {
				String checkStatusafter4MinutesText = checkStatusafter4Minutes.getText();
				System.out.println("Check Status In Download Center For Transaction Report status after 4 minutes : "
						+ checkStatusafter4MinutesText);
				System.out.println("Transaction report is displayed in Download Center with Ready status ");
				Assert.assertTrue(true,
						"Transaction report For BankBalance Report displayed in Download Center with Ready status");
			} else {
				System.out.println(
						"Transaction report For BankBalance Report not displayed in Download Center with Ready status");
				Assert.fail(
						"Transaction report For BankBalance Report not displayed in Download Center with Ready status");
			}

		} catch (Exception e) {

			System.err.println(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
							+ e);
			Assert.fail(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
							+ e.getMessage());

		}
//
//		if (checkStatusafter4Minutes.isDisplayed()) {
//
//			Assert.assertTrue(true, CheckStatusafter4Minutes);
//
//			System.out.println("Bank balance report is displayed in Download Center with Ready staus ");
//
//		} else {
//			System.out.println("Bank balance report is not displayed in Download Center with Ready staus ");
//
//			System.err.println(
//					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
//							+ CheckStatusafter4Minutes);
//
//		}

	}

}
