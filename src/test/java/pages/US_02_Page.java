package pages;

<<<<<<< HEAD
=======
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
>>>>>>> master
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_02_Page {
<<<<<<< HEAD

=======
>>>>>>> master
    public US_02_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

<<<<<<< HEAD
=======
    @FindBy(id="item-1")
    public WebElement checkboxMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement checkBoxHeader;


>>>>>>> master

}
