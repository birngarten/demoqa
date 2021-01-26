package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US026Page {
    public US026Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Resizable']")
    public WebElement resiableLink;
    @FindBy(xpath = "//div[@style='width: 200px; height: 200px;']")
    public List<WebElement> boxes;
}
