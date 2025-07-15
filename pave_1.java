import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class pave_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://preprod-transient.parkengage.com/parkingpayments/touchless-parking-parking/eyJmYWNpbGl0eV9pZCI6MTQ0LCJnYXRlIjoxMX0=");
            driver.findElement(By.id("phone")).sendKeys("8096993749");
            driver.findElement(By.id("license_plate")).sendKeys("h90079");
            Thread.sleep(100);
            driver.findElement(By.xpath("//div[@class='p-0 m-0 d-flex justify-content-center align-items-center row']//div[1]//div[1]")).click();

            driver.findElement(By.id("name_on_card")).sendKeys("test");
            driver.findElement(By.id("card_number")).sendKeys("4761 7310 0000 0043");
            driver.findElement(By.id("expiry")).sendKeys("02/28");
            driver.findElement(By.id("Cvv")).sendKeys("123");

        Thread.sleep(100);
            WebElement btn = driver.findElement(By.xpath("//button[@name='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        By.xpath("//div[contains(@class, 'd-flex') and contains(@class, 'justify-content-center') and contains(@class, 'align-items-center')]").findElement(driver).click();
        Thread.sleep(5);
        driver.findElement(By.cssSelector(".p-0.m-0.d-flex.justify-content-center.align-items-center.row")).click();
        Thread.sleep(5);
        driver.findElement(By.cssSelector("div[class='d-flex justify-content-center align-items-center']")).click();



    }
}
