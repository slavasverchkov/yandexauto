package com.demoqa.testDemo.Sortable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class SortablePage {

    public SortablePage(WebDriver driver)  {
        this.driver = driver;
    }

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://demoqa.com/";

    By getSortablePageLocator = By.xpath("//div[@id='sidebar']/aside/ul/li/a");


    public void open() {
        driver.get(url);
    }

    public void clickSortable(){
        driver.findElement(getSortablePageLocator).click();
    }


}
