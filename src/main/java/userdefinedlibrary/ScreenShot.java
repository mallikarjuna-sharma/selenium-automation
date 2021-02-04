package userdefinedlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//TAKING THE SCREEENSHOT

public class ScreenShot {
	public void getScreenShot(WebDriver driver) {
		// TODO Auto-generated method stub
		String filename;
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		filename = String.valueOf(new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date()));
		File destination = new File(System.getProperty("user.dir") + "/Screenshots/" + filename);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
