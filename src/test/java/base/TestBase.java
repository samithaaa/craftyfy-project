package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	protected static WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	
	public WebDriver getDriver() {
	  return driver;
	}
	
	
	public void readProp() throws IOException  //read config.properties file
	{
		FileReader fle=new FileReader("C:\\Users\\Samitha Fathima\\OneDrive\\Pictures\\Desktop\\SDET\\Craftyfy\\CraftyfyProject\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(fle);
	}
	
	@BeforeClass
	public void setUp() throws IOException
	{
		readProp();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
