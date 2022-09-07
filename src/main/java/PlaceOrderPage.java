import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class PlaceOrderPage extends PageBase {
    public PlaceOrderPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")
    WebElement checkoutBtnAsGuest;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etFirstName")
    WebElement setFastName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etLastName")
    WebElement setLastName;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")
    WebElement setCompanyName;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")
    WebElement countrySpinner;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etCity")
    WebElement setCityName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")
    WebElement setStreetAddress;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etZipCode")
    WebElement setZipCode;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etPhone")
    WebElement setPhone;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement btnContinue;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText")
    WebElement setEmail;


    public void guestMode(AndroidTouchAction action) {
        waitForVisibility(checkoutBtnAsGuest);
        click(checkoutBtnAsGuest);
       // tabAction(checkoutBtnAsGuest, action);

    }

    public void setAddress(AndroidTouchAction action) throws InterruptedException {
        clear(setFastName);
        tabAction(setFastName, action);
        setFastName.sendKeys("Mehedi");

        clear(setLastName);
        tabAction(setLastName, action);
        setLastName.sendKeys("Hasan");

        clear(setEmail);
        tabAction(setEmail, action);
        setEmail.sendKeys("m.mehedi@riseuplabs.com");

        driver.hideKeyboard();

        scrollingAction(driver, action, 0.100, 0.01);
        Thread.sleep(3000);

        clear(setCompanyName);
        tabAction(setCompanyName, action);
        setCompanyName.sendKeys("Riseup Labs");

        clear(setCityName);
        tabAction(setCityName, action);
        setCityName.sendKeys("Dhaka");


        clear(setStreetAddress);
        tabAction(setStreetAddress, action);
        setStreetAddress.sendKeys("Dhaka");


        clear(setZipCode);
        tabAction(setZipCode, action);
        setZipCode.sendKeys("1207");


        clear(setPhone);
        tabAction(setPhone, action);
        setPhone.sendKeys("01755525571");

        Thread.sleep(2000);
        tabAction(btnContinue, action);


    }


}
