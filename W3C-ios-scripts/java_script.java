
import java.net.URL;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.github.cdimascio.dotenv.Dotenv;
public class Upload extends Thread{
   private static Dotenv dotenv = Dotenv.load();
   public static String userName = dotenv.get("BROWSERSTACK_USERNAME");
   public static String accessKey = dotenv.get("BROWSERSTACK_ACCESS_KEY");
   public static void main(String args[]) throws MalformedURLException, InterruptedException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    browserstackOptions.put("osVersion", "14");
    browserstackOptions.put("deviceName", "iPhone 12");
    browserstackOptions.put("realMobile", "true");
    browserstackOptions.put("projectName", "Sample Test");
    browserstackOptions.put("buildName", "Sample Build");
    browserstackOptions.put("debug", "true");
    capabilities.setCapability("bstack:options", browserstackOptions);
    capabilities.setCapability("appium:nativeWebTap",true);
     IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
     driver.get("https://the-internet.herokuapp.com/upload");
     Thread.sleep(5000);
     driver.findElement(By.id("file-upload")).click();
     driver.context("NATIVE_APP");
     driver.findElement(By.name("Photo Library")).click();
     
     Thread.sleep(5000);
     List list = driver.findElements(By.className("XCUIElementTypeImage"));
    ((IOSElement) list.get(0)).click();
     Thread.sleep(5000);
     driver.findElement(By.name("Choose")).click();
     Set<String> contextName = driver.getContextHandles();
     driver.context(contextName.toArray()[1].toString());
     driver.findElement(By.id("file-submit")).click();
     driver.quit();
  }
}
