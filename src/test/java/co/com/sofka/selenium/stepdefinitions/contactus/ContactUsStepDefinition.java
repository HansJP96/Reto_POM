package co.com.sofka.selenium.stepdefinitions.contactus;

import co.com.sofka.selenium.model.contactus.ContactUsModel;
import co.com.sofka.selenium.page.contactus.ContactUsPageFunctions;
import co.com.sofka.selenium.stepdefinitions.setup.WebUI;
import co.com.sofka.selenium.utils.UrlPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class ContactUsStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(ContactUsStepDefinition.class);
    private final ContactUsModel contactUsModel = new ContactUsModel();
    private ContactUsPageFunctions contactUsPageFunctions;
    private ContactUsAssertionFunctions contactUsAssertionFunctions;

    @When("el usuario visitante de la pagina se encuentra en el home")
    public void elUsuarioVisitanteDeLaPaginaSeEncuentraEnElHome() {
       try{
           setUpLog4j2();
           setUpWebDriver();
           generalSetUp(UrlPages.URL_INDEX.getValue());
       } catch (Exception exception){
           closeDriver();
           Assertions.fail("Fallo entrando al home de la pagina",exception);
           LOGGER.error(exception.getMessage(), exception);
       }
    }
    @Then("existe una opcion de Contact Us")
    public void existeUnaOpcionDeContactUs() {
        try{
            contactUsAssertionFunctions = new ContactUsAssertionFunctions(webDriver);
            Assertions.assertTrue(contactUsAssertionFunctions.isContactUs());
        } catch (Exception exception){
            closeDriver();
            Assertions.fail("No se encontro opcion Contact Us",exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @Then("lo redirige a la pagina correcta")
    public void loRedirigeALaPaginaCorrecta() {
        try{
            contactUsPageFunctions = new ContactUsPageFunctions(webDriver);
            contactUsAssertionFunctions = new ContactUsAssertionFunctions(webDriver);
            contactUsPageFunctions.pressContactUsOption();
            Assertions.assertEquals(
                    contactUsAssertionFunctions.contactUsCorrectPage(),
                    contactUsAssertionFunctions.contactUsPageValidation());
        } catch (Exception exception){
            Assertions.fail("La pagina de redireccion tiene errores",exception);
            LOGGER.error(exception.getMessage(), exception);
        } finally {
            closeDriver();
        }
    }

    @Given("el usuario visitante se encuentra en la pagina de Contact us")
    public void elUsuarioVisitanteSeEncuentraEnLaPaginaDeContactUs() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp(UrlPages.URL_CONTACT_US.getValue());
        } catch (Exception exception){
            closeDriver();
            Assertions.fail("Fallo entrando a la pagina de Contact Us",exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @When("llena la informacion de todos los campos y valida su accion")
    public void llenaLaInformacionDeTodosLosCamposYValidaSuAccion() {
        try{
            contactUsModel.setName("Julian");
            contactUsModel.setEmail("jul223@gmail.com");
            contactUsModel.setPhone("3208772130");
            contactUsModel.setMessage("Deseo  conocer como abrir mi cuenta de banco de manera remota.");
            contactUsPageFunctions = new ContactUsPageFunctions(webDriver,contactUsModel);
            contactUsPageFunctions.fillContactUsInputs();
        } catch (Exception exception){
            closeDriver();
            Assertions.fail("Fallo entrando a la pagina de Contact Us",exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @Then("aparece un mensaje de atencion al cliente que lo contactara pronto")
    public void apareceUnMensajeDeAtencionAlClienteQueLoContactaraPronto() {
        try{
            contactUsAssertionFunctions = new ContactUsAssertionFunctions(webDriver,contactUsModel);
            Assertions.assertEquals(
                    contactUsAssertionFunctions.messageSentSuccessful(),
                    contactUsAssertionFunctions.messageSentUserResult()
            );
        } catch (Exception exception){
            Assertions.fail("No se encontro elemento de mensaje de confirmacion",exception);
            LOGGER.error(exception.getMessage(), exception);
        } finally {
            closeDriver();
        }
    }
}
