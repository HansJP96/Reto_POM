package co.com.sofka.selenium.runners.register;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/register/userRegister.feature"},
        glue = "co.com.sofka.selenium.stepdefinitions.register"
)
public class RegisterSerenityTest {

}
