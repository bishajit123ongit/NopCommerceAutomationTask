package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage extends BaseTest {
    @FindBy(xpath = "//div[@class='header-menu']//child::a[@href='/electronics']")
    WebElement elElectronics;

    @FindBy(xpath = "//div[@class='header-menu']//child::a[@href='/cell-phones']")
    WebElement elCellPhones;

    public PlaceOrderPage(){
        PageFactory.initElements(driver,this);
    }

    public PlaceOrderPage mouseHoverToElectronics() throws InterruptedException {
        elElectronics.isDisplayed();
        Thread.sleep(2000);
        action.moveToElement(elElectronics).build().perform();
        return this;
    }
    public PlaceOrderPage clickCellPhones() throws InterruptedException {
        elCellPhones.isDisplayed();
        elCellPhones.click();
        Thread.sleep(2000);
        return this;
    }
}
