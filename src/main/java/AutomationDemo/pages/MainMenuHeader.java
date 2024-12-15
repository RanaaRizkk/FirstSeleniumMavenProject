package AutomationDemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static framework.ElementActions.click;

public class MainMenuHeader {
    private WebDriver driver;
    private By loginPage = By.xpath("//a[@href='/login']");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");

    public MainMenuHeader(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click on 'Signup / Login' button")
    public MainMenuHeader clickOnSignUpButton(){
        click(driver,loginPage);
        return this;
    }
    @Step("Click on Delete Button")
    public MainMenuHeader clickOnDeleteButton(){
        click(driver,deleteAccountButton);
        return this;
    }



}
