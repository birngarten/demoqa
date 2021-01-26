package testsDemoqa;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US010Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US011Test {
    US010Page us010 = new US010Page();

    @BeforeMethod
    public void stars() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
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
        //Birinci Click me butonuna tiklandiginda cikan alertte "You clicked a button" texti oldugunu verify ediniz
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        us010.firstButton.click();
        String aletrtText = Driver.driver.switchTo().alert().getText();
        Assert.assertEquals(aletrtText,"You clicked a button");
    }
    @Test
    public void tc052(){
        //Ikinci Click me butonuna tiklandiginda 5 saniye icinde cikan alertte OK butonuna tiklanabildigini dogrulayiniz
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        us010.secondButton.click();
        ReusableMethods.waitFor(5);
        Driver.driver.switchTo().alert().accept();
        //bir assertion yazmak daha iyi olurdu.
    }
    @Test
    public void tc053(){
        //Ucuncu Click me butonuna tiklandiginda cikan alertte Cancel'e tiklandiktan sonra "You selected Cancel" texti goruntulendigini verify ediniz
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        us010.thirdButton.click();
        Driver.driver.switchTo().alert().dismiss();
        Assert.assertEquals(us010.getThirdButtonResultText.getText(),"You selected Cancel");
    }
    @Test
    public void tc054(){
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        us010.forthButton.click();
        Driver.driver.switchTo().alert().sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        Driver.driver.switchTo().alert().accept();
        //text girilebilmesini nasıl assert ederiz fikrim yok?
    }
    @Test
    public void tc055(){
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        us010.forthButton.click();
        Driver.driver.switchTo().alert().sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        Driver.driver.switchTo().alert().accept();
        Assert.assertEquals(us010.getForthButtonResultText.getText(),"You entered "+ConfigReader.getProperty("demoqa_test_data"));
    }
}
