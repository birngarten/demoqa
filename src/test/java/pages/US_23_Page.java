package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_23_Page {
    public US_23_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetMenuCard;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement selectMenu;

    @FindBy(xpath = "(//li[@id='item-8'])[2]")
    public WebElement selectMenuButton;

    @FindBy(xpath = "//div[@class=' css-1hwfws3']")
    public WebElement selectValueBox;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public List<WebElement> selectValueDropDownOptions;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    public WebElement selectOneBox;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public List<WebElement> selectOneDropDownOptions;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectBox;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    public WebElement multiSelectDropdownBox;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public List<WebElement> multiSelectionDropDownOptions;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public List<WebElement> multiSelectDropdownOptions;

    @FindBy(id = "cars")
    public WebElement standartMultiSelect;

    @FindBy(xpath = "//*[.='Multiselect drop down']")
    public WebElement multiSelectBold;
}

