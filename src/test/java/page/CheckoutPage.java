package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	public void setName(String fname,String lname)	//delivery information 
	{
		WebElement first=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstName'][placeholder='First name']")));
		first.clear();
		first.sendKeys(fname);
		WebElement last=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lastName'][placeholder='Last name']")));
		last.clear();
		last.sendKeys(lname);
	}
	
	public void enterEmail(String mail)
	{
		WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email'][placeholder='Email address']")));
		email.sendKeys(mail);
	}
	
	public void setStreet(String strt)
	{
		WebElement str=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='street'][placeholder='Street']")));
		str.sendKeys(strt);
	}
	
	public void setLocation(String cty,String ste)
	{
		WebElement city=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("city")));
		city.sendKeys(cty);
		WebElement state=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("state")));
		state.sendKeys(ste);
	}
	public void setZipcode(String zip)
	{
		WebElement code=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("zipcode")));
		code.sendKeys(zip);
	}
	
	public void setCountry(String cntr)
	{
		WebElement country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("country")));
		country.sendKeys(cntr);
	}
	
	public void setPhone(String phone)
	{
		WebElement phoneno=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
		phoneno.sendKeys(phone);
	}
	
	public void setCOD()
	{
		WebElement cod=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='CASH ON DELIVERY']")));
		cod.click();
	}
	
	public void setOnlinePay()
	{
		WebElement online=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'razorpay')]")));
		online.click();
	}
	public void placeOrder()
	{
		WebElement order=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and normalize-space()='PLACE ORDER']")));
		order.click();
	}

}
