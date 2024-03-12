package JUnit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Assignment4Task1 {

    WebDriver driver;

    //Go to URL: https://the-internet.herokuapp.com/windows
    // Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”
    @Test
    public void task1Assig4() {

        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        // Verify the text: “Opening a new window”
        String text = driver.getPageSource();
        if (driver.getPageSource().contains("Opening a new window")) {
            System.out.println("Text: " + text + " is present. ");
        } else {
            System.out.println("Text: " + text + " is not present. ");
        }

        //Verify the title of the page is “The Internet”
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        if(actualTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title didn't match");
        }

        //Click on the “Click Here” button
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        //Verify the new window title is “New Window”
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "New Window";
        if(actualTitle1.equalsIgnoreCase(expectedTitle1)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title didn't match");
        }

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
       String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        if(actualTitle2.equalsIgnoreCase(expectedTitle2)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title didn't match");
        }


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
