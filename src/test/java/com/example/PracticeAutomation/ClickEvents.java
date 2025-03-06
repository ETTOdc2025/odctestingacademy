package com.example.PracticeAutomation;
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
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;
public class ClickEvents {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  ClickEventsPage clickeventspage;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		clickeventspage = new ClickEventsPage(driver);
	
		baseUrl = "https://practice-automation.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}
	
	
	
 @Test
  public void testClickEvents() throws Exception {
    driver.get("https://practice-automation.com/click-events/");
    try {
    	
    WebElement element = driver.findElement(By.xpath("//h1[@itemprop='headline']"));
    assertEquals("Click Events", element.getText());
    driver.findElement(By.xpath("//b[normalize-space()='Cat']")).click();
     element= driver.findElement(By.xpath("//h2[@id='demo']"));
    assertEquals("Meow!",element.getText());
    driver.findElement(By.xpath("//b[normalize-space()='Dog']")).click();
    element= driver.findElement(By.xpath("//h2[@id='demo']"));
    assertEquals("Woof!", element.getText());
    driver.findElement(By.xpath("//b[normalize-space()='Pig']")).click();
   element = driver.findElement(By.xpath("//h2[@id='demo']"));
   assertEquals("Oink!", element.getText());
   driver.findElement(By.xpath("//b[normalize-space()='Cow']")).click();
  element = driver.findElement(By.xpath("//h2[@id='demo']"));
  assertEquals("Moo!", element.getText());
  
  clickeventspage.takeScreenShot("clickevents.jpg");
  clickeventspage.takeScreenShot("getClickEventsTitle.jpg", clickeventspage.getCat());
  
  
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
@Test
  public void testClickEventsPage() throws Exception {
	driver.get("https://practice-automation.com/click-events/");
    String[][] sounds = {{"cat","Meow!"},{"dog","Woof!"},{"pig","Oink!"},{"cow","Moo!"}};
    try {
    	 for (int i = 0; i < sounds.length; i++) {
    	        driver.findElement(By.xpath("//button[@onclick='"+ sounds[i][0]+"Sound()']")).click();
    	
				assertEquals(sounds[i][1], driver.findElement(By.id("demo")).getText());
    	 }
    	
   clickeventspage.getCat().click();
   assertEquals("Meow!", clickeventspage.getTextDemo().getText());
   clickeventspage.getDog().click();
   assertEquals("Woof!", clickeventspage.getTextDemo().getText());
   clickeventspage.getPig().click();
   assertEquals("Oink!", clickeventspage.getTextDemo().getText());
   clickeventspage.getCow().click();
  assertEquals("Moo!", clickeventspage.getTextDemo().getText());
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