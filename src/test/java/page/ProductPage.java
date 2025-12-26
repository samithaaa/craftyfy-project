package page;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	WebDriver driver;
	WebDriverWait wait;

	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}

	public WebElement selectCategory()	//checking whether Category is working
	{
		WebElement cat=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @value='Stationery']")));
		cat.click();
		return cat;
	}
	public WebElement sortBy() //checking whether sortby option is working
	{
		WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='low-high']")));
		sort.click();
		return sort;
	}
	public WebElement selectType()
	{
		WebElement type=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @value='WallHangings']")));
		type.click();
		return type;
		
	}
	public void selectProd()
	{
		WebElement prod=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Heart Shaped Wall Hanging Photo Frame']")));
		prod.click();
	}
	
	public void selectColor()
	{
		WebElement color=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Red']")));
		color.click();
	}
	
	public WebElement addtoCart() //Adding product to cart
	{
		WebElement add_prod=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='ADD TO CART']")));
		add_prod.click();
		return add_prod;
	}
	
	public int getCartcount()
	{
		 WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/cart']//p")));
		 return Integer.parseInt(badge.getText().trim());
	}
	
	public WebElement search()
	{
		WebElement searchbar=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Search'][type='text']")));
		return searchbar;
	}
	
	public void searchProduct(String pro)
	{
		search().sendKeys(pro);
	}
}
