package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class US013Page {
    public US013Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement alertsFrameWinwowsCard;
    @FindBy(xpath = "//*[.='Nested Frames']")
    public WebElement nestedFrameLink;
    @FindBy(xpath = "//p")
    public WebElement chilFrameText;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;
    @FindBy(id = "framesWrapper")
    public WebElement mainPageText;


}
