package WebdriverPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapePracto {

	public static void main(String[] args) {
		// https://www.pepperfry.com/site_product/search?q=BedSheets&src=BedSheets&as=0

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		// staleElement ExceptionWebDriver driver=new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.pepperfry.com/site_product/search?q=BedSheets&src=BedSheets&as=0");
		driver.findElement(By.id("curSortType")).click();
		List<WebElement> options = driver
				.findElements(By.xpath("//ul[@class='clip-drpdwn-flx pf-margin-0 pf-padding-0 capitalize']//li//a"));
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText();
			System.out.println(option);
			if (options.get(i).getText().contains("Fastest Shipping")) {
				options.get(i).click();
				break;
			}
		}

	}

}
