package frameWorkClasses;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	// Declare the WebDriver
	public static WebDriver driver;

	// Constructor of the Base Class - Check if our Driver has been started
	public BasePage() {
		if (driver == null) {
			// Set Parameter values
			String browser = getDataConfigProperties("browser");
			String URL = getDataConfigProperties("URL");
		    //	String pdriverDir = getDataConfigProperties("pdriverDir");
			// String browser = "chrome";
			// String URL = "https://www.takealot.com/";
			// String pdriverDir = "/Users/dianaleca/Applications/";

			// Verify parameter passed as "chrome"
			if (browser.equalsIgnoreCase("chrome")) {
		
				WebDriverManager.chromedriver().setup();
				// Set path to chromedriver.exe
				// System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver");
				// create an instance of chrome
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}

			// String pdriverDirFireFox = getDataConfirgPropeties("driverdirFirefox");
			else if (browser.equalsIgnoreCase("firefox")) {
				
			WebDriverManager.firefoxdriver().setup();
				// Set path to geckodriver.exe
			    // System.setProperty("webdriver.gecko.driver", pdriverDir + "geckodriver.exe");
				// create an instance of firefox
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}

				// System.setProperty("webdriver.edge.driver",pdriverDir+"MicrosoftWebDriver.exe");
			else if (browser.equalsIgnoreCase("edge")) {
				// Set path to MicrosoftWebDriver.exe
				
			   WebDriverManager.edgedriver().setup();
			    //	System.setProperty("webdriver.edge.driver", pdriverDir + "MicrosoftWebDriver.exe");
				// create an instance of edge
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
				}
				}

	// METHOD: Read the Config
	public String getDataConfigProperties(String proprtyName) {
		// Properties set
		// System.out.println("In Config");
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
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
	
	public String readPDFContent(String appUrl, int expectedNoPages) throws Exception {
		URL url = new URL (appUrl);
		InputStream input = url.openStream();
		BufferedInputStream fileToParse = new BufferedInputStream(input);
		PDDocument document = null;
		String output = null;
		
		try {
			document = PDDocument.load(fileToParse);
			output = new PDFTextStripper().getText(document);
			// ensure the number of pages is correct
			int numberOfPages = getPageCount(document);
			Assert.assertEquals(numberOfPages, expectedNoPages);
			
		} finally {
			if (document != null) {
				document.close();
			}
			fileToParse.close();
			input.close();
		}
		return output;
	}
	
	public int getPageCount(PDDocument doc) {
		// get total number of pages in the PDF document
		int pageCount = doc.getNumberOfPages();
		return pageCount;
	}

	// METHOD: Get current URL
	public String getURL() {
		String getCurrentURL = driver.getCurrentUrl();
		return getCurrentURL;
	}
	
	// METHOD: Wait for URL
	public void waitForUrl(int elementWait, String urlContains) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(urlContains));
		}

	// METHOD: Wait for Click
	public void waitforClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
		}

	// METHOD: Wait to Disappear
	public void waitToDisappear(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(pLocator));
	}
	
	// METHOD: Wait for Element
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
		}

	// METHOD: Verify Element exists
	public boolean elementExists(By pLocator) {
		boolean display = getElement(pLocator).isDisplayed();
		return display;
		}
	
	// METHOD: Get Element
	public WebElement getElement(By pLocator) {
		waitforClick(30, pLocator);
		return driver.findElement(pLocator);
		}

	// METHOD: Get Element Text
	public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
//		System.out.println(elementText);
		return elementText;
		}

	// METHOD: Click an Element
	public void clickElement(By pLocator) {
		waitforClick(30, pLocator);
		getElement(pLocator).click();
		}
	
	// METHOD: Get Title
	public String getTitle() {
		String getTitle = driver.getTitle();
	//	System.out.println(elementText);
		return getTitle;
		}

	// METHOD: Enter text in Field
	public void enterText(By pLocator, String enterText) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).sendKeys(enterText);
		}
	
	// METHOD: Clear text from field
	public void clearText(By pLocator) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).clear();
		}

	// METHOD: Select from drop-down
	public void selectDropDown(By pLocator, String pValue) {
		waitForElement(200, pLocator);
		// Create an instance of the drop down object
		Select selDrpDwn = new Select(getElement(pLocator));
		// Populate the DropDown
		selDrpDwn.selectByVisibleText(pValue);
		}
	
	// METHOD: Switch Window
	public void switchToNewTab() {
		Set<String> handles = driver.getWindowHandles();
		// Selenium will check how many windows are currently open.
		// This will store the ID for both parent and child window
		Iterator<String> it = handles.iterator();
		// Using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		// Switch to new window by passing the ID of the child window
		driver.switchTo().window(childWindowID);
		}

	// METHOD: Switch to Parent
	public void switchToParent() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		// Switch to new window by passing the ID of the parent window
		driver.switchTo().window(parentWindowID);
		}

	// METHOD: Close Child Browser
	public void closeChildBrowserTab() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		driver.close();
		driver.switchTo().window(parentWindowID);
		driver.close();
		}
	
	// METHOD: Clean up i.e. Clear Cart
	public void cleanUp() {
		WebElement checkbox = driver.findElement(By.name("removefromcart"));
		checkbox.click();
		driver.findElement(By.cssSelector("input[name='updatecart']")).click();
		}
	
	// METHOD: Clean up i.e. Close the Driver
		public void closeBrowser() {
		//	driver.close(); //closes current window only
		driver.quit();  // closes all windows
		}
		
		

}
