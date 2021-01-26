package pagesDemoqa;

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
    @FindBy(xpath = "(//div[@id='droppable'])[1]")
    public WebElement dropableFrist;
    @FindBy(xpath = "(//div[@class='drop-box ui-droppable'])[2]")
    public WebElement droppable;
    @FindBy(id = "acceptable")
    public WebElement acceptableBox;
    @FindBy(xpath = "(//div[@id='droppable'])[2]")
    public WebElement dropableAfterDrop;
    @FindBy(xpath = "(//p)[2]")
    public WebElement droppedText;
    @FindBy(xpath = "//div[@id='notAcceptable']")
    public WebElement notAccetableBox;
    //
    @FindBy(id = "dragBox")
    public WebElement dragBoxThree;
    @FindBy(xpath = "(//p)[3]")
    public WebElement droppedTextThree;
    @FindBy(id = "notGreedyDropBox")
    public WebElement bigUpperBox;
    @FindBy(id = "notGreedyInnerDropBox")
    public WebElement smallUpperBox;
    //
    @FindBy(id = "revertable")
    public WebElement revertableBox;
    @FindBy(id = "notRevertable")
    public WebElement notRevertableBox;
    @FindBy(xpath = "(//div[@id='droppable'])[3]")
    public WebElement dropArea;
}
