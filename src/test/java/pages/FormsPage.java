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



}
