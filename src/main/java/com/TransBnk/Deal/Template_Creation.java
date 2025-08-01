package com.TransBnk.Deal;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;
import com.google.common.base.Predicates;

public class Template_Creation {
	private static final String OpenQA = null;
	public WebDriver driver;
	@FindBy(xpath = "//a[text()='Templates']")
	private WebElement ClickOnTemplateOption;

	@FindBy(xpath = "//app-button[@text=\"Add Template\"]")
	private WebElement ClickOnAddTemplateButton;

	@FindBy(xpath = "//input[@id=\"templateName\"]")
	private WebElement EnterTemplateName;

	@FindBy(xpath = "//*[@id=\"templateDescription\"]")
	private WebElement EnterTemplateDescription;

	@FindBy(xpath = "//*[@id=\"uploadAccount\"]/div/div/div[2]/div/form/div[3]/ng-multiselect-dropdown/div/div[1]/span")
	private WebElement Product_dropdown;

	@FindBy(xpath = "//*[@id=\"productCode\"]")
	private WebElement ClickOnDocumentType;

	@FindBy(xpath = "//input[@id=\"fileUpload\"]")
	private WebElement UploadFileButton;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement ClickOnSaveButton;

	@FindBy(xpath = "//*[@id=\"markfield\"]/ul/li[1]")
	private WebElement MarkTemplateField;

	@FindBy(xpath = "//h6[contains(.,'Predefined Fields')]/following-sibling::select[contains(@formcontrolname, 'placeholderId')]")
	private WebElement PredefinedField_dropdown;

	@FindBy(xpath = "//*[@id=\"selectField\"]/div//form/div[2]/button[2]")
	private WebElement ConfirmButton;

	@FindBy(xpath = "//*[@id=\"editor1\"]/div[2]//div/p[3]")
	private WebElement RepeatingSection;

	@FindBy(xpath = "//li[contains(.,'Mark Repeating Section')]")
	private WebElement clickOn_markRepeatingSectionOption;

	public Template_Creation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// ** click on template ** //
	public void ClickOnTemplate() throws InterruptedException {

		// click on template option
		Thread.sleep(1000);
		ClickOnTemplateOption.click();

	}

	// ** click on add template button **//
	public void AddTemplateButton() throws InterruptedException {

		// click on add template
		Thread.sleep(1500);

		Assert.assertTrue(ClickOnAddTemplateButton.isDisplayed());

		ClickOnAddTemplateButton.click();
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;

	}

	private String getClipboardContents() throws AWTException, UnsupportedFlavorException, IOException {
		// get the contents of the clipboard
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		return clipboard.getData(DataFlavor.stringFlavor).toString();

	}

	public static String TemplateName;
	public String DealRefID;;

	// ** Enter template name ** //

	public String Enter_TemplateName() throws Exception {
		Thread.sleep(1000);
		EnterTemplateName.sendKeys(UtilityClass.getDatafromPropertyFile("TemplateName") + getCurrentTimeStamp());

		// Select and copy the entered value
		EnterTemplateName.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
		EnterTemplateName.sendKeys(Keys.chord(Keys.CONTROL, "c")); // Copy

		// Get the copied text from the clipboard
		TemplateName = getClipboardContents();

		// Print or use the copied value
		System.out.println("Copied Template name Text: " + TemplateName);

		Thread.sleep(2000);
		return TemplateName;

	}

	// ** Enter Template description ** //

	public void EnterTemplateDesciption() throws Exception {

		Thread.sleep(200);

		EnterTemplateDescription.sendKeys(UtilityClass.getDatafromPropertyFile("TemplateDescription"));
	}

	// ** Select product ** //

	public void select_Product(String ProgramName) throws Exception {

		// click on Product dropdown
		Thread.sleep(3000);
		Product_dropdown.click();

		// select product from dropdown
		Thread.sleep(1000);
		List<WebElement> product_list = driver
				.findElements(By.xpath("//li[@class=\"multiselect-item-checkbox ng-star-inserted\"]"));
		// System.out.println(product_list.size());

		for (int i = 0; i < product_list.size(); i++) {
			WebElement ProductString = product_list.get(i);
			String Product_name = ProductString.getText();
			System.out.println(Product_name);
			// Thread.sleep(1000);
			if (Product_name.contains(ProgramName)) {
				System.out.println("expected Product name is present on screen");

				driver.findElement(
						By.xpath("(//li[@class=\"multiselect-item-checkbox ng-star-inserted\"])[" + (i + 1) + "]"))
						.click();

				Product_dropdown.click();

				break;

			} else {
//				System.out.println("product name is not matched");
			}
		}

	}

