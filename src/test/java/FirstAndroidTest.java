import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    AppiumDriver driver;
@BeforeTest
    public void setUp() throws MalformedURLException {
    //Open the app
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("udid", "e6mby9gamfami7be");
    caps.setCapability("platformName", "Android");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("platformVersion", "11");
    caps.setCapability("deviceName", "Megi Mobile");
    caps.setCapability("appPackage", "com.devolo.home_network");
    caps.setCapability("appActivity", "com.devolo.home_network.MainActivity");


    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
}
@Test
    public void installNewDevice(){

    //1. Introduction page click Next button
    driver.findElementByAccessibilityId("Next").click();
    //2. Accept terms and conditions
    driver.findElement(By.className("android.widget.CheckBox")).click();
    //3. Click "Let's start" button
    driver.findElementByAccessibilityId("Let's start").click();
    //4. Permissions page
    driver.findElementByClassName("android.widget.Switch").click();
    driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
    //driver.findElementByAccessibilityId("Location service Required along with location permission to view the Wi-Fi name. We do not use or store your location.").click();
    //driver.findElement(By.id("android:id/button1")).click();
    // Tap Continue button
    driver.findElementByAccessibilityId("Continue").click();
}

@AfterTest
    public void tearDown(){
    if(null != driver){
        driver.quit();
    }
}


}
