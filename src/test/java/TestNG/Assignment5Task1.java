package TestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Assignment5Task1 {

   WebDriver driver;

    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void GoingToFacebook(){

        driver.get("https://www.facebook.com/");

    }

    @Test(dependsOnMethods = "GoingToFacebook")
    public void GoingToGoogle(){

        driver.get("https://www.google.com/");

    }

    @Test(dependsOnMethods = "GoingToGoogle")
    public void GoingToAmazon(){

        driver.get("https://www.amazon.com/");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
