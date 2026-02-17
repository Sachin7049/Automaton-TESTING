package Framework.pageobject;

import Framework.AbstractionComponents.Handling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage extends Handling {

    WebDriver driver;

    public Landingpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(xpath = "(//div[@id='toast-container'])[1]")
    WebElement error;

    public void loginpage(String username, String password) {

        // wait & enter email
        waitForElementToAppear(userEmail);
        userEmail.clear();
        userEmail.sendKeys(username);

        // wait & enter password
        waitForElementToAppear(userPassword);
        userPassword.clear();
        userPassword.sendKeys(password);

        // wait until login button is clickable
        waitForElementToBeClickable(submit);

        // use safe JS click (avoids intercept issue)
        safeJsClick(submit);
    }

    public String errormessage() {
        waitForElementToAppear(error);
        return error.getText();
    }
}






//    WebElement userEmail=driver.findElement(By.id("userEmail"));
//    driver.findElement(By.id("userPassword")).sendKeys("Welcome@123");
//        driver.findElement(By.id("login")).click();

