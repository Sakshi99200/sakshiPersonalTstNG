package com.TransBnk.TestClass_Deals;

import org.testng.annotations.Test;

import com.TransBnk.Library.UtilityClass;
import com.TransBnk.testutility.BaseTest;

public class TestClass_Login extends BaseTest {

//	@Test(priority = 1)
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
//	public void Verify_ClickOnForgotPassword() throws Exception {
//
//		loginpage.ClickOnForgotPassword();
//
//	}
//
//	@Test(priority = 3)
//	public void Verify_Enter_EmailID_forForgotPasswordField() throws Exception {
//
//		loginpage.Enter_EmailID_forForgotPasswordField();
//
//	}
//
//	@Test(priority = 4)
//	public void Verify_ClickOnSendButton() throws Exception {
//
//		loginpage.ClickOnSendButton();
//
//	}
//
//	@Test(priority = 5)
//	public void Verify_ForgotPasswordMail() throws InterruptedException {
//
//		loginpage.VerifyForgotPasswordMail();
//	}
//
//	@Test(priority = 6)
//	public void Verify_ContactUsOption() throws InterruptedException {
//
//		loginpage.ClickOn_ContactUs_Option();
//	}

	@Test(priority = 7)
	public void Verify_Valid_input_SignInPage() throws Exception {

		loginpage.SignIn_with_Valid_Credentials(UtilityClass.getDatafromPropertyFile("Valid_EmailId_login"),
				UtilityClass.getDatafromPropertyFile("Valid_Password_login"));

	}

}
