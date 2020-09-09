package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_05_Page {
    public US_05_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "item-4")
    public WebElement buttonsMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement buttonsHeaderText;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(xpath = "//button[.='Click Me']")
    public  WebElement clickMeButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;



}
