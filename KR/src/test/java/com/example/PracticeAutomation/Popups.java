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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Popups {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
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
	  }

  @Test
  public void testPopups() throws Exception {
    driver.get("https://practice-automation.com/popups/");
    try {
    driver.findElement(By.xpath("//button[@id='alert']/b")).click();
    acceptNextAlert = true;
    assertEquals("Hi there, pal!", closeAlertAndGetItsText());
    driver.findElement(By.xpath("//button[@id='confirm']/b")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [answerOnNextPrompt | Islem | ]]
    assertTrue(closeAlertAndGetItsText().matches("^OK or Cancel, which will it be[\\s\\S]$"));
    driver.findElement(By.xpath("//button[@id='prompt']/b")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [getPrompt |  | ]]
    //driver.findElement(By.xpath("//article[@id='post-1055']/div/div[3]")).click();
   
      assertEquals("Nice to meet you, Islem!", driver.findElement(By.id("promptResult")).getText());
    driver.findElement(By.xpath("//div[@onclick='showTooltip()']")).click();
    driver.findElement(By.id("myTooltip")).click();
    
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
