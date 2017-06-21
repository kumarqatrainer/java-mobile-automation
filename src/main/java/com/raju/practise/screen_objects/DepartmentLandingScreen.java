package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


public class DepartmentLandingScreen extends DriverHelper {

    @AndroidFindBy(id = "category_title")
    private MobileElement _categoryTitle;
    @AndroidFindBy(id = "category_search")
    private MobileElement _categorySearch;
    @AndroidFindAll(@AndroidFindBy(id = "category_row_text"))
    private List<MobileElement> _categoryRows;




}
