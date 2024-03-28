package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Assignment4Task7 {
    WebDriver driver;

    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    @Test
    public void task4Assig7() throws IOException {

        //Go to amazon.com
        driver.get("https://www.amazon.com/");

        // Take Full Page Screenshot.
        TakesScreenshot ss = (TakesScreenshot)driver;
        File ssFile = ss.getScreenshotAs(OutputType.FILE);
        //FieldUtils.copyFile(ssFile,new File("C:\\Users\\Talal\\IdeaProjects\\Assignment\\test-output\\fullScreenshot\\screenshot.png"));

        // Take any spesific WebElement ScreenShot
        WebElement amazonImage = driver.findElement(By.id("nav-logo-sprites"));
        File amazonImageSS = amazonImage.getScreenshotAs(OutputType.FILE);
       // FieldUtils.copyFile(amazonImageSS,new File("C:\\Users\\Talal\\IdeaProjects\\Assignment\\test-output\\screenshot\\webElementScreenshot.png"));
    }

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    public void afterEach() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }
}
