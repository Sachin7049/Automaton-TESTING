package Framework.pageobject;


import Framework.AbstractionComponents.Handling;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.List;

public class Productpage extends Handling {

    WebDriver driver;

    public Productpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By productsBy = By.cssSelector(".mb-3");
    By addToCartButton = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.id("toast-container");
    By spinnerBy = By.cssSelector(".ng-animating");

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;


    // Get all products
    public List<WebElement> getProducts() {
        waitForElementToAppear(productsBy);
        return products;
    }



    // Get product by name
    public WebElement getProductByName(String productName) {

        waitForElementToAppear(productsBy);

        return products.stream()
                .filter(p -> p.findElement(By.cssSelector("b"))
                        .getText().trim().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    // Add product to cart
    public void addProductToCart(String productName) {

        WebElement product = getProductByName(productName);

        if (product == null) {
            throw new RuntimeException("Product not found: " + productName);
        }

        WebElement addButton = product.findElement(addToCartButton);

        // wait for animations/loaders
        waitForElementToDisappear(By.cssSelector(".ng-animating"));

        // wait until button is clickable
        waitForElementToBeClickable(addButton);

        // JS click to avoid interception
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);

        // wait for toast confirmation
        waitForElementToAppear(By.id("toast-container"));

    }
    // Navigate to cart (HEADER ELEMENT → JS CLICK)
    public void goToCart() {

        waitForElementToDisappear(toastMessage);
        waitForElementToDisappear(spinnerBy);
        waitForElementToBeClickable(cartButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cartButton);
    }
    }









