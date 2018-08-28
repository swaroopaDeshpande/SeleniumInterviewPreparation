package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Constantvars;
import util.Synchronization_Points;

public class WareHousesitePracto {

	public static void main(String[] args) {
		//https://www.thewarehouse.co.nz
		
		System.setProperty("webdriver.chrome.driver", Constantvars.driver_exe_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);

		driver.get("https://www.thewarehouse.co.nz/c/toys-baby/outdoor-play/trampolines#prefn1=turntoAverageRating&srule=name-descending&sz=24&start=0&prefv1=3%20stars%20%26%20up");
//		WebElement brand=driver.findElement(By.xpath("//h3[contains(text(),'Brand')]"));
//		brand.click();
//		driver.findElement(By.xpath("//a[@title='Refine by:Basics']//i")).click();
//		
		
		WebElement sort=driver.findElement(By.xpath("//div[@id='s2id_grid-sort-footer']"));
		sort.click();
		driver.findElement(By.xpath("//a[@class='select2-choice']//span[@id='select2-chosen-137']")).click();
		
	}

}
