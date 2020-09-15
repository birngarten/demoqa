package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FormsPage {
    public FormsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card-up'])[2]")
    public WebElement FormsCard;
    @FindBy(xpath = "//div[@class='element-list collapse show']")
    public WebElement practiceForm;
    @FindBy(xpath = "//form[@class='was-validated']")
    public WebElement errorElement;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(xpath = "//label[@class='custom-control-label']")
    public WebElement maleButton;
    @FindBy(id = "gender-radio-2")
    public WebElement femaleButton;
    @FindBy(id = "userNumber")
    public WebElement userTelefonNUmber;
    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement succesTitle;
    @FindBy(id = "userEmail")
    public WebElement userEmailBox;
    @FindBy(xpath = "(//label[@class='custom-control-label'])[4]")
    public WebElement sportsCheckBox;
    @FindBy(id = "uploadPicture")
    public WebElement uploadFile;
    @FindBy (id = "currentAddress")
    public WebElement currentAdressTextBox;
    @FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder']")
    public WebElement stateDropbox;
    @FindBy(id ="react-select-3-input")
    public WebElement stateInformationPlace;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    public WebElement cityDropbox;
    @FindBy(id = "react-select-4-input")
    public WebElement cityInformationPlace;
}
