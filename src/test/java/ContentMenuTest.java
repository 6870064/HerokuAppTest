import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContentMenuTest extends BaseTest {

    @Test
    public void contextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions
                .contextClick(driver.findElement(By.id("hot-spot"))) //Правый клик по элементу
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();

        assertEquals(alert.getText(), "You selected a context menu", "Alert text is wrong"); //Валидация
        // текста на алерте
        alert.dismiss(); //Закрытие алерта
    }
}
