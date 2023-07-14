package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GuestPage extends BaseTest {

    public GuestPage(){
        try {
            PageFactory.initElements(driver, this);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public BillingPage clickCheckoutButton(){
        WebElement elRegister = driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        FrmSubScrollToElement(driver, elRegister);
        elRegister.click();
        return new BillingPage();
    }
}
