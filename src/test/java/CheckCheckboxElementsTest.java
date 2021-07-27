import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckCheckboxElementsTest extends BaseTest {

    @Test
    public void checkBoxCouldBeCheckedAndUnchecked(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        assertEquals(checkBoxes.get(0).isSelected(),false,"Первый чекбокс не выбран");
        checkBoxes.get(0).click();
        assertEquals(checkBoxes.get(0).isSelected(),true,"Первый чекбокс выбран");
        assertEquals(checkBoxes.get(1).isSelected(),true,"Второй чекбокс выбран");
        checkBoxes.get(1).click();
        assertEquals(checkBoxes.get(1).isSelected(),false,"Второй чекбокс не выбран");
    }
}


