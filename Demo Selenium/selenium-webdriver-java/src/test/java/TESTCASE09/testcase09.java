package TESTCASE09;

import POM.CartPage2;
import POM.LoginPage2;
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
public class testcase09{
    public void testSeven(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{

            //1. Go to http://live.techpanda.org/
            SoftAssert softassert= new SoftAssert();
            driver.get("http://live.techpanda.org/");

//           2. Go to Mobile and add IPHONE to cart
            driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a")).click();
            CartPage2 Page = new CartPage2(driver);
            Page.addToCart();
            Thread.sleep(3000);
            //3. Enter Coupon Code
            //bf
            WebElement bfTotElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[5]/span/span"));
            String bfTot = bfTotElem.getText();
            System.out.println("Subtotal before apply is:" + bfTot);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div/input")).sendKeys("GURU50");
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div/div/button[1]")).click();


            // 5. Verify the discount generated
            //after
            WebElement aftTotElem =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span"));
            String aftTot = aftTotElem.getText();

            System.out.println("Subtotal before apply is:" + aftTot);
             AssertJUnit.assertNotSame(bfTot, aftTot);

             if(bfTot.equals(aftTot)){
                 System.out.println("Failed to discount");
             } else System.out.println("Discount successful");

 } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
