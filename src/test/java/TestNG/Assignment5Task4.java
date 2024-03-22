package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment5Task4 {
    WebDriver driver;
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    // Login with that credentials
    // Email: clarusway@gmail.com
    // Password: 123456789
    // Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    // (create an array structure with "Mac, iPad and Samsung". You can see it in Assignment 2)

    By email= By.id("input-email");
    By passwordName = By.id("input-password");
    By buttonTag = By.xpath("//input[@type='submit']");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "getData")
    public void test(String searchInput)throws InterruptedException{

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        driver.findElement(email).sendKeys("clarusway@gmail.com");
        driver.findElement(passwordName).sendKeys("123456789");
        driver.findElement(buttonTag).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(searchInput+ Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    }
    @DataProvider
    public Object [][] getData(){
        return new Object[][]{
                {"mac"},
                {"ipad"},
                {"Samsung"},
        };
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
