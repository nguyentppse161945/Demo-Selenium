package TESTCASE06;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Test
public class testcase6 {
//    public void testSix(){
//        WebDriver driver = driverFactory.getChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
//        try {
//            // 1. Open the target page - Mobile page
//            driver.get("http://live.techpanda.org/");
//
//            //2.  Click on my account link
//            WebElement clickAccout = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
//            clickAccout.click();
//
//            WebElement clickRegister = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
//            clickRegister.click();
//
//            //3. Login in application using previously created credential
//            WebElement enterEmail = driver.findElement(By.xpath("//input[@id='email']"));
//            enterEmail.clear();
//            enterEmail.sendKeys("loc@gmail.com");
//            enterEmail.click();
//
//            WebElement enterPassword = driver.findElement(By.xpath("//input[@id='pass']"));
//            enterPassword.clear();
//            enterPassword.sendKeys("123456789");
//            enterPassword.click();
//
//            WebElement clickBtnLogin = driver.findElement(By.xpath("//button[@id='send2']"));
//            clickBtnLogin.click();
//
//            //4. Click on MY WISHLIST link
//            WebElement clickMobile = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
//            clickMobile.click();
//
//            WebElement clickAddToWishList = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[1]/a[1]"));
//            clickAddToWishList.click();
//
//            WebElement clickMyWishList= driver.findElement(By.xpath("//strong[normalize-space()='My Wishlist']"));
//            clickMyWishList.click();
//
//            //5. In next page, Click ADD TO CART link
//            WebElement clickAddToCart= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/button[1]/span[1]/span[1]"));
//            clickAddToCart.click();
//
//
//            WebElement selectedOptions = select.getOptions("//select[@id='country']");
//            Select selectCountry = new Select(selectedOptions);
//            selectCountry.selectByValue("United States");
//
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        driver.quit();
//    }

    public static void testSix(){
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
            driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();

            //4. Click on MY WISHLIST link
            driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();

            //5. In next page, Click ADD TO CART link
            driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();

            //6. Enter general shipping country, state/province and zip for the shipping cost estimate
            WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
            Select countrySelect = new Select(country);
            countrySelect.selectByValue("US");

            WebElement state = driver.findElement(By.xpath("//select[@id='region_id']"));
            Select stateSelect = new Select(state);
            stateSelect.selectByValue("2");
            driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("1111");

            //7. Click Estimate
            driver.findElement(By.xpath("//span[contains(text(),'Estimate')]")).click();
            WebElement price = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span"));

            //8. Verify Shipping cost generated
            WebElement priceName = driver.findElement(By.cssSelector("dl[class='sp-methods'] dt"));
            softassert.assertEquals(priceName.getText(), "Flat Rate");
            System.out.println(priceName.getText() +": " + price.getText());

            //9. Select Shipping Cost, Update Total
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[2]/dl[1]/dd[1]/ul[1]/li[1]/label[1]")).click();
            driver.findElement(By.xpath("//button[@title='Update Total']")).click();

            //10. Verify shipping cost is added to total
            WebElement genratePrice = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)"));
            WebElement newPrice = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span"));
            softassert.assertEquals(newPrice.getText(),genratePrice.getText());

            //11. Click "Proceed to Checkout"
            driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();

            //12a. Enter Billing Information, and click Continue
            try {
                Select sAddr = new Select(driver.findElement(By.name("billing_address_id")));
                int sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception e){
                System.out.println("Bliing drop down error ");
            }
            driver.findElement(By.xpath("//input[@id='billing:firstname']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='billing:middlename']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='billing:lastname']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='billing:company']")).sendKeys("FPT");
            driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys("123 ABC");
            driver.findElement(By.xpath("//input[@id='billing:street2']")).sendKeys("456 ABC");
            driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys("United States");
            WebElement selectCountry = driver.findElement(By.xpath("//select[@id='billing:country_id']"));
            Select checkoutCountry = new Select(selectCountry);
            checkoutCountry.selectByValue("US");

            WebElement region = driver.findElement(By.xpath("//select[@id='billing:region_id']"));
            Select regionSelect = new Select(region);
            regionSelect.selectByValue("2");
            driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys("1111");
            driver.findElement(By.xpath("//input[@id='billing:telephone']")).sendKeys("0123456789");
            driver.findElement(By.xpath("//input[@id='billing:fax']")).sendKeys("123456789");
            driver.findElement(By.xpath("//label[@for='billing:use_for_shipping_no']")).click();
            driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

            Thread.sleep(3000);

            //12b. Enter Shipping Information, and click Continue
            try {
                Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
                int sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception e){
                System.out.println("shipping drop down error ");
            }

            driver.findElement(By.xpath("//input[@id='shipping:firstname']")).clear();
            driver.findElement(By.xpath("//input[@id='shipping:firstname']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='shipping:middlename']")).clear();
            driver.findElement(By.xpath("//input[@id='shipping:middlename']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='shipping:lastname']")).clear();
            driver.findElement(By.xpath("//input[@id='shipping:lastname']")).sendKeys("Ha");

            driver.findElement(By.xpath("//input[@id='shipping:company']")).clear();
            driver.findElement(By.xpath("//input[@id='shipping:company']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='shipping:street1']")).clear();
            driver.findElement(By.xpath("//input[@id='shipping:street1']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='shipping:street2']")).clear();
            driver.findElement(By.xpath("//input[@id='shipping:street2']")).sendKeys("Ha");
            driver.findElement(By.xpath("//input[@id='shipping:city']")).sendKeys("United States");
            WebElement selectedCountry = driver.findElement(By.xpath("//select[@id='shipping:country_id']"));
            Select checkout = new Select(selectedCountry);
            checkout.selectByValue("US");

            //13. In Shipping Method, Click Continue
            WebElement regioned = driver.findElement(By.xpath("//select[@id='shipping:region_id']"));
            Select selectedRegion = new Select(regioned);
            selectedRegion.selectByValue("2");
            driver.findElement(By.xpath("//input[@id='shipping:postcode']")).sendKeys("1111");
            driver.findElement(By.xpath("//input[@id='shipping:telephone']")).sendKeys("0123456789");
            driver.findElement(By.xpath("//input[@id='shipping:fax']")).sendKeys("123456789");
            driver.findElement(By.xpath("//button[@onclick='shipping.save()']")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();

            Thread.sleep(1000);

            //14. In Payment Information select 'Check/Money Order' radio button. Click Continue
            driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();
            driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();

            Thread.sleep(1000);

            //15. Click 'PLACE ORDER' button
            driver.findElement(By.xpath("//button[@title='Place Order']")).click();


            Thread.sleep(1000);

            //16. Verify Oder is generated. Note the order number
            WebElement orderId = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
            System.out.println("Your order # is: " + orderId.getText());
            WebElement verify = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
            softassert.assertEquals(verify.getText(),"YOUR ORDER HAS BEEN RECEIVED.");
            softassert.assertAll();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
