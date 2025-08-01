package com.TransBnk.Deal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Library.UtilityClass;

public class Edit_Templates {

	public WebDriver driver;

	public Edit_Templates(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ** check Template fields are visible to not **//

	public void Verify_AddedTemplateFields_StateName() throws Exception {

		// verify that added template fields are visible or not under template - state
		// name
		// information
		Thread.sleep(1000);

		WebElement TemplateFields_State_Name = driver.findElement(By.xpath(
				"//div[@id=\"profile-vertical\"]//form[contains(.,'Template Fields')]/div/div[1]//div[@class=\"text\" and contains(.,'"
						+ UtilityClass.getDatafromPropertyFile("SectionName_State") + "')]"));

		Assert.assertTrue(TemplateFields_State_Name.isDisplayed());

		System.out.println("Created State Name Template Field is displayed on screen ");

	}

	public void Verify_AddedTemplateFields_AgreementDate() throws Exception {

		// verify that added template fields are visible or not under template
		// information - agreement date
		Thread.sleep(1000);
		WebElement TemplateFields_AgreementDate = driver.findElement(By.xpath(
				"//div[@id=\"profile-vertical\"]//form[contains(.,'Template Fields')]/div/div[1]//div[@class=\"text\" and contains(.,'"
						+ UtilityClass.getDatafromPropertyFile("Section_AgreementDate") + "')]"));

		Assert.assertTrue(TemplateFields_AgreementDate.isDisplayed());

		System.out.println("Created Agreement date Template Field is displayed on screen ");

	}

	// ** Repeating section fields are visible or not**//

	public void Verify_RepeatingfSectionsFields() throws Exception {

		// verify added Repeating sections are visible on screen or not -- repeating
		// section
		Thread.sleep(1000);

		WebElement TemplateFields_RepeatingSection = driver.findElement(By.xpath(
				"//div[@id=\"profile-vertical\"]//form[contains(.,'Template Fields')]/div/div[1]//div[@class=\"text\" and contains(.,'"
						+ UtilityClass.getDatafromPropertyFile("Repeating_Section") + "')]"));

		Assert.assertTrue(TemplateFields_RepeatingSection.isDisplayed());

		System.out.println("Created Agreement date  Field is displayed on screen ");

	}

}
