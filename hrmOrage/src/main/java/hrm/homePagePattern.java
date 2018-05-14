package hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePagePattern {

	WebDriver driver;
	
	public homePagePattern(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(xpath="//a[@href='http://www.orangehrm.com']")
WebElement OrangeHRM;

@FindBy(xpath="//input[@id='searchSystemUser_employeeName_empName']")
WebElement adminEmployeeName;
	
@FindBy(xpath="//input[@id='searchSystemUser_userName']")
WebElement adminUserNameSearch;
	
@FindBy(xpath="//div[@class='menu']/ul[1]/li[1]/a")
WebElement homePageBarAdmin;


@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")	
WebElement viewSystemUsers;

@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
WebElement userManagement;
	
@FindBy(xpath="//input[@id='ohrmList_chkSelectAll']")
WebElement adminUserCheckBoxes;
	
@FindBy(xpath="//a[@id='welcome']")
WebElement WelcomeAdmin;

@FindBy(xpath="//a[text()='Logout']")
WebElement LogOut;

@FindBy(xpath="//div[@class='menu']")
WebElement homePageBar;




@FindBy(xpath="//div[@class='menu']/ul[1]/li[2]/a/b")
WebElement homePagePIM;

@FindBy(xpath="//select[@id='empsearch_job_title']")
WebElement PIMEmplJobTitle;


public WebElement OrangeHRM() {
	
	return OrangeHRM;
}

public WebElement adminEmployeeName() {
	
	return adminEmployeeName;
}

public WebElement adminUserNameSearch() {
	
	return adminUserNameSearch;
}





public WebElement homePageBarAdmin() {

		return homePageBarAdmin;
}

public WebElement viewSystemUsers() {
	return viewSystemUsers;
}

public WebElement userManagement() {
	
	return userManagement;
}


public WebElement adminUserCheckBoxes() {
	
	return adminUserCheckBoxes;
}

public WebElement PIMEmplJobTitle() {
	
	return PIMEmplJobTitle;
}

public WebElement homePagePIM() {
	
	return homePagePIM;
}


public WebElement homePageBar() {
	
	return homePageBar;
}

public WebElement WelcomeAdmin() {
	return WelcomeAdmin;
}


public WebElement LogOut() {
	return LogOut;
}







}
