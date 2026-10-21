package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

//LOCATORS:

    //This is the search input text box
    private final By searchInputBox = By.cssSelector("input[type=search][class=search-field]");

    //This is the button which is clicked post entering search item
    private final By searchButton = By.cssSelector("button[value=Search]");

    //The message which is shown post searching the item eg:->  Search results: “blue”,we will extract the text for assertion
    private final By searchResultMessage = By.cssSelector("h1.woocommerce-products-header__title.page-title");

    //View cart Link
    private final By viewCartLink = By.cssSelector("[title='View cart']");



//ACTIONS:

public void searchTheProductInTheSearchBox(String searchItem)
{
    //use for dry run since we use implicit option during dry run,later switch to implicit one
    driver.findElement(searchInputBox).sendKeys(searchItem);

//    Implicit option - safer
//    WebElement ele=  wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputBox));
//    ele.sendKeys(searchItem);


}

public void clickOnTheSearchBtn()
{
    //use for dry run since we use implicit option during dry run,later switch to implicit one
    driver.findElement(searchInputBox).click();

    //Implicit option - safer
//    WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(searchInputBox));
//    ele.click();
}


    //Used for extracting Text and then doing Assertion in the Test Case
    public String verifyTheSearchResult()
    {
        return driver.findElement(searchResultMessage).getText();

        //wait.until(ExpectedConditions.textToBePresentInElementValue(searchResultMessage,"Search results: “blue”");
    }


    private By addProductToCartButtonLocator(String productName)
    {

        By addToCartButton = By.cssSelector(
                "a[aria-label='Add “" + productName + "” to your cart']"
        );

        return addToCartButton;
    }

    //To make locator dynamic based on product Name,eg:By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    //We decided to have separate private function which can be called with product as argument,which return By

    public void addProductToTheCart(String productName)
    {
        By addToCartButton = addProductToCartButtonLocator(productName);

        //use for dry run since we use implicit option during dry run,later switch to implicit one
        driver.findElement(addToCartButton).click();

//        Implicit option - safer
//         WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
//         ele.click();

    }


    public void clickOnViewCartLink()
    {
        //use for dry run since we use implicit option during dry run,later switch to implicit one
        //observation - slight  delay should be applied before click,it takes time for link to appear
       driver.findElement(viewCartLink).click();
    }


}

