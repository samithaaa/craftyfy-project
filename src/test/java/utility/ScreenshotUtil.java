	package utility;
	
	import org.openqa.selenium.*;
	import java.io.File;
	import org.apache.commons.io.FileUtils;

	public class ScreenshotUtil {

	    public static void takeScreenshot(WebDriver driver, String testName) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);

	            String path = "C:\\Users\\Samitha Fathima\\OneDrive\\Pictures\\Desktop\\SDET\\Craftyfy\\CraftyfyProject\\target\\screenshots\\" + testName + ".png";
	            File dest = new File(path);

	            FileUtils.copyFile(src, dest);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



