package testsDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US016Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US016Test {
    US016Page us016Page = new US016Page();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc074(){
        //sayfanın başlığının "Auto Complete" olduğunu assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        Assert.assertEquals(us016Page.PageHeader.getText(),"Auto Complete");
    }
    @Test
    public void tc075(){
        //üst text başlığının "Type multiple color names" olduğunu assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        Assert.assertEquals(us016Page.upperPartText.getText(),"Type multiple color names");
    }
    @Test
    public void tc076(){
        //-Alt Text boxların başlığının "Type single color name" olduğunu assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        System.out.println(us016Page.downerPartText.getText());
        Assert.assertEquals(us016Page.downerPartText.getText(),"Type single color name");
    }
    @Test
    public void tc079(){
        //Üst Text box.a bir kaç harf yazın, bu harfleri içeren renklerin aşağıda listelendiğini asset edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        us016Page.upperPartText.click();
        ReusableMethods.waitFor(1);
        String []myTestArray = {"Red","Blue","Black","Green","Yellow","Purple"};
        for(int i=0;i<myTestArray.length;i++){
            actions.sendKeys(myTestArray[i]).perform();
            ReusableMethods.waitFor(1);
            actions.sendKeys(Keys.ENTER).perform();
        }
        for(int i=0;i<myTestArray.length;i++){
            Assert.assertTrue(Driver.getDriver().findElement(By.id("autoCompleteMultipleContainer"))
                    .getText().contains(myTestArray[i]));
        }
    }

    @Test
    public void tc081(){
        //seçilen renklerin tümünün silinebildiğini assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        us016Page.upperPartText.click();
        ReusableMethods.waitFor(1);
        String []myTestArray = {"Red","Blue","Black","Green","Yellow","Purple"};
        for(int i=0;i<myTestArray.length;i++){
            actions.sendKeys(myTestArray[i]).perform();
            ReusableMethods.waitFor(1);
            actions.sendKeys(Keys.ENTER).perform();
        }
        for(int i=0;i<myTestArray.length;i++){
            actions.click(us016Page.upperColorDelete).perform();
            ReusableMethods.waitFor(1);
        }
        ReusableMethods.waitFor(1);

        String result = "test";
        try {
            us016Page.upperColorTextControl.getText();
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            result = "ok";
        }
        Assert.assertEquals(result,"ok");
    }

    @Test
    public void tc082(){
        //Alt Text box.a yazılan harfleri içeren renkler aşağıya listelenmelidir.
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        actions.click(us016Page.dowerPartTextBox).sendKeys("Red").perform();
        //assert yapamadım
    }
    @Test
    public void tc083(){
        //Listelenen renklerden birinin seçilebildiğini assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        actions.click(us016Page.dowerPartTextBox).sendKeys(ConfigReader.getProperty("demoqa_color_test")).perform();
        actions.sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(ConfigReader.getProperty("demoqa_color_test"),us016Page.downerTextBoxResult.getText());
    }
    @Test
    public void tc084(){
//        us016Page.widgetsCard.click();
//        us016Page.AutoCompleteLink.click();
//        actions.click(us016Page.dowerPartTextBox).sendKeys(ConfigReader.getProperty("demoqa_color_test")).perform();
//        actions.sendKeys(Keys.ENTER).perform();
//        actions.click(us016Page.dowerPartTextBox).perform();
//        for(int i=0;i<ConfigReader.getProperty("demoqa_color_test").length();i++){
//            actions.sendKeys(Keys.BACK_SPACE).perform();
//        }
    }

}
