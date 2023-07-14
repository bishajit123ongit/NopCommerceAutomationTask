package com.nopstation.pom.test;

import com.nopstation.pom.BaseTest;
import com.nopstation.pom.pages.HomePage;
import com.nopstation.pom.pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    public RegistrationTest(){
        super();
    }

    @Feature("Home page verification")
    @Description("Lunch and then verify the homepage appear properly")
    @Test(priority = 0)
    public void verifyHomePageShouldSucceed(){
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isHomePageDisplay());
    }

    @Feature("Go to the registration page")
    @Story("Registration link")
    @Description("From the home page click to the registration link")
    @Test(priority = 1)
    public void clickRegisterButtonShouldSucceed(){
          registerPage = new HomePage()
                .clickRegisterLink();
        Assert.assertTrue(registerPage.isRegisterButtonDisplay());
    }

    @Feature("Filling the registration form")
    @Story("Filling the registration form")
    @Description("Filling the all essential field for registration")
    @Test(priority = 2)
    public void registrationShouldSucceed() throws Exception {
        splitDayMonthYearFormDate(arrayList.get("Register").get(0).get("DateOfBirth"));

        registerPage = registerPage
                .fillGender(arrayList.get("Register").get(0).get("Gender"))
                .fillFirstName(arrayList.get("Register").get(0).get("FirstName"))
                .fillLastName(arrayList.get("Register").get(0).get("LastName"))
                .fillDateOfBirthDate(splitDob[0])
                .fillDateOfBirthMonth(splitDob[1])
                .fillDateOfBirthYear(splitDob[2])
                .fillEmail(arrayList.get("Register").get(0).get("Email"))
                .fillCompanyName(arrayList.get("Register").get(0).get("CompanyName"))
                .fillNewsLetter(arrayList.get("Register").get(0).get("NewsLetter"))
                .fillPassword(arrayList.get("Register").get(0).get("Password"))
                .fillConfirmPassword(arrayList.get("Register").get(0).get("ConfirmPassword"))
                .clickRegisterButton();
                 Assert.assertTrue(registerPage.verifyRegistration());
    }
}
