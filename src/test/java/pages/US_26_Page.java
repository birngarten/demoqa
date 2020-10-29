package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_26_Page {


    public US_26_Page(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[5]")
    public WebElement interactionsCard;

    @FindBy(xpath = "//span[.='Resizable']")
    public  WebElement resizablePage;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    public WebElement resizableHeaderText;

    @FindBy(xpath = "//div[@class='constraint-area']")
    public WebElement firstStabilBox;

    @FindBy(xpath = "//div[@id='resizable']")
    public WebElement secondUnstabilBox;

    @FindBy(xpath = "//span[@class='react-resizable-handle react-resizable-handle-se']")
    public List<WebElement> catchPoint;

    @FindBy(xpath = "//div[@style='width: 200px; height: 200px;']")
    public List<WebElement>  resizeableBoxes;

    @FindBy(xpath = "(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]")
    public WebElement ilkTutmaNoktasi;

    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']")
    public WebElement ilkResizableKutu;


}
