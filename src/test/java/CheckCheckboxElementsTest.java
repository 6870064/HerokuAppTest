import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.*;

public class CheckCheckboxElementsTest extends BaseTest {

    @Test
    public void checkBoxCouldBeCheckedAndUnchecked() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        assertFalse(checkBoxes.get(0).isSelected(),"Первый чекбокс не выбран");
        checkBoxes.get(0).click();
        assertTrue(checkBoxes.get(0).isSelected(), "Первый чекбокс выбран");
        assertTrue(checkBoxes.get(1).isSelected(), "Второй чекбокс выбран");
        checkBoxes.get(1).click();
        assertFalse(checkBoxes.get(1).isSelected(),"Второй чекбокс не выбран");
    }
}
