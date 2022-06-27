package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWorkClasses.BasePage;
import frameWorkClasses.ReadExcel;
import pageObjectsExam.BasePageExam;
import pageObjectsExam.CartPage;
import pageObjectsExam.CategoryPage;
import pageObjectsExam.CompareProductsPage;
import pageObjectsExam.ItemDetailPage;
import pageObjectsExam.LandingPage;
import pageObjectsExam.SearchResultPage;


public class TestCasesExam extends BasePage{

	// INSTANTIATIONS
		BasePageExam basePG = new BasePageExam();
		CategoryPage catPG = new CategoryPage();
		CartPage cartPG = new CartPage();
		CompareProductsPage compPG = new CompareProductsPage();
		ItemDetailPage itemPG = new ItemDetailPage();
		LandingPage landPG = new LandingPage();
		SearchResultPage resultPG = new SearchResultPage();
		SoftAssert softAssert = new SoftAssert();
		ReadExcel readExcel = new ReadExcel();
		
		@AfterTest
		public void closeBrowswer() {
		}
		
		// User Story 1: Browse via Category Menu Header
		@Test
		public void GIVEN_userIsOnLandingPage_AND_selectsBlueJeansViaApparlAndShoesHeaderMenu_WHEN_userAddsToCart_THEN_successNotificationIsDisplayed_AND_itemIsSuccessfullyDisplaysInShopppingCart() 
				throws InterruptedException {
			
			String expectedTitle = "Blue Jeans";
			String actualTitle;
		
			basePG.navigateToHomePage();
			landPG.selectApparelandShoesViaCategoryHearderMenu();	
			Thread.sleep(1000);
			
			catPG.clickElementTextOfThirdItem();
			actualTitle = itemPG.verifyElementText();
			System.out.println("Expected Title = "  +actualTitle);
			System.out.println("Actual Title = "  +actualTitle);
			Reporter.log("Expected Title = " + " " + expectedTitle);
			Reporter.log("Actual Title = " + " " + actualTitle);
			Thread.sleep(1000);
			
			itemPG.addItemToCart();
			itemPG.closeSuccessNotification();
			basePG.navigateToShoppingCartPage();
			
			Assert.assertEquals(expectedTitle, actualTitle);
			AssertJUnit.assertEquals(cartPG.checkCartCount("(1)"), true);
			
			cleanUp();
			
			}
				
		// User Story 2: Browse using Category List
		@Test
		public void GIVEN_userSelectsCreateYourOwnJewelryViaTheJewelryCategoryList_AND_selectsSilverImm_AND_inputs30cmLength_AND_selectsStarPendantType_WHEN_userAddsToCart_THEN_itemIsSuccessfullyDisplaysInShopppingCart() 
				throws InterruptedException {	
			
			String expectedTitle = "Create Your Own Jewelry";
			String actualTitle;
			String material = "Silver 1 mm";
			String pendantStyle = "Star";
			int length = 30;
			
			basePG.navigateToHomePage();
			landPG.selectJeweleryViaCategoryList();
			Thread.sleep(2000);
			
			catPG.clickElementTextOfFirstItem();
			actualTitle = itemPG.verifyElementText();
			System.out.println("Expected Title = "  +actualTitle);
			System.out.println("Actual Title = "  +actualTitle);
			Reporter.log("Expected Title = " + " " + expectedTitle);
			Reporter.log("Actual Title = " + " " + actualTitle);
			
			itemPG.selectMaterialDropDown(material);
			System.out.println("Expected Material = "  +material);
			System.out.println("Actual Material = "  +material);
			Reporter.log("Expected Material = " + " " + material);
			Reporter.log("Actual Material = " + " " + material);
			Thread.sleep(2000);
			
			itemPG.enterLengthInCM(length);
			System.out.println("Expected Length = "  +length);
			System.out.println("Actual Length = "  +length);
			Reporter.log("Expected Length = " + " " + length);
			Reporter.log("Actual Length = " + " " + length);
			Thread.sleep(2000);
			
			itemPG.selectPendantTypeRadioButton(pendantStyle);
			System.out.println("Expected Pendant Style = "  +pendantStyle);
			System.out.println("Actual Pendant Style = "  +pendantStyle);
			Reporter.log("Expected Pendant Style = " + " " + pendantStyle);
			Reporter.log("Actual Pendant Style = " + " " + pendantStyle);
			
			itemPG.addItemToCart();
			itemPG.closeSuccessNotification();
			basePG.navigateToShoppingCartPage();
			
			Assert.assertEquals(expectedTitle, actualTitle);
			AssertJUnit.assertEquals(cartPG.checkCartCount("(1)"), true);
			
			cleanUp();
			
			}
	
