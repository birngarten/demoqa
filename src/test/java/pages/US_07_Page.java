package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_07_Page {

    public US_07_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "item-7")
    public WebElement uploadDownloadLink;

    @FindBy(linkText = "Download")
    public WebElement downloadButton;

    @FindBy(id = "uploadFile")
    public WebElement chooseFileButton;

    @FindBy(id = "uploadedFilePath")
    public  WebElement dosyaYukleTexti;
}
