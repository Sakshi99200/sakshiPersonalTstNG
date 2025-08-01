package com.TransBnk.SanityTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SanityTestingFlow {

	@FindBy(xpath = "//*[@id=\"HOME\"]")
	private WebElement clickOnHomeService;

	@FindBy(xpath = "(//a[contains(@class, 'subitem') and text()='Dashboard'])[1]")
	private WebElement dashboardOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[2]/li")
	private WebElement clickOnRadarServices;

	@FindBy(xpath = "//a[contains(@class, 'subitem') and text()='Bank Balance']")
	private WebElement bankBalanceOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[2]/ul/a[2]")
	private WebElement transactionsOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[2]/ul/a[3]")
	private WebElement ruleManagerOption;

	@FindBy(xpath = "//*[@id=\"REGN\"]")
	private WebElement clickOnDocuflowService;

	@FindBy(xpath = "//a[contains(@class, 'subitem') and text()='Templates']")
	private WebElement templateOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[3]/ul/a[2]")
	private WebElement dealsOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[3]/ul/a[3]")
	private WebElement dealVerificationOption;

	@FindBy(xpath = "//*[@id=\"PAYOUTS\"]")
	private WebElement clickOnPayoutsService;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[4]/ul/a[1]")
	private WebElement accountMasterOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[4]/ul/a[2]")
	private WebElement beneficiaryListOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[4]/ul/a[3]")
	private WebElement bulkBeneficiaryOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[4]/ul/a[4]")
	private WebElement payoutListOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[4]/ul/a[5]")
	private WebElement bulkPayoutOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[4]/ul/a[6]")
	private WebElement payoutApprovalListOption;

	@FindBy(xpath = "//*[@id=\"UPI_AUTOPAY\"]")
	private WebElement clickOnUPIAutopayService;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[5]/ul/a[1]")
	private WebElement UPIautopayDashboardOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[5]/ul/a[2]")
	private WebElement mandateStatusOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[5]/ul/a[3]")
	private WebElement UPICollectOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[5]/ul/a[4]")
	private WebElement UPIBulkCollectOption;

	@FindBy(xpath = "//*[@id=\"ACCOUNT_VALIDATION\"]")
	private WebElement clickOnAccountValidationSevice;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[6]/ul/a[1]")
	private WebElement singleAccountValidationOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[6]/ul/a[2]")
	private WebElement bulkAccountValidationOption;

	@FindBy(xpath = "//*[@id=\"DIGITAL_LEDGER\"]")
	private WebElement clickOnDigitalLenderservice;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[7]/ul/a[1]")
	private WebElement DLCCodeOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[7]/ul/a[2]")
	private WebElement DLCCreditOption;

	@FindBy(xpath = "//*[@id=\"NACH\"]")
	private WebElement clickOnNACHService;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[8]/ul/a[1]")
	private WebElement NACHDashboardOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[8]/ul/a[2]")
	private WebElement NACHDetailsOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[8]/ul/a[3]")
	private WebElement NACHRequestOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[8]/ul/a[4]")
	private WebElement NACHBulkRequestOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[8]/ul/a[5]")
	private WebElement NACHDebitOption;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[8]/ul/a[6]")
	private WebElement NACHBulkDebitOption;

	@FindBy(xpath = "//*[@id=\"DOWNLOAD_CENTER\"]")
	private WebElement clickOnDownloadCenterService;

	@FindBy(xpath = "/html/body/app-root/app-base-layout/div[2]/div[1]/div/ul/div[9]/ul/a")
	private WebElement reportOption;

	public WebDriver driver;

	public SanityTestingFlow(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// ** validate home service ** //

	public void validateHomeService() throws InterruptedException {

		Thread.sleep(4000);
		// click on home service

		clickOnHomeService.click();

		Actions a = new Actions(driver);

		a.moveToElement(clickOnHomeService).build().perform();

		Assert.assertTrue(clickOnHomeService.isDisplayed(), "Home service is Not displayed on screen");

		System.out.println("Home service is  displayed on screen");

		// verify dashboard
		Thread.sleep(4000);

		Assert.assertTrue(dashboardOption.isDisplayed(), "DashBoard option is Not present on screen");

		dashboardOption.click();

		System.out.println("Dashboard option is  displayed on screen");

	}

	// ** validate Risk radar service ** //

	public void validateRiskRadarService() throws InterruptedException {

		// click on risk radar service
		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(clickOnRadarServices).build().perform();

		Assert.assertTrue(clickOnRadarServices.isDisplayed(), "Risk radar service is Not displayed on screen");

		a.moveToElement(clickOnRadarServices).click().build().perform();

//		clickOnRadarService.click();

		System.out.println("Risk radar service is  displayed on screen");
	}

	public void validateBankBalanceOption() throws InterruptedException {
		// verify bank balance option

		Thread.sleep(4000);

		Assert.assertTrue(bankBalanceOption.isDisplayed(), " Bank balance option is Not present on screen");

		bankBalanceOption.click();

		System.out.println("Bank balance option is  displayed on screen");
	}

	public void validateTransactionOption() throws InterruptedException {
		// verify Transaction option

		Thread.sleep(4000);

		Assert.assertTrue(transactionsOption.isDisplayed(), " Transaction option is Not present on screen");

		transactionsOption.click();

		System.out.println("transactions option is  displayed on screen");
	}

	public void validateRuleManagerOption() throws InterruptedException {
		// verify rule manager option

		Thread.sleep(4000);

		Assert.assertTrue(ruleManagerOption.isDisplayed(), " rule manager option is Not present on screen");

		ruleManagerOption.click();

		System.out.println("rule manager option is  displayed on screen");
	}

	public void validateDocuflowService() throws InterruptedException {
		// click on Docuflow service

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(clickOnDocuflowService).build().perform();

		Assert.assertTrue(clickOnDocuflowService.isDisplayed(), "Docuflow service is Not displayed on screen");

		clickOnDocuflowService.click();

		System.out.println("docuflow service is  displayed on screen");
	}

	public void validateTemplateOption() throws InterruptedException {
		// verify Template option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(templateOption).build().perform();

		Assert.assertTrue(templateOption.isDisplayed(), " Template option is Not present on screen");

		templateOption.click();

		System.out.println("Template option is  displayed on screen");
	}

	public void validateDealsOption() throws InterruptedException {
		// verify Deals option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(dealsOption).build().perform();

		Assert.assertTrue(dealsOption.isDisplayed(), " deals option is Not present on screen");

		dealsOption.click();

		System.out.println("Deals option is  displayed on screen");
	}

	public void validateDealVerification() throws InterruptedException {

		// verify Deal verification option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(dealVerificationOption).build().perform();

		Assert.assertTrue(dealVerificationOption.isDisplayed(), " deal verification option is Not present on screen");

		dealVerificationOption.click();

		System.out.println("Deal verification option is  displayed on screen");
	}

	public void validatePayoutService() throws InterruptedException {
		// click on payouts service

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(clickOnPayoutsService).build().perform();

		Assert.assertTrue(clickOnPayoutsService.isDisplayed(), "Payouts service is Not displayed on screen");

		clickOnPayoutsService.click();

		System.out.println("Payouts service is  displayed on screen");
	}

	public void validateAccountMasterOption() throws InterruptedException {
		// verify account master option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(accountMasterOption).build().perform();

		Assert.assertTrue(accountMasterOption.isDisplayed(), " account master option is Not present on screen");

		accountMasterOption.click();

		System.out.println("account master option is  displayed on screen");
	}

	public void validateBeneficiaryListOption() throws InterruptedException {
		// verify Beneficiary list option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(beneficiaryListOption).build().perform();

		Assert.assertTrue(beneficiaryListOption.isDisplayed(), " beneficiary list option is Not present on screen");

		beneficiaryListOption.click();

		System.out.println("beneficiary list option is  displayed on screen");
	}

	public void validateBulkBeneficiaryOption() throws InterruptedException {
		// verify bulk Beneficiary option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(bulkBeneficiaryOption).build().perform();

		Assert.assertTrue(bulkBeneficiaryOption.isDisplayed(), " bulk beneficiary option is Not present on screen");

		bulkBeneficiaryOption.click();

		System.out.println(" bulk beneficiary option is  displayed on screen");
	}

	public void validatePayoutListOptoin() throws InterruptedException {
		// verify payout list option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(payoutListOption).build().perform();

		Assert.assertTrue(payoutListOption.isDisplayed(), " payout list option is Not present on screen");

		payoutListOption.click();

		System.out.println("payout list option is  displayed on screen");
	}

	public void validateBulkPayoutOPtion() throws InterruptedException {
		// verify bulk payout option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(bulkPayoutOption).build().perform();

		Assert.assertTrue(bulkPayoutOption.isDisplayed(), " bulk payout option is Not present on screen");

		bulkPayoutOption.click();

		System.out.println(" bulk payout option is  displayed on screen");
	}

	public void validatePayoutApprovalListOption() throws InterruptedException {
		// verify payout approval list option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(payoutApprovalListOption).build().perform();

		Assert.assertTrue(payoutApprovalListOption.isDisplayed(),
				" payout approval list option is Not present on screen");

		payoutApprovalListOption.click();

		System.out.println(" payout approval list option is  displayed on screen");
	}

	public void validateUPIAutopayService() throws InterruptedException {
		// click on UPI Autopay service

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(clickOnUPIAutopayService).build().perform();

		Assert.assertTrue(clickOnUPIAutopayService.isDisplayed(), "UPI autopay service is Not displayed on screen");

		clickOnUPIAutopayService.click();

		System.out.println("UPI autopay service is  displayed on screen");

	}

	public void validateDashBoardOption() throws InterruptedException {
		// verify Dashboard option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(UPIautopayDashboardOption).build().perform();

		Assert.assertTrue(UPIautopayDashboardOption.isDisplayed(),
				" UPI autopay dashboard option is Not present on screen");

		UPIautopayDashboardOption.click();

		System.out.println(" UPI autopay dashboard option is  displayed on screen");
	}

	public void validateMandateStatusOption() throws InterruptedException {
		// Validate mandate status

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(mandateStatusOption).build().perform();

		Assert.assertTrue(mandateStatusOption.isDisplayed(), " mandate status option is Not present on screen");

		mandateStatusOption.click();

		System.out.println(" mandate status option is  displayed on screen");

	}

	public void validateUPICollectOption() throws InterruptedException {
		// Validate UPI Collect

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(UPICollectOption).build().perform();

		Assert.assertTrue(UPICollectOption.isDisplayed(), " UPI Collect option is Not present on screen");

		UPICollectOption.click();

		System.out.println(" UPI Collect option is  displayed on screen");

	}

	public void validateUPIBulkCollectOption() throws InterruptedException {
		// Validate UPI Bulk Collect

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(UPIBulkCollectOption).build().perform();

		Assert.assertTrue(UPIBulkCollectOption.isDisplayed(), " UPI Bulk Collect option is Not present on screen");

		UPIBulkCollectOption.click();

		System.out.println(" UPI Bulk Collect option is  displayed on screen");

	}

	public void validateAccountValidationService() throws InterruptedException {
		// click on Account validation service

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(clickOnAccountValidationSevice).build().perform();

		Assert.assertTrue(clickOnAccountValidationSevice.isDisplayed(),
				"Account validation service is Not displayed on screen");

		clickOnAccountValidationSevice.click();

		System.out.println("Account validation service is  displayed on screen");

	}

	public void validateSingleAccountValidationOption() throws InterruptedException {
		// Validate Single account Validation option

		Thread.sleep(4000);

		Assert.assertTrue(singleAccountValidationOption.isDisplayed(),
				" Single account validation option is Not present on screen");

		singleAccountValidationOption.click();

		System.out.println(" Single account validation option is  displayed on screen");

	}

	public void validateBulkAccountValidationOption() throws InterruptedException {
		// Validate Bulk account Validation option

		Thread.sleep(4000);

		Assert.assertTrue(bulkAccountValidationOption.isDisplayed(),
				" bulk account validation option is Not present on screen");

		bulkAccountValidationOption.click();

		System.out.println(" bulk account validation option is  displayed on screen");

	}

	public void validateDigitalLedgerService() throws InterruptedException {
		// click on digital ledger service

		Thread.sleep(4000);

		Assert.assertTrue(clickOnDigitalLenderservice.isDisplayed(),
				"Digital ledger service is Not displayed on screen");

		clickOnDigitalLenderservice.click();

		System.out.println("Digital Ledger service is  displayed on screen");

	}

	public void validateDLCCodeOption() throws InterruptedException {
		// Validate DLC Code option

		Thread.sleep(4000);

		Assert.assertTrue(DLCCodeOption.isDisplayed(), " DLC Code option is Not present on screen");

		DLCCodeOption.click();

		System.out.println(" DLC Code option is  displayed on screen");

	}

	public void validateDLCCreditOption() throws InterruptedException {
		// Validate DLC Credit option

		Thread.sleep(4000);

		Assert.assertTrue(DLCCreditOption.isDisplayed(), " DLC Credit option is Not present on screen");

		DLCCreditOption.click();

		System.out.println(" DLC Credit option is  displayed on screen");

	}

	public void validateNACHService() throws InterruptedException {
		// click on NACH service

		Thread.sleep(5000);

		Assert.assertTrue(clickOnNACHService.isDisplayed(), "NACH service is Not displayed on screen");

		clickOnNACHService.click();

		System.out.println("NACH service is  displayed on screen");

	}

	public void validateNACHDashboardOption() throws InterruptedException {
		// click on NACH dashboard option

		Thread.sleep(4000);

		Assert.assertTrue(NACHDashboardOption.isDisplayed(), "NACH Dashboard option is Not displayed on screen");

		NACHDashboardOption.click();

		System.out.println("NACH dashboard option is  displayed on screen");

	}

	public void validateNACHDetailsOption() throws InterruptedException {
		// click on NACH details option

		Thread.sleep(4000);

		Assert.assertTrue(NACHDetailsOption.isDisplayed(), "NACH Details option is Not displayed on screen");

		NACHDetailsOption.click();

		System.out.println("NACH details option is  displayed on screen");

	}

	public void validateNACHRequestOption() throws InterruptedException {
		// click on NACH request option

		Thread.sleep(4000);

		Assert.assertTrue(NACHRequestOption.isDisplayed(), "NACH request option is Not displayed on screen");

		NACHRequestOption.click();

		System.out.println("NACH request option is  displayed on screen");

	}

	public void validateNACHBulkRequestOption() throws InterruptedException {
		// click on NACH bulk request option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(NACHBulkRequestOption).build().perform();

		Assert.assertTrue(NACHBulkRequestOption.isDisplayed(), "NACH bulk request option is Not displayed on screen");

		NACHBulkRequestOption.click();

		System.out.println("NACH bulk request option is  displayed on screen");

	}

	public void validateNACHDebitOption() throws InterruptedException {
		// click on NACH Debit option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(NACHDebitOption).build().perform();

		Assert.assertTrue(NACHDebitOption.isDisplayed(), "NACH Debit option is Not displayed on screen");

		NACHDebitOption.click();

		System.out.println("NACH Debit option is  displayed on screen");

	}

	public void validateNACHBulkDebitOption() throws InterruptedException {
		// click on NACH Bulk Debit option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(NACHBulkDebitOption).build().perform();

		Assert.assertTrue(NACHBulkDebitOption.isDisplayed(), "NACH Bulk Debit option is Not displayed on screen");

		NACHBulkDebitOption.click();

		System.out.println("NACH Bulk Debit option is  displayed on screen");

	}

	public void validateDownloadCenterService() throws InterruptedException {
		// click Download center service

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(clickOnDownloadCenterService).build().perform();

		Assert.assertTrue(clickOnDownloadCenterService.isDisplayed(),
				"Download center service is Not displayed on screen");

		clickOnDownloadCenterService.click();

		System.out.println("download center service is  displayed on screen");

	}

	public void validateReportsOption() throws InterruptedException {
		// click Reports option

		Thread.sleep(4000);

		Actions a = new Actions(driver);

		a.moveToElement(reportOption).build().perform();

		Assert.assertTrue(reportOption.isDisplayed(), "report option is Not displayed on screen");

		reportOption.click();

		System.out.println("report option is  displayed on screen");

	}

}
