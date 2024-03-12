package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment4Task2 {

    WebDriver driver;

    /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
    @Test
    public void task2Assig4() throws InterruptedException {

       // Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        Actions action= new Actions(driver);
        WebElement BANK = driver.findElement(By.id("credit2"));
        WebElement DEBITSIDEAccount = driver.findElement(By.xpath("//li[@class='placeholder'][1]"));
        action.dragAndDrop(BANK,DEBITSIDEAccount).perform();
        Thread.sleep(3000);

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement SALES = driver.findElement(By.id("credit1"));
        WebElement CREDITSIDEAccount = driver.findElement(By.xpath("//ol[@class='field15 ui-droppable ui-sortable']"));
        action.dragAndDrop(SALES,CREDITSIDEAccount).perform();
        Thread.sleep(3000);

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement fourth1 = driver.findElement(By.id("fourth"));
        WebElement DEBITSIDEAmount = driver.findElement(By.xpath("//*[@id='amt7']/li"));
        action.dragAndDrop(fourth1,DEBITSIDEAmount).perform();
        Thread.sleep(3000);

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement fourth2 = driver.findElement(By.id("fourth"));
        WebElement CREDITSIDEAmount = driver.findElement(By.xpath("//*[@id='amt8']/li"));
        action.dragAndDrop(fourth2,CREDITSIDEAmount).perform();
        Thread.sleep(3000);

        //Verify the visibility of Perfect text
        if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed()){
            System.out.println("Perfect Displayed !!!");
        } else {
            System.out.println("Perfect not Displayed !!!");
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
