package pageObjectsExam;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {

		// METHOD: Select Apparel $ Shoes via Category Header Menu
		public void selectApparelandShoesViaCategoryHearderMenu() {
			clickElement(By.cssSelector(".top-menu > li:nth-of-type(4) > a"));	
			}

		// METHOD: Select Jewelry via Category List
		public void selectJeweleryViaCategoryList() {
			clickElement(By.cssSelector(".list > li:nth-of-type(6) > a"));			
			}

		// METHOD: Select Computers via Category List
		public void selectComputersViaCategoryList() {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/computers']"));			
			}

		// METHOD: Select Desktop via Computer Category List
		public void selectDesktopViaComputerCategoryList() {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/desktops']"));			
			}
	


}
	
	

