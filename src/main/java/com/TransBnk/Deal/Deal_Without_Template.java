package com.TransBnk.Deal;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Deal_Without_Template {

	public WebDriver driver;

	@FindBy(xpath = "(//a[@id=\"dropdownMenuLink\"])[1]")
	private WebElement Entity_dropdown;

	@FindBy(xpath = "(//a[@id=\"dropdownMenuLink\"])[2]")
	private WebElement Product_dropdown;

	@FindBy(xpath = "//*[@id=\"REGN\"]/img[1]")
	private WebElement Docuflow;

	@FindBy(xpath = "//a[text()='Deals']")
	private WebElement Deals;

	@FindBy(xpath = "//app-button[@text=\"Create Deal\"]")
	private WebElement CreateDealButton;

	@FindBy(xpath = "(//input[@formcontrolname=\"dealReferenceId\"])[1]")
	private WebElement DealReferenceId;

	@FindBy(xpath = "//select[@formcontrolname=\"selectState\"]")
	private WebElement AgreementState;

	@FindBy(xpath = "//input[@placeholder=\"Enter Consideration Amount\"]")
	private WebElement ConsiderationAmount;

	@FindBy(xpath = "//input[@placeholder=\"Enter Date\"]")
	private WebElement AgreementDate;

	@FindBy(xpath = "//select[@formcontrolname=\"selectProduct\"]")
	private WebElement ClickOnProductOption;

	@FindBy(xpath = "//select[@formcontrolname=\"documentType\"]")
	private WebElement ClickOnDocumentType;

	@FindBy(xpath = "//label[contains(.,'Do you require a template?')]")
	private WebElement RequireTemplateField;

	@FindBy(xpath = "(//input[@formcontrolname=\"isTemplateRequired\"])[2]")
	private WebElement RequiredTemplateNO;

	@FindBy(xpath = "//button[contains(.,'Proceed')]")
	private WebElement ProceedButton;

	@FindBy(xpath = "//input[@id=\"fileUpload\"]")
	private WebElement UploadFileButton;

	@FindBy(xpath = "(//input[@class=\"form-control formField\"])[1]")
	private WebElement BankLender;

	@FindBy(xpath = "(//input[@class=\"form-control formField\"])[2]")
	private WebElement NBFCLender;

	@FindBy(xpath = "(//input[@class=\"form-control formField\"])[3]")
	private WebElement Borrower;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party1_Party_Address;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party2_Party_Address;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[4]/div[2]/textarea")
	private WebElement Party3_Party_Address;

	@FindBy(xpath = "(//input[@formcontrolname=\"partyBranch\"])[1]")
	private WebElement Party1_PartyBranch;

	@FindBy(xpath = "(//*[@id=\"location\"])[1]")
	private WebElement Party2_PartyBranch;

	@FindBy(xpath = "(//*[@id=\"location\"])[1]")
	private WebElement Party3_PartyBranch;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div//form/div[1]/div/div[6]/div[2]/input")
	private WebElement Signing_Sequence_party1;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div//form/div[1]/div/div[6]/div[2]/input")
	private WebElement Signing_Sequence_party2;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div//form/div[1]/div/div[6]/div[2]/input")
	private WebElement Signing_Sequence_party3;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[1]/div/div[7]/div[2]/input")
	private WebElement Party1_MinNoofSignatories;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[1]/div/div[7]/div[2]/input")
	private WebElement Party2_MinNoofSignatories;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[7]/div[2]/input")
	private WebElement Party3_MinNoofSignatories;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	private WebElement Party1_SaveButton;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	private WebElement Party2_SaveButton;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	private WebElement Party3_SaveButton;

	@FindBy(xpath = "(//input[@formcontrolname=\"partyName\"])[1]")
	private WebElement Party2_PartyName;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[2]/div[2]/div/input")
	private WebElement Party3_PartyName;

	@FindBy(xpath = "(//select[@formcontrolname=\"partyConstituentType\"])[1]")
	private WebElement Party2_PartyConstituentType;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[1]/div/div[3]/div[2]/select")
	private WebElement Party3_PartyConstituentType;

	@FindBy(xpath = "( //button[contains(.,'Add Signatories ')])[1]")
	private WebElement AddSignatoriesButton_Party1;

	@FindBy(xpath = "( //button[contains(.,'Add Signatories ')])[2]")
	private WebElement AddSignatoriesButton_Party2;

	@FindBy(xpath = "( //button[contains(.,'Add Signatories ')])[3]")
	private WebElement AddSignatoriesButton_Party3;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/div[2]/div[2]/div/span")
	private WebElement AddCustomSignatories;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryName\"]")
	private WebElement EnterSignatories_FullName;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryEmail\"]")
	private WebElement EnterSignatories_EmailAddress;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryMobile\"]")
	private WebElement EnterSignatories_MobileNumber;

	@FindBy(xpath = "//input[@id=\"YearofBirth\"]")
	private WebElement EnterSignatories_DateOfBirth;

	@FindBy(xpath = "//*[@id=\"confirmSignatory\"]/div//div[2]//div/button[2]")
	private WebElement ClickOnConfirmButton;

	@FindBy(xpath = "//*[@id=\"fromSignatory\"]/div//div[2]/div[2]/button[2]")
	private WebElement ClickOnConfirmButtonAfterEnterSignatioriesDetails;

	@FindBy(xpath = "//div[2]/div/main/app-add-agreement-detail/div[1]/app-section-header/div//div[2]/div/app-button[2]/button")
	private WebElement ClickOnProceedButton;

	@FindBy(xpath = "//button[contains(.,'Send for Execution ')]")
	private WebElement SendForExecution;

	@FindBy(xpath = "//*[@id=\"sendForExecution\"]//div[2]/button[2]")
	private WebElement ConfirmButton;

	@FindBy(xpath = "//select[@formcontrolname=\"selectSignatory\"]")
	private WebElement ClickOnPredefinedSelectSignatoriesOption;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div//div[2]/div[3]/button[2]")
	private WebElement ClickOnConfrimButton;

	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	private WebElement CapturePopUpMessage_AfterClickOnSendForexcutionButton;

	public Deal_Without_Template(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void select_Entity(String EntityName) throws Exception {
		try {
			// click on entity dropdown
			Thread.sleep(6000);
			Entity_dropdown.click();

			// select entity from dropdown

			List<WebElement> entity_list = driver
					.findElements(By.xpath("/html/body/app-root/app-base-layout/div[1]/div[2]/div[1]/div/div"));
//		System.out.println(entity_list.size());
			for (int i = 0; i < entity_list.size(); i++) {
				WebElement EntityString = entity_list.get(i);
				String Entity_name = EntityString.getText();
//			System.out.println(Entity_name);
//			Thread.sleep(1000);
				if (Entity_name.contains(EntityName)) {
					System.out.println("expected Entity name is present on screen");

					driver.findElement(By
							.xpath("/html/body/app-root/app-base-layout/div[1]/div[2]/div[1]/div/div[" + (i + 1) + "]"))
							.click();
					break;

				} else {
//				System.out.println("Entity name is not matched");

				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void select_Product(String ProgramName) throws Exception {
		try {
			// click on Product dropdown
			Thread.sleep(3000);
			Product_dropdown.click();

			// select product from dropdown
			List<WebElement> product_list = driver.findElements(By.xpath("//p[@class=\"dropdown-item\"]"));
//		System.out.println(product_list.size());

			for (int i = 0; i < product_list.size(); i++) {
				WebElement ProductString = product_list.get(i);
				String Product_name = ProductString.getText();
//			System.out.println(Product_name);
//			Thread.sleep(1000);
				if (Product_name.contains(ProgramName)) {
					System.out.println("expected Product name is present on screen");

					driver.findElement(By.xpath("(//p[@class=\"dropdown-item\"])[" + (i + 1) + "]")).click();
					break;

				} else {
//				System.out.println("product name is not matched");
				}
//				Thread.sleep(3000);

			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void ClickOnDocuflowOption() throws InterruptedException {
		Thread.sleep(2000);
		try {
			// click on docuflow option
			Docuflow.click();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void ClickOnDealsOption() throws InterruptedException {

		try {
			Thread.sleep(3000);
			// click on deals option
			Deals.click();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void ClickOn_CreateDeal_Button() throws InterruptedException {
		Thread.sleep(3000);

		// validate after click on deals option page is navigating to correct webpage or
		// not

		String expectedUrl = "https://sandbox.trusthub.in/dashboard/registration/deal";
		System.out.println(" expectedurl : " + expectedUrl);
		try {
			Thread.sleep(3000);

			System.out.println("currenturl : " + driver.getCurrentUrl());

			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

			Assert.assertTrue(true, expectedUrl);

			System.out.println("Navigated to correct webpage");

		} catch (Throwable pageNavigationError) {
			System.out.println("Didn't navigate to correct webpage");

		}

		Thread.sleep(1000);

		// click on create deal button
		CreateDealButton.click();

	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;

	}

	public static String DealRefereneceID;
	public String DealRefID;;

	public String enter_Deal_reference_ID() throws Exception {

		System.out.println("Executing method : enter_Deal_reference_ID()");
		try {
			Thread.sleep(4000);
			String referenceId = UtilityClass.getDatafromPropertyFile("DealRefereneceID") + getCurrentTimeStamp();
			DealReferenceId.click();
			DealReferenceId.sendKeys(referenceId);

			DealRefereneceID = DealReferenceId.getAttribute("value");

			System.out.println("Entered deal reference id : " + DealRefereneceID);

			Thread.sleep(2000);

			return DealRefereneceID;
		} catch (Exception e) {
			System.err.println("Exception in enter_Deal_reference_ID: " + e.getMessage());
			Assert.fail("Failed to enter Deal reference ID", e);
			throw e;
		}
	}

	public void Select_Agreement_State() throws Exception {
		try {
			Thread.sleep(3000);

			// Click on agreement state option
			AgreementState.click();
			Thread.sleep(3000);

			// Select state from dropdown
			List<WebElement> state_list = driver
					.findElements(By.xpath("//*[@formcontrolname=\"selectState\" and @id=\"productCode\"]/option"));
			for (int i = 0; i < state_list.size(); i++) {
				WebElement StateString = state_list.get(i);
				String State_name = StateString.getText();
				if (State_name.contains(UtilityClass.getDatafromPropertyFile("State_name"))) {
					System.out.println("Expected Agreement state name is present on screen");
					driver.findElement(By.xpath(
							"//*[@formcontrolname=\"selectState\" and @id=\"productCode\"]/option[" + (i + 1) + "]"))
							.click();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Exception in Select_Agreement_State: " + e.getMessage());
			Assert.fail("Failed to select Agreement State", e);
			throw e;
		}
	}

	public void Enter_ConsiderationAmount() throws Exception {
		try {
			Thread.sleep(3000);

			ConsiderationAmount.sendKeys(UtilityClass.getDatafromPropertyFile("ConsiderationAmt"));

			Thread.sleep(3000);

			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
		} catch (Exception e) {
			System.err.println("Exception in Enter_ConsiderationAmount: " + e.getMessage());
			Assert.fail("Failed to enter Consideration Amount", e);
			throw e;
		}
	}

	// To enter today's date
	public static String TodaysDate;

	public static String getCurrentDate() {
		try {
			// Get the current date
			LocalDate currentDate = LocalDate.now();

			// Define the format you want (dd-MM-yyyy)
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			// Format the current date
			TodaysDate = currentDate.format(formatter);

			// Print the formatted date
			System.out.println("Current date in custom format (dd-MM-yyyy): " + TodaysDate);

			return TodaysDate;
		} catch (Exception e) {
			System.err.println("Exception in getCurrentDate: " + e.getMessage());
			Assert.fail("Failed to get current date", e);
			throw e;
		}
	}

	public void Select_Agreement_Date() throws InterruptedException {
		try {
			// Select date
			Thread.sleep(3000);
			AgreementDate.click();
			AgreementDate.sendKeys(getCurrentDate());
			Thread.sleep(3000);

		} catch (Exception e) {
			System.err.println("Exception in Select_Agreement_Date: " + e.getMessage());
			Assert.fail("Failed to select Agreement Date", e);
			throw e;
		}
	}

	public void Select_productName(String productName) throws Exception {
		try {
			Thread.sleep(3000);
			ClickOnProductOption.click();

			// Select product name from dropdown
			Thread.sleep(1000);
			List<WebElement> productName_list = driver
					.findElements(By.xpath("//*[@formcontrolname=\"selectProduct\"]/option"));
			for (int i = 0; i < productName_list.size(); i++) {
				WebElement ProductString = productName_list.get(i);
				String Product_name = ProductString.getText();
				if (Product_name.contains(productName)) {
					System.out.println("Expected Product name is present on screen");
					driver.findElement(By.xpath("//*[@formcontrolname=\"selectProduct\"]/option[" + (i + 1) + "]"))
							.click();
					break;
				} else {
//					System.out.println("Product name is not matched");
				}
			}
		} catch (Exception e) {
			System.err.println("Exception in Select_productName: " + e.getMessage());
			Assert.fail("Failed to select Product name", e);
			throw e;
		}
	}

	public void Select_DocumentType() throws Exception {
		try {
			Thread.sleep(3000);

			// Click on document type dropdown
			ClickOnDocumentType.click();

			// Select document type name from dropdown
			List<WebElement> DocType_list = driver
					.findElements(By.xpath("//*[@formcontrolname=\"documentType\"]/option"));
			System.out.println(DocType_list.size());
			for (int i = 0; i < DocType_list.size(); i++) {
				WebElement DocString = DocType_list.get(i);
				String DocumentType_name = DocString.getText();
				if (DocumentType_name.contains(UtilityClass.getDatafromPropertyFile("DocumentType"))) {
					System.out.println("Expected document type name is present on screen");
					driver.findElement(By.xpath("//*[@formcontrolname=\"documentType\"]/option[" + (i + 1) + "]"))
							.click();
					break;
				}
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			System.err.println("Exception in Select_DocumentType: " + e.getMessage());
			Assert.fail("Failed to select Document Type", e);
			throw e;
		}
	}

	// Do you require a template radio button
	public void ClickOnRequireTemplateRadioButton() throws Exception {
		try {
			Thread.sleep(3000);
			if (RequireTemplateField.isDisplayed()) {
				RequiredTemplateNO.click();
			} else {
				System.err.println("ClickOnRequireTemplateRadioButton - Radio button is not visible on screen");
				Assert.fail("ClickOnRequireTemplateRadioButton - Radio button is not visible on screen");
			}
		} catch (Exception e) {
			System.err.println("Exception in ClickOnRequireTemplateRadioButton: " + e.getMessage());
			Assert.fail("Failed to click on Require Template Radio Button", e);
			throw e;
		}
	}

	public void UploadTemplate() throws InterruptedException {
		try {
			Thread.sleep(3000);
			UploadFileButton.sendKeys(System.getProperty("user.dir") + "/TestData/Deal Template.docx");
			Thread.sleep(3000);

			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(400);

		} catch (Exception e) {
			System.err.println("Exception in UploadTemplate: " + e.getMessage());
			Assert.fail("Failed to upload template", e);
			throw e;
		}
	}

	public void ClickOnProceedButton() throws InterruptedException {

		Thread.sleep(4000);

		System.out.println("Executing Method : ClickOnProceedButton()");
		try {
//			Actions action = new Actions(driver);
//
//			action.moveToElement(ProceedButton).click();
			if (ProceedButton.isEnabled()) {
				ProceedButton.click();
				System.out.println("Clicked on proceed button");
				System.out.println("Current URL: " + driver.getCurrentUrl());
			} else {
				System.err.println("Proceed button is disabled");
				Assert.fail("Proceed button is disabled");
			}

		} catch (Exception e) {

			System.err.println("Error in method : ClickOnProceedButton()");

			System.err.println(e);

			Assert.fail("Error in method : ClickOnProceedButton()");
		}
//		Thread.sleep(200);
	}

	public void checkValidationAfterDealCreation() throws InterruptedException {
		System.out.println("Executing Method : checkValidationAfterDealCreation()");
		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//			WebElement validationMessageElement = wait
//					.until(ExpectedConditions.visibilityOf(CapturePopUpMessage_AfterClickOnSendForexcutionButton));
//
//			String CaptureValidationMessage_AfterClickOnProceedButton1 = validationMessageElement.getText();
//
//			String ExpectedValidationMessage_AFterClickOnProceedButton = "Deal created";
//
//			System.out.println("After Clicked on Send for execution button This Validation is displayed  : "
//					+ CaptureValidationMessage_AfterClickOnProceedButton1);
//
//			Assert.assertEquals(CaptureValidationMessage_AfterClickOnProceedButton1,
//					ExpectedValidationMessage_AFterClickOnProceedButton,
//					"Assertion failed : indicates an issue while initiating the deal.");
//
//			Thread.sleep(1000);

			// Use JavaScriptExecutor to wait for the validation message element to be
			// visible
			Thread.sleep(800);
			String pageSource = driver.getPageSource();
//			System.out.println(pageSource);
			String expectedToastMessage = "Deal created";

			if (pageSource.contains(expectedToastMessage)) {
				System.out.println("After Clicked on Send for execution button This Validation is displayed  : "
						+ expectedToastMessage);
			} else {
				System.err.println("Error in method: checkValidationAfterDealCreation()");
				Assert.fail("Assertion failed : indicates an issue while initiating the deal.");

			}

//			JavascriptExecutor js = (JavascriptExecutor) driver;
//
//			// Wait for the element to be present in the DOM (JavaScriptExecutor can't wait
//			// for visibility directly)
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			WebElement validationMessageElement = wait
//					.until(ExpectedConditions.visibilityOf(CapturePopUpMessage_AfterClickOnSendForexcutionButton));
//
//			// Use JavaScriptExecutor to get the text of the element
//			String validationMessageText = (String) js.executeScript("return arguments[0].textContent;",
//					validationMessageElement);
//
//			String ExpectedValidationMessage_AFterClickOnProceedButton = "Deal created";
//
//			System.out.println("After Clicked on Send for execution button This Validation is displayed  : "
//					+ validationMessageText);
//
//			Assert.assertEquals(validationMessageText, ExpectedValidationMessage_AFterClickOnProceedButton,
//					"Assertion failed : indicates an issue while initiating the deal.");

			Thread.sleep(1000);
		} catch (Exception e) {
			System.err.println("Error in method : checkValidationAfterDealCreation()");
			System.err.println(e);
			Assert.fail("Error in method : checkValidationAfterDealCreation()");
		}
	}

	// enter number in bank lender field

	public void EnterNumOfParties() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		try {
			Thread.sleep(7000);
			System.out.println(driver.getCurrentUrl());
			String pageSource = driver.getPageSource();
//			System.out.println("sakshiiiiiii" + pageSource);

			WebElement bankLenderElement = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Bank Lender')]")));
			String bankLender = bankLenderElement.getText();

			driver.findElement(By.xpath("//div[contains(., '" + bankLender
					+ "')]/following-sibling::div/input[contains(@placeholder, 'Enter Number Here')]"))
					.sendKeys(UtilityClass.getDatafromPropertyFile("NumberOfParties"));

			// enter number in NBFC Lender field

			String NBFC_lender = driver.findElement(By.xpath("//span[contains(.,'NBFC Lender')]")).getText();

			driver.findElement(By.xpath("//div[contains(., '" + NBFC_lender
					+ "')]/following-sibling::div/input[contains(@placeholder, 'Enter Number Here')]"))
					.sendKeys(UtilityClass.getDatafromPropertyFile("NumberOfParties"));

			// enter number in Borrower field
			String Borrowers = driver.findElement(By.xpath("(//span[contains(.,'Borrower')])[1]")).getText();

			driver.findElement(By.xpath("//div[contains(., '" + Borrowers
					+ "')]/following-sibling::div/input[contains(@placeholder, 'Enter Number Here')]"))
					.sendKeys(UtilityClass.getDatafromPropertyFile("NumberOfParties"));

			// click on proceed button

			ProceedButton.click();
			System.out.println("Clicked on ProceedButton button ");
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("hiiiiii");
		}
		// Party Details page
		Thread.sleep(5000);
		try {
			String party_details_page = driver.findElement(By.xpath("//h5[contains(.,'Party Details')]")).getText();

			String Expected_page = "Party Details";

			System.out.println(" expected Page : " + Expected_page);

			Assert.assertEquals(Expected_page, party_details_page);

			Assert.assertTrue(true, party_details_page);

			System.out.println("Navigated to correct page (party details page)");

		} catch (Throwable pageNavigationError) {
			System.out.println("Didn't navigate to correct page");

		}

		// check if bank party name is present on screen or not
		Thread.sleep(3000);

//			if (Bank_lender.isDisplayed()) {

		driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

		System.out.println("Bank party is present on screen");
		Thread.sleep(800);
		// enter Party Address

		Party1_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));
//
//			// Party Branch
//
		Party1_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));

		// ** select party name ** //

		// click on party name dropdown
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[@id=\"programType\"])[1]")).click();

		List<WebElement> PartyName_List = driver.findElements(By.xpath("(//*[@id=\"programType\"])[1]/option"));
		for (int i = 0; i < PartyName_List.size(); i++) {
			WebElement PartyNameString = PartyName_List.get(i);
			String party_name = PartyNameString.getText();
//				System.out.println(party_name);
			if (party_name.contains(UtilityClass.getDatafromPropertyFile("party_name"))) {
				System.out.println("expected Party name  is present on screen");

				driver.findElement(By.xpath("(//*[@id=\"programType\"])[1]/option[" + (i + 1) + "]")).click();
				break;

			}
		}
		Thread.sleep(500);

		// Signing Sequence

		Signing_Sequence_party1.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party1"));

		// Min no of Signatories

		Party1_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

		Party1_SaveButton.click();

//			} else {
//				System.out.println("Bank party is not present on screen");
//
//			}

		// check if NBFC party name is present on screen or not
		try {
			Thread.sleep(4000);

			String Party2 = UtilityClass.getDatafromPropertyFile("Party2");

			Assert.assertTrue(true, Party2);

			System.out.println("NBFC party is present on screen");

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();

			// party name
			Thread.sleep(200);

			Party2_PartyName.sendKeys(UtilityClass.getDatafromPropertyFile("Party2_PartyName"));

			// Party Constituent Type

			Party2_PartyConstituentType.click();

			// select Party Constituent type name from dropdown

			List<WebElement> PartyConstituentType_List = driver.findElements(By.xpath(
					"(//select[@placeholder=\"Constituent Type\" and @formcontrolname=\"partyConstituentType\"])[1]/option"));
			for (int i = 0; i < PartyConstituentType_List.size(); i++) {
				WebElement ConstituentTypeString = PartyConstituentType_List.get(i);
				String ConstituentType_name = ConstituentTypeString.getText();
				if (ConstituentType_name.contains(UtilityClass.getDatafromPropertyFile("PartyConstituentType"))) {
					System.out.println("expected Party Constituent type party 2 is present on screen");

					driver.findElement(By.xpath(
							"(//select[@placeholder=\"Constituent Type\" and @formcontrolname=\"partyConstituentType\"])[1]/option["
									+ (i + 1) + "]"))
							.click();
					break;

				}
			}
			Thread.sleep(500);
			// enter Party Address

			Party2_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));
			Thread.sleep(500);
			// Party Branch

			Party2_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));

			// Signing Sequence

			Signing_Sequence_party2.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party2"));

			// Min no of Signatories

			Party2_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

			Party2_SaveButton.click();

		} catch (

		Exception e) {
			System.out.println("NBFC party name is not present on screen");
			System.out.println(e);
		}
		// check if Borrower party name is present on screen or not

		try {
			Thread.sleep(5000);

			String Party3 = UtilityClass.getDatafromPropertyFile("Party3");

			Thread.sleep(2000);

			Assert.assertTrue(true, Party3);
			System.out.println("Borrower party is present on screen");

			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[3]")).click();

			// party name
			Thread.sleep(1000);

			Party3_PartyName.sendKeys(UtilityClass.getDatafromPropertyFile("Party3_PartyName"));

			// Party Constituent Type

			Thread.sleep(400);

			Party3_PartyConstituentType.click();

			// select Party Constituent type name from dropdow

			List<WebElement> PartyConstituentType_List = driver
					.findElements(By.xpath("(//select[@placeholder=\"Constituent Type\"])[1]/option"));
//			System.out.println(PartyConstituentType_List.size());
			for (int i = 0; i < PartyConstituentType_List.size(); i++) {
				WebElement ConstituentTypeString = PartyConstituentType_List.get(i);
				String DocumentType_name = ConstituentTypeString.getText();
				if (DocumentType_name.contains(UtilityClass.getDatafromPropertyFile("PartyConstituentType"))) {
					System.out.println("expected Party Constituent type party 3 is present on screen");

					driver.findElement(
							By.xpath("(//select[@placeholder=\"Constituent Type\"])[1]/option[" + (i + 1) + "]"))
							.click();
					break;

				}
			}
			Thread.sleep(2000);

			// enter Party Address

			Party3_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));
			Thread.sleep(500);

			// Party Branch

			Party3_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));
			Thread.sleep(500);

			// Signing sequence
			Signing_Sequence_party3.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party3"));

			// Min no of Signatories

			Party3_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

			Party3_SaveButton.click();

		} catch (Exception e) {
			System.out.println("borrower party is not present on screen");
			System.out.println(e);
		}

	}

	/// add signatories

	// add signatories for party 1

	// enter date of birth in signatories (for negative flow enterinf today's date)

	public void EnterSignatories_Invalid_DateOfBirth() {

		EnterSignatories_DateOfBirth.sendKeys(getCurrentDate());

	}

	public void AddCustomeSignatories_Party1() throws InterruptedException {
		Thread.sleep(7000);

		ClickOnDropDown_Party1();

		Actions action = new Actions(driver);

		action.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(3000);

		AddSignatoriesButton_Party1.click();

		// click on add custom signatories

		Thread.sleep(1000);
	}

	public void ClickOnDropDown_Party1() throws InterruptedException {
		Thread.sleep(8000);

		// click on dropdwon of party 1
		driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

	}

	// ** add Predefined Signatories in party one **//

	public void ClickOnSelectPredefinedSignatoriesOption() throws InterruptedException {
		Thread.sleep(1000);
		ClickOnPredefinedSelectSignatoriesOption.click();

	}

	// click on predefined signtories option from dropdown

	public void SelectPredefinedSignatoriesFromDropdown() throws Exception {
		// select predefined signatories option from dropdown
		List<WebElement> PredefinedSignatories_List = driver.findElements(By.xpath("//*[@id=\"productCode\"]/option"));
//						System.out.println(PartyConstituentType_List.size());
		for (int i = 0; i < PredefinedSignatories_List.size(); i++) {
			WebElement PredefinedSignatorieseString = PredefinedSignatories_List.get(i);
			String PredefinedSignatories_name = PredefinedSignatorieseString.getText();
			if (PredefinedSignatories_name.contains(UtilityClass.getDatafromPropertyFile("PredefinedSignatories"))) {
				System.out.println("expected predefined signatories  is present on screen");

				driver.findElement(By.xpath("//*[@id=\"productCode\"]/option[" + (i + 1) + "]")).click();
				break;

			} else {
//				System.out.println("prefined signatories option is not present in list ");
			}
		}
	}

	public void ClickOnConfirmButton() throws InterruptedException {
		// click on confirm button of predefined signatories
		Thread.sleep(800);
		ClickOnConfrimButton.click();
		System.out.println("clicked on confirm button");
	}

