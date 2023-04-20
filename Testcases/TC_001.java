package Testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginforAll;
import base.LaunchSalesForceUrl;

public class TC_001 extends LaunchSalesForceUrl{
	@BeforeTest
    public  void setup() 
	{
        excelFile="Login";
        testName="Login Test";
         testDescription=" SalesForce Login";
         testCategory="Smoke";
         testAuthor="Menaka";
    }
	@Test(dataProvider ="getData")
public void runSearch(String username,String password,String lname) throws IOException
{
	LoginforAll login = new LoginforAll(driver, node);
	
	login.enterUserName(username)
	.enterPassWord(password)
	.clickLogin()
	.clickOnToggle()
	.clickViewAll()
	.scrollElement()
	.enterIndividual()
	.clickNewButton()
	.enterLastName(lname)
	.clickSaveButton();
	
}
}
