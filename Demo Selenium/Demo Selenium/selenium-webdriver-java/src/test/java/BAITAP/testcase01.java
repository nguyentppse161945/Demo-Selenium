package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;



@Test
public class testcase01 {
    public void test1(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //Step 2. Verify Title of the page
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement titElem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("page-title"))));
            AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", titElem.getText());
            //Step 3. Click on -> MOBILE -> menu
            WebElement mobileElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
            mobileElem.click();
            //Step 4. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement sortElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
            Select select = new Select(sortElem);
            select.selectByVisibleText("Name");
            //Step 5. Verify all products are sorted by name
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, srcFile);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}