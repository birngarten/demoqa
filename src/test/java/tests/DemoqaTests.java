package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DemoqaTests {

    DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void mainLinkTest(){
        demoqaPage.mainPage.click();
        ReusableMethods.waitForClickablility(demoqaPage.mainPage,5000);
        Assert.assertTrue(demoqaPage.mainPage.isDisplayed());
    }
    @Test
    public void mainLinksTest(){
        demoqaPage.elements.click();
        SoftAssert asserttion1 = new SoftAssert();
        asserttion1.assertTrue(demoqaPage.elementPageHeader.getText().equals("Elements"));
        Driver.getDriver().navigate().back();
        demoqaPage.forms.click();
        asserttion1.assertTrue(demoqaPage.elementPageHeader.getText().equals("Forms"));
        Driver.getDriver().navigate().back();
        demoqaPage.alersFrameAndWindows.click();
        asserttion1.assertTrue(demoqaPage.elementPageHeader.getText().equals("Alerts, Frame & Windows"));
        Driver.getDriver().navigate().back();
        demoqaPage.widgets.click();
        asserttion1.assertTrue(demoqaPage.elementPageHeader.getText().equals("Widgets"));
        Driver.getDriver().navigate().back();
        demoqaPage.interactions.click();
        asserttion1.assertTrue(demoqaPage.elementPageHeader.getText().equals("Interactions"));
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        demoqaPage.bookStoreAplication.click();
        asserttion1.assertTrue(demoqaPage.elementPageHeader.getText().equals("Book Store"));
        Driver.getDriver().navigate().back();
        asserttion1.assertAll();
    }
    @Test
    public void positiveElementsTextBoxTest(){
        demoqaPage.elements.click();
        demoqaPage.textBox.click();
        ReusableMethods.waitFor(2);
        demoqaPage.fullnameTextBox.sendKeys(ConfigReader.getProperty("name"));
        demoqaPage.userEmailTextbox.sendKeys(ConfigReader.getProperty("mail"));
        demoqaPage.currentadressTextBox.sendKeys(ConfigReader.getProperty("current_adress"));
        demoqaPage.permanentAdressTextBox.sendKeys(ConfigReader.getProperty("permanent_adress"));
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        demoqaPage.submitButton.click();
        SoftAssert softAssert = new SoftAssert();
        System.out.println(demoqaPage.resultName.getText());
        softAssert.assertTrue(demoqaPage.resultName.getText().contains(ConfigReader.getProperty("name")));
        softAssert.assertTrue(demoqaPage.resultEmail.getText().contains(ConfigReader.getProperty("mail")));
        softAssert.assertTrue(demoqaPage.resultcurrentAddress.getText().contains(ConfigReader.getProperty("current_adress")));
        softAssert.assertTrue(demoqaPage.resultpermanentAddress.getText().contains(ConfigReader.getProperty("permanent_adress")));
        softAssert.assertAll();
    }
    @Test
    public void negativeElementsTextBoxTest(){
        demoqaPage.elements.click();
        demoqaPage.textBox.click();
        ReusableMethods.waitFor(2);
        demoqaPage.fullnameTextBox.sendKeys(ConfigReader.getProperty("name"));
        demoqaPage.userEmailTextbox.sendKeys(ConfigReader.getProperty("mail_wrong"));
        demoqaPage.currentadressTextBox.sendKeys(ConfigReader.getProperty("current_adress"));
        demoqaPage.permanentAdressTextBox.sendKeys(ConfigReader.getProperty("permanent_adress"));
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        demoqaPage.submitButton.click();
        Assert.assertTrue(demoqaPage.userEmailTextboxError.isDisplayed());
    }


}
