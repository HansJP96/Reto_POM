package co.com.sofka.selenium.page.login;

import co.com.sofka.selenium.model.login.LoginModel;
import org.openqa.selenium.WebDriver;

public class LoginPageFunctions extends LoginPageElements{

    private final LoginModel loginModel;

    public LoginPageFunctions(WebDriver webDriver, LoginModel loginModel) {
        super(webDriver);
        this.loginModel = loginModel;
    }

    public void fillLoginInputs(){
        scrollOn(username);
        clearField(username);
        typeInField(username,loginModel.getUsername());

        scrollOn(password);
        clearField(password);
        typeInField(password,loginModel.getPassword());

        scrollOn(submit);
        doSubmit(submit);
    }
}
