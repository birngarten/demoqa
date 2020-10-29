package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_24_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_24_Test extends TestBase {

    US_24_Page us24Page = new US_24_Page();

    @Test
    public void TC_147() {
        us24Page.widgetsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us24Page.sortableMenuMenuLink)).click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();


        String numbers []= {"One","Two","Three","Four","Five","Six"};

        int j = 0;
        for(int i = 5; i>0; i--) {
            ReusableMethods.waitFor(2);
            actions.clickAndHold(us24Page.allNumbers.get(5)).
                    moveToElement(us24Page.allNumbers.get(j)).
                    release().build().perform();
            Assert.assertEquals(us24Page.allNumbers.get(j).getText(),numbers[i]);
            System.out.println(us24Page.allNumbers.get(j).getText());
            j++;

        }

    }
}
