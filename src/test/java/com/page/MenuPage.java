package com.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

	@FindBy(xpath="//ul[@class='oxd-main-menu']//a")
	List<WebElement> menuList;
	
	
	
	public MenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * Create a method that takes 1 string parameter
	 * 
	 * that parameter is our menu name
	 */
									//Time
	public void navigateTo(String menuOption) {
		
		for(WebElement menu: menuList) {		
			String actText = menu.getText();					
			if(actText.equals(menuOption)) {
				menu.click();
				break;
			}		
		}	
	}
}
