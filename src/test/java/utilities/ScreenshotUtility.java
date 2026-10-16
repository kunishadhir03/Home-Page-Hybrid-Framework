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

        if (testName == null || testName.trim().isEmpty()) {
            testName = "BlankData";
        }

        String cleanedName =
                testName.replaceAll("[^a-zA-Z0-9_-]", "");

        if (cleanedName.isEmpty()) {
            cleanedName = "SpecialCharacters";
        }

        String path =
                System.getProperty("user.dir")
                        + "\\Screenshots\\"
                        + cleanedName
                        + ".png";

        try {

            File folder = new File(
                    System.getProperty("user.dir")
                            + "\\Screenshots");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            FileHandler.copy(
                    src,
                    new File(path));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}