package ru.yandex.testMarket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class YandexTestPage {

    WebDriver  driver;
    WebDriverWait wait;

    public YandexTestPage(WebDriver driver) throws IOException, ParseException {
        this.driver = driver;
    }
    JSONParser parser = new JSONParser();

    Reader reader = new FileReader("src\\main\\resources\\test.json");
    JSONObject jsonObject = (JSONObject) parser.parse(reader);

    @FindBy(id = "header")
    private WebElement header;

    By getMarketLocator = By.cssSelector("a[data-id='market']");
    By getSomeSpaceLocator = By.cssSelector(".\\_21NjfY1k45");
    By getComputerTechnologyLocator = (By.xpath("//a[contains(@href, '/catalog--kompiuternaia-tekhnika/54425')]"));
    By getTabletsLocator = (By.xpath("//li/div/a"));
    By getInputFromLocator = (By.id("glpricefrom"));
    By getInputToLocator = (By.id("glpriceto"));
    By getNameLabelLocator = (By.xpath("//span[contains(.,'Samsung')]"));
    By getSecondResultLocator = (By.xpath("//div[2]/div[4]/div/h3/a"));
    By getHeaderSearchToLocator = (By.id("header-search"));
    By getButtonSubmitLocator = (By.cssSelector(".button2"));
    By getFinalResultLocator = (By.xpath("//div[2]/div[4]/div/h3/a"));

    By getBackPreloader = By.cssSelector(".preloadable__preloader:nth-child(6)");
    By getPreloader = By.cssSelector(".preloadable__preloader:nth-child(6) > .spin2");

    public void open(){
        String url = (String) jsonObject.get("url");
        driver.get(url);
    }

    public void goMarket() {
        driver.findElement(getMarketLocator).click();
    }

    public void goSpace() {
        driver.findElement(getSomeSpaceLocator).click();
    }

    public void goCatalogComputerTechnology() {
        driver.findElement(getComputerTechnologyLocator).click();
    }

    public void goCatalogTablets() {
        driver.findElement(getTabletsLocator).click();
    }

    public void inputFieldFrom() {
        String from = (String) jsonObject.get("from");
        driver.findElement(getInputFromLocator).sendKeys(from);
    }

    public void inputFieldTo() {
        String to = (String) jsonObject.get("to");
        driver.findElement(getInputToLocator).sendKeys(to);
    }

    public void chooseNameMark() throws InterruptedException {
        driver.findElement(getNameLabelLocator).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(getBackPreloader));
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(getPreloader));
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(getPreloader));
       // Thread.sleep(3000);
    }

    public String saveSecondResult() {
        String title = driver.findElement(getSecondResultLocator).getAttribute("title");
        return title;
    }

    public void inputInSearch() {
        driver.findElement(getHeaderSearchToLocator).sendKeys(driver.findElement(getSecondResultLocator).getAttribute("title"));
    }

    public void clickButtonSubmit() {
        driver.findElement(getButtonSubmitLocator).click();
    }

    public String saveFinalResult() {
        String title = driver.findElement(getFinalResultLocator).getAttribute("title");
        return title;
    }

    public void equalResult() {
        try {
            System.out.println(saveSecondResult());
            System.out.println(saveFinalResult());
            System.out.println(saveSecondResult().equals(saveFinalResult()));
             if (saveSecondResult().equals(saveFinalResult()) == false) {
                 throw new Exception();
             }
            System.out.println("EQUAL");
        } catch (Exception e) {
            System.out.println("NOT EQUAL");
            Assert.fail(e + " Not Equal");
        }
    }
}
