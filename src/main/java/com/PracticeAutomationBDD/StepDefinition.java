package com.PracticeAutomationBDD;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.PracticeAutomation.po.ClickEventsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;
public class StepDefinition {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  ClickEventsPage clickeventspage;
  JavascriptExecutor js;
  StepDefinition stepdefinition; 
  


  @Given("I am in page click events")
  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		clickeventspage = new ClickEventsPage(driver);
		driver.get("https://practice-automation.com/click-events/");
		baseUrl = "https://practice-automation.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}
  
  @When("I click for the Dog")
  public void i_click_for_the_Dog() {
      // Write code here that turns the phrase above into concrete actions
	  clickeventspage.getDog().click();
  }

  @Then("I verify the sound displayed of the Dog")
  public void i_verify_the_sound_displayed_of_the_Dog() {
      // Write code here that turns the phrase above into concrete actions
	  assertEquals("Woof!",  clickeventspage.getTextDemo().getText());
  }

  @When("I click for the Cat")
  public void i_click_for_the_Cat() {
      // Write code here that turns the phrase above into concrete actions
	  clickeventspage.getCat().click();
  }

  @Then("I verify the sound displayed of the Cat")
  public void i_verify_the_sound_displayed_of_the_Cat() {
      // Write code here that turns the phrase above into concrete actions
	  assertEquals("Meow!",  clickeventspage.getTextDemo().getText());
  }

  
  @When("I click for the Pig")
  public void i_click_for_the_Pig() {
      // Write code here that turns the phrase above into concrete actions
	  clickeventspage.getPig().click();
  }

  @Then("I verify the sound displayed of the Pig")
  public void i_verify_the_sound_displayed_of_the_Pig() {
      // Write code here that turns the phrase above into concrete actions
	  assertEquals("Oink!",  clickeventspage.getTextDemo().getText());
  }

  
  
  
  @When("I click for the Cow")
  public void i_click_for_the_Cow() {
      // Write code here that turns the phrase above into concrete actions
	  clickeventspage.getCow().click();
  }

  @Then("I verify the sound displayed of the Cow")
  public void i_verify_the_sound_displayed_of_the_Cow() {
      // Write code here that turns the phrase above into concrete actions
	  assertEquals("Moo!",  clickeventspage.getTextDemo().getText());
  }

  @When("I click for the {string}")
	public void i_click_for_the(String animal) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@onclick=‘"+animal+"Sound()’]")).click();
	}
	@Then("I verify the {string} displayed")
	public void i_verify_the_displayed(String sound) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals( sound,  clickeventspage.getTextDemo().getText());
	}
 
}