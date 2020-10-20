package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_28_Page {
    public US_28_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[5]")
    public WebElement interactionsCard;

    @FindBy(xpath = "//span[.='Dragabble']")
    public WebElement dragabbleMenuLink;



}
