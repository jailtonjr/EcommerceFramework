package co.mercadolibre.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static ConfigFileReader configFileReader = new ConfigFileReader();
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, configFileReader.getSeconds());
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, configFileReader.getTimeout()), this);
    }

    protected void waitForElementToAppear(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
