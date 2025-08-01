package com.TransBnk.TestClass_Payouts;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_NegativeScenarios_BulkBeneficiary extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 3)
	public void Verify_ClickOn_PayoutsOption() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_PayoutsService();
	}

	@Test(priority = 4)
	public void Verify_ClickOn_Bulk_BeneficiaryOption() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_Bulk_BeneficiaryOption();
	}

	@Test(priority = 5)
	public void Verify_ClickOn_Add_Bulk_Beneficiary_Button() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_Add_Bulk_Beneficiary_Button();
	}

	@Test(priority = 6)
	public void writeDataToExcelFile() throws Exception {

		negativescenarios_bulkBeneficiary.insertDataIntoExcel();

	}

	@Test(priority = 7)
	public void Verify_Upload_ValidBeneficiaryFile() throws InterruptedException {

		add_bulk_beneficiary
				.Upload_File(System.getProperty("user.dir") + "/TestData/Bulk Beneficiary negative Scenarios.xlsx");
	}

	@Test(priority = 8)
	public void Veirfy_SelectBankName() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name"));
	}

	@Test(priority = 9)
	public void Verify_EnterRemarkInField() throws InterruptedException {

		negativescenarios_bulkBeneficiary.EnterRemark();

	}

	@Test(priority = 10)
	public void Verify_ClickOnConfirmButton() throws Exception {
		negativescenarios_bulkBeneficiary.ClickOnConfirmButton();
	}

	@Test(priority = 11)
	public void Verify_InvalidStatus() throws Exception {
		negativescenarios_bulkBeneficiary.Check_InvalidStatus();
		negativescenarios_bulkBeneficiary.verify_InvladiRecords_BulkBeneficiary_Row2();
		negativescenarios_bulkBeneficiary.verify_InvladiRecords_BulkBeneficiary_Row3();
		negativescenarios_bulkBeneficiary.verify_InvladiRecords_BulkBeneficiary_Row4();
		negativescenarios_bulkBeneficiary.verify_InvladiRecords_BulkBeneficiary_Row5();
		negativescenarios_bulkBeneficiary.verify_InvladiRecords_BulkBeneficiary_Row6();

	}

//	@Test(priority = 12)
//	public void Verify_ClickOnLogoutButton() throws InterruptedException {
//
//		loginpage.ClickOnLogoutButton();
//
//	}

}
