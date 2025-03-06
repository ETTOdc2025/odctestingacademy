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
import com.PracticeAutomation.po.FormFieldsPage;
public class FormFields {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	FormFieldsPage formfields;
	
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
		formfields = new FormFieldsPage(driver);
	}
	@Test
	public void testFormFields() throws Exception {
		driver.get("https://practice-automation.com/form-fields/");
		try {
			WebElement element = driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
			assertEquals("Form fields", formfields.getFormFieldsTitle().getText());
			formfields.log.info("* Required  : est affiché correctement");
			formfields.getInputName().clear();
			formfields.getInputName().sendKeys("Islem");
			
			formfields.getInputPassword().clear();
			formfields.getInputPassword().sendKeys("123456");
			
			formfields.getWaterDrink().click();
			
			formfields.getPerform();
		
			formfields.getRedColor().click();
			
		
		
		
			formfields.getEmailId().clear();
			formfields.getEmailId().sendKeys("souihi@gmail.com");
			
			formfields.getMsgId().clear();
			formfields.getMsgId().sendKeys("Hello");	
			
			formfields.getSubmitBtnId().click();
			Thread.sleep(1000);
			
			
			
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
	
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