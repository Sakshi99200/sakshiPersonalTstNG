package com.TransBnk.TestClass_Payouts;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Bulk_Beneficiary extends BaseTest {

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
	public void Verify_Upload_BlankFile() throws InterruptedException {

		add_bulk_beneficiary
				.Upload_File(System.getProperty("user.dir") + "/TestData/Beneficiary Blank File Upload.xlsx");
	}

	@Test(priority = 7)
	public void Veirfy_ErrorValidationForUploading_BlankFile() {

		add_bulk_beneficiary.Check_ErrorValidationForUploading_BlankFile();
	}

	@Test(priority = 8)
	public void ClickOn_CancelButton() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_CancelButton();

	}

	@Test(priority = 9)
	public void Verify_ClickOn_Add_Bulk_Beneficiary_Button_1() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_Add_Bulk_Beneficiary_Button();
	}

	@Test(priority = 10)
	public void Verify_BeneficiaryExcelFile_Headers() throws InterruptedException {

		add_bulk_beneficiary.validateBeneficiaryExcelFileHeaders(
				System.getProperty("user.dir") + "/TestData/Beneficiary file.xlsx");

	}

	@Test(priority = 11)
	public void writeDataToExcelFile() throws Exception {

		add_bulk_beneficiary.insertDataIntoBulkBeneficiaryExcelFile();

	}

	@Test(priority = 12)
	public void Verify_Upload_ValidBeneficiaryFile() throws InterruptedException {

		add_bulk_beneficiary.Upload_File(System.getProperty("user.dir") + "/TestData/Beneficiary file.xlsx");
	}

	@Test(priority = 13)
	public void Veirfy_SelectBankName() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name"));
	}

	@Test(priority = 14)
	public void Verify_EnterRemarkInField() throws InterruptedException {

		add_bulk_beneficiary.EnterRemark();

	}

	@Test(priority = 15)
	public void Verify_ClickOnConfirmButton() throws Exception {
		add_bulk_beneficiary.ClickOnConfirmButton();
	}

	@Test(priority = 16)
	public void Verify_StatusForUploadedBulkBeneficiary() throws Exception {

		add_bulk_beneficiary.verifyStatusForUploadedBulkBeneficiary();

	}

	@Test(priority = 17)
	public void Verify_ClickOn_PayoutsOptionAfterUploadingBulkBeneficiary() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 18)
	public void Verify_ClickOn_BeneficiaryListOption() throws Exception {

		add_bulk_beneficiary.ClickOn_BeneficiaryListOption();

	}

	@Test(priority = 19)
	public void Verify_ValidateValidRecords() throws Exception {

		add_bulk_beneficiary.ValidateValidRecords();

	}

}
