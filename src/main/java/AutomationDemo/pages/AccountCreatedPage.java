package AutomationDemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static framework.ElementActions.click;

public class AccountCreatedPage {
    private WebDriver driver;
    private By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    private By continueButtonAfterSignUp = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
    }


    @Step("Assert on Account Created Text")
    public AccountCreatedPage assertOnAccountCreatedText() {
        Assert.assertEquals(driver.findElement(accountCreatedText).getText(), "ACCOUNT CREATED!");
        return new AccountCreatedPage(driver);
    }
    @Step("Click Continue After Sign Up")
    public AccountCreatedPage clickContinueAfterSignUp(){
        click(driver,continueButtonAfterSignUp);
        return new AccountCreatedPage(driver);
    }


}
