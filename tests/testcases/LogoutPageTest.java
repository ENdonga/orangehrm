package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DashboardPage;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	LogoutPage logoutPage;
	
	public LogoutPageTest() {
		super();
	}
	
	@Test
	public void validateSuccessfulLogoutTest(){
		Assert.assertTrue(logoutPage.verifyAlternativeLoginBtnIsDisplayed(), "Logout failed. Please try again");;
	}

	@BeforeMethod
	public void setup() {
		// open browser
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.loginApplication(properties.getProperty("username"), properties.getProperty("password"));
		logoutPage = dashboardPage.logoutApplication();
	}

	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}

}
