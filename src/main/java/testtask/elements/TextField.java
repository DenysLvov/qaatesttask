package testtask.elements;

import org.openqa.selenium.By;

public class TextField extends AbstractElement {

    public TextField(By locator, String description) {
        super(locator, description);
    }

    public String getText() {
        return get().getText();
    }
}
