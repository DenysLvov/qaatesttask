/*
 * MainPage class
 * Class describes Search Page
 */
package testtask.pageobjects;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import testtask.elements.InputField;

import static testtask.DriverManager.getDriver;

@Log4j
public class MainPage {

    private By searchField = By.xpath("//input[@class='gLFyf gsfi']");


    @Getter
    private InputField SearchField = new InputField(searchField,"Google search");

    @Step
    public ResultsPage searchForWord(String word) {
        log.info("Enter in Search field: "+word);
        getSearchField().setText(word);
        getDriver().findElement(searchField).sendKeys(Keys.ENTER);
        return new ResultsPage();
    }

}
