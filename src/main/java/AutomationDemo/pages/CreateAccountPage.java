package AutomationDemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static framework.ElementActions.click;

public class CreateAccountPage {
    private WebDriver driver;
    private By accountInfoText = By.xpath("//b[text()='Enter Account Information']");
    private By selectingGender = By.id("id_gender2");
    private By password = By.id("password");
    private By selectingDays = By.id("days");
    private By selectingMonths = By.id("months");
    private By selectingYears = By.id("years");
    private By selectNewsLetter = By.id("newsletter");
    private By selectRecieveOffers = By.id("optin");
    private By first_name = By.id("first_name");
    private By last_name = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile_number = By.id("mobile_number");
    private By submitButton = By.xpath("//button[@type='submit']");

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Assert on Account Information Text")
    public CreateAccountPage assertOnAccountInfoText() {
        Assert.assertTrue(driver.findElement(accountInfoText).isDisplayed());
        return new CreateAccountPage(driver);
    }

    @Step(" Fill Account Information: Title, Name, Email, Password, Date of birth")
    public CreateAccountPage fillAccountInfo(String Pass, String Days, String months, String years) {
        click(driver,selectingGender);
        //fill the form Account Info
        driver.findElement(password).sendKeys(Pass);
        new Select(driver.findElement(selectingDays)).selectByValue(Days);
        new Select(driver.findElement(selectingMonths)).selectByValue(months);
        new Select(driver.findElement(selectingYears)).selectByValue(years);
        return new CreateAccountPage(driver);
    }

    @Step(" Select checkbox 'Sign up for our newsletter!'")
    public CreateAccountPage selectCheckboxForNewsLetter() {
        click(driver,selectNewsLetter);
        return new CreateAccountPage(driver);
    }

    @Step("Select checkbox 'Receive special offers from our partners!'")
    public CreateAccountPage selectCheckboxforOffers() {
        click(driver,selectRecieveOffers);
        return new CreateAccountPage(driver);
    }

    @Step(" Fill Address Information: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public CreateAccountPage fillAddressInfo(String FirstName, String LastName, String Company, String FirstAddress, String SecondAddress, String Country, String State, String City, String ZipCode, String MobileNumber) {
        //Adress info
        driver.findElement(first_name).sendKeys(FirstName);
        driver.findElement(last_name).sendKeys(LastName);
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(FirstAddress);
        driver.findElement(address2).sendKeys(SecondAddress);
        new Select(driver.findElement(country)).selectByValue(Country);
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(ZipCode);
        driver.findElement(mobile_number).sendKeys(MobileNumber);
        return new CreateAccountPage(driver);
    }

    @Step("Click on Submit Button")
    public CreateAccountPage clickOnSubmitButton() {
        //click on submit
        click(driver,submitButton);
        return new CreateAccountPage(driver);
    }

}
