package com.experian.fraudnetui.pageobjects;
import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.Utility.Util;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    private WebDriver webDriverPageObject=null;

    public LoginPage(WebDriver driver)
    {
        this.webDriverPageObject=driver;
        PageFactory.initElements(webDriverPageObject, this);
    }

    @FindAll({@FindBy(xpath = "//input[@type='text']")})
    public List<WebElement> inputFields;

    @FindBy(xpath="//input[@type='password']")
    private WebElement txtPassword;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath="//*[contains(text(),'test investigator')]")
    private WebElement lblLoggedinUser;

    @FindBy(xpath="//span[@id='arrow']")
    private WebElement btnLogoutArrow;

    @FindBy(xpath="//a[@class='logoutLink']")
    private WebElement btnLogout;

    public void login(String UserName,String Password,String Org)
    {
        try

        {
            if (Util.waitForWebElement(inputFields.get(0))) {
                inputFields.get(0).sendKeys(UserName);
            }

           if (Util.waitForWebElement(txtPassword)) {
                txtPassword.sendKeys(Password);
            }

           if (Util.waitForWebElement(inputFields.get(1))) {
                inputFields.get(1).sendKeys(Org);
           }

            if (Util.waitForWebElement(btnSubmit)) {
                btnSubmit.click();
            }

            Reporter.addStepLog("user enters username,password and organisation");
        }

        catch (Exception ex)
        {

            Reporter.addStepLog(ex.getMessage());
        }
    }

    public boolean checkSuccessfullogin()
    {
        Boolean  userNameExist=false;
        if(Util.waitForWebElement(lblLoggedinUser)) {
             userNameExist=lblLoggedinUser.isDisplayed();
             Util.sleep(3000);
        }
        return  userNameExist;
    }

   public void logOut()
    {
        if(Util.waitForWebElement(btnLogoutArrow)) {
            btnLogoutArrow.click();
            Util.sleep(3000);
        }

        if(Util.waitForWebElement(btnLogout)) {
            btnLogout.click();
            Util.sleep(3000);
        }


    }

}
