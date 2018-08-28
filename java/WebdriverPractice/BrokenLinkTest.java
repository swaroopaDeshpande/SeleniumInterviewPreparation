package WebdriverPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		Thread.sleep(2000);
		driver.switchTo().frame(0);

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@1234");
		WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		loginBtn.click();

		// a href
		// images //img //href <http://www.test.com

		// 1.get list of all links and images
		List<WebElement> linkedList = driver.findElements(By.tagName("a"));
		linkedList.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> activeLinks = new ArrayList<WebElement>();
		// Iterate linkedList-exclude links and images who doesn't have any href
		// attribute

		for (int i = 0; i < linkedList.size(); i++) {
			if (linkedList.get(i).getAttribute("href") != null) {
				activeLinks.add(linkedList.get(i));
			}
		}
		// get size of active linked list
		System.out.println("Size of active links is :" + activeLinks.size());

		// check the href url,with http connection api200 ok,404 not
		// found500-->internal 400: bad req,

		for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();// ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "-->" + response);
		}

	}

}
