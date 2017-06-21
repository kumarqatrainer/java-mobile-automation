package com.raju.practise.Steps;

import com.raju.practise.screen_objects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class WishListSteps {

    private AddToBagScreen addToBagScreen;
    private SlidingScreen slidingScreen;
    private WishListScreen wishListScreen;
    private ProductListingScreen productListingScreen;
    public WishListSteps(BasketScreen diBasketScreen,ProductListingScreen diProductListingScreen, WishListScreen diWishListScreen, AddToBagScreen diAddToBagScreen, MainScreen diMainScreen, SlidingScreen diSlidingScreen) {
        this.addToBagScreen = diAddToBagScreen;
        this.slidingScreen = diSlidingScreen;
        this.wishListScreen = diWishListScreen;
        this.productListingScreen = diProductListingScreen;
    }

    @When("^I Add Product to my wishlist$")
    public void i_Add_Product_to_my_wishlist() {
        addToBagScreen.addProductToWishList().selectSize();
    }

    @When("^I tap on my wishlist$")
    public void i_tap_on_my_wishlist() {
        slidingScreen.goToMyWishList();
    }

    @Then("^I see selected product is in my wishlist$")
    public void i_see_selected_product_is_in_my_wishlist() {
        Assert.assertEquals(addToBagScreen.productDetails, wishListScreen.getProductDetails());
    }

    @When("^I edit size$")
    public void iEditSize() {
        wishListScreen.editSizeInWishlist();
    }

    @Then("^I see product size is edited in my wishlist$")
    public void iSeeProductSizeIsEditedInMyWishlist() {
        Assert.assertEquals(wishListScreen.getSizeinWishList(), wishListScreen.SizeTxt);
    }

    @And("^I click on back button$")
    public void iClickOnBackButton() {
        wishListScreen.tapOnBackButton();
    }

    @And("^I select another product$")
    public void iSelectAnotherProduct() {
        productListingScreen.selectAnotherProduct();
    }


    @And("^I tap on edit to delete product$")
    public void iTapOnEditToDeleteProduct()  {
        wishListScreen.tapOnEditToDeleteProductInWishList();
    }

    @Then("^I see only one product is displayed$")
    public void iSeeOnlyOneProductIsDisplayed()  {
       Assert.assertEquals(wishListScreen.numberOfProductsDisplayedInWishList(),"1");
    }
    @And("^I tap on edit to delete all products$")
    public void iTapOnEditToDeleteAllProducts()  {
        wishListScreen.clearAllProducts();
    }

    @Then("^I see wishlist is empty$")
    public void iSeeWishlistIsEmpty(){
        Assert.assertEquals(wishListScreen.wishListIsEmpty(),"0");

    }


    @And("^I add product to bag from wishlist$")
    public void iAddProductToBagFromWishlist()  {
        wishListScreen.addProductToBag();
    }

    @Then("^wishlist count is zero$")
    public void wishlistCountIsZero() {
       Assert.assertTrue(wishListScreen.noItemsWishListTextDisplayed());
    }
}
