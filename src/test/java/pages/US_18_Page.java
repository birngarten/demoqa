package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_18_Page {
    public US_18_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement wigdedsCard;

    @FindBy(xpath = "//*[@id=\"item-3\"]/span")
    public WebElement slider;
    



}
