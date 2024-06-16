package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOne {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public CheckoutStepOne(WebDriver driver){
        this.driver = driver;
        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //attribute
    By titleText = By.xpath("//span[@class='title']");
    By continueBtn = By.id("continue");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");

    //method
    //get url
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    //get text: title
    public String getTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(titleText)).getText();
    }
    //get element: continue button
    public void getContinueBtn(){
        driver.findElement(continueBtn).isDisplayed();
    }
    //click: continue button
    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
    //input: first name
    public void enterFirstName(String first_name){
        driver.findElement(firstName).sendKeys(first_name);
    }
    //input: last name
    public void enterLastName(String last_name){
        driver.findElement(lastName).sendKeys(last_name);
    }
    //input: postal code
    public void enterPostalCode(String postal_code){
        driver.findElement(postalCode).sendKeys(postal_code);
    }
}
