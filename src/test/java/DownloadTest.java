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
    public void fileDownload(){

        String testFileName = "Dzmitry.Viachaslavau.png";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
      //  chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("/Users/dzmitry.viachaslavau/", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options); //Step 1: Create WebDriver and Add Options
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement el = driver.findElement(By.partialLinkText("Viachaslavau"));
        el.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File folder = new File("/Users/dzmitry.viachaslavau/Downloads/"); //Step 3: Check The File in Folder

        File[] listOfFiles = folder.listFiles();  //List the files on that folder
        boolean found = false;
        File f = null;
        //Look for the file in the files

        for (File listOfFile : listOfFiles) { //фейлится здесь
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                System.out.println(fileName);
                if (fileName == testFileName) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded file titled "+testFileName+ " is not found");
        f.deleteOnExit();
    }
}
