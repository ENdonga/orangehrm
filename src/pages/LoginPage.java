package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class LoginPage extends TestBase{

	// create an object repository for login page
	WebElement txtUsername = driver.findElement(By.id("txtUsername"));
	WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	WebElement loginBtn = driver.findElement(By.id("btnLogin"));
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage loginApplication(String username, String password) {
		// clear text fields and type
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		loginBtn.click();
		return new DashboardPage();
	}
}
