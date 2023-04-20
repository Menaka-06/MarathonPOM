package Testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginForDelete;
import base.LaunchSalesForceUrl;

public class TC_003 extends LaunchSalesForceUrl{
	@BeforeTest
    public  void setup() 
	{
        excelFile="delete";
        testName="Delete Individual Test";
         testDescription=" SalesForce Login";
         testCategory="Smoke";
         testAuthor="Menaka";
    }
	@Test(dataProvider ="getData")
	public void runDelete(String uname,String password,String lname,String lname2) throws InterruptedException, IOException
	{
		LoginForDelete del = new LoginForDelete(driver, node);
		del.enterUserName(uname)
		.enterPassWord(password)
		.clickLogin()
		.clickOnToggle()
		.clickViewAll()
		.scrollElement()
		.enterIndividual()
		.clickSearch()
		.enterSearch(lname)
		.clickFirstLink()
		.clickforDelete()
		.clickPopUp()
		.verifyDeleted(lname2);
		
		
	}

}
