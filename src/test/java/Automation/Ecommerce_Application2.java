package Automation;

import Framework.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Ecommerce_Application2 {
    public static void main(String[] args) throws InterruptedException {

        String productname = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();

        Landingpage page = new Landingpage(driver); //from page object model

        page.loginpage("testuser1234@yopmail.com", "Welcome@123");

        Productpage productpage = new Productpage(driver);


        productpage.addProductToCart(productname);


        productpage.goToCart();

        Cardpage cardpage = new Cardpage(driver);


        Boolean match = cardpage.verifyProductDisplay(productname);
        Assert.assertTrue(match, "Product not found in cart");

        cardpage.Cardtoclick();

        Checkoutpage checkoutpage = new Checkoutpage(driver);
        checkoutpage.selectCountry("India");
       checkoutpage.submitOrder();

        Confirmation confirmation = new Confirmation(driver);
        String message = confirmation.getConfirmationMessage();

        Assert.assertEquals(message, "Thankyou for the order.");

        driver.quit();



    }
}
