package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class HomeScreen extends DriverHelper {
    @AndroidFindBy(id="get_started_textview")
    private MobileElement _tapOnGetStarted;

    public void tapOnGetStarted() {
        waitForElement(_tapOnGetStarted).click();
    }
}