	// ** select document type ** //
	public void Select_DocumentType() throws Exception {
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
			if (DocumentType_name.contains(UtilityClass.getDatafromPropertyFile("DocumentType01"))) {
				System.out.println("expected document type name is present on screen");

				driver.findElement(By.xpath("//*[@formcontrolname=\"documentType\"]/option[" + (i + 1) + "]")).click();
				break;

			} else {
				System.out.println("document type name is not matched");
			}
		}
		Thread.sleep(2000);

	}

	// ** upload template ** //
	public void UploadTemplate() throws InterruptedException {
		Thread.sleep(500);
		UploadFileButton.sendKeys(System.getProperty("user.dir") + "/TestData/TemplateAutomation.docx");

	}

	// ** click on save button **//

	public void ClickonSaveButton() throws InterruptedException {
		Thread.sleep(200);
		ClickOnSaveButton.click();
	}

	public void openTempltefortest() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//tr[td[contains(., 'automation testing')]]//img[@title='Edit']")).click();

	}

	public void state() throws Exception {

		Thread.sleep(1500);
		String state = UtilityClass.getDatafromPropertyFile("StateName");
//		WebElement welcomeMessageElement = driver.findElement(By.xpath(
//				"//p[contains(., 'ESCROW ACCOUNT AGREEMENT')]/following-sibling::p[contains(.,'" + state + "')]"));

		WebElement divElement = driver.findElement(By.xpath("(//p[contains(., 'ESCROW ACCOUNT AGREEMENT')])[2]"));
		String divText = divElement.getText();
		System.out.println(divText);

		// Extract only the @@State part

		// Find the index of @@State
		int stateIndex = divText.indexOf(state);

		// Find the end index of @@State
		int endIndex = divText.indexOf(" ", stateIndex);

		// Extract only the @@State part
		String stateText = divText.substring(stateIndex, endIndex);

		System.out.println("State: " + stateText);
		Thread.sleep(400);

		// Locate the text containing @@State
		WebElement stateTextN = driver.findElement(By.xpath(".//*[contains(text(), '" + stateText + "')]"));
		Actions actions = new Actions(driver);

		actions.doubleClick(stateTextN).build().perform();

	}

	// ** Click on Mark Mark Template Field option ** //
	public void ClickOn_MarkTemplateField() throws InterruptedException {

		Thread.sleep(700);

		Assert.assertTrue(MarkTemplateField.isDisplayed());

		MarkTemplateField.click();
	}

	// ** Add Mark Template Field details ** //

	// Select the field from the predefined list

	public void SelectStateName_FromPredefinedList(String FieldName) throws Exception {

		// click on Predefined field dropdown
		Thread.sleep(1000);
		PredefinedField_dropdown.click();

		// select Field from dropdown

		List<WebElement> Field_list = driver
				.findElements(By.xpath("//select[@formcontrolname=\"placeholderId\"]/option"));

		for (int i = 0; i < Field_list.size(); i++) {
			WebElement FieldString = Field_list.get(i);
			String Field_name = FieldString.getText();

			// Thread.sleep(1000);
			if (Field_name.contains(FieldName)) {
				System.out.println("expected Entity name is present on screen");

				driver.findElement(By.xpath("//select[@formcontrolname=\"placeholderId\"]/option[" + (i + 1) + "]"))
						.click();
				break;

			} else {
//					System.out.println("field name is not matched");

			}
		}

	}

	public void ClickOnConfirmButton() throws InterruptedException {

		Thread.sleep(1000);

		ConfirmButton.click();

	}

	public void AgreementDate() throws Exception {
		Thread.sleep(1500);
		String AgreementDate = UtilityClass.getDatafromPropertyFile("AgreementDate");
//		WebElement welcomeMessageElement = driver.findElement(By.xpath(
//				"//p[contains(., 'ESCROW ACCOUNT AGREEMENT')]/following-sibling::p[contains(.,'" + state + "')]"));

		WebElement divElement = driver.findElement(By.xpath("(//p[contains(., 'ESCROW ACCOUNT AGREEMENT')])[2]"));
		String divText = divElement.getText();
		System.out.println(divText);

		// Extract only the @@AgreementDate part

		// Find the index of @@AgreementDate
		int AgreementDateIndex = divText.indexOf(AgreementDate);

		// Find the end index of @@AgreementDate
		int endIndex = divText.indexOf(" ", AgreementDateIndex);

		// Extract only the @@AgreementDate part
		String AgreementDateText = divText.substring(AgreementDateIndex, endIndex);

		System.out.println("AgreementDate: " + AgreementDateText);
		Thread.sleep(400);

		// Locate the text containing @@AgreementDate
		WebElement AgreementDateTextN = driver
				.findElement(By.xpath(".//*[contains(text(), '" + AgreementDateText + "')]"));
		Actions actions = new Actions(driver);

		actions.doubleClick(AgreementDateTextN).build().perform();
	}

	// ** mark paragraph as a repeating section ** //

	public void AddRepeatingSection() throws InterruptedException {

		// mark paragraph as a repeating section

		// Click inside the paragraph
		WebElement repeatingSection = driver
				.findElement(By.xpath("//*[@id=\"editor1\"]/div[2]/div[2]/div/p[3]/strong[1]"));
		Actions actions = new Actions(driver);

		WebElement startEle = driver.findElement(By.xpath("//*[@id=\"editor1\"]/div[2]/div[2]/div/p[3]/strong[1]"));
		WebElement EndEle = driver.findElement(By.xpath("//*[@id=\"editor1\"]/div[2]/div[2]/div/p[3]/strong[5]"));
//		actions.moveToElement(startEle).click().build().perform();
		Thread.sleep(2000);
		actions.click(startEle).build().perform();

		actions.clickAndHold().dragAndDrop(EndEle, startEle).build().perform();
		actions.keyDown(Keys.SHIFT);

		// Press Home key
		actions.sendKeys(Keys.HOME);

		// Release Shift key
		actions.keyUp(Keys.SHIFT);

		// Perform the actions
		actions.perform();

	}

	// ** Click on mark repeating section ** //
	public void ClickOn_MarkRepeatingSection() throws InterruptedException {

		Thread.sleep(300);

		clickOn_markRepeatingSectionOption.click();

	}

	
	
