package testsDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US026Page;
import utilities.Driver;

public class US026Test {
    US026Page us026Page = new US026Page();
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://demoqa.com/interaction");
    }
    @Test
    public void tc147(){
        //-Resizable textinin tiklanilir ve acilir oldugunu ve sayfada main-header oldugunu dogrula.
        Assert.assertTrue(us026Page.resiableLink.isEnabled());
    }
    @Test
    public void tc148(){
        //--Resizable texti tiklanildiginda; üstte büyügü olmak üzere iki "Resizable" kutunun acildigini kontrol edin.
        us026Page.resiableLink.click();
        Assert.assertEquals(us026Page.boxes.size(),2);
    }
    @Test
    public void tc149(){
        //--Birinci kutunun, en fazla icinde bulundugu kutu kadar buyutulebildigni dogrula.
        us026Page.resiableLink.click();
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@style='width: 200px; height: 200px;']"));
        js.executeScript("arguments[0].setAttribute('width', '300px')", element);
        js.executeScript("document.getElementById('colorPickIcon').setAttribute('style', '22.3333px')");

//        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
//        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);


    }

    @Test
    public void tc150(){
        //-(Boyutlarinin ise; Starting at 200x200. Min size is 150x150, max ise 500x300. oldugu dogrulanmali)
        //-Alttaki diger kutunun ise istenildigi kadar buyutulup ve kucultulebildigini dogrula.
    }
}
