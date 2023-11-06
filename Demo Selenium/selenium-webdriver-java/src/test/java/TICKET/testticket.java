package TICKET;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Test
public class testticket {
    public void testTicket() {
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        try {
            // 1. Open the target page - Mobile page
            driver.get("https://icy-ground-0dfceee00.4.azurestaticapps.net/ticket");
            Thread.sleep(2000);
            WebElement clickBuyTicket = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tr[2]/td[3]/div[1]/div[3]/*[name()='svg'][1]/*[name()='path'][2]"));
            clickBuyTicket.click();
            Thread.sleep(2000);
            WebElement clickCheckOut = driver.findElement(By.xpath("//a[@class='Ticket_btn__aD11U']"));
            clickCheckOut.click();


            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
