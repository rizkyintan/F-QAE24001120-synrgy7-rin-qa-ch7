package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutComplete {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public CheckoutComplete(WebDriver driver){
        this.driver = driver;
        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //attribute
    By titleText = By.xpath("//span[@class='title']");
    By backHomeBtn = By.id("back-to-products");
    By thankYouText = By.xpath("//*[contains(text(), 'Thank you for your order!')]");

    //method
    //get url
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    //get text: title
    public String getTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(titleText)).getText();
    }
    //get text: Thank you for your order!
    public void getThanksText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(thankYouText));
    }
    //get element: back home button
    public void getBackHomeBtn() {
        driver.findElement(backHomeBtn).isDisplayed();
    }
    //click: back home button
    public void clickBackHome() {
        driver.findElement(backHomeBtn).click();
    }
}
