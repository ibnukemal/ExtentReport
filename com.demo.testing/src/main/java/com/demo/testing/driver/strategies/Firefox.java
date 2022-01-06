package com.demo.testing.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver", "D:/Firefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
