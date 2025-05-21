package com.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	
	@FindBy(xpath="//li[starts-with(@class,'oxd-topbar-body-nav-tab')]")
	List<WebElement> topMenuList;
	
	
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']//li//a")
	List<WebElement> topSubMenuList;
	
	
	
	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void fromTopMenuNavigateTo(String topMenu, String subMenu) throws InterruptedException {
	
		//this code handles topMenu
		for(WebElement topMenuEl : topMenuList) {		
			String actTopMenu = topMenuEl.getText();			
			if(actTopMenu.equals(topMenu)) {
				topMenuEl.click();
				break;
			}
		}

		Thread.sleep(100);
		
		//this code handles subTopMenu
		for(WebElement subTopMenuEl : topSubMenuList) {
			String actSubTopMenuEL = subTopMenuEl.getText();
			
			if(actSubTopMenuEL.equals(subMenu)) {
				subTopMenuEl.click();
				break;
			}
		}
	}
	
	

}
