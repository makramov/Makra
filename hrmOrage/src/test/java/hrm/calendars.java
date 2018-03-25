package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;

public class calendars extends base{
	
	
	@BeforeMethod
    public void before() throws IOException {
	getDriver();
	LogIn();
	
		
	}

	
	@Test
	public void handleCalendars() {
 
     driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']")).click();
     driver.findElement(By.xpath("//input[@id='calFromDate']")).click();
     int days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td")).size();
  
     while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select")).getText().contains("Mar")) {
   		 
   	 driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/a[2]")).click();
     break;
   	 }
  
   	 for(int i=0;i<days;i++) {
  	 String day =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td")).get(i).getText();
  
  	 if(day.equals("30")) {
  	 driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td")).get(i).click();
  		
  		}
   	 }}
   
  					
  					
  				 	
  	@AfterMethod
  	public void tearDown() {
  	driver.quit();
  	}
 				
 		  
 		
	
	
	
	}

	
	
