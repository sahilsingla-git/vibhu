    package com.experian.fraudnetui.Utility;

    import com.cucumber.listener.Reporter;
    import com.experian.fraudnetui.drivermanager.TestBase;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import java.io.File;
    import java.io.IOException;

    public class Util extends TestBase {


        public static WebDriverWait wait;

        public static boolean waitForElementToBeClickable(WebElement element) {
            boolean result = false;
            WebDriverWait wait = new WebDriverWait(TestBase.driver,5000);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            result = true;
            return result;
        }

        // Wait until element is visible
        public static boolean waitForWebElement(WebElement element) {
            boolean result = false;
            try
            {
                /*WebDriverWait wait = new WebDriverWait(TestBase.driver, 1000);
                wait.until(ExpectedConditions.visibilityOf(element));
                result = true;
                return result;*/
                return false;

            }

            catch (Exception ex)
            {
                Reporter.addStepLog(ex.getMessage());
                return  result;

            }

        }

        public static void sleep(int timeInMilliSec) {
            try
            {
                Thread.sleep(timeInMilliSec);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        public static void waitForAjaxToFinish(){
                WebDriver driver = TestBase.driver;
                while (true) {
                Boolean ajaxIsComplete;
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                String script = "return window.jQuery.active == 0";
                ajaxIsComplete = (Boolean) executor.executeScript(script);
                if (ajaxIsComplete) {
                    break;
                }
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {

                }
            }
        }

        public static void scrollIntoPage(WebElement element) {

            try
            {
                JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);
            }

            catch (Exception ex)
            {
                Reporter.addStepLog(ex.getMessage());
            }
        }

        public static boolean checkPartialFilenameExistinFolder(String nameofFile,String folderName)
        {
            boolean flag=false;

            File[] listFiles = new File(folderName).listFiles();

            for (int i = 0; i < listFiles.length; i++)
            {
                if (listFiles[i].isFile())
                {
                    String fileName = listFiles[i].getName();
                    if (fileName.startsWith(nameofFile)&& fileName.endsWith(".csv"))
                    {
                        flag= true;
                        listFiles[i].delete();
                    }

                }
            }
            return flag;
        }


    }
