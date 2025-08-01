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

public class CheckDownloadCenterForTransaction {
	public WebDriver driver;

	@FindBy(xpath = "//button[contains(.,'Export')]")
	private WebElement clickOnExportButtonOnTransactionPage;

	@FindBy(xpath = "//*[@id=\"DOWNLOAD_CENTER\"]")
	private WebElement clickOnDownloadCenterService;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[9]/ul/a")
	private WebElement reportOption;

	public CheckDownloadCenterForTransaction(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// ** click on export button ** //
	public void clickOnExportButtonOnTransactionPage() throws InterruptedException {
		try {
			System.out.println(
					"Executing method : CheckDownloadCenterForTransaction.clickOnExportButtonOnTransactionPage()");

			Thread.sleep(3000);

			clickOnExportButtonOnTransactionPage.click();

			Thread.sleep(2000);

			// click on Close button
			driver.findElement(By.xpath("//*[@id=\"cancelPopUp\"]")).click();

		} catch (Exception e) {
			System.out.println(
					"Error in method : CheckDownloadCenterForTransaction.clickOnExportButtonOnTransactionPage()");
			System.err.println(e);
		}
	}

	// ** click on download center option to check Transaction report ** //

	public void clickOnDownloadCenterOption() throws InterruptedException {
		try {
			System.out.println("Executing method : CheckDownloadCenterForTransaction.clickOnDownloadCenterOption()");

			// click Download center service

			Thread.sleep(4000);

			Actions a = new Actions(driver);

			a.moveToElement(clickOnDownloadCenterService).build().perform();

			Assert.assertTrue(clickOnDownloadCenterService.isDisplayed(),
					"Download center service is Not displayed on screen");

			clickOnDownloadCenterService.click();

			System.out.println("download center service is  displayed on Transaction Page");
		} catch (Exception e) {
			System.out.println("Error in Method : CheckDownloadCenterForTransaction.clickOnDownloadCenterOption()");
			System.err.println(e);
		}
	}

	public void clickReportsOption() throws InterruptedException {

		System.out.println("Executing method : CheckDownloadCenterForTransaction.clickReportsOption()");
		try {
			// click Reports option

			Thread.sleep(4000);

			Actions a = new Actions(driver);

			a.moveToElement(reportOption).build().perform();

			Assert.assertTrue(reportOption.isDisplayed(), "report option is Not displayed on Transaction Page");

			reportOption.click();

			System.out.println("report option is  displayed on Transaction Page");
		} catch (Exception e) {
			System.out.println("Error in Method : CheckDownloadCenterForTransaction.clickReportsOption()");

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
		System.out.println("Current date : " + TodaysDate);

		return TodaysDate;

	}

	public void checkStatusInDownloadCenterForTransactionReport() throws InterruptedException {

		System.out.println(
				"Execting method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForTransactionReport()");

		WebElement checkQueuedStatus;

		try {
			// check status in downlad center for transaction //

			Thread.sleep(1000);

			checkQueuedStatus = driver.findElement(
					By.xpath("(//tr[td[contains(.,'Transaction')] and td[text()='Risk Radar'] and td[contains(text(), '"
							+ getCurrentDate()
							+ "')]]//button[contains(@class, 'btn-sm') and contains(@class, 'down-orangeStatus') and text()=' Queued '])[1]"));

			Assert.assertTrue(checkQueuedStatus.isDisplayed(),
					"Transaction report is not displayed in Download Center with Queued staus");

			String CheckQueuedStatus = checkQueuedStatus.getText();

			System.out.println("Check Status In Download Center For BankBalance Report : " + CheckQueuedStatus);

			System.out.println("Transaction report is displayed in Download Center with Queued staus ");

		} catch (Exception e) {

			System.err.println(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForTransactionReport() "
							+ e);
			Assert.fail(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForTransactionReport() "
							+ e.getMessage());

		}
		WebElement checkStatusafter4Minutes;

		try {
			// Wait for 4 minutes.
			Thread.sleep(200000);

			driver.navigate().refresh();

			Thread.sleep(2000);

			checkStatusafter4Minutes = driver.findElement(
					By.xpath("(//tr[td[contains(.,'Transaction')] and td[text()='Risk Radar'] and td[contains(text(), '"
							+ getCurrentDate()
							+ "')]]//button[contains(@class, 'btn-sm') and contains(@class, 'down-darkGreenStatus') and text()=' Ready '])[1]"));

			Assert.assertTrue(checkStatusafter4Minutes.isDisplayed(),
					"Transaction report is not displayed in Download Center with Ready staus ");

			String CheckStatusafter4Minutes = checkStatusafter4Minutes.getText();

			System.out.println("Check Status In Download Center For Transaction Report status after 4 minutes : "
					+ CheckStatusafter4Minutes);

			System.out.println("Transaction report is displayed in Download Center with Ready staus ");

		} catch (Exception e) {

			System.err.println(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
							+ e);
			Assert.fail(
					"Error in method : CheckDownloadCenterForBankBalance.checkStatusInDownloadCenterForBankBalanceReport() "
							+ e.getMessage());
		}
	}

}
