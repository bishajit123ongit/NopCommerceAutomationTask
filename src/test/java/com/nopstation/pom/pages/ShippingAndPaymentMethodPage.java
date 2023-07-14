package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAndPaymentMethodPage extends BaseTest {

    @FindBy(id = "shippingoption_1")
    WebElement elNextDayAir;

    @FindBy(id = "paymentmethod_1")
    WebElement elCreditCard;

    @FindBy(name = "save")
    WebElement elContinue;


    public ShippingAndPaymentMethodPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyShippingMethodOption(){
        objectVisibilityAssert("id", "shippingoption_1");
        return true;
    }

    public ShippingAndPaymentMethodPage clickNextDayAir() throws Exception {
        WebElement elContinue = driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//button"));
        objectVisibilityAssert("id", "shippingoption_1");
        elNextDayAir.click();
        syncTimeWait("1");
        elContinue.click();
        return this;
    }

    public PaymentInfoAndConfirmOrderPage clickCreditCard() throws Exception {
        WebElement elContinue = driver.findElement(By.xpath("//li[@class='tab-section allow active']//button[@name='save']"));
        objectVisibilityAssert("id", "paymentmethod_1");
        elCreditCard.click();
        syncTimeWait("1");
        elContinue.click();
        return new PaymentInfoAndConfirmOrderPage();
    }
}
