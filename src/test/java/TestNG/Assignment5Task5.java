package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Assignment5Task5 {

    WebDriver driver;

    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Task5() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://crossbrowsertesting.github.io/");

        // Click To-Do App link
        driver.findElement(By.xpath("//a[@href='todo-app.html']")).click();

        //Checking Box to do-4 and Checking Box to do-5
        List<WebElement> todos = driver.findElements(By.xpath("//input[@type='checkbox']"));
        todos.get(3).click();
        todos.get(4).click();

        //If both clicks worked, then the following List should be have length 2.
        // Check the length of the list
        int todoo=0;
        for (WebElement todo : todos) {
            if (todo.isSelected()){
                todoo++;
            }
        }

        //Assert that this is correct
        Assert.assertEquals(todoo,2);

        //Assert that the to do we added is present in the list
        //assertTrue(todos.stream().anyMatch(e -> e.getText().equals("To-Do 4")));
        //assertTrue(todos.stream().anyMatch(e -> e.getText().equals("To-Do 5")));
        String todoItem1 = "To-Do 4";
        String todoItem2 = "To-Do 5";

        assertTrue(isTodoPresent(todoo, todoItem1));
        assertTrue(isTodoPresent(todoo, todoItem2));


        // Archiving old todos
        driver.findElement(By.linkText("Archive")).click();

        //If our archive link worked, then the following list should have length 4.
        // Check the length of the list after archiving
        List<WebElement> todooo = driver.findElements(By.xpath("//span[@class='done-false']"));
        int newtodo = todooo.size();

        //Assert that this is true as well
        Assert.assertEquals(newtodo,4);
    }

    private boolean isTodoPresent(List<WebElement> todos, String todoText) {
        for (WebElement todo : todos) {
            if (todo.getText().equals(todoText)) {
                return true;
            }
        }
        return false;
    }

        @AfterClass
        public void afterClass () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
}
