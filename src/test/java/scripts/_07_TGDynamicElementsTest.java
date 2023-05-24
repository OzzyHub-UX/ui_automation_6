package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _07_TGDynamicElementsTest extends Base{

    @BeforeMethod
    public void getURL() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-3")).click();
    }

    /**
     TEST CASE 1
     Go to https://techglobal-training.com/frontend/
     Click on the "Dynamic Elements" card
     Validate both boxes are displayed with the below texts
     Box 1
     */

    @Test (priority = 1)
    public void validateBoxes() {
        Waiter.pause(2);

        WebElement box1 = driver.findElement(By.cssSelector("p[id^=box_1]"));

        Waiter.pause(2);

        Assert.assertTrue(box1.isDisplayed());

        Assert.assertEquals(box1.getText(), "Box 1");
    }

    /**
     TEST CASE 2
     Go to https://techglobal-training.com/frontend/
     Click on the "Dynamic Elements" card
     Validate both boxes are displayed with the below texts
     Box 2
     */

    @Test (priority = 2)
    public void validateBox2() {

        WebElement box2 = driver.findElement(By.cssSelector("p[id^=box_2]"));

        Waiter.pause(2);

        Assert.assertTrue(box2.isDisplayed());

        Assert.assertEquals(box2.getText(), "Box 2");
    }

    /**
    TEST CASE 3
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate that both boxes are displayed with the below texts
    Box 1, Box 2
     USE CONTAINS
     */

    @Test (priority = 3)
    public void validateTextsAndDisplay() {

        //List<WebElement> boxes = driver.findElements(By.cssSelector("li[class*=DynamicElements]"));
        List<WebElement> boxes = driver.findElements(By.cssSelector("p[id*=box_]"));

        String[] expectedBoxesName = {"Box 1", "Box 2"};

        for (int i = 0; i < expectedBoxesName.length; i++) {
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertEquals(boxes.get(i).getText(), expectedBoxesName[i]);
        }

    }

}
