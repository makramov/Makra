package hrm;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class linksHandlong extends base {
 
@BeforeMethod
public void before() throws IOException {
  getDriver();	
 driver.get("https://www.ebay.com/");
 
}


@Test
public void handleLink() {
	
int number =driver.findElements(By.tagName("a")).size();
Assert.assertEquals(number,397);

WebElement footer= driver.findElement(By.xpath("//footer[@id='glbfooter']"));
int footnumber=footer.findElements(By.tagName("a")).size();
Assert.assertEquals(footnumber,87);

WebElement colonLinks =footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[2]/ul"));
int count =colonLinks.findElements(By.tagName("a")).size();
for(int i=0;i<count;i++) {
	
String value = colonLinks.findElements(By.tagName("a")).get(i).getText();
if(value.equals("Site map")) {
	colonLinks.findElements(By.tagName("a")).get(i).click();
String text =	driver.findElement(By.xpath("//h1[text()='Sitemap']")).getText();
	Assert.assertEquals(text, "Sitemap");
    break;  
}

}
driver.navigate().back();

}






@AfterMethod
public void tearDown() {

driver.quit();
	
}

}	

