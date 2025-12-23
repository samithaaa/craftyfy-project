package testcases;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import page.CartPage;
import page.HeaderPage;
import page.LoginPage;
import page.ProductPage;
@Listeners(listeners.ScreenshotListener.class)
public class CartTest extends TestBase {
	
	WebDriverWait wait;
	
	LoginPage lpg;
	ProductPage pdp;
	HeaderPage hdp;
	CartPage cpg;
	
	@BeforeClass
	public void beforeCart() {
        lpg= new LoginPage(driver);
        hdp=new HeaderPage(driver);
        pdp=new ProductPage(driver);
        cpg=new CartPage(driver);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        hdp.userIcon();
        lpg.login("amna@gmail.com", "Ammu@2003");
        hdp.clickCart();
    }
	
	@Test
	public void tc301()
	{
		String cartUrl = driver.getCurrentUrl();
		Assert.assertTrue(cartUrl.contains("cart"));
	}
	
	@Test
	public void tc302()
	{
		int initial=cpg.getValue();
		cpg.increaseQty();
		int increase =cpg.getValue();
		Assert.assertEquals(increase, initial+1,"Quantity did not increase by 1");
	}
	
	@Test
	public void tc303()
	{
		int initial=cpg.getValue();
		cpg.decreaseQty();
		int decrease =cpg.getValue();
		Assert.assertEquals(decrease, initial-1,"Quantity did not decrease by 1");
	}
	
	@Test
	public void tc304()
	{	
		By product = By.xpath("//p[normalize-space()='Heart Shaped Wall Hanging Photo Frame']");
		cpg.removeItem();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(product));//check if the product disappears
		Assert.assertTrue(driver.findElements(product).isEmpty());
	}
	
	@Test
	public void tc305()
	{
		hdp.clickCol();
		pdp.selectProd();
		pdp.selectColor();
		pdp.addtoCart();
		hdp.clickCart();
		cpg.proceedCheckout();
		Assert.assertTrue(driver.getCurrentUrl().contains("/place-order"),"Did not navigate to Checkout page");
	}
	

}
