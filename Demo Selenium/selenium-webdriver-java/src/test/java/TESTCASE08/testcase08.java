package TESTCASE08;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import POM.LoginPage;

import java.time.Duration;

@Test
public class testcase08 {
    public void testSeven(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{

            //1. Go to http://live.techpanda.org/
            SoftAssert softassert= new SoftAssert();
            driver.get("http://live.techpanda.org/");

            //2. Click on my account link
            driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();

            //3. Login in application using previously created credential
            driver.findElement(By.xpath("//a[contains(@title,'Log In')]")).click();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAccount("hahahahe@gmail.com","12345678");
//            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("lailaanhday2@gmail.com");
//            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("12345678");
//            driver.findElement(By.xpath("//button[@id='send2']")).click();


            //4. Click on 'REORDER' link , change QTY & click Update
            driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[2]")).click();

            //bf
            WebElement bfTotElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span"));
            String bfTot = bfTotElem.getText();

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).click();
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).clear();
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).sendKeys("27");
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button")).click();



             // 5. Verify Grand Total is changed
            //after
            WebElement aftTotElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span"));
            String aftTot = aftTotElem.getText();
            System.out.println(aftTot);
            AssertJUnit.assertNotSame(bfTot, aftTot);

//             //6. Complete Billing & Shipping Information
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]/ul/li/button")).click();
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/ul/li[3]/label")).click();
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[2]/input")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")).click();
            Thread.sleep(3000);
//           submit order
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button")).click();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
