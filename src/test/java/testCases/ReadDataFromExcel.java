package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;
import frameWorkClasses.Utilities;

public class ReadDataFromExcel {

	// instantiate class object
		ReadExcel readExcel = new ReadExcel();
		Utilities uts = new Utilities();
		
		String outputDirectory = uts.getDataConfigProperties("outputDir");
		String outputFile = outputDirectory + "output11.txt"; // output.txt" = any file name
		
		@BeforeMethod
		@BeforeTest
		public void setUp() {
			uts.resetOutputFile(outputFile);
		}
				
		public void ItemQuantity(String product, String quantity) {
			}
		
		@Test(dataProvider="Product and Quantity")
		public void ProductQuantityint(String product, String quantity) {
			System.out.println(product + " " + quantity);
			}
		
		@Test(dataProvider="Product and Quantity")
		public void ProductQuantityString(String product, int quantity) {
			System.out.println(product + " " + quantity);
			}
		
		@DataProvider(name = "Product and Quantity")
		public Object [ ][ ] getDataFromExcel() throws IOException {
			String inputDirectory = readExcel.getDataConfigProperties("inputDataDir");
			Object [ ][ ] errObj = readExcel.getExcelData(inputDirectory +"ProductAndQuantity.xlsx", "Sheet1");
			return errObj;
		}
		
		@Test(dataProvider="Product and Quantity")
		public void ProductQuantityString1(String product, String quantity) {
			boolean bool = true;
			
			String result;
			if (bool) {
				result = "It's true";
			} else {
				result = "It's Fail";
			}
			
			String content = product + "," + quantity + "," + result;
			
			try {
		// path - the path to the file
		// bytes - the byte array with the bytes to write
		// options - options specifying how the file is opened
		// Files.write(null. null. null);
				
				Files.write(Paths.get(outputFile), (content + System.lineSeparator()).getBytes(),
						StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);
				
			} catch (IOException e) {
				System.out.println("the error is " + e.getMessage());
				
			}
			}
		
	}
