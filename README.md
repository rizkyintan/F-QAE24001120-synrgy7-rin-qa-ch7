# Welcome to my Quality Assurance Learning Repository! 🚀 
### Chapter 7: UI Automation Testing with Selenium WebDriver 👆🏻💻

Hi folks! I am currently learning Software Quality Assurance at SYNRGY Batch 7. This repository serves as a dedicated space for storing code and resources related to my quality assurance learning and development journey. This repository is specifically designed to provide a comprehensive overview of Chapter 7, focusing on UI automation testing with Selenium WebDriver. In this repository, I created test scripts for one of the testing web https://www.saucedemo.com/ which focusing on 4 test cases:

* **Test 1: Login Successful**
* **Test 2: Login Failed wrong Password**
* **Test 3: Sorting Product from High to Low Prices**
* **Test 4: Checkout Product**

### Detailed Overview of Test Cases 📝

#### Test 1: Login Successful ✅
This test case verifies that a user can successfully log into the SauceDemo website with valid credentials.
- **Objective**: Ensure that users with correct username and password can access their accounts.
- **Steps**:
  1. Navigate to the login page.
  2. Enter valid username and password.
  3. Click the login button.
  4. Verify that the homepage is displayed.

#### Test 2: Login Failed with Wrong Password ❌
This test case checks the system's response to an attempt to log in with an incorrect password.
- **Objective**: Validate the application's ability to handle incorrect login attempts and display appropriate error messages.
- **Steps**:
  1. Navigate to the login page.
  2. Enter a valid username and an incorrect password.
  3. Click the login button.
  4. Verify that an error message is displayed.

#### Test 3: Sorting Products from High to Low Prices 💲🔽
This test case ensures that the product sorting feature works correctly.
- **Objective**: Confirm that products can be sorted from highest to lowest price.
- **Steps**:
  1. Log in with valid credentials.
  2. Navigate to the products page.
  3. Select the sorting option to sort products from high to low price.
  4. Verify that the products are correctly sorted through comparing the first displayed price and last displayed price.

#### Test 4: Checkout Product 🛒✅
This test case verifies the checkout process for a product.
- **Objective**: Ensure that users can successfully add products to the cart and complete the checkout process.
- **Steps**:
  1. Log in with valid credentials.
  2. Add a product to the cart.
  3. Proceed to checkout.
  4. Enter necessary details and complete the purchase.
  5. Verify that the order confirmation page is displayed.

### Learning Objectives 🎯

Through these test scripts, the main objectives are:

1. **Understanding Selenium Basics**: Learn how to set up Selenium WebDriver and create basic test scripts.
2. **Writing Effective Test Cases**: Develop skills in writing comprehensive test cases that cover various scenarios.
3. **Automating User Actions**: Gain proficiency in automating common user actions like login, navigation, sorting, and checkout.
4. **Verifying UI Elements**: Learn techniques to verify UI elements and their states using Selenium.

### Repository Structure 📁

- **/src/test/java/test_cases**: Contains detailed descriptions and implementation of each test case.
- **/src/main/java/page**: Includes page object model classes for organizing UI elements and their interactions.

### Getting Started 🚀

To get started with running the test scripts in this repository, follow these steps:

1. **Clone the repository**: git clone [repository](https://github.com/rizkyintan/F-QAE24001120-synrgy7-rin-qa-ch7.git)
2. **Install dependencies**: Ensure you have Java and Selenium WebDriver set up on your machine.
3. **Run the test scripts**: Use your preferred IDE or command line to execute the test cases.

By exploring these test scripts, you will gain practical experience in UI automation testing with Selenium. Happy testing! 🧪
