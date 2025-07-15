import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Transient {
    public static void main(String[] args) throws InterruptedException {
        // Set path to your chromedriver if needed
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("http://staging-transient.rev-pass.com/revpass/touchless-parking-revpass/eyJmYWNpbGl0eV9pZCI6NjczLCJnYXRlIjoxMX0=");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Fill First Name
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
            firstName.sendKeys("John");

            // Fill Last Name
            WebElement lastName = driver.findElement(By.id("last_name"));
            lastName.sendKeys("Doe");

            // Fill Phone
            WebElement phone = driver.findElement(By.id("phone"));
            phone.sendKeys("1234567890");

            // Fill License Plate
            WebElement plate = driver.findElement(By.name("license_plate"));
            plate.sendKeys("XYZ1234");
            // Click 'Hourly'
            WebElement hourlyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[contains(text(),'Hourly')]")));
            hourlyBtn.click();

            // Wait and get caret-up icon
            WebElement upArrow = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//i[contains(@class,'fa-caret-up')])[1]")));

            // Loop until duration text is "3 hours"
            int attempts = 0;
            while (attempts++ < 5) {
                WebElement durationText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'justify-content-between') and contains(translate(text(), 'HOURS', 'hours'), 'hours')]")
                ));


                String text = durationText.getText().trim();
                System.out.println("Current duration: " + text);

                if (text.startsWith("3")) break;  // "3 hours"
                upArrow.click();
                Thread.sleep(600);
            }

            System.out.println("Duration set to 3 hours.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }


        }
        }








