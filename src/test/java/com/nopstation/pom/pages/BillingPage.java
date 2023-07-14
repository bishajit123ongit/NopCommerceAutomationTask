package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingPage extends BaseTest {

    @FindBy(xpath = "//div[@class='center-1']//h1[contains(text(),'Checkout')]")
    WebElement elBillingPageTitle;

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement elFirstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement elLastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement elEmail;

    @FindBy(id = "BillingNewAddress_Company")
    WebElement elCompany;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement elCountry;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement elState;

    @FindBy(id = "BillingNewAddress_City")
    WebElement elCity;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement elAddressOne;

    @FindBy(id = "BillingNewAddress.Address2")
    WebElement elAddressTwo;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement elPostalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement elPhoneNumber;

    @FindBy(xpath = "//input[@id='BillingNewAddress_FaxNumber']")
    WebElement elFaxNumber;

    @FindBy(name = "save")
    WebElement elContinue;

    public BillingPage(){
        PageFactory.initElements(driver,this);
    }

    public BillingPage setFirstName(String firstName) {
        objectVisibilityAssert("id", "BillingNewAddress_FirstName");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_FirstName" + "').val('" + firstName + "');");
        return this;
    }

    public BillingPage setLastName(String lastName) {
        objectVisibilityAssert("id", "BillingNewAddress_LastName");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_LastName" + "').val('" + lastName + "');");
        return this;
    }

    public BillingPage setEmail(String email) {
        objectVisibilityAssert("id", "BillingNewAddress_Email");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_Email" + "').val('" + email + "');");
        return this;
    }

    public BillingPage setCompany(String company) {
        objectVisibilityAssert("id", "BillingNewAddress_Company");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_Company" + "').val('" + company + "');");
        return this;
    }

    public BillingPage setCountry(String country) throws Exception {
        objectVisibilityAssert("id", "BillingNewAddress_CountryId");
        Select countryName = new Select(elCountry);
        countryName.selectByValue("19");
        syncTimeWait("4");
        return this;
    }

    public BillingPage setState(String state) {
        objectVisibilityAssert("id", "BillingNewAddress_StateProvinceId");
        Select stateName = new Select(elState);
        stateName.selectByIndex(1);
        return this;
    }

    public BillingPage setCity(String city) {
        FrmSubScrollToElement(driver, elCity);
        objectVisibilityAssert("id", "BillingNewAddress_City");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_City" + "').val('" + city + "');");
        return this;
    }

    public BillingPage setAddressOne(String addressOne) {
        objectVisibilityAssert("id", "BillingNewAddress_Address1");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_Address1" + "').val('" + addressOne + "');");
        return this;
    }

    public BillingPage setAddressTwo(String addressTwo) {
        objectVisibilityAssert("id", "BillingNewAddress_Address2");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_Address2" + "').val('" + addressTwo + "');");
        return this;
    }

    public BillingPage setPostalCode(String postalCode) {
        FrmSubScrollToElement(driver, elPostalCode);
        objectVisibilityAssert("id", "BillingNewAddress_ZipPostalCode");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_ZipPostalCode" + "').val('" + postalCode + "');");
        return this;
    }

    public BillingPage setPhoneNumber(String phoneNumber) {
        FrmSubScrollToElement(driver, elPhoneNumber);
        objectVisibilityAssert("id", "BillingNewAddress_PhoneNumber");
        ((JavascriptExecutor) driver).executeScript("$('#" + "BillingNewAddress_PhoneNumber" + "').val('" + phoneNumber + "');");
        return this;
    }

    public ShippingAndPaymentMethodPage clickContinue() throws Exception {
        objectVisibilityAssert("name", "save");
        elContinue.click();
        syncTimeWait("3");
        return new ShippingAndPaymentMethodPage();
    }

    public boolean verifyBillingPageTitle(){
        objectVisibilityAssert("xpath", "//div[@class='center-1']//h1[contains(text(),'Checkout')]");
        return elBillingPageTitle.getText().equals("Checkout");
    }
}
