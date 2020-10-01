package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US017Page {
    public US017Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "//span[.='Date Picker']")
    public WebElement datePickerLink;
    @FindBy(id = "datePickerMonthYearInput")
    public WebElement dateSelectionBox;
    @FindBy(xpath = "//div[.='12']")
    public WebElement dayOfMonthSelection;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement dropdownMonthSelection;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement dropdownYearSelection;
    @FindBy(xpath = "//button[@aria-label='Previous Month']")
    public WebElement previousMontSelectionArrow;
    @FindBy(xpath = "//button[@aria-label='Next Month']")
    public WebElement nextMontSelectionArrow;
    @FindBy (id = "dateAndTimePickerInput")
    public WebElement dateAndTimeBox;
    @FindBy(xpath = "//div[@class='react-datepicker__month-read-view']")
    public WebElement monthDropboxMenu;
    @FindBy(xpath = "//div[@class='react-datepicker__year-read-view']")
    public WebElement yearDropboxMenu;
    @FindBy(xpath = "//div[.='May']")
    public WebElement monthMay;
    @FindBy(xpath = "//div[.='2018']")
    public WebElement year2018;

}
