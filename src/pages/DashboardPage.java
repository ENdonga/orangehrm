package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class DashboardPage extends TestBase{

	// create an object repository for login page
	WebElement welcomeLabel = driver.findElement(By.id("welcome"));
}
