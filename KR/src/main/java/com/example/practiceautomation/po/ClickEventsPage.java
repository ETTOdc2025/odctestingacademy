package com.example.practiceautomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickEventsPage extends PageObject {
	

	public ClickEventsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"top-wrap\"]/section/div/h1")
	private WebElement clickEventsTitle;
	
	
	@FindBy(xpath = "//button[@onclick='catSound()']")
	private WebElement btnCat;
	
	@FindBy(id = "demo")
	private WebElement msgCat;

	
	
	@FindBy(xpath = "//button[@onclick='dogSound()']")
	private WebElement btnDog;
	
	@FindBy(id = "demo")
	private WebElement msgDog;

	
	
	
	@FindBy(xpath = "//button[@onclick='pigSound()']")
	private WebElement btnPig;
	
	@FindBy(id = "demo")
	private WebElement msgPig;
	
	
	
	
	@FindBy(xpath = "//button[@onclick='cowSound()']")
	private WebElement btnCow;
	
	@FindBy(id = "demo")
	private WebElement msgCow;
	
	

	
	@FindBy(id = "demo")
	private WebElement msgAnimal;
		
	

	public WebElement getClickEventsTitle() {
		return clickEventsTitle;
	}

	public void setClickEventsTitle(WebElement clickEventsTitle) {
		this.clickEventsTitle = clickEventsTitle;
	}

	public WebElement getBtnCat() {
		return btnCat;
	}

	public void setBtnCat(WebElement btnCat) {
		this.btnCat = btnCat;
	}

	public WebElement getMsgCat() {
		return msgCat;
	}

	public void setMsgCat(WebElement msgCat) {
		this.msgCat = msgCat;
	}

	public WebElement getBtnDog() {
		return btnDog;
	}

	public void setBtnDog(WebElement btnDog) {
		this.btnDog = btnDog;
	}

	public WebElement getMsgDog() {
		return msgDog;
	}

	public void setMsgDog(WebElement msgDog) {
		this.msgDog = msgDog;
	}

	public WebElement getBtnPig() {
		return btnPig;
	}

	public void setBtnPig(WebElement btnPig) {
		this.btnPig = btnPig;
	}

	public WebElement getMsgPig() {
		return msgPig;
	}

	public void setMsgPig(WebElement msgPig) {
		this.msgPig = msgPig;
	}

	public WebElement getBtnCow() {
		return btnCow;
	}

	public void setBtnCow(WebElement btnCow) {
		this.btnCow = btnCow;
	}

	public WebElement getMsgCow() {
		return msgCow;
	}

	public void setMsgCow(WebElement msgCow) {
		this.msgCow = msgCow;
	}

	public WebElement getMsgAnimal() {
		return msgAnimal;
	}

	public void setMsgAnimal(WebElement msgAnimal) {
		this.msgAnimal = msgAnimal;
	}
	
	
	
	
	
	

}
