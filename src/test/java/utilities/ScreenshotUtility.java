package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String path =
                System.getProperty("user.dir")
                + "\\Screenshots\\"
                + testName
                + ".png";

        try {

            File folder = new File(
                    System.getProperty("user.dir")
                    + "\\Screenshots");

            if(!folder.exists()) {

                folder.mkdirs();
            }

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            FileHandler.copy(src, new File(path));

        } catch(Exception e) {

            e.printStackTrace();
        }

        return path;
    }
}