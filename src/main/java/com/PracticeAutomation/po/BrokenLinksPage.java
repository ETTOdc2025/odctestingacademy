package com.PracticeAutomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksPage extends PageObject {
	public BrokenLinksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//h1[@itemprop='headline']")
	private WebElement headLine;
	
	@FindBy(linkText = "HTTP response code")
	private WebElement responseCode;
	@FindBy(xpath = "//a[normalize-space()='Home']")
			private WebElement homeText;

	private WebElement logo;
	
	public WebElement getHomeText() {
		return homeText;
	}
	public void setHomeText(WebElement homeText) {
		this.homeText = homeText;
	}
	public WebElement getLogo() {
		return getLogo();
	}
	public void setLogo(WebElement logo) {
		this.logo = logo;
	}
	public WebElement getHeadLine() {
		return headLine;
	}
	public void setHeadLine(WebElement headLine) {
		this.headLine = headLine;
	}
	public WebElement getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(WebElement responseCode) {
		this.responseCode = responseCode;
	}
	
	
}
