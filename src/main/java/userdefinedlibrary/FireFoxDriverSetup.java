package userdefinedlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxDriverSetup {
	@SuppressWarnings("deprecation")
	public WebDriver driverSetup() {
		String driver = System.getProperty("user.dir") + "/ChromeDriver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driver);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette",true);
		return new FirefoxDriver(capabilities);
	}
}
