package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_12_Page {
    public US_12_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//span[@class='text'])[13]")
    public WebElement frames;

    @FindBy(css = "#frame2")
    public WebElement frame2;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    public WebElement frame2Text;
}
