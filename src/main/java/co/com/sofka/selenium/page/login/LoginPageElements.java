package co.com.sofka.selenium.page.login;

import co.com.sofka.selenium.page.actions.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends PageActions {

    public LoginPageElements(WebDriver webDriver) {
        super(webDriver);
        pageFactoryInit(webDriver,this);
    }

    // Input elements for login page
    @FindBy(name = "username")
    @CacheLookup
    protected WebElement username;

    @FindBy(name = "password")
    @CacheLookup
    protected WebElement password;

    @FindBy(xpath = "//input[@value=\"Log In\"]")
    @CacheLookup
    protected WebElement submit;

    // For assertion test
    @FindBy(xpath = "//div[@id=\"leftPanel\"]/p")
    @CacheLookup
    protected WebElement userWelcomeName;

    @FindBy(id = "accountTable")
    @CacheLookup
    protected WebElement overviewTable;

    @FindBy(xpath = "//div[@id=\"rightPanel\"]/h1")
    @CacheLookup
    protected WebElement assertionErrorTitle;

    @FindBy(xpath = "//div[@id=\"rightPanel\"]/p")
    @CacheLookup
    protected WebElement assertionErrorMessage;
}
