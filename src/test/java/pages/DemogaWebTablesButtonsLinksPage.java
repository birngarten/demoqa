package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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




}
