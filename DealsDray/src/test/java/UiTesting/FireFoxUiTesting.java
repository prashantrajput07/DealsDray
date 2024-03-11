package UiTesting;
 
import java.io.File;
 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

 
public class FireFoxUiTesting{
    public static void main(String[] args) {
     
    	WebDriver firefoxDriver = new FirefoxDriver();
    	firefoxDriver.manage().window().maximize();
        String url = "https://www.getcalley.com/page-sitemap.xml";
           Dimension[] resolutions = {
            new Dimension(1920, 1080),
            new Dimension(1366, 768),
            new Dimension(1536, 864),
            new Dimension(360, 640),
            new Dimension(414, 896),
            new Dimension(378, 667)
        };
           
       
        for (Dimension resolution : resolutions) {
         
        	firefoxDriver.manage().window().setSize(resolution);
        	firefoxDriver.get(url);
            String fileName = "./screenshot" + resolution.getWidth() + "x" + resolution.getHeight() + ".png";
            ((TakesScreenshot) firefoxDriver).getScreenshotAs(OutputType.FILE)
                .renameTo(new File(fileName));
        }
        firefoxDriver.quit();
    }
    
    
}
 