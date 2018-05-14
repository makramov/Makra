package hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPagePattern {

	WebDriver driver;
	
	public loginPagePattern(WebDriver driver) {
		// TODO Auto-generated constructor stub
       this.driver=driver;      	
	}
	
	By username = By.xpath("//input[@id='txtUsername']");
	By userpassword = By.xpath("//input[@id='txtPassword']");
	By LogInBtn = By.xpath("//input[@id='btnLogin']");
	By LOGINPanel = By.xpath("//div[@id='logInPanelHeading']");
	By InvalidCredentials =By.xpath("//span[text()='Invalid credentials']");
	By EmptyUserNameText = By.xpath("//span[@id='spanMessage' and text()='Username cannot be empty']");
    By EmptyUserPasswordText = By.xpath("//span[@id='spanMessage' and text()='Password cannot be empty']");	


	

    public WebElement EmptyUserPasswordText() {
		
		return driver.findElement(EmptyUserPasswordText);
	}
	

    
    public WebElement EmptyUserNameText() {
		
		return driver.findElement(EmptyUserNameText);
	}
	
	public WebElement username() {
		
		return driver.findElement(username);
	} 
	

    public WebElement userpassword() {
		
		return driver.findElement(userpassword);
	} 

    public WebElement LogInBtn() {
		
		return driver.findElement(LogInBtn);
	}

   public WebElement LOGINPanel() {
	   
	   return driver.findElement(LOGINPanel);
   }

   public WebElement InvalidCredentials() {
	   return driver.findElement(InvalidCredentials);
   }

}