		// User Story 3: Update Shopping Cart Quantity
		@Test
		public void GIVEN_userIsOnLandingPage_AND_entersSmartphoneAsSearchString_AND_clicksSearchButton_AND_addsToCart_WHEN_userUpdatesQtyTextBox_THEN_shoppingCartAmountIsUpdated() 
				throws InterruptedException {
			
			String searchInput = "Smartphone";
						
			basePG.navigateToHomePage();
			basePG.clickSearchBar();
			basePG.enterTextInSearchBar(searchInput);
			basePG.clickSearchButton();
			
			int unitPrice = cartPG.getUnitPrice();       	
			System.out.println("Expected Price = "  +unitPrice);
			System.out.println("Actual Price = "  +unitPrice);
			Reporter.log("Expected Price = " + " " + unitPrice);
			Reporter.log("Actual Price = " + " " + unitPrice);
			
			itemPG.addItemToCart();
			itemPG.closeSuccessNotification();
			basePG.navigateToShoppingCartPage();
			
			AssertJUnit.assertEquals(cartPG.checkCartCount("(1)"), true);
			
			cartPG.updateQuantity("3");
			AssertJUnit.assertEquals(cartPG.checkCartCount("(3)"), true);
			System.out.println("Expected Price x 3 = "  +unitPrice*3);
			System.out.println("Actual Price x 3 = "  +unitPrice*3);
			Reporter.log("Expected Price x 3 = " + " " + unitPrice*3);
			Reporter.log("Actual Price x 3 = " + " " + unitPrice*3);
			
			cartPG.updateQuantity("2");
			AssertJUnit.assertEquals(cartPG.checkCartCount("(2)"), true);
			System.out.println("Expected Price x 2 = "  +unitPrice*2);
			System.out.println("Actual Price x 2 = "  +unitPrice*2);
			Reporter.log("Expected Price x 2 = " + " " + unitPrice*2);	
			Reporter.log("Actual Price x 2 = " + " " + unitPrice*2);
			
			cartPG.updateQuantity("1");
			AssertJUnit.assertEquals(cartPG.checkCartCount("(1)"), true);
			System.out.println("Expected Price = "  +unitPrice);
			System.out.println("Actual Price = "  +unitPrice);
			Reporter.log("Expected Price = " + " " + unitPrice);
			Reporter.log("Actual Price = " + " " + unitPrice);
			
			cleanUp();
			
			}	
		
		// Use Case 4: Remove Item from Cart
		@Test
		public void GIVEN_userAddsYellowApplePhoneCoverToShoppingCart_WHEN_userChecksTheRemoveCheckbox_AND_selectsUpdateShopingCart_THEN_itemsAreSuccessfullyRemovedFromShoppingCart_AND_emptyCartMessageIsReturns() 
				throws InterruptedException {
			
			String searchInput = "Phone cover";
			String manufacturer = "Apple";
			String color = "Yellow";
			
			basePG.navigateToHomePage();
			basePG.clickSearchBar();
			basePG.enterTextInSearchBar(searchInput);
			basePG.clickSearchButton();
			resultPG.clickElementTextOfFirstItem();			
			
			itemPG.selectManufacturerDropDown(manufacturer);
			System.out.println("Expected Manufacturer = "  +manufacturer);
			System.out.println("Actual Manufacturer = "  +manufacturer);
			Reporter.log("Expected Manufacturer = " + " " + manufacturer);
			Reporter.log("Actual Manufacturer = " + " " + manufacturer);
			Thread.sleep(2000);
			
			itemPG.selectColorDropDown(color);
			System.out.println("Expected Color = "  +color);
			System.out.println("Actual Color = "  +color);
			Reporter.log("Expected Color = " + " " + color);
			Reporter.log("Actual Color = " + " " + color);
			Thread.sleep(2000);
			
			itemPG.addItemToCart();
			itemPG.closeSuccessNotification();
			
			AssertJUnit.assertEquals(cartPG.checkCartCount("(1)"), true);
			
			basePG.navigateToShoppingCartPage();
			Thread.sleep(1000);
			cartPG.removeItemFromShoppingCart();
			
			AssertJUnit.assertEquals(cartPG.checkCartCount("(0)"), true);
				
			}
		
