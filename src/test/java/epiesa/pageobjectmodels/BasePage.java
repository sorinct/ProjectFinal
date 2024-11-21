package epiesa.pageobjectmodels;

import epiesa.pageobjectmodels.modules.CartModule;
import epiesa.pageobjectmodels.modules.CookiesModule;
import epiesa.pageobjectmodels.modules.SearchModule;
import epiesa.utils.enums.CookiesActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static epiesa.utils.enums.CookiesActions.*;

public class BasePage {

    // 1. driver
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait longWait;

    // modules
    protected CookiesModule cookiesModule;
    protected SearchModule searchModule;
    protected CartModule cartModule;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // initiate modules
        this.cookiesModule = new CookiesModule(driver);
        this.searchModule = new SearchModule(driver);
        this.cartModule = new CartModule(driver);
    }

    // cookies module
    public void handleCookieDialog(CookiesActions action) {
        if (cookiesModule.isDialogVisible()) {
            if (action.equals(ACCEPT)) {
                cookiesModule.clickToAccept();
            } else if (action.equals(REJECT)) {
                cookiesModule.clickToReject();
            }
        }
    }

    // search module
    public void enterInSearchBar(String text) {
        searchModule.enterInSearchBar(text);
    }

    public void clickSearchIconButton() {
        searchModule.clickSearchIconButton();
    }

    // cart module
    public int getCartProductsNumberOfItems() {
        return cartModule.getCartProductsNumberOfItems();
    }

    public void clickOnCart() {
        cartModule.clickOnCart();
    }

    public WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitUntilAlertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText(Alert alert) {
        return alert.getText();
    }

    public void acceptAlert(Alert alert) {
        // Press the OK button from alert
        alert.accept();
    }

    public void acceptAlert(Alert alert, String response) {
        // Enter response on prompt alert
        alert.sendKeys(response);
        // Press the OK button from alert
        alert.accept();
    }

    public void cancelAlert(Alert alert) {
        //Press the Cancel button from alert
        alert.dismiss();
    }

    public boolean isAlertClosed() {
        try {
            driver.switchTo().alert();
            return false;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }
}
