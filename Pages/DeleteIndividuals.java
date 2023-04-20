package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.LaunchSalesForceUrl;

public class DeleteIndividuals extends LaunchSalesForceUrl{
	public DeleteIndividuals(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	
	}
	public DeleteIndividuals clickSearch()
	{
		WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		driver.executeScript("arguments[0].click();", clk);
		return this;
	}
	public DeleteIndividuals enterSearch(String lname) throws InterruptedException
	{
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(lname);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	
	public DeleteIndividuals clickFirstLink() throws InterruptedException
	{
	driver.findElement(By.xpath("(//span[contains(@class,'spread forceInlineEditCell')])[1]")).click();
	Thread.sleep(3000);
	return this;
	}
	public DeleteIndividuals clickforDelete() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='Delete']")).click();
		/*
		 * String msg =
		 * driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).
		 * getText(); System.out.println(msg);
		 */
		Thread.sleep(3000);
		return this;
		
	}
	public DeleteIndividuals clickPopUp()
	{
		WebElement pop = driver.findElement(By.xpath("//span[text()='Delete']"));
		driver.executeScript("arguments[0].click();", pop);
		return this;
		
	}
	public  DeleteIndividuals verifyDeleted(String lname) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(lname,Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		System.out.println(verify);
		return this;
	}


}
