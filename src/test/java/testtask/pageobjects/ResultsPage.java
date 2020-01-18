/*
 *  ResultsPage class.
 *  Class describes Page with results of search
 */
package testtask.pageobjects;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testtask.elements.Button;

import java.util.List;

import static testtask.DriverManager.getDriver;

@Log4j
public class ResultsPage {

    private By linkLocator = By.xpath("//a//h3");
    private By nextButton = By.xpath("//a/span[text()='Next' or text()='Уперед']");
    private By domainLinkLocator = By.xpath("//div//cite[@class]");
    private By domainLink = By.partialLinkText("testautomationday.com");

    @Getter
    private Button Next = new Button(nextButton, "Next page");

    @Step
    public WebPage openLink(int numberOfLinkToOpen) {
        List<WebElement> list = getDriver().findElements(linkLocator);
        list.get(numberOfLinkToOpen).click();
        return new WebPage();
    }

    @Step
    public boolean searchForDomain(String expectDomain, int numPg) {
        log.info(String.format("Search for '%s' on %s pages", expectDomain, numPg));

        int initPgCoun = numPg;
        List<WebElement> elemntList;

        while (numPg != 0) {
            elemntList = getDriver().findElements(domainLinkLocator);
            for (WebElement el : elemntList) {
                if (el.getText().contains(expectDomain)) {
                    log.info("Link was found on page: "+ (initPgCoun - numPg));
                    return true;
                }
            }
            if (getNext().isVisible()) {
                numPg--;
                getNext().clickButton();
            }
        }
        log.error("Nothing was found");
        return false;
    }
}