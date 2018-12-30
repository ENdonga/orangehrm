package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import pages.DashboardPage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DashboardPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	public DashboardPageTest() {
		super();
	}

	@Test
	public void verifyWelcomeUserLabelTest(){
		Assert.assertTrue(dashboardPage.verifyWelcomeLabel(), "Username label not displayed");
	}

	@BeforeMethod
	public void setup() {
		// open browser
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.loginApplication(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}

}
