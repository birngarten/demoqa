package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_11_Page {
    public US_11_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//li[@id='item-1'])[2]")
    public WebElement alert;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public List<WebElement> clickMe;//var olan Webelemenleri list icine atiyor

    @FindBy(xpath = "//span[@id='confirmResult']")
    public WebElement textAlert3;

    @FindBy(xpath = "//span[@id='promptResult']")
    public WebElement textAlert4;


}
