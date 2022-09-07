import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidTouchAction;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;




public class TestCaseForPlaceOrder extends TestBase {
    PlaceOrderPage placeOrder;

    @Test
    public void placeOrder() throws InterruptedException {
        placeOrder = new PlaceOrderPage(driver);
        action = new AndroidTouchAction(driver);

        Thread.sleep(1000);
        placeOrder.guestMode(action);
        Thread.sleep(1000);
        placeOrder.setAddress(action);
    }


}
