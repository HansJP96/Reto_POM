package co.com.sofka.selenium.page.contactus;

import co.com.sofka.selenium.page.actions.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPageElements extends PageActions {

    public ContactUsPageElements(WebDriver webDriver) {
        super(webDriver);
        pageFactoryInit(webDriver,this);
    }

    // Input elements for contact Us page
    @FindBy(id = "name")
    @CacheLookup
    protected WebElement name;

    @FindBy(id = "email")
    @CacheLookup
    protected WebElement email;

    @FindBy(id = "phone")
    @CacheLookup
    protected WebElement phone;

    @FindBy(id = "message")
    @CacheLookup
    protected WebElement message;

    @FindBy(xpath = "//input[@type=\"submit\" and @value=\"Send to Customer Care\"]")
    @CacheLookup
    protected WebElement submit;

    // For assertion test
    @FindBy(linkText = "Contact Us")
    @CacheLookup
    protected WebElement contactUsOption;

    @FindBy(xpath = "//div[@id=\"rightPanel\"]/h1")
    @CacheLookup
    protected WebElement titleMessage;

    @FindBy(xpath = "//div[@id=\"rightPanel\"]/p[1]")
    @CacheLookup
    protected WebElement firstSectionMessage;

    @FindBy(xpath = "//div[@id=\"rightPanel\"]/p[2]")
    @CacheLookup
    protected WebElement secondSectionMessage;
}
