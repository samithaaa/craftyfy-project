package testcases;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import page.HeaderPage;
import page.LoginPage;
import page.ProductPage;

@Listeners(listeners.ScreenshotListener.class)

public class ProductTest extends TestBase
{
	
	WebDriverWait wait;
	LoginPage lpg;
	HeaderPage hdp;
	ProductPage pdp;
	@BeforeClass
    public void objinit() {
        lpg= new LoginPage(driver);
        hdp=new HeaderPage(driver);
        pdp=new ProductPage(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        hdp.userIcon();
        lpg.login("amna@gmail.com", "Ammu@2003");
    }
	

	@Test
	public void tc101()
	{
		
		hdp.clickCol();
		
		WebElement category=pdp.selectCategory();
		Assert.assertTrue(category.isSelected());
	}
	
	@Test
	public void tc102()
	{
		WebElement sort_opt = pdp.sortBy();
		Assert.assertTrue(sort_opt.isSelected());
	}
	
	@Test
	public void tc103()
	{
		WebElement filtertype=pdp.selectType();
		Assert.assertTrue(filtertype.isSelected());
	}
	
	@Test
	public void tc104()
	{
		pdp.selectProd();
		pdp.selectColor();
		int initial=pdp.getCartcount();
		WebElement add= pdp.addtoCart();
		String added=add.getText();
		int after=pdp.getCartcount();
		Assert.assertEquals(after,initial+1,"Cart badge count did not increase by 1 after adding product");
		Assert.assertTrue(added.contains("Added"));
		
	}
	
	@Test
	public void tc105()
	{
		hdp.searchIcon();
		pdp.search();
		pdp.searchProduct("Heart"); //Product search
	}
	
}
