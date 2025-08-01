package com.TransBnk.TestClass_Payouts;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.Payouts.Bulk_Payout;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Bulk_Payout extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 3)
	public void Verify_ClickOn_PayoutService() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 4)
	public void Verify_ClickOn_Bulk_PayoutOption() throws InterruptedException {

		bulk_payout.ClickOn_Bulk_PayoutOption();

	}

	@Test(priority = 5)
	public void Verify_ClickOn_Add_Bulk_Payout_Button() throws InterruptedException {

		bulk_payout.ClickOn_AddBulkPayout();
	}

	@Test(priority = 6)
	public void Verify_Upload_BlankBulkPayoutFile() throws InterruptedException {

		add_bulk_beneficiary.Upload_File(System.getProperty("user.dir") + "/TestData/Payout Blank file upload.xlsx");
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
	public void Verify_ClickOn_Add_Bulk_Payout_Button_1() throws InterruptedException {

		bulk_payout.ClickOn_AddBulkPayout();
	}

	@Test(priority = 10)
	public void Verify_BeneficiaryExcelFile_Headers() throws InterruptedException {

		bulk_payout.validateBulkPayoutExcelFileHeaders(System.getProperty("user.dir") + "/TestData/Payout file.xlsx");

	}

	@Test(priority = 11)
	public void writeDataToExcel() throws Exception {

		bulk_payout.insertDataIntoBulkPayoutExcelFile();
	}

	@Test(priority = 12)
	public void Verify_Upload_ValidBulkPayoutFile() throws InterruptedException {

		add_bulk_beneficiary.Upload_File(System.getProperty("user.dir") + "/TestData/Payout file.xlsx");
	}

	@Test(priority = 13)
	public void Veirfy_SelectBankName() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name"));
	}

	@Test(priority = 14)
	public void Verify_EnterRemarkInField() throws InterruptedException {

		bulk_payout.EnterRemark();

	}

	@Test(priority = 15)
	public void Verify_ClickOnConfirmButton() throws Exception {

		add_bulk_beneficiary.ClickOnConfirmButton();

		bulk_payout.verifyStatusForUploadedPayouts();

	}

	@Test(priority = 16)
	public void Verify_ClickOn_PayoutsOption_1() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 17)
	public void Verify_ClickOn_Payout_List() throws InterruptedException {

		bulk_payout.ClickOn_Payout_ListOption();
	}

	@Test(priority = 18)
	public void Beneficiary_List() throws Exception {

		bulk_payout.Beneficiary_List();
	}

}
