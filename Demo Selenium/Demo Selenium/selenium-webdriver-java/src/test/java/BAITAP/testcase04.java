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
public class testcase04 {
    public void ableCompareProduct(){
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        try {
            // 1. Open the target page - Mobile page
            driver.get("http://live.techpanda.org/");
            //2. Click on MOBILE menu
            WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobile']"));
            mobile.click();

            WebElement getSonyTitle = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            WebElement getIphoneTitle = driver.findElement(By.xpath("//a[@title='IPhone'][normalize-space()='IPhone']"));
            String sonyTitle = getSonyTitle.getText();
            String iphoneTitle = getIphoneTitle.getText();
            System.out.println("IphoneTitle: "+ iphoneTitle);
            System.out.println("SonyTitle: "+ sonyTitle);

            // 3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
            WebElement compareSony = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]"));
            compareSony.click();
            WebElement compareIphone = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/div[1]/div[3]/ul[1]/li[2]/a[1]"));
            compareIphone.click();

            //4. Click on �COMPARE� button. A popup window opens
            WebElement clickCompare = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
            clickCompare.click();
            Thread.sleep(2000);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //5. Verify the pop-up window and check that the products are reflected in it
            WebElement getHead = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/h1[1]"));
            String headTitle = getHead.getText();
            System.out.println("compHead = " + headTitle);

            WebElement getPopIphone = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/h2[1]/a[1]"));
            String popIphone = getPopIphone.getText();
            WebElement getPopSony = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/h2[1]/a[1]"));
            String popSony = getPopSony.getText();

            System.out.println("popMobile1 = " + popIphone);
            System.out.println("popMobile2 = " + popSony);

            WebElement closeWindow = driver.findElement(By.xpath("//span[contains(text(),'Close Window')]"));
            closeWindow.click();

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
