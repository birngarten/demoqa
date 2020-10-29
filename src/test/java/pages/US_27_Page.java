package pages;

import freemarker.cache.WebappTemplateLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_27_Page {
    public US_27_Page(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "(//div[@class='card-up'])[5]")
    public WebElement interactionsCard;

    @FindBy(xpath = " //span[.='Droppable']")
    public WebElement droppableLink;

    @FindBy(xpath = "//a[@href='#']")
    public List<WebElement> droppedAllSubLinks;

    @FindBy(id = "draggable")
    public WebElement dragMeBox;

    @FindBy(xpath = "(//div[@id='droppable'])[1]")
    public WebElement droppedBigBox;

    @FindBy(id = "acceptable")
    public WebElement acceptableBox;

    @FindBy(xpath = "//div[@class='drop-box ui-droppable ui-droppable-active ui-active']")
    public  List<WebElement>  droppedBoxColors;

    @FindBy(xpath = "(//div[@id='droppable'])[2]")
    public WebElement acceptDroppedBoxBlue;

    @FindBy(id = "notAcceptable")
    public WebElement notAcceptable;

    @FindBy(id = "dragBox")
    public WebElement preventDragMeBox;

    @FindBy(xpath = "//div[@id='notGreedyDropBox']")
    public  WebElement outDroppeleBixBox;

    @FindBy(xpath = "(//p[.='Outer droppable'])[1]")
    public  WebElement outerDroppableTextBigBox;

    @FindBy(xpath = "//div[@id='notGreedyInnerDropBox']")
    public WebElement innerNotGreedySmallBox;

    @FindBy(xpath = "//p[.='Inner droppable (not greedy)']")
    public WebElement  innnerNotGreedyText;

    @FindBy(id = "revertable")
    public WebElement revertableBox;

    @FindBy(xpath = "(//div[@id='droppable'])[3]")
    public WebElement revertDroppableBox;

    @FindBy(xpath = "//div[.='Not Revert']")
    public WebElement notRevertableBox;



}