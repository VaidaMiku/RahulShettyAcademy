package com.academy.tests;

import com.academy.base.BaseTest;
import com.academy.pages.CheckOutPage;
import com.academy.pages.LogInPage;
import com.academy.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAcademy extends BaseTest {

    LogInPage logInPage;
    ShopPage shopPage;
    CheckOutPage checkOutPage;



    @Test (priority = 1)
    public void signingIn() throws IOException {
        logInPage = new LogInPage(driver);
        logInPage.signIn();
        //Assert.assertTrue(logInPage.radioButtonCheck());
        //System.out.println(logInPage.radioButtonCheck());

        logInPage.continueSignIn();
        Assert.assertEquals(logInPage.pageAfterSignIn(), "https://rahulshettyacademy.com/angularpractice/shop", "Test Failed");
        System.out.println(logInPage.pageAfterSignIn());

    }

    @Test (priority = 2)
    public void addItemsToCart() throws IOException {
        shopPage = new ShopPage(driver);
        shopPage.addItems();
        Assert.assertEquals(shopPage.getNumberOfItems(),"Checkout ( 4 )\n" +
                "(current)", "Wrong number");
        System.out.println(shopPage.getNumberOfItems());
        shopPage.goToBasket();
        Assert.assertTrue(shopPage.sum());
        System.out.println(shopPage.sum());
    }

    @Test (priority = 3)
    public void checkingOut() throws IOException {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.removeOneItem();
        Assert.assertEquals(checkOutPage.sumAfterItemChange(), "₹. 200000", "Fail");
        System.out.println(checkOutPage.sumAfterItemChange());

        checkOutPage.changeQuantity();
        Assert.assertEquals(checkOutPage.sumAfterItemChange(), "₹. 285000", "Fail");
        System.out.println(checkOutPage.sumAfterItemChange());

        checkOutPage.clickCheckout();
        Assert.assertTrue(checkOutPage.finalWindowCheck());
        System.out.println(checkOutPage.finalWindowCheck());

        checkOutPage.completeCheckOut();
        Assert.assertTrue(checkOutPage.alertCheck());
        System.out.println(checkOutPage.alertCheck());
    }



}
