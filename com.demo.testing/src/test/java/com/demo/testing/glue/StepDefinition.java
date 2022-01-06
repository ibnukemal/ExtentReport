package com.demo.testing.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.demo.testing.configuration.AutomationFrameworkConfig;
import com.demo.testing.pages.HomePage;
import com.demo.testing.pages.LoginPage;
import com.demo.testing.pages.PostPage;
import com.demo.testing.utils.ConfigProperties;
import com.demo.testing.driver.DriverSingleton;
import com.demo.testing.utils.TestCases;
import com.demo.testing.utils.Utils;
import com.demo.testing.utils.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private PostPage postPage;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");
	
	@Autowired
	ConfigProperties configProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configProperties.getBrowser());
		loginPage = new LoginPage();
		homePage = new HomePage();
		postPage = new PostPage();
		TestCases[] tests = TestCases.values();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@Given("^User go to the Website")
	public void User_go_to_the_Website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}
	
	@When("^User click login button")
	public void User_click_login_button() {
		loginPage.goToLoginPage();
		extentTest.log(LogStatus.PASS, "User click login button");
	}
	
	@When("^User input username password and click login")
	public void User_input_username_password_and_click_login() {
		loginPage.goToLoggedIn(configProperties.getUsername(), configProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username password and click login");
	}
	
	@When("^User click button Dashboard")
	public void User_click_button_Dashboard() {
		homePage.goToDashboard();
		extentTest.log(LogStatus.PASS, "User click button Dashboard");
	}
	
	@When("^User click button Post")
	public void User_click_button_Post() {
		postPage.goToPostPage();
		extentTest.log(LogStatus.PASS, "User click button Post");
	}
	
	@When("^User click button addNew")
	public void User_click_button_addNew() {
		postPage.addPost();
		extentTest.log(LogStatus.PASS, "User click button addNew");
	}
	
	@When("^User input title and click Publish")
	public void User_input_title_and_click_Publish() {
		postPage.publishPost(configProperties.getPostTitle());
		extentTest.log(LogStatus.PASS, "User input title and click Publish");
	}
	
	@When("^User click button Publish")
	public void User_click_button_Publish() {
		postPage.clickPublish();
		extentTest.log(LogStatus.PASS, "User click button Publish");
	}
	
	@Then("^User can login to the Website")
	public void User_can_login_to_the_Website () {
		assertEquals(configProperties.getDisplayName(), loginPage.getDisplayName());
		extentTest.log(LogStatus.PASS, "User can login to the Website");
	}
	
	@Then("^User go to dashboard menu")
	public void User_go_to_dashboard_menu () {
		assertEquals(configProperties.getDashboard(), homePage.getDashboard());
		extentTest.log(LogStatus.PASS, "User go to dashboard menu");
	}
	
	@Then("^User click icon Wordpress")
	public void User_click_icon_Wordpress() {
		postPage.clickWordpress();
		extentTest.log(LogStatus.PASS, "User click icon Wordpress");
	}
	
	@After
	public void closeObject() {
		report.endTest(extentTest);
		report.flush();
	}
	
}
