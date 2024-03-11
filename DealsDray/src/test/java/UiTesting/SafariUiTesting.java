package UiTesting;


import java.io.File;
 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
 
public class SafariUiTesting{
    public static void main(String[] args) {
     
    	WebDriver safariDriver = new SafariDriver();
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
         
        	safariDriver.manage().window().setSize(resolution);
        	safariDriver.get(url);
            String fileName = "./screenshot" + resolution.getWidth() + "x" + resolution.getHeight() + ".png";
            ((TakesScreenshot) safariDriver).getScreenshotAs(OutputType.FILE)
                .renameTo(new File(fileName));
        }
        safariDriver.quit();
    }
    
    
}
 
