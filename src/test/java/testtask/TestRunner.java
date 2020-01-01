package testtask;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = {"src/test/resources"}, glue="src.test.java.steps")
public class TestRunner extends AbstractTestNGCucumberTests{

}
