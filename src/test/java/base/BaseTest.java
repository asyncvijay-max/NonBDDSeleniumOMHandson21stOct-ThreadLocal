package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * This class will be extended by every Test Java Class like AccountManagement
 * It contains 2 methods which is startDriver and StopDriver ,
 * which will called before and after every Test Method
 *
 * startDriver() calls DriverFactory Java class which has a method to initialize
 *the new instance of Driver
 *
 * For every Test Method,(i mean Test Case), we use a new instance of driver(browser)
 * no sharing of driver is done between test cases(test methods)
 */

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void startDriver()
    {

        driver = new DriverFactory().initialDriver();

    }

    @AfterMethod
    public void stopDriver()
    {
      driver.quit();
    }

}
