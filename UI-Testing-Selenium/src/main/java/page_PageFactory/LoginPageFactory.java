package page_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// below class is if the example if we use Page Factory
public class LoginPageFactory{
    WebDriver driver;

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // declare attribute with Page Factory: @FindBy
    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    // declare method
    public void enterUsername(String user){
        username.sendKeys(user);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickLogin(){
        loginBtn.click();
    }

}
