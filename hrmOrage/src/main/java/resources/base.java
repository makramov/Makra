package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public Actions act;
	public Logger log;

	public WebDriver getDriver() throws IOException {

		prop = new Properties();
		FileInputStream fils = new FileInputStream(
				"C:\\Users\\Mansur\\Makra\\hrmOrage\\src\\main\\java\\resources\\data.properties");
		prop.load(fils);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mansur\\Desktop\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/makra/Desktop/java/Drivers/geckodriver");
			driver = new FirefoxDriver();

		}

		else {
			driver = new SafariDriver();
		}

		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		act = new Actions(driver);
		log = LogManager.getLogger(base.class.getName());

		return driver;
	}

	public void LogIn() {

		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	public void getScreenShot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\hrm\\" + result + "screenshot.png"));

	}

}
