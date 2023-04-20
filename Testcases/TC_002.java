package Testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginForEdit;
import base.LaunchSalesForceUrl;

public class TC_002 extends LaunchSalesForceUrl{
	@BeforeTest
    public  void setup() 
	{
        excelFile="editsalutation";
        testName="Edit Test";
        testDescription="Edit Individual ";
        testCategory="Smoke";
        testAuthor="Menaka";
    }
	@Test(dataProvider ="getData")
	public void runEditIndividuals(String uname,String password,String lname,String slname,String fname) throws IOException, InterruptedException {
		LoginForEdit run = new LoginForEdit(driver, node);
		run.enterUserName(uname)
		.enterPassWord(password)
		.clickLogin()
		.clickOnToggle()
		.clickViewAll()
		.scrollElement()
		.enterIndividual()
		.clickSearch()
		.enterSearch(lname)
		.clickFirstLink()
		.clickEditButton()
		.clickSelect()
		.selectSalutation()
		.enterFirstName(fname)
		.clickSave()
		.verifyEdit();
		}}
