package co.com.sofka.selenium.page.register;

import co.com.sofka.selenium.page.actions.PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPageElements extends PageActions {

    public RegisterPageElements(WebDriver webDriver) {
        super(webDriver);
        pageFactoryInit(webDriver,this);
    }

    // Input elements for register page
    @FindBy(id = "customer.firstName")
    @CacheLookup
    protected WebElement firstName;

    @FindBy(id = "customer.lastName")
    @CacheLookup
    protected WebElement lastName;

    @FindBy(id = "customer.address.street")
    @CacheLookup
    protected WebElement address;

    @FindBy(id = "customer.address.city")
    @CacheLookup
    protected WebElement city;

    @FindBy(id = "customer.address.state")
    @CacheLookup
    protected WebElement state;

    @FindBy(id = "customer.address.zipCode")
    @CacheLookup
    protected WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    @CacheLookup
    protected WebElement phone;

    @FindBy(id = "customer.ssn")
    @CacheLookup
    protected WebElement socialSecurityNumber;

    @FindBy(id = "customer.username")
    @CacheLookup
    protected WebElement username;

    @FindBy(id = "customer.password")
    @CacheLookup
    protected WebElement password;

    @FindBy(id = "repeatedPassword")
    @CacheLookup
    protected WebElement confirmPassword;

    @FindBy(xpath = "//input[@type=\"submit\" and @value=\"Register\"]")
    @CacheLookup
    protected WebElement submit;

    // For assertion test
    @FindBy(xpath = "//div[@id=\"rightPanel\"]/h1")
    @CacheLookup
    protected WebElement assertionWelcomeMessage;

    @FindBy(xpath = "//div[@id=\"rightPanel\"]/p")
    @CacheLookup
    protected WebElement assertionAccountConfirmation;

    @FindBy(id = "repeatedPassword.errors")
    @CacheLookup
    protected WebElement assertionRepeatedPasswordError;
}
