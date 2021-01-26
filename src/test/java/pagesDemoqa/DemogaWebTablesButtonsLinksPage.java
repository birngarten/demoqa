package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class DemogaWebTablesButtonsLinksPage {
    public DemogaWebTablesButtonsLinksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    public WebElement mainPage;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    public WebElement elementsCard;
    @FindBy(id = "item-3")
    public WebElement webTables;
    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;
    @FindBy(id = "firstName")
    public WebElement firstNameTextbox;
    @FindBy(id = "lastName")
    public WebElement lastNameTextbox;
    @FindBy(id = "userEmail")
    public WebElement emailTextbox;
    @FindBy(id = "age")
    public WebElement ageTextbox;
    @FindBy(id = "salary")
    public WebElement salaryTextbox;
    @FindBy(id = "department")
    public WebElement departmentTextbox;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "searchBox")
    public WebElement searchBox;
    @FindBy(xpath = "//div[@class='rt-tr -odd']")
    public WebElement resultText;
    @FindBy(xpath = "//input[@value='']")
    public WebElement emptyBox;
    @FindBy(id = "edit-record-1")
    public WebElement editButtonPencil;
    @FindBy(id = "delete-record-2")
    public WebElement deleteSecondData;
    @FindBy(xpath = "(//div[@class='rt-tr-group'])[2]")
    public WebElement secondData;
    @FindBy(id = "item-4")
    public WebElement buttons;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pagePageHeader;
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;
    @FindBy (id = "rightClickBtn")
    public WebElement rightClickButton;
    @FindBy (xpath = "(//button[@class='btn btn-primary'])[3]")
    public WebElement clickMeButton;

    public List<WebElement> buttonsReturn (){
        List<WebElement> buttons = new ArrayList<>();
        buttons.add(doubleClickButton);
        buttons.add(rightClickButton);
        buttons.add(clickMeButton);
        return buttons;
    }
    @FindBy (id = "doubleClickMessage")
    public WebElement doubleClickMessage;
    @FindBy (id = "rightClickMessage")
    public WebElement rightClickMessage;
    @FindBy (id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;
    @FindBy(id = "item-5")
    public WebElement links;
    @FindBy(id = "simpleLink")
    public WebElement simpleLink;
    @FindBy(id = "moved")
    public WebElement modevLink;
    @FindBy(xpath = "(//b)[1]")
    public WebElement statusCode;



}
