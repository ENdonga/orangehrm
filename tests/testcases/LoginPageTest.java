package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;

	public LoginPageTest() {
		super();
	}

	@Test(priority=1)
	public void validateLoginPageTitleTest(){
		Assert.assertEquals(loginPage.verifyPageTitle(), "OrangeHRM");
	}
	@Test(priority=2)
	public void validateSuccessLoginTest() {
		dashboardPage = loginPage.loginApplication(properties.getProperty("username"), properties.getProperty("password"));
	}
	@BeforeMethod
	public void setup() {
		// open browser
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void teardown() {
		// close browser
		driver.quit();
	}
}
