package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.LaunchSalesForceUrl;

public class CreateIndividuals extends LaunchSalesForceUrl{
	public CreateIndividuals(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	
	public CreateIndividuals clickNewButton()
	{
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		return this;
	}
	public CreateIndividuals enterLastName(String lname)
	{
		driver.findElement(By.xpath("//input[contains(@class,'lastName compoundBLRadius ')]")).sendKeys(lname);
		return this;
	}
	public EditIndividuals clickSaveButton()
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new EditIndividuals(driver,node);
	}

}
