import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/152360.jpeg");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click(); //Загрузить файл

        WebDriverWait wait = new WebDriverWait(driver, 5);

        String file_title = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(file_title, "152360.jpeg", "Title of the uploaded file is nnot equal"); //Проверить, что имя файла
        // на странице совпадает с именем загруженного файла

        driver.findElement(By.id("uploaded-files")).getText();
        String text_string = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        assertEquals(text_string, "File Uploaded!", "File is not Uploaded!"); //Проверка наличия сообщения
        // об успешной загрузке файла
    }
}


