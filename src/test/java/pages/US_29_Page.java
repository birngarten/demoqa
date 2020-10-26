package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_29_Page {
    public US_29_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[6]")
    public WebElement bookStoreApplicationCard;

    @FindBy(xpath = "//span[.='Login']")
    public WebElement loginMenuLink;

    @FindBy(xpath = "//div[.='Book Store Application']")
    public WebElement bookStoreApplicationMenuLink;

    @FindBy(xpath = "(//ul[@class='menu-list'])[6]/li")
    public List <WebElement> bookStoreApplicationMenuElements;

    @FindBy(xpath = "//h2")
    public WebElement welcomeText;

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//button[.='Log out']")
    public WebElement logoutButton;









}
