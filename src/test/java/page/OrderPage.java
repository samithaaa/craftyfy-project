package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public OrderPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public WebElement isOrderpageLoaded()
	{
		WebElement myorder= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'MY') and .//span[text()='ORDERS']]")));
		return myorder;
	}
	
	public WebElement orderPlaced()
	{
		WebElement placed= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Order Placed']")));
		return placed;
	}
	public void trackOrder()
	{
		WebElement track=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Track Order'])[1]")));
		track.click();
		wait.until(ExpectedConditions.urlContains("track"));
	}

}
