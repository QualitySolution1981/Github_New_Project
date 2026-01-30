package GithubPCKG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PetPooja {
	public WebDriver driver;
	 
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		    
			
	  }

	
	@Test (priority=0)
	public void OrderNow () throws InterruptedException {
		// Launch URL;  https://blackknight.petpooja.com/ 
		driver.get("https://blackknight.petpooja.com/");
	    Thread.sleep(5000);
	    //Select Ahmadabad city > Click on order now
	    Select drpCity = new Select(driver.findElement(By.id("cityselection")));
		drpCity.selectByIndex(1);
		Thread.sleep(5000);
		 
		Select drpCity1 = new Select(driver.findElement(By.xpath("//*[@id=\"branchselection\"]")));
		drpCity1.selectByIndex(1);
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//*[@id=\"ordernowbtn\"]")).click();
		Thread.sleep(5000);
  }
 
	
	@Test (priority=1)
	  public void Add () throws InterruptedException {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
        
      //3.	Select 'testing' from our recommendation (left side)
		Thread.sleep(5000);
		driver.findElement(By.linkText("testing")).click();
		
		Thread.sleep(5000);
		// Increase one quantity and again decrease one quantity 
		driver.findElement(By.xpath("//*[@id=\"Recommended&\"]/div[5]/ul/li/div/div[2]/p[2]/span")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"Recommended&\"]/div[5]/ul/li/div/div[2]/div/div[3]/div")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"Recommended&\"]/div[5]/ul/li/div/div[2]/div/div[1]")).click();
		//6.	(get price for this item and validate/ verify)
		String actual_message=driver.findElement(By.xpath("//*[@id=\"Recommended&\"]/div[5]/ul/li/div/div[2]/p[1]/span")).getText();
		String expect_message="₹175.00";
		Assert.assertEquals(actual_message, expect_message); 
		
		
		
		Thread.sleep(5000);
		// Select 'Assortaion' from our recommendation (left side)   
		driver.findElement(By.linkText("Assortments")).click();
		Thread.sleep(5000);
		//8.	Tap on ADD from Code item 
		driver.findElement(By.xpath("//*[@id=\"Recommended&\"]/div[9]/ul/li[5]/div/div[2]/p[2]/span")).click();
		Thread.sleep(5000);
		// Select ‘Medium’ > Tap on ADD button 
		driver.findElement(By.xpath("//*[@id=\"addonpopform\"]/div[2]/div/section/div[1]/div/p/label")).click();
		Thread.sleep(5000);
		// Tap on Order basket to place order from top right 
		driver.findElement(By.xpath("//*[@id=\"addonpopform\"]/div[1]/div[1]/div/button[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("cartbtnlink")).click();
		Thread.sleep(5000);
		//Increase item Quantity by editing quantity field 
		driver.findElement(By.xpath("//*[@id=\"cartitem_15798742863206\"]/div[2]/div[1]/div/div[2]/input")).sendKeys("3");
		Thread.sleep(5000);
		//12.	Tap on notes section and enter something
		driver.findElement(By.xpath("//*[@id=\"cart_special_notes\"]")).click();
		Thread.sleep(5000);
		//Tap on Add more Item and add any item from list 
		driver.findElement(By.xpath("//*[@id=\"cart_special_notes\"]")).sendKeys("Hey this is Testing");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"cart\"]/div[4]/p")).click();
		Thread.sleep(5000);
		
						
	  }
	
	
	
	@Test (priority=2)
	  public void Add1 () throws InterruptedException {
				
		//Tap on Order basket to place order from top right
		driver.findElement(By.className("cartbtnlink")).click();
		Thread.sleep(5000);
		//15.	Tap on Checkout
		driver.findElement(By.xpath("//*[@id=\"cart\"]/div[4]/div[2]/span[1]")).click();
		Thread.sleep(5000);
		//16.	Enter name and number > tap on send OTP
		driver.findElement(By.xpath("//*[@id=\"checkout_user_name\"]")).sendKeys("Varun");
		driver.findElement(By.xpath("//*[@id=\"userverificationpopup\"]/div[2]/div/input")).sendKeys("0000000000");
		Thread.sleep(5000);
		//17.	Enter invalid ‘123’ OTP and get error message
		driver.findElement(By.xpath("//*[@id=\"checkout_verify_otp\"]")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id=\"userotpverificationpoupform\"]/div[2]/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"userotpverificationpoup\"]/div/div/div[2]/div[1]")).getText();
		//18.	Again Enter correct ‘123456’ in OTP field
		driver.findElement(By.xpath("//*[@id=\"checkout_verify_otp\"]")).sendKeys("123456");
		//19.	Tap on ‘Verify OTP’
		driver.findElement(By.xpath("//*[@id=\"userotpverificationpoupform\"]/div[2]/button")).click();
		Thread.sleep(5000);
		
			
	  }
	
	
	@Test (priority=3)
	  public void Add2 () throws InterruptedException {
				
		//20.	Select option from ‘Delivery preference’ to put order as advance
		driver.findElement(By.xpath("//*[@id=\"checkoutform\"]/div/div[1]/div/div/button")).click();
		Thread.sleep(5000);
		//22.	Verify that order is place successfully or not.
		String actual_message=driver.findElement(By.xpath("/html/body/div[2]/center")).getText();
		String expect_message="Order payment updated successfully!";
		Assert.assertEquals(actual_message, expect_message); 
		
			
	  }
	
  @AfterTest
  public void afterTest() {
  }

}
