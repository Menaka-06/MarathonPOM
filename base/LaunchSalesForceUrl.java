package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LaunchSalesForceUrl {
	public ChromeDriver driver;
	public String excelFile;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String testName,testDescription,testCategory,testAuthor;
	@BeforeSuite
	public void startReport()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reportforsalesforce/result.html");
		//reporter.setAppendExisting(true);
		extent =new ExtentReports();
		extent.attachReporter(reporter);
	}
	@AfterSuite
	public void stopReport()
	{
		extent.flush();
	}
	@BeforeClass
	public void testDetails()
	{
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	public int takeSnap() throws IOException
	{
		int random=(int)(Math.random()*99999+10000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snapforsalesforce/img"+random+".png");
		FileUtils.copyFile(source, desc);
		return random;
	}
	public void reportStep(String stepDesc, String status) throws IOException
	{
		if(status.equalsIgnoreCase("pass"))
		{
			node.pass(stepDesc, MediaEntityBuilder.createScreenCaptureFromPath(".././snapforsalesforce/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			node.fail(stepDesc, MediaEntityBuilder.createScreenCaptureFromPath(".././snapforsalesforce/img"+takeSnap()+".png").build());
		}
	}
	
	
	@BeforeMethod
	public void launchBrowser()
	{
		node = test.createNode(testName);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}

	@DataProvider(name="getData")
	public String[][] getData() throws IOException {
		String[][] inputSalesForce = Utils.ReadInput.inputData(excelFile);
		return inputSalesForce;
	}
}
