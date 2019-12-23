package testtask.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testtask.pageobjects.MainPage;

public class TestGoogleSearch extends BaseTest {

    @Test(description = "Search for 'automation'. Open the first link on search results page. Check title")
    public void checkTitleInWebPage() {
        String searchWord = "automation";
        int numOfLink = 0; //numbers from '0'

        MainPage mainPg = new MainPage();
        String actualTitle = mainPg.searchForWord(searchWord)
                .openLink(numOfLink)
                .getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains(searchWord),
                String.format("Title '%s' doesn't contain search word '%s'", actualTitle, searchWord ));

    }

    @Test(description = "Search for “automation”. Check: 'testautomationday.com' is in search results pages (1-5)")
    public void checkDomainInWebPage() {
        String searchWord = "automation";
        String searchDomain ="testautomationday.com";
        //String searchDomain  = "automationanywhere.com";
        int rangePages = 5;

        MainPage mainPg = new MainPage();
        boolean b = mainPg.searchForWord(searchWord)
                .searchForDomain(searchDomain,rangePages);

        Assert.assertTrue(b,"Expected domain wasn't found");
    }

}


