package epiesa.pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchProductsPage extends BasePage {

    // 2. constructorul paginii
    public SearchProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 3. elemente (folosesc Page Factory)
    @FindBy(css = ".single-sub-product")
    List<WebElement> products;

    // 4. metode de actiune

    // 5. metode de verificare
    public boolean verifyProductsAreDisplayed() {
        return products.get(0).isDisplayed();
    }
}
