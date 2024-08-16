package HomePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	
	WebDriver driver = new ChromeDriver();
	String AlmusaferWebsiteURL= "https://global.almosafer.com/en";
	String ExpectedDefaultLanage = "en";
	Random rand = new Random(); 
	
	@BeforeTest 
	
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(AlmusaferWebsiteURL);
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
	}
	
		@Test(priority = 1, enabled= false)
		public void CheckTheDefaultLangugeIsEnglish() {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			Assert.assertEquals(ActualLanguage, ExpectedDefaultLanage);
		}
		
		@Test(priority = 2, enabled= false)
		public void CheckdefaultCurrency() {
			String ExpectedCurrency = "SAR";
			
			WebElement Currency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"));
			String ActualCurrency = Currency.getText();

			Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		}
		
		@Test(priority = 3, enabled= false)
		public void CheckContactNumber() {
			String ExpectedContactNumber = "+966554400000";
			String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();

			Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
		}

		@Test(priority = 4, enabled= false)
		public void CheckQitagLogo() {
			boolean ExpectedResultsForTheLogo = true;
			WebElement theFooter = driver.findElement(By.tagName("footer"));

			WebElement logo = theFooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"))
					.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));

			boolean ActualResultForThelogo = logo.isDisplayed();
			
			Assert.assertEquals(ActualResultForThelogo, ExpectedResultsForTheLogo);

		}
		
		@Test(priority = 5, enabled= false)
		public void TestHotelTabIsNotSelected() {
			String expectedValue ="false";
			WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			String actualValue = HotelTab.getAttribute("aria-selected");
			
			Assert.assertEquals(actualValue, expectedValue);
		}
		
		@Test(priority = 6, enabled= false)
		
		public void CheckDepatureDate() {
			LocalDate todayDate = LocalDate.now();
			
			//int Today  =todayDate.getDayOfMonth();
			//System.out.println(Today+22);
			
			int Tomorrow = todayDate.plusDays(1).getDayOfMonth();
			int ThedayAfterTomorrow = todayDate.plusDays(2).getDayOfMonth(); 
			
			List<WebElement> depatureAndArrivalDates = driver.findElements(By.className("LiroG")); 

		 	String ActualDepatureDate = depatureAndArrivalDates.get(0).getText(); 
		 	String ActualReturnDate = depatureAndArrivalDates.get(1).getText(); 
		 	
		 	
		 	int ActualDepatureDateAsInt = Integer.parseInt(ActualDepatureDate); 
		 	int ActualreturnDateAsInt = Integer.parseInt(ActualReturnDate); 


		 	Assert.assertEquals(ActualDepatureDateAsInt, Tomorrow);
		 	Assert.assertEquals(ActualreturnDateAsInt, ThedayAfterTomorrow);
//
//		 // Convert int variables to strings
//		 	String TomorrowAsString = String.valueOf(todayDate.plusDays(1).getDayOfMonth());
//		 	String ThedayAfterTomorrowAsString = String.valueOf(todayDate.plusDays(2).getDayOfMonth());
//
//		 	// Find the departure and arrival dates on the webpage
//		 	List<WebElement> depatureAndArrivalDates = driver.findElements(By.className("LiroG")); 
//
//		 	// Get the actual departure and return dates as strings
//		 	String ActualDepatureDate = depatureAndArrivalDates.get(0).getText(); 
//		 	String ActualReturnDate = depatureAndArrivalDates.get(1).getText(); 
//
//		 	// Assert the equality of the dates
//		 	Assert.assertEquals(ActualDepatureDate, TomorrowAsString);
//		 	Assert.assertEquals(ActualReturnDate, ThedayAfterTomorrowAsString);

		}
		
        @Test(priority = 7, enabled= false)
		
		public void RandomlyChangeTheLanguage() {
					String [] URLs = {"https://www.almosafer.com/en","https://www.almosafer.com/ar",}; 
					 int RandomIndex = rand.nextInt(URLs.length) ; 
					 
					 driver.get(URLs[RandomIndex]); 
	 		
		}
        
        @Test(priority = 8)
        public void SearchRandomLocationDependingOnLangauge() throws InterruptedException {
        	
        	
        	String [] URLs = {"https://www.almosafer.com/en","https://www.almosafer.com/ar",}; 
			 int RandomIndex = rand.nextInt(URLs.length) ; 
			 
			 driver.get(URLs[RandomIndex]); 
			 
			 WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	        	HotelTab.click();
			 
			 String ExpectedEnglishLanage = "en";
			 String ExpectedArabicLanage = "ar";
			 
			 String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			 
			 String Input_Text ="";
			 String [] Ar_Locations = {"دبي", "جدة"};
			  int randomIndexForAr_Locations = rand.nextInt(Ar_Locations.length);
			
			  String [] En_Locations = { "Jeddah","Dubai", "Riyadh"};
			  int randomIndexForEn_Locations = rand.nextInt(En_Locations.length);
			
	
			  WebElement LocationSearchBox = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
			  
			    if (ActualLanguage.equals(ExpectedEnglishLanage)) {
			        Input_Text = En_Locations[randomIndexForEn_Locations];  
			    } else if (ActualLanguage.equals(ExpectedArabicLanage)) {
			        Input_Text = Ar_Locations[randomIndexForAr_Locations];
			    }
			
			LocationSearchBox.sendKeys(Input_Text);
			
			  WebElement LocationBoxSuggestions = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
			  
			  LocationBoxSuggestions.findElement(By.cssSelector("li:first-child")).click();


				JavascriptExecutor js = (JavascriptExecutor) driver;

				//js.executeScript("document.querySelector('ul.sc-phbroq-4.gGwzVo.AutoComplete__List li:nth-child(2)').click();");
				
				WebElement firstLiElement = (WebElement) js.executeScript(
					    "return document.querySelector('ul.sc-phbroq-4.gGwzVo.AutoComplete__List li:nth-child(2)');"
					);
				Thread.sleep(3000);
					firstLiElement.click();
        }
        
		
		
}
