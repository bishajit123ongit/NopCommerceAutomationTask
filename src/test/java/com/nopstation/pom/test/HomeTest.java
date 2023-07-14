package com.nopstation.pom.test;

import com.nopstation.pom.BaseTest;
import com.nopstation.pom.pages.HomePage;
import com.nopstation.pom.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    public HomeTest(){
        super();
    }


    @Test
    public void clickRegisterButtonShouldSucceed(){
        RegisterPage registerPage = new HomePage()
                .clickRegisterLink();
        Assert.assertTrue(registerPage.isRegisterButtonDisplay());
    }
}
