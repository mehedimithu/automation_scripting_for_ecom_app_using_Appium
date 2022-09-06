import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public AndroidDriver driver;

    public AppiumDriverLocalService service;
    public DesiredCapabilities capabilities;
    public boolean canScrollMore;
    public DeviceRotation deviceRotation;
    public Activity activity;

    @BeforeTest
    public void Android_SetUp() throws MalformedURLException {

      /*  service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        //Appium Server start
        service.start();*/

        capabilities = new DesiredCapabilities();

        URL uri = new URL("http://127.0.0.1:4723/wd/hub/");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "sdk_gphone64_arm64");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "sources_file/nopstationCart_4.40.apk");

        /*caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", ".ApiDemos");*/

        driver = new AndroidDriver(uri, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        //Appium server stopped
        //service.stop();
    }
}
