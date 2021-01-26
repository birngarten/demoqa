package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class US030Page {
    public US030Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(id = "searchBox")
    public WebElement searchBox;
    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@role='columnheader']")
    public List<WebElement> columnHeader;
    @FindBy(xpath = "//div[@class='rt-tr -odd']")
    public WebElement firstBook;
    @FindBy(id = "basic-addon2")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@role='gridcell']")
    public List<WebElement> allData;
    @FindBy(xpath = "//div[@role='gridcell']")
    public Set<WebElement> allData2;
    @FindBy(xpath = "//select[@aria-label='rows per page']")
    public WebElement pagePerPageDropbox;
    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement firstBooksLink;
    @FindBy(id = "addNewRecordButton")
    public WebElement backToBookStore;

}
