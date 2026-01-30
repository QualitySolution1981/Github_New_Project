package GithubPCKG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SauceDemoLogin2 {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();

		 Map<String, Object> prefs = new HashMap<String, Object>();

		 prefs.put("credentials_enable_service", false);

		 prefs.put("profile.password_manager_enabled", false);

		 prefs.put("profile.password_manager_leak_detection", false);

		 options.setExperimentalOption("prefs", prefs);

		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		   driver.get("https://www.saucedemo.com/");
	  }
	
	@Test (priority=0)
	 
	public void bothvalueblank() throws InterruptedException {
	//Both Value Blank
		 driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
	        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
	        driver.findElement(By.xpath("//*[@id='login-button']")).click();
	        driver.findElement(By.xpath("//*[@class='select_container']")).click();
	        driver.findElement(By.xpath("//*[@value='za']")).click();
	        String actual_message=driver.findElement(By.xpath("//*[@class='inventory_item_name ']")).getText();
	    String expect_message="Test.allTheThings() T-Shirt (Red)";
	    Assert.assertEquals(actual_message, expect_message);
	    driver.findElement(By.xpath("//*[@class='select_container']")).click();
	    driver.findElement(By.xpath("//*[@value='lohi']")).click();
	    String actual_message1=driver.findElement(By.xpath("//*[@id='item_2_title_link']")).getText();
	    String expect_message1="Sauce Labs Onesie";
	    Assert.assertEquals(actual_message1, expect_message1);
	    driver.findElement(By.xpath("//*[@class='select_container']")).click();
	    driver.findElement(By.xpath("//*[@value='hilo']")).click();
	    String actual_message2=driver.findElement(By.xpath("//*[@id='item_5_title_link']")).getText();
	    String expect_message2="Sauce Labs Fleece Jacket";
	    Assert.assertEquals(actual_message2, expect_message2);
	    driver.findElement(By.xpath("//*[@class='select_container']")).click();
	    driver.findElement(By.xpath("//*[@value='az']")).click();
	    String actual_message3=driver.findElement(By.xpath("//*[@id='item_4_title_link']")).getText();
	    String expect_message3="Sauce Labs Backpack";
	    Assert.assertEquals(actual_message3, expect_message3);
	    driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
	}
	
	

  @AfterTest
  public void afterTest() {
  }

}
