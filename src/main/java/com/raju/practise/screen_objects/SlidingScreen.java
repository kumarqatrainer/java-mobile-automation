package com.raju.practise.screen_objects;

import com.raju.practise.Utils.SoftKeys;
import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


public class SlidingScreen extends DriverHelper {

    @AndroidFindBy(id = "menu_search")
    private MobileElement _tapOnSearch;

    @AndroidFindAll(@AndroidFindBy(id = "slidingmenu_sectionitem_label"))
    private List<MobileElement> _slidingMenuCategories;


    public MainScreen goToShopRiverIsLand() {
        _slidingMenuCategories.get(0).click();
        return new MainScreen();
    }


    public CategoryScreen goToWoman() {
        _slidingMenuCategories.get(2).click();
        return new CategoryScreen();
    }


    public void goToMenu() {
        _slidingMenuCategories.get(4).click();

    }

    public void goToGirls() {
        _slidingMenuCategories.get(6).click();

    }

    public void goToBoys() {
        _slidingMenuCategories.get(8).click();

    }

    public void goToStoreLocators() {
        _slidingMenuCategories.get(10).click();

    }

    public void goToCheckIn() {
        _slidingMenuCategories.get(12).click();

    }

    public void goToScanInStore() {

    }


    public void tapOnMenuAndEnterSearchTerm(String term) {
        _tapOnSearch.sendKeys(term);
        new SoftKeys().enter();
    }


    public void goToMyWishList() {
        waitForElement(_slidingMenuCategories.get(9)).click();
    }
}
