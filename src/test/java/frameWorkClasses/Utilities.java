package frameWorkClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

public class Utilities extends BasePage {

	//METHOD: Creates a screenshot
		public void takeSnapShot(String fileWithPath) throws IOException {
			// Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			
			// Call get Screenshot as a method to create image file
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			//Move the image file to the new destination
			File destFile = new File("target//" +"surefire-reports-" + getAppConfigProperties("build.timestamp") +"//images" + fileWithPath);
			
			// Copy File
			FileUtils.copyFile(scrFile, destFile);
			
			// Update the PDF report with the screenshot
			Reporter.log("<a href = '" + destFile.getAbsolutePath() + "'> <img src = '" + destFile.getAbsolutePath() + 
					"' height = '200' width = '200'/> </a>");
			
		}
		
		//METHOD: Return the time now
		public String timeReturn() {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
					return dtf.format(now);
		}
		
		//METHOD: Get the properties value from the app properties
		public String getAppConfigProperties(String proprtyName) {
			Properties p = new Properties();
			InputStream is = null;
			try {
				is = new FileInputStream("./target/app.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				p.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return p.getProperty(proprtyName);
			}
		
			public void resetOutputFile(String OutputFileName) {
				try {
					FileWriter myObj = new FileWriter(OutputFileName, false);
				}
				catch (IOException e) {
					System.out.println("An error occured");
					e.printStackTrace();
				}
			}
		

	}
