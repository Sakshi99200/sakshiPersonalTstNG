package com.TransBnk.TestClass_RiskRadar;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_CheckDownloadCenterForTransaction extends BaseTest {
	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_with_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_with_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 3)
	public void Verify_ClickOnRiskRadarOption() throws InterruptedException {

		riskRadarBankBalance.clickOnRiskRadar();
	}

	@Test(priority = 4)
	public void Verify_ClickOnBankBalance() throws InterruptedException {

		riskRadarBankBalance.clickOnTransactionOption();

	}

	@Test(priority = 5)
	public void Verify_ClickExportButtonOnBankBalancePage() throws InterruptedException {

		checkDownloadCenterForTransaction.clickOnExportButtonOnTransactionPage();

	}

	@Test(priority = 6)
	public void validateDownloadCenterService() throws InterruptedException {
		checkDownloadCenterForBankBalance.clickOnDownloadCenterOption();
	}

	@Test(priority = 7)
	public void validateReportsOption() throws InterruptedException {

		checkDownloadCenterForBankBalance.clickReportsOption();
	}

	@Test(priority = 8)
	public void Verify_BankBalanceStatusinDownloadCenterForBankBalance() throws InterruptedException {

		checkDownloadCenterForTransaction.checkStatusInDownloadCenterForTransactionReport();

	}

}
