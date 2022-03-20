package co.com.sofka.selenium.stepdefinitions.login;

import co.com.sofka.selenium.model.login.LoginModel;
import co.com.sofka.selenium.page.login.LoginPageFunctions;
import co.com.sofka.selenium.stepdefinitions.setup.WebUI;
import co.com.sofka.selenium.utils.UrlPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);
    private LoginPageFunctions loginPageFunctions;
    private LoginAssertionFunctions loginAssertionFunctions;
    private final LoginModel loginModel = new LoginModel();


    @Given("que el cliente se encuentra en el home de la pagina")
    public void queElClienteSeEncuentraEnElHomeDeLaPagina() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp(UrlPages.URL_INDEX.getValue());
        } catch (Exception exception) {
            closeDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @When("digita su username: {string}, su contrasena: {string} y confirma su accion")
    public void digitaSuUsernameSuContrasenaYConfirmaSuAccion(String username, String password) {
        try {
            loginModel.setUsername(username);
            loginModel.setPassword(password);
            loginPageFunctions = new LoginPageFunctions(webDriver, loginModel);
            loginPageFunctions.fillLoginInputs();
        } catch (Exception exception) {
            closeDriver();
            Assertions.fail("Fallo rellenando los campos", exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("el usuario observa un mensaje que dice {string}")
    public void elUsuarioObservaUnMensajeQueDice(String desiredMessage) {
        try {
            loginAssertionFunctions = new LoginAssertionFunctions(webDriver, loginModel);
            Assertions.assertEquals(desiredMessage, loginAssertionFunctions.successfulLoginMessage());
            Assertions.assertTrue(loginAssertionFunctions.successfulLoginTable(), "No aparece la tabla overview");
        } catch (Exception exception) {
            Assertions.fail("No se encontro elemento de login correcto esperado");
            LOGGER.error(exception.getMessage(), exception);
        } finally {
            closeDriver();
        }
    }

    @When("digita su username: {string}, una contrasena incorrecta: {string} y confirma su accion")
    public void digitaSuUsernameUnaContrasenaIncorrectaYConfirmaSuAccion(String username, String invalidPassword) {
        try {
            loginModel.setUsername(username);
            loginModel.setPassword(invalidPassword);
            loginPageFunctions = new LoginPageFunctions(webDriver, loginModel);
            loginPageFunctions.fillLoginInputs();
        } catch (Exception exception) {
            closeDriver();
            Assertions.fail("Fallo rellenando los campos con contrasena incorrecta", exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("el usuario observa un mensaje de error relacionado a sus credenciales")
    public void elUsuarioObservaUnMensajeDeErrorRelacionadoASusCredenciales() {
        try {
            loginAssertionFunctions = new LoginAssertionFunctions(webDriver, loginModel);
            Assertions.assertEquals(
                    loginAssertionFunctions.invalidCredentialsMessage(),
                    loginAssertionFunctions.errorUserResult());
        } catch (Exception exception) {
            Assertions.fail("No se encontro elemento de error esperado", exception);
            LOGGER.error(exception.getMessage(), exception);
        } finally {
            closeDriver();
        }
    }

}
