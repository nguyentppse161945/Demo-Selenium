package TESTCASE01;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class testcase1 {
    public void testGetTitle(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Open the target page - Login Form
            driver.get("http://live.techpanda.org/");

            //Step 2. Verify Title of the page
            WebElement pageTitleDiv = driver.findElement(By.className("page-title"));
            WebElement h2Element = pageTitleDiv.findElement(By.tagName("h2"));
            String pageTitle = h2Element.getText();
            System.out.println(pageTitle);

            //Step 3. Click on -> MOBILE -> menu
            WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobile']"));
            mobile.click();

            //Step 4. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement sortByDropdown = driver.findElement(By.cssSelector("select[title='Sort By']"));
            Select select = new Select(sortByDropdown);
            select.selectByVisibleText("Name");

            //Step 5. Verify all products are sorted by name
            List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));
            for (WebElement productName : productNames) {
                System.out.println(productName.getText());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
