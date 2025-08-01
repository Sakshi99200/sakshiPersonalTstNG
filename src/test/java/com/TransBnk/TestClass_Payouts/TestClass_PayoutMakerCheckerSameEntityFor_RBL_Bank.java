package com.TransBnk.TestClass_Payouts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_PayoutMakerCheckerSameEntityFor_RBL_Bank extends BaseTest {

	@Test(priority = 1)
	public void Verify_LoginToPayoutMakerUser() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01_RBL"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutMakerUser01_RBL"));
	}

	@Test(priority = 2)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template
				.select_Entity(UtilityClass.getDatafromPropertyFile("entityName_payoutMakerCheckerSameEntity_RBL"));

	}

	@Test(priority = 3)
	public void Verify_Select_Product() throws Exception {

		deal_without_template
				.select_Product(UtilityClass.getDatafromPropertyFile("programName_payoutMakerCheckerSameEntity_RBL"));

	}

	@Test(priority = 4)
	public void Verify_ClickOn_PayoutService() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 5)
	public void Verify_ClickOn_Bulk_PayoutOption() throws InterruptedException {

		bulk_payout.ClickOn_Bulk_PayoutOption();

	}

	@Test(priority = 6)
	public void Verify_ClickOn_Add_Bulk_Payout_Button() throws InterruptedException {

		bulk_payout.ClickOn_AddBulkPayout();
	}

	@Test(priority = 7)
	public void Veirfy_SelectBankName() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name_RBL"));
	}

	@Test(priority = 8)
	public void Verify_BulkPayoutExcelFile_Headers_DBSBank() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_DBSBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout DBS Bank.xlsx");

	}

	@Test(priority = 9)
	public void validateBulkPayoutExcelFileHeaders_For_IDFCBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_IDFCBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout IDFC Bank.xlsx");

	}

	@Test(priority = 10)
	public void validateBulkPayoutExcelFileHeaders_For_InduslndBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_InduslndBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Induslnd Bank.xlsx");

	}

	@Test(priority = 11)
	public void validateBulkPayoutExcelFileHeaders_For_RBLBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_RBLBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout RBL Bank.xlsx");

	}

	@Test(priority = 12)
	public void validateBulkPayoutExcelFileHeaders_For_AxisBankFile() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_AxisBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Axis Bank.xlsx");

	}

	@Test(priority = 13)
	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Yes Bank Account Payout.xlsx");

	}

	@Test(priority = 14)
	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout() throws InterruptedException {

		bulk_payout_rbl_bank.validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Yes Bank VPA Payout.xlsx");

	}

//	@Test(priority = 15)
//	public void Verify_ClickOn_Add_Bulk_Payout_Button1() throws InterruptedException {
//
//		bulk_payout.ClickOn_AddBulkPayout();
//	}

	@Test(priority = 16)
	public void Veirfy_SelectBankName_RBL() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name_RBL"));
	}

	@Test(priority = 17)
	public void insertDataIntoBulkPayoutExcelFile() throws Exception {

		payoutMakerCheckerSameEntity_RBLBank.insertDataIntoBulkPayoutExcelFile(
				System.getProperty("user.dir") + "/TestData/MakerChecker Bulk Payout RBL Bank.xlsx");

	}

	@Test(priority = 18)
	public void Verify_Upload_ValidBulkPayoutFile() throws InterruptedException {

		add_bulk_beneficiary
				.Upload_File(System.getProperty("user.dir") + "/TestData/MakerChecker Bulk Payout RBL Bank.xlsx");
	}

	@Test(priority = 19)
	public void Verify_EnterDescriptionInField() throws InterruptedException {

		payoutMakerCheckerSameEntity_RBLBank.EnterDescription();

	}

	@Test(priority = 20)
	public void Verify_ClickOnConfirmButton() throws Exception {

		add_bulk_beneficiary.ClickOnConfirmButton();

	}

	@Test(priority = 21)
	public void Verify_StatusForUploadedPayouts() throws Exception {

		payoutMakerCheckerSameEntity_RBLBank.verifyStatusForUploadedPayouts_MakerCheckerFlow();

	}

	@Test(priority = 22)
	public void Verify_ValidRecords() throws Exception {

		payoutMakerCheckerSameEntity_RBLBank.ValidRecords();

	}

	@Test(priority = 23)
	public void Verify_ClickOn_PayoutsOption_1() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 24)
	public void Verify_ClickOn_Payout_List() throws InterruptedException {

		bulk_payout.ClickOn_Payout_ListOption();
	}

	@Test(priority = 25)
	public void Verify_FieldsOnPayoutListPage() throws Exception {

		payoutMakerCheckerSameEntity_RBLBank.VerifyFieldsOnPayoutListPage();
	}

	// approve payout for same entity porgram

	@Test(priority = 26)
	public void Verify_ClickOn_PayoutsOption_forApprovePayout() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 27)
	public void Verify_ClickOn_PayoutApprovalList_forApprovePayout() throws InterruptedException {

		payoutMakerCheckerSameEntity_RBLBank.clickOnPayoutApprovalListOption();
	}

	@Test(priority = 28)
	public void verify_payoutIsVisibleInPayoutApprovalList_SameEntity_And_ApprovePayoutFromSameCheckerUser()
			throws InterruptedException {

		payoutMakerCheckerSameEntity_RBLBank.approvePayoutFromSameCheckerUser();

	}

	@Test(priority = 29)
	public void verify_clickOnAllActions_CheckerUser03() throws InterruptedException {
		payoutMakerCheckerSameEntity_RBLBank.clickOnAllActions_CheckerUserSameUserAprroval();
	}

	@Test(priority = 30)
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser01() throws InterruptedException, IOException {
		payoutMakerCheckerSameEntity_RBLBank.verify_ApprovalStatusInAllActionsFor_CheckerUser01();
	}

	@Test(priority = 31)
	public void verify_Logout() throws InterruptedException {
		loginpage.ClickOnLogoutButton();
	}

}
