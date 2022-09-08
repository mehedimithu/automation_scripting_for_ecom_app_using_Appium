import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AddProductsToCartPage extends PageBase {
    public AddProductsToCartPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnAccept")
    WebElement acceptBtn;

    @AndroidFindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnPlus")
    AndroidElement getQuantity;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup")
    WebElement clickOnLumia;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
    WebElement selectProductItem;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup[1]")
    WebElement getSize;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
    WebElement getCheckout;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvDone")
    WebElement clickDoneBtn;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")
    WebElement cartBtn;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/menu_cart")
    WebElement cartPage;


    public void clickAccept() {
       // waitForVisibility(acceptBtn);
        click(acceptBtn);
    }


    public void swipeLeft(AndroidTouchAction action) {
        swipeAction(action);
        tabAction(selectProductItem, action);
    }

    public void scrollDown(AppiumDriver driver, AndroidTouchAction action) {
        scrollingAction(driver, action, 0.90,0.02);

    }

    public void pressedItem(AppiumDriver driver, AndroidTouchAction action) {
        tabAction(clickOnLumia, action);
    }


    public void getSizeAndQuantity(AndroidTouchAction action) throws InterruptedException {
        tabAction(getQuantity, action);
        tabAction(getSize, action);
        List<MobileElement> getSize = driver.findElements(By.className("android.widget.RadioButton"));
        getSize.get(1).click();
        Thread.sleep(2000);
        tabAction(clickDoneBtn, action);
    }

    public void charBtn(AndroidTouchAction action) {
        tabAction(cartBtn, action);
        //Get to Shopping cart
        tabAction(cartPage, action);

    }

    public  void  checkOut(AndroidTouchAction action){
        tabAction(getCheckout, action);
    }


}
