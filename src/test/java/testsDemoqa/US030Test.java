package testsDemoqa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US030Page;
import utilities.Driver;
import utilities.TestBase;

public class US030Test extends TestBase {
    US030Page us030Page = new US030Page();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void setUp (){
        Driver.getDriver().get("https://demoqa.com/books");
    }
    @Test
    public void tc176(){
        //Book Store ifadesi Baslik olarak gorunmeli ve "Type to serach" ve  Login alanlari gorunur ve aktif olmali
        Assert.assertEquals(us030Page.pageHeader.getText(), "Book Store");
        Assert.assertTrue(us030Page.loginButton.isEnabled());
        Assert.assertTrue(us030Page.searchBox.isEnabled());
    }
    @Test
    public void tc177(){
        //Arama alaninin altinda sirasiyla " Image, Title,Author ve Publisher " sekmeleri gorunmeli ve aktif olmali
        String [] myTestData = {"Image", "Title","Author" , "Publisher"};
        int i=0;
        for (WebElement w :us030Page.columnHeader) {
            Assert.assertEquals(w.getText(),myTestData[i]);
            Assert.assertTrue(w.isEnabled());
            i++;
        }
    }
    @Test
    public void tc178(){
        //Liste de kitap ismi ,yazar ismi  ve yayinci ismi  search girince  ilgili sonuclar dogru olarak gorunmeli
        // ya teker teker yada hepsini bir anda girerek test edebilirsiniz

        for(int i=1;i<us030Page.allData.size();i++){
            if(i%4==0){
                i++;
            }
            us030Page.searchBox.sendKeys(us030Page.allData.get(i).getText());
            us030Page.searchButton.click();
            Assert.assertTrue(us030Page.firstBook.getText().contains(us030Page.allData.get(i).getText()));
            Driver.getDriver().navigate().refresh();
        }
        System.out.println(us030Page.allData.size());
    }
    @Test
    public void tc179(){
        //row gorunur sayisi bir sayfada  100 e kadar arttirilabilir olsun ve bunu assert edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select options = new Select(us030Page.pagePerPageDropbox);
        options.selectByIndex(5);
        Assert.assertEquals(options.getOptions().get(5).getText(),"100 rows");
    }
    @Test
    public void tc180(){
        us030Page.firstBooksLink.click();
    }
    @Test
    public void tc181(){
        //"Back to BookStore  butunun  assert ediniz  tiklanir olup olmadigini ve istenilen yere gelip gelmedigini
        us030Page.firstBooksLink.click();
        Assert.assertTrue(us030Page.backToBookStore.isEnabled());
        us030Page.backToBookStore.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://demoqa.com/books");
    }
    @Test
    public void tc182(){
        //Book Store  da ki Login butununun sayfa da gorunurlugunu ve islevselligini  test ediniz
        us030Page.firstBooksLink.click();
        Assert.assertTrue(us030Page.loginButton.isEnabled());
    }
}
