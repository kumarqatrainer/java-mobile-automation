package com.raju.practise.screen_objects;

import com.raju.practise.driverManager.DriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AddToBagScreen extends DriverHelper {



    public JSONObject  productDetails;

    @AndroidFindBy(id = "pdp_addtobag_button")
    private MobileElement _addToBagBtn;

    @AndroidFindAll(@AndroidFindBy(id = "text1"))
    private List<MobileElement> _selectSize;

    @AndroidFindAll(@AndroidFindBy(id = "title"))
    private List<MobileElement> _wishListBtn;

    @AndroidFindBy(id = "overflow")
    private MobileElement _overflow;

    @FindBy(id = "pdp_header_price_text")
    private WebElement _productPrice;

    @FindBy(id = "pdp_header_name_text")
    private WebElement _productName;

    public AddToBagScreen addProductToCart() {
        getProductDetails();
        waitForElement(_addToBagBtn).click();
        return this;
    }

    public void selectSize() {
        if(_selectSize.size()==0)
            System.out.println("product does not have sizes");
        else if(_selectSize.size()>0)
        waitForElement(_selectSize.get(1)).click();


    }

    public AddToBagScreen addProductToWishList() {
        waitForElement(_overflow).click();
        waitForElement(_wishListBtn.get(1)).click();
        return this;

    }


    @SuppressWarnings("unchecked")
	public JSONObject getProductDetails() {
        productDetails=new JSONObject();
        productDetails.put("name", waitForElement(_productName).getText().toLowerCase());
        productDetails.put("price", waitForElement(_productPrice).getText().replace("£", ""));
        productDetails.put("size",_selectSize.get(0).getText());
        return productDetails;
    }


}
