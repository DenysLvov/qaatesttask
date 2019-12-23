package testtask.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Button extends TextField {

    private By locator;
    private String description;

    public Button(By locator, String description){
        super(locator, description);
    }

    @Step
    public void clickButton() {
        get().click();
    }
}
