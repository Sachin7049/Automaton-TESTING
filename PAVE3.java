
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;

public class PAVE3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://preprod-transient.parkengage.com/parkingpayments/touchless-parking-parking/eyJmYWNpbGl0eV9pZCI6MTQ0LCJnYXRlIjoxMX0=");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@class='d-inline-block' and @style='height: 25px; width: 25px;']")
        ));

// Small pause to ensure it's interactable
        Thread.sleep(500);
        logoutIcon.click();

        driver.findElement(By.cssSelector(".btn.border-primary.text-primary.w-100.my-4")).click();

        driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("jonh");
        driver.findElement(By.cssSelector("#email")).sendKeys("jon90086@yopmail.com");
        driver.findElement(By.id("loginInputSingup")).sendKeys("5573300891");

        driver.findElement(By.cssSelector("#password")).sendKeys("Welcome@123");
        driver.findElement(By.id("confirm_password")).sendKeys("Welcome@123");
        driver.findElement(By.id("formHorizontalCheck")).click();

        driver.findElement(By.cssSelector(".d-flex.justify-content-center.align-items-center")).click();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        //span[normalize-space()='Add New Vehicle']
        WebElement addVehicleBtn = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Add New Vehicle']")));
        addVehicleBtn.click();
//        driver.findElement(By.xpath("(//span[normalize-space()='Add New Vehicle']")).click();
        driver.findElement(By.cssSelector(".inputLoginVehicle.form-control")).sendKeys("H52876");
        driver.findElement(By.cssSelector("button[class='btn w-100 my-4 text-white bg-primary VehicleeAddButton'] div[class='d-flex justify-content-center align-items-center']")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(500); // Wait for dropdown to close

// Now click on the rate div
        driver.findElement(By.xpath("//div[@class='p-0 m-0 d-flex justify-content-center align-items-center row']//div[1]//div[1]")).click();


        WebElement addCardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Add New Card']")
        ));

        // Scroll to button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addCardButton);

        // Close any dropdowns again if needed
        actions.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(500);

        // Wait and click
        wait.until(ExpectedConditions.elementToBeClickable(addCardButton)).click();

        // Enter card details
        driver.findElement(By.id("name_on_card")).sendKeys("test");
        driver.findElement(By.id("card_number")).sendKeys("4761 7310 0000 0043");
        driver.findElement(By.id("expiry")).sendKeys("02/28");
        driver.findElement(By.id("Cvv")).sendKeys("123");

        // Click final "Add Card" button (double-check the correct selector if needed)
        WebElement addCardSubmit = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[class='btn w-100 my-4 text-white bg-primary'] div[class='d-flex justify-content-center align-items-center']")
        ));
        addCardSubmit.click();



        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog']")));

// Find button
        WebElement submitBtn = driver.findElement(By.cssSelector(".btn.w-100.text-white.bg-primary"));

// Check enabled
        if (submitBtn.isEnabled()) {
            submitBtn.click();
            System.out.println("✅ Clicked Start Parking button!");
        } else {
            System.out.println("❌ Button is disabled, please check required fields.");
        }

        // Scroll and click
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addCardSubmit);
//        addCardSubmit.click();


//

//
    }
}








