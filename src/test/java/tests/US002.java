package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class US002  {
    DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }

    @Test
    public void tc005(){
        demoqaPage.elementsCard.click();
        Assert.assertTrue(demoqaPage.textBox.isDisplayed());
        ReusableMethods.waitFor(2);
        demoqaPage.elementOpen.click();
        ReusableMethods.waitFor(2);
        Assert.assertFalse(demoqaPage.textBox.isDisplayed());
    }
    @Test
    public void tc006(){
        demoqaPage.elementsCard.click();
        demoqaPage.checkBox.click();
        Assert.assertTrue(demoqaPage.elementPageHeader.getText().equals("Check Box"));
    }
    @Test
    public void tc007(){
        demoqaPage.elementsCard.click();
        demoqaPage.checkBox.click();
        Assert.assertTrue(demoqaPage.homeCheckbox.isEnabled());
    }
    @Test
    public void tc008(){
        demoqaPage.elementsCard.click();
        demoqaPage.checkBox.click();
        ReusableMethods.waitFor(1);
        demoqaPage.homeArrow.click();
        ReusableMethods.waitFor(1);
        demoqaPage.desktopArrow.click();
        ReusableMethods.waitFor(1);
        demoqaPage.documentsArrow.click();
        ReusableMethods.waitFor(1);
        demoqaPage.downloadsArrow.click();
        ReusableMethods.waitFor(1);
        demoqaPage.workspaceArrow.click();
        ReusableMethods.waitFor(1);
        demoqaPage.officeArrow.click();
        ReusableMethods.waitFor(1);
        SoftAssert softAssert = new SoftAssert();

        demoqaPage.excelFileCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("excel"));
        demoqaPage.excelFileCheckbox.click();

        demoqaPage.wordFileCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("word"));
        demoqaPage.wordFileCheckbox.click();

        demoqaPage.wordFileCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("word"));
        demoqaPage.wordFileCheckbox.click();

        demoqaPage.downloadsCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("downloads"));
        demoqaPage.downloadsCheckbox.click();

        demoqaPage.generalCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("general"));
        demoqaPage.generalCheckbox.click();

        demoqaPage.classifiedCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("classified"));
        demoqaPage.classifiedCheckbox.click();

        demoqaPage.privateCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("private"));
        demoqaPage.privateCheckbox.click();

        demoqaPage.publicCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("public"));
        demoqaPage.publicCheckbox.click();

        softAssert.assertAll();
   }
   @Test
    public void tc009 (){
        SoftAssert softAssert = new SoftAssert();
       List<String> succesText = new ArrayList<>();
       demoqaPage.elementsCard.click();
       demoqaPage.checkBox.click();
       ReusableMethods.waitFor(1);
       for (int i=1; i<7; i++){
           String elementPath = "(//button[@class='rct-collapse rct-collapse-btn'])["+i+"]";
           WebElement element = Driver.driver.findElement(By.xpath(elementPath));
           element.click();
           ReusableMethods.waitFor(1);
       }
       for (int i=1; i<18; i++){
           String checkBoxElementPath = "(//span[@class='rct-checkbox'])["+i+"]";
           WebElement checkBoxElement = Driver.driver.findElement(By.xpath(checkBoxElementPath));
           checkBoxElement.click();
           ReusableMethods.waitFor(1);
           succesText.add(demoqaPage.successText.getText());
           checkBoxElement.click();
       }
       System.out.println(succesText);
    }
}
