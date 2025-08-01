package com.TransBnk.TestClass_Deals;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.annotations.Test;

import com.TransBnk.Deal.Deal_With_Template;
import com.TransBnk.Deal.Deal_Without_Template;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_AddSignatories_after_generateAgreement_DealWithoutTemplate extends BaseTest {

// @Test(priority = 1)
//
//	public void Verify_Invalid_input_SignInPage() throws Exception {
//
//		loginpage.Blank_fieldValidation_SignIn();
//
//		loginpage.Invalid_input_signIn();
//
//	}
//
//	@Test(priority = 2)
//	public void Verify_Valid_input_SignInPage() throws Exception {
//
//		loginpage.SignIn_with_Valid_Credentials();
//
//	}

	@Test(priority = 3)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 4)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 5)
	public void VerifyClickOnDocuflow() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 6)
	public void VerifyClickOnDeals() throws Exception {

		deal_without_template.ClickOnDealsOption();

		deal_without_template.ClickOn_CreateDeal_Button();

		deal_without_template.enter_Deal_reference_ID();
		deal_without_template.Select_Agreement_State();
		deal_without_template.Enter_ConsiderationAmount();
		deal_without_template.Select_Agreement_Date();
		deal_without_template.Select_DocumentType();
		deal_without_template.Select_productName(UtilityClass.getDatafromPropertyFile("product"));
		deal_without_template.ClickOnRequireTemplateRadioButton();
		deal_without_template.UploadTemplate();
		deal_without_HandlingNegativeScnarios.pageDown();
		deal_without_template.ClickOnProceedButton();
		deal_without_template.checkValidationAfterDealCreation();
	}

	@Test(priority = 7)
	public void Verify_EnterNumberOfParties() throws Exception {

//		// remove after use
//
//		deal_without_template.clickviewbutton();

		deal_without_template.EnterNumOfParties();

	}

	@Test(priority = 8)
	public void AddCustomSignatories_party1() throws Exception {
		deal_without_template.AddCustomeSignatories_Party1();
	}

	@Test(priority = 9)

	public void ClickOnSelectPredefinedSignatoriesOption() throws InterruptedException {
		deal_without_template.ClickOnSelectPredefinedSignatoriesOption();
	}

	@Test(priority = 10)
	public void SelectPredefinedSignatoriesFromDropdown() throws Exception {
		deal_without_template.SelectPredefinedSignatoriesFromDropdown();
	}

	@Test(priority = 11)
	public void ClickOnConfirmButton() throws InterruptedException {
		deal_without_template.ClickOnConfirmButton();
	}

	@Test(priority = 12)
	public void ClickOnDropDown_Party2() throws InterruptedException {
		deal_without_template.ClickOnDropDown_Party2();

	}

	@Test(priority = 13)

	public void AddCustomSignatories_Party2() throws Exception {
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 14)
	public void EnterValidDetails_CustomSignatories_Party2() throws Exception {
		deal_without_template.EnterValidDetails_CustomSignatories_Party2();
	}

	@Test(priority = 15)
	public void Verify_AddCustomSignatories_party3_() throws Exception {

		deal_without_template.AddCustomSignatories_Party3();

		deal_without_template.ClickOnProceedButton_OnpartyDetailsPage();
		Thread.sleep(1000);
	}

	@Test(priority = 16)

	public void Verify_performActionsBasedOnDealRefID() throws Exception {

		deal_without_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 17)
	public void Verify_ClickOnAddSignatoriesButton() throws InterruptedException {

		addsignatories_afterGenerateAgreement.ClickOnAddSignatoriesButton();

	}

	@Test(priority = 18)
	public void Verify_AddSignatoriesAfterGenerateAgreement() throws Exception {

		addsignatories_afterGenerateAgreement.EnterDetails_InSignatories();

	}

	@Test(priority = 19)
	public void ClickOnSendForExecutionButton() throws Exception {

		deal_without_HandlingNegativeScnarios.pageUp();

		deal_without_template.ThreadSleep();

		deal_without_template.ClickOnSendForExecutionButton();

	}

	@Test(priority = 20)
	public void Verify_ReadMailAnd_ClickOnReviewSignButton_forDealWithTemplate()
			throws MessagingException, IOException, InterruptedException, Exception {
		Thread.sleep(10000);
		// Call method fetchAndClickButton
		utilityClass.ReadMailAnd_ClickOnReviewSignButton_forDealWithoutTemplate();

		UtilityClass.EnterOTPFrom_Mail(Deal_Without_Template.DealRefereneceID);
	}

	@Test(priority = 21)
	public void Verify_ClickOnVerifyButton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnVerifyButton();
	}

	@Test(priority = 22)
	public void Verify_ClickOnCheckBox() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBox();
	}

	@Test(priority = 23)
	public void Verify_ClickOnProceedToSignButton() throws Exception {
		signAgreementDocument_dealwithoutTemplate.ClickOnProceedToSignButton();
	}

	@Test(priority = 24)
	public void Verify_ClickOnCheckBoxOnAdharCard() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBoxOnAdharCard();
	}

	@Test(priority = 25)
	public void Verify_EnterAdharNumber() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.EnterAdharNumber();
	}

	@Test(priority = 26)
	public void Verify_ClickOnSendOTPbutton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnSendOTPbutton();
	}

	@Test(priority = 27)
	public void Verify_SwitchToOriginalTab() throws InterruptedException {

		utilityClass.switchToTab(0);

	}

//	@Test(priority = 28)
//	public void Verify_ClickOnLogoutButton() throws InterruptedException {
//
//		loginpage.ClickOnLogoutButton();
//
//	}
}
