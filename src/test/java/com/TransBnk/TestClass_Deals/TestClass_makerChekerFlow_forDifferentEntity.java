package com.TransBnk.TestClass_Deals;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.annotations.Test;

import com.TransBnk.Deal.Deal_Without_Template;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_makerChekerFlow_forDifferentEntity extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("EntityName_MakerCheker_Diff_Entity"));

	}

	@Test(priority = 2)
	public void Verify_Select_ProductName() throws Exception {

		deal_without_template
				.select_Product(UtilityClass.getDatafromPropertyFile("programName_makerChecker_Diff_entity"));

	}

	@Test(priority = 3)
	public void VerifyClickOnDocuflow() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 4)
	public void VerifyClickOnDeals() throws InterruptedException {

		deal_without_template.ClickOnDealsOption();

	}

	@Test(priority = 5)
	public void ClickOn_Create_button() throws InterruptedException {
		deal_without_template.ClickOn_CreateDeal_Button();
	}

	@Test(priority = 6)
	public void Verify_Deal_creation_page() throws Exception {

		deal_without_template.enter_Deal_reference_ID();
		deal_without_template.Select_Agreement_State();
		deal_without_template.Enter_ConsiderationAmount();
		deal_without_template.Select_Agreement_Date();
		deal_without_template.Select_DocumentType();
		deal_without_template.Select_productName(UtilityClass.getDatafromPropertyFile("ProductName_makerCheker"));
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

	public void Verify_EmptyFieldValidation_CustomeSignatories() throws Exception {
		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_FullName();

		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_EmailAddress();

//		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_MobileNumber();

	}

	@Test(priority = 15)
	public void VerifyInvalidInputs_fieldValidation_CustomeSignatories() throws Exception {
//		deal_without_template.EnterSignatories_Invalid_DateOfBirth();

//		deal_without_HandlingNegativeScnarios.Invalid_Input_DateofBirth();

		deal_without_HandlingNegativeScnarios.Invalid_Input_AadhaarNumber();

		deal_without_HandlingNegativeScnarios.Invalid_Input_EmailAddress();

		deal_without_HandlingNegativeScnarios.ClickOnCancelButton_AddSignatories();

	}

	@Test(priority = 16)

	public void ClickOnAddCustomSignatories_Party2() throws Exception {
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 17)
	public void EnterValidDetails_CustomSignatories_Party2() throws Exception {
		deal_without_template.EnterValidDetails_CustomSignatories_Party2();
	}

	@Test(priority = 18)
	public void Verify_AddCustomSignatories_party3() throws Exception {
		deal_without_template.AddCustomSignatories_Party3();

		deal_without_template.ClickOnProceedButton_OnpartyDetailsPage();

		Thread.sleep(15000);

	}

	@Test(priority = 19)

	public void Verify_performActionsBasedOnDealRefID() throws Exception {
		deal_without_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 20)
	public void Verify_ClickOnSendForExecutionButton() throws Exception {

		makercheckerFlow_forsameEntity.ClickOnSubmitForVerificationButton();

	}

	@Test(priority = 21)

	public void Select_Entity_forDiffMakerCheker() throws Exception {

		deal_without_template
				.select_Entity(UtilityClass.getDatafromPropertyFile("EntityName_MakerCheckerApprover_Diff_Entity"));

	}

	@Test(priority = 22)
	public void ClickOnDocuflowOption() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 23)

	public void ClickOn_DealVerificationOption() throws InterruptedException {
		makercheckerFlow_forsameEntity.ClickOnDealVerificationOption();
	}

	@Test(priority = 24)

	public void PerformActionBasedOnDealID_ForDeal_Verification() throws Exception {

		deal_without_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 25)
	public void ClickOnSendForExecutionButton() throws Exception {

		deal_without_template.ClickOnSendForExecutionButton();

	}

	@Test(priority = 26)
	public void Verify_ReadMailAnd_ClickOnReviewSignButton_forDealWithTemplate()
			throws MessagingException, IOException, InterruptedException, Exception {
		Thread.sleep(10000);
		// Call method fetchAndClickButton
		utilityClass.ReadMailAnd_ClickOnReviewSignButton_forDealWithoutTemplate();

		UtilityClass.EnterOTPFrom_Mail(Deal_Without_Template.DealRefereneceID);
	}

	@Test(priority = 27)
	public void Verify_ClickOnVerifyButton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnVerifyButton();
	}

	@Test(priority = 28)
	public void Verify_ClickOnCheckBox() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBox();
	}

	@Test(priority = 29)
	public void Verify_ClickOnProceedToSignButton() throws Exception {
		signAgreementDocument_dealwithoutTemplate.ClickOnProceedToSignButton();
	}

	@Test(priority = 30)
	public void Verify_ClickOnCheckBoxOnAdharCard() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBoxOnAdharCard();
	}

	@Test(priority = 31)
	public void Verify_EnterAdharNumber() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.EnterAdharNumber();
	}

	@Test(priority = 32)
	public void Verify_ClickOnSendOTPbutton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnSendOTPbutton();
	}

	@Test(priority = 33)
	public void Verify_SwitchToOriginalTab() throws InterruptedException {

		utilityClass.switchToTab(0);

	}

//	@Test(priority = 34)
//	public void Verify_ClickOnLogoutButton() throws InterruptedException {
//
//		loginpage.ClickOnLogoutButton();
//
//	}
}
