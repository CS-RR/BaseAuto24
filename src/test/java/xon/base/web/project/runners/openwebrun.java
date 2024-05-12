package xon.base.web.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/homepage.feature",
        tags = "@stories",
        glue = "xon.base.web.project.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class openwebrun {

}