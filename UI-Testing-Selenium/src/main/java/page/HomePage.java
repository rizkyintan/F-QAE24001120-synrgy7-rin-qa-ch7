package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //LOGIN TEST
    //attribute
    By titleText = By.xpath("//span[@class='title']");
    By cartLogo = By.className("shopping_cart_link");

    //method
    //get url
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    //get text: title
    public String getTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(titleText)).getText();
    }
    //get element: logo cart
    public void getCartElement() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cartLogo)).isDisplayed();
    }

    //SORTING HIGHEST TO LOWEST TEST
    //attribute
    By sortBtn = By.xpath("//*[@class='product_sort_container']");
    By sortHiLoBtn = By.xpath("//*[@value='hilo']");
    By activeSortOption = By.xpath("//*[@class='active_option']");
    By firstPriceText = By.xpath("(//div[@class='inventory_item_price'])[1]");
    By lastPriceText = By.xpath("(//div[@class='inventory_item_price'])[6]");

    //method
    //click element: choose sorting option
    public void chooseSorting(){
        wait.until(ExpectedConditions.presenceOfElementLocated(sortBtn));
        driver.findElement(sortBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(sortHiLoBtn));
        driver.findElement(sortHiLoBtn).click();
    }
    //get text: check active option of sorting
    public String getSortOption(){
        return driver.findElement(activeSortOption).getText();
    }
    //get first price
    public double getFirstPrice(){
        String firstPriceString = driver.findElement(firstPriceText).getText().replace("$", "");
        return Double.parseDouble(firstPriceString);
    }
    //get last price
    public double getLastPrice(){
        String lastPriceString = driver.findElement(lastPriceText).getText().replace("$", "");
        return Double.parseDouble(lastPriceString);
    }

    //CHECKOUT TEST
    //attribute
    By addCartBtnBackpack = By.id("add-to-cart-sauce-labs-backpack");
    By addCartBtnOnesie = By.id("add-to-cart-sauce-labs-onesie");
    By shoppingCartBadge = By.className("shopping_cart_badge");
    By shoppingCartBtn = By.className("shopping_cart_link");

    //method
    //click: add to cart backpack
    public void clickAddCartBackpack(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addCartBtnBackpack));
        driver.findElement(addCartBtnBackpack).click();
    }
    //click: add to cart onesie
    public void clickAddCartOnesie() {
        driver.findElement(addCartBtnOnesie).click();
    }
    //get text: shopping cart badge number
    public double getShoppingCartBadge() {
        return Double.parseDouble(driver.findElement(shoppingCartBadge).getText());
    }
    //click: cart button
    public void clickCart() {
        driver.findElement(shoppingCartBtn).click();
    }
}
