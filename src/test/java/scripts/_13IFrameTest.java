package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _13IFrameTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Validate the "Please fill out your information below" paragraph
     */

    @Test(priority = 1, description = "TC123: Validate the IFrame Page content paragraph")
    public void validateTheParagraph(){
        //WebElement iframe = driver.findElement(By.id("form_frame"));
        //driver.switchTo().frame(iframe);

        //driver.switchTo().frame(0);

        driver.switchTo().frame("form_frame");

        WebElement paragraph = driver.findElement(By.cssSelector("#name_form>p"));
        Assert.assertTrue(paragraph.isDisplayed());
        Assert.assertEquals(paragraph.getText(), "Please fill out your information below");
    }

    /*

     */
    @Test(priority = 2, description = "TC345 Validate the form submission")
    public void validateTheFormSubmission() {

        WebElement innerFrame = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(innerFrame);

        WebElement fName = driver.findElement(By.id("first_name"));
        fName.sendKeys("John");
        WebElement lName = driver.findElement(By.id("last_name"));
        lName.sendKeys("Doe");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        driver.switchTo().defaultContent();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(), "You entered: John Doe");
    }
}