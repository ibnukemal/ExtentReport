package com.demo.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testing.driver.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#block-7 > div > a")
	private WebElement btnLoginPage;
	
	@FindBy(id = "user_login")
	private WebElement txtUsername;
	
	@FindBy(id = "user_pass")
	private WebElement txtPassword;

	@FindBy(id = "wp-submit")
	private WebElement btnLogin;
	
	@FindBy(css = "#wp-admin-bar-my-account > a > span")
	private WebElement txtDisplayName;
	
	public void goToLoginPage() {
		btnLoginPage.click();
	}
	
	public void goToLoggedIn(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getDisplayName() {
		return txtDisplayName.getText();
	}
}
