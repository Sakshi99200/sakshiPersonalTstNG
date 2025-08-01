package com.TransBnk.TestClass_RiskRadar;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_RiskRadar_BankBalance extends BaseTest {

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

		riskRadarBankBalance.clickOnBankBalance();

	}

	@Test(priority = 5)
	public void Verify_BankBalancePage() throws InterruptedException {

		riskRadarBankBalance.verifyBankBalancePage();
	}

	@Test(priority = 6)
	public void Verify_clickOnFetchButton() throws InterruptedException, IOException {

		riskRadarBankBalance.clickOnFetchButton();
	}

	@Test(priority = 7)
	public void checkBalanceFetchDateAndTime_Bank_INDB() throws IOException, InterruptedException {

		riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_INDB();
	}

	@Test(priority = 8)
	public void checkBalanceFetchDateAndTime_Bank_UTIB() throws IOException, InterruptedException {

		riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_UTIB();
	}

	@Test(priority = 9)
	public void checkBalanceFetchDateAndTime_Bank_RATN() throws IOException, InterruptedException {

		riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_RATN();
	}

	@Test(priority = 10)
	public void checkBalanceFetchDateAndTime_Bank_YES() throws IOException, InterruptedException {

		riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_YesBank();
	}

//	@Test(priority = 11)
//	public void checkBalanceFetchDateAndTime_Bank_ICICI() throws IOException, InterruptedException {
//
//		riskRadarBankBalance.checkBalanceFetchDateAndTime_Bank_ICICI();
//	}

	@Test(priority = 12)
	public void Verify_BankBalanceValue() throws InterruptedException {

		riskRadarBankBalance.clickOnRiskRadar();
	}

	@Test(priority = 13)
	public void Verify_clickOnTransactionOption() throws InterruptedException {

		riskRadarBankBalance.clickOnTransactionOption();

	}

	@Test(priority = 18)
	public void Verify_clickOnFetchButtonOnTransactionPage() throws InterruptedException, IOException {

		riskRadarBankBalance.clickOnFetchButton();

		deal_without_template.ThreadSleep();

	}

	@Test(priority = 19)
	public void Verify_NullorZeroTransAmountForBankTransaction() throws Exception {

		riskRadarBankBalance.checkNullorZeroTransAmountForBankTransaction();
	}

	@Test(priority = 20)
	public void Verify_clickOnFirstPage4() throws Exception {

		riskRadarBankBalance.clickOnFirstPage();

	}

	@Test(priority = 21)
	public void Verify_checkNullAccountBalForBankTransaction() throws Exception {

		riskRadarBankBalance.checkNullAccountBalForBankTransaction();
	}

	@Test(priority = 22)
	public void Verify_clickOnFirstPage() throws Exception {

		riskRadarBankBalance.clickOnFirstPage();

	}

	@Test(priority = 23)
	public void Verify_checkDuplicateRefNo() throws InterruptedException {

		riskRadarBankBalance.checkDuplicateTransactionEntries();

	}

	@Test(priority = 24)
	public void Verify_clickOnFirstPage1() throws Exception {

		riskRadarBankBalance.clickOnFirstPage();

	}

}
