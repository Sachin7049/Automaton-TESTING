import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class united_parking {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://preprod-transient.parkengage.com/parkingpayments/touchless-parking-parking/eyJmYWNpbGl0eV9pZCI6MTQ0LCJnYXRlIjoxMX0=");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@class='d-inline-block' and @style='height: 25px; width: 25px;']")
        ));


//        WebDriver driver=new ChromeDriver();driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://preprod-transient.parkengage.com/unitedparking/touchless-parking-united/eyJmYWNpbGl0eV9pZCI6MzQyLCJnYXRlIjoxMSwiZ2F0ZV90eXBlIjoiMCJ9");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement logoutIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//span[@class='d-inline-block' and @style='height: 25px; width: 25px;']")
//        ));
//        WebElement element = driver.findElement(By.xpath("svg[xmlns='http://www.w3.org/2000/svg']"));
//        element.click();
        //driver.findElement(By.xpath("//span[@class='d-inline-block']//*[name()='svg']")).click();
       // driver.findElement(By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg']")).click();
//        Thread.sleep(1000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Create Account')]"))).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("jonh");
        driver.findElement(By.cssSelector("#email")).sendKeys("jonh823945@yopmail.com");
        driver.findElement(By.id("loginInputSingup")).sendKeys("7899308679");

        driver.findElement(By.cssSelector("#password")).sendKeys("Welcome@123");
        driver.findElement(By.id("confirm_password")).sendKeys("Welcome@123");
        driver.findElement(By.id("formHorizontalCheck")).click();
        driver.findElement(By.cssSelector(".d-flex.justify-content-center.align-items-center")).click();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.cssSelector(".fa.fa-plus.small")).click();
        driver.findElement(By.xpath("(//i[@class='fa fa-plus small'])[1]")).click();
        driver.findElement(By.cssSelector(".inputLoginVehicle.form-control")).sendKeys("H732");
        driver.findElement(By.cssSelector("button[class='btn w-100 my-4 text-white bg-primary VehicleeAddButton'] div[class='d-flex justify-content-center align-items-center']")).click();
        driver.findElement(By.cssSelector("div[class='p-0 m-0 d-flex justify-content-center align-items-center row'] div:nth-child(1) div:nth-child(1)")).click();

        driver.findElement(By.cssSelector(".fa.fa-plus.small")).click();
        driver.findElement(By.cssSelector(".form-control.form-control")).sendKeys("test");
        driver.findElement(By.id("card_number")).sendKeys("4761 7310 0000 0043");
        driver.findElement(By.id("expiry")).sendKeys("02/28");
        driver.findElement(By.id("Cvv")).sendKeys("123");
        driver.findElement(By.cssSelector(".d-flex.justify-content-center.align-items-center")).click();










    }
}
