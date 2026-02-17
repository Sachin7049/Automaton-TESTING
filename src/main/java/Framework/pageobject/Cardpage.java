package Framework.pageobject;


import Framework.AbstractionComponents.Handling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Cardpage extends Handling {



    By Iteam =By.cssSelector(".cartSection h3");
    @FindBy(css = ".cartSection h3")
   private List<WebElement> productTitles;
    @FindBy(css=".totalRow button")
            WebElement checkoutele;


        WebDriver driver;
        public Cardpage(WebDriver driver){
            super(driver);
            this.driver =driver;
            PageFactory.initElements(driver,this);

        }

    public Boolean verifyProductDisplay(String productName) {

        waitForElementToAppear(By.cssSelector(".cartSection"));

        return productTitles.stream()
                .anyMatch(p ->
                        p.getText().trim().equalsIgnoreCase(productName)
                );
    }

    // ✅ FIXED METHOD
    public void Cardtoclick() {

        // ensure cart items are loaded
        waitForElementToAppear(Iteam);

        // wait for checkout button to be clickable
        waitForElementToBeClickable(checkoutele);

        // use JS click to avoid interception
        safeJsClick(checkoutele);
    }
}


