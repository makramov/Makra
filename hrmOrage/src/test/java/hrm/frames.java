package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class frames extends base{
	
	@BeforeTest
	public void before() throws IOException {
	getDriver();
	driver.get("http://jqueryui.com/droppable/");
	
		
	}

	
	@Test
	public void handleFrames() {
		
	driver.switchTo().frame(0);
   WebElement source	=driver.findElement(By.xpath("//div[@id='draggable']"));
   WebElement target=	driver.findElement(By.xpath("//div[@id='droppable']"));
	act.dragAndDrop(source, target).build().perform();
driver.switchTo().defaultContent();	
	}
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
