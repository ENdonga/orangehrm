package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class LogoutPage extends TestBase{

	// create an object repository for logged out page (also log in page)
	// compare the url
	WebElement alternativeLoginBtn = driver.findElement(By.id("openIdLogin"));
	
	public LogoutPage() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifyAlternativeLoginBtnIsDisplayed() {
		return alternativeLoginBtn.isDisplayed();
	}
}
