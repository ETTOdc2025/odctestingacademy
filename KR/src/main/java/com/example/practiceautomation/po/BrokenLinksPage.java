package com.example.practiceautomation.po;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksPage extends PageObject {

	public BrokenLinksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//*[@id='header']/div/a/img")
	private WebElement logo;
	
	@FindBy(xpath = "//*[@id=\"post-1267\"]/div/p[2]/a")
	private WebElement HTTPResponseCodeText;
	
	@FindBy(xpath = "//h1[@itemprop='headline']")
	private WebElement brokenLinksTitle;
	
	@FindBy(xpath = "//a[normalize-space()= 'Home']")
	private WebElement homeText;
	
	@FindBy(xpath = "//article[@id='post-1267']/div/p[2]")
	private WebElement idealScenarioText;
	
	@FindBy(xpath = "//th[@class='has-text-align-left'][1]")
	private WebElement nameText;
	
	@FindBy(xpath = "//td[@class='has-text-align-left'][1]")
	private WebElement missingPageText;
	
	@FindBy(xpath = "//th[@class='has-text-align-left'][2]")
	private WebElement statusText;
	
	@FindBy(xpath = "//td[@class='has-text-align-left'][2]")
	private WebElement QuatreCentQuatrePageText;
	
	@FindBy(xpath = "//p[contains(., '200')]")
	private List<WebElement> NombreCode200;
	
	

	

	public WebElement getBrokenLinksTitle() {
		return brokenLinksTitle;
	}
	public void setBrokenLinksTitle(WebElement brokenLinksTitle) {
		this.brokenLinksTitle = brokenLinksTitle;
	}
	public WebElement getHomeText() {
		return homeText;
	}
	public void setHomeText(WebElement homeText) {
		this.homeText = homeText;
	}
	public WebElement getLogo() {
		return logo;
	}
	public void setLogo(WebElement logo) {
		this.logo = logo;
	}
	public WebElement getHTTPResponseCodeText() {
		return HTTPResponseCodeText;
	}
	public void setHTTPResponseCodeText(WebElement response) {
		this.HTTPResponseCodeText = HTTPResponseCodeText;
	}
	public WebElement getIdealScenarioText() {
		return idealScenarioText;
	}
	public void setIdealScenarioText(WebElement idealScenarioText) {
		this.idealScenarioText = idealScenarioText;
	}

	public WebElement getQuatreCentQuatrePageText() {
		return QuatreCentQuatrePageText;
	}
	public void setQuatreCentQuatrePageText(WebElement QuatreCentQuatrePageText) {
		this.QuatreCentQuatrePageText = QuatreCentQuatrePageText;
	}
	public WebElement getNameText() {
		return nameText;
	}
	public void setNameText(WebElement nameText) {
		this.nameText = nameText;
	}
	public WebElement getMissingPageText() {
		return missingPageText;
	}
	public void setMissingPageText(WebElement missingPageText) {
		this.missingPageText = missingPageText;
	}
	public WebElement getStatusText() {
		return statusText;
	}
	public void setStatusText(WebElement statusText) {
		this.statusText = statusText;
	}
	public List<WebElement> getNombreCode200() {
		return NombreCode200;
	}

	public void setNombreCode200(List<WebElement> NombreCode200) {
		this.NombreCode200 = NombreCode200;
	}

	

	
	
}