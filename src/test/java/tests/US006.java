package tests;

import org.testng.annotations.BeforeTest;
import pages.DemogaWebTablesButtonsLinksPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US006 {
    DemogaWebTablesButtonsLinksPage demogaWebTablesButtonsLinksPage = new DemogaWebTablesButtonsLinksPage();
    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
}
