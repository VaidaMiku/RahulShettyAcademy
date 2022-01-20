package com.academy.pages;

import com.academy.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShopPage extends BaseTest {


    public ShopPage(WebDriver driver) throws IOException{
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[1]/div/div[2]/button")
    WebElement item1Add;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[2]/div/div[2]/button")
    WebElement item2Add;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[3]/div/div[2]/button")
    WebElement item3Add;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[4]/div/div[2]/button")
    WebElement item4Add;

    @FindBy(xpath = "/html/body/app-root/app-shop/nav/div/div/ul/li/a")
    WebElement checkOutButton;

    @FindBy(xpath = "/html/body/app-root/app-shop/nav/div/div/ul/li/a")
    WebElement itemsInCart;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div/table/tbody/tr[5]/td[5]/h3/strong")
    WebElement totalAmount;




    public void addItems() {
        item1Add.click();
        item2Add.click();
        item3Add.click();
        item4Add.click();
    }

    public String getNumberOfItems() {
        return itemsInCart.getText();

    }

    public void goToBasket() {
        checkOutButton.click();
    }

    public boolean sum() {
        return totalAmount.isDisplayed();
    }


}
