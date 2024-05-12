package xon.base.web.project.interfacesui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox extends PageObject {

    public static Target INPUT = Target.the("Input Box").located(By.id("APjFqb"));
}
