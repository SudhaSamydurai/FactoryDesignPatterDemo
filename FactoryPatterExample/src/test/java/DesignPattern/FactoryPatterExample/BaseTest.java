package DesignPattern.FactoryPatterExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setupDriver() {
		System.out.println(
				"*********************   Create WebDriver Instance - Do not forget system property   *******************");
		WebDriverManager.chromedriver().setup();
		
		this.driver = new ChromeDriver();
	}

	@AfterTest
	public void quitDriver() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		this.driver.quit();
	}
}
