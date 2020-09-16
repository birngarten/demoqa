package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US010Page {
    public US010Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[3]")
    public WebElement alersFrameAndWindows;
    @FindBy(xpath = "//*[.='Browser Windows']")
    public WebElement browserWindows;
    @FindBy(xpath = "(//span[@class='text'])[11]")
    public  WebElement browsersWindow;
    @FindBy(xpath = "(//span[@class='text'])[12]")
    public  WebElement alerts;
    @FindBy(xpath = "(//span[@class='text'])[13]")
    public  WebElement frames;
    @FindBy(xpath = "(//span[@class='text'])[14]")
    public  WebElement nestedFrames;
    @FindBy(xpath = "(//span[@class='text'])[15]")
    public  WebElement modalDialoghs;
    @FindBy(id = "tabButton")
    public WebElement newTabButton;
    @FindBy(id = "windowButton")
    public WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    public WebElement newWindowMessageButton;
    @FindBy(id = "sampleHeading")
    public WebElement newPageText;
    @FindBy (xpath = "//body")
    public WebElement getNewWindowMessageText;
    @FindBy(id = "alertButton")
    public WebElement firstButton;
    @FindBy(id = "timerAlertButton")
    public WebElement secondButton;
    @FindBy(id = "confirmButton")
    public WebElement thirdButton;
    @FindBy(id = "promtButton")
    public WebElement forthButton;
    @FindBy(id = "confirmResult")
    public WebElement getThirdButtonResultText;
    @FindBy(id = "promptResult")
    public WebElement getForthButtonResultText;
}
