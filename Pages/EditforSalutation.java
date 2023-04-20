package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.LaunchSalesForceUrl;

public class EditforSalutation extends LaunchSalesForceUrl{
	public EditforSalutation(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	
	}
	public EditforSalutation clickSelect()
	{
		driver.findElement(By.xpath("//a[@class='select']")).click();
		return this;
	}
	
	public EditforSalutation selectSalutation()
	{
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		return this;
	
	}
	public EditforSalutation enterFirstName(String fname)
	{
		driver.findElement(By.xpath("//input[contains(@class,'firstName compoundBorder')]")).sendKeys(fname);
		return this;
	}
	public EditforSalutation clickSave()
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return this;
	}
	public EditforSalutation verifyEdit()
	{
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(msg);
		return this;
	}
}
