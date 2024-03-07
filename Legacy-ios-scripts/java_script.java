import java.net.URL;
import java.util.List;
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
     DesiredCapabilities caps = new DesiredCapabilities();
     caps.setCapability("device", "iPhone 12 Pro Max");
     caps.setCapability("os_version", "14");
     caps.setCapability("real_mobile", "true");
     caps.setCapability("project", "My First Project");
     caps.setCapability("build", "My First Build");
     caps.setCapability("name", "Bstack-[Java] Sample Test");
     caps.setCapability("nativeWebTap", "true");
     IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
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
