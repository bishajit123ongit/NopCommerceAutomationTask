package com.nopstation.pom.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FunctionalMethods extends FrameworkSubroutine{
    public static boolean splitDayMonthYearFormDate(String dateOfBirth){
        splitDob = dateOfBirth.split("\\/");
        return true;
    }

    public static boolean objectVisibilityAssert(String locatorFindBy, String locatorValue){
        if(locatorFindBy.equals("xpath")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        }
        else if(locatorFindBy.equals("id")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        }
        else if(locatorFindBy.equals("class")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
        }
        else if(locatorFindBy.equals("name")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
        }

        return true;
    }

    public static boolean syncTimeWait(String SecondsToWait) throws Exception {
        try {
            if (SecondsToWait.equals("DEFAULT")) {
                Thread.sleep(4 * 1000);
            } else {
                Thread.sleep((Integer.parseInt(SecondsToWait) * 1000));
            }
            return true;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean scrollMinMax(String scrollType) throws Exception {
        if (scrollType.equals("Min")) {
            action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
            syncTimeWait("1");
        } else {
            action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            syncTimeWait("1");
        }
        return true;
    }


}
