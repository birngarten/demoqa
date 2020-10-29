package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_24_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;


public class US_24_Test extends TestBase {
    US_24_Page us24Page = new US_24_Page();
    SoftAssert soft = new SoftAssert();


    @BeforeMethod
    public void interactionsMenu() {
        wait.until(ExpectedConditions.visibilityOf(us24Page.interactionsMenucard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us24Page.sortableMenuButton.click();

    }

    @Test
    public void TC_135() {
        // Sortable menu linkinin tiklanabilir oldugunu kontrol ediniz

        soft.assertTrue(us24Page.sortableMenuButton.isEnabled());
        soft.assertAll();

    }

    @Test
    public void TC_136() {
        // Sortable texti altinda List ve Grid
        // menusunun  goruntulenebilir oldugunu dogrulayiniz
        soft.assertTrue(us24Page.gridBox.isDisplayed());
        soft.assertTrue(us24Page.listBox.isDisplayed());
        soft.assertAll();

    }

    @Test
    public void TC_137() {
        // List menusu altinda  "One","Two","Three","Four","Five","Six"
        // kutucuklarinin verilen siralamaya uygun oldugunu test ediniz

        int one = us24Page.oneBox.getLocation().y;
        int two = us24Page.twoBox.getLocation().y;
        int three = us24Page.threeBox.getLocation().y;
        int four = us24Page.fourBox.getLocation().y;
        int five = us24Page.fiveBox.getLocation().y;
        int six = us24Page.sixBox.getLocation().y;

        boolean sira = false;
        if (one < two && two < three && three < four && four < five && five < six) {
            sira = true;
        }
        Assert.assertTrue(sira);

    }

    @Test
    public void TC_138() {
        // "One" isimli kutucugu sirayla
        // her sayinin altina suruklenebildigini kontrol ediniz;
        ReusableMethods.waitFor(2);

        actions.moveToElement(us24Page.oneBox).clickAndHold().moveToElement(us24Page.twoBox).build().perform();
        actions.moveToElement(us24Page.oneBox).clickAndHold().moveToElement(us24Page.threeBox).build().perform();
        actions.dragAndDrop(us24Page.oneBox, us24Page.fourBox).build().perform();
        actions.dragAndDrop(us24Page.oneBox, us24Page.fiveBox).build().perform();
        actions.dragAndDrop(us24Page.oneBox, us24Page.sixBox).build().perform();

        /* ##########Samet Abi For Each ile ###########

        us024Page.sortableLink.click();
        for(int i=1;i<6;i++){
        actions.clickAndHold(us024Page.numbers.get(0)).perform();
        actions.moveToElement(us024Page.numbers.get(i)).perform();
        //actions.release(us024Page.numbers.get(0)).perform();
        ReusableMethods.waitFor(1);
        }
        actions.release().perform();
        Assert.assertEquals(us024Page.numbers.get(5).getText(),"One");
         */
    }

    @Test
    public void TC_139() {
        // "One","Two","Three","Four","Five","Six" surukleyerek "Six","Five",
        // "Four","Three","Two","One" olabildigini Assert ediniz
        ReusableMethods.waitFor(2);

        ReusableMethods.waitFor(2);
        actions.dragAndDrop(us24Page.sixBox, us24Page.oneBox).build().perform();
        actions.dragAndDrop(us24Page.fiveBox, us24Page.oneBox).build().perform();
        actions.dragAndDrop(us24Page.fourBox, us24Page.oneBox).build().perform();
        actions.dragAndDrop(us24Page.threeBox, us24Page.oneBox).build().perform();
        actions.moveToElement(us24Page.twoBox).clickAndHold().moveToElement(us24Page.oneBox).build().perform();
        // actions.dragAndDrop(us24Page.twoBox, us24Page.oneBox).build().perform();

        int six = us24Page.sixBox.getLocation().y;
        int five = us24Page.fiveBox.getLocation().y;
        System.out.println(six);//302
        System.out.println(five);//352

        boolean buyuktenKucugeSiralama = false;
        if (six < five) {
            buyuktenKucugeSiralama = true;
        }
        soft.assertTrue(buyuktenKucugeSiralama);
        soft.assertAll();


        /* #########Özkan Abi nin kolay kodu ##########

        String numbers []= {"One","Two","Three","Four","Five","Six"};
        int j = 0;
        for(int i = 5; i>0; i--) {
        ReusableMethods.waitFor(2);
        actions.clickAndHold(us24Page.allNumbers.get(5)).
        moveToElement(us24Page.allNumbers.get(j)).
        release().build().perform();
        Assert.assertEquals(us24Page.allNumbers.get(j).getText(),numbers[i]);
        j++;
        }
        }*/

    }

    @Test
    public void TC_140() {
        // Grid menusu altindaki butun kutucuklari sirayla en sag ve
        // alt satira suruklendigini assert ediniz
        ReusableMethods.waitFor(2);
        us24Page.gridBox.click();

        actions.dragAndDrop(us24Page.oneBoxGrid, us24Page.threeBoxGrid).build().perform();
        actions.dragAndDrop(us24Page.fourBoxGrid, us24Page.sixBoxGrid).build().perform();

        ReusableMethods.waitFor(2);

        actions.dragAndDrop(us24Page.sevenBoxGrid, us24Page.nineBoxGrid).build().perform();
        ReusableMethods.waitFor(1);
        actions.dragAndDrop(us24Page.oneBoxGrid, us24Page.sevenBoxGrid).build().perform();
        actions.dragAndDrop(us24Page.twoBoxGrid, us24Page.eightBoxGrid).build().perform();
        actions.dragAndDrop(us24Page.threeBoxGrid, us24Page.nineBoxGrid).build().perform();

        /*####### Samet Abi daha iyi cözüm #############
        @Test
        public void tc140(){
        //Grid menusu altindaki butun kutucuklari sirayla en sag ve alt satira suruklendigini assert ediniz
        us024Page.sortableLink.click();
        us024Page.gridLink.click();
        String [] myTestData = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        for(int i=0;i<9;i++) {
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us024Page.numbers.get(6)).perform();
        actions.moveToElement(us024Page.numbers.get(14)).perform();
        actions.release().perform();
        Assert.assertEquals(us024Page.numbers.get(14).getText(), myTestData[i]);
        }
        }
         */
    }

    @Test
    public void TC_141() {
        // Grid menusu altindaki butun kutucuklarin sol en ust kisima
        // suruklenebildigini assert ediniz

        us24Page.gridBox.click();
        actions.dragAndDrop(us24Page.nineBoxGrid, us24Page.oneBoxGrid).build().perform();
        ReusableMethods.waitFor(1);
        actions.dragAndDrop(us24Page.eightBoxGrid, us24Page.nineBoxGrid).build().perform();
        ReusableMethods.waitFor(1);
        actions.dragAndDrop(us24Page.fiveBoxGrid, us24Page.eightBoxGrid).build().perform();// en son One'in yerine Five olcak


        /* ################Samet Abi Daha guzel cözüm##################
        @Test
        public void tc141(){
        //Grid menusu altindaki butun kutucuklarin sol en ust kisima suruklenebildigini assert ediniz
        us024Page.sortableLink.click();
        us024Page.gridLink.click();
        String [] myTestData = {"Nine","Eight","Seven","Six","Five","Four","Three","Two","One"};
        for(int i=0;i<9;i++) {
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us024Page.numbers.get(14)).perform();
        actions.moveToElement(us024Page.numbers.get(6)).perform();
        actions.release().perform();
        Assert.assertEquals(us024Page.numbers.get(6).getText(), myTestData[i]);
        }
         */

    }

}
