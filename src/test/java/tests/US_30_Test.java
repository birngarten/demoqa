package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_30_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class US_30_Test extends TestBase {

    US_30_Page us30Page = new US_30_Page();
    List<String> allWindowsHandles;

    @BeforeMethod
    public void setUs29Page() {
        wait.until(ExpectedConditions.elementToBeClickable(us30Page.bookStoreApplicationCard)).click();
        // actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    @Test
    public void TC_176() {
        // Book Store ifadesi Baslik olarak gorunmeli ve "Type to serach" ve  Login alanlari gorunur ve aktif olmali
        Assert.assertTrue(us30Page.bookStoreText.isDisplayed() && us30Page.searchBox.isDisplayed() && us30Page.loginButton.isDisplayed());
        Assert.assertTrue(us30Page.bookStoreText.isEnabled() && us30Page.searchBox.isEnabled() && us30Page.loginButton.isEnabled());

    }

    @Test
    public void TC_177() {
        // Arama alaninin altinda sirasiyla " Image, Title,Author ve Publisher " sekmeleri gorunmeli ve aktif olmali
        String[] firstRowElements = {"Image", "Title", "Author", "Publisher"};
        int i = 0;
        for (WebElement w : us30Page.firstRowElementList) {
            Assert.assertEquals(w.getText(), firstRowElements[i]);
            Assert.assertTrue(w.isEnabled());
            i++;
        }

    }

    @Test
    public void TC_178() {
        // Liste de kitap ismi ,yazar ismi  ve yayinci ismi  search girince  ilgili sonuclar dogru olarak gorunmeli
        // ya teker teker yada hepsini bir anda girerek test edebilirsiniz
        System.out.println(us30Page.allData.size());

        // Kitap isimleri ile arama
        for (int i = 1; i < 30; i = i + 4) {
            String bookName = us30Page.allData.get(i).getText();
            System.out.println(bookName);
            us30Page.searchBox.sendKeys(bookName);
            Assert.assertEquals(us30Page.bookNameSearchResult.getText(), bookName);
            Driver.getDriver().navigate().refresh();
        }

        // Yazar isimleri ile arama
        for (int i = 2; i < 31; i = i + 4) {
            String autorName = us30Page.allData.get(i).getText();
            System.out.println(autorName);
            us30Page.searchBox.sendKeys(autorName);
            Assert.assertEquals(us30Page.autorNameSearchResult.getText(), autorName);
            Driver.getDriver().navigate().refresh();
        }

        // Yayievi ile arama
        for (int i = 3; i < 32; i = i + 4) {
            String publisherName = us30Page.allData.get(i).getText();
            System.out.println(publisherName);
            us30Page.searchBox.sendKeys(publisherName);
            Assert.assertEquals(us30Page.publisherNameSearchResult.getText(), publisherName);
            Driver.getDriver().navigate().refresh();
        }

        // Samet beyin cozumu
        // Tek seferde Bir satirdaki tum verileri sirasiyla gonderme yontemi
        // Kitap ismi -  Yazar ismi - Yayinci seklinde gonderim yapiyor

//        for(int i=1;i<us30Page.allData.size();i++){
//            if(i%4==0){
//                i++;
//            }
//            us30Page.searchBox.sendKeys(us30Page.allData.get(i).getText());
//            us30Page.searchButton.click();
//            Assert.assertTrue(us30Page.firstBook.getText().contains(us30Page.allData.get(i).getText()));
//            Driver.getDriver().navigate().refresh();
//        }


    }

    @Test
    public void TC_179() {
        // row gorunur sayisi bir sayfada  100 e kadar arttirilabilir olsun ve bunu assert edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select options = new Select(us30Page.rowSelectMenu);
        options.selectByValue("100");

        int rowCount = us30Page.allRowsList.size();
        Assert.assertEquals(rowCount, 100);

    }

    @Test
    public void TC_180() {
        // "ISBN :   //9781449325862   //Title :   //Git Pocket Guide   //Sub Title :   //A Working Introduction
        //Author :  //Richard E. Silverman  //Publisher :  //O'Reilly Media  //Total Pages :  //234  //Description :
        //This pocket guide is the perfect on-the-job companion to Git, the distributed version control system.
        // It provides a compact, readable introduction to Git for new users, as well as a reference to common
        // commands and procedures for those of you with Git exp"
        // seklinde  kitap ile ilgili detayli veriler gorulebilir olsun bunu assert ediniz  ve
        // iligli kitabin  linkinin  calisip calismadigini bir sonraki web tab da test ediniz .

        wait.until(ExpectedConditions.elementToBeClickable(us30Page.firstBookName)).click();

        int i = 0;
        for (WebElement w : us30Page.bookLabelsList) {
            Assert.assertTrue(w.isDisplayed());
            Assert.assertTrue(us30Page.bookDatasList.get(i++).isDisplayed());
            System.out.println(w.getText());
        }
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        wait.until(ExpectedConditions.elementToBeClickable(us30Page.bookWebsiteLink2));
        us30Page.bookWebsiteLink2.click();

        allWindowsHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(allWindowsHandles.get(1));
        System.out.println(allWindowsHandles);

        String newTabTitle = Driver.getDriver().getTitle();
        Assert.assertNotEquals(newTabTitle,"ToolsQA");

    }

    @Test
    public void TC_181() {
        // "Back to BookStore  butunun  assert ediniz  tiklanir olup olmadigini ve istenilen yere gelip gelmedigini

        wait.until(ExpectedConditions.elementToBeClickable(us30Page.firstBookName));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",us30Page.firstBookName);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(us30Page.backToBookStoreButton.isEnabled());

        wait.until(ExpectedConditions.elementToBeClickable(us30Page.backToBookStoreButton)).click();
        Assert.assertTrue(us30Page.searchBox.isDisplayed());

    }

    @Test
    public void TC_182() {
        // Book Store  da ki Login butununun sayfa da gorunurlugunu ve islevselligini  test ediniz
        Assert.assertTrue(us30Page.loginButton.isDisplayed() && us30Page.loginButton.isEnabled() );

    }


}
