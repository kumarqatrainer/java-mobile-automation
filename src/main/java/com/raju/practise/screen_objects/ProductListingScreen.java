package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductListingScreen extends DriverHelper {


    //Change webelement to mobile element
    @AndroidFindAll(@AndroidFindBy(id = "product_grid_main_image"))
    private List<WebElement> _selectProduct;

    @AndroidFindAll(@AndroidFindBy(id = "android.widget.TextView"))
    private List<MobileElement> _selectCategory;

    @AndroidFindBy(id = "checkout_login_quick_checkout")
    private MobileElement _ShopAll;


    public ProductListingScreen selectAnyProduct() {
        waitForElements(_selectProduct).get(1).click();
        return new ProductListingScreen();
    }

    public ProductListingScreen selectAnotherProduct() {
        waitForElements(_selectProduct).get(2).click();
        return new ProductListingScreen();
    }
}
