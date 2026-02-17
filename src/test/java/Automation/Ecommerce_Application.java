package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Ecommerce_Application {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        String productname="ZARA COAT 3";

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("userEmail")).sendKeys("testuser1234@yopmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Welcome@123");
        driver.findElement(By.id("login")).click();

//        Landingpage page =new Landingpage(driver);

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mb-3"), 0));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().trim().equalsIgnoreCase(productname)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


        // Wait for toast
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#toast-container")));

// Wait for animation loader to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".ng-animating")));

// Cart click – bulletproof
        WebElement cartBtn = driver.findElement(
                By.cssSelector("[routerlink*='cart']")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", cartBtn);

        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBtn);





        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
        List<WebElement> cardproducts=driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean match = cardproducts.stream().anyMatch(cardproduct->cardproduct.getText().equalsIgnoreCase(productname));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions action =new Actions(driver);
        action.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("//span[normalize-space()=\"India\"]//i")).click();

        driver.findElement(By.xpath(" //a[normalize-space()=\"Place Order\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".hero-primary"))));
        String confirm= driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(confirm.equalsIgnoreCase("Thankyou for the order."));
        System.out.println(confirm);





        driver.close();




    }
}
