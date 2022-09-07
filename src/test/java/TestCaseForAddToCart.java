
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

    PlaceOrderPage placeOrder;


    @Test(priority = 1)
    public void productAddToCart() throws InterruptedException {
        addToCart = new AddProductsToCartPage(driver);
        action = new AndroidTouchAction(driver);


        Thread.sleep(5000);

        addToCart.clickAccept();
        Thread.sleep(5000);

        addToCart.swipeLeft(action);
        Thread.sleep(1000);

        addToCart.scrollDown(driver, action);
        Thread.sleep(1000);

        addToCart.pressedItem(driver, action);

        addToCart.getSizeAndQuantity(action);

        addToCart.charBtn(action);
        Thread.sleep(1000);

        addToCart.checkOut(action);
        Thread.sleep(1000);


    }


    /*Scenario: 02 Customer successfully place order as a guest user
        Given: Mike go to shopping cart by clicking top cart icon
        When: Mike click checkout button from shopping cart page
        And: Mike select checkout as guest from shopping cart page
        Then: Mike input all the details in checkout billing details page and click continue
        And: Mike select "Next Day Air" as shipping method and click continue
        And: Mike select "Check/Money Order" as payment method and click continue
        And: Mike click next button on payment information page
        Then: Mike click confirm button to place the order
        And: Verify order place successfully with popup message "Your order has been successfully processed!"*/

   @Test(priority = 2)
    public void TestCaseForPlaceOrder() throws InterruptedException {

       placeOrder = new PlaceOrderPage(driver);
        action = new AndroidTouchAction(driver);

        Thread.sleep(1000);
        placeOrder.guestMode(action);
        Thread.sleep(1000);
        placeOrder.setAddress(action);
    }

}
