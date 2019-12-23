/*
 * BaseTest Class
 * 
 * Shares Web driver in test classes     
 */
package testtask.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static testtask.DriverManager.getDriver;
import static testtask.DriverManager.killDriver;

public class BaseTest {

    @BeforeMethod
    public void getPage() {
        getDriver().get("http:google.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        killDriver();
    }
}