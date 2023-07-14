package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseTest {
    @FindBy(xpath = "//div[@class='page-title']//h1")
    WebElement elPageTitle;

    @FindBy(id = "termsofservice")
    WebElement elTermsOfService;

    @FindBy(id = "checkout")
    WebElement elButtonCheckout;

    public ShoppingCartPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyShoppingCartPageTitle(){
        objectVisibilityAssert("xpath","//div[@class='page-title']//h1");
        return elPageTitle.getText().equals("Shopping cart");
    }

    public ShoppingCartPage clickTermsAndCondition(){
        FrmSubScrollToElement(driver, elTermsOfService);
        objectVisibilityAssert("id", "termsofservice");
        elTermsOfService.click();
        return this;
    }

    public GuestPage clickCheckoutButton() throws Exception {
        objectVisibilityAssert("id", "checkout");
        elButtonCheckout.click();
        syncTimeWait("2");
        GuestPage guestPage = new GuestPage();
        return guestPage;
    }
}
