package com.TransBnk.Library;

import java.util.Properties;
import java.util.Set;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	private WebDriver driver;

	@FindBy(xpath = "(//input[@id=\"email\"])[1]")
	private WebElement Email;

	@FindBy(xpath = "(//input[@id=\"password\"])[1]")
	private WebElement password;

	@FindBy(xpath = "//div[@class=\"container ng-star-inserted\"]")
	private WebElement click;

	@FindBy(xpath = "//button[text()=' Sign In ']")
	private WebElement SignIn;

	@FindBy(xpath = "//*[@id=\"dropdownMenuButton\"]/img")
	private WebElement Profile;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement Logout;

	@FindBy(xpath = "//a[contains(.,'Forgot password')]")
	private WebElement ForgotPasswrod;

	@FindBy(xpath = "//input[@placeholder=\"Enter email id\"]")
	private WebElement EnterEmailID_forgotPasswrod;

	@FindBy(xpath = "//button[contains(.,'Send')]")
	private WebElement SendButton;

	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement ContactUs;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void Blank_fieldValidation_SignIn() throws InterruptedException {

		System.out.println("Executing method :" + "LoginPage.Blank_fieldValidation_SignIn()");

		try {
			// to validate error message click on email field
			Email.click();

			click.click();

			// to validate error message click on password field

			password.click();

			click.click();

			Thread.sleep(1000);
			// email field validation message
			WebElement validationMsg_Email = driver.findElement(By.xpath("//small[text()=' Email id is required ']"));

			String ValidationMsg_Email = validationMsg_Email.getText();

			Assert.assertTrue(validationMsg_Email.isDisplayed(),
					"Validation message for Email field is not displayed.");

			System.out.println("blank field validation message for email " + ValidationMsg_Email);

			Thread.sleep(1000);
			// password field validation message
			WebElement validationMsg_Password = driver
					.findElement(By.xpath("//small[text()=' Password is Required ']"));

			String Validation_Password = validationMsg_Password.getText();

			Assert.assertTrue(validationMsg_Password.isDisplayed(),
					"Success message for password field is not displayed.");

			System.out.println("blank field validation message for password field" + Validation_Password);

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error in method :" + "LoginPage.Blank_fieldValidation_SignIn()");
		}

	}

	public void Invalid_input_signIn() throws Exception {

		System.out.println("Executing method :" + "LoginPage.Invalid_input_signIn()");

		try {
			Email.sendKeys(UtilityClass.getDatafromPropertyFile("Invalid_EmailId_login"));

			Thread.sleep(1000);
			// email field validation message
			// capture error message for enter invalid **Email** field
			WebElement Email_errorMsg = driver.findElement(By.xpath("//small[text()=' Invalid Email id ']"));
			String email = Email_errorMsg.getText();
			System.out.println(email);
			System.out.println("Error message for loginpage Email id field: " + email);

			String Actual_ErrorMsg_email = "Invalid Email id";

			if (Email_errorMsg.isDisplayed()) {
				Assert.assertEquals(email, Actual_ErrorMsg_email,
						"error validation message is not displayed for wrong email id field ");

				Assert.assertTrue(true, Actual_ErrorMsg_email);

				Thread.sleep(800);

				Email.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			} else {
				System.out.println("error validation message is not displayed");
			}

		} catch (Exception e) {

			System.err.println("error occur in :" + "LoginPage.Invalid_input_signIn()");
			System.err.println(e);
		}
	}

	public void SignIn_with_Valid_Credentials(String username, String Password) throws Exception {

		System.out.println("executing method :" + "LoginPage.SignIn_with_Valid_Credentials()");

		try {

			// enter valid credentials
			Thread.sleep(1000);
			// enter email id
			Email.sendKeys(username);

			// enter password
			password.sendKeys(Password);

			Thread.sleep(400);
			// click on sign in button
			SignIn.click();

			System.out.println("successfully sign in ..");

		} catch (Exception e) {

			System.err.println("Error in method :" + "LoginPage.SignIn_with_Valid_Credentials()");
			System.err.println(e);
		}
	}

	// ** click on profile and logout **//

	public void ClickOnLogoutButton() throws InterruptedException {

		System.out.println("Executing method :" + "LoginPage.ClickOnLogoutButton()");

		Thread.sleep(4000);
		// click on profile
		Profile.click();

		// click on logut button
		Thread.sleep(500);
		Logout.click();
		
		System.out.println("User Logout Successfully.");
	}

	// ** Click on forgot password option ** //

	public void ClickOnForgotPassword() throws InterruptedException {

		System.out.println("executing method :" + "LoginPage.ClickOnForgotPassword()");

		try {

			Thread.sleep(300);
			ForgotPasswrod.click();

		} catch (Exception e) {
			System.err.println("Error in method :" + "LoginPage.ClickOnForgotPassword()");
			System.err.println(e);
		}
	}

	// ** enter email id for forgot password field
	public void Enter_EmailID_forForgotPasswordField() throws Exception {

		System.out.println("eexcuting method :" + "LoginPage.Enter_EmailID_forForgotPasswordField()");

		try {

			Thread.sleep(400);

			EnterEmailID_forgotPasswrod.sendKeys(UtilityClass.getDatafromPropertyFile("Valid_EmailId_login"));

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			System.err.println("Error in method :" + "LoginPage.Enter_EmailID_forForgotPasswordField()");
		}
	}

	// ** click on save button ** //

	public void ClickOnSendButton() throws InterruptedException {

		System.out.println("execting method :" + "LoginPage.ClickOnSendButton()");
		Thread.sleep(200);

		SendButton.click();
	}

	public void VerifyForgotPasswordMail() throws InterruptedException {

		System.out.println("Executing method :" + "LoginPage.VerifyForgotPasswordMail()");
		Thread.sleep(3000);

		String host = "imap.gmail.com"; // IMAP server host
		String username1 = "sakshi.bodhare@techstalwarts.com";
		String password1 = "zkztrufkmjqfkeqe";

		// Expected subject of the email
		String expectedSubject = "TransBnk password reset request.";

		try {
			// Get session
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", "imaps");
			Session session = Session.getInstance(props);

			// Connect to the IMAP server
			Store store = session.getStore();
			store.connect(host, username1, password1);

			// Get inbox folder
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			// Get messages
			Message[] messages = inbox.getMessages();

			// Iterate through messages to find the one with the expected subject
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				if (message.getSubject().equals(expectedSubject)) {
					// Print sender, subject, and content of the email
					System.out.println("Found email with subject: " + expectedSubject);
					System.out.println("From: " + message.getFrom()[0]);
					System.out.println("Subject: " + message.getSubject());
					System.out.println("Content: " + message.getContent());
					break; // Exit loop once the expected email is found
				}
			}

			// Close connections
			inbox.close(false);
			store.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ** click on Contact us option to verify that page is redirect to the expected
	// page or not

	public void ClickOn_ContactUs_Option() throws InterruptedException {
		System.out.println("execurting method :" + "LoginPage.ClickOn_ContactUs_Option()");

		// click on contact us option
		Thread.sleep(1000);
		ContactUs.click();

		// Get the window handles to identify the newly opened tab
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Switch to the newly opened tab
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(900);
				break;
			}
		}

		// Get the current URL of the newly opened tab
		String currentUrl = driver.getCurrentUrl();

		// Assert whether the current URL matches the expected URL
		String expectedUrl = "https://sandbox.trusthub.in/";
		Assert.assertEquals(currentUrl, expectedUrl, "URL of the new tab is not as expected");
		System.out.println("after click on Contact US option  expected URL is opened..");
		driver.close();

		// Switch back to the parent window
		driver.switchTo().window(mainWindowHandle);

	}

}
