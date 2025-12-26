
	
	package listeners;

	import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
	import org.testng.ITestResult;
	
import base.TestBase;
import utility.ScreenshotUtil;

	public class ScreenshotListener extends TestBase implements ITestListener {

	    @Override
	    public void onTestFailure(ITestResult result) //this method automatically triggered automatically by TestNG whenever test fails
	    {
	    	WebDriver driver=getDriver();
	        ScreenshotUtil.takeScreenshot(driver,result.getName());	//Capture screenshot and name it using the failed test method name
	    }
	}



