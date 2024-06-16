package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.*;

public class TestCasesSauceDemo {

    //declare variables
    public WebDriver driver;
    public String highLowSort = "Price (high to low)";

    //Expected url in each page
    public String urlBase = "https://www.saucedemo.com/";
    public String urlHomePage = "https://www.saucedemo.com/inventory.html";
    public String urlCart = "https://www.saucedemo.com/cart.html";
    public String urlCheckoutStepOne = "https://www.saucedemo.com/checkout-step-one.html";
    public String urlCheckoutStepTwo = "https://www.saucedemo.com/checkout-step-two.html";
    public String urlCheckoutComplete = "https://www.saucedemo.com/checkout-complete.html";

    //Expected title in each page
    String titleHome = "Products";
    String titleCart = "Your Cart";
    String titleCheckoutStepOne = "Checkout: Your Information";
    String titleCheckoutStepTwo = "Checkout: Overview";
    String titleCheckoutComplete = "Checkout: Complete!";

    //Login credentials
    String username = "standard_user";
    String password = "secret_sauce";
    String wrongPass = "password_salah";

    //Checkout identity
    String firstName = "Intan";
    String lastName = "Nurlita";
    String postalCode = "12345";

    @BeforeClass
    public void setup(){
        //initiate the driver setup
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(urlBase);
    }

    @Test
    public void LoginTestFailed(){
        driver.get(urlBase);

        //create pages object which needed in Login Test
        LoginPage loginPage = new LoginPage(driver);

        //call action method with certain parameter or test data
        loginPage.enterUsername(username);
        loginPage.enterPassword(wrongPass);
        loginPage.clickLogin();

        //assertions
        Assert.assertEquals(loginPage.getCurrentUrl(), urlBase); //assert by url
        loginPage.verifyErrorMessage(); //assert by element
    }

    @Test
    public void LoginTestSuccess(){
        driver.get(urlBase);

        //create pages object which needed in Login Test
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //call action method with certain parameter or test data
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        //assertions
        Assert.assertEquals(homePage.getCurrentUrl(), urlHomePage); //assert by url
        Assert.assertEquals(homePage.getTitleText(), titleHome); //assert by text
        homePage.getCartElement(); //assert by element
    }

    @Test
    public void SortHighToLow(){
        //create pages object which needed in Login Test
        HomePage homePage = new HomePage(driver);

        //action click to choose sort method
        homePage.chooseSorting();

        //assertions
        Assert.assertTrue(homePage.getFirstPrice() > homePage.getLastPrice(), "Test failed: First price is not higher than the last price"); //assert by business logic
        Assert.assertEquals(homePage.getSortOption(), highLowSort); //assert by text of option chosen
    }

    @Test
    public void Checkout(){
        //create pages object which needed in Login Test
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo(driver);
        CheckoutComplete checkoutComplete = new CheckoutComplete(driver);

        //Scenario 0: action to user Login in LOGIN PAGE
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        //assertion 0: verify login in HOME PAGE
        Assert.assertEquals(homePage.getCurrentUrl(), urlHomePage); //assert by url
        Assert.assertEquals(homePage.getTitleText(), titleHome); //assert by text
        homePage.getCartElement(); //assert by element

        //Scenario 1: add item to cart in HOME PAGE
        homePage.clickAddCartBackpack();
        Assert.assertEquals(homePage.getShoppingCartBadge(), 1); //assert by element
        homePage.clickAddCartOnesie();
        Assert.assertEquals(homePage.getShoppingCartBadge(), 2); //assert by element
        homePage.clickCart();

        //assertion 1: verify add to cart in CART PAGE
        Assert.assertEquals(cartPage.getCurrentUrl(), urlCart); //assert by url
        Assert.assertEquals(cartPage.getTitleText(), titleCart); //assert by text
        cartPage.getCheckoutBtn(); //assert by element: checkout button

        //Scenario 2: checkout in CART PAGE
        cartPage.clickCheckout();

        //assertion 2: verify Checkout in CHECKOUT STEP ONE PAGE
        Assert.assertEquals(checkoutStepOne.getCurrentUrl(), urlCheckoutStepOne); //assert by url
        Assert.assertEquals(checkoutStepOne.getTitleText(), titleCheckoutStepOne); //assert by text
        checkoutStepOne.getContinueBtn(); //assert by element: continue button

        //Scenario 3: fill the identity in CHECKOUT STEP ONE PAGE
        checkoutStepOne.enterFirstName(firstName);
        checkoutStepOne.enterLastName(lastName);
        checkoutStepOne.enterPostalCode(postalCode);
        checkoutStepOne.clickContinue();

        //assertion 3:verify continue checkout in CHECKOUT STEP TWO PAGE
        Assert.assertEquals(checkoutStepTwo.getCurrentUrl(), urlCheckoutStepTwo); //assert by url
        Assert.assertEquals(checkoutStepTwo.getTitleText(), titleCheckoutStepTwo); //assert by text

        //Scenario 4: finish checkout in CHECKOUT STEP TWO PAGE
        checkoutStepTwo.getFinishBtn();
        checkoutStepTwo.clickFinish();

        //assertion 4: verify finish checkout in COMPLETE CHECKOUT PAGE
        Assert.assertEquals(checkoutComplete.getCurrentUrl(), urlCheckoutComplete); //assert by url
        Assert.assertEquals(checkoutComplete.getTitleText(), titleCheckoutComplete); //assert by text
        checkoutComplete.getThanksText(); //assert by text: Checkout-Complete!

        //Scenario 5: back to homepage action in COMPLETE CHECKOUT PAGE
        checkoutComplete.getBackHomeBtn();
        checkoutComplete.clickBackHome();

        //assertion 5: verify back to home in HOME PAGE
        Assert.assertEquals(homePage.getCurrentUrl(), urlHomePage); //assert by url
        Assert.assertEquals(homePage.getTitleText(), titleHome); //assert by text
        homePage.getCartElement(); //assert by element
    }

    @AfterClass
    public void quit(){
        if (driver != null) {
            driver.quit();
        }
    }
}
