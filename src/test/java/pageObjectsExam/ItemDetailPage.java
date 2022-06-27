package pageObjectsExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import frameWorkClasses.BasePage;

public class ItemDetailPage extends BasePage {

		// METHOD: Verify Element Text Item
			public String verifyElementText() {
			String text1 = getElementText(By.cssSelector("h1"));
			return text1;
			}	
	
		// METHOD: Select Material Drop Down			
			public void selectMaterialDropDown(String material) {
			Select select = new Select(driver.findElement(By.name("product_attribute_71_9_15")));
			select.selectByValue("47");			
			}
			
		// METHOD: Select Manufacturer Drop Down			
			public void selectManufacturerDropDown(String manufacturer) {
			Select select = new Select(driver.findElement(By.name("product_attribute_80_2_37")));
			select.selectByValue("113");			
			}
			
		// METHOD: Select Color Drop Down
			public void selectColorDropDown(String color) {
			Select select = new Select(driver.findElement(By.name("product_attribute_80_1_38")));
			select.selectByValue("117");			
			}
			
		// METHOD: Populate Length in CM textbox
			public void enterLengthInCM(int length) {
			driver.findElement(By.cssSelector(".textbox")).sendKeys("30");
			}
			
		// METHOD: Select Pendant type radio button
			public void selectPendantTypeRadioButton(String pendantStyle) {
			WebElement radio3 = driver.findElement(By.cssSelector(".option-list li:nth-of-type(3) [type]"));
			radio3.click();	
			}
			
		// METHOD: Add to Cart
			public void addItemToCart() throws InterruptedException {
			Thread.sleep(2000);	
			clickElement(By.cssSelector("input[value='Add to cart']"));
			}	
					
		// METHOD: Close Success Notification	
			public void closeSuccessNotification() {
			driver.findElement(By.cssSelector("div#bar-notification")).click();
			WebElement shipMessage = driver.findElement(By.cssSelector("div#bar-notification > .content"));
			System.out.println(shipMessage.getText());
			}
			
		// METHOD: Get Unit Price
			public int getUnitPrice() {	
				String unitPriceString = getElementText(By.cssSelector(".actual-price.price"));
					String unitPrice = unitPriceString.substring(0, 3);
					int unitPriceInt = Integer.parseInt(unitPrice);
					return unitPriceInt;	
					}
			
		// METHOD: Add To Compare List
			public void selectAddToCompareList() {
			clickElement(By.cssSelector("input[value='Add to compare list']"));
			}
			
		
}
