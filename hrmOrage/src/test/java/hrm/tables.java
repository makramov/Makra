package hrm;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class tables extends base{

	@BeforeTest
	public void before() throws IOException {
	getDriver();	
	driver.get("http://www.cricbuzz.com/live-cricket-scorecard/19312/pak-vs-wi-2nd-t20i-windies-tour-of-pakistan-2018");
	}

    @Test
    public void validateTable() {
    String extra= driver.findElement(By.xpath("//div[@id='innings_1']/div[1]/div[8]/div[2]")).getText();
    String Total=driver.findElement(By.xpath("//div[@id='innings_1']/div[1]/div[9]/div[2]")).getText();
    int sum=0 ;
    WebElement table = driver.findElement(By.xpath("//div[@id='innings_1']/div[1]"));	
    int count=table.findElements(By.xpath("//div[@id='innings_1']/div[1]/div/div[3]")).size();
    for(int i=0;i<count-2;i++) {
    String rows=table.findElements(By.xpath("//div[@id='innings_1']/div[1]/div/div[3]")).get(i).getText();
    int value=Integer.parseInt(rows);
    sum=sum+value;
    
    
    }
int extravalue =  Integer.parseInt(extra);
int totalvalue = Integer.parseInt(Total);
    int totalsum=sum+extravalue;
    System.out.println(totalvalue);
    System.out.println(totalsum);
    assertEquals(totalvalue, totalsum);
    }



}
