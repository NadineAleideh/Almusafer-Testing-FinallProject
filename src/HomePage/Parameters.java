package HomePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Parameters {
	
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String AlMosaferURL = "https://global.almosafer.com/en";
	String ExpectedDefaultLanage = "en";
	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	boolean ExpectedResultsForTheLogo = true;
	String expectedValue ="false";
	
	LocalDate todayDate = LocalDate.now();
	int Tomorrow = todayDate.plusDays(1).getDayOfMonth();
	int ThedayAfterTomorrow = todayDate.plusDays(2).getDayOfMonth();
	
	
	
	String [] EnglishCities = {"Dubbai","Jeddah","riyadh"};
	int randomEnglishCity = rand.nextInt(EnglishCities.length);
	String [] ArabicCities = {"دبي","جدة"}; 
	int randomArabicCity = rand.nextInt(ArabicCities.length);
	
	
	
	public void GeneralSetup () {
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(AlMosaferURL);

	}
	
	public void RandomSelectTheLanguageOfTheWebSite() {
		String [] URLs = {"https://www.almosafer.com/en","https://www.almosafer.com/ar",}; 
		 int RandomIndex = rand.nextInt(URLs.length) ; 
		 driver.get(URLs[RandomIndex]); 
	}
}
