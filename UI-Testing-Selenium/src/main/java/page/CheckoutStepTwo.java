package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwo {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public CheckoutStepTwo(WebDriver driver){
        this.driver = driver;
        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //attribute
    By titleText = By.xpath("//span[@class='title']");
    By finishBtn = By.id("finish");

    //method
    //get url
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    //get text: title
    public String getTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(titleText)).getText();
    }
    //get element: finish button
    public void getFinishBtn() {
        driver.findElement(finishBtn).isDisplayed();
    }
    //click: finish button
    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }
}
