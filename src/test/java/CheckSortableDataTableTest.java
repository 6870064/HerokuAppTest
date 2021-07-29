import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckSortableDataTableTest extends BaseTest {

    @Test
    public void checkDropdownListElements() {
        driver.get("http://the-internet.herokuapp.com/tables");
        //tr[1]//td[1]  tr - строка; td - столбец
        WebElement tableElement1 = driver.findElement(By.xpath("//table//tr[1]//td[1]")); // Реки говнокода =))
        WebElement tableElement2 = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        WebElement tableElement3 = driver.findElement(By.xpath("//table//tr[3]//td[3]"));
        WebElement tableElement4 = driver.findElement(By.xpath("//table//tr[4]//td[4]"));
        WebElement tableElement5 = driver.findElement(By.xpath("//table//tr[4]//td[5]"));
        assertEquals(tableElement1.getText(),"Smith", " " +tableElement1+ " last name has not found");
        assertEquals(tableElement2.getText(),"John", " " +tableElement2+ " first name has not found");
        assertEquals(tableElement3.getText(),"jdoe@hotmail.com", " " +tableElement4+ " email has not found");
        assertEquals(tableElement5.getText(),"http://www.timconway.com", " " +tableElement5+ " price has not found");
    }
}


