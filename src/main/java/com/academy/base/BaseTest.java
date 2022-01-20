package com.academy.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

import static com.academy.util.TestDataReader.getBrowser;
import static com.academy.util.TestDataReader.getUrl;

public class BaseTest {

    public WebDriver driver;

    DesiredCapabilities dc;

    @BeforeTest
    public void setUp() throws IOException {

        String browser = getBrowser();
        String baseUrl = getUrl();


        dc = new DesiredCapabilities();
        dc.setPlatform(Platform.WINDOWS);
        dc.setBrowserName(browser);
        //System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        //driver.close();
    }
}
