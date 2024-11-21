package epiesa.pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static final String PATH = "";

    // 2. constructorul paginii
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 3. elemente (folosesc Page Factory)
    @FindBy(css = ".contul-meu")
    WebElement myAccountDropDown;

    @FindBy(css = ".contul-meu+.dropdown-menu [href=\"/autentificare-epiesa/\"]")
    WebElement loginAndMyAccountHeader;

    @FindBy(css = "[class=\"contul-meu-right\"] a")
    WebElement myAccountEmail;

//    todo move to my account module
    // 4. metode de actiune
    public void hoverOnMyAccount() {
        Actions action = new Actions(driver);
        action.moveToElement(myAccountDropDown).perform();
    }

    public void clickOnLogin(){
        loginAndMyAccountHeader.click();
    }

    // 5. metode de verificare
    public boolean verifyLoginAndMyAccountHeaderIsDisplayed() {
        hoverOnMyAccount();
        waitUntilElementVisible(loginAndMyAccountHeader);
        return loginAndMyAccountHeader.isDisplayed();
    }
}
