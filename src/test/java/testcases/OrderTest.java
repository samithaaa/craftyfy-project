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
import page.CartPage;
import page.CheckoutPage;
import page.HeaderPage;
import page.LoginPage;
import page.OrderPage;
import page.ProductPage;

@Listeners(listeners.ScreenshotListener.class)
public class OrderTest extends TestBase{
	
	WebDriverWait wait;
	
	LoginPage lpg;
	HeaderPage hdp;
	CartPage cpg;
	CheckoutPage ckt;
	OrderPage ord;
	ProductPage pdp;
	
	@BeforeClass
	public void beforeCheckout() throws InterruptedException
	{
		lpg=new LoginPage(driver);
		hdp=new HeaderPage(driver);
		pdp=new ProductPage(driver);
		cpg=new CartPage(driver);
		ckt=new CheckoutPage(driver);
		ord=new OrderPage(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		hdp.userIcon();
		lpg.setEmail("amna@gmail.com");
		lpg.setPassword("Ammu@2003");
		lpg.setLogin();
		Thread.sleep(1000);
	}
	@BeforeMethod
	public void beforeDeliveryInfo() //adding product to cart and checkout
	{
		hdp.clickCol();
		pdp.selectProd();
		pdp.selectColor();
		pdp.addtoCart();
		hdp.clickCart();
		cpg.proceedCheckout();
		
	}
	
	@Test(priority=1)
	public void placingOrder()
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
		WebElement placed=ord.orderPlaced();
		Assert.assertTrue(placed.isDisplayed());
	}
	
	@Test(priority=2)
	public void checkTrackorder()
	{
		ord.trackOrder();
		Assert.assertTrue(driver.getCurrentUrl().contains("track"));
	}
	
	@Test(priority=3)
	public void onlinePayment()
    {
		ckt.setName("Amna","A");
		ckt.enterEmail("amna@gmail.com");
		ckt.setStreet("Pattom");
		ckt.setLocation("Tvm","Kerala");
		ckt.setZipcode("345678");
		ckt.setCountry("India");
		ckt.setPhone("8888888888");
		ckt.setOnlinePay();
		
    }
}
