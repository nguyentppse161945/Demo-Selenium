package TESTCASE07;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Test
public class testcase07 {
  public static void testSeven(){
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
          driver.findElement(By.xpath("//input[@id='email']")).sendKeys("lailaanhday2@gmail.com");
          driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("12345678");
          driver.findElement(By.xpath("//button[@id='send2']")).click();


          //4. Click on 'My Orders'
          driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")).click();

          Thread.sleep(5000);
          //5. 5. Click on 'View Order'
          driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[6]/span/a[1]")).click();

//          //6. Click on 'Print Order' link
          driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]")).click();


      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
