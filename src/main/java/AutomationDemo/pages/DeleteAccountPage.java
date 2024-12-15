package AutomationDemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static framework.ElementActions.click;

public class DeleteAccountPage {
    private WebDriver driver;
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private By continueBtnAfterDelete = By.xpath("//a[@data-qa='continue-button']");

    public DeleteAccountPage(WebDriver driver){
        this.driver = driver;
    }


    @Step("Assert on Account Deleted Text")
    public DeleteAccountPage assertOnAccountDeletedText() {
        Assert.assertEquals(driver.findElement(accountDeletedText).getText(), "ACCOUNT DELETED!");
        return this;
    }

    @Step("Click Continue After Account Deleted")
    public DeleteAccountPage clickContinueAfterAccDelete() {
        click(driver,continueBtnAfterDelete);
        return this;
    }
}
