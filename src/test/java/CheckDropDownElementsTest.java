import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckDropDownElementsTest extends BaseTest {

    @Test
    public void checkDropdownListElements() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement element = driver.findElement(By.id("dropdown"));
        Select dropDownSelect = new Select(element);

        List<WebElement> option = dropDownSelect.getOptions(); //Взять все элементы дроп-дауна
        // и проверить их наличие
        assertEquals(option.get(0).getText(), "Please select an option");
        assertEquals(option.get(1).getText(), "Option 1");
        assertEquals(option.get(2).getText(), "Option 2");

        dropDownSelect.selectByIndex(1); // выбрать первый элемент
        String dropDownText = dropDownSelect.getFirstSelectedOption().getText();
        assertEquals(dropDownText, "Option 1"); //проверка того, что выбран первый элемент

        dropDownSelect.selectByIndex(2); // выбрать второй элемент
        String dropDownText2 = dropDownSelect.getFirstSelectedOption().getText();
        assertEquals(dropDownText2, "Option 2"); //проверка того, что выбран второй элемент
    }
}


