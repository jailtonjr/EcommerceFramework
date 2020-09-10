package co.mercadolibre.framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Project: SimpleTestFramework
 * Created by: Jailton Louzada
 * WebSite: https://jailtonjr.dev
 * Description: BaseTest
 */
public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void startServer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Selenium server started...");

    }

    @AfterClass
    public static void stopServer() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

//    public WebDriver getDriver() {
//        return driver;
//    }
}