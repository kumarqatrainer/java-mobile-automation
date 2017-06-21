package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class CheckOutScreen extends DriverHelper {

    @AndroidFindBy(id = "android.widget.TextView")
    private MobileElement _checkOutScreen;
}
