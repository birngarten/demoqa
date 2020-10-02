package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US026Page {
    public US026Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
