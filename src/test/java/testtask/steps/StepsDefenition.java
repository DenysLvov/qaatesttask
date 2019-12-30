package testtask.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import testtask.pageobjects.MainPage;
import testtask.pageobjects.ResultsPage;
import testtask.pageobjects.WebPage;

import static testtask.DriverManager.getDriver;

public class StepsDefenition {

    MainPage mainPage;
    ResultsPage resultPage;
    WebPage webPage;

    @Given("I open {string} page")
    public void iOpenPage(String url) {
    getDriver().get(url);
    }

    @When("I enter {string} in search field")
    public void iEnterInSearchField(String searchWord) {
        mainPage = new MainPage();
                resultPage = mainPage.searchForWord(searchWord);
    }

    @And("I open the {string}-st link on search results page")
    public void iOpenTheStLinkOnSearchResultsPage(String linkNumb) {
        int linkToOpen = Integer.valueOf(linkNumb);
        webPage = resultPage.openLink(linkToOpen);
    }

    @Then("I see {string} in the title of opened page")
    public void iSeeInTheTitleOfOpenedPage(String searchWord) {
        String webPageTitle = webPage.getTitle();
        Assert.assertEquals(webPageTitle, searchWord, String.format("Expected title is %s, but was %s", searchWord, webPageTitle ));
    }
}
