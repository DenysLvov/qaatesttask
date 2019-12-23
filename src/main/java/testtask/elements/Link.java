package testtask.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Link extends TextField{

    public Link(By locator, String description) {
        super(locator, description);
    }

    @Step
    public void clickLink() {
        get().click();
    }
}
