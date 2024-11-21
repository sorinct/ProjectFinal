package epiesa.pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public static final String PATH = "cos-cumparaturi-epiesa/";

    // 2. constructorul paginii
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 3. elemente (folosesc Page Factory)
    // todo only works for one product, make it work for more
    @FindBy(css = ".cumparaturi-text>p")
    WebElement productText;

    @FindBy(css = ".plus")
    WebElement increaseQuantityPlusSign;

    @FindBy(css = ".minus")
    WebElement decreaseQuantityMinusSign;

    @FindBy(css = ".delete-bttn")
    WebElement itemDeleteButton;

    @FindBy(css = "#aaa_st")
    WebElement subTotal;

    @FindBy(css = "#aaa2")
    WebElement stotal;

    @FindBy(css = "[action=\"/cos-cumparaturi-epiesa/#aicisha\"]>h4")
    WebElement emptyCartText;

    // 4. metode de actiune
    public void clickOnIncreaseQuantityPlusSign() {
        increaseQuantityPlusSign.click();
    }

    public void clickOnDecreaseQuantityMinusSign() {
        decreaseQuantityMinusSign.click();
    }

    public void clickOnItemDeleteButton() {
        itemDeleteButton.click();
    }

    // 5. metode de verificare
    public String verifyProductTextIsCorrect() {
        return productText.getText();
    }

    public String verifySubTotalText() {
        return subTotal.getText();
    }

    public int verifySubTotalPrice() {
        return Integer.parseInt(verifySubTotalText().trim().split(" ")[0]);
    }

    public String verifyEmptyCartText() {
        return emptyCartText.getText();
    }
}
