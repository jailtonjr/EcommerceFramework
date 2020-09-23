package co.mercadolibre.pages.objects;

import co.mercadolibre.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/section/ol/li[1]/div/div/div[2]/div[3]/div[1]/div[1]/span/text()")
    private WebElement installmentsQtd;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/section/ol/li[1]/div/div/div[2]/div[3]/div[1]/div[1]/span/div/div/span/span[2]")
    private WebElement getInstallmentsPrice;

    @FindBy(className = "ui-search-item__title")
    private List<WebElement> productsNames;


    public void searchProduct(String product) {
        waitForElementToAppear(searchInput);
        searchInput.sendKeys(product + Keys.ENTER);
    }

    public String getProductName() {
        waitForElementToAppear(productName);
        return productName.getText();
    }

    public String getProductPrice() {
        waitForElementToAppear(productPrice);
        return productPrice.getText();
    }

    public String getProductInstallmentsQtd() {
        waitForElementToAppear(installmentsQtd);
        return installmentsQtd.getText();
    }

    public List<WebElement> listOfProducts() {
        waitForElementToAppear(productName);
        return productsNames;
    }

}
