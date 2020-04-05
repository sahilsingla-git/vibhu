package com.experian.fraudnetui.pageobjects;

import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.Utility.Util;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeLoginPage {


    private WebDriver webDriverPageObject=null;

    public PracticeLoginPage(WebDriver driver)
    {
        this.webDriverPageObject=driver;
        PageFactory.initElements(webDriverPageObject, this);
    }

    @FindBy(xpath ="//input[@name='uid']")
    private  WebElement txtUsername;

    @FindBy(xpath = "//input[@type='password']")
    private  WebElement txtPassword;


    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnSubmit;

   /* @FindBy(xpath = "//a[@href='http://demo.guru99.com/test/newtours/']")
    private WebElement lblLoggedinUser;*/

/*
    @FindBy(xpath="//span[@id='arrow']")
    private WebElement btnLogoutArrow;
*/

    @FindBy(xpath = "//a[@href='Logout.php']")
    private WebElement btnLogout;

    public void login(String UserName,String Password)
    {
        try
        {
            Util.waitForWebElement(txtUsername);
            txtUsername.sendKeys(UserName);
            Util.waitForWebElement(txtPassword);
            txtPassword.sendKeys(Password);
            Reporter.addStepLog("user enters username,password");
            Util.waitForWebElement(btnSubmit);
            btnSubmit.click();
            Util.sleep(1000);


        }

        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }
    }

    public boolean checkSuccessfullogin()
    {
        //webDriverPageObject.switchTo().defaultContent();
        Util.waitForWebElement(btnLogout);
        if(btnLogout.isDisplayed())
        {
            return true;

        }
        else
        {  // webDriverPageObject.switchTo().alert().accept();
            Util.sleep(1000);
            return false;
        }
    }

    /*public void logOut()
    {
        Util.scrollIntoPage(btnLogout);
        Util.waitForWebElement(btnLogout);
        btnLogout.click();
        Util.sleep(500);
       webDriverPageObject.get("http://demo.guru99.com/V4/manager/Logout.php");
        webDriverPageObject.switchTo().alert().accept();
        Util.sleep(500);


    }*/




}
