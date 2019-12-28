/*
 * BaseTest Class
 * 
 * Shares Web driver in test classes     
 */
package testtask.tests;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static testtask.DriverManager.getDriver;
import static testtask.DriverManager.killDriver;

public class BaseTest {

    @Step
    @BeforeMethod
    public void getPage() {
        getDriver().get("http:google.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        killDriver();
    }
}