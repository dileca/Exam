package pageObjectsExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class CategoryPage extends BasePage {

		// METHOD: Click Element Text of First Item
	   		public void clickElementTextOfFirstItem() {
	   		clickElement(By.cssSelector("div:nth-of-type(1) > .product-item  h2 > a"));
	   		}	
	
	   	// METHOD: Click Element Text of Third Item
	   		public void clickElementTextOfThirdItem() {
	   		clickElement(By.cssSelector("div:nth-of-type(3) > .product-item  h2 > a"));
	   		}	   		
	   		
		// METHOD: Click Element Text of Third Item
	   		public void clickElementTextOfFourthItem() {
	   		clickElement(By.cssSelector("div:nth-of-type(4) > .product-item  h2 > a"));
	   		}		
}
