package xon.base.web.project.stepdefinitions.hook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import xon.base.web.project.hook.OpenWeb;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static xon.base.web.project.utils.Constants.TIME_SHORT;
import static xon.base.web.project.utils.Constants.TITLE;
import static xon.base.web.project.utils.Time.waiting;

public class Hook {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} is researching things on the internet")
    public void isResearchingThingsOnTheInternet(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL()
        );
        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)
                )
        );
    }
}