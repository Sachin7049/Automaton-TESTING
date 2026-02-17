package Framework.stepsDefination;

import Automation.testComponent.BaseTest;
import Framework.pageobject.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


import java.io.IOException;

public class StepsDefinitionImpl extends BaseTest {

    Landingpage page;
    Productpage productpage;
    Cardpage cardpage;
    Checkoutpage checkoutpage;
    Confirmation confirmation;

    @Given("I am on the homepage of the ecommerce application")
    public void i_am_on_the_homepage_of_the_ecommerce_application() throws IOException {
        launchApplication();
        page = new Landingpage(driver);
        productpage = new Productpage(driver);
        cardpage = new Cardpage(driver);
        checkoutpage = new Checkoutpage(driver);
        confirmation = new Confirmation(driver);
    }

    @Given("Login with name {string} and password {string}")
    public void login_with_name_and_password(String email, String password) {
        page.loginpage(email, password);
    }

    @When("I add {string} to the cart")
    public void i_add_product_to_the_cart(String product) {
        productpage.addProductToCart(product);
        productpage.goToCart();
    }

    @When("I checkout {string} and submit the order")
    public void i_checkout_and_submit_the_order(String product) {
        Assert.assertTrue(cardpage.verifyProductDisplay(product));
        cardpage.Cardtoclick();
        checkoutpage.selectCountry("India");
        checkoutpage.submitOrder();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(
                confirmation.getConfirmationMessage(),
                expectedMessage
        );
    }

}

