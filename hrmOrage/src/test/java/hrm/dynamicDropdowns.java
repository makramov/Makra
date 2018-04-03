package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class dynamicDropdowns extends base {
	
	
	@BeforeTest
	public void before() throws IOException {
		getDriver();
	    driver.get("http://www.ksrtc.in/oprs-web/");
	}
	
	
	@Test
    public void jsExecutor() {
	 driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("bang");
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 String script = "return document.getElementById(\"fromPlaceName\").value;";
    // String text =(String) js.executeScript(script);	
	 int i=0;
	
     while(!js.executeScript(script).equals("BANGALORE INTERNATION AIPORT")){
     i++;
     driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
     
     if(i>10) {
    	 break;
     }
     }
     if(i>10) {
    	 System.out.println("Element is not found.");
     }
     else {
    	 System.out.println("Element is found.");
    	
     }}
    
	

    @AfterTest
    public void after() {
    
    	driver.quit();	
    }
}