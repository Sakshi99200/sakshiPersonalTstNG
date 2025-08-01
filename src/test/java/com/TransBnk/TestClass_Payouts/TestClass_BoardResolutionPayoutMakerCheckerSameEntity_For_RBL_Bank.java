package com.TransBnk.TestClass_Payouts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_BoardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank extends BaseTest {

	@Test(priority = 1)
	public void Verify_LoginToPayoutMakerUserBoardResolutionSameEntity() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(
				UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01BoardResolution_RBL"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutMakerUser01Boardresolution_RBL"));
	}

	@Test(priority = 2)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(
				UtilityClass.getDatafromPropertyFile("entityName_BoardResolutionpayoutMakerCheckerSameEntity_RBL"));

	}

	@Test(priority = 3)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(
				UtilityClass.getDatafromPropertyFile("programName_BoardResolutionpayoutMakerCheckerSameEntity_RBL"));

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

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.validateBulkPayoutExcelFileHeaders_For_DBSBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout DBS Bank.xlsx");

	}

	@Test(priority = 9)
	public void validateBulkPayoutExcelFileHeaders_For_IDFCBankFile() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.validateBulkPayoutExcelFileHeaders_For_IDFCBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout IDFC Bank.xlsx");

	}

	@Test(priority = 10)
	public void validateBulkPayoutExcelFileHeaders_For_InduslndBankFile() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank
				.validateBulkPayoutExcelFileHeaders_For_InduslndBankFile(
						System.getProperty("user.dir") + "/TestData/Bulk Payout Induslnd Bank.xlsx");

	}

	@Test(priority = 11)
	public void validateBulkPayoutExcelFileHeaders_For_RBLBankFile() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.validateBulkPayoutExcelFileHeaders_For_RBLBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout RBL Bank.xlsx");

	}

	@Test(priority = 12)
	public void validateBulkPayoutExcelFileHeaders_For_AxisBankFile() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.validateBulkPayoutExcelFileHeaders_For_AxisBankFile(
				System.getProperty("user.dir") + "/TestData/Bulk Payout Axis Bank.xlsx");

	}

	@Test(priority = 13)
	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank
				.validateBulkPayoutExcelFileHeaders_For_YesBankFile_AccountPayout(
						System.getProperty("user.dir") + "/TestData/Bulk Payout Yes Bank Account Payout.xlsx");

	}

	@Test(priority = 14)
	public void validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank
				.validateBulkPayoutExcelFileHeaders_For_YesBankFile_VPA_Payout(
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
	public void insertDataIntoBulkPayoutExcelFileBoardResolutionSameEntity() throws Exception {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.insertDataIntoBulkPayoutExcelFile(
				System.getProperty("user.dir") + "/TestData/Board Resolution CM Bulk Payout SameEntity RBL Bank.xlsx");

	}

	@Test(priority = 18)
	public void Verify_Upload_ValidBulkPayoutFileBoardResolutionSameEntity() throws InterruptedException {

		add_bulk_beneficiary.Upload_File(
				System.getProperty("user.dir") + "/TestData/Board Resolution CM Bulk Payout SameEntity RBL Bank.xlsx");
	}

	@Test(priority = 19)
	public void Verify_EnterDescriptionInField() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.EnterDescription();

	}

	@Test(priority = 20)
	public void Verify_ClickOnConfirmButton() throws Exception {

		add_bulk_beneficiary.ClickOnConfirmButton();

	}

	@Test(priority = 21)
	public void Verify_StatusForUploadedPayoutsBoardResolutionSameEntity() throws Exception {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.verifyStatusForUploadedPayouts_MakerCheckerFlow();

	}

	@Test(priority = 22)
	public void Verify_ValidRecords() throws Exception {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.ValidRecords();

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

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.VerifyFieldsOnPayoutListPage();
	}

	// approve payout for same entity porgram

	@Test(priority = 26)
	public void Verify_ClickOn_PayoutsOption_forApprovePayout() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 27)
	public void Verify_ClickOn_PayoutApprovalList_forApprovePayoutBoardResolution() throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.clickOnPayoutApprovalListOption();
	}

	@Test(priority = 28)
	public void verify_payoutIsVisibleInPayoutApprovalList_SameEntity_And_ApprovePayoutFromSameCheckerUserBoardResolution()
			throws InterruptedException {

		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.approvePayoutFromSameCheckerUserForBoardResolution();

	}

	@Test(priority = 29)
	public void verify_clickOnAllActions_CheckerUser01() throws InterruptedException {
		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.clickOnAllActions_CheckerUserSameUserAprroval();
	}

	@Test(priority = 30)
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser01() throws InterruptedException, IOException {
		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank.verify_ApprovalStatusInAllActionsFor_CheckerUser01();
	}

	@Test(priority = 31)
	public void verify_Logout() throws InterruptedException {
		loginpage.ClickOnLogoutButton();
	}
}
