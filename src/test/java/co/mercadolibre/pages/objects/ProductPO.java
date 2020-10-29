package co.mercadolibre.pages.objects;

import co.mercadolibre.framework.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductPO extends BasePage {

    public ProductPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "nav-search-input")
    private WebElement searchInput;

    @FindBy(className = "ui-search-item__title")
    private WebElement productName;

    @FindBy(className = "price-tag-fraction")
    private WebElement productPrice;


    //TODO
    // - Increase the XPath and learn xpath functions
    // - Create a list of products and handle it on another class

    @FindBy(xpath = "//section[@class='ui-search-results']//ol//li[@class='ui-search-layout__item'][1]//span[contains(@class, 'ui-search-installments ')]")
    private WebElement installmentsQtd;

    @FindBy(xpath = "//section[@class='ui-search-results']//ol//li[@class='ui-search-layout__item'][1]//span[contains(@class, 'ui-search-installments ')]")
    private WebElement getInstallmentsPrice;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/section/ol/li")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//*[@id=\"cookieDisclaimerButton\"]")
    private WebElement cookieButton;

    public void searchProduct(String product) {
        waitForElementToAppear(searchInput);
        searchInput.sendKeys(product + Keys.ENTER);
    }

    public String getProductName() {
        waitForElementToAppear(productName);
        return productName.getText();
    }

    public double getProductPrice() {
        waitForElementToAppear(productPrice);
        return Double.parseDouble(productPrice.getText());
    }

    public int getProductInstallmentsQtd() {
        waitForElementToAppear(installmentsQtd);
        return Integer.parseInt(installmentsQtd.getText().substring(0, 2));
    }

    public void clickOkCookie () {
        waitForElementToAppear(cookieButton);
        cookieButton.click();
    }

    public double getGetInstallmentsPrice() {
        waitForElementToAppear(getInstallmentsPrice);
        String installmentPrice = getInstallmentsPrice.getText();
        String result = installmentPrice.substring(installmentPrice.indexOf('$') + 1, installmentPrice.length());
        return Double.parseDouble(result.trim());
    }

    public List<WebElement> getListOfProductsByName() {
        waitForElementToAppear(searchInput);
        List<WebElement> listProductByName = new ArrayList<>();
        for (WebElement item : listOfProducts) {
            listProductByName.add(item.findElement(By.xpath(".//h2")));
        }
        return listProductByName;
    }

    public void clickOnRandomProductFromThePage (List<WebElement> listProducts) throws InterruptedException {
        Random randomProductIndex = new Random();
        WebElement element = listProducts.get(randomProductIndex.nextInt(listProducts.size()));
        System.out.println("random element name:" + element.getText() + "webelement: "+ element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

}
