package Automation;


import Automation.testComponent.BaseTest;
import Framework.pageobject.Landingpage;
import Framework.pageobject.Productpage;
import Framework.pageobject.Cardpage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Error_validation extends BaseTest {

    @Test
    public void submitOrderErrorValidation() {

        Landingpage page = new Landingpage(driver);

        page.loginpage("testuser1234@yopmail.com", "Welcome@123");

        String actualError = page.errormessage();
        Assert.assertEquals(actualError, "Incorrect email or password.");
    }

    @Test
    public void productionValidation() {

        String productname = "ZARA COAT 3";

        Landingpage page = new Landingpage(driver);
        page.loginpage("sachinrathore@yopmail.com", "Welcome@123");

        Productpage productpage = new Productpage(driver);
        productpage.addProductToCart(productname);
        productpage.goToCart();

        Cardpage cardpage = new Cardpage(driver);
        Boolean match = cardpage.verifyProductDisplay(productname);

        Assert.assertTrue(match, "Product not found in cart");
    }
}
