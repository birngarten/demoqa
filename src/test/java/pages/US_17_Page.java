package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_17_Page {
    public US_17_Page() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//span[@class='text'])[18]") //constractor
    public WebElement datePicker;
    @FindBy(id = "datePickerContainer")
    public WebElement dateZone;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement month;
    @FindBy(xpath = "//div[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']")
    //option[@value='2020']
    public WebElement yearRes;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement yearIsk;
    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--015']")
    public WebElement day;
    @FindBy(id = "datePickerMonthYearInput")
    public WebElement selectDateBox;
    @FindBy(xpath = "//input[@id=\"dateAndTimePickerInput\"]")
    public  WebElement dateTimePickerBox;
}
