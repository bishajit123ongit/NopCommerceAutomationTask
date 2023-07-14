package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentInfoAndConfirmOrderPage extends BaseTest {
    @FindBy(id = "CreditCardType")
    WebElement elCreditCardType;

    @FindBy(id = "CardholderName")
    WebElement elCardHolderName;

    @FindBy(id = "CardNumber")
    WebElement elCardNumber;

    @FindBy(id = "ExpireMonth")
    WebElement elExpireMonth;

    @FindBy(id = "ExpireYear")
    WebElement elExpireYear;

    @FindBy(id = "CardCode")
    WebElement elCardCode;


    public PaymentInfoAndConfirmOrderPage(){
        PageFactory.initElements(driver,this);
    }

    public PaymentInfoAndConfirmOrderPage fillCardHolderName(String cardHolderName){
        objectVisibilityAssert("id", "CardholderName");
        ((JavascriptExecutor) driver).executeScript("$('#" + "CardholderName" + "').val('" + cardHolderName + "');");
        return this;
    }

    public PaymentInfoAndConfirmOrderPage fillCardNumber(String cardNumber){
        objectVisibilityAssert("id", "CardNumber");
        ((JavascriptExecutor) driver).executeScript("$('#" + "CardNumber" + "').val('" + cardNumber + "');");
        return this;
    }

    public PaymentInfoAndConfirmOrderPage fillExpiryMonth(String month){
        Select dtMonth = new Select(elExpireMonth);
        dtMonth.selectByValue(month);
        return this;
    }

    public PaymentInfoAndConfirmOrderPage fillExpiryYear(String year){
        Select dtYear = new Select(elExpireYear);
        dtYear.selectByValue(year);
        return this;
    }

    public PaymentInfoAndConfirmOrderPage fillCardCode(String cardCode){
        objectVisibilityAssert("id", "CardCode");
        ((JavascriptExecutor) driver).executeScript("$('#" + "CardCode" + "').val('" + cardCode + "');");
        return this;
    }

    public PaymentInfoAndConfirmOrderPage clickContinue() throws Exception {
        WebElement elContinue = driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//button"));
        elContinue.click();
        syncTimeWait("3");
        return new PaymentInfoAndConfirmOrderPage();
    }

    public PaymentInfoAndConfirmOrderPage confirmOrder() throws Exception {
        WebElement elContinue = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//button"));
        FrmSubScrollToElement(driver, elContinue);
        elContinue.click();
        syncTimeWait("3");
        return new PaymentInfoAndConfirmOrderPage();
    }

    public boolean verifyOrderSuccessfully() throws Exception {
        WebElement elSuccessOrderTitle = driver.findElement(By.xpath("//div[@class='master-column-wrapper']//following-sibling::strong"));
        syncTimeWait("2");
        return elSuccessOrderTitle.getText().equals("Your order has been successfully processed!");
    }

    public boolean verifyPaymentInformation(){
        objectVisibilityAssert("id", "CreditCardType");
        return true;
    }
}
