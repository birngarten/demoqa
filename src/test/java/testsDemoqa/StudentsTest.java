package testsDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class StudentsTest {

    @BeforeTest
    public void start(){
        Driver.getDriver().get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
    }
    @Test
    public void test1(){
        List<WebElement> students = new ArrayList<>();
        for (int i=1;i<22;i++){
            String element = "//li[@id='node"+i+"']";
            WebElement student = Driver.getDriver().findElement(By.xpath(element));
            students.add(student);
        }
        System.out.println(students);
    }
}
