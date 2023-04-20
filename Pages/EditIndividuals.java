package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.LaunchSalesForceUrl;

public class EditIndividuals extends LaunchSalesForceUrl{
	
	public EditIndividuals(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	
	}
	public EditIndividuals clickSearch()
	{
		WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		driver.executeScript("arguments[0].click();", clk);
		return this;
	}
	public EditIndividuals enterSearch(String lname) throws InterruptedException
	{
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(lname);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	
	public EditIndividuals clickFirstLink() throws InterruptedException
	{
	driver.findElement(By.xpath("(//span[contains(@class,'spread forceInlineEditCell')])[1]")).click();
	Thread.sleep(3000);
	return this;
	}
	public EditforSalutation clickEditButton()
	{
		driver.findElement(By.xpath("//div[text()='Edit']")).click();
		return new EditforSalutation(driver,node);
	}
}
