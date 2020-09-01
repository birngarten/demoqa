package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoqaPage {

    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy(xpath = "(//span[@class='pr-1'])[1]")
    public WebElement elementsMenu;

    @FindBy(xpath = "//span[.='Text Box']")
    public WebElement textBoxMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement textBoxHeader;

    @FindBy(id = "userForm")
    public WebElement userForm;







}



