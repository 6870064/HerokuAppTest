import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckHoversTest extends BaseTest {

    @Test
    public void checkHovers() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        //User 1
        WebElement ProfileElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        Actions action = new Actions(driver);
        action.moveToElement(ProfileElement).build().perform();
        WebElement ProfileNameElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        assertEquals(ProfileNameElement.getText(), "name: user1", "User name is not equal to name: user1");
        WebElement ProfileLinkElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
        action.moveToElement(ProfileLinkElement).click().perform();

        WebElement InfoText = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals(InfoText.getText(), "Not Found", "404 error is found");

        //User 2. Копипаста действий с User1, отличия только в Xpath.
        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement Profile2Element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(Profile2Element).build().perform();
        WebElement Profile2NameElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        assertEquals(Profile2NameElement.getText(), "name: user2", "User name is not equal to name: user2");
        WebElement Profile2LinkElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));
        action.moveToElement(Profile2LinkElement).click().perform();

        WebElement Info2Text = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals(Info2Text.getText(), "Not Found", "404 error. User2 Profile is not found.");

        //User 3. Копипаста действий с User1, отличия только в Xpath.
        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement Profile3Element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        Actions action3 = new Actions(driver);
        action2.moveToElement(Profile3Element).build().perform();
        WebElement Profile3NameElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        assertEquals(Profile3NameElement.getText(), "name: user3", "User name is not equal to name: user3");
        WebElement Profile3LinkElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));
        action.moveToElement(Profile3LinkElement).click().perform();

        WebElement Info3Text = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals(Info3Text.getText(), "Not Found", "404 error. User3 Profile is not found.");
    }
}
