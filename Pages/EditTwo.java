package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.LaunchSalesForceUrl;

public class EditTwo extends LaunchSalesForceUrl {

	public EditTwo(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	public EditTwo clickOnToggle() throws IOException
	{
	try {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		reportStep(" Toggle clicked Successfully ","pass");
	} catch (Exception e) {
		reportStep(" Toggle Not clicked ","Fail");
	}
	return this;
	}
	public EditTwo clickViewAll() throws IOException {
	try {
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		reportStep(" ViewAll clicked Successfully ","pass");
	} catch (Exception e) {
		reportStep(" ViewAll Not clicked ","Fail");
	}
	return this;
	}

	 	public EditTwo scrollElement()
	 	{
	 		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
	 		driver.executeScript("arguments[0].scrollIntoView();", scroll);
	 		return this;
	 	}
		
	 	public EditIndividuals enterIndividual() throws IOException {
	 		try {
				driver.findElement(By.xpath("//p[text()='Individuals']")).click();
				reportStep(" Individuals  Clicked Successfully ","Pass");
			} catch (Exception e) {
				reportStep(" Individuals Not  Clicked "+e,"Fail");
			}
				
	return new EditIndividuals(driver, node);
	}

}
