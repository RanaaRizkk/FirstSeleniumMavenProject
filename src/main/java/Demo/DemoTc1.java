package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoTc1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");//driver.get
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //name and email in signup page
        driver.findElement(By.name("name")).sendKeys("rana");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("rana@mail.com", Keys.ENTER);
        //select gender
        driver.findElement(By.id("id_gender2")).click();
        //fill the form Account Info
        driver.findElement(By.id("password")).sendKeys("r1234567");
        new Select(driver.findElement(By.id("days"))).selectByValue("21");
        new Select(driver.findElement(By.id("months"))).selectByValue("4");
        new Select(driver.findElement(By.id("years"))).selectByValue("2001");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //Adress info
        driver.findElement(By.id("first_name")).sendKeys("rana");
        driver.findElement(By.id("last_name")).sendKeys("rrr");
        driver.findElement(By.id("company")).sendKeys("Giza");
        driver.findElement(By.id("address1")).sendKeys("Cairo");
        driver.findElement(By.id("address2")).sendKeys("New Cairo");
        new Select(driver.findElement(By.id("country"))).selectByValue("Canada");
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("New Cairo");
        driver.findElement(By.id("zipcode")).sendKeys("23432");
        driver.findElement(By.id("mobile_number")).sendKeys("0123453345");
        //click on submit
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //delete account
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();



    }
}
