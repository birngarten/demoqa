package tests;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.Driver;

public class elements {
    DemoqaPage demoqaPage = new DemoqaPage();
    @Test
    public void textBox() {
        Driver.getDriver().get("https://demoqa.com/elements");
        demoqaPage.allElementsMenu.stream().map(t->t.getText()).forEach(System.out::println);
    }

    @Test
    public void webTables() {
        Driver.getDriver().get("https://demoqa.com/webtables");
        demoqaPage.addButton.click();
        demoqaPage.firstname.sendKeys("Ali");
        demoqaPage.lastname.sendKeys("Veli");
        demoqaPage.userEmail.sendKeys("123");
        demoqaPage.age.sendKeys("12");
        demoqaPage.salary.sendKeys("1200000");
        demoqaPage.department.sendKeys("test");
        demoqaPage.submitButton.click();
        System.out.println("Css value: " + demoqaPage.userEmail.getCssValue("border-color"));
        String cssValueColor = demoqaPage.userEmail.getCssValue("border-color");
        String hex = Color.fromString(cssValueColor).asHex();
        System.out.println("Hex :" + hex );



        String color =demoqaPage.firstname.getCssValue("border-color");
        System.out.println("firstname border: " + Color.fromString(color).asHex());

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.attributeContains(demoqaPage.userEmail,"border-color","rgb(220, 53, 69)"));

        System.out.println("Color = " + demoqaPage.userEmail.getCssValue("border-color"));
        Assert.assertEquals(demoqaPage.userEmail.getCssValue("border-color"),"rgb(220, 53, 69)");


    }

}
