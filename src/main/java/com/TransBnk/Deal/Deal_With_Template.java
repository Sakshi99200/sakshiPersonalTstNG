package com.TransBnk.Deal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Deal_With_Template {
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

	@FindBy(xpath = "//input[@class=\"inputtypesOfUserForm ng-untouched ng-pristine ng-invalid\"]")
	private WebElement AgreementDate;

	@FindBy(xpath = "//select[@formcontrolname=\"selectProduct\"]")
	private WebElement ClickOnProductOption;

	@FindBy(xpath = "//select[@formcontrolname=\"documentType\"]")
	private WebElement ClickOnDocumentType;
	@FindBy(xpath = "//label[contains(.,'Do you require a template?')]")
	private WebElement RequireTemplateField;

	@FindBy(xpath = "(//input[@formcontrolname=\"isTemplateRequired\"])[1]")
	private WebElement RequiredTemplateYES;
	@FindBy(xpath = "//button[contains(.,'Proceed')]")
	private WebElement ProceedButton;

	@FindBy(xpath = "(//button[contains(.,'Create')])[1]")
	private WebElement CreateButton;

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

	@FindBy(xpath = "//button[contains(.,'details')]")
	private WebElement Agreement_Details;

	@FindBy(xpath = "(//input[@type=\"date\" and @placeholder=\"Enter Value\"] )[1]")
	private WebElement Facilityletterdate;

	@FindBy(xpath = "(//input[@type=\"date\" and @placeholder=\"Enter Value\"] )[2]")
	private WebElement SD_Date;

	@FindBy(xpath = "//button[contains(.,'Next')]")
	private WebElement NextButton;

	@FindBy(xpath = "//button[contains(.,'Additional Details ')]")
	private WebElement AdditionalDetailsButton;

	@FindBy(xpath = "//button[contains(.,' Add Details ')]")
	private WebElement AddDetailsButton;

	@FindBy(xpath = "(//input[@id=\"field\"])")
	private WebElement EnterPartyPartnumber_1;

	@FindBy(xpath = "(//input[@id=\"field\"])[2]")
	private WebElement EnterPartyPartnumber_2;

	@FindBy(xpath = "(//input[@id=\"field\"])[3]")
	private WebElement EnterPartyPartnumber_3;

	@FindBy(xpath = "(//button[text()=\" Save \"])[2]")
	private WebElement ClickOnSaveButton_PartyCount;

	@FindBy(xpath = "//button[contains(.,'parties')]")
	private WebElement clickOnPartiesOption;

	@FindBy(xpath = "(//input[@formcontrolname=\"customFieldParty\"])[1]")
	private WebElement Party_synonym_1;

	@FindBy(xpath = "(//input[@formcontrolname=\"customFieldParty\"])[1]")
	private WebElement Party_synonym_2;

	@FindBy(xpath = "(//input[@formcontrolname=\"customFieldParty\"])[1]")
	private WebElement Party_synonym_3;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[3]/div/div/div/div[2]/div/div[2]/select")
	private WebElement ClickOnPartyNumber_1;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[3]/div/div/div/div[2]/div/div[2]/select")
	private WebElement ClickOnPartyNumber_2;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[3]/div/div/div/div[2]/div/div[2]/select")
	private WebElement ClickOnPartyNumber_3;

	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div/form/div[4]/button")
	private WebElement AddSignatoriesButton_Party1;

	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/form/div[4]/button")
	private WebElement AddSignatoriesButton_Party2;

	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/form/div[4]/button")
	private WebElement AddSignatoriesButton_Party3;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/div[2]/div[2]/div/span")
	private WebElement AddCustomSignatories;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryName\"]")
	private WebElement EnterSignatories_FullName;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryEmail\"]")
	private WebElement EnterSignatories_EmailAddress;

	@FindBy(xpath = "//input[@formcontrolname=\"partySignatoryMobile\"]")
	private WebElement EnterSignatories_MobileNumber;

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

	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	private WebElement CapturePopUpMessage_AfterClickOnSendForexcutionButton;

	public Deal_With_Template(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void select_Entity(String entityName) throws Exception {
		try {
			System.out.println("Executing Method :" + "Deal_With_Template.select_Entity()");

			// click on entity dropdown
			Thread.sleep(4000);
			Entity_dropdown.click();

			// select entity from dropdown

			List<WebElement> entity_list = driver.findElements(By.xpath("//p[@class=\"dropdown-item\"]"));
//		System.out.println(entity_list.size());
			for (int i = 0; i < entity_list.size(); i++) {
				WebElement EntityString = entity_list.get(i);
				String Entity_name = EntityString.getText();
//			System.out.println(Entity_name);
//			Thread.sleep(1000);
				if (Entity_name.contains(entityName)) {
					System.out.println("expected Entity name is present on screen");

					driver.findElement(By.xpath("(//p[@class=\"dropdown-item\"])[" + (i + 1) + "]")).click();
					break;

				} else {
//				System.out.println("Entity name is not matched");

				}
			}
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("Error in Method :" + "Deal_With_Template.select_Entity()");
		}
	}

	public void select_Product(String ProductName) throws Exception {
		try {

			System.out.println("Executing Method : " + "Deal_With_Template.select_Product()");
			// click on Product dropdown
			Thread.sleep(6000);
			Product_dropdown.click();

			// select product from dropdown

			List<WebElement> product_list = driver.findElements(By.xpath("//p[@class=\"dropdown-item\"]"));
//		System.out.println(product_list.size());
			for (int i = 0; i < product_list.size(); i++) {
				WebElement ProductString = product_list.get(i);
				String Product_name = ProductString.getText();
//				System.out.println(Product_name);
//			Thread.sleep(1000);
				if (Product_name.contains(ProductName)) {
					System.out.println("expected Product name is present on screen");

					driver.findElement(By.xpath("(//p[@class=\"dropdown-item\"])[" + (i + 1) + "]")).click();
					break;

				} else {
//					System.out.println("product name is not matched");
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("Error in method :" + "Deal_With_Template.select_Product()");
		}

	}

	public void ClickOnDocuflowOption() throws InterruptedException {
		Thread.sleep(2000);
		try {
			System.out.println("Executing Method :" + "Deal_With_Template.ClickOnDocuflowOption()");
			// click on docuflow option
			Docuflow.click();

		} catch (Exception e) {
			System.err.println(e);
			System.out.println("Error in method :" + "Deal_With_Template.ClickOnDocuflowOption()");
		}
	}

	public void ClickOnDealsOption() throws InterruptedException {
		try {
			System.out.println("Executing Method : " + "Deal_With_Template.ClickOnDealsOption()");
			Thread.sleep(500);
			// click on deals option
			Deals.click();
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("Error in method :" + "Deal_With_Template.ClickOnDealsOption()");
		}
	}

	public void ClickOn_CreateDeal_Button() throws InterruptedException {
		Thread.sleep(2000);

		// validate after click on deals option page is navigating to correct webpage or
		// not

		String expectedUrl = "https://sandbox.trusthub.in/dashboard/registration/deal";
		System.out.println(" expectedurl : " + expectedUrl);
		try {

			System.out.println("currenturl : " + driver.getCurrentUrl());

			Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Error : Didn't navigate to correct webpage");

			System.out.println("Navigated to correct webpage");

		} catch (Throwable pageNavigationError) {
			System.out.println("Error in method : " + "Deal_With_Template.ClickOn_CreateDeal_Button()");
			System.err.println("Didn't navigate to correct webpage");

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

	public static String DealWithtemplate_RefereneceID;
	public String DealWithTemplate_RefID;;

	public String enter_Deal_reference_ID() throws Exception {

		System.out.println("Executing method : " + "Deal_With_Template.enter_Deal_reference_ID()");
		try {

			Thread.sleep(1000);
			String referenceId = UtilityClass.getDatafromPropertyFile("DealRefereneceID") + getCurrentTimeStamp();
			DealReferenceId.sendKeys(referenceId);

			DealWithtemplate_RefereneceID = DealReferenceId.getAttribute("value");

			System.out.println("Entered deal reference id : " + DealWithtemplate_RefereneceID);

			Thread.sleep(2000);
			return DealWithtemplate_RefereneceID;

		} catch (Exception e) {
			System.err.println(e);
			System.out.println("error in method :" + "Deal_With_Template.enter_Deal_reference_ID()");
		}
		return DealWithtemplate_RefereneceID;

	}

	public void Select_Agreement_State() throws Exception {
		System.out.println("Executing method :" + "Deal_With_Template.Select_Agreement_State()");

		try {
			// click on agreement state option
			AgreementState.click();

			// select state from dropdown
			List<WebElement> state_list = driver
					.findElements(By.xpath("//*[@formcontrolname=\"selectState\" and @id=\"productCode\"]/option"));
			// System.out.println(state_list.size());
			for (int i = 0; i < state_list.size(); i++) {
				WebElement StateString = state_list.get(i);
				String State_name = StateString.getText();
				// System.out.println(State_name);
//			Thread.sleep(1000);
				if (State_name.contains(UtilityClass.getDatafromPropertyFile("State_name"))) {
					System.out.println("expected Agreement state name is present on screen");

					driver.findElement(By.xpath(
							"//*[@formcontrolname=\"selectState\" and @id=\"productCode\"]/option[" + (i + 1) + "]"))
							.click();
					break;

				} else {
//				System.out.println(" agreement state name is not matched");
				}
			}
		} catch (Exception e) {
			System.err.println("Error in method :" + "Deal_With_Template.Select_Agreement_State()");

			System.err.println(e);

		}
	}

	public void Enter_ConsiderationAmount() throws Exception {

		System.out.println("Executing method :" + "Deal_With_Template.Enter_ConsiderationAmount()");
		try {

			ConsiderationAmount.sendKeys(UtilityClass.getDatafromPropertyFile("ConsiderationAmt"));

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// to enter todays date
	public static String TodaysDate;

	public static String getCurrentDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyy");
		Date now = new Date();
		TodaysDate = sdfDate.format(now);
		System.out.println("todays date : " + TodaysDate);
		return TodaysDate;

	}

	public void Select_Agreement_Date() throws InterruptedException {
		// Select date
		Thread.sleep(1000);
		AgreementDate.click();

		AgreementDate.sendKeys(getCurrentDate());

	}

	public void Select_productName(String ProductName) throws Exception {
		System.out.println("Executing method : " + "Deal_With_Template.Select_productName()");
		try {
			Thread.sleep(3000);

			ClickOnProductOption.click();

			// select product name from dropdown

			List<WebElement> productName_list = driver
					.findElements(By.xpath("//*[@formcontrolname=\"selectProduct\"]/option"));
//				System.out.println(product_list.size());
			for (int i = 0; i < productName_list.size(); i++) {
				WebElement ProductString = productName_list.get(i);
				String Product_name = ProductString.getText();
//					System.out.println(Product_name);
//			Thread.sleep(1000);
				if (Product_name.contains(ProductName)) {
					System.out.println("expected Product name is present on screen");

					driver.findElement(By.xpath("//*[@formcontrolname=\"selectProduct\"]/option[" + (i + 1) + "]"))
							.click();
					break;

				} else {
//				System.out.println("product name is not matched");
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("Error in Method :" + "Deal_With_Template.Select_productName()");
		}

	}

	public void Select_DocumentType(String DocumentType) throws Exception {

		System.out.println("Executing method : " + "Deal_With_Template.Select_DocumentType()");
		Thread.sleep(2000);

		// click on document type dropdown
		ClickOnDocumentType.click();

		// select document type name from dropdown

		List<WebElement> DocType_list = driver.findElements(By.xpath("//*[@formcontrolname=\"documentType\"]/option"));
		System.out.println(DocType_list.size());
		for (int i = 0; i < DocType_list.size(); i++) {
			WebElement DocString = DocType_list.get(i);
			String DocumentType_name = DocString.getText();
//			System.out.println(DocumentType_name);
//			Thread.sleep(1000);
			if (DocumentType_name.contains(DocumentType)) {
				System.out.println("expected document type name is present on screen");

				driver.findElement(By.xpath("//*[@formcontrolname=\"documentType\"]/option[" + (i + 1) + "]")).click();
				break;

			} else {
//				System.out.println("document type name is not matched");
			}
		}
		Thread.sleep(2000);

	}
	// Do you require a template radio button

	public void ClickOnRequireTemplateRadioButton() {

		if (RequireTemplateField.isDisplayed()) {

			RequiredTemplateYES.click();

		} else {
			System.out.println("radio button is not visible on screen");
		}

	}

	public void ClickOnProceedButton() {

		ProceedButton.click();

	}

	public void searchCreatedTemplate_AndClickOnCreateButton() throws Exception {

		System.out.println("Executing Method :" + "Deal_With_Template.searchCreatedTemplate_AndClickOnCreateButton()");
		Thread.sleep(6000);
		try {
			String TemplateName = UtilityClass.getDatafromPropertyFile("Template_name");
			String Template_Name = TemplateName.trim();

			System.out.println(Template_Name);
			// If template is present, click on the Create button

			driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']/tr[contains(td[2],'" + Template_Name
					+ "')]//button[text()=' Create ']")).click();

			System.out.println("Clicked on Create button successfully.");
			Thread.sleep(3000);

		} catch (Exception e) {
			System.err.println(e);
			System.err.println(
					"Error in method : " + "Deal_With_Template.searchCreatedTemplate_AndClickOnCreateButton()");
		}
	}

	// enter number in bank lender field

	public void EnterNumOfParties_and_details() throws Exception {

		System.out.println("Executing Method :" + "Deal_With_Template.EnterNumOfParties_and_details()");
		try {
			Thread.sleep(3000);

			WebElement Bank_lender = driver.findElement(By.xpath("//span[contains(.,'Bank Lender')]"));

			String Bank_lender1 = driver.findElement(By.xpath("//span[contains(.,'Bank Lender')]")).getText();
			System.out.println(Bank_lender1);

			driver.findElement(By.xpath("//div[contains(., '" + Bank_lender1
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

			Thread.sleep(2000);
			// **Agreement Details **//

			// verify agreement details page
			String Expected_page = "details";
			String Actual_page = Agreement_Details.getText();

			if (Agreement_Details.isDisplayed()) {

				Assert.assertEquals(Expected_page, Actual_page, "Agreement details page is not displayed on screen");

				Agreement_Details.click();

				System.out.println("Showing correct page");

				Thread.sleep(500);

				if (Facilityletterdate.isDisplayed()) {

					Facilityletterdate.sendKeys(getCurrentDate());
					Thread.sleep(400);

				} else {
					System.out.println("facility letter date is not displayed on page");
				}
				if (SD_Date.isDisplayed()) {

					SD_Date.sendKeys(getCurrentDate());
					Thread.sleep(400);

				} else {
					System.out.println("SD date is not displayed on page");
				}

				// click on next button

				NextButton.click();

			} else {
				System.out.println("there is no Agreement page");

			}

			// **Additional Details **//

			Thread.sleep(1000);
			if (AdditionalDetailsButton.isDisplayed()) {

				AdditionalDetailsButton.click();
				Thread.sleep(1000);

				// click on add details button
				if (AddDetailsButton.isDisplayed()) {

					AddDetailsButton.click();

					Thread.sleep(1000);
					// add 1 party count
					EnterPartyPartnumber_1.sendKeys("1");

					ClickOnSaveButton_PartyCount.click();

					Thread.sleep(1000);

					AddDetailsButton.click();
					Thread.sleep(700);
					// add 2 party count
					EnterPartyPartnumber_2.sendKeys("2");

					ClickOnSaveButton_PartyCount.click();

					Thread.sleep(2000);

					AddDetailsButton.click();

					Thread.sleep(700);

					// add 3 party count
					EnterPartyPartnumber_3.sendKeys("3");

					ClickOnSaveButton_PartyCount.click();

				} else {
					System.out.println("add details button is not displayed on page ");
				}

			} else {
				System.out.println("additional details field is not displayed on screen");
			}
			Thread.sleep(4000);

			// ** Parties **//

			if (clickOnPartiesOption.isDisplayed()) {

				System.out.println("clicked on parties option");

				clickOnPartiesOption.click();

				Thread.sleep(900);
				// Party Details page

				String party_details_page = driver.findElement(By.xpath("//h5[contains(.,'Party Details')]")).getText();

				String Expected_pagePartyDetails = "Party Details";

				System.out.println(" expected Page : " + Expected_pagePartyDetails);
				try {

					Assert.assertEquals(Expected_pagePartyDetails, party_details_page,
							"Expected Party details page is not displayed on screen");

					Assert.assertTrue(true, party_details_page);

					System.out.println("Navigated to correct page (party details page)");

				} catch (Throwable pageNavigationError) {
					System.out.println("Didn't navigate to correct page");

				}

				WebElement Bank = driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/span)[1]"));

				// check if bank party name is present on screen or not

				if (Bank.isDisplayed()) {

					driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[1]")).click();

					System.out.println("Bank party is present on screen");

					// enter Party Address

					Party1_Party_Address.sendKeys(UtilityClass.getDatafromPropertyFile("PartyAddress"));

					// Party Branch
					Thread.sleep(300);
					Party1_PartyBranch.sendKeys(UtilityClass.getDatafromPropertyFile("PartyBranch"));

					// Signing Sequence

					Signing_Sequence_party1.sendKeys(UtilityClass.getDatafromPropertyFile("Signing_Sequence_Party1"));

					// Min no of Signatories

					Party1_MinNoofSignatories.sendKeys(UtilityClass.getDatafromPropertyFile("MinNoOfSignatories"));

					// enter Party synonym

					// enter Party synonym

					Party_synonym_1.sendKeys(UtilityClass.getDatafromPropertyFile("Party_Synonym_1"));

					// party number
					Thread.sleep(500);

					// click on party number field

					ClickOnPartyNumber_1.click();

					Thread.sleep(200);
					List<WebElement> PartyNumberList = driver.findElements(
							By.xpath("//*[@id=\"collapse1\"]/div//form/div[3]/div//div[2]/select/option"));
					for (int i = 0; i < PartyNumberList.size(); i++) {
						WebElement ConstituentTypeString = PartyNumberList.get(i);
						String ConstituentType_name = ConstituentTypeString.getText();
						System.out.println(ConstituentType_name);
						if (ConstituentType_name.contains(UtilityClass.getDatafromPropertyFile("PartyNumber_1"))) {
							System.out.println("expected Party number for Party 1 is present on screen");

							driver.findElement(
									By.xpath("//*[@id=\"collapse1\"]/div//form/div[3]/div//div[2]/select/option["
											+ (i + 1) + "]"))
									.click();
							break;

						} else {
//							System.out.println("expected Party number for Party 1 is NOT present on screen");

						}
					}

					Thread.sleep(500);

					Party1_SaveButton.click();

				} else {
					System.out.println("Bank party is not present on screen");

				}

			} else {
				System.out.println("parties option is not displayed on page");
			}
		} catch (Exception e) {
			System.out.println("Error in method " + "Deal_With_Template.EnterNumOfParties_and_details()");
			System.err.println(e);
		}
		// ********* NBFC *************//

		// check if NBFC party name is present on screen or not
		try {
			Thread.sleep(4000);

			String Party2 = UtilityClass.getDatafromPropertyFile("Party2");

			Assert.assertTrue(true, Party2);
			if (Party2 != null && !Party2.isEmpty()) {

				System.out.println("NBFC party is present on screen");

				driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();

				// party name
				Thread.sleep(800);

				Party2_PartyName.sendKeys(UtilityClass.getDatafromPropertyFile("Party2_PartyName"));

				// Party Constituent Type

				Party2_PartyConstituentType.click();
				Thread.sleep(200);

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

				// enter Party synonym

				Party_synonym_2.sendKeys(UtilityClass.getDatafromPropertyFile("Party_Synonym_2"));

				// party number
				Thread.sleep(500);
				ClickOnPartyNumber_2.click();
				Thread.sleep(200);

				List<WebElement> PartyNumberList = driver
						.findElements(By.xpath("//*[@id=\"collapse2\"]/div//form/div[3]/div//div[2]/select/option"));
				for (int i = 0; i < PartyNumberList.size(); i++) {
					WebElement ConstituentTypeString = PartyNumberList.get(i);
					String ConstituentType_name = ConstituentTypeString.getText();
					if (ConstituentType_name.contains(UtilityClass.getDatafromPropertyFile("PartyNumber_2"))) {
						System.out.println("expected Party number for Party 2 is present on screen");

						driver.findElement(By.xpath(
								"//*[@id=\"collapse2\"]/div//form/div[3]/div//div[2]/select/option[" + (i + 1) + "]"))
								.click();
						break;

					} else {
//					System.err.println("expected Party number for Party 2 is NOT present on screen");
					}

					Thread.sleep(800);

					Party2_SaveButton.click();
				}
			} else {
				System.err.println("NBFC party name is not present on screen");

			}
		} catch (Exception e) {
			System.err.println("NBFC party name is not present on screen");
			System.err.println(e);
		}

		// *********** Borrower ***********//

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

			// // select Party Constituent type name from dropdow

			List<WebElement> PartyConstituentType_List = driver
					.findElements(By.xpath("(//select[@placeholder=\"Constituent Type\"])[1]/option"));
//				System.out.println(PartyConstituentType_List.size());
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

			// enter Party synonym

			Party_synonym_3.sendKeys(UtilityClass.getDatafromPropertyFile("Party_Synonym_3"));

			// party number
			Thread.sleep(500);

			ClickOnPartyNumber_3.click();

			Thread.sleep(200);

			List<WebElement> PartyNumberList = driver.findElements(
					By.xpath("//*[@id=\"collapse3\"]/div/div/form/div[3]/div/div/div/div[2]/div/div[2]/select/option"));
			for (int i = 0; i < PartyNumberList.size(); i++) {
				WebElement ConstituentTypeString = PartyNumberList.get(i);
				String ConstituentType_name = ConstituentTypeString.getText();
				if (ConstituentType_name.contains(UtilityClass.getDatafromPropertyFile("PartyNumber_3"))) {
					System.out.println("expected Party number for party 3 is present on screen");

					driver.findElement(By.xpath(
							"//*[@id=\"collapse3\"]/div/div/form/div[3]/div/div/div/div[2]/div/div[2]/select/option["
									+ (i + 1) + "]"))
							.click();
					break;

				} else {
//					System.err.println("expected Party number for party 3 is NOT  present on screen");
				}
			}
			Thread.sleep(800);

			Party3_SaveButton.click();

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(500);

			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("borrower party is not present on screen");
		}
	}

	// add noOFParties when performing negative scenarios

	public void EnterNumOfParties_AfterDeletingThePartyDetails() throws Exception {
		try {
			Thread.sleep(4000);

			WebElement Bank_lender = driver.findElement(By.xpath("//span[contains(.,'Bank Lender')]"));

			String Bank_lender1 = driver.findElement(By.xpath("//span[contains(.,'Bank Lender')]")).getText();
//			System.out.println(Bank_lender1);

			driver.findElement(By.xpath("//div[contains(., '" + Bank_lender1
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

			// click on Parties option
			Thread.sleep(300);
			driver.findElement(By.xpath("//*[@id=\"party\"]")).click();
			System.out.println("Clicked on Parties option");

			// Party Details page
			Thread.sleep(900);
			String party_details_page = driver.findElement(By.xpath("//h5[contains(.,'Party Details')]")).getText();

			String Expected_page = "Party Details";

			System.out.println(" expected Page : " + Expected_page);
			try {

				Assert.assertEquals(Expected_page, party_details_page);

				Assert.assertTrue(true, party_details_page);

				System.out.println("Navigated to correct page (party details page)");

			} catch (Throwable pageNavigationError) {
				System.out.println("Didn't navigate to correct page");

			}

			// check if bank party name is present on screen or not
			Thread.sleep(1000);

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

		} catch (Exception e) {
			System.out.println(e);
			System.err.println();
		}
	}

	// add signatories

	// add signatories for party 1

	public void AddCustomSignatories_Party1() throws Exception {
		System.out.println("Executing Method :" + "Deal_With_Template.AddCustomSignatories_Party1()");
		try {
			Thread.sleep(4000);

			// click on dropdwon of party 1
			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a//div/a/img)[1]")).click();

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(3000);

			AddSignatoriesButton_Party1.click();

			// click on add custom signatories

			Thread.sleep(3000);

			AddCustomSignatories.click();

			Thread.sleep(1000);

			EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party1"));

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);

			EnterSignatories_EmailAddress
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty1"));

			EnterSignatories_MobileNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party1"));

			ClickOnConfirmButton.click();
			Thread.sleep(400);

			ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

			Thread.sleep(4000);

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("there is some error occur while adding custome signatories for party 1");
		}
	}

	public void AddCustomSignatories_Party2() throws Exception {
		System.out.println("Executing Method :" + "Deal_With_Template.AddCustomSignatories_Party2()");
		try {

			Thread.sleep(3000);

			// click on dropdwon of party 2
			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[2]")).click();

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(1000);

			AddSignatoriesButton_Party2.click();

			// click on add custom signatories

			Thread.sleep(1000);

			AddCustomSignatories.click();

			Thread.sleep(1000);

			EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party2"));

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);

			EnterSignatories_EmailAddress
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty2"));

			EnterSignatories_MobileNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party2"));

			ClickOnConfirmButton.click();
			Thread.sleep(400);

			ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

			Thread.sleep(4000);
		} catch (Exception e) {

			System.err.println("Error in Method :" + "Deal_With_Template.AddCustomSignatories_Party2()");
			System.err.println(e);
		}

	}

	public void AddCustomSignatories_Party3() throws Exception {

		System.out.println("Executing Method :" + "Deal_With_Template.AddCustomSignatories_Party3()");

		try {
			Thread.sleep(6000);

			// click on dropdwon of party 3
			driver.findElement(By.xpath("(//*[@id=\"headingTwo\"]/h5/a/div/div/a/img)[3]")).click();

			Actions action = new Actions(driver);

			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			Thread.sleep(3000);

			AddSignatoriesButton_Party3.click();

			// click on add custom signatories

			Thread.sleep(4000);

			AddCustomSignatories.click();

			Thread.sleep(1000);

			EnterSignatories_FullName.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_FullName_Party3"));

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);

			EnterSignatories_EmailAddress
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_EmailAddressParty3"));

			EnterSignatories_MobileNumber
					.sendKeys(UtilityClass.getDatafromPropertyFile("Signatories_MobileNumber_party3"));
			Thread.sleep(400);

			ClickOnConfirmButton.click();
			Thread.sleep(900);

			ClickOnConfirmButtonAfterEnterSignatioriesDetails.click();

			Thread.sleep(700);

			action.sendKeys(Keys.PAGE_UP).build().perform();

			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(200);

			ClickOnProceedButton.click();

		} catch (Exception e) {
			System.err.println(e);
			System.err.println("error occurs while adding party signatories 3 ");
		}
		Thread.sleep(4000);

	}

	// Utility method to check if a given text is present on the screen
	public boolean isDealRefIDPresentOnScreen(String DealWithtemplate_RefereneceID) throws InterruptedException {
		// Check if the page source contains the DealRefID
		Thread.sleep(1000);

		return driver.getPageSource().contains(DealWithtemplate_RefereneceID);
	}

	public void performActionsBasedOnDealRefID() throws Exception {

		// Get the deal id
		System.out.println("Executing Method :" + "Deal_With_Template.performActionsBasedOnDealRefID()");

		Thread.sleep(3000);

		try {
			String DealWithTemplateRefid = DealWithtemplate_RefereneceID;

			// Check if the DealRefID is present on the screen
			if (isDealRefIDPresentOnScreen(DealWithTemplateRefid)) {
				// If DealRefID is present, click on the edit button
				clickEditButton();

				System.out.println("Clicked on Edit button successfully.");

			} else {
				System.err.println("DealRefID not found on the screen.");
			}

			// Check if the DealRefID is present on the screen
			if (isDealRefIDPresentOnScreen(DealWithTemplateRefid)) {
				// If DealRefID is present, click on the edit button
				Assert.assertTrue(true, DealWithTemplateRefid);

				System.out.println("after clicked on edit button correct Deal Reference is opened ");
			} else {
				System.err.println("after clicked on edit button correct Deal Reference is not opened ");
			}
		} catch (Exception e) {
			System.out.println("Executing Method :" + "Deal_With_Template.performActionsBasedOnDealRefID()");
			System.err.println(e);

		}
	}

	// Utility method to click on the "Edit" button
	public void clickEditButton() throws InterruptedException {
		System.out.println("Executing Method :" + "Deal_With_Template.clickEditButton()");
		try {
			// Assuming the Edit button has an ID "editButtonId"
			driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']/tr[td[1]//strong[contains(.,'"
					+ DealWithtemplate_RefereneceID + "')]]//img[@title='View']")).click();
			// Print a message for demonstration
			System.out.println("Clicked on the Edit button.");
		} catch (Exception e) {
			System.err.println("error In method :" + "Deal_With_Template.clickEditButton()");
			System.err.println(e);
		}
	}

	public void ClickOnSendForExecutionButton() throws Exception {

		Thread.sleep(1000);
		System.out.println("Executing Method : " + "Deal_With_Template.ClickOnSendForExecutionButton()");

		if (SendForExecution.isDisplayed()) {

			Assert.assertTrue(SendForExecution.isDisplayed(), "Error: SendForExecution Button is not displayed.");

			SendForExecution.click();

			Thread.sleep(400);

			// click on confirm button

			ConfirmButton.click();
			Thread.sleep(300);

			String CaptureValidationMessage_AfterClickOnSendForexcutionButton1 = CapturePopUpMessage_AfterClickOnSendForexcutionButton
					.getText();

			System.out.println("After Clicked on Send for execution button This Validation is displayed  : "
					+ CaptureValidationMessage_AfterClickOnSendForexcutionButton1);

		} else {
			System.out.println("Deal_With_Template.ClickOnSendForExecutionButton()");

			System.err.println("Error : indicating an issue while initiating the deal.");

		}

		Thread.sleep(1000);

	}

}
