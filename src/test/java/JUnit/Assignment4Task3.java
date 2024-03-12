package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4Task3 {
    WebDriver driver;

    // go to https://www.google.com/
    // search for "Scroll Methods" by using an Actions object
    @Test
    public void task3Assig4(){

        // go to https://www.google.com/
        driver.get("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object




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
