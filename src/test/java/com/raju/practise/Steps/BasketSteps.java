package com.raju.practise.Steps;

import com.raju.practise.screen_objects.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class BasketSteps {

    AddToBagScreen addToBagScreen;
    MainScreen mainScreen;
    SlidingScreen slidingScreen;
    ProductListingScreen productListingScreen;
    BasketScreen basketScreen;

    public BasketSteps(AddToBagScreen diAddToBagScreen, MainScreen diMainScreen,SlidingScreen diSlidingScreen,ProductListingScreen diProductListingScreen,BasketScreen diBasketScreen) {
        this.addToBagScreen = diAddToBagScreen;
        this.mainScreen = diMainScreen;
        this.slidingScreen=diSlidingScreen;
        this.productListingScreen=diProductListingScreen;
        this.basketScreen=diBasketScreen;
    }


    @Given("^I am on home page$")
    public void i_am_on_home_page() {
        new HomeScreen().tapOnGetStarted();
    }

    @When("^I tap on menu$")
    public void i_tap_on_menu() {
        mainScreen.tapOnMenu();
    }

    @When("^I search for a \"([^\"]*)\"$")
    public void i_search_for_a(String searchTerm) {
        slidingScreen.tapOnMenuAndEnterSearchTerm(searchTerm);
    }

    @When("^I select any product$")
    public void i_select_any_product() {
        productListingScreen.selectAnyProduct();
    }

    @When("^I add product to bag$")
    public void i_add_product_to_bag() {
        addToBagScreen.addProductToCart().selectSize();

    }

    @When("^I go to basket$")
    public void i_go_to_basket() {
        basketScreen.tapOnBacketMenuBtn();
    }

    @Then("^I see selected product in bag$")
    public void i_see_selected_product_in_bag() {
        Assert.assertEquals(addToBagScreen.productDetails, basketScreen.getProductDetails());

    }

}
