package BAITAP;


import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase05 {
    public void Test_05() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");


            // 2. Click on my account link
            WebElement accElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]"));
            accElem.click();
            WebElement myAccElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[5]/div/ul/li[1]/a"));
            myAccElem.click();

            // 3. Click Create an Account link and fill New User information excluding the registered Email ID.
            WebElement createAccElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/a/span/span"));
            createAccElem.click();
            WebElement firstNameElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[1]/div/input"));
            firstNameElem.sendKeys("Nguyen");
            WebElement midNameElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[2]/div/input"));
            midNameElem.sendKeys("La");
            WebElement lastNameElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[3]/div/input"));
            lastNameElem.sendKeys("Lai");
            WebElement emailElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[2]/div/input"));
            emailElem.sendKeys("lailanguyen@gmail.com");
            WebElement pwdElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[3]/div[1]/div/input"));
            pwdElem.sendKeys("123456");
            WebElement cfmPwdElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[3]/div[2]/div/input"));
            cfmPwdElem.sendKeys("123456");

            // 4. Click Register
            WebElement regisElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[2]/button/span/span"));
            regisElem.click();

            // 5. Verify Registration is done. Expected account registration done.
            WebElement successElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span"));
            AssertJUnit.assertEquals("Thank you for registering with Main Website Store.", successElem.getText());

            // 6. Go to TV menu

            WebElement menuElem = driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[2]/a"));
            menuElem.click();

            // 7. Add product in your wish list - use product - LG LCD
            WebElement addElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
            addElem.click();

            // 8. Click SHARE WISHLIST
            WebElement shareElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]"));
            shareElem.click();


            // 9. In next page enter Email and a message and click SHARE WISHLIST
            WebElement emailInsertElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[1]/ul/li[1]/div/textarea"));
            emailInsertElem.sendKeys("dungntse171487@fpt.edu.vn");
            WebElement messageElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[1]/ul/li[2]/div/textarea"));
            messageElem.sendKeys(":)");

            WebElement shareWLElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[2]/button/span/span"));
            shareWLElem.click();

            // 10. Check wishlist is shared. Expected wishlist shared successfully.
            WebElement sucElem = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span"));
            AssertJUnit.assertEquals("Your Wishlist has been shared.", sucElem.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}