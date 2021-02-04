/**
 * 
 */
package testscenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverService;

import testobjectrepository.GooglePage;
import userdefinedlibrary.DriverSetup;
import userdefinedlibrary.ExcelReadWrite;
import userdefinedlibrary.FireFoxDriverSetup;
import userdefinedlibrary.Property;
import userdefinedlibrary.ScreenShot;

public class NavigationCommand {

	public static WebDriver chromeDriver;
	public static WebDriver firefoxDriver;

	public static void main(String[] args) {

	}

	@BeforeClass
	public static void setup() {
		DriverSetup driver = new DriverSetup();
		FireFoxDriverSetup fireFoxDriverSetup = new FireFoxDriverSetup();
		firefoxDriver = fireFoxDriverSetup.driverSetup();
		chromeDriver = driver.driverSetup();
	}

	@Test
	public void TileTest() {
		// TODO Auto-generated method stub

		Property property = new Property();
		GooglePage searchResult = new GooglePage();
		String expectedTitle = null;
		String weburl = null;
		String searchText = null;

		try {
			expectedTitle = property.readPropertiesFile("ExpectedTitle");
			weburl = property.readPropertiesFile("WebUrl");
			searchText = property.readPropertiesFile("SearchText");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualTitle = searchResult.getSearchResults(chromeDriver, weburl, searchText);

		Assert.assertEquals(actualTitle, expectedTitle.toString());

	}

	@Test
	public void getScreenshotTest() {

		try {
			ScreenShot sc = new ScreenShot();
			sc.getScreenShot(chromeDriver);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void getExcelTest() {

		ExcelReadWrite excelReadWrite = new ExcelReadWrite();

		excelReadWrite.writeexcel();
		String result = excelReadWrite.readexcel();

		chromeDriver.navigate().back();
		chromeDriver.navigate().refresh();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.close();
		chromeDriver.quit();
		Assert.assertEquals(result, "Success");

	}

	@Test
	public void firefoxTileTest() {
		// TODO Auto-generated method stub

		Property property = new Property();
		GooglePage searchResult = new GooglePage();
		String expectedTitle = null;
		String weburl = null;
		String searchText = null;

		try {
			expectedTitle = property.readPropertiesFile("ExpectedTitle");
			weburl = property.readPropertiesFile("WebUrl");
			searchText = property.readPropertiesFile("SearchText");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualTitle = searchResult.getSearchResults(firefoxDriver, weburl, searchText);
		firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void firefoxGetScreenshotTest() {

		try {
			ScreenShot sc = new ScreenShot();
			sc.getScreenShot(firefoxDriver);
			firefoxDriver.navigate().back();
			firefoxDriver.navigate().refresh();
			firefoxDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			firefoxDriver.close();
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

}
