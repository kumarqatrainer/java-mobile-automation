package com.raju.practise.screen_objects;

import com.raju.practise.Utils.SoftKeys;
import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.json.simple.JSONObject;

import java.util.List;


public class WishListScreen extends DriverHelper {

    public String SizeTxt;
    public static String ProductNameInWishList;
    @AndroidFindBy(id = "wishlist_item_name")
    private MobileElement _productTxtView;
    @AndroidFindBy(id = "price")
    private MobileElement _priceTxtView;
    @AndroidFindBy(id = "fake_spinner")
    private MobileElement _sizeTxtView;
    @AndroidFindAll(@AndroidFindBy(id = "title"))
    private List<MobileElement> _editTxtView;
    @AndroidFindBy(id = "action_overflow_wishlist")
    private MobileElement _overflowTxtView;
    @AndroidFindAll(@AndroidFindBy(id = "size_label"))
    private List<MobileElement> _sizeLbl;
    @AndroidFindBy(id = "size_label")
    private MobileElement _sizeLblInWishList;
    @AndroidFindAll(@AndroidFindBy(id = "title"))
    private List<MobileElement> _editWishList;
    @AndroidFindAll(@AndroidFindBy(id = "remove_icon"))
    private List<MobileElement> _deleteProduct;
    @AndroidFindBy(id = "wishlist_quantity_text")
    private MobileElement _wishListQuantity;
    @AndroidFindBy(id = "button1")
    private MobileElement _clearYesBtn;
    @AndroidFindBy(id = "add_to_bag")
    private MobileElement _addToBag;
    @AndroidFindBy(id = "empty_wishlist_no_items_text")
    private MobileElement _noItemsWishListTxt;


    @SuppressWarnings("unchecked")
	public JSONObject getProductDetails() {
        JSONObject json = new JSONObject();
        json.put("name", _productTxtView.getText().toLowerCase());
        json.put("price", _priceTxtView.getText().replace("£", ""));
        json.put("size", _sizeTxtView.getText());
        return json;
    }

    public String editSizeInWishlist() {
        waitForElement(_sizeTxtView).click();
        if (_sizeLbl.size() == 1)
            SizeTxt = _sizeLbl.get(0).getText();
        else if (_sizeLbl.size() > 1) {
            SizeTxt = _sizeLbl.get(0).getText();
        }
        return SizeTxt;
    }

    public String ddlSelectedProductSize() {
        return waitForElement(_sizeLbl.get(1)).getText();

    }

    public String getSizeinWishList() {
        return waitForElement(_sizeLblInWishList).getText();
    }

    public void tapOnBackButton() {
        new SoftKeys().back();
    }

    public void tapOnEditToDeleteProductInWishList() {
        waitForElement(_overflowTxtView).click();
        _editWishList.get(0).click();
        _deleteProduct.get(0).click();
    }

    public String numberOfProductsDisplayedInWishList() {
        return waitForElement(_wishListQuantity).getText().replace(" ITEM", "");
    }

    public void clearAllProducts() {
        waitForElement(_overflowTxtView).click();
        _editWishList.get(1).click();
        _clearYesBtn.click();
    }

    public String wishListIsEmpty() {
        return waitForElement(_wishListQuantity).getText().replace(" ITEMS", "");
    }

    public WishListScreen addProductToBag() {
        waitForElement(_addToBag).click();
        return this;
    }


    public boolean noItemsWishListTextDisplayed() {
        System.out.println("noItemsWishListTxt :" +  waitForElement(_noItemsWishListTxt).getText());
       return  waitForElement(_noItemsWishListTxt).getText().matches("YOU HAVE NO ITEMS IN YOUR WISH LIST");
    }
}
