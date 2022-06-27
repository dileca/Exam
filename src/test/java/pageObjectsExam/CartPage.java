package pageObjectsExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage {

		// METHOD: Update Quantity
			public void updateQuantity(String quant) throws InterruptedException  {
			driver.findElement(By.cssSelector(".qty-input")).clear();	
			driver.findElement(By.cssSelector(".qty-input")).sendKeys(quant);
			driver.findElement(By.cssSelector("input[name='updatecart']")).click();
			}
	
		// METHOD: Check Cart Count
			public boolean checkCartCount(String checkCount) throws InterruptedException {
				Thread.sleep(2000);
					String itemElement = ".cart-qty";
					System.out.println(getElementText(By.cssSelector(itemElement)));
					System.out.println(checkCount);
				if (getElementText(By.cssSelector(itemElement)).contains(checkCount)) {
					Reporter.log("Amount Correct " + checkCount);
					Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
					return true;
					}
				Reporter.log("Amount inCorrect " + checkCount);
				Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
				return false;
				}
		
		// METHOD: Remove Item from Shopping Cart
			public void removeItemFromShoppingCart() throws InterruptedException {
			WebElement checkbox = driver.findElement(By.name("removefromcart"));
			checkbox.click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[name='updatecart']")).click();
			WebElement emptyCartMessage = driver.findElement(By.cssSelector(".order-summary-content"));
			System.out.println(emptyCartMessage.getText());
			}	
				
		// METHOD: Verify Empty Cart Message
			public boolean verifyEmptyCartMessage() {
			String itemElement = ".order-summary-content";
			if (driver.findElements(By.cssSelector(itemElement)).size() != 0) {
				System.out.println("Element exists");
				Reporter.log("Element exists " +itemElement);
				Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
				return true;
			} else {
				System.out.println("Element doesn't exist");
				Reporter.log("Element does not exist " +itemElement);
				Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
				}		
			}
	
			// METHOD: Select Country Drop Down			
				public void selectCountryDropDown(String country) {
				Select select = new Select(driver.findElement(By.cssSelector("select#CountryId")));
				select.selectByVisibleText("United States");			
				}
	
			// METHOD: Select State Drop Down			
				public void selectStateDropDown(String state) {
				Select select = new Select(driver.findElement(By.cssSelector("select#StateProvinceId")));
				select.selectByVisibleText("Massachusetts");			
				}
		
			// METHOD: Populate Zip Code
				public void populateZipCode(int zip) {
				driver.findElement(By.cssSelector("[name='ZipPostalCode']")).sendKeys("02116");
				}	
	
			// METHOD: Estimate Shipping
				public void estimateShipping() {
				driver.findElement(By.cssSelector("[class='button-2 estimate-shipping-button']")).click();
				}
	
			// METHOD: Verify Shipping Results
				public void verifyShippingResults() {
				driver. findElement(By.cssSelector(".shipping-results")).isDisplayed();
				}
			
			// METHOD: Return Estimate Shipping
				public void returnEstimateShippingMessage() {
				WebElement shipMessage = driver.findElement(By.cssSelector(".shipping-results .shipping-option-item:nth-of-type(1) .option-description"));
				System.out.println(shipMessage.getText());
				}
				
			// METHOD: Get Unit Price
				public int getUnitPrice() {
					String unitPriceString = getElementText(By.cssSelector(".actual-price.price"));
						String unitPrice = unitPriceString.substring(0, 3);
						int unitPriceInt = Integer.parseInt(unitPrice);
						return unitPriceInt;	
						}
				

				
				
}
