package Automation;

import Automation.testComponent.BaseTest;
import Framework.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.io.IOException;

public class Ecommerce_Application3  extends BaseTest {
    String productname = "ZARA COAT 3";

    @Test(dataProvider = "dpMethod",groups = {"Purchase"})

    public void sumbitorder(String email, String password, String productname) {

        Landingpage page = new Landingpage(driver);
                              // use page class for URL
        page.loginpage(email, password);

        Productpage productpage = new Productpage(driver);
        productpage.addProductToCart(productname);
        productpage.goToCart();

        Cardpage cardpage = new Cardpage(driver);
        Assert.assertTrue(cardpage.verifyProductDisplay(productname));

        cardpage.Cardtoclick();

        Checkoutpage checkoutpage = new Checkoutpage(driver);
        checkoutpage.selectCountry("India");
        checkoutpage.submitOrder();

        Confirmation confirmation = new Confirmation(driver);
        Assert.assertEquals(confirmation.getConfirmationMessage(), "THANKYOU FOR THE ORDER.");


    }

    @Test(dependsOnMethods = {"sumbitorder"})
    public void Orderlistingtest() {
        Landingpage page = new Landingpage(driver);

        page.loginpage("testuser1234@yopmail.com", "Welcome@123");

        Myorders myorders = new Myorders(driver);
        System.out.println(myorders);
        Assert.assertTrue(myorders.verifyOrder(productname));

    }


    @Test
    @DataProvider
    public Object[][] dpMethod() {
        return new Object[][]{{"testuser1234@yopmail.com", "Welcome@123", "ZARA COAT 3"}, {"sachinrathore@yopmail.com", "Welcome@123", "iphone 13 pro"}
        };
    }
}


