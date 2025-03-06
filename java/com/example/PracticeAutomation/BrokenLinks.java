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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class BrokenLinks {
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
  public void testBrokenLinks() throws Exception {
	 
    driver.get("https://practice-automation.com/broken-links/");
    try {
   // Broken Links : Titre de la page
    WebElement element = driver.findElement(By.xpath("//*[@id=\"top-wrap\"]/section/div/nav/span/span[1]/a")); 	// Action Home
    assertEquals("Home", element.getText());  // Resultat attendu
    element = driver.findElement(By.xpath("//article[@id='post-1267']/div/p[2]"));
    assertEquals("In an ideal scenario a website should have no broken links. Therefore, it’s important to ensure that all links are working properly. One way to do that is to verify that the HTTP response code is 200 when the link is clicked.", element.getText());
    element = driver.findElement(By.xpath("//article[@id='post-1267']/div/p[3]"));
    assertEquals("In this case, clicking the link will return a response code of 404 (Not Found). You could write an automated test that checks for the expected response code of 200.",element.getText());
       }
    catch (Error e) {
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