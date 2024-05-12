package xon.base.web.project.questions;

import static org.openqa.selenium.By.xpath;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TextIsPresent implements Question<Boolean> {

    private final String expectedText;

    private TextIsPresent(String expectedText) {
        this.expectedText = expectedText;
    }

    public static TextIsPresent with(String expectedText) {
        return new TextIsPresent(expectedText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> allTextOnPage = BrowseTheWeb.as(actor)
                                .findAll(xpath("//*[not(self::script)][not(self::style)]"))
                                .stream()
                                .map(WebElement::getText)
                                .collect(Collectors.toList());

        return allTextOnPage.stream().anyMatch(text -> text.contains(expectedText));
    }
}