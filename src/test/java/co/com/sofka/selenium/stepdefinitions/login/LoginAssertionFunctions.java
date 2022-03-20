package co.com.sofka.selenium.stepdefinitions.login;

import co.com.sofka.selenium.model.login.LoginModel;
import co.com.sofka.selenium.page.login.LoginPageElements;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginAssertionFunctions extends LoginPageElements {

    public LoginAssertionFunctions(WebDriver webDriver, LoginModel loginModel) {
        super(webDriver);
    }

    protected String successfulLoginMessage() {
        return getElementText(userWelcomeName);
    }

    protected boolean successfulLoginTable() {
        return overviewTable.isDisplayed();
    }

    protected List<String> errorUserResult() {
        List<String> result = new ArrayList<>();
        result.add(getElementText(assertionErrorTitle).trim());
        result.add(getElementText(assertionErrorMessage).trim());
        return result;
    }

    protected List<String> invalidCredentialsMessage() {
        List<String> desiredResult = new ArrayList<>();
        desiredResult.add("Error!");
        desiredResult.add("The username and password could not be verified.");
        return desiredResult;
    }
}
