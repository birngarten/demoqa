package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_23_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class US_23_Test extends TestBase {
    US_23_Page us23Page = new US_23_Page();
    SoftAssert soft = new SoftAssert();


    @BeforeMethod
    public void selectMenu() {
        wait.until(ExpectedConditions.visibilityOf(us23Page.widgetMenuCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us23Page.selectMenuButton.click();
    }

    @Test
    public void TC_128() {
        //Sayfanın başlığınin"Select Menu" oldugunu verify edin
        soft.assertTrue(us23Page.selectMenu.isDisplayed());
        soft.assertAll();

    }

    @Test
    public void TC_129() {
        // Sayfada ilk olarak "Select Value" adi altinda "Select Option" adli box icinde Dropdown
        // menu tiklandiginda acilmalidir ve takibinde menudeki secenekler secilebilmelidir.(Assert)
        ReusableMethods.waitFor(2);
        us23Page.selectValueBox.click();
        System.out.println("DropDown Secenekleri: " + us23Page.selectValueDropDownOptions.size());
        for (WebElement w : us23Page.selectValueDropDownOptions) {
            String menuSecenek = w.getText();
            System.out.println(menuSecenek);
            if (w.getText().contains("Another root option")) {
                w.click();
                //soft.assertTrue(w.isDisplayed());
                break;

            }
            // soft.assertAll();

        }
        /*####################################
        Özkan Abi Yöntem

        String[] expectedList = {"Group 1, option 1", "Group 1, option 2", "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option"};
        int i = 0;
        for (WebElement w : us23Page.allOptionsSelectMenu) {
            String option = w.getText();
            System.out.println(option);
            Assert.assertEquals(option, expectedList[i]);
            i++;
        }

        #######################################
        Samet Abi Yöntem

        us023Page.firstDropbox.click();
        ReusableMethods.waitFor(1);
        String myArray[] = {"Group 1, option 1", "Group 1, option 2", "Group 2, option 1",
                "Group 2, option 2", "A root option", "Another root option"};
        for (int i = 0; i < myArray.length; i++) {
            us023Page.firstDropbox.click();
            ReusableMethods.waitFor(1);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ENTER).perform();
            Assert.assertEquals(us023Page.result.getText(), myArray[i]);
        }
    }

             @FindBy(xpath = "//div[@class=' css-1uccc91-singleValue']")
             public WebElement result;
         */

        // 2.Yol Uzun Method SendKeys ile;

        /*us23Page.selectValueBox.click();
        System.out.println(us23Page.selectValueBox.getText());
        String selectValuOptions[] = {"Group 1, option 2", "Group 1, option 2",
                "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option"};

        List<String> selectList = Arrays.asList(selectValuOptions);
        for (String w : selectList) {
            actions.sendKeys(w).click(us23Page.selectValueBox).perform();
            soft.assertTrue(us23Page.selectValueBox.getText().contains(w));
        }
        soft.assertAll();

        // 3.Yol Uzun List ile

        //List<String> selectList= new ArrayList<>();
        //selectList.add("Group 1, option 2");
        //selectList.add("Group 1, option 2");
        //selectList.add("Group 2, option 1");
        //selectList.add("Group 2, option 2");
        //selectList.add("A root option");
        //selectList.add("Another root option");
        //for (int i = 0; i < selectList.size(); i++) {
        // actions.sendKeys(selectList.get(i)).click(us23Page.selectValueBox).perform();
        // soft.assertTrue(us23page.selectValueBox.getText().contains(selectValuOptions[i]));
        */
    }

    @Test
    public void TC_130() {
        // Sayfada ikinci olarak "Select One" adi altinda "Select Title" adli box icinde Dropdown
        // menu tiklandiginda acilmalidir ve takibinde menudeki secenekler secilebilmelidir.(Assert)
        ReusableMethods.waitFor(2);
        us23Page.selectOneBox.click();
        for (WebElement w : us23Page.selectOneDropDownOptions) {
            String selectOneElement = w.getText();
            if (selectOneElement.contains("Mr.")) {
                w.click();
            }
        }


    }

    @Test
    public void TC_131() {
        //Sayfada ucuncu olarak "Old Style Select Menu" adi altinda ""Red"" adli box icinde Dropdown
        // menu tiklandiginda acilmalidir ve takibinde menudeki secenekler secilebilmelidir.(Assert)"
        us23Page.oldSelectBox.click();
        Select select = new Select(us23Page.oldSelectBox);
        List<WebElement> oldSelectList = select.getOptions();
        System.out.println(oldSelectList.get(4).getText());
        for (WebElement w : oldSelectList) {

            System.out.println(w.getText());
            select.selectByVisibleText(w.getText());

        }
    }

    @Test
    public void TC_132() {
        // Sayfada dorduncu olarak ""Multiselect drop down"" adi altinda
        // ""Select..."" adli box icinde Dropdown menu tiklandiginda acilmalidir
        // ve takibinde menudeki secenekler secilebilmelidir.(Assert)"

        us23Page.multiSelectDropdownBox.click();
        System.out.println(us23Page.multiSelectionDropDownOptions.size());
        ReusableMethods.waitFor(2);
        for (WebElement w : us23Page.multiSelectionDropDownOptions) {
            String multiSelections = w.getText();
            w.click();
        }
        // Ikinci yol SendKeys ile;

        /*String multiSelect[] = {"Green", "Blue", "Black", "Red"};
        List<String> multiSelectionOptions = Arrays.asList(multiSelect);
        for (String w : multiSelectionOptions) {
            actions.sendKeys(w).click(us23Page.multiSelectDropdownBox).perform();
            soft.assertTrue(us23Page.multiSelectDropdownBox.getText().contains(w));
        }*/


    }

    @Test
    public void TC_133() {
        //-Sayfada son olarak "Standard multi select" adi altinda alt alta "Volvo", "Saab","Opel"
        // ve"Audi" secenekleri bulunmali ve secenekler secilebilmelidir. (Assert)"
        us23Page.standartMultiSelect.click();
        Select select = new Select(us23Page.standartMultiSelect);
        List<WebElement> elements = select.getOptions();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            String value = elements.get(i).getText();
            System.out.println(value);
            soft.assertTrue(us23Page.standartMultiSelect.getText().contains(value));
        }
        soft.assertAll();

        // 2.Yol SendKeys;

        //System.out.println(us23page.standartMultiSelect.getText());
        //String standartMultiSelectOptions[]={"Volvo", "Saab","Opel","Audi"};
        //List<String> multiSelectList=Arrays.asList(standartMultiSelectOptions);
        //for (String w:multiSelectList){
        //actions.sendKeys(w).click(us23page.standartMultiSelect);
        //soft.assertTrue(us23page.standartMultiSelect.getText().contains(w));


    }

    @Test
    public void TC_134() {
        //-"Multiselect drop down" ve "Standard multi select"
        // basliklarinin bold oldugunu verify edin.

        ReusableMethods.waitFor(2);
        System.out.println(us23Page.multiSelectBold.getCssValue("font-weight"));
        Assert.assertTrue(us23Page.multiSelectBold.getCssValue("font-weight").equals("400"));
    }
}
