	package utility;
	
	import org.openqa.selenium.*;
	import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

	public class ScreenshotUtil {

	    public static void takeScreenshot(WebDriver driver, String testName) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            
	            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")); //to generate timestamp of screenshot

	            String path = "C:\\Users\\Samitha Fathima\\OneDrive\\Pictures\\Desktop\\SDET\\Craftyfy\\CraftyfyProject\\target\\screenshots\\" + testName +"_" + timestamp  + ".png"; //save in screenshots folder
	            File dest = new File(path);

	            FileUtils.copyFile(src, dest);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



