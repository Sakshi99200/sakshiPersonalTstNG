package com.TransBnk.Deal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Delete_TemplateFields_RepeatingSection {
	public WebDriver driver;

	@FindBy(xpath = "(.//button[contains(.,' Yes ')])[1]")
	private WebElement ClickOnYesButton;

	public Delete_TemplateFields_RepeatingSection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// ** delete added template fields **//

	public void Verify_Delete_TemplateFields_StateName() throws Exception {

		// delete added template fields

		// -- state name --//

		Thread.sleep(1000);

		WebElement TemplateFields_State_Name = driver.findElement(By.xpath(
				"//div[@id=\"profile-vertical\"]//form[contains(.,'Template Fields')]/div/div[1]//div[@class=\"text\" and contains(.,'"
						+ UtilityClass.getDatafromPropertyFile("SectionName_State")
						+ "')]/following-sibling::div[@class='icons-action']"));

		Assert.assertTrue(TemplateFields_State_Name.isDisplayed());

		Actions action = new Actions(driver);

		action.moveToElement(TemplateFields_State_Name).click().build().perform();

		System.out.println("clicked on Delete option to delete State name template field");

	}

	public void Verify_Delete_TemplateFields_AgreementDate() throws Exception {

		// delete added template fields

		// -- Agreement date --//

		Thread.sleep(1000);

		WebElement TemplateFields_State_Name = driver.findElement(By.xpath(
				"//div[@id=\"profile-vertical\"]//form[contains(.,'Template Fields')]/div/div[1]//div[@class=\"text\" and contains(.,'"
						+ UtilityClass.getDatafromPropertyFile("Section_AgreementDate")
						+ "')]/following-sibling::div[@class='icons-action']"));

		Assert.assertTrue(TemplateFields_State_Name.isDisplayed());

		Actions action = new Actions(driver);

		action.moveToElement(TemplateFields_State_Name).click().build().perform();

		System.out.println("clicked on Delete option to delete Agreement date template field");

	}

	public void Verify_Delete_TemplateFields_repeatingSection() throws Exception {

		// delete added template fields

		// -- Repeating Section --//

		Thread.sleep(1000);

		WebElement TemplateFields_State_Name = driver.findElement(By.xpath(
				"//div[@id=\"profile-vertical\"]//form[contains(.,'Template Fields')]/div/div[1]//div[@class=\"text\" and contains(.,'"
						+ UtilityClass.getDatafromPropertyFile("Repeating_Section")
						+ "')]/following-sibling::div[@class='icons-action']"));

		Assert.assertTrue(TemplateFields_State_Name.isDisplayed());

		Actions action = new Actions(driver);

		action.moveToElement(TemplateFields_State_Name).click().build().perform();

		System.out.println("clicked on Delete option to delete Repeating Section template field");

	}

	public void ClickOn_YesButton_ToDeleteField() throws InterruptedException {

		// click on YES button to delete the field

		Thread.sleep(800);

		ClickOnYesButton.click();

	}

}
