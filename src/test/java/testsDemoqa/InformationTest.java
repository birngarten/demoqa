package testsDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class InformationTest {

    @BeforeTest
    public void setUp(){
        Driver.getDriver().get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
    }
    @Test
    public void test1(){
        List<WebElement> informationBoxes = new ArrayList<>();
        List<WebElement> boxes = new ArrayList<>();
        Actions actions = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.id("node12"));
        System.out.println(element.getText());
        for (int i=1;i<22;i++){
            String elemntLocator = "node"+i;
            informationBoxes.add(Driver.getDriver().findElement(By.id(elemntLocator)));
            //System.out.println(Driver.getDriver().findElement(By.id(elemntLocator)).getText());
        }
        for (int i=1;i<8;i++){
            String elementLocator = "box"+i;
            boxes.add(Driver.getDriver().findElement(By.id(elementLocator)));
        }
        for (int i=0;i<21;){
            if(informationBoxes.isEmpty()){
                break;
            }
            for(int j=0;j<7;){
                if(informationBoxes.isEmpty()){
                    break;
                }
                actions.clickAndHold(informationBoxes.get(i)).perform();
                ReusableMethods.waitFor(1);
                actions.moveToElement(boxes.get(j)).perform();
                ReusableMethods.waitFor(1);
                actions.release().perform();

                if(informationBoxes.get(i).getAttribute("class").equals("correctAnswer")){
                    informationBoxes.remove(i);
                    i=0;
                    j=0;
                } else {
                    ReusableMethods.waitFor(1);
                    actions.moveToElement(Driver.getDriver().findElement(By.id("allItems")));
                    j++;
                }
            }
        }
        Assert.assertTrue(informationBoxes.isEmpty());
    }
}
