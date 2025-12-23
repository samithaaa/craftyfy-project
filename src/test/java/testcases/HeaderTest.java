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
	
	@Test
	public void tc601()
	{
		hdp.searchIcon();
		Assert.assertTrue(pdp.search().isDisplayed());
	}

	@Test
	public void tc602() throws InterruptedException
	{
		hdp.clickAbout();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("about"));
	}
	
	@Test
	public void tc603() throws InterruptedException
	{
		hdp.clickContact();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("contact"));
	}
	
	
	

	
}
