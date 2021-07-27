import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test
    public void elementTypos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> typosElements = driver.findElements(By.tagName("p"));

        assertEquals(typosElements.get(0).getText(), "This example demonstrates a typo being introduced. " +
                "It does it randomly on each page load.");
        assertEquals(typosElements.get(1).getText(), "Sometimes you'll see a typo, other times you won,t.");
    }
}


