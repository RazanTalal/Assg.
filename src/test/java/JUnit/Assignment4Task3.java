package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;


public class Assignment4Task3 {
    WebDriver driver;

    // go to https://www.google.com/
    // search for "Scroll Methods" by using an Actions object
    @Test
    public void task3Assig4() throws InterruptedException {

        driver.get("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object

        WebElement searchInput = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);

        actions.moveToElement(searchInput).click().keyDown(Keys.SHIFT)
                .sendKeys("s").keyUp(Keys.SHIFT).sendKeys("croll").sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).sendKeys("ethods").sendKeys(Keys.ENTER)
                .build().perform();

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
