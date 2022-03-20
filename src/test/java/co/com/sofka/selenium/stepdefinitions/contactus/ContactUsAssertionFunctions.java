package co.com.sofka.selenium.stepdefinitions.contactus;

import co.com.sofka.selenium.model.contactus.ContactUsModel;
import co.com.sofka.selenium.page.contactus.ContactUsPageElements;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ContactUsAssertionFunctions extends ContactUsPageElements {
    private ContactUsModel contactUsModel;

    public ContactUsAssertionFunctions(WebDriver webDriver) {
        super(webDriver);
    }

    public ContactUsAssertionFunctions(WebDriver webDriver, ContactUsModel contactUsModel) {
        super(webDriver);
        this.contactUsModel=contactUsModel;
    }

    protected boolean isContactUs(){
        return contactUsOption.isDisplayed();
    }

    protected List<Object> contactUsCorrectPage(){
        List<Object> desiredResult = new ArrayList<>();
        desiredResult.add("Customer Care");
        desiredResult.add("Email support is available by filling out the following form.");
        desiredResult.add(true);
        desiredResult.add(true);
        desiredResult.add(true);
        desiredResult.add(true);
        desiredResult.add(true);
        return desiredResult;
    }
    protected List<Object> contactUsPageValidation(){
        List<Object> result = new ArrayList<>();
        result.add(getElementText(titleMessage).trim());
        result.add(getElementText(firstSectionMessage).trim());
        result.add(name.isDisplayed());
        result.add(email.isDisplayed());
        result.add(phone.isDisplayed());
        result.add(message.isDisplayed());
        result.add(submit.isDisplayed());
        return result;
    }

    protected List<String> messageSentSuccessful(){
        List<String> desiredResult = new ArrayList<>();
        desiredResult.add("Customer Care");
        desiredResult.add("Thank you " + contactUsModel.getName());
        desiredResult.add("A Customer Care Representative will be contacting you.");
        return desiredResult;
    }

    protected List<String> messageSentUserResult(){
        List<String> result = new ArrayList<>();
        result.add(getElementText(titleMessage).trim());
        result.add(getElementText(firstSectionMessage).trim());
        result.add(getElementText(secondSectionMessage).trim());
        return result;
    }
}
