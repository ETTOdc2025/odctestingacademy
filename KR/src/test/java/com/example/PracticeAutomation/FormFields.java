package com.example.PracticeAutomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.example.practiceautomation.po.FormFieldsPage;

public class FormFields {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	FormFieldsPage formFields;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		baseUrl = "https://practice-automation.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		formFields = new FormFieldsPage(driver);
	}

	@Test
	public void testFormFields() throws Exception {
		driver.get("https://practice-automation.com/form-fields/");
		try {
			//WebElement element = driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
			assertEquals("Form Fields", formFields.getFormFieldsTitle().getText());
			formFields.log.info("* Required  : est affiché correctement");
			formFields.getInputName().clear();
			formFields.getInputName().sendKeys("Islem");
			
			formFields.getInputPassword().clear();
			formFields.getInputPassword().sendKeys("123456");
			
			formFields.getWaterDrink().click();
			
			formFields.perform(formFields.getCtrlAltDelightDrink());
		
			formFields.getRedColor().click();
			
			formFields.perform(formFields.getfFC0CBColor());
			
			formFields.JavaScriptExecutor(formFields.getAutomationId());
			Thread.sleep(1000);
			
			formFields.getSelect(formFields.getAutomationId()).selectByVisibleText("Yes");
			formFields.getSelect(formFields.getAutomationId()).selectByVisibleText("No");
			formFields.getSelect(formFields.getAutomationId()).selectByVisibleText("Undecided");
			
			assertEquals("Selenium", formFields.getSeleniumText().getText());
			
			formFields.getEmailId().clear();
			formFields.getEmailId().sendKeys("souihi@gmail.com");
			
			formFields.getMsgId().clear();
			formFields.getMsgId().sendKeys("Hello");	
			
			formFields.getSubmitBtnId().click();
			Thread.sleep(1000);
			
			
			/*	
			
			// Forcer le scroll avant chaque interaction
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formFields.getAutomationId());
			Thread.sleep(500); // Petite pause pour assurer le scroll
			
			
			/*
			
			
			// actions.perform() // Déplace la souris sur l'élément, ce qui peut déclencher
			// le scroll
			// Sélectionner l'élément du menu déroulant
			WebElement automationDropdown = driver.findElement(By.id("automation"));
			// Forcer le scroll avant chaque interaction
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", automationDropdown);
			Thread.sleep(500); // Petite pause pour assurer le scroll
			
			// Sélectionner "Yes"
			new Select(automationDropdown).selectByVisibleText("Yes");
			
			// Sélectionner "No"
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", automationDropdown);
			Thread.sleep(500);
			new Select(automationDropdown).selectByVisibleText("No");
			
			// Sélectionner "Undecided"
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", automationDropdown);
			Thread.sleep(500);
			new Select(automationDropdown).selectByVisibleText("Undecided");
			
			
			
			
			element = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li"));
			assertEquals("Selenium", element.getText());
			
			element = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[2]"));
			assertEquals("Playwright", element.getText());
			
			element = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[3]"));
			assertEquals("Cypress", element.getText());
			
			element = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[4]"));
			assertEquals("Appium", element.getText());
			
			element = driver.findElement(By.xpath("//form[@id='feedbackForm']/ul/li[5]"));
			assertEquals("Katalon Studio", element.getText());
			
			
			driver.findElement(By.id("feedbackForm")).click();
			element = driver.findElement(By.id("email"));
			element.click();
			element.clear();
			element.sendKeys("Souihi.islem@gmail.com");
			Thread.sleep(500);
			
			
			element = driver.findElement(By.id("message"));
			element.click();
			element.clear();
			element.sendKeys("hello word");
			Thread.sleep(500);
			element = driver.findElement(By.id("submit-btn"));
			element.click();
			
			*/
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
