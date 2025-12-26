package testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import page.HeaderPage;
import page.LoginPage;
import page.ProductPage;
import page.RegistrationPage;

public class RegisterTest extends TestBase {

	WebDriverWait wait;
	LoginPage lpg;
	HeaderPage hdp;
	RegistrationPage rp;
	@BeforeClass
	public void objectint()
	{   
		hdp=new HeaderPage(driver);
		rp=new RegistrationPage(driver);
		lpg=new LoginPage(driver);
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		hdp.userIcon();
		
	}
	
	@Test(priority=1)
	public void validReg() throws InterruptedException
	{
		lpg.createAcc();
		rp.enterName("Siya");
		rp.enterEmail("siyaaaiii@gmail.com");
		rp.enterPass("Siyaaaa#123");
		rp.signUp();

		
	}
	@Test(priority=2)
	public void invalidReg()
	{	hdp.userIcon();
		lpg.createAcc();
		WebElement btn=rp.signUp();
		Assert.assertFalse(btn.isEnabled(), "sign up should be disabled for empty credentials");
		
		
	}

	
}
