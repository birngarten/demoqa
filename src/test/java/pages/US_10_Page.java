package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_10_Page {
    public US_10_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[3]")
    public WebElement alertsFrameWindowsCard;

    @FindBy(xpath = "(//li[@id='item-0'])[3]")
    public WebElement browserWindows;

    @FindBy(id = "tabButton")
    public WebElement newTabButton;
    @FindBy(id = "windowButtonWrapper")
    public WebElement newWindowButton;
    @FindBy(id = "msgWindowButtonWrapper")
    public WebElement newMsgButton;

    @FindBy(id = "sampleHeading")
    public WebElement thisISaSamplePage;

    @FindBy(xpath = "//h1")
    public WebElement thisISaSamplePage2;


}
