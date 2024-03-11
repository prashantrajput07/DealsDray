package FunctionalTesting;

import java.awt.AWTException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest{
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.dealsdray.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='reorder']/following-sibling::span[text()='Order']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/mis/orders']//button[@name='child']")).click();
	    Thread.sleep(2000);
	    WebElement element  =driver.findElement(By.xpath("//button[normalize-space()='Add Bulk Orders']"));
	    Thread.sleep(2000);
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element);
	    Thread.sleep(2000);
	   

	    WebElement element1 = driver.findElement(By.xpath("//input[@type='file']"));
	   // JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element1);

	   //executor.executeScript("arguments[0].click();", element1);
	   Thread.sleep(2000);
	    Robot rb= new Robot();
	    StringSelection str=new StringSelection("C:\\Users\\Lenovo\\Downloads\\demo-data.xlsx");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
	    
	    
	   TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/ss.png");
		try 
		{
			Files.copy(src, dest);
			System.out.println("Screenshot successfully");
		}
		catch (IOException e)
		{
		}
	    
	  
	    
	    
	  
}
}
