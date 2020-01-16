package testtask.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import testtask.pageobjects.MainPage;
import testtask.pageobjects.ResultsPage;
import testtask.pageobjects.WebPage;
import static testtask.DriverManager.getDriver;
import static testtask.DriverManager.killDriver;

public class StepsDefenition {

    @After
    public void shutDown() {
        killDriver();
    }

    MainPage mainPage;
    ResultsPage resultPage;
    WebPage webPage;

    @Given("I open {string} url")
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
        int linkToOpen = Integer.parseInt(linkNumb);
        webPage = resultPage.openLink(linkToOpen);
    }

    @Then("I see {string} in the title of opened page")
    public void iSeeInTheTitleOfOpenedPage(String searchWord) {
        String webPageTitle = webPage.getTitle();
        Assert.assertTrue(String.format("Title '%s' doesn't contain search word '%s'", webPageTitle, searchWord ), webPageTitle.toLowerCase().contains(searchWord));
    }


    @Then("I can find {string} domain in first {string} pages")
    public void iCanFindDomainInFirstPages(String searchDomain, String rangePages) {
        int num = Integer.parseInt(rangePages);
        boolean isFound = resultPage.searchForDomain(searchDomain,num);

        Assert.assertTrue("Expected domain wasn't found",isFound);
    }
}
