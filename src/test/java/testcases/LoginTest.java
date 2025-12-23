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
	
	@Test
	public void tc001() throws IOException
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
	@Test
	public void tc002()
	{	hdp.userIcon();
		lpg.homeLogout();
	}
	@Test
	public void tc003() throws InterruptedException
	{
		hdp.LogOut();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
	}
	
	@Test 
	public void tc004()
	{	
		String loginUrl = driver.getCurrentUrl();
		WebElement forgot=lpg.forgetPass();
		Assert.assertTrue(forgot.isDisplayed(), "Forgot password not visible");
		Assert.assertTrue( wait.until(d -> !d.getCurrentUrl().equals(loginUrl)));	
	}	
	
	@Test
	 public void tc005() throws IOException
	{	hdp.userIcon();
		lpg.setEmail(ExcelUtility.readExcel(1,0));
		lpg.setPassword(ExcelUtility.readExcel(1,1));
		lpg.setLogin();
		
		String invalid_toast= lpg.invalidCred();
		Assert.assertEquals(invalid_toast, AutomationConstants.actualInvalid);
	}

	@Test
	public void tc006() throws IOException, InterruptedException
	{   lpg.overLay();
	Thread.sleep(1000);
		hdp.userIcon();
		lpg.setEmail(ExcelUtility.readExcel(2,0));
		lpg.setPassword(ExcelUtility.readExcel(2,1));
		lpg.setLogin();
		
		String unreg_toast = lpg.unregUser();
		Assert.assertEquals(unreg_toast, AutomationConstants.actualUnreg);
		
	}
	
	@Test
	public void tc007() throws IOException, InterruptedException
	{
		lpg.overLay();
		hdp.userIcon();
		lpg.setLogin();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(),AutomationConstants.loginPageURL);
		
		
	}

}
