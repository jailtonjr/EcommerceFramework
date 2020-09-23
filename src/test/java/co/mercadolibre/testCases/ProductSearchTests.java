package co.mercadolibre.testCases;

import co.mercadolibre.framework.BaseTest;
import co.mercadolibre.model.Product;
import co.mercadolibre.pages.objects.ProductPO;
import org.junit.Test;

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
    }

    @Test
    public void printAllProductsNames() {
        product.searchProduct("Tablet");
        product.listOfProducts().forEach(product -> System.out.println(product.getText()));
    }

    @Test
    public void setAllProductData() {
        product.searchProduct("Tablet");



    }
}
