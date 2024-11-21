package epiesa.pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
    public static final String PATH = "admin-cont-epiesa/";

    // 2. constructorul paginii
    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 3. elemente (folosesc Page Factory)
    @FindBy(css = ".contul-meu+.dropdown-menu [href=\"/logout-epiesa/\"]") // todo create new module MyAccount in Header
    WebElement singOutButton;

    @FindBy(css = "[class=\"contul-meu-right\"] a")
    WebElement myAccountEmail;

    // 4. metode de actiune
    public void clickOnSignOut() {
        singOutButton.click();
    }

    // 5. metode de verificare
    public String verifyMyAccountEmailIsCorrect() {
        waitUntilElementVisible(myAccountEmail);
        return myAccountEmail.getText();
    }
}
