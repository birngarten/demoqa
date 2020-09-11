package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CountryesTest {

    @BeforeTest
    public void start(){
        Driver.getDriver().get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
    }

    @Test
    public void test2(){
        ReusableMethods.waitFor(2);
        List<WebElement> countryes = new ArrayList<>();
        List<WebElement> cityes = new ArrayList<>();
        WebElement error = Driver.getDriver().findElement(By.id("answerDiv"));
        for(int i=1; i<16; i++){
            countryes.add(Driver.getDriver().findElement(By.xpath("(//div[@class='dragDropSmallBox'])["+i+"]")));
            //System.out.println(countryes);
        }
        for(int i=16; i<31; i++){
            cityes.add(Driver.getDriver().findElement(By.xpath("(//div[@class='dragDropSmallBox'])["+i+"]")));
            //System.out.println(cityes);
        }
        Actions actions = new Actions(Driver.getDriver());
        for (int i=0;i<15;i++){
            if(cityes.size()==0){
                break;
            }
            for (int j=0;j<15;){
                if(cityes.size()==0){
                    break;
                }
            ReusableMethods.waitFor(1);
            actions.clickAndHold(cityes.get(i)).perform();
            ReusableMethods.waitFor(1);
            actions.moveToElement(countryes.get(j)).perform();
            actions.release().perform();
            ReusableMethods.waitFor(1);
            actions.build().perform();
            if(cityes.get(i).getAttribute("class").equals("correctAnswer")){
                cityes.remove(i);
                j++;
                i=0;
            }  else {
                actions.clickAndHold(cityes.get(i)).perform();
                ReusableMethods.waitFor(1);
                actions.moveToElement(error).perform();
                actions.release().perform();
                ReusableMethods.waitFor(1);
                actions.build().perform();
                i++;
                }
            }
        }
        Assert.assertTrue(cityes.size()==0);
    }

}
