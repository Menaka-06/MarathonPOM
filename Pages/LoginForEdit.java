package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.LaunchSalesForceUrl;

public class LoginForEdit extends LaunchSalesForceUrl{
	public LoginForEdit(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	public LoginForEdit enterUserName(String username) throws IOException {
	try {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		reportStep(username+" Username Entered Successfully","pass");
	} catch (Exception e) {
		reportStep(username+" Username Not Entered","Fail");
	}
	return this;
	}
	public LoginForEdit enterPassWord(String password) throws IOException {
	try {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		reportStep(password+" Password Entered Successfully","pass");
	} catch (Exception e) {
		reportStep(password+" Password Not Entered ","Fail");
	}
	return this;
	}
	
	public EditTwo clickLogin() throws IOException {
	try {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		reportStep(" Login clicked Successfully ","pass");
	} catch (Exception e) {
		reportStep(" Login Not clicked ","Fail");
	}
	return new EditTwo(driver, node);
	
	}
	
	
}



