package ru.yandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();

        // System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
        // this.driver = new InternetExplorerDriver();
    }

    @After
    public void close() {
        System.out.println("test close");
        this.driver.quit();
    }

}
