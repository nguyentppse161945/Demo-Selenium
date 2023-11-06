package TESTCASE02;

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
public class testcase2 {
    public void testCompare() {
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        try {
            // 1. Open the target page - Mobile page
            driver.get("http://live.techpanda.org/");

            // 2. Click on -> MOBILE -> menu
            WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobile']"));
            mobile.click();

            //3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
            WebElement priceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String cost = priceElement.getText();
            System.out.println("Cost of Sony Xperia: " + cost);

            // 4. Click on Sony Xperia mobile
            WebElement navigateSony = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            navigateSony.click();

            //5. Read the Sony Xperia mobile from detail page.
            WebElement addToCompareSony = driver.findElement(By.xpath("//a[@class='link-compare']"));
            addToCompareSony.click();
            WebElement navigateToSortList = driver.findElement(By.xpath("//a[contains(@class,'level0')][normalize-space()='Mobile']"));
            navigateToSortList.click();

            // 6. Compare Product value in list and details page should be equal ($100)
            WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[title='Sort By']")));

            Select select = new Select(sortByDropdown);
            select.selectByVisibleText("Price");
///


            WebElement addToCompare = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[2]/a[1]"));
            addToCompare.click();

            WebElement addToCompare2 = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
            addToCompare2.click();
            Thread.sleep(2200);
            String cost1 = priceElement.getText();
            System.out.println("Cost of Sony Xperia: " + cost1);
            System.out.println(addToCompare);

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
