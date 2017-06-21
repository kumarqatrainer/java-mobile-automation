package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


public class ProductListCategory extends DriverHelper {

    @AndroidFindBy(id = "product_list_category_text")
    private MobileElement _productListCategoryText;
    @AndroidFindBy(id = "product_list_category_items_quantity")
    private MobileElement _count;
    @AndroidFindBy(id = "action_filter_sort")
    private MobileElement _actionFilterSort;
    @AndroidFindBy(id = "product_list_filter")
    private MobileElement _productListFilterBtn;
    @AndroidFindBy(id = "product_list_sort")
    private MobileElement _productListSortBtn;
    @AndroidFindAll(@AndroidFindBy(id = "android.widget.RelativeLayout\n"))
    private MobileElement ProductListFilters;
    @AndroidFindBy(id = "filter_fragment_clear_button")
    private MobileElement _clearBtn;
    @AndroidFindBy(id = "product_list_sort")
    private MobileElement _applyFilterBtn;
    @AndroidFindBy(id = "best_selling_layout")
    private MobileElement _relevantBtn;
    @AndroidFindBy(id = "high_to_low_layout")
    private MobileElement highToLowBtn;
    @AndroidFindBy(id = "low_to_high_layout")
    private MobileElement _lowToHighBtn;
    @AndroidFindAll(@AndroidFindBy(id = "row_filter_list_fragment_checkbox"))
    private List<MobileElement> _checkBoxes;
    @AndroidFindBy(id = "filter_search_edittext")
    private MobileElement _filterSearchTxt;
    @AndroidFindBy(id = "list_transaction_button")
    private MobileElement _gridViewBtn;
    @AndroidFindBy(id = "product_grid_cost")
    private MobileElement _productGridCost;
    @AndroidFindBy(id = "product_list_cost")
    private MobileElement _productListCost;




}
