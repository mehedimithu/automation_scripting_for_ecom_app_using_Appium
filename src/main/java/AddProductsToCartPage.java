import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddProductsToCartPage extends PageBase {
    public AddProductsToCartPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnAccept")
    MobileElement popupScreen;

    public  void clickAcceptBtn(){
        click(popupScreen);
    }


}
