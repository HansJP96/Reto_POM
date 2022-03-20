package co.com.sofka.selenium.runners.login;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/login/userLogin.feature"},
        glue = "co.com.sofka.selenium.stepdefinitions.login"
)
public class LoginSerenityTest {
}
