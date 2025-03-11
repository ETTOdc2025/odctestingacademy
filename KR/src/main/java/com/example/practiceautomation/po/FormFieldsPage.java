package com.example.practiceautomation.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormFieldsPage extends PageObject {

	public FormFieldsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//div[@id='top-wrap']/section/div/h1")
	private WebElement formFieldsTitle;
	
	@FindBy(id = "name-input")
	private WebElement inputName;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement inputPassword;
	
	@FindBy(id = "drink1")
	private WebElement waterDrink;
	
	@FindBy(id = "drink5")
	private WebElement ctrlAltDelightDrink;

	@FindBy(id = "color1")
	private WebElement redColor;
	
	@FindBy(id = "color5")
	private WebElement fFC0CBColor;
	
	@FindBy(id = "automation")
	private WebElement automationId;
	
	@FindBy(xpath = "//form[@id='feedbackForm']/ul/li")
	private WebElement seleniumText;
	
	@FindBy(id = "email")
	private WebElement emailId;
	
	@FindBy(id = "message")
	private WebElement msgId;
	
	@FindBy(id = "submit-btn")
	private WebElement submitBtnId;

	
	
	public void clickFavoritDrink(int index)
	{
		driver.findElement(By.xpath("//input[@id='drink"+index+"']")).click();
	}
	
	public void clickAllFavoritDrink()
	{
		for (int i = 0; i < 4; i++) {
			clickFavoritDrink(i+1);
		}
	}
	
	


	public WebElement getFormFieldsTitle() {
		return formFieldsTitle;
	}

	public void setFormFieldsTitle(WebElement formFieldsTitle) {
		this.formFieldsTitle = formFieldsTitle;
	}

	public WebElement getInputName() {
		return inputName;
	}

	public void setInputName(WebElement inputName) {
		this.inputName = inputName;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(WebElement inputPassword) {
		this.inputPassword = inputPassword;
	}

	public WebElement getWaterDrink() {
		return waterDrink;
	}

	public void setWaterDrink(WebElement waterDrink) {
		this.waterDrink = waterDrink;
	}

	public WebElement getRedColor() {
		return redColor;
	}

	public void setRedColor(WebElement redColor) {
		this.redColor = redColor;
	}

	public WebElement getCtrlAltDelightDrink() {
		return ctrlAltDelightDrink;
	}

	public void setCtrlAltDelightDrink(WebElement ctrlAltDelightDrink) {
		this.ctrlAltDelightDrink = ctrlAltDelightDrink;
	}

	public WebElement getfFC0CBColor() {
		return fFC0CBColor;
	}

	public void setfFC0CBColor(WebElement fFC0CBColor) {
		this.fFC0CBColor = fFC0CBColor;
	}

	public WebElement getAutomationId() {
		return automationId;
	}

	public void setAutomationId(WebElement automationId) {
		this.automationId = automationId;
	}

	public WebElement getSeleniumText() {
		return seleniumText;
	}

	public void setSeleniumText(WebElement seleniumText) {
		this.seleniumText = seleniumText;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public void setEmailId(WebElement emailId) {
		this.emailId = emailId;
	}

	public WebElement getMsgId() {
		return msgId;
	}

	public void setMsgId(WebElement msgId) {
		this.msgId = msgId;
	}

	public WebElement getSubmitBtnId() {
		return submitBtnId;
	}

	public void setSubmitBtnId(WebElement submitBtnId) {
		this.submitBtnId = submitBtnId;
	}
	
	
	
	
	

	
	
	
	

	
	

}
