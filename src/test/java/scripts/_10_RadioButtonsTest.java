package scripts;

import com.github.dockerjava.api.model.WaitResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _10_RadioButtonsTest extends Base{

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-6")).click();
    }

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Radio Buttons" card
     * Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
     * Select "Java" and validate it is selected but the other 2 are deselected
     * Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @Test
    public void checkRadioButtons () {

        List<WebElement> radioBoxLabel = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
        List<WebElement> radioBoxInput = driver.findElements(By.cssSelector("#radio-button-group_1 input"));


        Waiter.pause(4);
        for (int i = 0; i < radioBoxLabel.size(); i++) {
            Assert.assertTrue(radioBoxLabel.get(i).isDisplayed());
            Assert.assertTrue(radioBoxLabel.get(i).isEnabled());
            Assert.assertFalse(radioBoxInput.get(i).isSelected());
        }

        // Java is Selected and other 2 is deselected
        Waiter.pause(4);
        radioBoxInput.get(0).click();
        Assert.assertTrue(radioBoxInput.get(0).isSelected());
        Assert.assertFalse(radioBoxInput.get(1).isSelected());
        Assert.assertFalse(radioBoxInput.get(2).isSelected());


        //JavaScript is Selected and other 2 is deselected
        Waiter.pause(4);
        radioBoxInput.get(1).click();
        Assert.assertFalse(radioBoxInput.get(0).isSelected());
        Assert.assertTrue(radioBoxInput.get(1).isSelected());
        Assert.assertFalse(radioBoxInput.get(2).isSelected());
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Radio Buttons" card
     * Validate that "Selenium", "Cypress" and "Playwright#" radio buttons are displayed, enabled, and not selected
     * Select "Selenium" and validate it is selected but the other 2 are deselected
     * Select "Cypress" to validate it is selected but the other 2 are deselected
     */

    @Test
    public void checkRadioButtons2() {
        List<WebElement> radioBoxLabel = driver.findElements(By.cssSelector("#radio-button-group_2 label"));
        List<WebElement> radioBoxInput = driver.findElements(By.cssSelector("#radio-button-group_2 input"));


        Waiter.pause(4);
        for (int i = 0; i < radioBoxInput.size(); i++) {
            Assert.assertTrue(radioBoxLabel.get(i).isDisplayed());
            Assert.assertTrue(radioBoxLabel.get(i).isEnabled());
            Assert.assertFalse(radioBoxInput.get(i).isSelected());
        }

        // Java is Selected and other 2 is deselected
        Waiter.pause(4);
        radioBoxLabel.get(0).click();
        Assert.assertTrue(radioBoxInput.get(0).isSelected());
        Assert.assertFalse(radioBoxInput.get(1).isSelected());
        Assert.assertFalse(radioBoxInput.get(2).isSelected());


        //JavaScript is Selected and other 2 is deselected
        Waiter.pause(4);
        radioBoxLabel.get(1).click();
        Assert.assertFalse(radioBoxInput.get(0).isSelected());
        Assert.assertTrue(radioBoxInput.get(1).isSelected());
        Assert.assertFalse(radioBoxInput.get(2).isSelected());
    }
}

