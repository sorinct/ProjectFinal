package epiesa.pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public static final String PATH =
            "scut-motor-dacia-logan-ii-1-6-16v-benzina-105-cai-asam-55260/110762/103397/epsprdt-3038489/";

    // 2. constructorul paginii
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 3. elemente (folosesc Page Factory)
    @FindBy(css = "#adauga_piesa_cos>button")
    WebElement addToCartButton;

    // 4. metode de actiune
    public void clickOnAddToCart() {
        addToCartButton.click();
    }

    // 5. metode de verificare
}