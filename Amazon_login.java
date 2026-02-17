import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Amazon_login {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://preprod.parkengage.com/");
        driver.findElement(By.cssSelector("a.btn.btn-primary.btn-sm.text-light.mt-1")).click();
        driver.findElement(By.id("username")).sendKeys("superadmin@parkengage.com");
        driver.findElement(By.id("pwd")).sendKeys("Superadmin@2");
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-outline-primary")).click();
        String title =driver.getTitle();
        System.out.println("Page Title: " + title);






//

    }
}
