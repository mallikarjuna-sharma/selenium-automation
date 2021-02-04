package testobjectrepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	public String getSearchResults(WebDriver driver,String weburl,String searchText) {
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(weburl);

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(searchText, Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"result-stats\"]")));
		
		String actualTitle = driver.getTitle();
		return actualTitle;
		
	}

}
