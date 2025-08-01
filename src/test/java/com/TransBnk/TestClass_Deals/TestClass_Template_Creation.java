package com.TransBnk.TestClass_Deals;

import org.testng.annotations.Test;

import com.TransBnk.Deal.Template_Creation;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Template_Creation extends BaseTest {

	@Test(priority = 2)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 3)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("ProductName"));

	}

	@Test(priority = 4)
	public void VerifyClickOnDocuflow() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 5)
	public void VerifyClickOnTemplate() throws InterruptedException {

		template_creation.ClickOnTemplate();

		template_creation.openTempltefortest();

	}

//	@Test(priority = 6)
//	public void VerifyAddTemplateButtonw() throws InterruptedException {
//
//		template_creation.AddTemplateButton();
//	}
//
//	@Test(priority = 7)
//	public void VerifyEnter_TemplateName() throws Exception {
//
//		template_creation.Enter_TemplateName();
//
//	}
//
//	@Test(priority = 8)
//	public void VerifyEnterTemplateDesciption() throws Exception {
//
//		template_creation.EnterTemplateDesciption();
//
//	}
//
//	@Test(priority = 9)
//	public void VerifySelect_Product() throws Exception {
//
//		template_creation.select_Product(utilityClass.getDatafromPropertyFile("SelectProduct01"));
//
//	}
//
//	@Test(priority = 10)
//	public void VerifySelect_DocumentType() throws Exception {
//
//		template_creation.Select_DocumentType();
//
//	}
//
//	@Test(priority = 11)
//	public void VerifyUploadTemplate() throws Exception {
//
//		template_creation.UploadTemplate();
//
//	}
//
//	@Test(priority = 12)
//	public void VerifyClickonSaveButton() throws Exception {
//
//		template_creation.ClickonSaveButton();
//
//	}

	@Test(priority = 13)
	public void VerifyState() throws Exception {

		template_creation.state();

	}

	@Test(priority = 14)
	public void VerifyClickOn_MarkTemplateField() throws Exception {

		template_creation.ClickOn_MarkTemplateField();

	}

	@Test(priority = 15)
	public void VerifySelectStateName_FromPredefinedList() throws Exception {

		template_creation.SelectStateName_FromPredefinedList(utilityClass.getDatafromPropertyFile("SectionName_State"));

	}

	@Test(priority = 16)
	public void VerifyClickOnConfirmButton() throws Exception {

		template_creation.ClickOnConfirmButton();

	}

	@Test(priority = 17)
	public void VerifyAgreementDate() throws Exception {

		template_creation.AgreementDate();

	}

	@Test(priority = 18)
	public void VerifyClickOn_MarkTemplateField_agreementDate() throws Exception {

		template_creation.ClickOn_MarkTemplateField();

	}

	@Test(priority = 19)
	public void VerifySelectStateName_FromPredefinedList_AgreementDate() throws Exception {

		template_creation
				.SelectStateName_FromPredefinedList(utilityClass.getDatafromPropertyFile("Section_AgreementDate"));

	}

	@Test(priority = 20)
	public void VerifyClickOnConfirmButton_agreeementDAte() throws Exception {

		template_creation.ClickOnConfirmButton();

	}

	@Test(priority = 21)
	public void VerifyAddRepeatingSection() throws InterruptedException {

		template_creation.AddRepeatingSection();
	}

	@Test(priority = 22)
	public void Verify_ClickOn_MarkRepeatingSection() throws InterruptedException {

		template_creation.ClickOn_MarkRepeatingSection();
	}

}
