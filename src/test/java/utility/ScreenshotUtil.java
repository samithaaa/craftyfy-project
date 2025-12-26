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
	            // Convert WebDriver object to TakesScreenshot interface
	            
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            // Capture screenshot as a temporary file
	            
	            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")); //to generate timestamp of screenshot
	            // Generate current timestamp
	            
	            String path = "C:\\Users\\Samitha Fathima\\OneDrive\\Pictures\\Desktop\\SDET\\Craftyfy\\CraftyfyProject\\target\\screenshots\\" + testName +"_" + timestamp  + ".png"; //save in screenshots folder
	            File dest = new File(path);

	            FileUtils.copyFile(src, dest);
	            // Copy screenshot from source to destination
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



