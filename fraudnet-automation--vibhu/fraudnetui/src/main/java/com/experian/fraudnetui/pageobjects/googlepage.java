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
import org.openqa.selenium.Keys;

public class googlepage {

    private WebDriver webDriverPageObject=null;

    public googlepage(WebDriver driver)
    {
        this.webDriverPageObject=driver;
        PageFactory.initElements(webDriverPageObject, this);
    }

    @FindBy(xpath="//input[@name='q']")
    private WebElement Query;

    @FindBy(xpath="(//a[@id='hdtb-tls']")
    private WebElement resultDisplayed;

    @FindBy(xpath="//input[@type='submit'])[1]")
    private WebElement submit;

    public void enterQuery()    {

        //if(Util.waitForWebElement(Query))
        //{
        Util.sleep(1000);
        Query.sendKeys("Mortar");
        Util.sleep(1000);
        Query.sendKeys(Keys.ENTER);
        //}

    }
    public boolean checkresult()
    {
        Boolean  resultExist;
       resultExist= Util.waitForWebElement(resultDisplayed);
        /*if(Util.waitForWebElement(resultDisplayed)) {
            //resultExist=resultDisplayed.isDisplayed();
            //Util.sleep(1000);
            resultExist
        }*/
        return resultExist;

    }

}


