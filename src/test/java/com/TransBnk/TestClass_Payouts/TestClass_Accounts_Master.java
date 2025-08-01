package com.TransBnk.TestClass_Payouts;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Accounts_Master extends BaseTest {

	@Test(priority = 1)
	public void Verify_Select_Entity() throws Exception {

		deal_without_template.select_Entity(UtilityClass.getDatafromPropertyFile("Entity_name"));

	}

	@Test(priority = 2)
	public void Verify_Select_Product() throws Exception {

		deal_without_template.select_Product(UtilityClass.getDatafromPropertyFile("ProductName"));

	}

	@Test(priority = 3)
	public void Verify_ClickOn_PayoutsOption() throws InterruptedException {

		accounts_master.ClickOn_PayoutsOption();

	}

	@Test(priority = 4)
	public void Verify_ClickOn_Accounts_Master() throws InterruptedException {

		accounts_master.ClickOn_AccountMasterOption();

	}

	@Test(priority = 5)
	public void Verify_ClickOn_UploadButton() throws InterruptedException {

		accounts_master.ClickOn_UploadButton();
	}

	@Test(priority = 6)
	public void Verify_Upload_BlankFile() throws InterruptedException {

		accounts_master.Upload_BlankFile();
	}

	@Test(priority = 7)
	public void Veirfy_ErrorValidationForUploading_BlankFile() {

		accounts_master.Check_ErrorValidationForUploading_BlankFile();
	}

}
