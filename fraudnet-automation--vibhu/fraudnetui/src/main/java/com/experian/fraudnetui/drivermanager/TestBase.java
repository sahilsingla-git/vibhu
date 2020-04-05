package com.experian.fraudnetui.drivermanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public static WebDriver driver;

    public WebDriver getDriver() {

        driver=new ChromeDriver();
        return driver;
    }
}
