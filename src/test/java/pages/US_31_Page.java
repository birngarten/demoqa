package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_31_Page {

    public US_31_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[6]")
    public WebElement bookStoreAppMenuCard;

    @FindBy(xpath = "//span[.='Profile']")
    public WebElement profiloMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement profileHeaderText;

    @FindBy(xpath = "//a[@style='font-weight: bold;']")
    public WebElement loginLink;

    @FindBy(xpath = "(//a[@style='font-weight: bold;'])[2]")
    public WebElement registerLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement registerHeaderText;

    @FindBy(xpath = "//label[@class='form-label']")
    public List<WebElement> registerBookStoreList;
//
    @FindBy(xpath = "//input[@class='mr-sm-2 form-control']")
    public List<WebElement> registerBookStoreBoxes;

    @FindBy(id = "register")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control']")
    public WebElement kayitOlmadi;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement reCaptchaChek;

    @FindBy(id = "gotologin")
    public WebElement backLoginButon;


}
