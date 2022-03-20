package co.com.sofka.selenium.page.contactus;

import co.com.sofka.selenium.model.contactus.ContactUsModel;
import org.openqa.selenium.WebDriver;

public class ContactUsPageFunctions extends ContactUsPageElements {
    private ContactUsModel contactUsModel;

    public ContactUsPageFunctions(WebDriver webDriver, ContactUsModel contactUsModel) {
        super(webDriver);
        this.contactUsModel = contactUsModel;
    }

    public ContactUsPageFunctions(WebDriver webDriver) {
        super(webDriver);
    }

    public void pressContactUsOption(){
        scrollOn(contactUsOption);
        clickOnElement(contactUsOption);
    }

    public void fillContactUsInputs(){
        scrollOn(name);
        clearField(name);
        typeInField(name,contactUsModel.getName());

        scrollOn(email);
        clearField(email);
        typeInField(email,contactUsModel.getEmail());

        scrollOn(phone);
        clearField(phone);
        typeInField(phone,contactUsModel.getPhone());

        scrollOn(message);
        clearField(message);
        typeInField(message,contactUsModel.getMessage());

        scrollOn(submit);
        doSubmit(submit);
    }

}
