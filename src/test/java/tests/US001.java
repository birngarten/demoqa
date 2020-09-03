package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001 {
    DemoqaPage demoqaPage = new DemoqaPage();
    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc001(){
        demoqaPage.elementsCard.click();
        Assert.assertTrue(demoqaPage.textBox.isEnabled());
        ReusableMethods.waitFor(2);
        demoqaPage.elementOpen.click();
    }
    @Test
    public void tc002(){
        demoqaPage.elementsCard.click();
        demoqaPage.textBox.click();
        Assert.assertTrue(demoqaPage.elementPageHeader.getText().equals("Text Box"));
    }
    @Test
    public void tc003(){
        demoqaPage.elementsCard.click();
        Assert.assertTrue(demoqaPage.textBox.isEnabled());
        demoqaPage.textBox.click();
        System.out.println(demoqaPage.textBoxForm.getText());
        String arr[]= {"Full Name", "Email", "Current Address" ,  "Permanent Address", "Submit"};
        for (String w:arr) {
            Assert.assertTrue(demoqaPage.textBoxForm.getText().contains(w));
        }
    }
}
