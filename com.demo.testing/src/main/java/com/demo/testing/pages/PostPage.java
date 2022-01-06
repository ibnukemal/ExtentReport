package com.demo.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.testing.driver.DriverSingleton;

public class PostPage {

private WebDriver driver;
	
	public PostPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu-posts")
	private WebElement btnPost;
	
	@FindBy(css = "#wpbody-content > div.wrap > a")
	private WebElement btnAddPost;
	
	@FindBy(css = "#post-title-0")
	private WebElement txtTitle;
	
	@FindBy(xpath = "//*[@id=\"editor\"]/div[1]/div[1]/div[1]/div/div[2]/button[2]")
	private WebElement btnPublish;
	
	@FindBy(xpath = "//*[@id=\"editor\"]/div[1]/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/button")
	private WebElement btnPublish2;
	
	@FindBy(xpath = "//*[@id=\"editor\"]/div[1]/div[1]/div[1]/div/a")
	private WebElement menuWordpress;
	
	public void goToPostPage() {
		btnPost.click();
	}
	
	public void addPost(){
		btnAddPost.click();
	}
	
	public void publishPost(String title) {
		txtTitle.sendKeys(title);
		btnPublish.click();
	}
	
	public void clickPublish() {
		btnPublish2.click();
	}
	
	public void clickWordpress() {
		menuWordpress.click();
	}
}
