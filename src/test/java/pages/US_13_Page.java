package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_13_Page {

    public US_13_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[3]")
    public WebElement alertsCard;
    @FindBy(xpath = "//*[.='Nested Frames']")
    public WebElement nestedMenuLink;
    @FindBy(xpath = "//iframe")
    public List<WebElement> iframeList;
    @FindBy(xpath = "//p")
    public WebElement childFrameText;
    //    @FindBy(id = "frame1")
//    public WebElement parentFrameText;
    @FindBy(xpath = "//body[.='Parent frame']")
    public WebElement parentIframeText;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;
    @FindBy(id = "framesWrapper")
    public WebElement MainText;
}

