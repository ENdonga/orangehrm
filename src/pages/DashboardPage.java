package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.TestBase;

public class DashboardPage extends TestBase{

	// create an object repository for login page
	WebElement welcomeLabel = driver.findElement(By.id("welcome"));
	WebElement welcomeModal = driver.findElement(By.id("welcome-menu"));
	WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	
	public DashboardPage() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyWelcomeLabel() {
		return welcomeLabel.isDisplayed();
	}
	
	public LogoutPage logoutApplication() {
		welcomeLabel.click();
		Actions action = new Actions(driver);
		action.moveToElement(welcomeModal).build().perform();
		logoutLink.click();
		return new LogoutPage();
	}
}
