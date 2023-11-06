package BAITAP;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class testcase03 {
    public void test3(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2 2. Click on �MOBILE� menu
            WebElement mobileElem = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileElem.click();

            //3.. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            WebElement add = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]"));
            add.click();

            //4 change quantity
            WebElement quantity = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]"));
            quantity.clear();
            quantity.sendKeys("1000");
            quantity.click();
            Thread.sleep(2000);

            WebElement clickUpdate = driver.findElement(By.xpath("//button[@title='Update']"));
            clickUpdate.click();

            //5. Verify the error message
            WebElement getError = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]"));
            String error = getError.getText();
            AssertJUnit.assertEquals("The requested quantity for 'Sony Xperia' is not available", error);
            System.out.println("error: " + error);

            //6.read message
            WebElement clickEmpty = driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]"));
            clickEmpty.click();
            Thread.sleep(2000);

            WebElement getEmptyError = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]"));
            String showEmpty = getEmptyError.getText();
            System.out.println("Show Empty: " + showEmpty);

            //7. Verify cart is empty
            WebElement empty = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/p[1]"));
            String vertifyEmpty = empty.getText();
            System.out.println("Text Vertify Empty: " + vertifyEmpty);



            Thread.sleep(50000000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
