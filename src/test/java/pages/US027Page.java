package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US027Page {
    public US027Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Droppable']")
    public WebElement dropableLink;
    @FindBy(xpath = "//a[@href='#']")
    public List<WebElement> mainLİnks;
    @FindBy(id = "draggable")
    public WebElement draggable;
    @FindBy(id = "droppable")
    public WebElement droppable;
    @FindBy(id = "acceptable")
    public WebElement acceptableBox;
}
