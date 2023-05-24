package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _08_TGWaitsTest extends Base{

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-4")).click();
    }

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Waits" card
     * Click on the "Click on me to see a red box" button
     * Validate that a red box is displayed
     */

    @Test
    public void validateRedBox () {

        WebElement waits = driver.findElement(By.id("red"));
        waits.click();


        WebElement redBox = driver.findElement(By.cssSelector("button[class*=Box_c_box"));

        Waiter.pause(10);

        Assert.assertTrue(redBox.isDisplayed());

    }

}
