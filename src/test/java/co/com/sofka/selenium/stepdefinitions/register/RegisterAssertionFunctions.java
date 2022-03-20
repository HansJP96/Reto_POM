package co.com.sofka.selenium.stepdefinitions.register;

import co.com.sofka.selenium.model.register.RegisterModel;
import co.com.sofka.selenium.page.register.RegisterPageElements;
import co.com.sofka.selenium.page.register.RegisterPageFunctions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class RegisterAssertionFunctions extends RegisterPageElements {

    private final RegisterModel registerModel;

    public RegisterAssertionFunctions(WebDriver webDriver, RegisterModel registerModel) {
        super(webDriver);
        this.registerModel = registerModel;
    }

    protected List<String> userRegistrationResult(){
        List<String> result = new ArrayList<>();
        result.add("Welcome " + registerModel.getUsername());
        result.add("Your account was created successfully. You are now logged in.");
        return result;
    }

    protected List<String> successfulUserCreated(){
        List<String> resultValues = new ArrayList<>();

        resultValues.add(getElementText(assertionWelcomeMessage).trim());
        resultValues.add(getElementText(assertionAccountConfirmation).trim());

        return resultValues;
    }

    protected String  passwordConfirmationError(){
        return getElementText(assertionRepeatedPasswordError).trim();
    }

}
