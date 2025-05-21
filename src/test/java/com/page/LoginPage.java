package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}

}
