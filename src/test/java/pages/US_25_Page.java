package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_25_Page {

    public US_25_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[5]")
    public WebElement interactionsCard;

    @FindBy(xpath = "//span[.='Selectable']")
    public WebElement selectableLink;

    @FindBy(xpath = "(//div[.='Interactions'])[1]")
    public WebElement interactionHeadText;

    @FindBy(xpath = "//a[@href='#']")
    public List<WebElement> listAndGridButtons;

    @FindBy(xpath = "//li[@class='mt-2 list-group-item active list-group-item-action']")
    public List<WebElement> listTabOfTextes;



}
