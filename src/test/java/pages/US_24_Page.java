package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_24_Page {
    public US_24_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[5]")
    public WebElement widgetsCard;

    @FindBy(xpath = "//*[.='Sortable']")
    public WebElement sortableMenuMenuLink;

    @FindBy(xpath = "//div[@class='vertical-list-container mt-4']/div")
    public List <WebElement> allNumbers;




}
