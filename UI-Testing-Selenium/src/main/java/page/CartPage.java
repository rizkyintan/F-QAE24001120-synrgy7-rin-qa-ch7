package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public CartPage(WebDriver driver){
        this.driver = driver;
        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //attribute
    By titleText = By.xpath("//span[@class='title']");
    By checkoutBtn = By.id("checkout");

    //method
    //get url
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    //get text: title
    public String getTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(titleText)).getText();
    }
    //get element: checkout button
    public void getCheckoutBtn() {
        driver.findElement(checkoutBtn).isDisplayed();
    }
    //click: checkout button
    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
