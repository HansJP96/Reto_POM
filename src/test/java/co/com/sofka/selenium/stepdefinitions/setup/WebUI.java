package co.com.sofka.selenium.stepdefinitions.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.selenium.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {
    private static final String WEBDRIVER_CHROME_DRIVER="webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH="src/test/resources/driver/windows/chrome/chromedriver.exe";

    protected WebDriver webDriver;

    protected void setUpWebDriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER,WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalSetUp(String urlPage ){
        webDriver = new ChromeDriver();
        webDriver.get(urlPage);
        webDriver.manage().window().maximize();
    }

    // ***** verificar USER_IDR
    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void  closeDriver(){
        webDriver.quit();
    }
}
