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
        driver.findElement(By.id("pwd")).sendKeys("Superadmin@1234");
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-outline-primary")).click();
        String title =driver.getTitle();
        System.out.println("Page Title: " + title);


//        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https://www.amazon.in/gp/homepage.html?_encoding=UTF8&ref_=navm_em_signin&action=sign-out&path=%2Fgp%2Fhomepage.html%3F_encoding%3DUTF8%26ref_%3Dnavm_em_signin&signIn=1&useRedirectOnSuccess=1&ref_=nav_em_signout_0_1_1_40&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http://specs.openid.net/auth/2.0");
//
//
/////// xpath define syntax is // input [@attributename=" value "];
//      driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("sachinrathore7566@gmail.com");
//        driver.findElement(By.className("a-button-input")).click();

//       driver.findElement(By.id("ap_email")).sendKeys("sachinrathore7566@gmail.com");
   //  driver.findElement(By.className("a-button-input")).click();
//      driver.findElement(By.id("auth-fpp-link-bottom")).click();
//      driver.findElement(By.id("continue")).click();
//         driver.findElement(By.id("ap_password")).sendKeys("Sachin@83055");
////        driver.findElement(By.id("signInSubmit")).click();




//

    }
}
