package testcases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import page.ContactPage;
import page.HeaderPage;
import page.LoginPage;

@Listeners(listeners.ScreenshotListener.class)
public class ContactTest extends TestBase{
	

	WebDriverWait wait;
	ContactPage cnt;
	HeaderPage hdp;
	LoginPage lpg;
	
	
	@BeforeClass
	public void objectint()
	{  
		lpg=new LoginPage(driver);
		cnt=new ContactPage(driver);
	    hdp=new HeaderPage(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		hdp.userIcon();
		lpg.login("amna@gmail.com","Ammu@2003");
	}
	
	@Test
	public void tc501()
	{   hdp.clickContact();
	    cnt.exploreJobs();
	    Assert.assertTrue(driver.getCurrentUrl().contains("jobs"));
	
	}

	@Test
	public void tc502()
	{
		hdp.subscribe("abc@gmail.com");
		WebElement mail=hdp.emailSub();
		Assert.assertTrue(mail.getText().contains("abc@gmail.com"));
	}

}
