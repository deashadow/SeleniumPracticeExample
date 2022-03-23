package com.deashadow.seleniumpractice;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.logging.Logger;

public class GoogleSearchTest {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(GoogleSearchTest.class.getName());

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
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
