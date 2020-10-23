package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_28_Page {
    public US_28_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[5]")
    public WebElement interactionsCard;

    @FindBy(xpath = "//span[.='Dragabble']")
    public WebElement dragabbleMenuLink;

    @FindBy(xpath = "//div[.='Dragabble']")
    public WebElement dragabbleHeaderText;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    public WebElement dragabbleHeaderTextBg;

    @FindBy(xpath = "//a[@role='tab']")
    public List <WebElement> dragabbleTabList;

    @FindBy(id = "dragBox")
    public WebElement dragBox;

    @FindBy(id = "restrictedX")
    public WebElement dragBoxX;

    @FindBy(id = "restrictedY")
    public WebElement dragBoxY;

    @FindBy(id = "containmentWrapper")
    public WebElement firstMoveArea;

    @FindBy(xpath = "//div[@class='draggable ui-widget-content m-3']")
    public WebElement secondMoveArea;

    @FindBy(xpath = "//div[@id='containmentWrapper']/div")
    public WebElement firstMoveAreaElement;

    @FindBy(xpath = "//div[@class='draggable ui-widget-content m-3']/span")
    public WebElement secondMoveAreaElement;

    @FindBy(xpath = "//div[@class='cursor-style-container mt-4']/div")
    public List <WebElement> cursorTypeBoxList;

    @FindBy(xpath = "//body")
    public WebElement pageBody;

    @FindBy(id = "cursorCenter")
    public WebElement cursorCenter;

    @FindBy(id = "draggableExample-tab-cursorStyle")
    public WebElement cursorStyleTab;



    // Hareket Ettirme ve Konum Kontrol Methodu //

    public static boolean isMoveAndCheckLocation(WebElement element, String axis, int xOffSet, int yOffSet) {
        int firstLocationX = element.getLocation().x;
        int firstLocationY = element.getLocation().y;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(element).moveByOffset(xOffSet, yOffSet).build().perform();
//        wait.until(ExpectedConditions.attributeContains(element, "style", "top"));
        ReusableMethods.waitFor(3);
        int lastLocationX = element.getLocation().x;
        int lastLocationY = element.getLocation().y;

        if (axis.equalsIgnoreCase("x") && firstLocationX != lastLocationX && firstLocationY == lastLocationY) {
            return true;
        } else if (axis.equalsIgnoreCase("y") && firstLocationX == lastLocationX && firstLocationY != lastLocationY) {
            return true;
        } else if (axis.equalsIgnoreCase("xy") && firstLocationX != lastLocationX && firstLocationY != lastLocationY) {
            return true;
        } else {
            return false;
        }

    }


















}
