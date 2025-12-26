package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(15));
		}
	
	public void enterName(String name)
	{
		WebElement nam=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Name'][type='text']")));
		nam.sendKeys(name);
	}
	
	public void enterEmail(String mail)
	{
		WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email']")));
		email.sendKeys(mail);
	}
	
	public void enterPass(String pwd)
	{
		WebElement pass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
		pass.sendKeys(pwd);
	}
	
	public WebElement signUp() //sign up account with new email and password
	{
		WebElement sign=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign Up']")));
		sign.click();
		return sign;
	}
}
