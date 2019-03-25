package firebasejenkin;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends Reuse
{
	public static void main(String args[]) throws InterruptedException
	{
	System.out.println("hi");
	   InitializeDriver();
		InitializePath();
		launch("https://selenium-prd.firebaseapp.com/","HomeTab");
		System.out.println("Application launched succesfully");
		login();
		WebElement Hometab=findElement(By.xpath("//a[contains(text(),'Home')]"),"Hometab");
		clickButton(Hometab,"Home Tab");
		WebElement name=findElement(By.id("name"),"name");
		enterText(name,"name","shweta");
		WebElement lname=findElement(By.id("lname"),"lastname");
		enterText(lname,"lastname","sapare");
		WebElement postalAddress=findElement(By.id("postaladdress"),"postal code");
		enterText(postalAddress,"postal code","California");
		WebElement personalAddress=findElement(By.id("personaladdress"),"personal address");
		enterText(personalAddress,"personal address","California");
		WebElement gender=findElement(By.xpath("//input[@value='female']"),"gender");
		clickButton(gender,"gender");
		WebElement city=findElement(By.id("city"),"city");
		Select select=new Select(city);
		select.selectByValue("goa");
		Thread.sleep(3000);
		Select course=new Select(findElement(By.name("course"),"course"));
		course.selectByVisibleText("MCA");
		Select district=new Select(findElement(By.id("district"),"district"));
		district.selectByIndex(2);
		Thread.sleep(3000);
		Select state=new Select(findElement(By.id("state"),"state"));
		state.selectByValue("bca");
		WebElement pincodes=findElement(By.id("pincode"),"pincode");
		enterText(pincodes,"pincode","12345");
		WebElement emailid=findElement(By.id("emailid"),"email");
		emailid.sendKeys("shweta@gmail.com");
		Thread.sleep(5000);
		WebElement submit=findElement(By.xpath("//button[@class='bootbutton']"),"submit");
		clickButton(submit,"submit");
		Thread.sleep(5000);
		WebElement switchto=findElement(By.xpath("//button[contains(text(),'Switch To')]"),"switch tab");
		Actions action=new Actions(driver);
		action.moveToElement(switchto).build().perform();
		findElement(By.xpath("//a[contains(text(),'Alert')]"),"Alert").click();
		findElement(By.xpath("//button[contains(text(),'Window Alert')]"),"Window alert").click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();  
		Thread.sleep(3000);
		WebElement prompt=findElement(By.xpath("//button[contains(text(),'Promt Aler')]"),"Prompt Alert");
		clickButton(prompt,"Prompt alert");
		Thread.sleep(4000);
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("shweta");	
		alert.accept();  
		System.out.println(findElement(By.xpath("//*[@id=\"Selenium\"]"),"Prompt Alert msg").getText());
		EndReport();
}
}

