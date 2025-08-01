package com.TransBnk.TestClass_Payouts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_PayoutMakerChecker3DiffUser extends BaseTest {
	@Test(priority = 1)
	public void Verify_LoginToPayoutMakerUser() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutMakerUser01"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutMakerUser01"));
	}

	@Test(priority = 2)
	public void Verify_Select_Entity() throws Exception {
		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));
	}

	@Test(priority = 3)
	public void Verify_Select_Product() throws Exception {
		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("payoutProgramNameCheckerUser01"));
	}

	@Test(priority = 4)
	public void Verify_ClickOnPayoutsOption() throws InterruptedException {
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
	public void writeDataToExcel() throws Exception {
		payoutMakerCheckerSameEntity
				.insertDataIntoExcel(System.getProperty("user.dir") + "/TestData/PayoutForMakerChecker.xlsx");
	}

	@Test(priority = 8)
	public void Verify_Upload_ValidBulkPayoutFile() throws InterruptedException {
		add_bulk_beneficiary.Upload_File(System.getProperty("user.dir") + "/TestData/PayoutForMakerChecker.xlsx");
	}

	@Test(priority = 9)
	public void Veirfy_SelectBankName() throws Exception {
		add_bulk_beneficiary.SelectBankName(UtilityClass.getDatafromPropertyFile("Bank_Name"));
	}

	@Test(priority = 10)
	public void Verify_EnterRemarkInField() throws InterruptedException {
		bulk_payout.EnterRemark();
	}

	@Test(priority = 11)
	public void Verify_ClickOnConfirmButton() throws Exception {
		add_bulk_beneficiary.ClickOnConfirmButton();
	}

	@Test(priority = 12)
	public void Verify_StatusForUploadedPayouts() throws Exception {
		bulk_payout.verifyStatusForUploadedPayouts();
	}

	@Test(priority = 13)
	public void Verify_LogoutFromMakerUser() throws Exception {
		loginpage.ClickOnLogoutButton();
	}

	@Test(priority = 14)
	public void Verify_LoginToPayoutCheckerUser_01() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutCheckerUser01"));
	}

	@Test(priority = 15)
	public void Verify_SelectPayoutCheckerEntity_AoorovalUser01() throws Exception {
		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("payoutEntityNameCheckerUser01"));
	}

	@Test(priority = 16)
	public void Verify_SelectPayoutCheckerProduct_ApprovalUser01() throws Exception {
		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("payoutProgramNameCheckerUser01"));
	}

	@Test(priority = 17)
	public void Verify_ClickOn_PayoutsOption_ApprovalUser01() throws InterruptedException {
		add_bulk_beneficiary.ClickOn_PayoutsService();
	}

	@Test(priority = 18)
	public void Verify_ClickOn_PayoutApprovalListOption_AprovalUser01() throws InterruptedException {
		payoutMakerCheckerSameEntity.clickOnPayoutApprovalListOption();
	}

	@Test(priority = 19)
	public void Verify_PayoutIsVisibleForCheckerUser_01_AndApprovePayoutFromCheckerUser01()
			throws InterruptedException {
		payoutMakerCheckerSameEntity.approvePayoutFromCheckerUser_01();
	}

	@Test(priority = 20)
	public void verify_clickOnAllActions_CheckerUser01() throws InterruptedException {
		payoutMakerCheckerSameEntity.clickOnAllActions_CheckerUser();
	}

	@Test(priority = 21)
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser01() throws InterruptedException, IOException {
		payoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_CheckerUser01();
	}

	@Test(priority = 22)
	public void Verify_LogoutFromCheckerUser_01() throws Exception {
		loginpage.ClickOnLogoutButton();
	}

	@Test(priority = 23)
	public void Verify_LoginToPayoutCheckerUser_02() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser02"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutCheckerUser02"));
	}

	@Test(priority = 24)
	public void Verify_SelectPayoutCheckerEntity_User02() throws Exception {
		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("payoutEntityNameCheckerUser02"));
	}

	@Test(priority = 25)
	public void Verify_SelectPayoutCheckerProduct_User02() throws Exception {
		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("payoutProgramNameCheckerUser02"));
	}

	@Test(priority = 26)
	public void Verify_ClickOnPayoutsOption_user02() throws InterruptedException {
		add_bulk_beneficiary.ClickOn_PayoutsService();
	}

	@Test(priority = 27)
	public void Verify_PayoutIsVisibleForCheckerUser_02_AndApprovePayoutFromCheckerUser02()
			throws InterruptedException {
		payoutMakerCheckerSameEntity.approvePayoutFromCheckerUser_02();
	}

	@Test(priority = 28)
	public void verify_clickOnAllActions_CheckerUser02() throws InterruptedException {
		payoutMakerCheckerSameEntity.clickOnAllActions_CheckerUser();
	}

	@Test(priority = 29)
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser02() throws InterruptedException, IOException {
		payoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_CheckerUser02();
	}

	@Test(priority = 30)
	public void Verify_LogoutFromCheckerUser_02() throws Exception {
		loginpage.ClickOnLogoutButton();
	}

	@Test(priority = 31)
	public void Verify_LoginToPayoutCheckerUser_03() throws Exception {
		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("userNamePayoutCheckerUser01"),
				UtilityClass.getDatafromPropertyFile("passwordPayoutCheckerUser01"));
	}

	@Test(priority = 32)
	public void Verify_SelectPayoutCheckerEntity_User03() throws Exception {
		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("payoutEntityNameCheckerUser01"));
	}

	@Test(priority = 33)
	public void Verify_SelectPayoutCheckerProduct_User03() throws Exception {
		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("payoutProgramNameCheckerUser01"));
	}

	@Test(priority = 34)
	public void Verify_ClickOn_PayoutsOption_User03() throws InterruptedException {
		add_bulk_beneficiary.ClickOn_PayoutsService();
	}

	@Test(priority = 35)
	public void Verify_ClickOn_PayoutApprovalListOption_User03() throws InterruptedException {
		payoutMakerCheckerSameEntity.clickOnPayoutApprovalListOption();
	}

	@Test(priority = 36)
	public void Verify_PayoutIsVisibleForCheckerUser_03_AndApprovePayoutFromCheckerUser03()
			throws InterruptedException {
		payoutMakerCheckerSameEntity.approvePayoutFromCheckerUser_03();
	}

	@Test(priority = 37)
	public void verify_clickOnAllActions_CheckerUser03() throws InterruptedException {
		payoutMakerCheckerSameEntity.clickOnAllActions_CheckerUser();
	}

	@Test(priority = 38)
	public void verify_ApprovalStatusInAllActionsFor_CheckerUser03() throws InterruptedException, IOException {
		payoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_CheckerUser03();
	}

	@Test(priority = 39)
	public void Verify_LogoutFromCheckerUser_03() throws Exception {
		loginpage.ClickOnLogoutButton();
	}

}
