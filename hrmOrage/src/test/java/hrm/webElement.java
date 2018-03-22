package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class webElement extends base {
	
	@BeforeTest
	
	public void before() throws IOException {
		
		getDriver();
		driver.get("https://www.makemytrip.com/");
	}

	@Test
	public void validateWebElement() {
		Assert.assertFalse(driver.findElement(By.xpath("//div[@class='clearfix']/div[1]")).isDisplayed());
		driver.findElement(By.xpath("//div[@id='multicity']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='clearfix']/div[1]")).isDisplayed());
		
Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Discover Hot Deals']")).getText(),"Discover Hot Deals");
	}
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
}
