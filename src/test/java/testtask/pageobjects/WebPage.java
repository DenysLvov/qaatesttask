/*
 * WebPage class
 *
 * Class describes web page opened from link
 */

package testtask.pageobjects;

import lombok.extern.log4j.Log4j;

import static testtask.DriverManager.getDriver;

@Log4j
public class WebPage {

    public String getTitle() {
        log.info("Title is: " + getDriver().getTitle());
        return getDriver().getTitle();
    }
}
