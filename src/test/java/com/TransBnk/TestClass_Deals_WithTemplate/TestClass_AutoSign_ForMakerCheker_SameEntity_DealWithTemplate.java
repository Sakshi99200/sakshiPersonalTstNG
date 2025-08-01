package com.TransBnk.TestClass_Deals_WithTemplate;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.annotations.Test;

import com.TransBnk.Deal.Deal_With_Template;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_AutoSign_ForMakerCheker_SameEntity_DealWithTemplate extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_with_template
				.select_Entity(UtilityClass.getDatafromPropertyFile("EntityName_AutoSignMakerCheker_sameEntity"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_with_template
				.select_Product(UtilityClass.getDatafromPropertyFile("ProgramName_AutoSignMakerChecker_sameEntity"));

	}

	@Test(priority = 3)
	public void Verify_ClickOnDocuflow() throws InterruptedException {

		deal_with_template.ClickOnDocuflowOption();

	}

	@Test(priority = 4)
	public void Verify_ClickOnDeals() throws InterruptedException {

		deal_with_template.ClickOnDealsOption();

		deal_with_template.ClickOn_CreateDeal_Button();
	}

	@Test(priority = 5)
	public void Verify_Deal_creation_page() throws Exception {

		deal_with_template.enter_Deal_reference_ID();

		deal_with_template.Select_Agreement_State();
		deal_with_template.Enter_ConsiderationAmount();
		deal_with_template.Select_Agreement_Date();
		deal_with_template.Select_DocumentType(UtilityClass.getDatafromPropertyFile("DocumentType01"));
		deal_with_template.Select_productName(UtilityClass.getDatafromPropertyFile("ProductName_ForAutoSign"));
		deal_with_template.ClickOnRequireTemplateRadioButton();
		deal_with_template.ClickOnProceedButton();

	}

	@Test(priority = 6)
	public void Verify_searchCreatedTemplate_AndClickOnCreateButton() throws Exception {

		deal_with_template.searchCreatedTemplate_AndClickOnCreateButton();
	}

	@Test(priority = 7)
	public void Verify_EnterNumberOf_Parties() throws Exception {
		deal_with_template.EnterNumOfParties_and_details();
	}

	@Test(priority = 8)
	public void Verify_autoSign_forParty1() throws Exception {
		autosign_signatories_dealwithout_template.Check_AutoSign_PartySignatoires();
	}

	@Test(priority = 9)

	public void Verify_CustomeSignatoriesFor_autoSignatoriesParty() throws Exception {
		autosign_signatories_dealwithout_template.AddCustomSignatories_ForAutoSignParty();
	}

	@Test(priority = 10)
	public void ClickOnDropDown_Party2() throws InterruptedException {
		deal_without_template.ClickOnDropDown_Party2();

	}

	@Test(priority = 11)

	public void AddCustomSignatories_Party2() throws Exception {
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 12)

	public void Verify_EmptyFieldValidation_CustomeSignatories() throws Exception {
		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_FullName();

		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_EmailAddress();

//		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_MobileNumber();

	}

	@Test(priority = 13)
	public void VerifyInvalidInputs_fieldValidation_CustomeSignatories() throws Exception {
//		deal_without_template.EnterSignatories_Invalid_DateOfBirth();

//		deal_without_HandlingNegativeScnarios.Invalid_Input_DateofBirth();

		deal_without_HandlingNegativeScnarios.Invalid_Input_AadhaarNumber();

		deal_without_HandlingNegativeScnarios.Invalid_Input_EmailAddress();

		deal_without_HandlingNegativeScnarios.ClickOnCancelButton_AddSignatories();

	}

	@Test(priority = 14)

	public void ClickOnAddCustomSignatories_Party2() throws Exception {
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 15)
	public void EnterValidDetails_CustomSignatories_Party2() throws Exception {

		deal_without_template.EnterValidDetails_CustomSignatories_Party2();
	}

	@Test(priority = 16)
	public void Verify_AddCustomSignatories_party3() throws Exception {

		deal_without_template.AddCustomSignatories_Party3();

		deal_without_template.ClickOnProceedButton_OnpartyDetailsPage();

		Thread.sleep(15000);

	}

	@Test(priority = 17)

	public void Verify_performActionsBasedOnDealRefID() throws Exception {

		deal_with_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 18)
	public void Verify_ClickOnSubmitForVerificationButton() throws Exception {

		makercheckerFlow_forsameEntity.ClickOnSubmitForVerificationButton();

	}

	@Test(priority = 19)
	public void ClickOnDocuflowOption() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 20)

	public void ClickOn_DealVerificationOption() throws InterruptedException {
		makercheckerFlow_forsameEntity.ClickOnDealVerificationOption();
	}

	@Test(priority = 21)

	public void PerformActionBasedOnDealID_ForDeal_Verification() throws Exception {

		deal_with_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 22)
	public void ClickOnSendForExecutionButton() throws Exception {

		deal_without_template.ThreadSleep();

		deal_without_template.ThreadSleep();

		deal_without_template.ClickOnSendForExecutionButton();

	}

	@Test(priority = 23)
	public void Verify_ReadMailAnd_ClickOnReviewSignButton_forDealWithoutTemplate()
			throws MessagingException, IOException, InterruptedException, Exception {
		Thread.sleep(10000);
		// Call method fetchAndClickButton

		utilityClass.ReadMailAnd_ClickOnReviewSignButton_forDealWithTemplate();

		UtilityClass.EnterOTPFrom_Mail(Deal_With_Template.DealWithtemplate_RefereneceID);
	}

	@Test(priority = 24)
	public void Verify_ClickOnVerifyButton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnVerifyButton();
	}

	@Test(priority = 25)
	public void Verify_ClickOnCheckBox() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBox();
	}

	@Test(priority = 26)
	public void Verify_ClickOnProceedToSignButton() throws Exception {
		signAgreementDocument_dealwithoutTemplate.ClickOnProceedToSignButton();
	}

	@Test(priority = 27)
	public void Verify_ClickOnCheckBoxOnAdharCard() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBoxOnAdharCard();
	}

	@Test(priority = 28)
	public void Verify_EnterAdharNumber() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.EnterAdharNumber();
	}

	@Test(priority = 29)
	public void Verify_ClickOnSendOTPbutton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnSendOTPbutton();
//		driver.close();
	}

	@Test(priority = 30)
	public void Verify_SwitchToMainTab() throws InterruptedException {

		utilityClass.switchToTab(0);

	}

//	@Test(priority = 31)
//	public void Verify_ClickOnLogoutButton() throws InterruptedException {
//
//		loginpage.ClickOnLogoutButton();
//
//	}
}
