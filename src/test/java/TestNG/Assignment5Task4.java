package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

    @Test(dataProvider = "getData")
    public void test(String word){

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
       // driver.findElement((By.xpath("//input[@name='search']")).sendKeys(word+ Keys.ENTER);
    }
    @DataProvider
    public Object [][] getData(){
        return new Object[][]{
                {"mac"},
                {"ipad"},
                {"Samsung"},
        };
}
}
