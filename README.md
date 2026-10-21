the repo:
https://github.com/asyncvijay-max/NonBDDSeleniumOMHandson21stOct.git

website under test:
https://askomdch.com/

Registered user:
testpeterpan
testpeterpan@testing.com
password123
-------------------------------------------------------

Test cases planning to automate:
1) Guest checkout using Direct Bank Transfer
2) Login during checkout using Direct Bank Transfer
-------------------------------------------------------
Test Case 1:(no login,just guest)
Steps high level:
    Navigate to store
    Search for "Blue Shoes"
    Add "Blue Shoes" to the Cart
    Navigated to Cart Page
    Navigates to Checkout Page,adds Billing Address
    Finally goes to Order confirmation Page
-------------------------------------------------------
Test Case 2:(login during checkout)
Steps high level:
    Navigate to store
    Search for "Blue Shoes"
    Add "Blue Shoes" to the Cart
    Navigated to Cart Page
    Navigates to Checkout Page,clicks Login,enter user credentials ,adds Billing Address
    Finally goes to Order confirmation Page
-------------------------------------------------------
RUN tests using maven command line

IMP
1)
before running make sure your Test Java Class under test package, 
has the word Test at the end eg: AccountManagementTest
without Test keyword, mvn test will not pick up your Java Test

2) Now run -> mvn clean test   (tests are executed serially one by one,not in parallel by default)
( at this moment, we donot need Maven sure fireplugin explicitly mentioned in pom.xml)
We will add this Maven sure fire plugin later ,when we drive execution using testng.xml
   You don't necessarily need to declare Surefire explicitly.

However, if you want to run a particular TestNG suite file, explicitly configuring Surefire is useful.



----------------------------------------------------











