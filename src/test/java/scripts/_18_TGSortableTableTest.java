package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;

import java.util.List;

public class _18_TGSortableTableTest extends Base{

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-11")).click();
    }

    /**
     *
     */

    @Test
    public void validateSortAscByQuantity(){
        WebElement ascByQuantity = driver.findElement(By.id("quantity_asc"));
        ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(1);

    }
}
