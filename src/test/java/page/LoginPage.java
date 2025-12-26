package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}
	
	
	public void setEmail(String email)  //entering email
	{
		WebElement mail= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email' and @placeholder='Email']")));
		mail.clear();
		mail.sendKeys(email);
	}
	
	public void setPassword(String pass)	//entering password
	{
		WebElement passw=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password' and @placeholder='Password']")));
		passw.clear();
		passw.sendKeys(pass);
	}
	
	public void setLogin()	//clicking login button
	{
		WebElement logbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")));
		logbtn.click();
	}
	
	public void login(String email, String password) {
	    setEmail(email);
	    setPassword(password);
	    setLogin();
	}
		
	public WebElement forgetPass()  //Clicking forget password link
	{
		WebElement forget=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Forgot your password?']")));
		forget.click();
		return forget;
	}
	
	public String invalidCred()		//checking for invalid credentials message displayed
	{
		WebElement invalid_cred= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invalid credentials')]")));
		String msg=invalid_cred.getText();
		return msg;
	}
	
	public String unregUser()	//checking for user dont exist message displayed
	{
		WebElement not_exist= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert' and contains(.,\"User doesn't exists\")]")));
		String text=not_exist.getText();
		return text;
	}
	
	public void overLay() //to wait till toast disappear
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader, .overlay"))); //wait until overlay disappears

	}
	
	public void homeLogout()	//clicking logout button from home page
	{
		WebElement lgot=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Logout']")));
		lgot.click();
	}
	
	public void createAcc()		//clicking Create Account button
	{
		WebElement create=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Create account']")));
		create.click();
	}
}
