
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Updatingcode {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        driver.get("https://preprod-transient.parkengage.com/parkingpayments/touchless-parking-parking/eyJmYWNpbGl0eV9pZCI6MTQ0LCJnYXRlIjoxMX0=");

        // Wait and click logout icon
        WebElement logoutIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@class='d-inline-block' and @style='height: 25px; width: 25px;']")));
        logoutIcon.click();

        // Click "Sign Up"
        driver.findElement(By.cssSelector(".btn.border-primary.text-primary.w-100.my-4")).click();

        // Fill signup form
        driver.findElement(By.id("fullName")).sendKeys("jonh");
        driver.findElement(By.id("email")).sendKeys("jon086@yopmail.com");
        driver.findElement(By.id("loginInputSingup")).sendKeys("5574134891");
        driver.findElement(By.id("password")).sendKeys("Welcome@123");
        driver.findElement(By.id("confirm_password")).sendKeys("Welcome@123");
        driver.findElement(By.id("formHorizontalCheck")).click();

        driver.findElement(By.cssSelector(".d-flex.justify-content-center.align-items-center")).click();

        // Wait and click "Add New Vehicle"
        WebElement addVehicleBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Add New Vehicle']")));
        addVehicleBtn.click();

        driver.findElement(By.cssSelector(".inputLoginVehicle.form-control")).sendKeys("H22876");
        driver.findElement(By.cssSelector("button.VehicleeAddButton")).click();

        // Wait briefly for model dropdown, then close
        Thread.sleep(500);
        actions.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(500);

        // Select rate option
        WebElement firstRateOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='p-0 m-0 d-flex justify-content-center align-items-center row']//div[1]//div[1]")));
        firstRateOption.click();

        // Wait and click "Add New Card"
        WebElement addCardButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Add New Card']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addCardButton);
        addCardButton.click();

        // Enter card details
        // Fill card details
        driver.findElement(By.id("name_on_card")).sendKeys("test");
        driver.findElement(By.id("card_number")).sendKeys("4761 7310 0000 0043");
        driver.findElement(By.id("expiry")).sendKeys("02/28");
        driver.findElement(By.id("Cvv")).sendKeys("123");

        WebElement addCardSubmit = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[class='btn w-100 my-4 text-white bg-primary'] div[class='d-flex justify-content-center align-items-center']")
        ));
        addCardSubmit.click();



        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog']")));





//// Click Add Card Submit button (do not wait for invisibility before this!)
//        WebElement addCardSubmit = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[contains(@class,'VehicleeAddButton')]")));
//        addCardSubmit.click();

// Wait for modal to disappear AFTER clicking
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog']")));


//        // Wait for modal to disappear before final click
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog']")));

        // Find Start Parking button
        WebElement submitBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".btn.w-100.text-white.bg-primary")));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        Thread.sleep(500);

        // Check if enabled and click
        if (submitBtn.isEnabled()) {
            submitBtn.click();
            System.out.println("✅ Clicked Start Parking button successfully!");
        } else {
            System.out.println("❌ Button is disabled, please check input values!");
        }

        System.out.println("✅ Flow completed successfully!");

        // driver.quit(); // Uncomment if you want to close the browser
    }
}




