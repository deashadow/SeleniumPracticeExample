package com.deashadow.seleniumpractice;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.logging.Logger;

public class GoogleSearchTest {
    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(GoogleSearchTest.class.getName());

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/firefoxdriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void testGooglePage() {
        String searchWord="Hello world";
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys(searchWord);
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Alert: TITLE: "+ driver.getTitle());
        assertEquals("Google", driver.getTitle());
        LOGGER.info("Alert: TITLE: "+ driver.getTitle());
    }
}
