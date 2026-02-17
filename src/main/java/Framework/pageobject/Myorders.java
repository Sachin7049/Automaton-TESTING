package Framework.pageobject;

import Framework.AbstractionComponents.Handling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Myorders extends Handling {
    WebDriver driver;

    //create constructor first run then create pagefactory
    public Myorders (WebDriver driver){
        super(driver); //for handling class constructor and calling to parent class
        this.driver =driver;
        PageFactory.initElements(driver,this); //pagefactory initialize it mean this class can acces driver

    }
    @FindBy(xpath = "//button[@routerlink=\"/dashboard/myorders\"]")
    WebElement myorder;
    @FindBy(css = "td:nth-child(3)")
  private List< WebElement> orderlist;

    public Boolean verifyOrder(String productName) {

        waitForElementToAppear(myorder);
        myorder.click();

        // WAIT for order rows, not button
     waitForElementToAppears(orderlist);

        return orderlist.stream()
                .anyMatch(order ->
                        order.getText().trim().equalsIgnoreCase(productName)
                );
    }
}
