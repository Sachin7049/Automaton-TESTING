package Automation;

import Automation.testComponent.BaseTest;
import Framework.pageobject.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Ecommerce_Application_json extends BaseTest {
   String productname = "ZARA COAT 3";

    @Test(dataProvider = "dpMethod",groups = {"Purchase"})

    public void sumbitorder(HashMap<String,String> input) {

        Landingpage page = new Landingpage(driver);
                           // use page class for URL
        page.loginpage(input.get("email"),input.get("password"));

        Productpage productpage = new Productpage(driver);
        productpage.addProductToCart(input.get("product"));
        productpage.goToCart();

        Cardpage cardpage = new Cardpage(driver);
        Assert.assertTrue(cardpage.verifyProductDisplay(input.get("product")));

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
    public Object[][] dpMethod() throws IOException {

//        HashMap<String ,String> map=new HashMap<>();
//        map.put("email","testuser1234@yopmail.com");
//        map.put("password","Welcome@123");
//        map.put("product","ZARA COAT 3");
//        HashMap<String ,String> map2=new HashMap<>();
//        map2.put("email","sachinrathore@yopmail.com");
//        map2.put("password","Welcome@123");
//        map2.put("product","iphone 13 pro");
       List<HashMap<String,String>>  data = getJsonDataToMap(  System.getProperty("user.dir") +
               "\\src\\main\\java\\Framework\\Jsondata\\datprovide.json");


       return new Object[][]{{data.get(0)},{data.get(1)}};
    }
}


