package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_19_Page {
    public US_19_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgetsCard;

    @FindBy(xpath = "//*[.='Progress Bar']")
    public WebElement progressBarLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement headerProgressBar;

    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(xpath = "//div[@aria-valuenow='50']")
    public WebElement fiftyPercentProgress;

    @FindBy(xpath = "//*[.='Stop']")
    public WebElement stopButton;

    @FindBy(xpath = "//div[@class='progress-bar bg-info']")
    public WebElement infoProgressBar;

    @FindBy(id ="resetButton")
    public WebElement resetButton;

    @FindBy(xpath = "//div[@class='progress-bar bg-success']")
    public WebElement successProgressBar;


}
