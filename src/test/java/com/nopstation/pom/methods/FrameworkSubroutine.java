package com.nopstation.pom.methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.*;

public class FrameworkSubroutine {
    public static Actions action;
    public static Properties configProperties;
    public static WebDriver driver;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static Map<String, List<LinkedHashMap<String, String>>> arrayList = new LinkedHashMap<>();
    public static String[] splitDob;
    public static JavascriptExecutor js;

    public static boolean FrmReadConfigProperties(){
        try {
            //Read the properties for any operating system
            File file = new File("config.properties");
            String path = file.getAbsolutePath();
            configProperties = new Properties();
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(path);
            configProperties.load(inputStream);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean FrmBrowserDriverSetUp(){
        try{
            String browserName = getBrowser();
            if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            driver.get(getBaseUrl());

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean FrmExcelSheetDataFetch(String DatasheetName) {
        List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
        boolean isTerminate = false;
        File file = new File("TestRunList.xlsx");
        String excelFilepath = file.getAbsolutePath();

        try {
            workbook = new XSSFWorkbook(excelFilepath);
            if (workbook.getSheet(DatasheetName) != null) {
                sheet = workbook.getSheet(DatasheetName);
            }
            int rowCount = sheet.getLastRowNum();
            if (sheet.getRow(0).getLastCellNum() > 0) {
                String value;
                for (int i = 1; i <= rowCount; i++) {
                    if (isTerminate) {
                        isTerminate = false;
                        break;
                    }
                    Row row = sheet.getRow(0);
                    LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        if (FrmSubEmptyCellCheck(sheet, i, j)) {
                            String key = row.getCell(j).getStringCellValue().trim();
                            value = sheet.getRow(i).getCell(j).getStringCellValue();
                            value = value.replace("\"", "");
                            rowData.put(key, value);
                            if ((key.trim().startsWith("##") && key.trim().endsWith("EOF")) ||
                                    (value.trim().startsWith("##") && value.trim().endsWith("EOF"))) {
                                isTerminate = true;
                                break;
                            }
                        }
                    }
                    dataList.add(rowData);
                }
                arrayList.put(DatasheetName, dataList);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Excel sheet null value handler
    public static boolean FrmSubEmptyCellCheck(XSSFSheet xssfSheet, int row, int col) {
        try {
            return xssfSheet.getRow(row).getCell(col) != null
                    && xssfSheet.getRow(row).getCell(col).getStringCellValue() != null
                    && !xssfSheet.getRow(row).getCell(col).getStringCellValue().isEmpty();

        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }
    }

    public static void FrmSubScrollToElement(WebDriver driver, WebElement webElement) {
        int x = webElement.getLocation().getX(), y = webElement.getLocation().getY() - 120;
        String scroll_by_coord = "window.scrollTo(" + x + "," + y + ");";
        ((JavascriptExecutor) driver).executeScript(scroll_by_coord);
    }

    public static String getBaseUrl() {
        return configProperties.getProperty("baseUrl");
    }

    public static String getBrowser() {
        return configProperties.getProperty("browserName");
    }
}
