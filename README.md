# Creatio Automation

Automation framework made to provide automated testing to Creatio.
Technologies used:
* Selenide
* TestNG
* Allure Reports
* Maven

## Getting Started

These instructions will get you an up and running project your local machine for development and testing
purposes.

### Prerequisites

- Jdk 16
- Maven 3.6.0+

### Installing

- Clone this project and download the Maven dependencies.

## Workflow

Each page in Creatio has its own class, in the form of a page object. The page object contains web element definitions and any relevant methods that do any operation on these elements.
Keep in mind that these classes do not take care of assertions, this will be taken care of in the test class.

### Tests Management

Tests should be divided into sub-packages:
- base - This package contains the base test class in which all the other test classes extend.
- functional - This package contains functional test classes for each tab/page in the application.

You can add more packages as you see fit.

**Write the assertions in the test case itself, not in the page objects**.

### Tests Writing Conventions

There are a few rules and conventions which should be applied when writing your tests:
* Each test class should extend `TestBase`.
* Each test method should be annotated israel2032
* with the TestNG `@Test` annotation, and with Allure `@Description` annotation.
* Each test method should be named with the following syntax: `testUnit_testCondition_expectedResult`.
* If there are several tests in your test class, each test should have a priority.

Example:
```java
    public class Example{
        @Test(priority = 2)
        @Description("Enter valid contact person info and assert the add additional contact is functional.")
        public void eventFormContactPersonInfo_validInfo_isAdditionalContactAdded() {
            myPageObject.getElement().shouldBe(Visible);
        }
}
```

### Test Suite Configuration

TestNG uses xml files to run the test suite. Open one of the xml files and specify the full path of the test classes it
should run. For example:
```xml
    <test name="Personal Details Tab Functional Tests" enabled="true">
        <classes>
            <class name="functional.PersonalDetailsTest"/>
        </classes>
    </test>
``` 

If you want to skip a test, just change `enabled` from `true` to `false`.

### Parameters
There is a parameter that should be inside the suite XML file: `url`.
* url - The application url to navigate.

### Running Tests
You can run the tests from maven either by specifying the xml suite files inside pom.xml, or as an argument:

##### Adding the test file in the pom.xml
```xml
        <suiteXmlFiles>
            <suiteXmlFile>Creatio.xml</suiteXmlFile>
        </suiteXmlFiles>
```
and then `mvn clean test`.
##### Adding the test file as argument
`mvn clean test -DtestFile="Creatio.xml"`

It is possible to run the test s from the IDE as well, as TestNG XML Suite.

### Reports
Allure reports can be generated after running the tests with the command `mvn allure:serve`
