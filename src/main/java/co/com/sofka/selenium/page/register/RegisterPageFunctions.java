package co.com.sofka.selenium.page.register;

import co.com.sofka.selenium.model.register.RegisterModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class RegisterPageFunctions extends RegisterPageElements {

    private final RegisterModel registerModel;

    public RegisterPageFunctions(WebDriver webDriver, RegisterModel registerModel) {
        super(webDriver);
        this.registerModel=registerModel;
    }

    public void fillAllRequiredInputs(){

        scrollOn(firstName);
        clearField(firstName);
        typeInField(firstName, registerModel.getFirstName());

        scrollOn(lastName);
        clearField(lastName);
        typeInField(lastName, registerModel.getLastName());

        scrollOn(address);
        clearField(address);
        typeInField(address, registerModel.getAddress());

        scrollOn(city);
        clearField(city);
        typeInField(city, registerModel.getCity());

        scrollOn(state);
        clearField(state);
        typeInField(state, registerModel.getState());

        scrollOn(zipCode);
        clearField(zipCode);
        typeInField(zipCode, registerModel.getZipCode());

        scrollOn(socialSecurityNumber);
        clearField(socialSecurityNumber);
        typeInField(socialSecurityNumber, registerModel.getSocialSecurityNumber());

        scrollOn(username);
        clearField(username);
        typeInField(username, registerModel.getUsername());

        scrollOn(password);
        clearField(password);
        typeInField(password, registerModel.getPassword());

        scrollOn(confirmPassword);
        clearField(confirmPassword);
        typeInField(confirmPassword, registerModel.getConfirmPassword());

        scrollOn(confirmPassword);
        doSubmit(submit);
    }

}
