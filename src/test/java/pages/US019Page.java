package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class US019Page {
    public US019Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(id = "startStopButton")
    public WebElement startStopButton;
    @FindBy(xpath = "//div[@class='progress-bar bg-info']")
    public WebElement progressBarPercent;
    @FindBy(xpath = "//div[@class='progress-bar bg-success']")
    public WebElement progressBar;
    @FindBy(id = "resetButton")
    public WebElement resetButton;
}
