package com.TransBnk.TestClass_Deals;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_edit_template extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("ProductName"));

	}

	@Test(priority = 3)
	public void VerifyClickOnDocuflow() throws InterruptedException {

		deal_without_template.ClickOnDocuflowOption();

	}

	@Test(priority = 4)
	public void VerifyClickOnTemplate() throws InterruptedException {

		template_creation.ClickOnTemplate();

		template_creation.openTempltefortest();

	}

	@Test(priority = 5)
	public void Verify_AddedTemplateFields_StateName() throws Exception {

		edit_template.Verify_AddedTemplateFields_StateName();
	}

	@Test(priority = 6)
	public void Verify_AddedTemplateFields_AgreementDate() throws Exception {

		edit_template.Verify_AddedTemplateFields_AgreementDate();

	}

	
	
}
