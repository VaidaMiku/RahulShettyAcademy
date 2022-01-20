package com.academy.pages;

import com.academy.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.academy.util.TestDataReader.getPassword;
import static com.academy.util.TestDataReader.getUsername;

public class LogInPage extends BaseTest {

    String username = getUsername();
    String password = getPassword();



    public LogInPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "username")
    WebElement usernameBox;

    @FindBy(name = "password")
    WebElement passwordBox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[4]/div/label[2]/span[2]")
    WebElement userRadioButton;

    @FindBy(id = "okayBtn")
    WebElement popupButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[5]/select")
    WebElement userDropDownList;

    @FindBy(id = "terms")
    WebElement termsCheckbox;

    @FindBy(id = "signInBtn")
    WebElement signInButton;



    public void signIn() {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        userRadioButton.click();
        WebDriverWait waitForButton = new WebDriverWait(driver, 20);
        waitForButton.until(ExpectedConditions.elementToBeClickable(popupButton));
        popupButton.click();
    }


    //public boolean radioButtonCheck() {
        //return userRadioButton.isSelected();
    //}

    public void continueSignIn() {
        Select userType = new Select(userDropDownList);
        userType.selectByVisibleText("Consultant");
        termsCheckbox.click();
        signInButton.click();
        WebDriverWait waitForWebsite = new WebDriverWait(driver, 20);
        waitForWebsite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-shop/div/div/div[1]/h1")));
    }


    public String pageAfterSignIn() {
        return driver.getCurrentUrl();
    }



}
