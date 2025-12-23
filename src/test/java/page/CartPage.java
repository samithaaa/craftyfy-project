package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
		
	}
	
	public WebElement getQty()
	{
		WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
		return qty;
	}
	public void increaseQty()
    {    
		WebElement qty=getQty();
		qty.click();
		qty.sendKeys(Keys.ARROW_UP); //increase quantity through keyboard action
	}
	public void decreaseQty()
	{
		WebElement qty=getQty();
		qty.sendKeys(Keys.ARROW_DOWN); 
		
	}
	public int getValue()
	{
		return Integer.parseInt(getQty().getAttribute("value"));
	}
	
	public void removeItem()
	{
		WebElement remove= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=' Heart Shaped Wall Hanging Photo Frame ']/ancestor::div//input[@type='number']/following-sibling::img")));
		remove.click();
	}
	
	
	public void proceedCheckout()
	{
		WebElement checkout=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")));
		checkout.click();
	}
}
