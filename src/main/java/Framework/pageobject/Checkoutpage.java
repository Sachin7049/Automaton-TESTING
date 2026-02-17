package Framework.pageobject;


import Framework.AbstractionComponents.Handling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkoutpage extends Handling {

    WebDriver driver;

    public Checkoutpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryInput;

    By results = By.cssSelector(".ta-results");

    @FindBy(xpath = "//button[contains(@class,'ta-item')]")
    WebElement countryResult;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement submitButton;

    // Select country from autocomplete
    public void selectCountry(String countryName) {

        waitForElementToAppear(countryInput);

        countryInput.sendKeys(countryName);

        waitForElementToAppear(results);

        // Click first matching result
        safeJsClick(countryResult);
    }

    // Submit order
    public void submitOrder() {

        waitForElementToBeClickable(submitButton);
        safeJsClick(submitButton);
    }
}




