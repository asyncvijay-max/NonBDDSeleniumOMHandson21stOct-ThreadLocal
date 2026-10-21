package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //LOCATORS:

    //1. Product Name - extract the text for assertion during the test
    private final By productName = By.cssSelector("td[class='product-name'] > a");

    //2.Product Qty - extract the text for assertion during the test
    private final By productQty = By.cssSelector("td[class='product-quantity']  input[title=Qty]");


    //proceedToCheckOut button
    private final By proceedToCheckOutBtn= By.cssSelector(".checkout-button");

    //ACTIONS:

    //1. Extract Text for productName
        public String verifyTheProductNameInTheCart()
        {
            return driver.findElement(productName).getText();
        }

    //2. Extract Text for productQty
    public String verifyTheProductQtyInTheCart()
        {
            return driver.findElement(productQty).getText();
        }


    public void clickOnProceedToCheckOutBtn()
    {
        //use for dry run since we use implicit option during dry run,later switch to implicit one
        driver.findElement(proceedToCheckOutBtn).click();

        //wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutBtn)).click();
    }


}
