package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Every Page class is going to extend this Base Page Java class,inheritence concept.
 *  */

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loadPage(String endPoint)
    {
        driver.get("https://askomdch.com"+ endPoint);
    }

}
