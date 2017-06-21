package com.raju.practise.screen_objects;

import org.json.simple.JSONObject;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class BasketScreen extends DriverHelper {

    public static String ProductNameInBasket;

    @AndroidFindBy(id = "menu_basket")
    private MobileElement _BasketBtn;
    @AndroidFindBy(id = "basket_list_name")
    private MobileElement _productNameLbl;
    @AndroidFindBy(id = "basket_list_cost")
    private MobileElement _priceLbl;
    @AndroidFindBy(id = "basket_list_increase_quantity")
    private MobileElement _basketQuantityIncrease;
    @AndroidFindBy(id = "basket_list_decrease_quantity")
    private MobileElement _basketQuantityDecrease;
    @AndroidFindBy(id = "basket_promo_code")
    private MobileElement _basketPromoCode;
    @AndroidFindBy(id = "basket_addtobag_button")
    private MobileElement _basketAddtobagButton;
    @AndroidFindBy(id = "basket_list_quantity")
    private MobileElement _basketListQuantity;
    @AndroidFindBy(id = "noMessagesText")
    private MobileElement _noMessagesText;

    @AndroidFindBy(id = "basket_list_size")
    private MobileElement _sizeLbl;

    public void tapOnBacketMenuBtn() {
        waitForElement(_BasketBtn).click();
    }

    @SuppressWarnings("unchecked")
	public JSONObject getProductDetails() {
        JSONObject json = new JSONObject();
        json.put("name", _productNameLbl.getText().toLowerCase());
        json.put("price", _priceLbl.getText().replace("£", ""));
        json.put("size", _sizeLbl.getText());
        return json;
    }


}
