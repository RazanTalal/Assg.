package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.Set;

public class Assignment4Task5 {
    WebDriver driver;

    /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
    @Test
    public void task4Assig5(){

        //Go to URL: http://facebook.com
        driver.get("http://facebook.com");

        //getCookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        allCookies.forEach(System.out::println);

        //addCookie
        Cookie cookieSugar = new Cookie("NewCookie","Sugar");
        System.out.println("After adding totalNumber: " + driver.manage().getCookies().size());

        //deleteCookieNamed
        driver.manage().deleteCookieNamed("NewCookie");
        System.out.println("Befor Delete All: " + driver.manage().getCookies().size());

        //deleteAllCookies
        driver.manage().deleteAllCookies();
        System.out.println("After Delete: " +driver.manage().getCookies().size());

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
