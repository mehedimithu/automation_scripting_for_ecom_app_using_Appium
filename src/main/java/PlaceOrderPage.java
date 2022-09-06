import io.appium.java_client.AppiumDriver;


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

public class PlaceOrderPage extends  PageBase{
    public PlaceOrderPage(AppiumDriver driver) {
        super(driver);
    }


}
