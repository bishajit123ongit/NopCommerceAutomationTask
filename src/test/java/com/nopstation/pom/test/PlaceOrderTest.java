package com.nopstation.pom.test;

import com.nopstation.pom.BaseTest;
import com.nopstation.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    PlaceOrderPage placeOrderPage;
    CellPhoneAddCartPage cellPhoneAddCartPage;
    ShoppingCartPage shoppingCartPage;
    BillingPage billingPage;
    GuestPage guestPage;
    ShippingAndPaymentMethodPage shippingAndPaymentMethodPage;
    PaymentInfoAndConfirmOrderPage paymentInfoAndConfirmOrderPage;

    public PlaceOrderTest(){
        super();
    }

    @Test(priority = 0)
    public void verifyHomePageShouldSucceed(){
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isHomePageDisplay());
    }

    @Test(priority = 1)
    public void clickElectronicsCellPhoneShouldSucceed() throws InterruptedException {
        placeOrderPage = new HomePage()
                .mouseHoverToElectronics()
                .clickCellPhones();
        Assert.assertTrue(new CellPhoneAddCartPage().verifyNokiaLumia());
    }

    @Test(priority = 2)
    public void clickNokiaLumiaShouldSucceed() throws InterruptedException {
        cellPhoneAddCartPage = new CellPhoneAddCartPage()
                .clickNokiaLumiaPhone();
        Assert.assertTrue(cellPhoneAddCartPage.verifyNokiaLumia());
    }

    @Test(priority = 3)
    public void verifyQuantity(){
        Assert.assertTrue(cellPhoneAddCartPage.verifyProductQuantity());
    }

    @Test(priority = 4)
    public void clickAddCartShouldSucceed() throws Exception {
        cellPhoneAddCartPage = cellPhoneAddCartPage
                .setTheProductQuantity()
                .clickAddCart();
    }

    @Test(priority = 5)
    public void clickShoppingCartShouldSucceed() throws Exception {
        cellPhoneAddCartPage = new CellPhoneAddCartPage();
        shoppingCartPage = cellPhoneAddCartPage
                .clickShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyShoppingCartPageTitle());
    }

    @Test(priority = 6)
    public void clickCheckoutButtonShouldSucceed() throws Exception {
        shoppingCartPage = new ShoppingCartPage();
        guestPage = shoppingCartPage
                .clickTermsAndCondition()
                .clickCheckoutButton();
    }

    @Test(priority = 7)
    public void clickCheckoutAsGuestShouldSucceed() throws Exception {
        guestPage = new GuestPage();
        billingPage = guestPage
                .clickCheckoutButton();
        Assert.assertTrue(billingPage.verifyBillingPageTitle());
    }

    @Test(priority = 8)
    public void createBillingDetailsShouldSucceed() throws Exception {
        billingPage = new BillingPage();
        shippingAndPaymentMethodPage = billingPage
                .setFirstName(arrayList.get("Billing").get(0).get("FirstName"))
                .setLastName(arrayList.get("Billing").get(0).get("LastName"))
                .setEmail(arrayList.get("Billing").get(0).get("Email"))
                .setCompany(arrayList.get("Billing").get(0).get("Company"))
                .setCountry(arrayList.get("Billing").get(0).get("Country"))
                .setState(arrayList.get("Billing").get(0).get("State"))
                .setCity(arrayList.get("Billing").get(0).get("City"))
                .setAddressOne(arrayList.get("Billing").get(0).get("AddressOne"))
                .setAddressTwo(arrayList.get("Billing").get(0).get("AddressTwo"))
                .setPostalCode(arrayList.get("Billing").get(0).get("PostalCode"))
                .setPhoneNumber(arrayList.get("Billing").get(0).get("PhoneNumber"))
                .clickContinue();
        Assert.assertTrue(shippingAndPaymentMethodPage.verifyShippingMethodOption());
    }

    @Test(priority = 9)
    public void selectShippingAndPaymentMethodShouldSucceed() throws Exception {
        shippingAndPaymentMethodPage = new ShippingAndPaymentMethodPage();
        paymentInfoAndConfirmOrderPage = shippingAndPaymentMethodPage
                .clickNextDayAir()
                .clickCreditCard();
        Assert.assertTrue(paymentInfoAndConfirmOrderPage.verifyPaymentInformation());
    }

    @Test(priority = 10)
    public void createPaymentAndConfirmOrderShouldSucceed() throws Exception {
        paymentInfoAndConfirmOrderPage = new PaymentInfoAndConfirmOrderPage()
                .fillCardHolderName(arrayList.get("PaymentInformation").get(0).get("CardHolderName"))
                .fillCardNumber(arrayList.get("PaymentInformation").get(0).get("CardNumber"))
                .fillExpiryMonth("3")
                .fillExpiryYear("2027")
                .fillCardCode("122")
                .clickContinue();

        paymentInfoAndConfirmOrderPage = paymentInfoAndConfirmOrderPage
                .confirmOrder();
        Assert.assertTrue(paymentInfoAndConfirmOrderPage.verifyOrderSuccessfully());
    }
}
