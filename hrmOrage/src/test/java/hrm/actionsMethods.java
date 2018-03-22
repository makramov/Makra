package hrm;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class actionsMethods extends base{
	
	public homePagePattern hp;
	
	@BeforeTest
	
	public void before() throws IOException {
		getDriver();
		LogIn();	
		hp = new homePagePattern(driver);
	}
	
	@Test
	public void validateActions() {
		
	act.moveToElement(hp.homePageBarAdmin()).moveToElement(hp.userManagement()).moveToElement(hp.viewSystemUsers()).click().build().perform();
		
	act.moveToElement(hp.adminUserNameSearch()).click().sendKeys(Keys.SHIFT,"mansur").build().perform();
	act.doubleClick(hp.adminUserNameSearch()).build().perform();
	act.moveToElement(hp.adminEmployeeName()).click().sendKeys("Akramov").build().perform();
	act.contextClick().build().perform();
	
	}
	
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}
