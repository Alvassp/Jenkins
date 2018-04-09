package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Driver{
    @BeforeSuite
    public void initWebDriver(){
        initDriver();

    }
    @AfterTest
    public void quitBrowser(){
        tearDown();
    }
}
