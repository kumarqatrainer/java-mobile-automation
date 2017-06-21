package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


public class MainScreen extends DriverHelper {

    @AndroidFindBy(id="home_slidingmenu")
    private MobileElement _tapOnSlidingMenu;
    @AndroidFindBy(id="menu_basket")
    private MobileElement _menuBasket;
    @AndroidFindAll(@AndroidFindBy(className="android.widget.Button"))
    private List<MobileElement> _mainScreenButtons;

    public void tapOnMenu() {
        waitForElement(_tapOnSlidingMenu).click();
    }

}
