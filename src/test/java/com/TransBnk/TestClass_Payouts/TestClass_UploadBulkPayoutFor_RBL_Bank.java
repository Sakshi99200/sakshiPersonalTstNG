package com.TransBnk.TestClass_Payouts;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_UploadBulkPayoutFor_RBL_Bank extends BaseTest {

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
	public void Veirfy_SelectBankName() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name_RBL"));
	}

	@Test(priority = 7)
	public void Verify_Upload_BlankBulkPayoutFile() throws InterruptedException {

		add_bulk_beneficiary
				.Upload_File(System.getProperty("user.dir") + "/TestData/New BulkPayout Blank File Upload.xlsx");
	}

	@Test(priority = 8)
	public void Veirfy_ErrorValidationForUploading_BlankFile() {

		add_bulk_beneficiary.Check_ErrorValidationForUploading_BlankFile();
	}

	@Test(priority = 9)
	public void ClickOn_CancelButton() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_CancelButton();
	}

	@Test(priority = 10)
	public void Verify_BulkPayoutExcelFile_Headers_DBSBank() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_DBSBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout DBS Bank.xlsx");

	}

	@Test(priority = 11)
	public void validateBulkPayoutExcelFileHeaders_For_IDFCBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_IDFCBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout IDFC Bank.xlsx");

	}

	@Test(priority = 12)
	public void validateBulkPayoutExcelFileHeaders_For_InduslndBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_InduslndBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Induslnd Bank.xlsx");

	}

	@Test(priority = 13)
	public void validateBulkPayoutExcelFileHeaders_For_RBLBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_RBLBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout RBL Bank.xlsx");

	}

	@Test(priority = 14)
	public void validateBulkPayoutExcelFileHeaders_For_AxisBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_AxisBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Axis Bank.xlsx");

	}

	@Test(priority = 15)
	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Yes Bank Account Payout.xlsx");

	}

	@Test(priority = 16)
	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Yes Bank VPA Payout.xlsx");

	}

	@Test(priority = 17)
	public void Verify_ClickOn_Add_Bulk_Payout_Button1() throws InterruptedException {

		bulk_payout.ClickOn_AddBulkPayout();
	}

	@Test(priority = 18)
	public void Veirfy_SelectBankName_RBL() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name_RBL"));
	}

	@Test(priority = 19)
	public void insertDataIntoBulkPayoutExcelFile() throws Exception {

		bulk_payout_rbl_bank.insertDataIntoBulkPayoutExcelFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout RBL Bank.xlsx");

	}

	@Test(priority = 20)
	public void Verify_Upload_ValidBulkPayoutFile() throws InterruptedException {

		add_bulk_beneficiary.Upload_File(System.getProperty("user.dir") + "/TestData/Bulk Payout RBL Bank.xlsx");
	}

	@Test(priority = 21)
	public void Verify_EnterDescriptionInField() throws InterruptedException {

		bulk_payout_rbl_bank.EnterDescription();

	}

	@Test(priority = 22)
	public void Verify_ClickOnConfirmButton() throws Exception {

		add_bulk_beneficiary.ClickOnConfirmButton();

	}

	@Test(priority = 23)
	public void Verify_StatusForUploadedPayouts() throws Exception {

		bulk_payout_rbl_bank.verifyStatusForUploadedPayouts();

	}

	@Test(priority = 24)
	public void Verify_ValidRecords() throws Exception {

		bulk_payout_rbl_bank.ValidRecords();

	}

	@Test(priority = 25)
	public void Verify_ClickOn_PayoutsOption_1() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 26)
	public void Verify_ClickOn_Payout_List() throws InterruptedException {

		bulk_payout.ClickOn_Payout_ListOption();
	}

	@Test(priority = 27)
	public void Verify_FieldsOnPayoutListPage() throws Exception {

		bulk_payout_rbl_bank.VerifyFieldsOnPayoutListPage();
	}

	@Test(priority = 28)
	public void Verify_PayoutDetailsIn_PayoutDetailsPopup() throws Exception {

		bulk_payout_rbl_bank.VerifyFieldsOnPayoutListPage();
	}

}
