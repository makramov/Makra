package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;

public class multiframes extends base {
	
	public int i;
	public WebElement num1;
	
	@BeforeMethod
	public void before() throws IOException {
		getDriver();
		driver.get("https://www.google.com/recaptcha/api2/demo");
		
	}

	
	@Test
	public void verifyFrames()  {
	
		
		//WebElement num1=driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-spinnerAnimation']"));	
		int count =driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<count;i++) {	
			driver.switchTo().frame(i);
	
	/*driver.switchTo().frame(num1);
	driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-spinnerAnimation']")).click();
 */
	 int frame1=driver.findElements(By.xpath("//div[@class='recaptcha-checkbox-spinnerAnimation']")).size();
	 if(frame1>0) {
    driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-spinnerAnimation']")).click();
	}
	
	
	
	/*public int validateFrames(By by) {		 
	int count =driver.findElements(By.tagName("iframe")).size();
	for(int i=0;i<count;i++) {	
		driver.switchTo().frame(i);
	int frame1=driver.findElements(by).size();
	 if(frame1>0) {
     driver.switchTo().frame(frame1);
	 break;
	}
	else{
		System.out.println("Continiue.");
	}
   

	}	
	driver.switchTo().defaultContent();
	return i;
    
	}*/
	   }}
@AfterTest
public void tearDown() {
	driver.quit();
}
}
