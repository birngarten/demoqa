package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US021Page {
    public US021Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
