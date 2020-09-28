package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US018Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US018Test {
    US018Page us018Page = new US018Page();
    @BeforeMethod
    public void start() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc091(){
        //slide.ın sola kaydırılabildiğini assert edin
        us018Page.widgetsCard.click();
        us018Page.sliderLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(us018Page.sliderBall).perform();
        for(int i=0;i<30;i++){
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        }
        String value = us018Page.sliderValue.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(value)<50);
    }
    @Test
    public void tc092(){
        //slide.ın sağa kaydırılabildiğini assert edin
        us018Page.widgetsCard.click();
        us018Page.sliderLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(us018Page.sliderBall).perform();
        for(int i=0;i<30;i++){
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
        String value = us018Page.sliderValue.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(value)>50);
    }
    @Test
    public void tc093(){
        //slide.ın en sola kaydırılabildiğini assert edin
        us018Page.widgetsCard.click();
        us018Page.sliderLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(us018Page.sliderBall).perform();
        for(int i=0;i<=50;i++){
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        }
        String value = us018Page.sliderValue.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(value)==0);
    }
    @Test
    public void tc094(){
        //slide.ın en sağa kaydırılabildiğini assert edin
        us018Page.widgetsCard.click();
        us018Page.sliderLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(us018Page.sliderBall).perform();
        for(int i=0;i<=50;i++){
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
        String value = us018Page.sliderValue.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(value)==100);
    }
    @Test
    public void tc095(){
        //slide.ı önce sola sonra sağa kaydırılabildiğini assert edin
        us018Page.widgetsCard.click();
        us018Page.sliderLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(us018Page.sliderBall).perform();
        for(int i=0;i<=30;i++){
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        }
        for(int i=0;i<=40;i++){
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
        String value = us018Page.sliderValue.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(value)>50);
    }
    @Test
    public void tc096(){
        //slide.ı önce sola sonra sağa kaydırılabildiğini assert edin
        us018Page.widgetsCard.click();
        us018Page.sliderLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(us018Page.sliderBall).perform();
        for(int i=0;i<=30;i++){
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
        for(int i=0;i<=40;i++){
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        }
        String value = us018Page.sliderValue.getAttribute("value");
        Assert.assertTrue(Integer.parseInt(value)<50);
    }
}
