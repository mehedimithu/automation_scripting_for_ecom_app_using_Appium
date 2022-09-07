
import io.appium.java_client.android.AndroidTouchAction;
import org.testng.annotations.Test;


/*Scenario: 01 Customer add products in his shopping cart
        Given: Mike on home page after opening nopCart mobile app
        When: Mike click "electronics" from our categories list from home page
        And: Mike click to "Nokia Lumia 1020" product details page
        Then: Mike select size "Large" from product details page
        And: Mike click plus button to increase Qty by "2"
        Then: Mike click add to cart button to add the product in his cart*/

public class TestCaseForAddToCart extends TestBase {
    AddProductsToCartPage addToCart;


    @Test
    public void productAddToCart() throws InterruptedException {
        addToCart = new AddProductsToCartPage(driver);
        action = new AndroidTouchAction(driver);

        Thread.sleep(2000);

        addToCart.clickAccept();
        Thread.sleep(1000);

        addToCart.swipeLeft(action);
        Thread.sleep(3000);

        addToCart.scrollDown(driver, action);
        Thread.sleep(1000);

        addToCart.pressedItem(driver, action);

        addToCart.getSizeAndQuantity(action);

        addToCart.charBtn(action);
        Thread.sleep(1000);

        addToCart.checkOut(action);
        Thread.sleep(1000);

    }

}
