package com.demo.testing.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testing.driver.DriverSingleton;

public class HomePage {
	
private WebDriver driver;
	
	public HomePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@id='wp-admin-bar-site-name']/a[@class='ab-item']")
	private WebElement lstMenu;
	
	@FindBy(css="#wpbody-content > div.wrap > h1")
	private WebElement txtDashboard;
	
	public void goToDashboard() {
		lstMenu.click();
	}
	
	public String getDashboard() {
		return txtDashboard.getText();
	}
	
}
