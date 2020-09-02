package tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DemoqaElementsCheckbox {
    DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void fullCheckboxTest(){
        demoqaPage.elementsCard.click();
        ReusableMethods.waitFor(1);
        demoqaPage.checkBox.click();
        demoqaPage.homeArrow.click();
        demoqaPage.desktopArrow.click();
        demoqaPage.documentsArrow.click();
        demoqaPage.downloadsArrow.click();
        demoqaPage.workspaceArrow.click();
        demoqaPage.officeArrow.click();
        demoqaPage.homeArrow.click();
        ReusableMethods.waitFor(2);
        demoqaPage.homeArrow.click();
    }



    @Test
    public void checkboxTest(){
        demoqaPage.elementsCard.click();
        ReusableMethods.waitFor(1);
        demoqaPage.checkBox.click();
        SoftAssert softAssert = new SoftAssert();
        demoqaPage.homeArrow.click();
        demoqaPage.homeCheckbox.click();
        softAssert.assertTrue(demoqaPage.successText.getText().contains("home"));
        //softAssert.assertTrue(demoqaPage.successText.getText().contains("desktop"));
        softAssert.assertAll();
    }

}