//		actions.moveToElement(EndEle).build().perform();
//
//		actions.moveToElement(repeatingSection).click().build().perform();

//		actions.moveToElement(repeatingSection).doubleClick(repeatingSection).build().perform();
//
//		actions.moveToElement(repeatingSection).doubleClick(repeatingSection).build().perform();

//		actions.moveToElement(repeatingSection).doubleClick(repeatingSection).build().perform();
	// Select the entire paragraph
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("function selectElementContents(el) { " + "var range = document.createRange();"
//				+ "range.selectNodeContents(el);" + "var sel = window.getSelection();" + "sel.removeAllRange();"
//				+ "sel.addRange(range);" + "}" + "var el = arguments[0];" + "selectElementContents(el);",
//				repeatingSection);
//		actions.moveToElement(repeatingSection, 0, 0).clickAndHold(repeatingSection).perform();
//
//		actions.moveToElement(repeatingSection, 0, 0).clickAndHold().build().perform();
	// Calculate the height of the paragraph
//		int height = repeatingSection.getSize().getHeight();
//
//		// Move to the end of the paragraph
//		actions.moveToElement(repeatingSection, 0, height).perform();
//		actions.click().build().perform();

//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("function selectElementContents(el) { " +
//                "var range = document.createRange();" +
//                "range.selectNodeContents(el);" +
//                "var sel = window.getSelection();" +
//                "sel.removeAllRanges();" +
//                "sel.addRange(range);" +
//                "}" +
//                "var el = arguments[0];" +
//                "selectElementContents(el);", repeatingSection);
//		String script = "var element = arguments[0];" + "var range = document.createRange();"
//				+ "range.selectNodeContents(element);" + "var selection = window.getSelection();"
//				+ "selection.removeAllRanges();" + "selection.addRange(range);";
//		((JavascriptExecutor) driver).executeScript(script, repeatingSection);

}
//		// Select the entire paragraph
//		String script = "var element = arguments[0];" +
//	            "if (window.getSelection) {" +
//	            "  var selection = window.getSelection();" +
//	            "  selection.removeAllRanges();" +
//	            "  var range = document.createRange();" +
//	            "  range.selectNodeContents(element);" +
//	            "  selection.addRange(range);" +
//	            "} else if (document.selection) {" +
//	            "  var range = document.body.createTextRange();" +
//	            "  range.moveToElementText(element);" +
//	            "  range.select();" +
//	            "}" +
//	            // Simulate double click
//	            "var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });" +
//	            "element.dispatchEvent(evt);";
//		((JavascriptExecutor) driver).executeScript(script, repeatingSection);
//	}
