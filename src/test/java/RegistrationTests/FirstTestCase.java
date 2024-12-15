package RegistrationTests;
import AutomationDemo.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.JsonFileManager;
import utilities.PropertiesReader;
import static framework.DriverFactory.initiateDriver;


public class FirstTestCase {
    WebDriver driver;
    private JsonFileManager testData;;


    @Step("Open the browser and Maximize it")
    @BeforeMethod
    public void beforeMethod() {
        PropertiesReader.loadProperties();
        driver = initiateDriver(System.getProperty("browserType"), true);
        testData = new JsonFileManager("src/test/resources/TestDataJsonFile/TestData.json");
    }


    @Test(description = "Test Case 1: Register User")
    @Severity(SeverityLevel.CRITICAL)
    public void testTc1() {
        new LoginPage(driver)
                .NavigateToUrl();
        new MainMenuHeader(driver)
                .clickOnSignUpButton();
        new LoginPage(driver)
                .assertOnNewUserSignUpText()
                .signUpEmailandUserName(testData.getTestData("name"),testData.getTestData("email"));
        new CreateAccountPage(driver)
                .assertOnAccountInfoText()
                .fillAccountInfo(testData.getTestData("pass"),testData.getTestData("Days"),testData.getTestData("Months"),testData.getTestData("years"))
                .selectCheckboxForNewsLetter()
                .selectCheckboxforOffers()
                .fillAddressInfo(testData.getTestData("FirstName"),testData.getTestData("LastName"),testData.getTestData("Company"),testData.getTestData("FirstAddress"),"5th settlement","Canada","Cairo","5th settlement","112334","0123454565456")
                .clickOnSubmitButton();
        new AccountCreatedPage(driver)
                .assertOnAccountCreatedText()
                .clickContinueAfterSignUp();
        new MainMenuHeader(driver)
                .clickOnDeleteButton();
        new DeleteAccountPage(driver)
                .assertOnAccountDeletedText()
                .clickContinueAfterAccDelete();


    }


    @AfterMethod
    @Step("Quit the Browser")
    public void AfterMethod() {
        driver.quit();
    }
}
