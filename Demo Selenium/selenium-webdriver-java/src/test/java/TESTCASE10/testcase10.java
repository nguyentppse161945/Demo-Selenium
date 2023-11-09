package TESTCASE10;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import POM.LoginPage2;

import java.io.File;
import java.time.Duration;

@Test
public class testcase10{
    public void testSeven(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{

            //1. Go to http://live.techpanda.org/
            SoftAssert softassert= new SoftAssert();
            driver.get("http://live.techpanda.org/index.php/backendlogin");

//           2.  Login the credentials provided

            LoginPage2 loginPage = new LoginPage2(driver);
            loginPage.loginAccount("user01","guru99com");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/a")).click();


//
////            3. Go to Sales-> Orders menu
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a")).click();

            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a")).click();

            //4. Input OrderId and FromDate -> ToDate

            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[2]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[2]/div/input")).sendKeys("100021274");

            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[1]/input")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[1]/input")).sendKeys("11/07/2023");
//
            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[2]/input")).clear();
            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[2]/input")).sendKeys("11/10/2023");

            driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/table/tbody/tr/td[3]/button[2]")).click();

            File destDirectory = new File("C:\\Users\\immor\\OneDrive\\Máy tính\\Demo-Selenium\\Demo Selenium\\selenium-webdriver-java\\src\\test\\java\\Capture");
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File screenshot1 = screenshot.getScreenshotAs(OutputType.FILE);
            File filterPage = new File(destDirectory, "TC10-Filter.png");
            FileHandler.copy(screenshot1, filterPage);


            softassert.assertAll();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
