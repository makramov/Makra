package hrm;


import java.io.IOException;


import org.openqa.selenium.By;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class calendar extends base{
	
	@BeforeTest
	public void before() throws IOException {
		
		getDriver();
		driver.get("https://www.makemytrip.com/");
	}
   
	@Test
	public void validatecalendar(){

	driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).click();
	
	
	while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]")).getText().contains("April")) {
		
		driver.findElement(By.xpath("(//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']/a/span)[1]")).click();
	   break;
	}
     
int days=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")).size();
	for(int i=0;i<days;i++) {
String day=	driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")).get(i).getText();
	if(day.equalsIgnoreCase("30")) {
		driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")).get(i).click();
    break;		
	}	
		
	}
	}
	
	

	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
