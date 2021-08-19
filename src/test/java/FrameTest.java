import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTest {

    @Test
    public void frameCheck() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0); //Открыть iFrame
        String frame_text = driver.findElement(By.xpath("//*[text()='Your content goes here.']")).getText();
        assertEquals(frame_text, "Your content goes here.", "Text in the frame is not equal"); //Проверка,
        // что текст внутри параграфа равен “Your content goes here.”
        driver.switchTo().defaultContent(); //Закрыть iFrame
    }
}
