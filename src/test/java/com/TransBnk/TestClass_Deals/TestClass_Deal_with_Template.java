package com.TransBnk.TestClass_Deals;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.annotations.Test;

import com.TransBnk.Deal.Deal_With_Template;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Deal_with_Template extends BaseTest {

	@Test(priority = 1)
	public void Verify_Valid_input_SignInPage() throws Exception {

		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("Valid_EmailId_login"),
				UtilityClass.getDatafromPropertyFile("Valid_Password_login"));

	}
//
//	@Test(priority = 2)
//	public void Verify_Valid_input_SignInPage() throws Exception {
//
//		loginpage.SignIn_with_Valid_Credentials();
//
//	}

	@Test(priority = 3)
	public void Verify_Select_Entity() throws Exception {

		deal_with_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 4)
	public void Verify_Select_Product() throws Exception {

		deal_with_template.select_Product(UtilityClass.getDatafromPropertyFile("Product_name"));

	}

	@Test(priority = 5)
	public void Verify_ClickOnDocuflow() throws InterruptedException {

		deal_with_template.ClickOnDocuflowOption();

	}

	@Test(priority = 6)
	public void Verify_ClickOnDeals() throws InterruptedException {

		deal_with_template.ClickOnDealsOption();

		deal_with_template.ClickOn_CreateDeal_Button();
	}

	@Test(priority = 7)
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

	@Test(priority = 8)
	public void Verify_searchCreatedTemplate_AndClickOnCreateButton() throws Exception {

		deal_with_template.searchCreatedTemplate_AndClickOnCreateButton();
	}

	@Test(priority = 9)
	public void Verify_EnterNumberOf_Parties() throws Exception {
		deal_with_template.EnterNumOfParties_and_details();
	}

	@Test(priority = 10)
	public void AddCustomSignatories_party1() throws Exception {
		deal_with_template.AddCustomSignatories_Party1();
	}

	@Test(priority = 11)
	public void Verify_AddCustomSignatories_party2() throws Exception {
		deal_with_template.AddCustomSignatories_Party2();
	}

	@Test(priority = 12)
	public void Verify_AddCustomSignatories_party3() throws Exception {
		deal_with_template.AddCustomSignatories_Party3();

		deal_without_template.ClickOnProceedButton_OnpartyDetailsPage();

		Thread.sleep(15000);

	}

	@Test(priority = 13)

	public void Verify_performActionsBasedOnDealRefID() throws Exception {
		deal_with_template.performActionsBasedOnDealRefID();

	}

	@Test(priority = 14)
	public void Verify_ClickOnSendForExecutionButton() throws Exception {
		deal_with_template.ClickOnSendForExecutionButton();

	}

	@Test(priority = 15)
	public void Verify_ReadMailAnd_ClickOnReviewSignButton_forDealWithTemplate()
			throws MessagingException, IOException, InterruptedException, Exception {
		Thread.sleep(10000);
		// Call method fetchAndClickButton
		utilityClass.ReadMailAnd_ClickOnReviewSignButton_forDealWithTemplate();

		UtilityClass.EnterOTPFrom_Mail(Deal_With_Template.DealWithtemplate_RefereneceID);
	}

	@Test(priority = 16)
	public void Verify_ClickOnVerifyButton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnVerifyButton();
	}

	@Test(priority = 17)
	public void Verify_ClickOnCheckBox() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBox();
	}

	@Test(priority = 18)
	public void Verify_ClickOnProceedToSignButton() throws Exception {
		signAgreementDocument_dealwithoutTemplate.ClickOnProceedToSignButton();
	}

	@Test(priority = 19)
	public void Verify_ClickOnCheckBoxOnAdharCard() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnCheckBoxOnAdharCard();
	}

	@Test(priority = 20)
	public void Verify_EnterAdharNumber() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.EnterAdharNumber();
	}

	@Test(priority = 21)
	public void Verify_ClickOnSendOTPbutton() throws InterruptedException {
		signAgreementDocument_dealwithoutTemplate.ClickOnSendOTPbutton();
	}

	@Test(priority = 22)
	public void Verify_SwitchToOriginalTab() throws InterruptedException {

		utilityClass.switchToTab(0);

	}

	@Test(priority = 23)
	public void Verify_ClickOnLogoutButton() throws InterruptedException {

		loginpage.ClickOnLogoutButton();

	}
}
