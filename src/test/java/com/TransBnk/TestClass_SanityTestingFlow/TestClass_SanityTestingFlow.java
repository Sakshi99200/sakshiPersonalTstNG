package com.TransBnk.TestClass_SanityTestingFlow;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_SanityTestingFlow extends BaseTest {

	@Test(priority = 1)
	public void validateSelect_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void validateSelect_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 3)
	public void validateHomeService() throws InterruptedException {

		sanityTestingFlow.validateHomeService();
	}

	@Test(priority = 4)
	public void validateRiskRadarService() throws InterruptedException {

		sanityTestingFlow.validateRiskRadarService();

		deal_without_template.ThreadSleep();
	}

	@Test(priority = 5)
	public void validateBankBalanceOption() throws InterruptedException {

		sanityTestingFlow.validateBankBalanceOption();
	}

	@Test(priority = 6)
	public void validateTransactionOption() throws InterruptedException {

		sanityTestingFlow.validateRiskRadarService();

		sanityTestingFlow.validateTransactionOption();
	}

	@Test(priority = 7)
	public void validateRuleManagerOption() throws InterruptedException {
		sanityTestingFlow.validateRiskRadarService();

		sanityTestingFlow.validateRuleManagerOption();
	}

	@Test(priority = 8)
	public void validateDocuflowService() throws InterruptedException {

		sanityTestingFlow.validateDocuflowService();

	}

	@Test(priority = 9)
	public void validateTemplateOption() throws InterruptedException {

		sanityTestingFlow.validateTemplateOption();
	}

	@Test(priority = 10)
	public void validateDealsOption() throws InterruptedException {

		sanityTestingFlow.validateDocuflowService();

		sanityTestingFlow.validateDealsOption();
	}

	@Test(priority = 11)
	public void validateDealVerification() throws InterruptedException {

		sanityTestingFlow.validateDocuflowService();

		sanityTestingFlow.validateDealVerification();
	}

	@Test(priority = 12)
	public void validatePayoutService() throws InterruptedException {

		sanityTestingFlow.validatePayoutService();

	}

	@Test(priority = 13)
	public void validateAccountMasterOption() throws InterruptedException {

		sanityTestingFlow.validateAccountMasterOption();

	}

	@Test(priority = 14)
	public void validateBeneficiaryListOption() throws InterruptedException {

		sanityTestingFlow.validatePayoutService();

		sanityTestingFlow.validateBeneficiaryListOption();
	}

	@Test(priority = 15)
	public void validateBulkBeneficiaryOption() throws InterruptedException {

		sanityTestingFlow.validatePayoutService();

		sanityTestingFlow.validateBulkBeneficiaryOption();
	}

	@Test(priority = 16)
	public void validatePayoutListOptoin() throws InterruptedException {

		sanityTestingFlow.validatePayoutService();

		sanityTestingFlow.validatePayoutListOptoin();
	}

	@Test(priority = 17)
	public void validateBulkPayoutOPtion() throws InterruptedException {

		sanityTestingFlow.validatePayoutService();

		sanityTestingFlow.validateBulkPayoutOPtion();
	}

	@Test(priority = 18)
	public void validatePayoutApprovalListOption() throws InterruptedException {

		sanityTestingFlow.validatePayoutService();

		sanityTestingFlow.validatePayoutApprovalListOption();
	}

	@Test(priority = 19)
	public void validateUPIAutopayService() throws InterruptedException {

		sanityTestingFlow.validateUPIAutopayService();

	}

	@Test(priority = 20)
	public void validateDashBoardOption() throws InterruptedException {

		sanityTestingFlow.validateDashBoardOption();

	}

	@Test(priority = 21)
	public void validateMandateStatusOption() throws InterruptedException {

		sanityTestingFlow.validateUPIAutopayService();

		sanityTestingFlow.validateMandateStatusOption();
	}

	@Test(priority = 22)
	public void validateUPICollectOption() throws InterruptedException {

		sanityTestingFlow.validateUPIAutopayService();

		sanityTestingFlow.validateUPICollectOption();
	}

	@Test(priority = 23)
	public void validateAccountValidationService() throws InterruptedException {

		sanityTestingFlow.validateAccountValidationService();
	}

	@Test(priority = 24)
	public void validateSingleAccountValidationOption() throws InterruptedException {

		sanityTestingFlow.validateSingleAccountValidationOption();
	}

	@Test(priority = 25)
	public void validateBulkAccountValidationOption() throws InterruptedException {

		sanityTestingFlow.validateAccountValidationService();

		sanityTestingFlow.validateBulkAccountValidationOption();
	}

	@Test(priority = 26)
	public void validateDigitalLedgerService() throws InterruptedException {

		sanityTestingFlow.validateDigitalLedgerService();
	}

	@Test(priority = 27)
	public void validateDLCCodeOption() throws InterruptedException {

		sanityTestingFlow.validateDigitalLedgerService();

		sanityTestingFlow.validateDLCCodeOption();
	}

	@Test(priority = 28)
	public void validateUPIBulkCollectOption() throws InterruptedException {

		sanityTestingFlow.validateDigitalLedgerService();

		sanityTestingFlow.validateDLCCreditOption();
	}

	@Test(priority = 29)
	public void validateNACHService() throws InterruptedException {

		sanityTestingFlow.validateNACHService();
	}

	@Test(priority = 30)
	public void validateNACHDashboardOption() throws InterruptedException {

		sanityTestingFlow.validateNACHService();

		sanityTestingFlow.validateNACHDashboardOption();
	}

	@Test(priority = 31)
	public void validateNACHDetailsOption() throws InterruptedException {

		sanityTestingFlow.validateNACHService();

		sanityTestingFlow.validateNACHDetailsOption();
	}

	@Test(priority = 32)
	public void validateNACHRequestOption() throws InterruptedException {
		sanityTestingFlow.validateNACHService();
		sanityTestingFlow.validateNACHRequestOption();
	}

	@Test(priority = 33)
	public void validateNACHBulkRequestOption() throws InterruptedException {
		sanityTestingFlow.validateNACHService();
		sanityTestingFlow.validateNACHBulkRequestOption();
	}

	@Test(priority = 34)
	public void validateNACHBulkDebitOption() throws InterruptedException {
		sanityTestingFlow.validateNACHService();
		sanityTestingFlow.validateNACHBulkDebitOption();
	}

	@Test(priority = 35)
	public void validateDownloadCenterService() throws InterruptedException {
		sanityTestingFlow.validateDownloadCenterService();
	}

	@Test(priority = 36)
	public void validateReportsOption() throws InterruptedException {
		sanityTestingFlow.validateDownloadCenterService();
		sanityTestingFlow.validateReportsOption();
	}

}
