package hrm;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class sssl {
	public static void main(String[] args) {
    
	DesiredCapabilities cp = DesiredCapabilities.chrome();
	//cp.acceptInsecureCerts();		
	//cp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
      cp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
      
      ChromeOptions m = new ChromeOptions();
      m.merge(cp);
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Makra\\git\\New folder\\Makra\\hrmOrage\\src\\main\\java\\resources\\chromedriver.exe");
      ChromeDriver driver = new ChromeDriver(m);
      driver.get("http://www.google.com");
	 WindowsUtils.killByName("Notepad.exe");
	
	}

}
