package co.com.sofka.selenium.stepdefinitions.register;

import co.com.sofka.selenium.model.register.RegisterModel;
import co.com.sofka.selenium.page.register.RegisterPageFunctions;
import co.com.sofka.selenium.stepdefinitions.setup.WebUI;
import co.com.sofka.selenium.utils.UrlPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class RegisterStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private RegisterPageFunctions registerPageFunctions;
    private RegisterAssertionFunctions registerAssertionFunctions;
    private final RegisterModel registerModel = new RegisterModel();

    @Given("que el cliente se encuentra en la pagina de registro de ParaBank")
    public void queElClienteSeEncuentraEnLaPaginaDeRegistroDeParaBank() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp(UrlPages.URL_REGISTER.getValue());
        } catch (Exception exception){
            closeDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }
    @When("ingresa su informacion en todos los campos obligatorios y confirma la accion")
    public void ingresaSuInformacionEnTodosLosCamposObligatoriosYConfirmaLaAccion() {
        try {
            registerModel.setFirstName("Pablo");
            registerModel.setLastName("Colombia");
            registerModel.setAddress("Street 44");
            registerModel.setCity("Bogota");
            registerModel.setState("Cundinamarca");
            registerModel.setZipCode("1233255");
            registerModel.setSocialSecurityNumber("123456789");
            registerModel.setUsername("pablo99");
            registerModel.setPassword("qwert");
            registerModel.setConfirmPassword("qwert");

            registerPageFunctions = new RegisterPageFunctions(webDriver, registerModel);
            registerPageFunctions.fillAllRequiredInputs();
        } catch (Exception exception){
            closeDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }
    @Then("la pagina le muestra al usuario mensaje de bienvenida con su username y la confirmacion de su registro")
    public void laPaginaLeMuestraAlUsuarioMensajeDeBienvenidaConSuUsernameYLaConfirmacionDeSuRegistro() {
        try{
            registerAssertionFunctions = new RegisterAssertionFunctions(webDriver,registerModel);
            Assertions.assertEquals(
                    registerAssertionFunctions.userRegistrationResult(),
                    registerAssertionFunctions.successfulUserCreated());
        } catch (Exception exception){
            LOGGER.error(exception.getMessage(),exception);
        } finally {
            closeDriver();
        }
    }

    @When("al ingresar su informacion en los campos obligatorios se equivoca confirmando la contrasena y confirma la accion")
    public void alIngresarSuInformacionEnLosCamposObligatoriosSeEquivocaConfirmandoLaContrasenaYConfirmaLaAccion() {
        try {
            registerModel.setFirstName("Juan");
            registerModel.setLastName("Perez");
            registerModel.setAddress("Street 08");
            registerModel.setCity("Cartagena");
            registerModel.setState("Bolivar");
            registerModel.setZipCode("5677899");
            registerModel.setSocialSecurityNumber("987654321");
            registerModel.setUsername("juaper");
            registerModel.setPassword("juan99");
            registerModel.setConfirmPassword("juan12");
            registerPageFunctions = new RegisterPageFunctions(webDriver, registerModel);
            registerPageFunctions.fillAllRequiredInputs();
        } catch (Exception exception){
            closeDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }
    @Then("el usuario recibe un mensaje de error que dice {string}")
    public void elUsuarioRecibeUnMensajeDeErrorQueDice(String errorMessage) {
        try{
            registerAssertionFunctions = new RegisterAssertionFunctions(webDriver,registerModel);
            Assertions.assertEquals(
                    errorMessage,
                    registerAssertionFunctions.passwordConfirmationError());
        } catch (Exception exception){
            Assertions.fail("No se encontro elemento de mensaje de error",exception);
            LOGGER.error(exception.getMessage(),exception);
        } finally {
            closeDriver();
        }
    }
}
