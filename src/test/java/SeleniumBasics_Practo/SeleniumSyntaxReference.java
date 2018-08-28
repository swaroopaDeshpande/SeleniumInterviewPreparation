package SeleniumBasics_Practo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class SeleniumSyntaxReference {

	@BeforeMethod
	public void Setup() {
		// 1.How to launch any browser?(IE,Chrome,FF,safari)
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//2.How to Open URL
		driver.get("https://www.facebook.com");//wait till whole page load
		//driver.navigate().to("https://www.facebook.com");//open but not wait till page load
		driver.manage().window().getPosition();
		

	}

}
