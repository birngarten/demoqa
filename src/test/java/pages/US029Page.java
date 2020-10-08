package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US029Page {
    public US029Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
