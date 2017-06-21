package com.raju.practise.Utils;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by vgottumukkala on 09/05/2016.
 */
public class SoftKeys extends DriverHelper{

    public void enter() {
        ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER);
    }
    public void back() {
        ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.BACK);
    }
}
