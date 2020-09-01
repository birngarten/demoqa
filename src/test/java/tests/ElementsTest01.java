package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ReusableMethods;
import utilities.TestBase;

public class ElementsTest01 extends TestBase {

    @Test
    public void textbox01() {
        demoqaPage.elementsCard.click();
        demoqaPage.elementsMenu.click();
        ReusableMethods.waitFor(2);
        Assert.assertFalse(demoqaPage.textBoxMenuLink.isDisplayed());
        demoqaPage.elementsMenu.click();
        demoqaPage.textBoxMenuLink.click();
        Assert.assertTrue(demoqaPage.textBoxHeader.isDisplayed());
        String actualUserForm = demoqaPage.userForm.getText();
        System.out.println(actualUserForm);

        String [] expectedUserForm = {"Full Name", "Email", "Current Address" ,
                "Permanent Address","Submit"};

        for(String w : expectedUserForm) {
            Assert.assertTrue(actualUserForm.contains(w));
        }

        // buraya conflict olusturuyorum.
    }

}
