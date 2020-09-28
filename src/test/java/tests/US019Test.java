package tests;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US019Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US019Test {
    US019Page us019Page = new US019Page();

    @BeforeMethod
    public void start() {
        Driver.getDriver().get("https://demoqa.com/progress-bar");
    }

    @Test
    public void tc097() {
        //sayfanin basliginin "Progress Bar "oldugunu assert edin.
        Assert.assertEquals(us019Page.pageHeader.getText(), "Progress Bar");
    }

    @Test
    public void tc098() {
        //Start yazisinin beyaz renkte ve mavi renkli button oldugunu assert edin
        Color.fromString(us019Page.startStopButton.getCssValue("color")).asHex();
        Assert.assertEquals(Color.fromString(us019Page.startStopButton.getCssValue("color")).asHex(), "#ffffff");
        Assert.assertEquals(Color.fromString(us019Page.startStopButton.getCssValue("background-color")).asHex(), "#007bff");
    }

    @Test
    public void tc099() {
        //Start ikonuna basildiginda veri islendigini assert edin
        us019Page.startStopButton.click();
        List<String> progressReturn = new ArrayList<>();
        progressReturn.add(us019Page.progressBarPercent.getAttribute("aria-valuenow"));
        for (int i = 0; i < 101; i++) {
            if (!progressReturn.contains(us019Page.progressBarPercent.getAttribute("aria-valuenow"))) {
                progressReturn.add(us019Page.progressBarPercent.getAttribute("aria-valuenow"));
            }
        }
        System.out.println(progressReturn);
        Assert.assertTrue(progressReturn.size() > 1);
    }

    @Test
    public void tc100() {
        //veri islemeye basladiginda "Stop" yazdigini assert edin.
        us019Page.startStopButton.click();
        Assert.assertEquals(us019Page.startStopButton.getText(),"Stop");
    }
    @Test
    public void tc101(){
        //Veri islemesinin mavi renkte oldugunu assert edin.
        us019Page.startStopButton.click();
        ReusableMethods.waitFor(1);
        String color = Color.fromString(us019Page.progressBarPercent.getCssValue("background-color")).asHex();
        Assert.assertEquals(color,"#17a2b8");
    }
    @Test
    public void tc102(){
        us019Page.startStopButton.click();
        // veri islemesi bittiginde rengin yesile dönmesini assert edin.
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
//        String green = Color.fromString("#28a745").asHex();
//        System.out.println(green);
//        wait.until(ExpectedConditions.attributeToBe(us019Page.progressBar,"background-color","rgb(40, 167, 69)"));
        ReusableMethods.waitFor(10);
        String color = Color.fromString(us019Page.progressBar.getCssValue("background-color")).asHex();
        Assert.assertEquals(color,"#28a745");
    }
    @Test
    public void tc103(){
        us019Page.startStopButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(us019Page.resetButton));
        Assert.assertEquals(us019Page.resetButton.getText(),"Reset");
    }
    @Test
    public void tc104(){
        //"Restart" tekrar click yapildiginda veri islenmesini assert edin.
        us019Page.startStopButton.click();
        ReusableMethods.waitFor(15);
        us019Page.resetButton.click();
        us019Page.startStopButton.click();
        List<String> progressReturn = new ArrayList<>();
        progressReturn.add(us019Page.progressBarPercent.getAttribute("aria-valuenow"));
        for (int i = 0; i < 50; i++) {
            if (!progressReturn.contains(us019Page.progressBarPercent.getAttribute("aria-valuenow"))) {
                progressReturn.add(us019Page.progressBarPercent.getAttribute("aria-valuenow"));
            }
        }
        Assert.assertTrue(progressReturn.size() > 1);
    }

}



