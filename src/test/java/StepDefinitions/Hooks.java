package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void preConditions()
    {
        openBrowserAndLaunchApplication();
    }




    // Scenario class holds the complete info of your tests execution in Cucum framework
    @After
    public void postConditions(Scenario scenario)
    {
        byte[] pic;
        if (scenario.isFailed())
        {
            pic = takeScreenshot("failed/" + scenario.getName());
        }
        else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }

        // Once ss is generated, we need to attach it in the report
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }
}