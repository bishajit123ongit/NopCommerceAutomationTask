package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPhoneAddCartPage extends BaseTest {
    @FindBy(className = "product-item")
    WebElement elProductElement;

    @FindBy(id = "product_enteredQuantity_20")
    WebElement elProductQuantity;

    @FindBy(id = "add-to-cart-button-20")
    WebElement elAddCart;

    @FindBy(className = "ico-cart")
    WebElement elShoppingCart;

    public CellPhoneAddCartPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyNokiaLumia() throws InterruptedException {
        objectVisibilityAssert("class", "product-item");
        Thread.sleep(2000);
        return true;
    }

    public CellPhoneAddCartPage clickNokiaLumiaPhone(){
        FrmSubScrollToElement(driver, elProductElement);
        elProductElement.isDisplayed();
        elProductElement.click();
        return this;
    }

    public boolean verifyProductQuantity(){
        FrmSubScrollToElement(driver, elProductQuantity);
        objectVisibilityAssert("id", "product_enteredQuantity_20");
        return true;
    }

    public CellPhoneAddCartPage setTheProductQuantity() throws Exception {
        syncTimeWait("2");
        elProductQuantity.clear();
        elProductQuantity.sendKeys("2");
        return this;
    }

    public CellPhoneAddCartPage clickAddCart(){
        try {
            objectVisibilityAssert("id", "add-to-cart-button-20");
            elAddCart.click();
            syncTimeWait("6");
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ShoppingCartPage clickShoppingCart() throws Exception {
        scrollMinMax("Min");
        objectVisibilityAssert("class", "ico-cart");
        elShoppingCart.click();
        return new ShoppingCartPage();
    }
}
