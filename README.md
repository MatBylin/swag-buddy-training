# swag-buddy-training
Repository use for experimental course dedicated to my great friend R@fal.

## Test object 
https://www.saucedemo.com/

## Used libraries
- selenium-java
- testng
- lombok
- hamcrest (how to use hamcrest: https://www.baeldung.com/java-junit-hamcrest-guide)

## Starting point
As a starting point we have almost empty framework with minimum functionality.

## Exercises
:white_check_mark: Excersise 0:
Get familiar with the 'starting point' framework code :)  

:arrows_counterclockwise: Excersise 1:
Implement LoginPage.class page object. Within LoginPage implement locators and methods responsible for login to the application. We will use PageFactory implementation of the POP look here: https://www.browserstack.com/guide/page-object-model-in-selenium.  

Excersice 2: Implement test that validates positive login scenario. Use valid credentials and make sure that login was succesffull (validate products page opened).

Excersice 3: Implement test that validates negative login scenario. Validate that user is left on the login page with validation message displayed. 

Excersice 4: We have two tests at this point but our framework lacks synchronization (waiting strategies). There are three basic strategies for waiting: implicit, explicit and fluent wait. (https://www.baeldung.com/selenium-implicit-explicit-wait). We are going to implement fluent wait. To implement it we need to instantiate FluentWait<WebDriver> object, we want to have one global implementation of creation those objects. TODO:
- Implement class WaitProvider in the main/java/wait package. Let this class be responsible for cerating FluentWait<WebDriver> object based on a timeout and polling defined within framework.properies file. Set timeout to 20s, and polling to 1s by default. Let out wait ignore NoSuchElementException.class and StaleElementReferenceException.class exceptions.
- Additionally give WaitProvider ability to create custom waits upon provided timeouts by user
- In BasePage create field `protected FluentWait<WebDriver> wait;` and instantiate it within BasePage contructor

