import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void login() {

        driver.get("http://the-internet.herokuapp.com/login");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        assertEquals(userName.getAttribute("value"), "tomsmith", "Username is " +
                "not entered in the field");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        userName.submit();

        String message = driver.findElement(By.id("flash")).getText();
        assertEquals(message, "You logged into a secure area!\n" +
                "×", "Text is different");
    }
}