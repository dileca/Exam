package pageObjectsExam;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class BasePageExam extends BasePage {
	
		// METHOD; Navigate to Home Page
			public void navigateToHomePage() {
			driver.get("http://demowebshop.tricentis.com/");
			waitForUrl(30, "tricentis");
			}
	
		// METHOD: Go to Cart Page
			public void navigateToShoppingCartPage() {
			driver.get("http://demowebshop.tricentis.com/cart");
			waitForUrl(30, "cart");
			}
		
		//METHOD: Click Search Input Box
			public void clickSearchBar() {
			clickElement(By.cssSelector("input#small-searchterms"));	
			}
		
		// METHOD: Enter text in Search bar
			public void enterTextInSearchBar(String enterTextInSearchBar) {
			enterText(By.id("small-searchterms"), enterTextInSearchBar);	
			}
				
		// METHOD: Click Search Button	
			public void clickSearchButton() {
			clickElement(By.cssSelector("form[method='get'] > .button-1.search-box-button"));
			}
		
	
}
