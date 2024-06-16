package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //attribute
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.xpath("//*[contains(text(), 'password do not match')]");

    //method
    //input: username
    public void enterUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }
    //input: password
    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    //click: login button
    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
    //get url
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    //get element: error message
    public void verifyErrorMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMsg)).isDisplayed();
    }
}



