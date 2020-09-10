package co.mercadolibre.pages;

import co.mercadolibre.framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPO extends BasePage {

    public SearchPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "nav-search-input")
    private WebElement searchInput;

}
