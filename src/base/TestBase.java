package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testutil.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	String osName = System.getProperty("os.name").toLowerCase();
	String driverPath = System.getProperty("user.dir");

	public TestBase() {
		try {
			properties = new Properties();
			FileInputStream readConfigFile = new FileInputStream(
					System.getProperty("user.dir") + "/src/config/config.properties");
			properties.load(readConfigFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = properties.getProperty("browser").toLowerCase();
//		System.out.println("Operating System: " + osName);
//		System.out.println("Browser name: " + browserName);
		if (osName.contains("windows")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				// initialize new chrome browser
				System.setProperty("webdriver.chrome.driver", driverPath + "/drivers/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				// initialize new chrome browser
				System.setProperty("webdriver.gecko.driver", driverPath + "/drivers/geckodriver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		if (osName.contains("mac")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				// initialize new chrome browser
				System.setProperty("webdriver.chrome.driver", driverPath + "/drivers/chromedriver/chromedriver");
				driver = new ChromeDriver();
			} else {
				// initialize new chrome browser
				System.setProperty("webdriver.gecko.driver", driverPath + "/drivers/geckodriver/geckodriver");
				driver = new FirefoxDriver();
			}
		}
		if (osName.contains("linux")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				// initialize new chrome browser
				System.setProperty("webdriver.chrome.driver",
						driverPath + "/drivers/linuxdrivers/chromedriver/chromedriver");
				driver = new ChromeDriver();
			} else {
				// initialize new chrome browser
				System.setProperty("webdriver.gecko.driver",
						driverPath + "/drivers/linuxdrivers/geckodriver/geckodriver");
				driver = new FirefoxDriver();
			}
		}
		// maximize browser window
		driver.manage().window().maximize();
		// add page load timeout and wait
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
}