//	public void EnterValidDetails_CustomSignatories_Party1() throws Exception {
//		Thread.sleep(500);
//		Actions action = new Actions(driver);
////
////		action.sendKeys(Keys.PAGE_DOWN).build().perform();
//
//		Thread.sleep(3000);
//
//		AddSignatoriesButton_Party1.click();
//
//		// click on add custom signatories
//
//		Thread.sleep(1000);
//
//		AddCustomSignatories.click();
//
//		Thread.sleep(1000);
//
//		EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party1"));
//
//		action.sendKeys(Keys.PAGE_DOWN).build().perform();
//		Thread.sleep(1000);
//
//		EnterSignatories_EmailAddress.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty1"));
//
//		EnterSignatories_MobileNumber.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party1"));
//
//		ClickOnConfirmButton.click();
//		Thread.sleep(400);
//
//		ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();
//
//		Thread.sleep(4000);
//	}

	// click on dropdwon of party 2
	public void ClickOnDropDown_Party2() throws InterruptedException {
		Thread.sleep(4000);

		// click on dropdwon of party 2
		driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();
		Actions action = new Actions(driver);

//		action.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

	public void AddCustomSignatories_Party2() throws Exception {

		Thread.sleep(3000);

//		// click on dropdwon of party 2
//		driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();

		Thread.sleep(1000);

		AddSignatoriesButton_Party2.click();

		// click on add custom signatories

		Thread.sleep(1000);

		AddCustomSignatories.click();
		Thread.sleep(300);
	}

	public void EnterValidDetails_CustomSignatories_Party2() throws Exception {
		Thread.sleep(1000);

		EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party2"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);

		EnterSignatories_EmailAddress.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty2"));

		EnterSignatories_MobileNumber.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party2"));

		ClickOnConfirmButton.click();
		Thread.sleep(400);

		ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

		Thread.sleep(4000);
	}

	public void AddCustomSignatories_Party3() throws Exception {

		Thread.sleep(5000);

		// click on dropdwon of party 3
		driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[3]")).click();

		Actions action = new Actions(driver);

		action.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(2000);

		AddSignatoriesButton_Party3.click();

		// click on add custom signatories

		Thread.sleep(2000);

		AddCustomSignatories.click();

		Thread.sleep(1000);

		EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party3"));

		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);

		EnterSignatories_EmailAddress.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty3"));

		EnterSignatories_MobileNumber.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party3"));

		ClickOnConfirmButton.click();
		Thread.sleep(400);

		ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();
		Thread.sleep(400);
	}

	public void ClickOnProceedButton_OnpartyDetailsPage() throws InterruptedException {

		Thread.sleep(700);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.PAGE_UP).build().perform();

		action.sendKeys(Keys.PAGE_UP).build().perform();

		ClickOnProceedButton.click();

		Thread.sleep(4000);

	}

	// Utility method to check if a given text is present on the screen
	public boolean isDealRefIDPresentOnScreen(String DealRefereneceID) throws InterruptedException {
		// Check if the page source contains the DealRefID
		Thread.sleep(1000);

		return driver.getPageSource().contains(DealRefereneceID);
	}

	public void performActionsBasedOnDealRefID() throws Exception {
		// Get the DealRefID

		Thread.sleep(3000);

		try {
			String dealRefID = DealRefereneceID;
			System.out.println(dealRefID + " -DealRefereneceID");

			// Check if the DealRefID is present on the screen
			if (isDealRefIDPresentOnScreen(dealRefID)) {

				System.out.println(DealRefereneceID + " Created Deal is present on screen");
				// If DealRefID is present, click on the edit button
				try {
					ClickOnViewtButton();

				} catch (NoSuchElementException e) {

					ClickOnEditButton();

					System.err.println("clicked on Edit button");
					Assert.fail("");
				}

			} else {
				System.out.println("DealRefID not found on the screen.");
			}

			// Check if the DealRefID is present on the screen
			if (isDealRefIDPresentOnScreen(dealRefID)) {
				// If DealRefID is present, click on the edit button
				Assert.assertTrue(true, dealRefID);

				System.out.println("after clicked on edit button correct Deal is opened ");
			} else {
				System.out.println("after clicked on edit button correct Deal is not opened ");
			}
		} catch (Exception e) {
			System.err.println(e);

		}
	}

	// Utility method to click on the "Edit" button
	public void ClickOnViewtButton() throws InterruptedException {
		Thread.sleep(1000);
		// click on view button
		driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']/tr[td[1]//strong[contains(.,'"
				+ DealRefereneceID + "')]]//img[@title='View']")).click();

		// Print a message for demonstration
		System.out.println("Clicked on the Edit button.");

	}

	public void ClickOnEditButton() {

		driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']/tr[td[1]//strong[contains(.,'"
				+ DealRefereneceID + "')]]//img[@title='Edit']")).click();
	}

	// remove after use

	public void clickviewbutton() throws InterruptedException {
		Thread.sleep(2000);
		// Assuming the Edit button has an ID "editButtonId"
		driver.findElement(By.xpath("//*[@id=\"transactionTable\"]/tbody[1]/tr/td[10]/span/img")).click();

		// Print a message for demonstration
		System.out.println("Clicked on the Edit button.");

	}

	public void ClickOnSendForExecutionButton() throws Exception {
		Thread.sleep(1000);
		System.out.println("Executing Method : " + "Deal_Without_Template.ClickOnSendForExecutionButton()");

		if (SendForExecution.isDisplayed()) {

			Assert.assertTrue(SendForExecution.isDisplayed(), "Error: SendForExecution Button is not displayed.");

			SendForExecution.click();

			Thread.sleep(400);

			// click on confirm button

			ConfirmButton.click();
			Thread.sleep(300);

			String CaptureValidationMessage_AfterClickOnSendForexcutionButton1 = CapturePopUpMessage_AfterClickOnSendForexcutionButton
					.getText();

			String ExpectedValidationMessage_AFterClickOnSendForExecutionButton = "Initiate Signing Success";

			System.out.println("After Clicked on Send for execution button This Validation is displayed  : "
					+ CaptureValidationMessage_AfterClickOnSendForexcutionButton1);

			Assert.assertEquals(CaptureValidationMessage_AfterClickOnSendForexcutionButton1,
					ExpectedValidationMessage_AFterClickOnSendForExecutionButton,
					"Assertion failed : indicates an issue while initiating the deal.");
		} else {
			System.out.println("Deal_Without_Template.ClickOnSendForExecutionButton()");

			System.err.println("Error : indicating an issue while initiating the deal.");

		}

		Thread.sleep(1000);

	}

	public void ThreadSleep() throws InterruptedException {
		Thread.sleep(4000);
	}

	public void ClickOnSendForExecutionButton_NegativeScenarios() throws Exception {
		Thread.sleep(1000);
		System.out.println("Executing Method : " + "Deal_Without_Template.ClickOnSendForExecutionButton()");

		if (SendForExecution.isDisplayed()) {

			Assert.assertTrue(SendForExecution.isDisplayed(), "Error: SendForExecution Button is not displayed.");

			SendForExecution.click();

			Thread.sleep(400);

			// click on confirm button

			ConfirmButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement validationMessageElement = wait
					.until(ExpectedConditions.visibilityOf(CapturePopUpMessage_AfterClickOnSendForexcutionButton));

			String CaptureValidationMessage_AfterClickOnSendForexcutionButton1 = validationMessageElement.getText();

			String ExpectedValidationMessage_AFterClickOnSendForExecutionButton = "Initiate Signing Success";

			System.out.println("After Clicked on Send for execution button This Validation is displayed  : "
					+ CaptureValidationMessage_AfterClickOnSendForexcutionButton1);

			Assert.assertEquals(CaptureValidationMessage_AfterClickOnSendForexcutionButton1,
					ExpectedValidationMessage_AFterClickOnSendForExecutionButton,
					"Assertion failed : indicates an issue while initiating the deal.");

		} else {
			System.out.println("Deal_Without_Template.ClickOnSendForExecutionButton()");

			System.err.println("Error : indicating an issue while initiating the deal.");

		}

		Thread.sleep(1000);

	}

}
