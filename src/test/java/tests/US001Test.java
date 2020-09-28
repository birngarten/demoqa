package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US001Test {
    DemoqaPage demoqaPage = new DemoqaPage();
    @BeforeMethod
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @AfterTest
    public void stop (){
        ReusableMethods.waitFor(5);
        Driver.getDriver().close();
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
        Assert.assertTrue(demoqaPage.PageHeader.getText().equals("Text Box"));
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
        //- Full Name, Email, Current Address , Permanent Address, text boxlarina veri
        //girilebilir olmali.

        for(int i =1; i<6; i++){
            demoqaPage.userEmailTextbox.sendKeys(ConfigReader.getProperty("demoqa_email_false"+i));
            ReusableMethods.waitFor(1);
            demoqaPage.submitButton.click();
            Assert.assertTrue(demoqaPage.userEmailTextboxError.isDisplayed());
            ReusableMethods.waitFor(2);
            demoqaPage.userEmailTextbox.clear();
        }
        Assert.assertTrue(demoqaPage.submitButton.isEnabled());
    }
    @Test
    public void tc004(){
            demoqaPage.elementsCard.click();
            demoqaPage.textBox.click();
//            demoqaPage.fullnameTextBox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
//            demoqaPage.submitButton.click();
//            Assert.assertTrue(demoqaPage.afterSubmitTextBox.getText().contains(ConfigReader.getProperty("demoqa_test_data")));
//            demoqaPage.fullnameTextBox.clear();
//            ReusableMethods.waitFor(1);
        List<WebElement>textBoxes = new ArrayList<>();
        textBoxes.add(demoqaPage.fullnameTextBox);
        textBoxes.add(demoqaPage.currentadressTextBox);
        textBoxes.add(demoqaPage.permanentAdressTextBox);

        for (WebElement w:textBoxes) {
            w.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
            demoqaPage.submitButton.click();
            Assert.assertTrue(demoqaPage.afterSubmitTextBox.getText().contains(ConfigReader.getProperty("demoqa_test_data")));
            w.clear();
            ReusableMethods.waitFor(1);
        }
    }
}
