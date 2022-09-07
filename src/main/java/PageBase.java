import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    AppiumDriver driver;
    WebDriverWait wait;

    public boolean canScrollMore;

    public PageBase(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

        this.driver = driver;
    }

    public void waitForVisibility(WebElement element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void tabAction(WebElement element, AndroidTouchAction action) {
        action.tap(ElementOption.element(element)).perform();
    }


    public void swipeAction(AndroidTouchAction action) {
        List<MobileElement> categoriesItem = driver.findElements(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.nopstation.nopcommerce.nopstationcart:id/ivProductThumb\")"));
        MobileElement firstElement = categoriesItem.get(0);
        MobileElement desireElement = categoriesItem.get(6);
        int midOfYCoordinate = firstElement.getLocation().y + (firstElement.getSize().height / 2);
        int firstElementXCoordinate = firstElement.getLocation().x;
        int sixElementXCoordinate = desireElement.getLocation().x;

        action.press(PointOption.point(sixElementXCoordinate, midOfYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(15)))
                .moveTo(PointOption.point(firstElementXCoordinate, midOfYCoordinate))
                .release().perform();

//        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", direction,
//                "percent", 1.00
//        ));

    }

    public void setText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }



    public void scrollToEnd() {
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.builder()
                            .put("left", 100)
                            .put("top", 100)
                            .put("width", 200)
                            .put("height", 200)
                            .put("direction", "down")
                            .put("percent", 3.0)
                            .build());


        } while (canScrollMore);
    }
    public void scrollDown() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nokia Lumia 1020\"));"));
    }


    static void scrollingAction(AppiumDriver driver, AndroidTouchAction action, double start, double end) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * start);
        int scrollEnd = (int) (dimension.getHeight() * end);
        action.press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public Double  formattedAmount(String amount){
        Double totalPrice = Double.parseDouble(amount.substring(1));
        return totalPrice;
    }
}
