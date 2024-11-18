package epiesa;

import epiesa.utils.EpiesaUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class RegistrationPageAccess {
    WebDriver driver;

    @Test
    public void test01() {
        driver = EpiesaUtils.launchAndCloseCookies();
//        Hover contul meu
        WebElement elementDropDownButton = driver.findElement(By.cssSelector(".header-top .header-right .btn-group .contul-meu"));
        Actions action= new Actions(driver);
        action.moveToElement(elementDropDownButton).perform();
//        click pe login
        WebElement element = driver.findElement(By.cssSelector(".header-top .header-right .btn-group .dropdown-menu li a[href=\"/autentificare-epiesa/\"]"));
        element.click();
//        verificare url pagina
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.epiesa.ro/autentificare-epiesa/" );
        driver.quit();
    }





//    @Test
//    public void test02() {
//
//        driver = BrowserUtils.getDriver("chrome");
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.navigate().to("http://57.151.123.81:3000/#/");
//        WebElement dismissPopup = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted"));
//        dismissPopup.click();
//
//        WebElement accountButton = driver.findElement(By.id("navbarAccount"));
//        accountButton.click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
////        WebElement loginButton = driver.findElement(By.cssSelector("#navbarLoginButton"));
//        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#navbarLoginButton")));
//        loginButton.click();
//
//        WebElement loginText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-login > div > mat-card > h1")));
//        Assert.assertEquals(loginText.getText(), "Login", "The site is not on the Login page");
//
//        WebElement email = driver.findElement(By.id("email"));
//        WebElement password = driver.findElement(By.id("password"));
//
//        email.clear();
//        email.sendKeys("alex@alex.com");
//        password.clear();
//        password.sendKeys("alsjd3212jdj");
//
//        driver.quit();
//    }
}
