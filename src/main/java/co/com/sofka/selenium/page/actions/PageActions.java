package co.com.sofka.selenium.page.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageActions {
    private static final Logger LOGGER = Logger.getLogger(PageActions.class);
    private static final String WEBDRIVER_ERROR = "Webdriver can not be null";
    private WebDriver webDriver;

    // Constructor
    public PageActions(WebDriver webDriver) {
        try {
            if (webDriver == null) {
                LOGGER.warn(WEBDRIVER_ERROR);
            }
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage(), exception);
        }
        this.webDriver = webDriver;
    }

    //POM with page factory
    protected void pageFactoryInit(WebDriver webDriver, Object page) {
        PageFactory.initElements(webDriver, page);
    }

    // Common actions on pages
    protected void clickOnElement(By locator) {
        webDriver.findElement(locator).click();
    }

    protected void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    protected void clearField(By locator) {
        webDriver.findElement(locator).clear();
    }

    protected void clearField(WebElement webElement) {
        webElement.clear();
    }

    protected void typeInField(By locator, CharSequence... charSequences) {
        webDriver.findElement(locator).sendKeys(charSequences);
    }

    protected void typeInField(WebElement webElement, CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }

    protected void scrollOn(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(locator));
    }

    protected void scrollOn(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void doSubmit(By locator) {
        webDriver.findElement(locator).submit();
    }

    protected void doSubmit(WebElement webElement) {
        webElement.submit();
    }

    protected String getElementText(By locator) {
        return webDriver.findElement(locator).getText();
    }
    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }
}