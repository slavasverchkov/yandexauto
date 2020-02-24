package ru.yandex.testMarket;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.WebDriverSettings;

public class YandexTest extends WebDriverSettings {

    @Test
    public void Login() throws InterruptedException {
        YandexTestPage yandexTestPage = PageFactory.initElements(driver, YandexTestPage.class);

        yandexTestPage.open();
        yandexTestPage.goMarket();
        yandexTestPage.goSpace();
        yandexTestPage.goCatalogComputerTechnology();
        yandexTestPage.goCatalogTablets();
        yandexTestPage.inputFieldFrom();
        yandexTestPage.inputFieldTo();
        yandexTestPage.chooseNameMark();
        yandexTestPage.saveSecondResult();
        yandexTestPage.inputInSearch();
        yandexTestPage.clickButtonSubmit();
        yandexTestPage.equalResult();
    }

    @Test
    public void Translate() throws InterruptedException {
        YandexTranslatePage yandexTranslatePage = PageFactory.initElements(driver, YandexTranslatePage.class);
        YandexTestPage yandexTestPage = PageFactory.initElements(driver, YandexTestPage.class);

        yandexTestPage.open();
        yandexTranslatePage.goTranslate();
        yandexTranslatePage.inputFromLanguage();
        yandexTranslatePage.ChooseLanguageFrom();
        yandexTranslatePage.ChooseLanguageTo();
        yandexTranslatePage.CheckResult();

    }

}
