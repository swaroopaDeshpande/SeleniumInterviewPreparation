package WebdriverPractice;

public class SynchronizationConcepts {

	public static void main(String[] args) {
		// 1.Static wait: Thread.sleep(2000); current thread become inactive
		// till time given.Remeber alarm clock
		// 2.wait(): Thread will be inactive till certain conditions happen in
		// future.required notify(),notifyall() to start process.remeber screw
		// driver you have given to your coworker now till it comes to u , u
		// sleep once your college gave u tha screw driver work gonna start
		// 3.Dynamic wait
		// 1.Implicitly
		// wait:driver.manage().timeouts().implictlywait(10,TimeUnit.seconds);
		// global wait,directly apply on driver,can change anytime in
		// script,applied on all element presnt on HTML dom,dymanic in nature
		// 2.explicite wait: no keyword use with WebDriverWait class with some
		// expected conditions
		// dynamic in nature , only for particular element
		// 3.fluent wait:an fluent wait is a special wait to tell Selenium
		// Webdriver to
		// poll(to search)
		// the DOM for a given time with polling machanisum
		// with ignoring conditions such as "NOSUCHELEMENTEXECEPTION"
	}

}
