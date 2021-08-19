import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControl() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        String test_text = driver.findElement(By.id("checkbox")).getText();
        assertEquals(test_text, "A checkbox", "A checkbox has not been found"); //Найти чекбокс
        driver.findElement(By.xpath("//button[text()='Remove']")).click(); // Нажать на кнопку

        WebDriverWait wait = new WebDriverWait(driver, 10);

        String textForTest2 = driver.findElement(By.id("message")).getText();
        assertEquals(textForTest2, "It's gone!", "A checkbox hasn't gone"); //Дождался надписи “It’s gone”

        List<WebElement> dynamicElement = driver.findElements(By.xpath("//*[@type='checkbox']"));
        boolean isPresented = dynamicElement.size() != 0;
        assertEquals(isPresented, false, "Checkbox is still displayed"); //проверить, что чекбокса нет

        driver.findElement(By.cssSelector("[type='text']")); //Найти инпут. Второй вариант нахождения - по xpath
        // *[@type="text"]

        boolean input_state1 = driver.findElement(By.cssSelector("[type='text']")).isEnabled();
        assertEquals(input_state1, false, "Input field is Enabled"); //Проверить, что инпут disabled

        driver.findElement(By.xpath("//button[text()='Enable']")).click();// Нажать на кнопку Enable

        WebElement element = wait.until(d -> d.findElement(By.id("message")));

        String textForTest3 = element.getText();
        assertEquals(textForTest3, "It's enabled!", "Input is not enabled"); //Дождался надписи
        // It's enabled!”

        boolean input_state2 = driver.findElement(By.cssSelector("[type='text']")).isEnabled();
        assertEquals(input_state2, true, "Input field is Enabled"); //Проверить, что инпут disabled
    }
}
