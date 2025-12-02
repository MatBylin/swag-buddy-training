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

(Writing in progress...) Excersice 4: We have two tests at this point. Our framework lacks synchronization (waiting strategies). There are three basic strategies for waiting: implicit, explicit and fluent wait. (https://www.baeldung.com/selenium-implicit-explicit-wait). We are going to implement explicit (or fluent - choice is yours) wait. To implement it we need to instantiate WebDriverWait object, we want to have one global implementation of it. Implement class WaitProvider in the main/java/wait package. Let this class be responsible for cerating WebDriverWait object based on a timeout defined within framework.properies class. 

