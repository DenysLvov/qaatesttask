/*
 * WebPage class
 *
 * Class describes web page opened from link
 */

package denysp.pageobjects;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import utils.DriverContainer;

@Log4j
@Getter
public class WebPage {

   public WebPage() {

    }

    public String getTitle() {
        log.info("Title is: " + driver.getTitle());
        return driver.getTitle();
    }
}
