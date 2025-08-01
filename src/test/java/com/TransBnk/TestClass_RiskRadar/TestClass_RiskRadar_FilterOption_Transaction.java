package com.TransBnk.TestClass_RiskRadar;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_RiskRadar_FilterOption_Transaction extends BaseTest {

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
	public void Verify_ClickOnTransactionOption() throws InterruptedException {

		riskRadarBankBalance.clickOnTransactionOption();

	}
	
	@Test(priority = 5)
	public void Verify_checkCustomerNameFilterOnBankBalancePage() throws InterruptedException {

		checkFilterOptionRiskRadar.checkBankFilterOnTransactionPage();

	}
	
	

}
