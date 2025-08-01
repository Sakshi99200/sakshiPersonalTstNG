package com.TransBnk.TestClass_Deals_WithTemplate;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_with_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_with_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

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
	}

	@Test(priority = 19)

	public void Verify_EditParty_01_Details() throws Exception {

		edit_delete_addMultiple_scenarios_bulkbeneficiary_dealWithtemplate.EditParty_01_Details();

	}

	@Test(priority = 20)

	public void Verify_EditParty_02_Details() throws Exception {

		edit_delete_addMultiple_scenarios_bulkbeneficiary_dealWithtemplate.EditParty_02_Details();

	}

	@Test(priority = 21)

	public void Verify_EditParty_03_Details() throws Exception {

		edit_delete_addMultiple_scenarios_bulkbeneficiary_dealWithtemplate.EditParty_03_Details();

	}

	@Test(priority = 22)

	public void Verify_Delete_Party01_Details() throws Exception {

		edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party01_Details();

	}

	@Test(priority = 23)

	public void Verify_Delete_Party02_Details() throws Exception {

		edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party02_Details();

	}

	@Test(priority = 24)

	public void Verify_Delete_Party03_Details() throws Exception {

		edit_Delete_AddMultipleSignartories_Sceanrios.Delete_Party03_Details();

		edit_Delete_AddMultipleSignartories_Sceanrios.RefreshPage();

	}

	@Test(priority = 25)
	public void Verify_EnterNumberOfParties_() throws Exception {

//		// remove after use
//
//		deal_without_template.clickviewbutton();

		deal_with_template.EnterNumOfParties_AfterDeletingThePartyDetails();

	}

	@Test(priority = 26)
	public void AddCustomSignatories_party1_() throws Exception {
		
		deal_without_template.AddCustomeSignatories_Party1();
	}

	@Test(priority = 27)

	public void ClickOnSelectPredefinedSignatoriesOption_() throws InterruptedException {
		
		deal_without_template.ClickOnSelectPredefinedSignatoriesOption();
	}

	@Test(priority = 28)
	public void SelectPredefinedSignatoriesFromDropdown_() throws Exception {
		
		deal_without_template.SelectPredefinedSignatoriesFromDropdown();
	}

	@Test(priority = 29)
	public void ClickOnConfirmButton_() throws InterruptedException {
		
		deal_without_template.ClickOnConfirmButton();
	}

	@Test(priority = 30)
	public void ClickOnDropDown_Party2_() throws InterruptedException {
		
		deal_without_template.ClickOnDropDown_Party2();

	}

	@Test(priority = 31)

	public void AddCustomSignatories_Party2_() throws Exception {
		
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 32)

	public void Verify_EmptyFieldValidation_CustomeSignatories_() throws Exception {

		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_FullName();

		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_EmailAddress();

//		deal_without_HandlingNegativeScnarios.Blank_FieldValidation_MobileNumber();

	}

	@Test(priority = 33)
	public void VerifyInvalidInputs_fieldValidation_CustomeSignatories_() throws Exception {
//		deal_without_template.EnterSignatories_Invalid_DateOfBirth();

//		deal_without_HandlingNegativeScnarios.Invalid_Input_DateofBirth();

		deal_without_HandlingNegativeScnarios.Invalid_Input_AadhaarNumber();

		deal_without_HandlingNegativeScnarios.Invalid_Input_EmailAddress();

		deal_without_HandlingNegativeScnarios.ClickOnCancelButton_AddSignatories();

	}

	@Test(priority = 34)

	public void ClickOnAddCustomSignatories_Party2_() throws Exception {
	
		deal_without_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 35)
	public void EnterValidDetails_CustomSignatories_Party2_() throws Exception {
		
		deal_without_template.EnterValidDetails_CustomSignatories_Party2();
	}

	@Test(priority = 36)
	public void Verify_MultipleSIgnatoriesFlow() throws Exception {
		deal_without_template.ClickOnDropDown_Party2();
		edit_Delete_AddMultipleSignartories_Sceanrios
				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_01"));
		deal_without_template.ClickOnDropDown_Party2();
		edit_Delete_AddMultipleSignartories_Sceanrios
				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_02"));
		deal_without_template.ClickOnDropDown_Party2();
		Thread.sleep(200);
		edit_Delete_AddMultipleSignartories_Sceanrios

				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_03"));
		deal_without_template.ClickOnDropDown_Party2();
		Thread.sleep(200);
		edit_Delete_AddMultipleSignartories_Sceanrios
				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_04"));
		deal_without_template.ClickOnDropDown_Party2();
		Thread.sleep(200);
		edit_Delete_AddMultipleSignartories_Sceanrios
				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_05"));
		deal_without_template.ClickOnDropDown_Party2();
		Thread.sleep(200);
		edit_Delete_AddMultipleSignartories_Sceanrios
				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_06"));
		deal_without_template.ClickOnDropDown_Party2();
		edit_Delete_AddMultipleSignartories_Sceanrios
				.AddCustomSignatories_Multiple_times(utilityClass.getDatafromPropertyFile("signatoroies_emailID_07"));
		Thread.sleep(200);
	}

	@Test(priority = 37)
	public void Verify_AddCustomSignatories_party3_() throws Exception {

		deal_without_template.AddCustomSignatories_Party3();

		deal_without_template.ClickOnProceedButton_OnpartyDetailsPage();
		Thread.sleep(1000);
	}

	@Test(priority = 38)

	public void Verify_performActionsBasedOnDealRefID() throws Exception {

		deal_with_template.performActionsBasedOnDealRefID();

	}

//	@Test(priority = 39)
//	public void Verify_ClickOnSendForExecutionButton() throws Exception {
//
//		deal_with_template.ClickOnSendForExecutionButton();
//
//	}

	@Test(priority = 40)
	public void VerifyErrorValidationMsg_ForAddingMultipleSignatoires() throws InterruptedException {

		edit_Delete_AddMultipleSignartories_Sceanrios.ErrorValidationMsg_ForAddingMultipleSignatoires();
	}

	@Test(priority = 41)

	public void Verify_CancelAgreement() {

		edit_Delete_AddMultipleSignartories_Sceanrios.Cancel_Agreement();
	}

	@Test(priority = 42)
	public void Verify_DealStatus_AfterCancelAgreement() throws InterruptedException {

		deal_without_HandlingNegativeScnarios.pageUp();
		deal_without_HandlingNegativeScnarios.pageUp();
		deal_without_HandlingNegativeScnarios.pageUp();
		deal_without_HandlingNegativeScnarios.pageUp();
		deal_without_HandlingNegativeScnarios.pageUp();
		deal_without_HandlingNegativeScnarios.pageUp();
		verifyStatusOf_dealAndAgreement.Verify_DealStatus_AfterCancelAgreement();

	}

	@Test(priority = 43)
	public void Verify_AgreementStatus_AfterCancelAgreement() throws InterruptedException {

		verifyStatusOf_dealAndAgreement.Verify_AgreementStatus_AfterCancelAgreement();

	}

//	@Test(priority = 44)
//
//	public void ClickOnLogoutButton() throws Exception {
//
//		loginpage.ClickOnLogoutButton();
//
//	}

}
