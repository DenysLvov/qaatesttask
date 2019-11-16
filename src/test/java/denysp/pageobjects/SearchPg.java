/*
 * SearchPg class
 *
 * Class describes Search Page
 */
package denysp.pageobjects;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.DriverContainer;

@Log4j
public class SearchPg {

    private By searchFieldLocator = By.xpath("//input[@title='Search']");

    public SearchPg() {

    }

    public ResultsPg searchForWord(String word) {
        driver.findElement(searchFieldLocator).sendKeys(word);
        driver.findElement(searchFieldLocator).sendKeys(Keys.ENTER);
        return new ResultsPg();
    }

}
