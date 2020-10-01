package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US024Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US024Test {
    US024Page us024Page = new US024Page();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get("https://demoqa.com/interaction");
    }
    @Test
    public void tc135(){
        //-Sortable menu linki tiklanabilir oldugunu kontrol ediniz
        Assert.assertTrue(us024Page.sortableLink.isEnabled());
    }
    @Test
    public void tc136(){
        //-Sortable texti altinda List ve Grid menusunun  goruntulenebilir oldugunu dogrulayiniz
        us024Page.sortableLink.click();
        Assert.assertTrue(us024Page.listLink.isDisplayed());
        Assert.assertTrue(us024Page.gridLink.isDisplayed());
    }
    @Test
    public void tc137(){
        us024Page.sortableLink.click();
        //List menusu altinda  "One","Two","Three","Four","Five","Six" kutucuklarinin
        // verilen siralamaya uygun oldugunu test ediniz
        String [] myTestData = {"One","Two","Three","Four","Five","Six"};
        for (int i=0;i<myTestData.length;i++){
            Assert.assertEquals(myTestData[i],us024Page.numbers.get(i).getText());
        }
    }
    @Test
    public void tc138(){
        //"One" isimli kutucugu sirayla her sayinin altina suruklenebildigini kontrol ediniz
        us024Page.sortableLink.click();
        for(int i=1;i<6;i++){
            actions.clickAndHold(us024Page.numbers.get(0)).perform();
            actions.moveToElement(us024Page.numbers.get(i)).perform();
            //actions.release(us024Page.numbers.get(0)).perform();
            ReusableMethods.waitFor(1);
        }
        actions.release().perform();
        Assert.assertEquals(us024Page.numbers.get(5).getText(),"One");

    }
    @Test
    public void tc139(){
        //"One","Two","Three","Four","Five","Six" surukleyerek
        //  "Six","Five","Four","Three","Two","One" olabildigini Assert ediniz
        String [] myTestData = {"Six","Five","Four","Three","Two","One"};
        us024Page.sortableLink.click();
        for(int i=0;i<6;i++){
            for(int j=5;j>-1;j--){
            actions.clickAndHold(us024Page.numbers.get(i)).perform();
            actions.moveToElement(us024Page.numbers.get(j)).perform();
            //actions.release(us024Page.numbers.get(0)).perform();
            ReusableMethods.waitFor(1);
            actions.release().perform();
        }
            if(us024Page.numbers.get(0).getText().equals("Six")){
                break;
            }
    }
        for(int i=0;i<6;i++){
            Assert.assertEquals(us024Page.numbers.get(i).getText(),myTestData[i]);
        }
    }
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
    }
}
