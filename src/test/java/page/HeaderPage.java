package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

public class HeaderPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}
	
	public void userIcon()
	{
		WebElement user=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.group img.w-5.cursor-pointer")));
		user.click();
	}
	
	public void LogOut()
	{
		WebElement clct = driver.findElement(By.xpath("//a[contains(text(),'COLLECTION')]"));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clct);
		
		userIcon();
		WebElement lgot=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Logout']")));
		lgot.click();

	}
	
	public void clickCart() {
		WebElement cart= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/cart']")));
		Actions actions = new Actions(driver);
	    actions.moveToElement(cart).click().perform();
	}
	
	public void clickCol()
	{
		
		WebElement coll=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/collection']")));
		coll.click();
//		WebElement clct = driver.findElement(By.xpath("//a[contains(text(),'COLLECTION')]"));
//
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", clct);
	}
	
	public void searchIcon()
	{
		WebElement search=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'items-center')]/img)[1]")));
		search.click();
	}
	
	public void clickAbout()
	{
		WebElement abt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/about']")));
		abt.click();
	}
	
	public void clickContact()
	{
		WebElement cont=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/contact']")));
		cont.click();
	}
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	

	}
	
	public void subscribe(String mail) {
		WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
		sub.sendKeys(mail);
		
	}
	
	public WebElement emailSub() {
		WebElement sub=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
		return sub;
		
	}
	
	public void clickSub()
	{
		WebElement clk=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SUBMIT']")));
		clk.click();
	}

}
