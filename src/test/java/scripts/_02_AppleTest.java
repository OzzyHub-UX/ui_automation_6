package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _02_AppleTest {
    /*
    validateTitleAndURL
    Go to https://www.apple.com/
    Validate its title is Apple
    Validate its URL is https://www.apple.com/
     */

    public static WebDriver driver; // Declaration

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Setting Up Chrome Driver

        driver = new ChromeDriver(); // Initialization

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.apple.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(3000);

        driver.quit();

    }

    @Test
    public void validateTitleAndURL() throws InterruptedException{

        Assert.assertEquals(driver.getTitle(), "Apple");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.apple.com/\"");

    }
}