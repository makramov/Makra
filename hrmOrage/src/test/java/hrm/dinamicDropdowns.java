package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class dinamicDropdowns extends base {
	
	
	@BeforeMethod
	
	public void beore() throws IOException {
		getDriver();
		driver.get("http://spicejet.com/");
		
	}
	
	
	@Test 
	public void HandlingdinamicDropdowns() {
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul[3]/li[1]/a")).click();
		driver.findElement(By.xpath("(//div[@id='dropdownGroup1']/div/ul[3]/li[2]/a)[2]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='dropdownGroup1']/div/ul[3]/li[2]/a)[2]"))
        		.getText(),"Mumbai (BOM)"
        );		
		
	}
	

	
	@AfterTest
	
	public void tearDown() {
		
		driver.quit();
	}
	
}
