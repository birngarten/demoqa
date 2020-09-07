package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_03_Page {

    public US_03_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="item-2")
    public WebElement radioButtonMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement radioButtonHeader;

    @FindBy(id="yesRadio")
    public WebElement yesRadioButton;

    @FindBy(id="impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy(id="noRadio")
    public WebElement noRadioButton;

    public List<WebElement> allRadioButton() {
        List<WebElement> allRButton = new ArrayList<>();
        allRButton.add(yesRadioButton);
        allRButton.add(impressiveRadioButton);
        return allRButton;
    }

    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement succesText;

}