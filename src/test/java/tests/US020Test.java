package tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US020Page;
import utilities.Driver;

import java.awt.*;

public class US020Test {
    US020Page us020Page = new US020Page();
    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get("https://demoqa.com/tabs");
    }
    @Test
    public void tc105(){
        //Sayfa basliginin "Tab" oldugunu assert edin.
        Assert.assertEquals(us020Page.pageHeader.getText(),"Tabs");
    }
    @Test
    public void tc106(){
        Assert.assertEquals(us020Page.upperHeader.getText(),"Details about Lorem Ipsum");
    }
    @Test
    public void tc107(){
//        us020Page.tabs.remove(0);
//        us020Page.tabs.remove(us020Page.tabs.size()-1);

        String [] myArray = {"","What", "Origin", "Use" , "More",""};
        for(int i=1;i<4;i++){
            System.out.println("list"+us020Page.tabs.get(i).getText());
            System.out.println("array"+myArray[i]);
           Assert.assertEquals(us020Page.tabs.get(i).getText(),myArray[i]);
        }
    }
    @Test
    public void tc108(){
        //Textbox in mavi renkte oldugunu ve click yapildiginda gri renk oldugunu ve bilgiyi assert edin
        Assert.assertEquals(Color.fromString(us020Page.tabs.get(1).getCssValue("color")).asHex(),"#495057");
    }
    @Test
    public void tc109(){
        //"Origin" linkinin mavi renkte oldugunu ve click yapildiginda gri renk oldugunu ve bilgiyi assert edin.
        Assert.assertEquals(Color.fromString(us020Page.tabs.get(2).getCssValue("color")).asHex(),"#007bff");
        us020Page.tabs.get(2).click();
        Assert.assertEquals(Color.fromString(us020Page.tabs.get(2).getCssValue("color")).asHex(),"#495057");
    }
    @Test
    public void tc110(){
        //"Use" linkinin mavi renkte oldugunu ve click yapildiginda gri renk oldugunu ve bilgiyi assert edin
        Assert.assertEquals(Color.fromString(us020Page.tabs.get(3).getCssValue("color")).asHex(),"#007bff");
        us020Page.tabs.get(3).click();
        Assert.assertEquals(Color.fromString(us020Page.tabs.get(3).getCssValue("color")).asHex(),"#495057");
    }
    @Test
    public void tc111(){
        //"More" yazısına tıknamadığını assert edin
        Assert.assertFalse(us020Page.tabs.get(4).isSelected());
    }

}