		// Use Case 5: Estimate Shipping
		@Test
		public void GIVEN_userAddsDiamondHeartNecklaceToShoppingCart_WHEN_userSelectsUSACountry_AND_selectsMassachusettsState_AND_inputs02216ZipCode_AND_userSelectsEstimateShipping_THEN_shippingDetailsAreDisplays() 
				throws InterruptedException {
			
			String searchInput = "Diamond Heart";
			String country = "United States";
			String state = "Massachussetts";
			int zip = 52116;
			
			basePG.navigateToHomePage();
			basePG.clickSearchBar();
			basePG.enterTextInSearchBar(searchInput);
			basePG.clickSearchButton();
			itemPG.addItemToCart();
			itemPG.closeSuccessNotification();
			AssertJUnit.assertEquals(cartPG.checkCartCount("(1)"), true);
			
			basePG.navigateToShoppingCartPage();
			cartPG.selectCountryDropDown(country);
			System.out.println("Expected Country = "  +country);
			System.out.println("Actual Country = "  +country);
			Reporter.log("Expected Country = " + " " + country);
			Reporter.log("Actual Country = " + " " + country);
			Thread.sleep(2000);
			
			cartPG.selectStateDropDown(state);
			System.out.println("Expected State = "  +state);
			System.out.println("Actual State = "  +state);
			Reporter.log("Expected State = " + " " + state);
			Reporter.log("Actual State = " + " " + state);
			Thread.sleep(2000);
			
			cartPG.populateZipCode(zip);
			System.out.println("Expected Zip Code = "  +zip);
			System.out.println("Actual Zip Code = "  +zip);
			Reporter.log("Expected Zip Code = " + " " + zip);
			Reporter.log("Actual Zip Code = " + " " + zip);
			cartPG.estimateShipping();
			cartPG.returnEstimateShippingMessage();

			cleanUp();
			
			}
			
//		Use Case 6: Compare Items
		@Test
		public void GIVEN_userSelectsAddToCompareListForDesktopPCWithCDRW_AND_userSelectsAddToCompareListForDesktopPCWithCDRW_AND_itemsDisplayInCompareProducts_WHEN_userSelectsClearList_THEN_listIsCleared_AND_noItemsMessageIsReturned()
					throws InterruptedException {
			
			String expectedTitle1  = "Build your own cheap computer";
			String expectedTitle2 = "Desktop PC with CDRW";		
			String actualTitle1;
			String actualTitle2;
			int expectedValue1 = 800;
			int expectedValue2 = 500;
			
			basePG.navigateToHomePage();
			landPG.selectComputersViaCategoryList();
			Thread.sleep(2000);
			landPG.selectDesktopViaComputerCategoryList();
			Thread.sleep(2000);
			catPG.clickElementTextOfFirstItem();
			actualTitle1 = itemPG.verifyElementText();
			System.out.println("Expected Title = "  +actualTitle1);
			System.out.println("Actual Title = "  +actualTitle1);
			Reporter.log("Expected Title = " + " " + expectedTitle1);
			Reporter.log("Actual Title = " + " " + actualTitle1);
			itemPG.selectAddToCompareList();	
			Thread.sleep(2000);
					
			landPG.selectComputersViaCategoryList();
			landPG.selectDesktopViaComputerCategoryList();
			catPG.clickElementTextOfFourthItem();
			actualTitle2 = itemPG.verifyElementText();
			System.out.println("Expected Title = "  +actualTitle2);
			System.out.println("Actual Title = "  +actualTitle2);
			Reporter.log("Expected Title = " + " " + expectedTitle2);
			Reporter.log("Actual Title = " + " " + actualTitle2);		
			itemPG.selectAddToCompareList();
			Thread.sleep(2000);
					
			compPG.returnUnitPriceOfFirstItem();
			int unitPrice2 = compPG.returnUnitPriceOfFirstItem();     											
			System.out.println("Expected value of "   +actualTitle2 + " = " +unitPrice2);
			System.out.println("Actual value of "   +actualTitle2 + " = " +unitPrice2);
			Reporter.log("Expected value of "   +actualTitle2+ "  " + "= "   +unitPrice2);
			Reporter.log("Actual value of "   +actualTitle2 + "  " + "= "   +unitPrice2);
					
			int unitPrice1 = compPG.returnUnitPriceOfSecondItem();
			System.out.println("Expected value of "   +actualTitle1 + " = " +unitPrice1);
			System.out.println("Actual value of "   +actualTitle1 + " = " +unitPrice1);
			Reporter.log("Expected value of "   +actualTitle1 + "  " + "= "   +unitPrice1);
			Reporter.log("Actual value of "   +actualTitle1 + "  " + "= "   +unitPrice1);
					
			Assert.assertEquals(expectedTitle1, actualTitle1);
			Assert.assertEquals(expectedTitle2, actualTitle2);
			Assert.assertEquals(expectedValue1, unitPrice1);
			Assert.assertEquals(expectedValue2, unitPrice2);
			Thread.sleep(2000);
							
				}
	
		// Use Case 7: Read from Data File
		@Test(dataProvider="Product and Quantity")
		public void SearchSiteWithExcel(String product, String quantity) throws InterruptedException {
			
			basePG.navigateToHomePage();
			basePG.clickSearchBar();
			basePG.enterTextInSearchBar(product);
			Thread.sleep(2000);
			basePG.clickSearchButton();
			itemPG.addItemToCart();
			Thread.sleep(2000);
			itemPG.closeSuccessNotification();
			Thread.sleep(2000);
			basePG.navigateToShoppingCartPage();
			Thread.sleep(2000);
			
			cleanUp();
			
			}
				
			@DataProvider(name = "Product and Quantity")
			public Object [ ][ ] getDataFromExcel() throws IOException {
				String excelDirectory = readExcel.getDataConfigProperties("inputDataDir");
				Object [ ][ ] errObj = readExcel.getExcelData(excelDirectory +"ProductAndQuantity.xlsx", "Sheet1");
				return errObj;
				}
		
}
	
	