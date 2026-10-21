package tests;

import base.BaseTest;
import domain.BillingAddress;
import domain.User;
import org.testng.annotations.Test;
import pages.*;
import utils.JacksonUtils;

import java.io.IOException;

public class CheckOutManagementTest extends BaseTest {

    @Test
    public void guestNoLoginDuringCheckOutE2E() throws IOException, InterruptedException {

   //Test Case - As a Guest ,add product to the cart,checkout,no login during checkout, submit the order


     //Test Data
        // Option 1 - create billinAddress object and then set values and pass as args
        //BillingAddress billingAddress = new BillingAddress();
//        billingAddress.setFirstName("Charlie");
//        billingAddress.setLastName("Chaps");
//        billingAddress.setBillingStreet("1234 Collin St");
//        billingAddress.setbCity("New York");
//        billingAddress.setZipCode("10001");
//        billingAddress.setEmail("chapscharlie@testing.com");


       //Option 2 (Best one) - create billingAddress.json (keys in it should match POJO class variable names)
       //Create a JacksonUtil class which uses Object Mapper to convert json to Java POJOs

//        InputStream is = getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");
//        billingAddress = JacksonUtils.deSerializeJson(is,billingAddress);

        //Just pick which ever json data by passing as arg, you get a Java POJO
        //Complete de serialization taken place in JackSon Utils
        BillingAddress billingAddress = JacksonUtils.deSerializeJson("myBillingAddress.json",BillingAddress.class);


    HomePage homePage = new HomePage(getDriver());
    homePage.loadPage("/");
    homePage.navigateToStorePage();

    StorePage storePage = new StorePage(getDriver());
    storePage.searchTheProductInTheSearchBox("blue");
    storePage.clickOnTheSearchBtn();
    //Need to assert the search result text later

    storePage.addProductToTheCart("Blue Shoes");
    storePage.clickOnViewCartLink();

    CartPage cartPage = new CartPage(getDriver());
    //Need to assert the product Name,product Qty in the Cart later
    cartPage.clickOnProceedToCheckOutBtn();

     CheckOutPage checkOutPage = new CheckOutPage(getDriver());
//    String fname = "Kiran";
//    String lastname ="John";
//    String billstreet = "123 Oven street";
//    String bcity = "New York";
//    String zipcode ="10001";
//    String email = "joe.kiran@testing.com";


    //checkOutPage.enterUserDetails(fname,lastname,billstreet,bcity,zipcode,email);

       checkOutPage.enterUserDetails(billingAddress);

        //static wait for the time being,NOT RECOMMENDED ,this issue arise in FF
       Thread.sleep(2000);
        // Solution
        //There are 2 overlay element blocking the click
        //We need to identify the overlay using debugger F8 ad then getting elem
        //Use explicit wait for the overlay to disappear
        //Then click the checkout place order button
        checkOutPage.placeOrder();

       OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());
        //Need to assert the order confirmation text ,later

    }


    @Test
    public void LoginDuringCheckOutE2E() throws IOException {

        //Test Case - As a guest, add product to the cart,click Login during checkout and submit order flow


        //Test Data
        // Option 1 - create billinAddress object and then set values and pass as args
        //BillingAddress billingAddress = new BillingAddress();
//        billingAddress.setFirstName("Charlie");
//        billingAddress.setLastName("Chaps");
//        billingAddress.setBillingStreet("1234 Collin St");
//        billingAddress.setbCity("New York");
//        billingAddress.setZipCode("10001");
//        billingAddress.setEmail("chapscharlie@testing.com");


        //Option 2 (Best one) - create billingAddress.json (keys in it should match POJO class variable names)
        User user= JacksonUtils.deSerializeJson("registeredUser.json", User.class);
        BillingAddress billingAddress = JacksonUtils.deSerializeJson("myBillingAddress.json",BillingAddress.class);



        HomePage homePage = new HomePage(getDriver());
        homePage.loadPage("/");
        homePage.navigateToStorePage();

        StorePage storePage = new StorePage(getDriver());
        storePage.searchTheProductInTheSearchBox("blue");
        storePage.clickOnTheSearchBtn();
        //Need to assert the search result text later

        storePage.addProductToTheCart("Blue Shoes");
        storePage.clickOnViewCartLink();

        CartPage cartPage = new CartPage(getDriver());
        //Need to assert the product Name,product Qty in the Cart later
        cartPage.clickOnProceedToCheckOutBtn();

        CheckOutPage checkOutPage = new CheckOutPage(getDriver());

        checkOutPage.clickOnLoginLinkCheckOut();
        checkOutPage.enterLoginCredentialsBeforeCheckOut(user);

       checkOutPage.enterUserDetails(billingAddress);

        checkOutPage.placeOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());
        //Need to assert the order confirmation text ,later



    }


}
