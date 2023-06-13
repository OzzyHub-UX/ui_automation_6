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
import utils.Waiter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _01_ProjectTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Setting Up Chrome Driver
        driver = new ChromeDriver(); // Launches Chrome Driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait
        driver.get("https://techglobal-training.com/frontend/project-1"); // Directs Browser To TG Training Website
    }

    @AfterMethod
    public void tearDown(){
        driver.quit(); // Quits the Driver
    }


    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the heading is “Contact Us”
     * Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
     * Validate the email is “info@techglobalschool.com"
     * Validate the phone number is “(773) 257-3010”
     */

    @Test(priority = 1, description = "Test case 01 - Validate the Contact Us Information")
    public void validateContactUsInformation() {

        WebElement header = driver.findElement(By.cssSelector("h1[class*=is-size-2"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phoneNumber = driver.findElement(By.id("phone-number"));

        List<WebElement> elementsList = Arrays.asList(header, address, email, phoneNumber);

        Waiter.pause(4);
        for (int i = 0; i < elementsList.size(); i++) {
            Assert.assertTrue(elementsList.get(i).isDisplayed());
        }

        // Validation of text for Header
        Assert.assertEquals(header.getText(), "Contact Us");

        // Validation of text for Address
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");

        // Validation of text for Email
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");

        // Validation of text for phoneNumber
        Assert.assertEquals(phoneNumber.getText(), "(773) 257-3010");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Full name input box is displayed
     * Validate that the Full name input box is required
     * Validate that the label of the Full name input box is “Full name”
     * Validate that the placeholder of the Full name input box is “Enter your name”
     */

    @Test(priority = 2, description = "Test Case 02 - Validate Full Name Input Box")
    public void validateFullNameInputBox () {

        WebElement fullNameInputBox = driver.findElement(By.cssSelector("input[placeholder=\"Enter your full name\"]"));

        Assert.assertTrue(fullNameInputBox.isDisplayed());
        Assert.assertEquals(fullNameInputBox.getAttribute("required"), "true");
        Assert.assertTrue(Boolean.parseBoolean(fullNameInputBox.getAttribute("required")));

        WebElement fullNameLabelBox = driver.findElement(By.cssSelector("label[for=name]"));

        Assert.assertEquals(fullNameLabelBox.getText(), "Full name *");
        Assert.assertEquals(fullNameInputBox.getAttribute("placeholder"), "Enter your full name");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “Gender”
     * Validate that the Gender is required
     * Validate the options are “Female”, “Male” and “Prefer not to disclose”
     * Validate the options are clickable and not selected
     * Click on the “Male” option and validate it is selected while the others are not selected
     * Click on the “Female” option and validate it is selected while the others are not selected
     */

    @Test(priority = 3, description = "Test Case 03 - Validate the Gender radio button")
    public void validateGenderRadioButton() {

        WebElement label = driver.findElement(By.cssSelector("div[class=control] label:nth-child(1)"));
        Assert.assertTrue(label.isDisplayed());
        Assert.assertEquals(label.getText(), "Gender *");

        List<WebElement> optionsLabels = driver.findElements(By.cssSelector("label[class^=radio]"));
        List<WebElement> optionsInputs = driver.findElements(By.cssSelector("input[type=radio]"));
        String[] expectedOptions = {"Male", "Female", "Prefer not to disclose"};

        Assert.assertEquals(optionsInputs.get(0).getAttribute("required"), "true");


        for (int i = 0; i < expectedOptions.length ; i++) {
            Assert.assertTrue(optionsInputs.get(i).isDisplayed());
            Assert.assertTrue(optionsInputs.get(i).isEnabled());
            Assert.assertFalse(optionsInputs.get(i).isSelected());
            Waiter.pause(2);
            Assert.assertEquals(optionsLabels.get(i).getText(), expectedOptions[i]);
        }

        // Validate Male Option
        optionsInputs.get(0).click();
        Assert.assertTrue(optionsInputs.get(0).isSelected());
        Assert.assertFalse(optionsInputs.get(1).isSelected());
        Assert.assertFalse(optionsInputs.get(2).isSelected());
        Waiter.pause(3);

        // Validate Female Option
        optionsInputs.get(1).click();
        Assert.assertFalse(optionsInputs.get(0).isSelected());
        Assert.assertTrue(optionsInputs.get(1).isSelected());
        Assert.assertFalse(optionsInputs.get(2).isSelected());
        Waiter.pause(3);
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Address input box is displayed
     * Validate that the Address input box is not required
     * Validate that the label of the Address input box is “Address”
     * Validate that the placeholder of the Address input box is “Enter your address*”
     */

    @Test(priority = 4, description = "Test Case 04 - Validate the Address Input Box")
    public void validateAddressInput() {

        WebElement addressInputBox = driver.findElement(By.cssSelector("input[placeholder=\"Enter your address\"]"));

        Assert.assertTrue(addressInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(addressInputBox.getAttribute("required")));
        Assert.assertEquals(addressInputBox.getAttribute("placeholder"), "Enter your address");

        WebElement addressLabel = driver.findElement(By.xpath("//form/div[3]/label"));

        Assert.assertEquals(addressLabel.getText(), "Address");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */

    @Test(priority = 5, description = "Test Case 05 - Validate the Email Input Box")
    public void validateEmailInput() {

        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type=email]"));

        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertEquals(emailInputBox.getAttribute("required"), "true");

        WebElement emailLabel = driver.findElement(By.xpath("//form/div[4]/label"));

        Assert.assertEquals(emailLabel.getText(), "Email *");
        Assert.assertEquals(emailInputBox.getAttribute("placeholder"), "Enter your email");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Phone input box is displayed
     * Validate that the Phone input box is not required
     * Validate that the label of the Phone input box is “Phone”
     * Validate that the placeholder of the Address input box is “Enter your phone number”
     */

    @Test(priority = 6, description = "Test Case 06 - Validate the Phone Input Box")
    public void validatePhoneInput() {

        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[placeholder=\"Enter your phone number\"]"));

        Assert.assertTrue(phoneInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(phoneInputBox.getAttribute("required")));
        WebElement phoneLabel = driver.findElement(By.xpath("//form/div[5]/label"));

        Assert.assertEquals(phoneLabel.getText(), "Phone");
        Assert.assertEquals(phoneInputBox.getAttribute("placeholder"), "Enter your phone number");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Message text area is displayed
     * Validate that the Message text area is not required
     * Validate that the label of the Message text area is “Message”
     * Validate that the placeholder of the Message text area is “Type your message here…”
     */

    @Test(priority = 7, description = "Test Case 07 - Validate the Message Text Area")
    public void validateTextArea() {

        WebElement textArea = driver.findElement(By.cssSelector("textarea[class=textarea]"));

        Assert.assertTrue(textArea.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(textArea.getAttribute("required")));

        WebElement textLabel = driver.findElement(By.xpath("//form/div[6]/label"));

        Assert.assertEquals(textLabel.getText(), "Message");
        Assert.assertEquals(textArea.getAttribute("placeholder"), "Type your message here...");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “I give my consent to be contacted.”
     * Validate that the Consent checkbox is required
     * Validate that the Consent checkbox is clickable
     * Click on the “I give my consent to be contacted.” checkbox and validate it is selected
     * Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     */

    @Test(priority = 8, description = "Test Case 08 - Validate the Consent Checkbox")
    public void validateConsentCheckbox() {

        WebElement label = driver.findElement(By.cssSelector("label[class=checkbox]"));

        Assert.assertEquals(label.getText(), "I give my consent to be contacted.");

        WebElement labelInput = driver.findElement(By.cssSelector("label[class=\"checkbox\"] input"));

        Assert.assertTrue(Boolean.parseBoolean(labelInput.getAttribute("required")));
        Assert.assertTrue(labelInput.isEnabled());


        labelInput.click();
        Assert.assertTrue(labelInput.isSelected());
        labelInput.click();
        Assert.assertFalse(labelInput.isSelected());
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */
    @Test(priority = 9, description = "Test Case 09 - Validate the Submit Button")
    public void validateSubmitButton() {

        WebElement submitButton = driver.findElement(By.cssSelector("button[class]"));

        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Enter a first name
     * Select a gender
     * Enter an address
     * Enter an email
     * Enter a phone number
     * Enter a message
     * Select the “I give my consent to be contacted.” checkbox
     * Click on the “SUBMIT” button
     * Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */
    @Test(priority = 10, description = "Test Case 10 - Validate the form Submission")
    public void validateForm() {

        WebElement fNameInput = driver.findElement(By.cssSelector("input[placeholder=\"Enter your full name\"]"));
        List<WebElement> genderInputs = driver.findElements(By.cssSelector("input[type=radio]"));
        WebElement addressInput = driver.findElement(By.cssSelector("input[placeholder=\"Enter your address\"]"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type=email]"));
        WebElement phoneNumberInput = driver.findElement(By.cssSelector("input[placeholder=\"Enter your phone number\"]"));
        WebElement messageInput = driver.findElement(By.cssSelector("textarea[class=textarea]"));
        WebElement consentInput = driver.findElement(By.cssSelector("label[class=\"checkbox\"] input"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[class]"));

        fNameInput.sendKeys("Yazan");
        genderInputs.get(0).click();
        addressInput.sendKeys("2860 S River Rd Suite 350, Des Plaines, IL");
        emailInputBox.sendKeys("johndoe@gmail.com");
        phoneNumberInput.sendKeys("(123)-123-1234");
        messageInput.sendKeys("Hello, the weather is nice today");
        consentInput.click();
        submitButton.click();

        WebElement message = driver.findElement(By.cssSelector("strong[class]"));
        Assert.assertEquals(message.getText(), "Thanks for submitting!");



    }
}
