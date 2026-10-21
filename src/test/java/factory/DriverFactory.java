package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver initialDriver()
    {
        WebDriver driver;



        //System Property(browser) for Browser selection, default is chrome if not provided
        String browserType = System.getProperty("browser","chrome");
        // mvn clean test -Dbrowser=chrome (pass browser as System property via CL)
        //if not provided,the value "chrome" is picked by default

        // System Property(headless) for Headless selection, defaults to false (headed mode)
        boolean headless = Boolean.parseBoolean(
        System.getProperty("headless", "false"));
        //eg:mvn clean test -Dbrowser=chrome -Dheadless=true


        switch(browserType.toLowerCase())
        {
            case "chrome" ->
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                if (headless) {
                    options.addArguments("--headless");
                }
                // Set a consistent browser window size
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                //break;
            }

            case "firefox" ->
            {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();

                if (headless) {
                    options.addArguments("-headless");
                }

                driver = new FirefoxDriver(options);
               // break;
            }

            default -> throw new IllegalStateException("Invalid browser");


        }


        // Action item: We will refactor implicit to explicit time later.
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize only in headed mode
        if (!headless) {
            driver.manage().window().maximize();
        }

      return driver;
    }
}

//Important NOTE:
//As of now(during test case prepartion phase), we will put implicit wait
//Later we will use explicit wait using WebdriverWait in the Base Page
//Never mix implicit wait with explicit wait
//To get started, during initial scripting, use implicit wait, it just checks the presence of element in the DOM,
//implicit waits doesnot check other things like visibility of elem, whether elem can interact etc


