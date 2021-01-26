package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US029Page {
    public US029Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[.='Book Store Application']")
    public WebElement bookStoreApplicationLink;
    @FindBy(xpath = "//li[.='Login']")
    public WebElement login;
    @FindBy(xpath = "//li[.='Book Store']")
    public WebElement bookStore;
    @FindBy(xpath = "//li[.='Profile']")
    public WebElement profile;
    @FindBy(xpath = "//li[.='Book Store API']")
    public WebElement bookStoreApi;
    @FindBy(xpath = "//h2")
    public WebElement welcomeText;
    @FindBy(xpath = "//h5")
    public WebElement loginBookStoreText;
}
