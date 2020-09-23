package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_09_Page {
    public US_09_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card-up'])[2]")
    public WebElement formsMenuCard;

    @FindBy(xpath = "//span[.='Practice Form']")
    public WebElement practiceFormMenuLink;

    @FindBy(id = "firstName")
    public  WebElement firstname;

    @FindBy(id = "lastName")
    public  WebElement lastName;

    @FindBy(id = "userEmail")
    public  WebElement userEmail;

    @FindBy(id = "gender-radio-2")
    public  WebElement gender;

    @FindBy(id = "userNumber")
    public  WebElement mobileNumber;

    @FindBy(id = "dateOfBirthInput")
    public  WebElement dateOfBirth;

    @FindBy(id = "subjectsInput")
    public  WebElement subject;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']")
    public  WebElement hobiSpor;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
    public  WebElement hobiReading;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-3']")
    public  WebElement hobiMusic;

    @FindBy(id = "uploadPicture")
    public  WebElement chooseFile;

    @FindBy(id = "currentAddress")
    public WebElement adress;

    @FindBy(id = "react-select-3-input")
    public WebElement state;

    @FindBy(id = "react-select-4-input")
    public WebElement city;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement dropDownAy;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement dropDownYil;

    @FindBy(xpath = "//div[.='23']")
    public WebElement gun;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement basariTexti;


}
