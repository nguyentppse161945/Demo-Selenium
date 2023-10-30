package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class testcase02 {
    public void test2() {
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        try {
            // 1. Open the target page - Mobile page
            driver.get("http://live.techpanda.org/index.php/mobile.html");

            // 2. Locate the product compare price for "Sony Xperia"
            WebElement priceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));

            WebElement navigateSony = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            navigateSony.click();

            WebElement addToCompareSony = driver.findElement(By.xpath("//a[@class='link-compare']"));
            addToCompareSony.click();
            //Navigate to sort list by Price
            WebElement navigateToSortList = driver.findElement(By.xpath("//a[contains(@class,'level0')][normalize-space()='Mobile']"));
            navigateToSortList.click();

            // 3. sort by price


            WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[title='Sort By']")));

            Select select = new Select(sortByDropdown);

            // Select the option with text "Name"
            select.selectByVisibleText("Price");


            WebElement addToCompare = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[2]/a[1]"));
            addToCompare.click();

            WebElement addToCompare2 = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
            addToCompare2.click();
            Thread.sleep(50000000);
            // 3. Extract and print the price of Sony Xperia
            String cost = priceElement.getText();
            System.out.println("Cost of Sony Xperia: " + cost);
            System.out.println(addToCompare);

            Thread.sleep(50000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}