
import io.appium.java_client.android.AndroidTouchAction;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;


/* Scenario: 01 Customer add products in his shopping cart
        Given: Mike on home page after opening nopCart mobile app
        When: Mike click "electronics" from our categories list from home page
        And: Mike click to "Nokia Lumia 1020" product details page
        Then: Mike select size "Large" from product details page
        And: Mike click plus button to increase Qty by "2"
        Then: Mike click add to cart button to add the product in his cart */

public class TestCaseForAddToCart extends TestBase {
    AddProductsToCartPage addToCart;
    PlaceOrderPage placeOrder;

    @DataProvider(name = "User Info")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data_source/user_info.json",
                "User Info", 9);
    }

    @Test(priority = 1)
    public void productAddToCart() throws InterruptedException {
        addToCart = new AddProductsToCartPage(driver);
        action = new AndroidTouchAction(driver);

        Thread.sleep(6000);
        addToCart.clickAccept();
        Thread.sleep(6000);

        addToCart.swipeLeft(action);
        Thread.sleep(2000);

        addToCart.scrollDown(driver, action);
        Thread.sleep(3000);
        addToCart.pressedItem(driver, action);

        addToCart.getSizeAndQuantity(action);
        addToCart.charBtn(action);
        Thread.sleep(2000);

        addToCart.checkOut(action);
        Thread.sleep(2000);
        System.out.println("Test Case For  Product Add To Cart Passed!");
    }


    /* Scenario: 02 Customer successfully place order as a guest user
        Given: Mike go to shopping cart by clicking top cart icon
        When: Mike click checkout button from shopping cart page
        And: Mike select checkout as guest from shopping cart page
        Then: Mike input all the details in checkout billing details page and click continue
        And: Mike select "Next Day Air" as shipping method and click continue
        And: Mike select "Check/Money Order" as payment method and click continue
        And: Mike click next button on payment information page
        Then: Mike click confirm button to place the order
        And: Verify order place successfully with popup message "Your order has been successfully processed!"*/

    @Test(priority = 2, dataProvider = "User Info")
    public void TestCaseForPlaceOrder(String firstName, String lastName, String email, String company, String city, String streetAddress, String streetAddress2,  String zipCode, String phoneNumber) throws InterruptedException {

        placeOrder = new PlaceOrderPage(driver);
        action = new AndroidTouchAction(driver);

        Thread.sleep(2000);
        placeOrder.guestMode(action);
        Thread.sleep(2000);
        placeOrder.setAddress(action, firstName, lastName, email, company, city, streetAddress, streetAddress2, zipCode, phoneNumber);
        Thread.sleep(2000);
        placeOrder.shippingDetails(action);
        Thread.sleep(2000);
        placeOrder.payment(action);
        Thread.sleep(3000);
        placeOrder.confirm(action);
        Thread.sleep(1000);


    }
}
