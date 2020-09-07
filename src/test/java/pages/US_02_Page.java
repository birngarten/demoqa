package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_02_Page {

    public US_02_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="item-1")
    public WebElement checkboxMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement checkBoxHeader;

    @FindBy(xpath = "//button[@title='Expand all']")
    public WebElement expandAllButton;

    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement succesText;

    @FindBy(xpath = "//span[@class='text-success']")
    public List<WebElement> allSuccesText;

}
