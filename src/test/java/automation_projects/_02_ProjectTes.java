package automation_projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _02_ProjectTes {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-22")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Validate that the username input box is displayed
     * Validate that the username input box is not required
     * Validate that the label of the username input box is “Please enter your username”
     * Validate that the password input box is displayed
     * Validate that the password input box is not required
     * Validate that the label of the password input box is “Please enter your password”
     * Validate the “LOGIN” button is displayed
     * Validate the “LOGIN” button is clickable
     * Validate that the button text is “LOGIN”
     * Validate the “Forgot Password?” link is displayed
     * Validate that the “Forgot Password?” link is clickable
     * Validate that the link text is “Forgot Password?”
     */

    @Test(priority = 1, description = "Validate the login form")
    public void validateLoginForm() {


        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type"));
        for (int i = 0; i < inputs.size(); i++) {
            Assert.assertTrue(inputs.get(i).isDisplayed());
            Assert.assertFalse(Boolean.parseBoolean(inputs.get(i).getAttribute("required")));
        }

        List<WebElement> labels = driver.findElements(By.cssSelector("label[for]"));
        String[] expected = {"Please enter your username", "Please enter your password"};
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(labels.get(0).getText(), expected[0]);
            Assert.assertEquals(labels.get(1).getText(), expected[1]);
        }

        WebElement loginButton = driver.findElement(By.id("login_btn"));

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");

        WebElement forPassLink = driver.findElement(By.cssSelector("form a"));

        Assert.assertTrue(forPassLink.isDisplayed());
        Assert.assertTrue(forPassLink.isEnabled());
        Assert.assertEquals(forPassLink.getText(), "Forgot Password?");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “TechGlobal”
     * Enter the password as “Test1234”
     * Click on the “LOGIN” button
     * Validate the success message is displayed as “You are logged in”
     * Validate the logout button displayed with the text “LOGOUT”
     */

    @Test(priority = 2, description = "Validate the valid login")
    public void validateValidLogin() {

        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type"));
            inputs.get(0).sendKeys("TechGlobal");
            inputs.get(1).sendKeys("Test1234");


        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement successMessage = driver.findElement(By.id("success_lgn"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(successMessage.getText(), "You are logged in");

        WebElement logOutButton = driver.findElement(By.id("logout"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(logOutButton.getText(), "LOGOUT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “TechGlobal”
     * Enter the password as “Test1234”
     * Click on the “LOGIN” button
     * Click on the “LOGOUT” button
     * Validate that the login form is displayed
     */

    @Test(priority = 3, description = "Validate the logout")
    public void validateLogOut() {

        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type"));
        inputs.get(0).sendKeys("TechGlobal");
        inputs.get(1).sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement logOutButton = driver.findElement(By.id("logout"));
        logOutButton.click();

        WebElement modal = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        Assert.assertTrue(modal.isDisplayed());
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Click on the “Forgot Password?” link
     * Validate that the modal heading “Reset Password” is displayed
     * Validate that the close button is displayed
     * Validate that the email input box is displayed
     * Validate that the label of the email input box is “Enter your email address and we'll send you a link to reset your password.”
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */

    @Test(priority = 4, description = "Validate the Forgot Password? Link and Password modal")
    public void validateForgotPasswordAndModal() {

        WebElement forPassLink = driver.findElement(By.cssSelector("form a"));
        forPassLink.click();

        WebElement modalHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertTrue(modalHeading.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector("button[class=delete"));
        Assert.assertTrue(closeButton.isDisplayed());

        WebElement emailInput = driver.findElement(By.id("email"));
        Assert.assertTrue(emailInput.isDisplayed());

        WebElement emailLabel = driver.findElement(By.cssSelector("label[for=email]"));
        Assert.assertEquals(emailLabel.getText(),"Enter your email address and we'll send you a link to reset your password.");

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Click on the “Forgot Password?” link
     * Validate that the “Reset Password” modal is displayed
     * Click on the close button
     * Validate that the “Reset Password” modal is closed
     */

    @Test(priority = 5, description = "Validate the Reset Password modal close button")
    public void validateResetModalButton() {

        WebElement forPassLink = driver.findElement(By.cssSelector("form a"));
        forPassLink.click();

        WebElement modalTitle = driver.findElement(By.id("modal_title"));
        Assert.assertTrue(modalTitle.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector("button[class=delete"));
        closeButton.click();

        WebElement modal = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        Assert.assertTrue(modal.isDisplayed());
    }

    /**
     *Navigate to https://techglobal-training.com/frontend/project-2
     * Click on the “Forgot Password?” link
     * Enter an email
     * Click on the “SUBMIT” button
     * Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button
     */

    @Test(priority = 6, description = "Validate the Reset Password form submission")
    public void validateResetForm(){

        WebElement forPassLink = driver.findElement(By.cssSelector("form a"));
        forPassLink.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("ynogura@outlook.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement confirmationMsg = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(confirmationMsg.getText(),"A link to reset your password has been sent to your email address.");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Leave username empty
     * Leave password empty
     * Click on the “LOGIN” button
     * Validate the failure message is displayed as “Invalid Username entered!” above the form
     */

    @Test(priority = 7, description = "Validate the invalid login with the empty credentials")
    public void validateInvalidLoginWEmptyCredentials() {

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMsg.getText(), "Invalid Username entered!");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “John”
     * Enter the password as “Test1234”
     * Click on the “LOGIN” button
     * Validate the failure message is displayed as “Invalid Username entered!” above the form
     */

    @Test(priority = 8, description = "Validate the invalid login with the wrong username")
    public void validateInvalidLoginWrongUserName(){

        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type"));
        inputs.get(0).sendKeys("John");
        inputs.get(1).sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMsg.getText(), "Invalid Username entered!");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “TechGlobal”
     * Enter the password as “1234”
     * Click on the “LOGIN” button
     * Validate the failure message is displayed as “Invalid Password entered!” above the form
     */

    @Test(priority = 9, description = "Validate the invalid login with the wrong password")
    public void validateInvalidLoginWrongPassword(){

        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type"));
        inputs.get(0).sendKeys("TechGlobal");
        inputs.get(1).sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMsg.getText(), "Invalid Password entered!");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “John”
     * Enter the password as “1234”
     * Click on the “LOGIN” button
     * Validate the failure message is displayed as “Invalid Username entered!” above the form
     */

    @Test(priority = 10, description = "Validate the invalid login with the wrong username and password")
    public void validateInvalidLoginWrongUsernameAndPassword(){

        List<WebElement> inputs = driver.findElements(By.cssSelector("input[type"));
        inputs.get(0).sendKeys("John");
        inputs.get(1).sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMsg.getText(), "Invalid Username entered!");
    }
}
