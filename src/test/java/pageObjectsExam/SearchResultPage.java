package pageObjectsExam;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SearchResultPage extends BasePage {

	
		// METHOD: Click Element Text of First Item
			public void clickElementTextOfFirstItem() {
			clickElement(By.cssSelector("div:nth-of-type(1) > .product-item  h2 > a"));
			}
	
		// METHOD: Click Element Text of Second Item
			public void clickElementTextOfSecondItem() {
			clickElement(By.cssSelector("div:nth-of-type(2) > .product-item  h2 > a"));
			}
			
}
