package TestRunner;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonFormat;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features" ,
                glue = "StepDefinitions",
                dryRun = false,
                tags = "@database",
                plugin= {"pretty", "html:target/Cucumber.html", "json:target/Cucumber.json", "rerun:target/failed.txt"})


                //"or" is used in case u want to run more than one test,
                //tags="@testcase1 or @testcase2")


//when u put dryRun = true;  this won't run your test cases but only write the features for you.
//So you have to change it to false

//target folder is mostly used for storing the test case execution reports generated using Cucumber

public class SmokeRunner {
}
