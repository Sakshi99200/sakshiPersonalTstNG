package com.TransBnk.TestClass_Payouts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_PayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank extends BaseTest {

	@Test(priority = 1)
	public void Verify_LoginToPayoutMakerUser() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01_RBL"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutMakerUser01_RBL"));
	}

	@Test(priority = 2)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(
				UtilityClass.getDatafromPropertyFile("entityName_payoutMakerCheckerMultiEntityDiffEntity_RBL"));

	}

	@Test(priority = 3)
	public void Verify_Select_Program() throws Exception {

		deal_without_template.select_Product(
				UtilityClass.getDatafromPropertyFile("programName_payoutMakerCheckerMultiEntityDiffEntity_RBL"));

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
	public void Veirfy_SelectBankName_RBL() throws Exception {

		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name_RBL"));
	}

	@Test(priority = 8)
	public void insertDataIntoBulkPayoutExcelFile() throws Exception {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.insertDataIntoBulkPayoutExcelFile(
				System.getProperty("user.dir") + "/TestData/MakerChecker Bulk Payout RBL Bank.xlsx");

	}

	@Test(priority = 9)
	public void Verify_Upload_ValidBulkPayoutFile() throws InterruptedException {

		add_bulk_beneficiary
				.Upload_File(System.getProperty("user.dir") + "/TestData/MakerChecker Bulk Payout RBL Bank.xlsx");
	}

	@Test(priority = 10)
	public void Verify_EnterDescriptionInField() throws InterruptedException {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.EnterDescription();

	}

	@Test(priority = 11)
	public void Verify_ClickOnConfirmButton() throws Exception {

		add_bulk_beneficiary.ClickOnConfirmButton();

	}

	@Test(priority = 12)
	public void Verify_StatusForUploadedPayouts() throws Exception {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.verifyStatusForUploadedPayouts_MakerCheckerFlow();

	}

	@Test(priority = 13)
	public void Verify_ValidRecords() throws Exception {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.ValidRecords();

	}

	@Test(priority = 14)
	public void Verify_ClickOn_PayoutsOption_1() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 15)
	public void Verify_ClickOn_Payout_List() throws InterruptedException {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.ClickOn_Payout_ListOption();
	}

	@Test(priority = 16)
	public void Verify_FieldsOnPayoutListPage() throws Exception {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.VerifyFieldsOnPayoutListPage();
	}

	@Test(priority = 17)
	public void verify_Logout() throws InterruptedException {
		loginpage.ClickOnLogoutButton();
	}

	// approve payout for diff 3 entity porgram

	@Test(priority = 18)
	public void Verify_LoginToPayoutChecker_1st_User() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutCheckerUser01"));
	}

	@Test(priority = 19)
	public void Verify_Select_1stCheckerUserEntity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("payoutEntityNameCheckerUser01"));

	}

	@Test(priority = 20)
	public void Verify_Select_1stCheckerUseProgram() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("payoutProgramNameCheckerUser01"));

	}

	@Test(priority = 21)
	public void Verify_ClickOn_PayoutsOption_forApprovePayout() throws Exception {

		add_bulk_beneficiary.ClickOn_PayoutsService();

	}

	@Test(priority = 22)
	public void Verify_ClickOn_PayoutApprovalList_forApprovePayout() throws InterruptedException {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.clickOnPayoutApprovalListOption();
	}

	@Test(priority = 23)
	public void verify_payoutIsVisibleInPayoutApprovalList_MultiEntity_And_ApprovePayoutFrom_1st_CheckerUser()
			throws InterruptedException {

		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.approvePayoutFrom_1st_CheckerUser();

	}

	@Test(priority = 24)
	public void verify_clickOnAllActions_CheckerUser03() throws InterruptedException {
		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.clickOnAllActions_CheckerUser();
	}

	@Test(priority = 25)
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser01() throws InterruptedException, IOException {
		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank.verify_ApprovalStatusInAllActionsFor_CheckerUser01();
	}

	@Test(priority = 26)
	public void verify_Logoutuser01() throws InterruptedException {
		loginpage.ClickOnLogoutButton();
	}
}
