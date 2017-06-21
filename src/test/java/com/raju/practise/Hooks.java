package com.raju.practise;

import com.raju.practise.driverManager.DriverHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        new DriverHelper().openApp();
    }

    //@After
    public void tearDown(){
        new DriverHelper().killApp();
    }



}
