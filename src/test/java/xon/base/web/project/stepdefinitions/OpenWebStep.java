package xon.base.web.project.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import xon.base.web.project.questions.TextIsPresent;
import xon.base.web.project.tasks.SearchFor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class OpenWebStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("he looks up {string}")
    public void heLooksUp(String term) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchFor.term(term));
    }

    @Then("he should see information about {string}")
    public void heShouldSeeInformationAbout(String expectedText) {
       OnStage.theActorInTheSpotlight().should(seeThat(TextIsPresent.with(expectedText)));
    }
}