package ru.yandex.testMarket;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class YandexTranslatePage {

    WebDriver driver;
    WebDriverWait wait;

    public YandexTranslatePage(WebDriver driver) throws IOException, ParseException {
        this.driver = driver;
    }

    By getTranslateLocator = By.cssSelector("a[data-id='translate']");
    By getTranslateNameLocator = By.id("header");
    By getTranslateLanguageFrom = By.id("fakeArea");
    By getFromLanguageButton = By.id("srcLangButton");
    By getFromLAnguageButtonEn = By.xpath("//*[@id=\"srcLangListboxContent\"]/div[1]/div[4]");
    By getToLanguageButton = By.id("dstLangButton");
    By getToLanguageButtonIt = By.xpath("//*[@id=\"dstLangListboxContent\"]/div[3]/div[3]");
    By getTranslateResultLocator = By.id("translation");

    public void goTranslate() {
        try {
            driver.findElement(getTranslateLocator).click();
            System.out.println(driver.getCurrentUrl());
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(getTranslateNameLocator));
            if (driver.getCurrentUrl().equals("https://translate.yandex.ru/") == false) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Редирект к странице Translate не выполнен");
        }
    }

    public void inputFromLanguage() {
        driver.findElement(getTranslateLanguageFrom).sendKeys("Hello");
    }

    public void ChooseLanguageFrom() throws InterruptedException {
        driver.findElement(getFromLanguageButton).click();
        Thread.sleep(500);
        driver.findElement(getFromLAnguageButtonEn).click();
    }

    public void ChooseLanguageTo() throws InterruptedException {
        driver.findElement(getToLanguageButton).click();
        Thread.sleep(500);
        driver.findElement(getToLanguageButtonIt).click();
        Thread.sleep(3000);
    }

    public String saveFinalResult() {
        String title = driver.findElement(getTranslateResultLocator).getAttribute("title");

        return title;
    }


    public void CheckResult() throws InterruptedException {
        System.out.println(driver.findElement(getTranslateResultLocator).getText());
        try {
            //Actions action = new Actions(driver);
            // action.moveToElement(driver.findElement(getGetTranslateResultLocator)).doubleClick().perform();
            if (driver.findElement(getTranslateResultLocator).getText().equals("Ciao") == false) {
                throw new Exception();
            }
            System.out.println("Перевод правильный");

        } catch (Exception e) {
            System.out.println("Перевод неправильный1");
            Assert.fail(e + " Перевод неправильный");
        }
    }
}