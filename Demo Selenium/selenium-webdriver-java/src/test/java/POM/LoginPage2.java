package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 {
    private WebDriver driver;

    public LoginPage2(WebDriver driver) {
        this.driver = driver;
    }
    public void loginAccount (String email, String password) {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div/div/form/div/div[5]/input")).click();

    }
}
