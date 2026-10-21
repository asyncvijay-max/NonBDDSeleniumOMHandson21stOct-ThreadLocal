package pages;

import base.BasePage;
import domain.BillingAddress;
import domain.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    //LOCATORS

    //Login details for checkout
    private final By loginLinkCheckOut = By.cssSelector("[class=showlogin]");

    private final By userNameorEmailTxt = By.cssSelector("#username");

    private final By passwordTxt = By.cssSelector("#password");

    private final By loginBtnCheckOut = By.cssSelector("[name=login]");


    //User Billing Address details
    private  final By firstNameTxt =  By.id("billing_first_name");

    private  final By lastNameTxt =  By.id("billing_last_name");

    private  final By billingStreetTxt =  By.id("billing_address_1");

    private  final By billingCityTxt =  By.id("billing_city");

    private final By billingState = By.cssSelector("#select2-billing_state-container");

    private  final By postCodeTxt =  By.id("billing_postcode");

    private  final By emailTxt =  By.id("billing_email");

    private  final By placeOrderBtn =  By.id("place_order");


    //ACTIONS

    public void clickOnLoginLinkCheckOut()
    {
        //for dry run since implicit timeout given as of now DriverFactory method
        driver.findElement(loginLinkCheckOut).click();

        //explicit for stability
        //wait.until(ExpectedConditions.elementToBeClickable(loginLinkCheckOut)).click();
    }

    private void enterUserNameorEmailTxtBox(String userNameorEmail)
    {
        //for dry run since implicit timeout given as of now in DriverFactory method
        driver.findElement(userNameorEmailTxt).sendKeys(userNameorEmail);

        //explicit for stability
//        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameorEmailTxt));
//        ele.clear();
//        ele.sendKeys(userNameorEmail);
    }

    private void enterPasswordTxtBox(String password)
    {
        //for dry run since implicit timeout given as of now in DriverFactory method
        driver.findElement(passwordTxt).sendKeys(password);

        //explicit for stability
//        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxt));
//        ele.clear();
//        ele.sendKeys(password);
    }

    private void clickOnLoginBtnCheckOutPage()
    {
        //for dry run since implicit timeout given as of now in DriverFactory method
        driver.findElement(loginBtnCheckOut).click();

        //explicit for stability
        //wait.until(ExpectedConditions.elementToBeClickable(loginBtnCheckOut)).click();

    }

    public void enterLoginCredentialsBeforeCheckOut(User user)
    {
        enterUserNameorEmailTxtBox(user.getEmailAddress());
        enterPasswordTxtBox(user.getPassword());
        clickOnLoginBtnCheckOutPage();

    }


   private void enterFirstName(String fname)
    {
        driver.findElement(firstNameTxt).clear();
        driver.findElement(firstNameTxt).sendKeys(fname);
    }

    private void enterLastName(String lname)
    {
        driver.findElement(lastNameTxt).clear();
        driver.findElement(lastNameTxt).sendKeys(lname);
    }
    private void enterbillingStreet(String billingStreet)
    {
        driver.findElement(billingStreetTxt).clear();
        driver.findElement(billingStreetTxt).sendKeys(billingStreet);
    }

    private void enterbillingCity(String city)
    {
        driver.findElement(billingCityTxt).clear();
        driver.findElement(billingCityTxt).sendKeys(city);
    }


    private void enterState(String stateName)
    {
        /** This works only in CHROME,not FF
         * WebElement selectDropDown = driver.findElement(By.cssSelector("#billing_state"));
         *        Select select = new Select(selectDropDown);
         *       select.selectByVisibleText(stateName);
         */
//

        //BELOW works in FF and Chrome
        //Select doesnot work
        // Use Java Script Executor to wait for the element to stay within view port and then click

         wait.until(ExpectedConditions.elementToBeClickable(billingState)).click();

       // By selectedDropDown1 = By.xpath("//select[@name='billing_state']/option[text()='"+stateName+"']");

        By selectedDropDown = By.xpath("//ul[@id='select2-billing_state-results']//li[normalize-space()='"+stateName+"']");

        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(selectedDropDown));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);

        e.click();



    }


    private void enterPostalCode(String zipcode)
    {
        driver.findElement(postCodeTxt).clear();
        driver.findElement(postCodeTxt).sendKeys(zipcode);
    }
    private void enterEmail(String email)
    {
        driver.findElement(emailTxt).clear();
        driver.findElement(emailTxt).sendKeys(email);
    }

    // Pass String as args, ok for dry runs, Always use POJOs long term.
//    public void enterUserDetails(String fname,String lname,String bStreet,String city,String zipcode,String email)
//    {
//        enterFirstName(fname);
//        enterLastName(lname);
//        enterbillingStreet(bStreet);
//        enterbillingCity(city);
//        enterPostalCode(zipcode);
//        enterEmail(email);
//    }

    // Pass POJO as argument
    public void enterUserDetails(BillingAddress billingAddress)
    {
        enterFirstName(billingAddress.getFirstName());
        enterLastName(billingAddress.getLastName());
        enterbillingStreet(billingAddress.getBillingStreet());
        enterbillingCity(billingAddress.getbCity());
        enterState(billingAddress.getbState());
        enterPostalCode(billingAddress.getZipCode());
        enterEmail(billingAddress.getEmail());
    }

    public void placeOrder()
    {
        driver.findElement(placeOrderBtn).click();

        //goes to order confirmation page
    }

}


/**
 * if in future,you need to add Billing Country as a loctor,there is a catch for FF
 * eg: use locator as xpath ->  //select[@name='billing_country']/option[text()='India']
 private void enterCountry(String countryName)
 {
 WebElement selectDropDown = driver.findElement(By.cssSelector("#billing_country"));
 Select select = new Select(selectDropDown);
 select.selectByVisibleText(countryName);

 }
 There is a good chance of automation failing in firefox (not chrome)
 The reason, in firefox above code wont work since the country India is staying out of view port in FF (known bug)
 The normal Select code wont work in FF but works in chrome

 Alternative code  for FF:
 1) first find the locator of country dropdown
 By countryDropDown = By.cssSelector('#select2-billing_country-container')

 2)Then click using explicit wait
 wait.until(ExpectedConditions.elementTobeClickable(countrDropdown)).click()

 3)Find the element that you are trying to select from dropdown,eg India

 By countyToPickFromList = By.xpath(//select[@name='billing_country']/option[text()='India']);

 4) Use Implicit wait to find the element

 WebElement e = wait.until(ExpectedConditions.elementTobeClickable(countyToPickFromList)


 5)Use JavaScript Executor to scroll to the view and then click

((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);

 6)Then click the element e

 e.click();






 */
