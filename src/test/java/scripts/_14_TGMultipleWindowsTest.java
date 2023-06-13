package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;
import utils.WindowHandler;

import java.util.List;
import java.util.Set;

public class _14_TGMultipleWindowsTest extends Base{

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        System.out.println(driver.getWindowHandle()); // TG id
        System.out.println(driver.getWindowHandles().size()); // 1
        driver.findElement(By.id("card-10")).click();
        System.out.println(driver.getWindowHandle()); // TG id
        System.out.println(driver.getWindowHandles().size()); // 1

    }

     @Test
    public void validateTheAppleNavigation() {

         String mainWindowHandle = driver.getWindowHandle(); // TG id

         WebElement appleLink = driver.findElement(By.id("apple"));
         appleLink.click();

         Set<String> allWindow = driver.getWindowHandles();

        for(String windowHandle: allWindow){
            if(!windowHandle.equals (mainWindowHandle)){
                driver.switchTo().window((windowHandle));
                break;
            }
         }
        Waiter.pause(2);

        WebElement appleLogo = driver.findElement(By.cssSelector("a[class=\"globalnav-link globalnav-link-apple\"]"));
         appleLogo.isDisplayed();
    }


    @Test
    public void validateTheMicrosoftNavigation() {

        String mainWindowHandle = driver.getWindowHandle();

        WebElement microsoftLink = driver.findElement(By.id("microsoft"));
        microsoftLink.click();

        Waiter.pause(2);

        WindowHandler.switchToChildWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft"));

    }

    @Test
    public void validateTheTeslaNavigation() {

        WebElement teslaLink = driver.findElement(By.id("tesla"));
        teslaLink.click();

        Waiter.pause(2);

        WindowHandler.switchToChildWindow();
        Assert.assertEquals(driver.getTitle(), "Electric Cars, Solar & Clean Energy | Tesla");

        driver.navigate().back();
        Waiter.pause(2);

        WindowHandler.switchToMainWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));
        WebElement header = driver.findElement(By.id("main_heading"));
        Assert.assertEquals(header.getText(), "Multiple Windows");
    }

    @Test
    public void validation() {

        List<WebElement> links = driver.findElements(By.cssSelector(".MultipleWindows_link__JB372"));

        String[] expectedURLs = {"https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/" };

        for (int i = 0; i < expectedURLs.length; i++) {
            links.get(i).click();
            WindowHandler.switchToChildWindow();
            Assert.assertEquals(driver.getCurrentUrl(), expectedURLs[i]);
            driver.close();
            WindowHandler.switchToMainWindow();
        }
    }


}
