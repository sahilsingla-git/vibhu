package com.experian.fraudnetui.pageobjects;

import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.Utility.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PosNegListPage {

    private WebDriver webDriverPageObject=null;

    public PosNegListPage(WebDriver driver)
    {
        this.webDriverPageObject=driver;
        PageFactory.initElements(webDriverPageObject, this);
    }

    @FindAll({@FindBy(xpath = "//input[@type='text']")})
    public List<WebElement> inputFields;

    @FindBy(xpath="//a[@id='lists']")
    private WebElement listTab;

    @FindBy(xpath=".//div[@class='template--lists-domain-type-sidebar']//a[contains(.,'Device')]")
    private WebElement deviceTab;

    @FindBy(xpath=".//*[@id='collapsecategory_4']/label[7]")
    private WebElement radiobtnIP;

    //button[@class='action-new-entry btn btn-success']

    @FindBy(xpath="//button[@class='action-new-entry btn btn-success']")
    private WebElement btnMainNewEntry;

    @FindBy(xpath="//div[@class='template--lists-domain-type-string-field']//input[@type='text']")
    private WebElement txtIPAddress;

    @FindBy(xpath=" //a[@id='homeLink']")
    private WebElement linkHome;


    @FindBy(xpath="//button[@class='btn ok btn-primary']")
    private WebElement btnModelOk;

    @FindBy(xpath="//span[contains(@class,'noty_text')]")
    private WebElement dupEntryMsg;


    public  void navigateTOList()
    {
        try
        {
            if (Util.waitForWebElement(listTab)) {
                listTab.click();
            }

            Util.waitForAjaxToFinish();

            if (Util.waitForElementToBeClickable(deviceTab)) {
                deviceTab.click();
            }

            if (Util.waitForWebElement(radiobtnIP)) {
                radiobtnIP.click();
                Util.waitForAjaxToFinish();
            }
        }

        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }

    }

    public  void makeListEntryForNegative(String ipaddress)
    {
        try
        {
            btnMainNewEntry.click();
            txtIPAddress.sendKeys(ipaddress);
            btnModelOk.click();
            linkHome.click();
        }
        catch ( Exception ex)
        {

            Reporter.addStepLog(ex.getMessage());
        }

    }


    public void makeDuplicateEntryForNegative(String ipaddress)
    {
        try
        {
            navigateTOList();
            btnMainNewEntry.click();

            Util.waitForAjaxToFinish();

            Util.waitForWebElement(txtIPAddress);
            txtIPAddress.sendKeys(ipaddress);

            Util.waitForWebElement(btnModelOk);
            btnModelOk.click();
            Util.waitForAjaxToFinish();
        }

        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }


    }

    public boolean verifyDuplicateEntryMsg()
    {
        boolean valMsg = false;
        try {

            Util.waitForAjaxToFinish();
            Util.waitForWebElement(dupEntryMsg);
            valMsg = dupEntryMsg.isDisplayed();
            Util.sleep(1000);

        }

        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }
        return valMsg;
    }


}
