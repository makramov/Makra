
package hrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class radioButtons extends base {

	@BeforeTest

	public void Before() throws IOException {

		getDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");

	}

	@Test
	public void radiobtn() {

		int size = driver.findElements(By.xpath("//input[@name='group1']")).size();

		for (int i = 0; i < size; i++) {

			String value = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

			if (value.equals("Milk")) {
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
				Assert.assertEquals(value, "Milk");
			}
		}

	}

	@AfterTest

	public void tearDown() {

	driver.quit();
	}

}
