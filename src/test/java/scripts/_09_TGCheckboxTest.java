package scripts;

import com.sun.xml.internal.ws.model.WrapperBeanGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import javax.xml.ws.WebEndpoint;
import java.util.List;

public class _09_TGCheckboxTest extends Base{

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Checkboxes" card
     * Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
     * Select both and validate they are both selected
     * Deselect both and validate they are deselected
     */

    @BeforeMethod
    public void setPageURL () {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void validateCheckboxes () {
        List<WebElement> checkBoxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> checkBoxInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        String[] expectedElements = {"Apple", "Microsoft"};

        for (int i = 0; i < expectedElements.length; i++) {
            Assert.assertTrue(checkBoxLabel.get(i).isDisplayed());
            Assert.assertTrue(checkBoxLabel.get(i).isEnabled());
            Assert.assertFalse(checkBoxInput.get(i).isSelected());
        }

        Waiter.pause(2);
        for (WebElement webElement : checkBoxInput) {
            webElement.click();
            Assert.assertTrue(webElement.isSelected());
        }

        Waiter.pause(2);
        for (WebElement webElement : checkBoxInput) {
            webElement.click();
            Assert.assertFalse(webElement.isSelected());
        }
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Checkboxes" card
     * Validate "Tesla" and "SpaceX" checkboxes are displayed, enabled, and not selected
     * Select both and validate they are both selected
     * Deselect both and validate they are deselected
     */

    @Test
    public void validateCheckBoxes2 () {
        List<WebElement> checkBoxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        List<WebElement> checkBoxInput = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));


        for (WebElement element : checkBoxInput) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            Assert.assertFalse(element.isSelected());

        }
        for (int i = 0; i < checkBoxInput.size(); i++) {
            checkBoxLabel.get(i).click();
            Assert.assertTrue(checkBoxInput.get(i).isSelected());
        }


        for (int i = 0; i < checkBoxInput.size(); i++) {
            checkBoxLabel.get(i).click();
            Assert.assertFalse(checkBoxInput.get(i).isSelected());
        }



    }
}
