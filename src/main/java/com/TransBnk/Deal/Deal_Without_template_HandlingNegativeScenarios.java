package com.TransBnk.Deal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Deal_Without_template_HandlingNegativeScenarios {

	public WebDriver driver;
	@FindBy(xpath = "(//input[@formcontrolname=\"dealReferenceId\"])[1]")
	private WebElement DealReferenceId;

	@FindBy(xpath = "//input[@placeholder=\"Enter Date\"]")
	private WebElement AgreementDate;

	@FindBy(xpath = "//input[@placeholder=\"Enter Deal Batch Id\"]")
	private WebElement LinkDealtoExistingDealReferenceID;

	@FindBy(xpath = "//button[contains(.,' Cancel ')]")
	private WebElement CancelButton;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryName\"]")
	private WebElement Signatories_FullName;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryEmail\"]")
	private WebElement Signatories_EmailAddress;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryMobile\"]")
	private WebElement Signatories_MobileNumber;

	@FindBy(xpath = "//input[@id=\"aadharNumber\"]")
	private WebElement Signatories_AdharNumber;

	@FindBy(xpath = "//input[@id=\"emailAddress\"]")
	private WebElement Signatories_emailAddress;

	@FindBy(xpath = "//*[@id=\"confirmSignatory\"]//div[2]//div/button[1]")
	private WebElement CancelButton_AddSignatories;

	public Deal_Without_template_HandlingNegativeScenarios(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ******Deal creation ******//

	// field validation for empty fields ( deal creation without template)

	// Method for blank field validation - Deal Reference ID
	public void Blank_FieldValidation_DealReferenceID() throws InterruptedException {
		System.out.println("Executing Method: Blank_FieldValidation_DealReferenceID()");

		Thread.sleep(5000);
		try {
			DealReferenceId.click();
			Actions actions = new Actions(driver);

			// pressing the "Tab" key TWO times using a loop
			int tabCount = 1;
			for (int i = 0; i < tabCount; i++) {
				actions.sendKeys(Keys.TAB).build().perform();
			}
			WebElement EmptyFieldValidation_DealRefID = driver
					.findElement(By.xpath("//small[contains(.,'Deal Reference id is Required')]"));

			String ValidationMsg_DealrefID = EmptyFieldValidation_DealRefID.getText();

			Assert.assertTrue(EmptyFieldValidation_DealRefID.isDisplayed(),
					"Validation message for Deal reference ID is not displayed.");

			System.out.println("blank field validation message for Deal Reference ID :  " + ValidationMsg_DealrefID);

		} catch (Exception e) {
			System.err.println("Error in method: Blank_FieldValidation_DealReferenceID()");
			e.printStackTrace();
			Assert.fail("Error in method: Blank_FieldValidation_DealReferenceID()");
		}
	}

	// Method for blank field validation - Agreement State
	public void Blank_FieldValidation_AgreementState() {
		System.out.println("Executing Method: Blank_FieldValidation_AgreementState()");
		try {
			Actions actions = new Actions(driver);
			for (int i = 0; i < 2; i++) {
				actions.sendKeys(Keys.TAB).build().perform();
			}
			Thread.sleep(100);

			WebElement validationMessageElement = driver
					.findElement(By.xpath("//small[contains(text(),'Agreement State is Required')]"));
			String validationMessageText = validationMessageElement.getText();

			Assert.assertTrue(validationMessageElement.isDisplayed(),
					"Validation message for Agreement State is not displayed.");
			System.out.println("Blank field validation message for Agreement State: " + validationMessageText);

		} catch (Exception e) {
			System.err.println("Error in method: Blank_FieldValidation_AgreementState()");
			e.printStackTrace();
			Assert.fail("Error in method: Blank_FieldValidation_AgreementState()");
		}
	}

	// Method for blank field validation - Consideration Amount
	public void Blank_FieldValidation_ConsiderationAmount() {
		System.out.println("Executing Method: Blank_FieldValidation_ConsiderationAmount()");
		try {
			Actions actions = new Actions(driver);
			for (int i = 0; i < 1; i++) {
				actions.sendKeys(Keys.TAB).build().perform();
			}
			Thread.sleep(100);

			WebElement validationMessageElement = driver
					.findElement(By.xpath("//small[contains(text(),'Consideration Amount is Required')]"));
			String validationMessageText = validationMessageElement.getText();

			Assert.assertTrue(validationMessageElement.isDisplayed(),
					"Validation message for Consideration Amount is not displayed.");
			System.out.println("Blank field validation message for Consideration Amount: " + validationMessageText);

		} catch (Exception e) {
			System.err.println("Error in method: Blank_FieldValidation_ConsiderationAmount()");
			e.printStackTrace();
			Assert.fail("Error in method: Blank_FieldValidation_ConsiderationAmount()");
		}
	}

	// Method for blank field validation - Agreement Date
	public void Blank_FieldValidation_AgreementDate() {
		System.out.println("Executing Method: Blank_FieldValidation_AgreementDate()");
		try {
			Actions actions = new Actions(driver);
			for (int i = 0; i < 3; i++) {
				actions.sendKeys(Keys.TAB).build().perform();
			}
			Thread.sleep(100);

			WebElement validationMessageElement = driver
					.findElement(By.xpath("//small[contains(text(),'Agreement Date is Required')]"));
			String validationMessageText = validationMessageElement.getText();

			Assert.assertTrue(validationMessageElement.isDisplayed(),
					"Validation message for Agreement Date is not displayed.");
			System.out.println("Blank field validation message for Agreement Date: " + validationMessageText);

		} catch (Exception e) {
			System.err.println("Error in method: Blank_FieldValidation_AgreementDate()");
			e.printStackTrace();
			Assert.fail("Error in method: Blank_FieldValidation_AgreementDate()");
		}
	}

	// Method for blank field validation - Product
	public void Blank_FieldValidation_Product() {
		System.out.println("Executing Method: Blank_FieldValidation_Product()");
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(100);

			WebElement validationMessageElement = driver
					.findElement(By.xpath("//small[contains(text(),'Product is Required')]"));
			String validationMessageText = validationMessageElement.getText();

			Assert.assertTrue(validationMessageElement.isDisplayed(),
					"Validation message for Product is not displayed.");
			System.out.println("Blank field validation message for Product: " + validationMessageText);

		} catch (Exception e) {
			System.err.println("Error in method: Blank_FieldValidation_Product()");
			e.printStackTrace();
			Assert.fail("Error in method: Blank_FieldValidation_Product()");
		}
	}

	// Method for blank field validation - Document Type
	public void Blank_FieldValidation_DocumentType() {
		System.out.println("Executing Method: Blank_FieldValidation_DocumentType()");
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(100);

			WebElement validationMessageElement = driver
					.findElement(By.xpath("//small[contains(text(),'Document Type is Required')]"));
			String validationMessageText = validationMessageElement.getText();

			Assert.assertTrue(validationMessageElement.isDisplayed(),
					"Validation message for Document Type is not displayed.");
			System.out.println("Blank field validation message for Document Type: " + validationMessageText);

		} catch (Exception e) {
			System.err.println("Error in method: Blank_FieldValidation_DocumentType()");
			e.printStackTrace();
			Assert.fail("Error in method: Blank_FieldValidation_DocumentType()");
		}
	}

	// Method for invalid input - Deal Reference ID
	public void Invalid_Input_DealReferenceID() {
		System.out.println("Executing Method: Invalid_Input_DealReferenceID()");
		try {
			Thread.sleep(400);
			DealReferenceId.sendKeys(UtilityClass.getDatafromPropertyFile("InvalidInput_DealrefID"));

			System.out.println("Entered invalid input for Deal Reference ID.");

		} catch (Exception e) {
			System.err.println("Error in method: Invalid_Input_DealReferenceID()");
			e.printStackTrace();
			Assert.fail("Error in method: Invalid_Input_DealReferenceID()");
		}
	}

	// Method for invalid input - Link Deal to Existing Deal Reference ID
	public void Invalid_Input_LinkDealtoExistingDealReferenceID() {
		System.out.println("Executing Method: Invalid_Input_LinkDealtoExistingDealReferenceID()");
		try {
			LinkDealtoExistingDealReferenceID
					.sendKeys(UtilityClass.getDatafromPropertyFile("Invalid_Input_LinkDealtoExistingDealReferenceID"));

			System.out.println("Entered invalid input for Link Deal to Existing Deal Reference ID.");

		} catch (Exception e) {
			System.err.println("Error in method: Invalid_Input_LinkDealtoExistingDealReferenceID()");
			e.printStackTrace();
			Assert.fail("Error in method: Invalid_Input_LinkDealtoExistingDealReferenceID()");
		}
	}

	// Method for invalid input - Agreement Date
	public void Invalid_Input_AgreementDate() {
		System.out.println("Executing Method: Invalid_Input_AgreementDate()");
		try {
			// Get today's date
			LocalDate currentDate = LocalDate.now();

			// Subtract one day to get yesterday's date
			LocalDate yesterdayDate = currentDate.minusDays(1);

			// Format the date if needed
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formattedYesterdayDate = yesterdayDate.format(formatter);

			// Print or store the result as needed
			System.out.println("Yesterday's date: " + formattedYesterdayDate);

			Thread.sleep(1000);
			AgreementDate.click();
			AgreementDate.sendKeys(formattedYesterdayDate);

			// capture error message and write validation code

			WebElement ErrorValidation_AgreementDate = driver
					.findElement(By.xpath("//small[contains(.,'Previous Date Is Not Allowed')]"));

			String ValidationMsg_AgreementDate = ErrorValidation_AgreementDate.getText();

			Assert.assertTrue(ErrorValidation_AgreementDate.isDisplayed(),
					"Validation message for Agreement Date field is not displayed.");

			System.out.println("for Entering Invalid input validation message for Agreement Date :  "
					+ ValidationMsg_AgreementDate);
		} catch (Exception e) {
			System.err.println("Error in method: Invalid_Input_AgreementDate()");
			e.printStackTrace();
			Assert.fail("Error in method: Invalid_Input_AgreementDate()");
		}
	}

	// Method to scroll page up
	public void pageUp() {
		System.out.println("Executing Method: pageUp()");
		try {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(400);
			System.out.println("Page scrolled up.");

		} catch (Exception e) {
			System.err.println("Error in method: pageUp()");
			e.printStackTrace();
			Assert.fail("Error in method: pageUp()");
		}
	}

	// Method to scroll page down
	public void pageDown() {
		System.out.println("Executing Method: pageDown()");
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
//			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(800);
			System.out.println("Page scrolled down.");

		} catch (Exception e) {
			System.err.println("Error in method: pageDown()");
			e.printStackTrace();
			Assert.fail("Error in method: pageDown()");
		}
	}

	// Method for displaying invalid input validation message - Deal Reference ID
	public void Displayed_invalidinputValidationMessage_DealRefID() {
		System.out.println("Executing Method: Displayed_invalidinputValidationMessage_DealRefID()");
		try {
			Thread.sleep(200);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			WebElement errorValidationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//					"//div[@role=\"alert\" and contains(.,'Deal Reference Id does not allow spaces & special characters')]")));
//
//			String validationMessageText = errorValidationElement.getText();
//
//			Assert.assertTrue(errorValidationElement.isDisplayed(),
//					"Validation message for Deal Reference ID is not displayed.");
//			System.out.println("Invalid input validation message for Deal Reference ID: " + validationMessageText);

			String pageSource = driver.getPageSource();
//			System.out.println(pageSource);
			String expectedToastMessage = "Deal Reference Id does not allow spaces &amp; special characters";

			if (pageSource.contains(expectedToastMessage)) {
				System.out.println("Invalid input validation message for Deal Reference ID: " + expectedToastMessage);
			} else {
				System.err.println("Error in method: Displayed_invalidinputValidationMessage_DealRefID()");
				Assert.fail("Error in method: Displayed_invalidinputValidationMessage_DealRefID()");

			}

		} catch (Exception e) {
			System.err.println("Error in method: Displayed_invalidinputValidationMessage_DealRefID()");
			e.printStackTrace();
			Assert.fail("Error in method: Displayed_invalidinputValidationMessage_DealRefID()");
		}
	}

	public void Clear_DealrefIDField() throws InterruptedException {
		Thread.sleep(3000);
		DealReferenceId.click();

		DealReferenceId.clear();

	}

	public void Clear_LinkDealtoExistingDealReferenceID() throws InterruptedException {
		Thread.sleep(500);
		WebElement Clear_LinkDealtoExistingDealReferenceID = driver
				.findElement(By.xpath("//input[@placeholder=\"Enter Deal Batch Id\"]"));
		Actions action = new Actions(driver);
		Clear_LinkDealtoExistingDealReferenceID.clear();
		action.doubleClick(Clear_LinkDealtoExistingDealReferenceID).build().perform();
		Thread.sleep(200);
		Clear_LinkDealtoExistingDealReferenceID.clear();
		Thread.sleep(200);

	}

	public void Displayed_InvalidinputValidationMsg_LinkDealtoExistingDealReferenceID() throws InterruptedException {
		Thread.sleep(300);
		try {
			WebElement ErrorValidation_LinkDealtoExistingDealReferenceID = driver
					.findElement(By.xpath("//div[text()=' Existing deal reference id is not present ']"));

			String ValidationMsg_LinkDealtoExistingDealReferenceID = ErrorValidation_LinkDealtoExistingDealReferenceID
					.getText();

			Assert.assertTrue(ErrorValidation_LinkDealtoExistingDealReferenceID.isDisplayed(),
					"Validation message for LinkDealtoExistingDealReferenceID field is not displayed.");

			System.out.println(" Entering Invalid input validation message for LinkDealtoExistingDealReferenceID :  "
					+ ValidationMsg_LinkDealtoExistingDealReferenceID);
			System.out.println("sakshi");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(
					"Deal_Without_template_HandlingNegativeScenarios.Displayed_InvalidinputValidationMsg_LinkDealtoExistingDealReferenceID()");
			System.out.println(e);
		}
	}

	public void ClickOnCancelButton() throws InterruptedException {
		CancelButton.click();
		Thread.sleep(300);
	}

	// ****Add Signatories****//

	// field validation for empty fields ( deal creation without template Party
	// Details)

	public void Blank_FieldValidation_FullName() throws InterruptedException {
		try {
			Thread.sleep(200);

			// empty field validation for full name.
			Signatories_FullName.click();

			Actions actions = new Actions(driver);

			// pressing the "Tab" key one times using a loop
			int tabCount = 1;
			for (int i = 0; i < tabCount; i++) {
				actions.sendKeys(Keys.TAB).build().perform();
			}
			WebElement EmptyFieldValidation_FullName = driver
					.findElement(By.xpath("//small[contains(.,'Name is Required')]"));

			String ValidationMsg_FullName = EmptyFieldValidation_FullName.getText();

			Assert.assertTrue(EmptyFieldValidation_FullName.isDisplayed(),
					"Validation message for Document Type field is not displayed.");

			System.out.println("blank field validation message for Document Type :  " + ValidationMsg_FullName);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Blank_FieldValidation_EmailAddress() {
		try {
			// empty field validation for Email address

			Signatories_EmailAddress.click();

			// pressing the "Tab" key one times
			Actions actions = new Actions(driver);

			actions.sendKeys(Keys.TAB).build().perform();

			WebElement EmptyFieldValidation_EmailAddress = driver
					.findElement(By.xpath("//small[contains(.,'At least one field is required Email or mobile')]"));

			String ValidationMsg_EmailAddress = EmptyFieldValidation_EmailAddress.getText();

			Assert.assertTrue(EmptyFieldValidation_EmailAddress.isDisplayed(),
					"Validation message for Email Address field is not displayed.");

			System.out.println("blank field validation message for Email Address :  " + ValidationMsg_EmailAddress);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Blank_FieldValidation_MobileNumber() {

		try {
			// empty field validation for Mobile number

			Signatories_MobileNumber.click();

			// pressing the "Tab" key one times
			Actions actions = new Actions(driver);

			actions.sendKeys(Keys.TAB).build().perform();

			WebElement EmptyFieldValidation_MobileNumber = driver
					.findElement(By.xpath("//small[contains(.,'Mobile Number is Required')]"));

			String ValidationMsg_MobileNumber = EmptyFieldValidation_MobileNumber.getText();

			Assert.assertTrue(EmptyFieldValidation_MobileNumber.isDisplayed(),
					"Validation message for Mobile Number field is not displayed.");

			System.out.println("blank field validation message for Mobile Number :  " + ValidationMsg_MobileNumber);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// invalid input in fields (deal creation without template)

	public void Invalid_Input_FullName() {

	}

	public void Invalid_Input_DateofBirth() {

		try {
			// empty field validation for Date of birth

			// pressing the "Tab" key one times
			Actions actions = new Actions(driver);

			actions.sendKeys(Keys.TAB).build().perform();

			WebElement Invalid_Input_DateOfBirth = driver
					.findElement(By.xpath("//small[contains(.,'age should be more than 18 year')]"));

			String ValidationMsg_DateOfBirth = Invalid_Input_DateOfBirth.getText();

			Assert.assertTrue(Invalid_Input_DateOfBirth.isDisplayed(),
					"Validation message for date of birth field is not displayed.");

			System.out.println("entering wrong input in date of birth field :  " + ValidationMsg_DateOfBirth);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void Invalid_Input_AadhaarNumber() throws Exception {
		try {
			Signatories_AdharNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Invalid_input_Signatories_AdhaarNumber"));
			// pressing the "Tab" key one times
			Actions actions = new Actions(driver);

			actions.sendKeys(Keys.TAB).build().perform();

			WebElement Invalid_Input_AadharNumber = driver
					.findElement(By.xpath("//small[contains(.,'Only Number is Allowed')]"));

			String ValidationMsg_AadharNumber = Invalid_Input_AadharNumber.getText();

			Assert.assertTrue(Invalid_Input_AadharNumber.isDisplayed(),
					"Validation message for Aadhar number field is not displayed.");

			System.out.println("entering wrong input in Aadhar number field :  " + ValidationMsg_AadharNumber);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Invalid_Input_EmailAddress() {
		try {
			Signatories_EmailAddress
					.sendKeys(UtilityClass.getDatafromPropertyFile("Invalid_Input_Signatories_EmailAddress"));
			// pressing the "Tab" key one times
			Actions actions = new Actions(driver);

			actions.sendKeys(Keys.TAB).build().perform();

			WebElement Invalid_Input_EmailAddress = driver
					.findElement(By.xpath("//small[contains(.,'Valid Email is Required')]"));

			String ValidationMsg_AadharNumber = Invalid_Input_EmailAddress.getText();

			Assert.assertTrue(Invalid_Input_EmailAddress.isDisplayed(),
					"Validation message for Email address field is not displayed.");

			System.out.println("entering wrong input in Email address field :  " + ValidationMsg_AadharNumber);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ClickOnCancelButton_AddSignatories() throws InterruptedException {

		Thread.sleep(1000);
		// click on cancel button
		CancelButton_AddSignatories.click();
	}

}
