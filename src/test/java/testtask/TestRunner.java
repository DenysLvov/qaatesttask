package testtask;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty",
                "json:target/cucumber-report/report.json"},
                features = {"src/test/resources"})

public class TestRunner{

}
