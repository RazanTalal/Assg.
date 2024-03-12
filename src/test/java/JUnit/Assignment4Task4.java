package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Assignment4Task4 {
    WebDriver driver;

    /*
    Go to Amazon
    Scroll to the bottom of the page using a robot
    Click on the "Back to top" web element
    Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
    Use Actions to type "ClarusWay" in the search box and perform the search
 */
    @Test
    public void task4Assig4() throws InterruptedException, AWTException {

        driver.get("https://www.amazon.com/");

        //Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.mouseWheel(4);
        Thread.sleep(5000);

        //Click on the "Back to top" web element
        driver.findElement(By.id("navBackToTop")).click();
        Thread.sleep(5000);

        //Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement jsInLogo = driver.findElement(By.xpath("//a[@href='/?ref_=footer_logo']"));
        js.executeScript("arguments[0].scrollIntoView();", jsInLogo);
        jsInLogo.click();

        String currentURL= driver.getCurrentUrl();
        Assertions.assertEquals("https://www.amazon.com/?ref_=footer_logo", currentURL);
        Thread.sleep(5000);

        //Use Actions to type "ClarusWay" in the search box and perform the search
        Actions actions = new Actions(driver);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(search).sendKeys("ClarusWay").build().perform();

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
