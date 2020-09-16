package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemogaWebTablesButtonsLinksPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US005Test {
    DemogaWebTablesButtonsLinksPage demogaWebTablesButtonsLinksPage = new DemogaWebTablesButtonsLinksPage();
    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc022(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.buttons.click();
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.pagePageHeader.getText().equals("Buttons"));
        String  frontHeader = demogaWebTablesButtonsLinksPage.pagePageHeader.getCssValue("font-weight");
        Assert.assertEquals(frontHeader,"300");
        //front-weight degeri assert etme
    }
    @Test
    public void tc023(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.buttons.click();
        ReusableMethods.waitFor(2);
//        Assert.assertTrue(demogaWebTablesButtonsLinksPage.doubleClickButton.isEnabled());
//        Assert.assertTrue(demogaWebTablesButtonsLinksPage.rightClickButton.isEnabled());
//        Assert.assertTrue(demogaWebTablesButtonsLinksPage.clickMeButton.isEnabled());
        for(WebElement w : demogaWebTablesButtonsLinksPage.buttonsReturn()){
            //Assert.assertTrue(w.isDisplayed());
            Assert.assertTrue(w.isEnabled());
        }
    }
    @Test
    public void tc024(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.buttons.click();
        ReusableMethods.waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        List<String>results = new ArrayList<>();
        actions.doubleClick(demogaWebTablesButtonsLinksPage.doubleClickButton).perform();
        results.add(demogaWebTablesButtonsLinksPage.doubleClickMessage.getText());
        actions.contextClick(demogaWebTablesButtonsLinksPage.rightClickButton).perform();
        results.add(demogaWebTablesButtonsLinksPage.rightClickMessage.getText());
        demogaWebTablesButtonsLinksPage.clickMeButton.click();
        results.add(demogaWebTablesButtonsLinksPage.dynamicClickMessage.getText());
        System.out.println(results);
        Assert.assertTrue(results.contains("You have done a right click"));
        Assert.assertTrue(results.contains("You have done a dynamic click"));
        Assert.assertTrue(results.contains("You have done a double click"));
    }
}
