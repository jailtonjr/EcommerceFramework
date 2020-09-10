package co.mercadolibre.testCases;

import co.mercadolibre.framework.BaseTest;
import co.mercadolibre.pages.ProductPO;
import org.junit.Test;

public class ProductSearchTests extends BaseTest {

    public ProductPO product = new ProductPO(driver);

    @Test()
    public void searchProduct() throws InterruptedException {
        product.openPage("https://www.mercadolibre.com.co/");
        product.searchProduct("tablet");
    }

    @Test()
    public void fetchProductData() throws InterruptedException {
        product.openPage("https://www.mercadolibre.com.co/");
        product.searchProduct("tablet");
        System.out.println(product.getProductName());

    }
}
