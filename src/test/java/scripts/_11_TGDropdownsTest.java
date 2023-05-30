package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;
import utils.Waiter;

import java.util.List;

public class _11_TGDropdownsTest extends Base {

    public static Select select;

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropdownTest() {

        Select select = new Select(driver.findElement(By.id("product_dropdown")));

        select.selectByVisibleText("iPhone 14 Pro Max");

        Waiter.pause(2);
    }

    @Test
    public void colorDropdownTest() {

        Select select = new Select(driver.findElement(By.id("color_dropdown")));

        select.selectByIndex(0); // Yellow
        select.selectByIndex(1); // Green
        select.selectByIndex(2); // Silver
        select.selectByIndex(3); // Black

        Waiter.pause(2);

    }

    @Test
    public void shipmentType() {

        WebElement element = (driver.findElement(By.id("shipment_dropdown")));
        element.click();
        Waiter.pause(2);

        List<WebElement> shipmentType1 = driver.findElements(By.cssSelector("div[id*=shipment_dropdown] span"));

        String[] expectedShipment = {"Delivery", "Pick up"};

        for (int i = 0; i < expectedShipment.length; i++) {
            Assert.assertTrue(shipmentType1.get(i).isDisplayed());
            Assert.assertEquals(shipmentType1.get(i).getText(), expectedShipment[i]);
        }
    }

    /**
     *Test Case: Validate Dropdowns Functionality on TechGlobal Training Page
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Dropdown" card
     * Select the "MacBook Pro 13" option from the "Product" dropdown.
     * Select the "Green" option from the "Color" dropdown.
     * Open the "Shipping" dropdown and click on the "Delivery" option.
     * Click on the "Submit" button.
     * Validate result message displays "Your Green MacBook Pro 13 will be delivered to you."
     */

    @Test
    public void validateDropdowns(){

    Select select = new Select(driver.findElement(By.id("product_dropdown")));
    select.selectByVisibleText("MacBook Pro 13");

    Select select1 = new Select(driver.findElement(By.id("color_dropdown")));
    select1.selectByVisibleText("Green");

    WebElement shipmentDropdown = driver.findElement(By.id("shipment_dropdown"));
    shipmentDropdown.click();

    WebElement selectDelivery = driver.findElement(By.cssSelector("#shipment_dropdown span:nth-child(1)"));
    selectDelivery.click();

    WebElement submit = driver.findElement(By.id("submit"));
    submit.click();

    WebElement result = driver.findElement(By.id("result"));
    Assert.assertEquals(result.getText(),"Your Green MacBook Pro 13 will be delivered to you.");

    Waiter.pause(2);

            /*
            WebElement dropdown = driver.findElement(By.id("product_dropdown"));
            WebElement dropdown1 = driver.findElement(By.id("color_dropdown"));
            WebElement dropdown2 = driver.findElement(By.id("shipping_dropdown"));
            List<WebElement> shipmentDropDownOption = driver.findElements(By.cssSelector("#shipment_dropdown span"));


            DropdownHandler.selectByIndex(dropdown, 3);
            DropdownHandler.selectByIndex(dropdown1, 2);
            DropdownHandler.clickDropdownOption(dropdown2, shipmentDropDownOption, "Delivery");

            WebElement submit = driver.findElement(By.cssSelector("#submit"));
            submit.click();

            WebElement result = driver.findElement(By.id("result"));
            Assert.assertEquals(result.getText(),"Your Green MacBook Pro 13 will be delivered to you.");
            Waiter.pause(3);
             */
    }


}
