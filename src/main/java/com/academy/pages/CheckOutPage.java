package com.academy.pages;

import com.academy.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.academy.util.TestDataReader.getLocation;

public class CheckOutPage extends BaseTest {

    String location = getLocation();


    public CheckOutPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div/table/tbody/tr[1]/td[5]/button")
    WebElement removeItem;

    @FindBy(xpath = "//*[@id=\"exampleInputEmail1\"]")
    WebElement increaseQuantity ;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div/table/tbody/tr[5]/td[5]/button")
    WebElement checkOutButton;

    @FindBy(xpath = "//*[@id=\"country\"]")
    WebElement deliveryLocation;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/app-checkout/div/div[2]/label")
    WebElement termsCheckbox;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/app-checkout/div/form/input")
    WebElement purchaseButton;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/div/div/table/tbody/tr[4]/td[5]/h3/strong")
    WebElement priceAfterItemChange;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/app-checkout/div")
    WebElement finalWindow;

    @FindBy(xpath = "/html/body/app-root/app-shop/div/app-checkout/div[2]/div")
    WebElement successfulPurchaseAlert;


    public void removeOneItem() {
        removeItem.click();
    }

    public String sumAfterItemChange() {
        return priceAfterItemChange.getText();
    }

    public void changeQuantity() {
        increaseQuantity.clear();
        increaseQuantity.sendKeys("2");
    }

    public void clickCheckout() {
        checkOutButton.click();
    }

    public boolean finalWindowCheck() {
        return finalWindow.isDisplayed();
    }

    public void completeCheckOut() {
        deliveryLocation.sendKeys(location);
        termsCheckbox.click();
        purchaseButton.click();
    }

    public boolean alertCheck() {
        return successfulPurchaseAlert.isDisplayed();
    }


}
