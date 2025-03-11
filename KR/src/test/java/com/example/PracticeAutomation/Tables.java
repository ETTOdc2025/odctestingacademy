package com.example.PracticeAutomation;

import static org.junit.Assert.assertEquals;
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
import org.openqa.selenium.support.ui.Select;

public class Tables {
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
  public void testTables() throws Exception {
    driver.get("https://practice-automation.com/tables/");
    //driver.findElement(By.linkText("Tables")).click();
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
    try {
      assertEquals("Tables", driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/nav")).click();
    try {
      assertEquals("Home", driver.findElement(By.linkText("Home")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("simple-table-item-prices")).click();
    driver.findElement(By.id("main")).click();
    try {
      assertEquals("Tables | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody")).click();
    try {
      assertEquals("$1200.00", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[4]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[4]/td[2]")).click();
    driver.findElement(By.id("main")).click();
    try {
      assertEquals("Tables | Practice Automation", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("25");
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("50");
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("100");
    driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[25]/td")).click();
    driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[25]/td")).click();
    try {
      assertEquals("25", driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[25]/td")).getText());
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
