package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_26_Page {


    public US_26_Page(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[5]")
    public WebElement interactionsCard;

    @FindBy(xpath = "//span[.='Resizable']")
    public  WebElement resizablePage;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    public WebElement resizableHeaderText;


}
