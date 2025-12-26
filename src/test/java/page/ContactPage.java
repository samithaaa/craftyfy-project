package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}
	public WebElement exploreJobs()	//click explore jobs button on contact page
	{
		WebElement explore=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Explore Jobs']")));
		explore.click();
		return explore;
	}
}
