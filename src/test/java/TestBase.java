import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public AppiumDriver driver;

    public AndroidTouchAction action;
    public AppiumDriverLocalService service;

    public DesiredCapabilities caps;
    public boolean canScrollMore;
    public DeviceRotation deviceRotation;
    public Activity activity;

    @BeforeClass
    public void Android_SetUp() throws MalformedURLException {

      /*  service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        //Appium Server start
        service.start();*/

        caps = new DesiredCapabilities();

        URL uri = new URL("http://127.0.0.1:4723/wd/hub/");

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "sdk_gphone64_arm64");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", System.getProperty("user.dir") + "/sources_file/nopstationCart_4.40.apk");

        /*caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", ".ApiDemos");*/

        driver = new AppiumDriver(uri, caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        if (null != driver) {
           driver.quit();
        }

        //Appium server stopped
        //service.stop();
    }
}
