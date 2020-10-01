package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
<<<<<<< HEAD

public class US_16_Page {
=======
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.util.List;

public class US_16_Page {
    public Component datePicker;
    public DataFlavor dateZone;
>>>>>>> master

    public US_16_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

<<<<<<< HEAD
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement wigdedsCard;

    @FindBy(xpath = "(//li[@id='item-1'])[3]")
    public WebElement autoCompleteMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement AutoCompleteHeaderText;




}
=======
    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement wigdedsCard;


    @FindBy(id = "//*[@id=\"app\"]/div/div/div[1]/div")
    public WebElement baslik;

    @FindBy(id = "autoCompleteMultiple")
    public List<WebElement> MultipleColorName;

    @FindBy(id = "autoCompleteMultipleInput")
    public WebElement renklermulti;

    @FindBy(xpath = "(//span[@class='text'])[17]") //constractor
    public WebElement autoCompleteLink;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    public WebElement pageTitle;

    @FindBy(id = "autoCompleteSingleInput")
    public WebElement singleBoxColor;

}
>>>>>>> master
