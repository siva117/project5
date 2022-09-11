package testNg;


import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.DataUtil;



public class TestNgPract {

	
	
	
	
	
   	@Parameters({"browser","env"})
	   @Test
	    public void tc1(@Optional String browser,String Environment) throws InterruptedException {
			System.out.println(Environment);
			DataUtil dt =new DataUtil();
			HashMap<String,String>envdata=dt.getPropertiesData(dt.getEnvConfigFile(Environment));
			    
		  Driver driver = new Driver(browser);
		  driver.navigate(envdata.get("url"));
		  
		  driver.get().findElement(By.xpath("//input [@type='text']")).sendKeys(envdata.get("username"));
		  driver.get().findElement(By.xpath("//input[@type='password']")).sendKeys(envdata.get("password"));
		  driver.get().findElement(By.xpath("//div[text()='Login']")).click();
		  
		  Thread.sleep(3000);
		  driver.closeallWindows();

   	}
   	@Parameters({"browser","env"})
	   @Test
	
   	public void tc2(@Optional String browser,String Environment) throws InterruptedException {
		System.out.println(Environment);
		DataUtil dt =new DataUtil();
		HashMap<String,String>envdata=dt.getPropertiesData(dt.getEnvConfigFile(Environment));
	
		  Driver driver = new Driver(browser);
		  driver.navigate(envdata.get("url"));
		  
		  driver.get().findElement(By.xpath("//a[text()='Sign Up']")).click();
		  driver.get().findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(envdata.get("username"));
	      driver.get().findElement(By.xpath("//button[@name='action']")).click();
	       
		  Thread.sleep(10000);
		  driver.closeallWindows();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}}
