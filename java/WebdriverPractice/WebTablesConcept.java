package WebdriverPractice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import util.Constantvars;
import util.Synchronization_Points;
import util.WebEventListener;
import util.XLS_Reader;

public class WebTablesConcept {
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;

	public static void main(String[] args) throws IOException {
		// Check webtables-print all data from webtable
		System.setProperty("webdriver.chrome.driver", Constantvars.driver_exe_path);
		WebDriver driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		String beforeXpath = "//*[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[1]";

		// for loop
		// what to do if its dynamic table:total no of rows
		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = (noOfRows.size() - 1);
		System.out.println("No Of rows in table " + rowCount);

		XLS_Reader reader = new XLS_Reader(
				"C:\\Users\\HP\\workspace\\SeleniumInterviewPreparation\\java\\TestData\\TestData.xlsx");
		if (!reader.isSheetExist("TableData")) {
			reader.addSheet("TableData");
			reader.addColumn("TableData", "companyname");
			reader.addColumn("TableData", "contactname");
		}

		for (int i = 2; i <= rowCount; i++) {
			String actualXpath_Company = beforeXpath + i + afterXpath;
			String companyname_Company = driver.findElement(By.xpath(actualXpath_Company)).getText();
			System.out.println(companyname_Company);
			reader.setCellData("TableData", "companyname", i, companyname_Company);

			String before_xpath_contact = "//*[@id='customers']/tbody/tr[";
			String after_xpath_contact = "]/td[2]";
			String actualXpath_Contact = before_xpath_contact + i + after_xpath_contact;
			String Contact = driver.findElement(By.xpath(actualXpath_Contact)).getText();
			System.out.println(Contact);
			reader.setCellData("TableData", "contactname", i, Contact);

		}

	}

}
