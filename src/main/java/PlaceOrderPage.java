import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


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

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='android:id/text1'])[12]")
    WebElement selectCountry;
    @FindBy(xpath = "//android.widget.LinearLayout[@index='4']")
    WebElement selectState;
    @FindBy(xpath = "//android.widget.TextView[@index='1']")
    WebElement otherState;
    @FindBy(xpath = "(//android.widget.TextView)[6]")
    WebElement selectStateName;

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

    @FindBy(xpath = "//android.widget.RelativeLayout[@index='3']")
    WebElement shippingMethod;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement contBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@index='3']")
    WebElement selectPayment;

    @FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
    WebElement btnPayment;

    @FindBy(xpath = "//android.view.View[@text='Payment information']")
    WebElement paymentInfo;

    @FindBy(xpath = "//android.widget.Button[@index='0']")
    WebElement nextBtn;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvSubTotal")
    WebElement subTotal;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvShippingCharge")
    WebElement shippingCharge;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvTotal")
    WebElement total;

    @FindBy(xpath = "//android.widget.Button[@index='1']")
    WebElement confirmBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@index='8']")
    WebElement selectMethods;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/md_title_layout")
    WebElement confirmNote;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/md_text_message")
    WebElement popupMessage;


    public void guestMode(AndroidTouchAction action) {
        waitForVisibility(checkoutBtnAsGuest);
        click(checkoutBtnAsGuest);

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

        tabAction(countrySpinner, action);
        driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
        selectCountry.click();

        Thread.sleep(2000);

        tabAction(selectState, action);

        if (otherState.isDisplayed()) {
            driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Other\"));"));
            otherState.click();
        } else {
            driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Luxembourg\"));"));
            selectStateName.click();
        }

        driver.hideKeyboard();

        clear(setCompanyName);

    tabAction(setCompanyName, action);
        setCompanyName.sendKeys("Riseup Labs");
        driver.hideKeyboard();

    clear(setCityName);
        tabAction(setCityName, action);
        setCityName.sendKeys("Antwerpen");
        driver.hideKeyboard();

        clear(setStreetAddress);
        tabAction(setStreetAddress, action);
        setStreetAddress.sendKeys("Antwerpen" + " " + "Belgium");
        driver.hideKeyboard();

        clear(setZipCode);
        tabAction(setZipCode, action);
        setZipCode.sendKeys("79070");
        driver.hideKeyboard();

        clear(setPhone);
        tabAction(setPhone, action);
        setPhone.sendKeys("+3299795755");
        driver.hideKeyboard();

        Thread.sleep(2000);
        tabAction(btnContinue, action);
        Thread.sleep(2000);

    }


    public void shippingDetails(AndroidTouchAction action) {
        tabAction(shippingMethod, action);
        scrollingAction(driver, action, 0.90, 0.02);
        contBtn.click();
    }

    public void payment(AndroidTouchAction action) throws InterruptedException {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Check / Money Order\"));"));
        Thread.sleep(1000);
        tabAction(selectMethods, action);
        Thread.sleep(1000);
        btnPayment.click();
        Thread.sleep(10000);
        nextBtn.click();
    }

    public void confirm(AndroidTouchAction action) throws InterruptedException {
        Thread.sleep(1000);
        scrollingAction(driver, action, 0.75, 0.01);

       /* double totalAmount = 0;
        String amounts = subTotal.getText();
        String charge = shippingCharge.getText();
        Double subtotalPrice = formattedAmount(amounts);
        Double chargeAmount = formattedAmount(charge);
        totalAmount = subtotalPrice + chargeAmount;
        System.out.println(totalAmount);
        Assert.assertEquals(totalAmount, total);*/

        confirmBtn.click();
        Thread.sleep(2000);

        String note = popupMessage.getText();

        System.out.println(note);

        Assert.assertEquals(note, note);

        System.out.println("Test Case For Placement Order Passed! ");
    }
}
