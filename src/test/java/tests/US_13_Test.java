package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_13_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class US_13_Test extends TestBase {

    US_13_Page us_13_page = new US_13_Page();
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
    }
    @Test
    public void TC_057(){
//Alerts, Frame & Windows menusune tiklandiginda
//Nested Frames menu linki calistigini verify ediniz.
        us_13_page.alertsCard.click();
        Assert.assertTrue(us_13_page.nestedMenuLink.isEnabled());
    }
    @Test
    public void TC_058(){
//Nested Frames menu linkine tiklandiginda acilan sayfada
// 2 adet Iframe oldugunu assert ediniz.

// us_13_page.alertsCard.click();
// us_13_page.nestedMenuLink.click();
// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(us_13_page.iframeList.get(0)));
// //Driver.getDriver().switchTo().frame(us_13_page.iframeList.get(0));
// //ReusableMethods.waitFor(1);
// Driver.getDriver().switchTo().frame(us_13_page.iframeList.get(0));
// us_13_page.iframeList.add(Driver.getDriver().findElement(By.xpath("//iframe")));
// System.out.println(us_13_page.iframeList.size());

        List<WebElement> iframeList = Driver.getDriver().findElements(By.xpath("//iframe"));
        for(int i=0;i<100;i++){
            Driver.getDriver().switchTo().frame(iframeList.get(i));
            iframeList.add(Driver.getDriver().findElement(By.xpath("//iframe")));
            if(iframeList.size()!=i+1){
                break;
            }
        }
        Assert.assertEquals(iframeList.size(),2);


    }
    @Test
    public void TC_059(){

    }
    @Test
    public void TC_060(){

    }
    @Test
    public void TC_061(){

    }
    @Test
    public void TC_062(){

    }

}


