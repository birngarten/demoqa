package pages;

import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;
import utilities.Driver;

public class US031Page {
    public US031Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
