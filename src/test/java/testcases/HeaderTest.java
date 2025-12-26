package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import page.HeaderPage;
import page.ProductPage;

public class HeaderTest extends TestBase{
	
	WebDriverWait wait;
	HeaderPage hdp;
	ProductPage pdp;
	
	@BeforeClass
	public void objectint()
	{   pdp=new ProductPage(driver);
		hdp=new HeaderPage(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	public void checkSearch()
	{
		hdp.searchIcon();
		Assert.assertTrue(pdp.search().isDisplayed());
	}

	@Test(priority=2)
	public void checkAbout() throws InterruptedException
	{
		hdp.clickAbout();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("about"));
	}
	
	@Test(priority=3)
	public void checkContact() throws InterruptedException
	{
		hdp.clickContact();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("contact"));
	}
	
	
	

	
}
