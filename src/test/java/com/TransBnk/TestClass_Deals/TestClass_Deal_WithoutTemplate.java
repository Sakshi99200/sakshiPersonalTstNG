package com.TransBnk.TestClass_Deals;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.annotations.Test;

import com.TransBnk.Deal.Deal_Without_Template;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Deal_WithoutTemplate extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 3)
	public void VerifyClickOnDocuflow() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 4)
	public void VerifyClickOnDeals() throws InterruptedException {

		deal_without_template.ClickOnDealsOption();

		deal_without_template.ClickOn_CreateDeal_Button();
	}
//
//	@Test(priority = 5)
//	public void Verify_EmptyFieldValidation_DealCreation() throws InterruptedException {
//
////		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_DealReferenceID();
////		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_AgreementState();
////		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_ConsiderationAmount();
////		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_AgreementDate();
////		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_DocumentType();
////		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_Product();
//	}
//
//	@Test(priority = 6)
//	public void Verify_InvalidInputFields_dealCreation() throws Exception {
//
////		deal_without_HandlingNegativeScnarios.pageUp();
//		deal_without_HandlingNegativeScnarios.Invalid_Input_DealReferenceID();
////		deal_without_HandlingNegativeScnarios.Invalid_Input_LinkDealtoExistingDealReferenceID();
//		deal_without_template.Select_Agreement_State();
//		deal_without_template.Enter_ConsiderationAmount();
//		deal_without_HandlingNegativeScnarios.Invalid_Input_AgreementDate();
//		deal_without_template.Select_DocumentType();
//		deal_without_template.Select_productName(UtilityClass.getDatafromPropertyFile("product"));
//		deal_without_template.ClickOnRequireTemplateRadioButton();
//		deal_without_template.UploadTemplate();
//		deal_without_template.ClickOnProceedButton();
//		deal_without_HandlingNegativeScnarios.pageUp();
//		deal_without_template.Select_Agreement_Date();
//		deal_without_HandlingNegativeScnarios.pageDown();
//		deal_without_template.ClickOnProceedButton();
////		deal_without_HandlingNegativeScnarios.Displayed_invalidinputValidationMessage_DealRefID();
//		deal_without_HandlingNegativeScnarios.pageUp();
//		deal_without_HandlingNegativeScnarios.Clear_DealrefIDField();
//		deal_without_template.enter_Deal_reference_ID();
//		deal_without_HandlingNegativeScnarios.pageDown();

