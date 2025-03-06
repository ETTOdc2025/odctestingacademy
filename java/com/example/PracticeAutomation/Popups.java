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

public class Popups {
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
  public void testPopups() throws Exception {
    driver.get("https://practice-automation.com/popups/");
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
    try {
      assertEquals("Popups | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/nav")).click();
    try {
      assertEquals("Home » Popups", driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/nav")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("main")).click();
    try {
      assertEquals("Popups (a.k.a., alerts) are a common feature in all modern web browsers. Use this page to practice handling the different type of popups that you may encounter. Click any of the buttons below to see a different popup.", driver.findElement(By.xpath("//article[@id='post-1055']/div/p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//button[@id='alert']/b")).click();
    acceptNextAlert = true;
    assertEquals("Hi there, pal!", closeAlertAndGetItsText());
    driver.findElement(By.xpath("//button[@id='confirm']/b")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [answerOnNextPrompt | Ward | ]]
    assertTrue(closeAlertAndGetItsText().matches("^OK or Cancel, which will it be[\\s\\S]$"));
    driver.findElement(By.xpath("//button[@id='prompt']/b")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [getPrompt |  | ]]
    driver.findElement(By.xpath("//div[@onclick='showTooltip()']")).click();
    driver.findElement(By.id("myTooltip")).click();
    driver.findElement(By.xpath("//article[@id='post-1055']/div/div[3]")).click();
    try {
      assertEquals("OK it is!", driver.findElement(By.id("confirmResult")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//article[@id='post-1055']/div/div[3]")).click();
    try {
      assertEquals("Nice to meet you, Ward!", driver.findElement(By.id("promptResult")).getText());
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
