package com.TransBnk.TestClass_Payouts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_PayoutMakerCheckerSameEntity extends BaseTest {

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

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

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
	public void Verify_StatusForUploadedPayoutsForSameEntity() throws Exception {

		bulk_payout.verifyStatusForUploadedPayouts();

	}

	@Test(priority = 13)
	public void Verify_ClickOn_PayoutsOptionFromSideMenu() throws InterruptedException {

		add_bulk_beneficiary.ClickOn_PayoutsService();
	}

	@Test(priority = 14)
	public void Verify_ClickOn_PayoutApprovalListOptionFromSideMenuToApprovePayoutFromSameEntityAndUser()
			throws InterruptedException {

		payoutMakerCheckerSameEntity.clickOnPayoutApprovalListOption();
	}

	@Test(priority = 15)
	public void verify_payoutIsVisibleInPayoutApprovalList_SameEntity() throws InterruptedException {

		payoutMakerCheckerSameEntity.approvePayoutFromCheckerUser_01();

	}

	@Test(priority = 16)
	public void verify_clickOnAllActions_CheckerSameEntity() throws InterruptedException {
		payoutMakerCheckerSameEntity.clickOnAllActions_CheckerUser();

	}

	@Test(priority = 17)
	public void verify_ApprovalStatusInAllActionsFor_SameEntityApprovalUser() throws InterruptedException, IOException {

		payoutMakerCheckerSameEntity.verify_ApprovalStatusInAllActionsFor_SameEntityApprovalUser();

	}

	@Test(priority = 18)
	public void Verify_LogoutFromUser() throws Exception {

		loginpage.ClickOnLogoutButton();

	}
}
