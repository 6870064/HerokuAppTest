import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckInputsTest extends BaseTest {

    @Test
    public void checkInputs(){
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
       inputField.sendKeys(Keys.ARROW_UP);
       inputField.sendKeys(Keys.ARROW_DOWN);
    }
}


