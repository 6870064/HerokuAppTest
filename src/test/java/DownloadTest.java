import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;

public class DownloadTest extends BaseTest {

    @Test
    public void fileDownload() throws InterruptedException {

        String testFileName = "152360.jpeg";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options); //Step 1: Create WebDriver and Add Options
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement el = driver.findElement(By.partialLinkText("152360"));
        el.click();

        Thread.sleep(4000);
        File folder = new File(System.getProperty("user.dir")); //Step 3: Check The File in Folder

        File[] listOfFiles = folder.listFiles();  //List the files on that folder
        boolean found = false;
        File f = null;
        int count = 0;


        while (found != true | count < 10) {

            for (File listOfFile : listOfFiles) { //Look for the file in the files

                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    System.out.println(fileName);
                    if (fileName.equals(testFileName)) {
                        f = new File(fileName);
                        found = true;
                        count++;
                        break;
                    }
                }
            }
            Assert.assertTrue(found, "Downloaded file titled " + testFileName + " is not found");
            f.deleteOnExit();
        }
    }
}
