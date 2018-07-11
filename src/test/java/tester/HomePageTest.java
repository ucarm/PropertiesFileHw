package tester;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ConfigLoader;
import pages.Homepage;
import pages.LogInPage;

public class HomePageTest {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.out.println("Set up selenium");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigLoader.getMyValue("URL"));
	}

	@Test(description="Login to site and assert if we are logged in")
	public void test1() throws InterruptedException {
		Homepage home = new Homepage(driver);
		home.signInLink.click();
		LogInPage logIn=  new LogInPage(driver);
		logIn.login(ConfigLoader.getMyValue("User"), ConfigLoader.getMyValue("Pass"));
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("//h1[.='My account']")).isDisplayed());
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		System.gc();
	}
}
