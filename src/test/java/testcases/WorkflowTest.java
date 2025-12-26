package testcases;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import page.CartPage;
import page.CheckoutPage;
import page.HeaderPage;
import page.LoginPage;
import page.OrderPage;
import page.ProductPage;

public class WorkflowTest extends TestBase{
	
	WebDriverWait wait;
	
	LoginPage lpg;
    HeaderPage hdp;
    ProductPage pdp;
    CartPage cpg;
    CheckoutPage ckt;
    OrderPage ord;
    
    @BeforeClass
	public void objectint() throws InterruptedException
	{
	lpg=new LoginPage(driver);
	hdp=new HeaderPage(driver);
	pdp=new ProductPage(driver);
	cpg=new CartPage(driver);
	ckt=new CheckoutPage(driver);
	ord=new OrderPage(driver);
	wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	hdp.userIcon();
	lpg.login("amna@gmail.com", "Ammu@2003");
	Thread.sleep(1000);
	}
    
   
    @Test(priority=1)
    public void addingToCart()
    {
    	hdp.clickCol();
    	pdp.selectProd();
    	pdp.selectColor();
    	int initial=pdp.getCartcount();
		WebElement add= pdp.addtoCart();
		String added=add.getText();
		int after=pdp.getCartcount();
		Assert.assertEquals(after,initial+1,"Cart badge count did not increase by 1 after adding product");
		Assert.assertTrue(added.contains("Added"));
    	
    }
    
    @Test(priority=2)
    public void checkOut()
    {
    	hdp.clickCart();
    	cpg.increaseQty();
    	cpg.proceedCheckout();
    	Assert.assertTrue(driver.getCurrentUrl().contains("/place-order"),"Did not navigate to Checkout page");
	}
    
    @Test(priority=3)
    public void orderPlacing()
    {
    	ckt.setName("Amna","A");
		ckt.enterEmail("amna@gmail.com");
		ckt.setStreet("Pattom");
		ckt.setLocation("Tvm","Kerala");
		ckt.setZipcode("345678");
		ckt.setCountry("India");
		ckt.setPhone("8888888888");
		ckt.setCOD();
		ckt.placeOrder();
		WebElement order=ord.isOrderpageLoaded();
		Assert.assertTrue(order.isDisplayed());
    }
    
    @Test(priority=4)
    public void checkLogOut()
    {
    	hdp.LogOut();
    }
    
   
    
    
    
}
