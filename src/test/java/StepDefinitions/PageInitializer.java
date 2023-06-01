package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;


// This class will manage the object creation of different page Objects in our framework.
// instead of calling the age of objects over again, this class will take good care of that step (repetition)

public class PageInitializer {

    public static LoginPage login;

    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects() {

        login = new LoginPage();
        addEmployeePage = new AddEmployeePage();
    }

}

