package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage2 {
    private WebDriver driver;

    public CartPage2(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        WebElement addIphone = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]"));
        addIphone.click();
    }
}
