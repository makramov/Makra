package hrm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class windowHandlers extends base {
	 
    public homePagePattern hp;
	@BeforeTest
	public void before() throws IOException {
		
		getDriver();
		LogIn();
		hp = new homePagePattern(driver);
		
	}
	
@Test

public void handlersMathod() {

	hp.OrangeHRM().click();
	Set<String> wp=driver.getWindowHandles();
    Iterator<String> get =   wp.iterator();
    String parent=get.next();
    String child =get.next();
    
    driver.switchTo().window(child);
    Assert.assertEquals(driver.getTitle(),"HR Management System | OrangeHRM l HR Management Software");
    driver.switchTo().window(parent);
    Assert.assertEquals(driver.getTitle(),"OrangeHRM");    
    
    
}

@AfterTest
public void tearDown() {
	
	driver.quit();
}
	
	

}
