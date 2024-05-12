package xon.base.web.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;
import xon.base.web.project.interfacesui.SearchBox;

public class SearchFor implements Task {

    private final String term;

    public SearchFor(String term) {
        this.term = term;
    }

    public static SearchFor term(String term) {
        return new SearchFor(term);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(term).into(SearchBox.INPUT),
                Hit.the(Keys.ENTER).into(SearchBox.INPUT)
        );
    }
}
