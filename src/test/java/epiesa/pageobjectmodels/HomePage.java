package epiesa.pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    // 1. driver
    WebDriver driver;

    // 2. constructorul paginii
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. selectori / elemente (daca folosesc Page Factory)
    By myAccountDropDown = By.cssSelector(".header-top .header-right .btn-group .contul-meu");
    By loginAndMyAccountHeader = By.cssSelector(".header-top .header-right .btn-group .dropdown-menu li a[href=\"/autentificare-epiesa/\"]");
    By usernameInput = By.cssSelector("[name=\"login_utilizator\"]");

    // 4. metode de actiune
    public void hoverOnMyAccount() {
        WebElement myAccountDropDownElement = driver.findElement(myAccountDropDown);
        Actions action = new Actions(driver);
        action.moveToElement(myAccountDropDownElement).perform();
    }


    public void clickOnMyAccount(){
        WebElement loginMyAccountHeaderFieldElement = driver.findElement(loginAndMyAccountHeader);
        loginMyAccountHeaderFieldElement.click();
    }

    public void enterUserName(String emailadress){
        WebElement userNameElement = driver.findElement(usernameInput);
        userNameElement.sendKeys(emailadress);
    }

    // 5. metode de verificare
}