//		deal_without_HandlingNegativeScnarios.Displayed_InvalidinputValidationMsg_LinkDealtoExistingDealReferenceID();
//		deal_without_HandlingNegativeScnarios.pageUp();
//		deal_without_HandlingNegativeScnarios.Clear_LinkDealtoExistingDealReferenceID();
//		deal_without_HandlingNegativeScnarios.pageDown();
//		deal_without_template.ClickOnProceedButton();
//		deal_without_HandlingNegativeScnarios.ClickOnCancelButton();
//	}
//
//
//	@Test(priority = 7)
//	public void Verify_ClickOn_Create_button() throws Exception {
//		deal_without_template.ClickOn_CreateDeal_Button();
//		deal_without_template.enter_Deal_reference_ID();
//
//	}

	@Test(priority = 8)
	public void verify_Enter_Deal_reference_ID() throws Exception {

		deal_without_template.enter_Deal_reference_ID();

	}

	@Test(priority = 9)
	public void verify_Select_Agreement_State() throws Exception {

		deal_without_template.Select_Agreement_State();

	}

	@Test(priority = 10)
	public void verify_Enter_ConsiderationAmount() throws Exception {

		deal_without_template.Enter_ConsiderationAmount();

	}

	@Test(priority = 11)
	public void verify_Select_Agreement_Date() throws Exception {

		deal_without_template.Select_Agreement_Date();

	}

	@Test(priority = 12)
	public void verify_Select_DocumentType() throws Exception {

		deal_without_template.Select_DocumentType();

	}

	@Test(priority = 13)
	public void verify_Select_productName() throws Exception {

		deal_without_template.Select_productName(UtilityClass.getDatafromPropertyFile("product"));

	}

	@Test(priority = 14)
	public void verify_ClickOnRequireTemplateRadioButton() throws Exception {

		deal_without_template.ClickOnRequireTemplateRadioButton();

	}

	@Test(priority = 15)
	public void verify_UploadTemplate() throws Exception {

		deal_without_template.UploadTemplate();

	}

	@Test(priority = 16)
	public void verify_ClickOnProceedButton() throws Exception {

		deal_without_template.ClickOnProceedButton();

	}

	@Test(priority = 17)
	public void Verify_EnterNumberOfParties() throws Exception {

		deal_without_template.EnterNumOfParties();

	}

	@Test(priority = 18)
	public void AddCustomSignatories_party1() throws Exception {

		deal_without_template.AddCustomeSignatories_Party1();
	}

	@Test(priority = 19)

	public void ClickOnSelectPredefinedSignatoriesOption() throws InterruptedException {
		deal_without_template.ClickOnSelectPredefinedSignatoriesOption();
	}

	@Test(priority = 20)
	public void SelectPredefinedSignatoriesFromDropdown() throws Exception {
		deal_without_template.SelectPredefinedSignatoriesFromDropdown();
	}

	@Test(priority = 21)
	public void ClickOnConfirmButton() throws InterruptedException {
		deal_without_template.ClickOnConfirmButton();
	}

	@Test(priority = 22)
	public void ClickOnDropDown_Party2() throws InterruptedException {
		deal_without_template.ClickOnDropDown_Party2();

	}

	@Test(priority = 23)

	public void AddCustomSignatories_Party2() throws Exception {
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 24)

	public void Verify_EmptyFieldValidation_CustomeSignatories_Blank_FieldValidation_FullName() throws Exception {
		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_FullName();

	}

	@Test(priority = 25)

	public void Verify_EmptyFieldValidation_CustomeSignatories_Blank_FieldValidation_EmailAddress() throws Exception {

		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_EmailAddress();

	}

	@Test(priority = 26)
	public void VerifyInvalidInputs_fieldValidation_CustomeSignatories_Invalid_Input_AadhaarNumber() throws Exception {
//		deal_without_template.EnterSignatories_Invalid_DateOfBirth();

//		deal_without_HandlingNegativeScnarios.Invalid_Input_DateofBirth();

		deal_without_HandlingNegativeScnarios.Invalid_Input_AadhaarNumber();

	}

	@Test(priority = 27)
	public void VerifyInvalidInputs_fieldValidation_CustomeSignatories_Invalid_Input_EmailAddress() throws Exception {

		deal_without_HandlingNegativeScnarios.Invalid_Input_EmailAddress();

	}

	@Test(priority = 28)
	public void Verify_ClickOnCancelButton_AddSignatories() throws Exception {

		deal_without_HandlingNegativeScnarios.ClickOnCancelButton_AddSignatories();

	}

	@Test(priority = 29)

	public void ClickOnAddCustomSignatories_Party2() throws Exception {
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 30)
	public void EnterValidDetails_CustomSignatories_Party2() throws Exception {
		deal_without_template.EnterValidDetails_CustomSignatories_Party2();
	}

	@Test(priority = 31)
	public void Verify_AddCustomSignatories_party3() throws Exception {
		deal_without_template.AddCustomSignatories_Party3();

		deal_without_template.ClickOnProceedButton_OnpartyDetailsPage();

		Thread.sleep(15000);

	}

	@Test(priority = 32)

	public void Verify_performActionsBasedOnDealRefID() throws Exception {
		deal_without_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 33)
	public void Verify_ClickOnSendForExecutionButton() throws Exception {
		deal_without_template.ClickOnSendForExecutionButton();

	}

	@Test(priority = 34)
	public void Verify_ReadMailAnd_ClickOnReviewSignButton_forDealWithoutTemplate()
			throws MessagingException, IOException, InterruptedException, Exception {
		Thread.sleep(10000);
		// Call method fetchAndClickButton
		utilityClass.ReadMailAnd_ClickOnReviewSignButton_forDealWithoutTemplate();
	}

	@Test(priority = 35)
	public void Verify_EnterOTPFrom_Mail_forDealWithoutTemplate()
			throws MessagingException, IOException, InterruptedException {
		Thread.sleep(10000);
		UtilityClass.EnterOTPFrom_Mail(Deal_Without_Template.DealRefereneceID);
	}

	@Test(priority = 36)
	public void Verify_ClickOnVerifyButton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnVerifyButton();
	}

	@Test(priority = 37)
	public void Verify_ClickOnCheckBox() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBox();
	}

	@Test(priority = 38)
	public void Verify_ClickOnProceedToSignButton() throws Exception {
		signAgreementDocument_dealwithoutTemplate.ClickOnProceedToSignButton();
	}

	@Test(priority = 39)
	public void Verify_ClickOnCheckBoxOnAdharCard() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBoxOnAdharCard();
	}

	@Test(priority = 40)
	public void Verify_EnterAdharNumber() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.EnterAdharNumber();
	}

	@Test(priority = 41)
	public void Verify_ClickOnSendOTPbutton() throws InterruptedException {

		signAgreementDocument_dealwithoutTemplate.ClickOnSendOTPbutton();

//		driver.close();
	}

	@Test(priority = 42)
	public void Verify_SwitchToMainTab() throws InterruptedException {

		utilityClass.switchToTab(0);

	}

	@Test(priority = 43)
	public void Verify_AgreementPdf() throws InterruptedException {
		agreement_pdf_dealwithout_template.ClickOn_AgreementPdf_option();
	}

	@Test(priority = 44)

	public void Verify_OpenAgreementPdf() throws InterruptedException {

		utilityClass.switchToTab(1);

		utilityClass.CloseDriver();
	}

	@Test(priority = 45)
	public void SwitchToMainTab() throws InterruptedException {

		utilityClass.switchToTab(0);

	}

	@Test(priority = 46)

	public void Verify_EstampAgreementPdf() throws InterruptedException {

		estamp_agreement.ClickOn_AgreementPdf_option();
	}

	@Test(priority = 47)

	public void Verify_OpenEstampAgreementPdf() throws InterruptedException {

		utilityClass.switchToTab(1);

		utilityClass.CloseDriver();

		utilityClass.switchToTab(0);

	}

	@Test(priority = 48)
	public void Verify_DealStatus() throws InterruptedException {

		verifyStatusOf_dealAndAgreement.Verify_DealStatus();
	}

	@Test(priority = 49)
	public void Verify_AgreementStatus() throws InterruptedException {

		verifyStatusOf_dealAndAgreement.Verify_AgreementStatus();
	}

//	@Test(priority = 21)
//	public void mobileotp() throws InterruptedException {
//		MobileOTP_DealWithoutTemplate.mobile_otp();
//	}
//
	@Test(priority = 50)
	public void Verify_ClickOnLogoutButton() throws InterruptedException {

		loginpage.ClickOnLogoutButton();

	}

}
