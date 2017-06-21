package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class RecentlyViewed extends DriverHelper {

    @AndroidFindBy(id = "recently_viewed_title")
    private MobileElement _recentlyViewedTitle;
    @AndroidFindBy(id = "recently_viewed_list_name")
    private MobileElement _recentlyViewedListName;
    @AndroidFindBy(id = "menu_delete_recently_viewed")
    private MobileElement _deleteRecentlyViewedBtn;
    @AndroidFindBy(id = "button1")
    private MobileElement _confirm;
    @AndroidFindBy(id = "button2")
    private MobileElement _cancel;
    @AndroidFindBy(id = "recently_viewed_empty_text")
    private MobileElement _recentlyViewedEmptyText;
}
