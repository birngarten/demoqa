package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_16_Page {

    public US_16_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement wigdedsCard;

    @FindBy(xpath = "(//li[@id='item-1'])[3]")
    public WebElement autoCompleteMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement AutoCompleteHeaderText;




}
