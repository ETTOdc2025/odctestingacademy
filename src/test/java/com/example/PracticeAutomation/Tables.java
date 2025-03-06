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

public class Tables {
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
  public void testTables() throws Exception {
    driver.get("https://practice-automation.com/tables/");
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
    try {
      assertEquals("Tables | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("main")).click();
    try {
      assertTrue(driver.findElement(By.xpath("//article[@id='post-1076']/div/p")).getText().matches("^Have you ever needed to look up something in a table[\\s\\S] That’s a trivial task for a human, but computers must be given step-by-step instructions to do the same\\.$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("main")).click();
    try {
      assertEquals("Simple Table", driver.findElement(By.id("simple-table-item-prices")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("main")).click();
    try {
      assertEquals("Use the following example to learn how to look up somethings in a table.", driver.findElement(By.xpath("//article[@id='post-1076']/div/p[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]")).click();
    driver.findElement(By.xpath("//table[@id='tablepress-1']/thead/tr/th/span")).click();
    driver.findElement(By.xpath("//table[@id='tablepress-1']/thead/tr/th[2]")).click();
    try {
      assertEquals("Tables | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//table[@id='tablepress-1']/thead/tr/th[3]/span")).click();
    try {
      assertEquals("Tables | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td")).click();
    driver.findElement(By.xpath("//div[@id='tablepress-1_wrapper']/div[3]/div[2]/div/nav/button[3]")).click();
    driver.findElement(By.xpath("//div[@id='tablepress-1_wrapper']/div[3]/div[2]/div/nav/button[4]")).click();
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
