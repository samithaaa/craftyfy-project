package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import page.AutomationConstants;
import page.HeaderPage;
import page.LoginPage;
import utility.ExcelUtility;

@Listeners(listeners.ScreenshotListener.class)
public class LoginTest extends TestBase {
	
	
	LoginPage lpg;
	HeaderPage hdp;
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void objinit()
	{
		lpg=new LoginPage(driver);
		hdp=new HeaderPage(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	@Test(priority=1)
	public void validCred() throws IOException
	{	
		hdp.userIcon();
		lpg.setEmail(ExcelUtility.readExcel(0,0));
		lpg.setPassword(ExcelUtility.readExcel(0,1));
		lpg.setLogin();

		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/login"))); //waits until redirect 

		System.out.println("CURRENT URL: " + driver.getCurrentUrl()); 

		JavascriptExecutor js= (JavascriptExecutor) driver;
		String token= (String)js.executeScript("return window.localStorage.getItem('token')");
		Assert.assertNotNull(token);  //Assert login by checking if the local storage contains a token
		
	}
	@Test(priority=2)
	public void homeLogout()
	{	hdp.userIcon();
		lpg.homeLogout();
	}
	@Test(priority=3)
	public void collectionLogout() throws InterruptedException
	{
		hdp.LogOut();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
	}
	
	@Test (priority=4)
	public void forgotPassword()
	{	
		String loginUrl = driver.getCurrentUrl();
		WebElement forgot=lpg.forgetPass();
		Assert.assertTrue(forgot.isDisplayed(), "Forgot password not visible"); 
		Assert.assertTrue( wait.until(d -> !d.getCurrentUrl().equals(loginUrl))); //wait until forgot password redirects to another page	
	}	
	
	@Test(priority=5)
	 public void invalidCredentials() throws IOException
	{	hdp.userIcon();
		lpg.setEmail(ExcelUtility.readExcel(1,0));
		lpg.setPassword(ExcelUtility.readExcel(1,1));
		lpg.setLogin();
		
		String invalid_toast= lpg.invalidCred();
		Assert.assertEquals(invalid_toast, AutomationConstants.actualInvalid); //check whether invalid credentials toast is displayed
	}

	@Test(priority=6)
	public void unregisteredUser() throws IOException, InterruptedException
	{  
		lpg.overLay();
	    Thread.sleep(1000);
		hdp.userIcon();
		lpg.setEmail(ExcelUtility.readExcel(2,0));
		lpg.setPassword(ExcelUtility.readExcel(2,1));
		lpg.setLogin();
		
		String unreg_toast = lpg.unregUser();
		Assert.assertEquals(unreg_toast, AutomationConstants.actualUnreg); //Assert whether user dont exist toast is displayed
		
	}
	
	@Test(priority=7)
	public void emptyLogin() throws IOException, InterruptedException
	{
		lpg.overLay();
		hdp.userIcon();
		lpg.setLogin();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(),AutomationConstants.loginPageURL);
		
		
	}

}
