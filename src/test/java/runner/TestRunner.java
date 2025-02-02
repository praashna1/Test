package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/features",
        glue={"stepDefinition", "utility","pages"},
        plugin={"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
       // monochrome = true, // Makes console output more readable
        //tags = "@adminComplain"
)

public class TestRunner {


}
