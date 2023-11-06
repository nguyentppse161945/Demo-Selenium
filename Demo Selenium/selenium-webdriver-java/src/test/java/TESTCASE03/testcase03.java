package TESTCASE03;

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
    public void cannotAddMore(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        try {
            // 1. Open the target page - Mobile page
            driver.get("http://live.techpanda.org/");

            //2. Click on MOBILE menu
            WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobile']"));
            mobile.click();

            //3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            WebElement addCartSony = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]"));
            addCartSony.click();

            //4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
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

            //6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
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

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
