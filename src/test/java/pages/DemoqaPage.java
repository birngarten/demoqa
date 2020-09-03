package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoqaPage {

    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    public WebElement mainPage;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    public WebElement elementsCard;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement elementPageHeader;
    @FindBy(xpath = "//div[@class='header-wrapper']")
    public WebElement elementOpen;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[2]")
    public WebElement forms;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[3]")
    public WebElement alersFrameAndWindows;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgets;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[5]")
    public WebElement interactions;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[6]")
    public WebElement bookStoreAplication;
    @FindBy(id = "item-0")
    public WebElement textBox;
    @FindBy(id = "item-1")
    public WebElement checkBox;
    @FindBy(id = "item-2")
    public WebElement radioButton;
    @FindBy(id = "item-4")
    public WebElement webTables;
    @FindBy(id = "item-5")
    public WebElement buttons;
    @FindBy(id = "item-6")
    public WebElement uploadAndDownload;
    @FindBy(id = "item-7")
    public WebElement dynamicProperties;
    @FindBy(id = "userForm")
    public WebElement textBoxForm;
    @FindBy(id = "userName")
    public WebElement fullnameTextBox;
    @FindBy(id = "userEmail")
    public WebElement userEmailTextbox;
    @FindBy(xpath = "//input[@class='mr-sm-2 field-error form-control']")
    public WebElement userEmailTextboxError;
    @FindBy(id = "currentAddress")
    public WebElement currentadressTextBox;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAdressTextBox;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(xpath = "//p[@id='name']")
    public WebElement resultName;
    @FindBy(xpath = "//p[@id='email']")
    public WebElement resultEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    public WebElement resultcurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    public WebElement resultpermanentAddress;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[1]")
    public WebElement homeCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[2]")
    public WebElement desktopCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[3]")
    public WebElement notesCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[4]")
    public WebElement commandsCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[5]")
    public WebElement documentsCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[6]")
    public WebElement workSpaceCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[7]")
    public WebElement reactCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[8]")
    public WebElement angularCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[9]")
    public WebElement veuCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[10]")
    public WebElement officeCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[11]")
    public WebElement publicCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[12]")
    public WebElement privateCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[13]")
    public WebElement classifiedCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[14]")
    public WebElement generalCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[15]")
    public WebElement downloadsCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[16]")
    public WebElement wordFileCheckbox;
    @FindBy(xpath = "(//span[@class='rct-checkbox'])[17]")
    public WebElement excelFileCheckbox;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[1]")
    public WebElement homeArrow;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[2]")
    public WebElement desktopArrow;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[3]")
    public WebElement documentsArrow;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[4]")
    public WebElement workspaceArrow;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[5]")
    public WebElement officeArrow;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[6]")
    public WebElement downloadsArrow;
    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement successText;
    @FindBy(xpath = "//label[@for='yesRadio']")
    public WebElement radioYes;
    @FindBy(id = "impressiveRadio")
    public WebElement radioImpressive;
    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement checkboxSuccesText;
    // buyrun
    //ojalksna
}