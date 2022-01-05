package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() { }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                } break;
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                } break;
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static String switchToNewTab() {
        String oldTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        return oldTab;
    }

    public static String switchToTab(String tab) {
        String oldTab = driver.getWindowHandle();
        driver.switchTo().window(tab);
        return oldTab;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
