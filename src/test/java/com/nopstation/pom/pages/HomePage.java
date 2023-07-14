package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement elRegister;

    @FindBy(id="small-searchterms")
    WebElement elSmallSearchTerms;

    @FindBy(xpath = "//div[@class='header-menu']//child::a[@href='/electronics']")
    WebElement elElectronics;

    @FindBy(xpath = "//div[@class='header-menu']//child::a[@href='/cell-phones']")
    WebElement elCellPhones;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isHomePageDisplay(){
        return elRegister.isDisplayed();
    }

    public boolean isSearchBoxDisplay(){
        return elSmallSearchTerms.isDisplayed();
    }

    public RegisterPage clickRegisterLink(){
        elRegister.isDisplayed();
        elRegister.click();
        return new RegisterPage();
    }

    public PlaceOrderPage mouseHoverToElectronics() throws InterruptedException {
        elElectronics.isDisplayed();
        Thread.sleep(2000);
        action.moveToElement(elElectronics).build().perform();
        return new PlaceOrderPage();
    }
    public PlaceOrderPage clickCellPhones() throws InterruptedException {
        elCellPhones.isDisplayed();
        elCellPhones.click();
        Thread.sleep(2000);
        return new PlaceOrderPage();
    }
}
