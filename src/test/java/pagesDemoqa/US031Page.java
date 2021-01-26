package pagesDemoqa;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US031Page {
    public US031Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
