package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	@Test
	public void tc701() throws InterruptedException
	{
		lpg.createAcc();
		rp.enterName("Siya");
		rp.enterEmail("siyaaaaan@gmail.com");
		rp.enterPass("Siyaaaa#123");
		rp.signUp();

		
	}
	@Test
	public void tc702()
	{	hdp.userIcon();
		lpg.createAcc();
		rp.signUp();
	}

	
}
