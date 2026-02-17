package Framework.pageobject;


import Framework.AbstractionComponents.Handling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation extends Handling {

    WebDriver driver;

    public Confirmation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Locator for confirmation message
    private By confirmationMessageBy = By.cssSelector(".hero-primary");

    @FindBy(css = ".hero-primary")
    private WebElement confirmationMessage;

    // Get confirmation message text
    public String getConfirmationMessage() {
        waitForElementToAppear(confirmationMessageBy);
        return confirmationMessage.getText();


    }




//    wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".hero-primary"))));
//    String confirm= driver.findElement(By.cssSelector(".hero-primary")).getText();
//       Assert.assertTrue(confirm.equalsIgnoreCase("Thankyou for the order."));
//        System.out.println(confirm);

}
