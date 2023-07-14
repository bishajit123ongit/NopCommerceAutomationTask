package com.nopstation.pom.test;

import com.nopstation.pom.BaseTest;
import com.nopstation.pom.pages.HomePage;
import com.nopstation.pom.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    public RegistrationTest(){
        super();
    }

    @Test(priority = 0)
    public void verifyHomePageShouldSucceed(){
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isHomePageDisplay());
    }

    @Test(priority = 1)
    public void clickRegisterButtonShouldSucceed(){
          registerPage = new HomePage()
                .clickRegisterLink();
        Assert.assertTrue(registerPage.isRegisterButtonDisplay());
    }

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
