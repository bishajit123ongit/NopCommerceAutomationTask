package com.nopstation.pom;

import com.nopstation.pom.methods.FrameworkSubroutine;
import com.nopstation.pom.methods.FunctionalMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends FunctionalMethods {

    public BaseTest() {
        FrmReadConfigProperties();
        FrmExcelSheetDataFetch("Register");
        FrmExcelSheetDataFetch("Billing");
        FrmExcelSheetDataFetch("PaymentInformation");
    }

    @BeforeClass
    public void browserSetUp() {
        FrmBrowserDriverSetUp();
        action = new Actions(driver);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
