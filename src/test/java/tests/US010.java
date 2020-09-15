package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US010Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US010 {

    US010Page us010 = new US010Page();

    @BeforeTest
    public void stars() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }

    @Test
    public void tc043() {
        us010.alersFrameAndWindows.click();
        ReusableMethods.waitFor(1);
        //us010.browserWindows.click();
        Assert.assertTrue(us010.browserWindows.isDisplayed());
    }

    @Test
    public void tc044() {
        //eksik kaldı
        us010.alersFrameAndWindows.click();
        //  us010.browsersWindow.click();
//        List<String> text = new ArrayList<>();
//        for (int i=11; i<16;i++){
//            String element = "(//span[@class='text'])["+i+"]";
//            text.add(Driver.getDriver().findElement(By.id(element)).getText());
//        }
//        System.out.println(text);
    }
    @Test
    public void tc045(){
        us010.alersFrameAndWindows.click();
        us010.browsersWindow.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(us010.newTabButton.isDisplayed());
        softAssert.assertTrue(us010.newWindowButton.isDisplayed());
        softAssert.assertTrue(us010.newWindowMessageButton.isDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void tc046(){
        us010.alersFrameAndWindows.click();
        us010.browsersWindow.click();
        String ilkSayfa = Driver.getDriver().getWindowHandle();
        us010.newTabButton.click();
        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        for (String w:windowHandles  ) {
            if (!w.equals(ilkSayfa)){
                Driver.getDriver().switchTo().window(w);
            }
        }
        Assert.assertTrue(us010.newPageText.isDisplayed());
    }
    @Test
    public void tc047(){
        us010.alersFrameAndWindows.click();
        us010.browsersWindow.click();
        String ilkSayfa = Driver.getDriver().getWindowHandle();
        us010.newTabButton.click();

        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        for (String w:windowHandles  ) {
            if (!w.equals(ilkSayfa)){
                Driver.getDriver().switchTo().window(w);
            }
        }
        Assert.assertTrue(us010.newPageText.isEnabled());
    }
    @Test
    public void tc048(){
        us010.alersFrameAndWindows.click();
        us010.browsersWindow.click();
        String ilkSayfa = Driver.getDriver().getWindowHandle();
        us010.newWindowMessageButton.click();

        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        for (String w:windowHandles  ) {
            if (!w.equals(ilkSayfa)){
                Driver.getDriver().switchTo().window(w);
            }
        }
        System.out.println(us010.getNewWindowMessageText.getText());
        //yapamadik
    }
    @Test
    public void tc049(){
        us010.alersFrameAndWindows.click();
        Assert.assertTrue(us010.alerts.isDisplayed());
    }
    @Test
    public void tc050(){
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        List<WebElement> buttons = new ArrayList<>();
        buttons.add(us010.firstButton);
        buttons.add(us010.secondButton);
        buttons.add(us010.thirdButton);
        buttons.add(us010.forthButton);
        for(WebElement w :buttons){
            Assert.assertTrue(w.isEnabled());
        }
        Assert.assertEquals(buttons.size(),4);
    }
    @Test
    public void tc051(){
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        us010.firstButton.click();
       //Driver.getDriver().switchTo().alert();
        String alertMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println(alertMessage);
        Driver.getDriver().switchTo().alert().accept();
    }
}
