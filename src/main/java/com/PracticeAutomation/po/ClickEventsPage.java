package com.PracticeAutomation.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ClickEventsPage extends PageObject {
		
public ClickEventsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//button[contains(@onclick,'catSound()')]")
private WebElement cat;
@FindBy(xpath="//button[contains(@onclick,'dogSound()')]")
private WebElement dog ;
@FindBy(xpath="//button[contains(@onclick,'pigSound()')]")
private WebElement pig;
@FindBy(xpath="//button[contains(@onclick,'cowSound()')]")
private WebElement cow;
@FindBy(id="demo")
private WebElement textDemo;
public WebElement getCat() {
	return cat;
}
public void setCat(WebElement cat) {
	this.cat = cat;
}
public WebElement getDog() {
	return dog;
}
public void setDog(WebElement dog) {
	this.dog = dog;
}
public WebElement getPig() {
	return pig;
}
public void setPig(WebElement pig) {
	this.pig = pig;
}
public WebElement getCow() {
	return cow;
}
public void setCow(WebElement cow) {
	this.cow = cow;
}
public WebElement getTextDemo() {
	return textDemo;
}
public void setTextDemo(WebElement textDemo) {
	this.textDemo = textDemo;
}
}