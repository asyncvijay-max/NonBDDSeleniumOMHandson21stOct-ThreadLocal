package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators

    //This is the store Menu <a> Link on the Top Menu Bar
    private final By storeMenuLink = By.cssSelector("li#menu-item-1227 > a[href='https://askomdch.com/store/']");

       //actions
    public void navigateToHomePage()
    {
        loadPage("/");


    }

    public void navigateToStorePage()
    {
        // for dry run,can be used, it will be flaky, move to implicit wait always
       driver.findElement(storeMenuLink).click();

       //Implicit wait strategy - safer - waits for ele to be clickable before clicking it.
       //WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink));
       //ele.click();



     }


}
