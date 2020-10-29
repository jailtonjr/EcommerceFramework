package co.mercadolibre.testCases;

import co.mercadolibre.framework.BaseTest;
import co.mercadolibre.model.Product;
import co.mercadolibre.model.ProductBuilder;
import co.mercadolibre.pages.objects.ProductPO;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSearchTests extends BaseTest {

    public ProductPO product = new ProductPO(driver);

    @Test
    public void searchProduct() throws InterruptedException {
        product.searchProduct("Laptop");
    }

    @Test
    public void fetchProductData() throws InterruptedException {
        product.searchProduct("Iphone");
        System.out.println("product name = "+product.getProductName());;
        assertThat(product.getProductName()).isEqualTo("Celular iPhone SE 2020 64gb Chip A13");
    }

    @Test
    public void printAllProductsNames() {
        product.searchProduct("Tablet");
//        product.listOfProducts().forEach(product -> System.out.println(product.getText()));
    }

    @Test
    public void setProductItem() {
        product.searchProduct("Tablet");

        Product item = new ProductBuilder()
                .name(product.getProductName())
                .price(product.getProductPrice())
                .installments(product.getProductInstallmentsQtd())
                .installmentPrice(product.getGetInstallmentsPrice())
                .build();

        System.out.println(item.toString());
    }

    @Test
    public void setAllProducts() {
        product.searchProduct("Smartphone");
        ArrayList<Product> productsItems = new ArrayList<>();

    }

    @Test
    public void test() throws InterruptedException {
        product.searchProduct("Smartphone");
        product.clickOkCookie();
        List<WebElement> productList = product.getListOfProductsByName();
        for (WebElement itemName : productList) {
            System.out.println("Product:"+itemName.getText());


        }


        product.clickOnRandomProductFromThePage(productList);

        Thread.sleep(3000);













/*        Thread.sleep(3000);
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[@id=\"root-app\"]/div/div/section/ol/li"));
        listOfProducts.stream().forEach(item -> System.out.println(item.findElement(By.xpath(".//h2")).getText()));
        Random randomNumberIndex = new Random();
        WebElement randomProduct = listOfProducts.get(randomNumberIndex.nextInt(listOfProducts.size()));
        System.out.println("Random Element: "+ randomProduct.getText());
        Thread.sleep(3000);
        driver.wait.until(ExpectedConditions.visibilityOf(locator));
        driver.findElement(By.linkText(randomProduct.getText())).click();*/

    }
}

//TODO
// Popup interaction - Keep using
// Expected condition - Keep using
// Assertions with AssertJ (Fluent Assertion)
//  - Use different assertions

// AssertJ
// Selenium WebDriver


// Task
// Pick a random product from the search result
// save the product name and price
// assert the previous name and price after click on the product

