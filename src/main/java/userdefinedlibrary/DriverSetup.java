package userdefinedlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

	public WebDriver driverSetup() {
		String chromeDriver = System.getProperty("user.dir") + "/ChromeDriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		return new ChromeDriver();
	}
}
