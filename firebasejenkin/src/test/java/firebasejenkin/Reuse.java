package firebasejenkin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Reuse {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;

	// Driver Initialization
	public static void InitializeDriver()
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		driver=new ChromeDriver();

	}
	public static void InitializePath()
	{
		
		report = new ExtentReports (System.getProperty("user.dir") +"/test-output/FirebaseReport.html", false); 
	}
	//Launching Browser
	public static void launch(String url,String logfilename)
	{
		driver.get(url);
		driver.manage().window().maximize();
		logger=report.startTest(logfilename);
	}
	/* Name         : findElement
	 * Arguments    : loction:Location of the object
	 *                objName:Name of the object
	 * Created date : 21Mar2019
	 * Last Modified: 21Mar2019
	 * Created		:Shweta Sapare           
	 * */
	public static WebElement findElement(By location,String objName)
	{
		WebElement obj=null;
		try
		{
			obj=driver.findElement(location);
			System.out.println("pass : "+objName+" found on page");
			logger.log(LogStatus.PASS," "+objName+"found on page  ");
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("fail : "+objName+" could not found on page");
			logger.log(LogStatus.FAIL," "+objName+ "could not find on page  ");
			
		}
		return obj;
	}
public static void login() throws InterruptedException
{
	WebElement emailUsername=findElement(By.id("email_field"),"email");
	emailUsername.clear();
	enterText(emailUsername,"email","admin123@gmail.com");
	System.out.println("username entered succesfully");
	WebElement pass=findElement(By.id("password_field"),"password");
	pass.clear();
	enterText(pass,"password","admin123");
	System.out.println("password entered succesfully");
	WebElement loginButton=findElement(By.xpath("//button[@onclick='login()']"),"Login");
	clickButton(loginButton,"Login");
	Thread.sleep(2000);
}
	/* Name         : enterText
	 * Arguments    : obj:Name of the WebElement
	 *                objName:Name of the object(user defined)
	 *                textvale:Text to be entered
	 * Last Modified: 21Mar2019           
	 * */
	public static void enterText(WebElement obj,String objName,String textvalue)
	{
		if(obj==null)
			return;
		if(obj.isDisplayed())
		{
			obj.sendKeys(textvalue);
			System.out.println("pass : "+textvalue+" enter in "+objName);
			logger.log(LogStatus.PASS,"entered succesfully  "+textvalue);
		}
		else
		{
			System.out.println("Fail : "+objName+" could not be bound ");	
			logger.log(LogStatus.FAIL,"Incorrect  "+textvalue);
		}
	}
	//Wait time
	public static void Wait()
	{
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	/*Title :select checkBox
	 * Arguments    : obj:Name of the WebElement
	 *                objName:Name of the object(user defined)
	 *                textvale:Text to be entered
	 * Last Modified: 21Mar2019           
	 * */
	public static void selectCheckBox(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		try {
			if(obj.isDisplayed())
			{
				if(!obj.isSelected())
				{
					obj.click();
				}
				System.out.println("Pass : checkbox "+objName+" selected ");
				logger.log(LogStatus.PASS," "+objName+ "selected ");
			}}
		catch(org.openqa.selenium.NoSuchElementException e)

		{
			System.out.println("Fail "+objName+" Could not be found ");
			logger.log(LogStatus.FAIL," "+objName+" Could not be found");
		}
	}
	public static void selectOptionButton(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		try {
			if(obj.isDisplayed())
			{
				if(!obj.isSelected())
				{
					obj.click();
				}
				System.out.println("Pass : Option button "+objName+" selected ");
				logger.log(LogStatus.PASS," "+objName+ "selected ");
			}
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("Fail "+objName+" Could not be found ");
			logger.log(LogStatus.FAIL," "+objName+" Could not be found");
		}
	}
	/* Name         : clickButton
	 * Arguments    : obj:Name of the WebElement
	 *                objName:Name of the object(user defined)
	 *                textvale:Text to be entered
	 * Last Modified: 21Mar2019           
	 * */
	public static void clickButton(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		try {
			if(obj.isDisplayed())
			{
				obj.click();
				System.out.println("Pass : "+objName+" click ");
				logger.log(LogStatus.PASS," "+objName+"  click ");
			}}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("Fail "+objName+"Could not be found");	
			logger.log(LogStatus.FAIL," "+objName+" Could not be found");
			
		
		}
	}

	//ending report
	public static void EndReport()
	{
		report.endTest(logger);
		report.flush();
		System.out.println("end report");
		driver.quit();
	}
}