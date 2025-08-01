package com.TransBnk.TestClass_Deals;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Delete_TemplateFields_RepeatingSection extends BaseTest {
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
	public void Verify_Delete_TemplateFields_StateName() throws Exception {

		delete_templateFields_repeatingSection.Verify_Delete_TemplateFields_StateName();

	}

	@Test(priority = 6)
	public void Verify_ClickOn_YesButton_ToDeleteField_StateName() throws InterruptedException {

		delete_templateFields_repeatingSection.ClickOn_YesButton_ToDeleteField();
	}

	@Test(priority = 7)
	public void Verify_Delete_TemplateField_StateName() throws Exception {

		delete_templateFields_repeatingSection.Verify_Delete_TemplateFields_StateName();

	}

	@Test(priority = 8)
	public void Verify_ClickOn_YesButton_ToDeleteField_AgreementDate() throws InterruptedException {

		delete_templateFields_repeatingSection.ClickOn_YesButton_ToDeleteField();
	}

	@Test(priority = 9)
	public void Verify_Delete_RepeatingSection() throws Exception {

		delete_templateFields_repeatingSection.Verify_Delete_TemplateFields_repeatingSection();

	}

	@Test(priority = 10)
	public void Verify_ClickOn_YesButton_ToDeleteField_repeatingSection() throws InterruptedException {

		delete_templateFields_repeatingSection.ClickOn_YesButton_ToDeleteField();
	}
}
