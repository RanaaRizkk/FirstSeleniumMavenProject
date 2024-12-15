package AutomationDemo.pages;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.ElementActions.click;

public class LoginPage {
    private WebDriver driver;
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private By signUpPage = By.xpath("//a[@href='/login']");
    private By newUserSignUpForm = By.xpath("//div[@class='signup-form']");
    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private String url = ("https://automationexercise.com/");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Navigate to AutomationExercise Url")
    public LoginPage NavigateToUrl() {
        driver.get(url);
        return this;
    }
    @Step("Assert on New User Sign up Text")
    public LoginPage assertOnNewUserSignUpText() {
        click(driver,signUpPage);
        Assert.assertTrue(driver.findElement(newUserSignUpForm).isDisplayed());
        return this;
    }

    @Step("Enter name and email address and Click on Sign up Button")
    public LoginPage signUpEmailandUserName(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        click(driver,signUpButton);
        return this;
    }


}
