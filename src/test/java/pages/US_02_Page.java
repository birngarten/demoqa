package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_02_Page {

    public US_02_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
