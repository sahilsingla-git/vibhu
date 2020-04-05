package com.experian.fraudnetui.pageobjects;

import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.Utility.Util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;

import java.util.List;

public class ReportPage {

    private WebDriver webDriverPageObject=null;

    public ReportPage(WebDriver driver)
    {
        this.webDriverPageObject=driver;
        PageFactory.initElements(webDriverPageObject, this);
    }

    @FindAll({@FindBy(xpath = "//input[@type='text']")})
    public List<WebElement> inputFields;

    @FindBy(xpath="//a[@id='reporting']")
    private WebElement reportTab;

    @FindBy(xpath="//input[@id='fnui-standard-reports-filter']")
    private WebElement radiobtnStandardReport;

    @FindBy(xpath="//*[@id='fnui-reports']/div")
    private WebElement mainDivReport;

    @FindBy(xpath="//*[@id='dijit_layout_ContentPane_0']")
    private WebElement invProdReportContentDiv;


    @FindBy(xpath="//*[@id='fnui-reporting-all-grid']/table/tbody/tr[3]/td[2]/a")
    private WebElement btnInvestigatorProdReport;

    //button[@class='action-new-entry btn btn-success']

    @FindBy(xpath="//input[contains(@id,'csvBtn')]")
    private WebElement btnExportCsv;


    public void navigateToReport()
    {
        Util.waitForWebElement(reportTab);
        reportTab.click();
    }

    public void navigateToInvProdReport()
    {
        Util.waitForAjaxToFinish();
        Util.waitForElementToBeClickable(radiobtnStandardReport);
        radiobtnStandardReport.click();
        Util.scrollIntoPage(mainDivReport);
        Util.waitForElementToBeClickable(btnInvestigatorProdReport);
        btnInvestigatorProdReport.click();

    }

    public void exportToCSV()
    {
        Util.waitForAjaxToFinish();
        Util.scrollIntoPage(invProdReportContentDiv);
        Util.waitForElementToBeClickable(btnExportCsv);
        btnExportCsv.click();
    }

    public boolean csvInvProdReportExist()
    {
        Util.sleep(3000);
        String fileName="InvestigatorProdRpt_";
        //string Path = System.Environment.GetEnvironmentVariable("USERPROFILE") + "\\Downloads";
        String folderPath = System.getProperty("user.home")+ "\\Downloads";
        boolean csvExistFlag=Util.checkPartialFilenameExistinFolder(fileName,folderPath);
        return csvExistFlag;

    }


}
