package com.example.PracticeAutomation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class FormFields {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testFormFields() throws Exception {
    driver.get("https://practice-automation.com/form-fields/");
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
    try {
      assertEquals("Form Fields | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/nav")).click();
    try {
      assertEquals("Home » Form Fields", driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/nav")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("main")).click();
    try {
      assertEquals("Filling out a web form is one of the most fundamental things to learn as you begin your automation journey. You can use the following form to practice entering text into an input field (here is how to enter text using Cypress), selecting a checkbox, clicking a radio button, selecting from a drop-down menu, getting an element’s text and other similar things. Have fun!", driver.findElement(By.xpath("//article[@id='post-1103']/div/p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("name-input")).click();
    String Ward = (String)driver.findElement(By.id("name-input")).getAttribute("value");
    driver.findElement(By.id("name-input")).clear();
    driver.findElement(By.id("name-input")).sendKeys("Ward");
    driver.findElement(By.xpath("//form[@id='feedbackForm']/label[2]")).click();
    driver.findElement(By.id("drink1")).click();
    driver.findElement(By.id("color1")).click();
    driver.findElement(By.id("automation")).click();
    new Select(driver.findElement(By.id("automation"))).selectByVisibleText("Yes");
    driver.findElement(By.id("email")).click();
  //  String khlifiward9@gmail_com = (String)driver.findElement(By.id("email")).getAttribute("value");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("khlifiward9@gmail.com");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).click();
    assertEquals("khlifiward9@gmail.com", driver.findElement(By.id("email")).getAttribute("value"));
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).clear();
    driver.findElement(By.id("message")).sendKeys("Hello!");
   // String Hello! = (String)driver.findElement(By.id("message")).getAttribute("value");
    assertEquals("Hello!", driver.findElement(By.id("message")).getAttribute("value"));
    driver.findElement(By.id("submit-btn")).click();
    assertEquals("Message received!", closeAlertAndGetItsText());
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
