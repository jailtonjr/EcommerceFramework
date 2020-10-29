package co.mercadolibre.framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Project: SimpleTestFramework
 * Created by: Jailton Louzada
 * WebSite: https://jailtonjr.dev
 * Description: BaseTest
 */
public abstract class BaseTest {

    protected static WebDriver driver;
    static ConfigFileReader configFileReader = new ConfigFileReader();


    @BeforeClass
    public static void startServer() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(configFileReader.getApplicationUrl());
    }

    @AfterClass
    public static void stopServer() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}