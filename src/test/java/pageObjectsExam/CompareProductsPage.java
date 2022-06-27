package pageObjectsExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class CompareProductsPage extends BasePage {

		
		// METHOD: Clear List
			public void clearList() throws InterruptedException {
			driver.findElement(By.linkText("Clear list")).click();
			Thread.sleep(1000);
			WebElement clearMessage = driver.findElement(By.cssSelector("//body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']//div[@class='page-body']"));
			System.out.println(clearMessage.getText());
			}
					
		// METHOD: Return Unit Price of First Item		
			public int returnUnitPriceOfFirstItem() {		
				String unitPriceString = getElementText(By.cssSelector(".product-price > td:nth-of-type(2)"));
					String unitPrice = unitPriceString.substring(0, 3);
					int unitPriceInt = Integer.parseInt(unitPrice);
					return unitPriceInt;	
					}
			
		// METHOD: Return Unit Price of Second Item		
			public int returnUnitPriceOfSecondItem() {		
				String unitPriceString = getElementText(By.cssSelector(".product-price > td:nth-of-type(3)"));
					String unitPrice = unitPriceString.substring(0, 3);
					int unitPriceInt = Integer.parseInt(unitPrice);
					return unitPriceInt;	
					}
}
