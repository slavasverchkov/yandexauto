package com.demoqa.testDemo;

import com.demoqa.WebDriverSettings;
import com.demoqa.testDemo.Sortable.SortablePage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.testMarket.YandexTestPage;

public class DemoTest extends WebDriverSettings {

    @Test
    public void sortable() {
        SortablePage sortable = PageFactory.initElements(driver, SortablePage.class);

        sortable.open();
        sortable.clickSortable();

    }

}
