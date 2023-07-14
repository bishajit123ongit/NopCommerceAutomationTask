package com.nopstation.pom.pages;

import com.nopstation.pom.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.ThreadLocalRandom;

public class RegisterPage extends BaseTest {

    @FindBy(id="register-button")
    WebElement elRegisterButton;

    @FindBy(id = "gender-male")
    WebElement elGenderMale;

    @FindBy(id="gender-female")
    WebElement elGenderFeMale;

    @FindBy(id="FirstName")
    WebElement elFirstName;

    @FindBy(id="LastName")
    WebElement elLastName;

    @FindBy(id="Email")
    WebElement elEmail;

    @FindBy(id="Company")
    WebElement elCompany;

    @FindBy(id="Newsletter")
    WebElement elNewsLetter;

    @FindBy(id="Password")
    WebElement elPassword;

    @FindBy(id="ConfirmPassword")
    WebElement elConfirmPassword;

    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement elRegister;

    @FindBy(name = "DateOfBirthDay")
    WebElement elDateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement elDateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement elDateOfBirthYear;

    @FindBy(className = "result")
    WebElement elVerifyRegistrationMessage;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    public RegisterPage fillGender(String gender) throws Exception {
        syncTimeWait("1");
        objectVisibilityAssert("id", "gender-female");
        if (gender.equalsIgnoreCase("male")) {
            elGenderMale.click();
        } else {
            elGenderFeMale.click();
        }
        return this;
    }

    public RegisterPage fillFirstName(String firstName){
        elFirstName.isDisplayed();
        elFirstName.clear();
        elFirstName.sendKeys(firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName){
        elLastName.isDisplayed();
        elLastName.clear();
        elLastName.sendKeys(lastName);
        return this;
    }

    public RegisterPage fillEmail(String email){
        FrmSubScrollToElement(driver, elEmail);
        int int_random = ThreadLocalRandom.current().nextInt();
        String randomEmail = String.valueOf(int_random) + email;
        elEmail.isDisplayed();
        elEmail.clear();
        elEmail.sendKeys(randomEmail);
        return this;
    }

    public RegisterPage fillNewsLetter(String newsLetter){
        FrmSubScrollToElement(driver, elNewsLetter);
        objectVisibilityAssert("id", "Newsletter");
        elNewsLetter.isDisplayed();
        elNewsLetter.click();
        return this;
    }

    public RegisterPage fillPassword(String password){
        elPassword.isDisplayed();
        elPassword.clear();
        elPassword.sendKeys(password);
        return this;
    }

    public RegisterPage fillConfirmPassword(String confirmPassword){
        elConfirmPassword.isDisplayed();
        elConfirmPassword.clear();
        elConfirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage fillCompanyName(String companyName){
        elCompany.isDisplayed();
        elCompany.clear();
        elCompany.sendKeys(companyName);
        return this;
    }

    public RegisterPage fillDateOfBirthDate(String day){
        Select dtBirth = new Select(elDateOfBirthDay);
        dtBirth.selectByIndex(Integer.parseInt(day));
        return this;
    }

    public RegisterPage fillDateOfBirthMonth(String month){
        Select dtBirth = new Select(elDateOfBirthMonth);
        dtBirth.selectByIndex(Integer.parseInt(month));
        return this;
    }

    public RegisterPage fillDateOfBirthYear(String year){
        Select dtBirth = new Select(elDateOfBirthYear);
        dtBirth.selectByValue(year);
        return this;
    }

    public RegisterPage clickRegisterButton() {
        elRegisterButton.isDisplayed();
        elRegisterButton.click();
        return this;
    }
    public boolean verifyRegistration(){
        objectVisibilityAssert("class", "result");
        String message = elVerifyRegistrationMessage.getText();
        return message.equals("Your registration completed");
    }

    public boolean isRegisterButtonDisplay(){
        return elRegisterButton.isDisplayed();
    }
}
