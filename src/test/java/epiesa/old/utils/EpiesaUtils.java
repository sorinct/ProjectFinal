package epiesa.old.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EpiesaUtils {
    public static WebDriver launchAndCloseCookies() {
//        Folosim utils din selenium
//        WebDriver driver = BrowserUtils.getDriver("chrome");
        WebDriver driver = new ChromeDriver();

//        Navigam Epiesa si asteptam 5 sec pt incarcare
        driver.navigate().to("https://www.epiesa.ro");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        Cautam buton cookies si dam click
        WebElement dismissPopup = driver.findElement(By.cssSelector(".cc-nb-okagree"));
        dismissPopup.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    return driver;
    }
}
