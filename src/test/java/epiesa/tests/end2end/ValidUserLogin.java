package epiesa.tests.end2end;

import epiesa.pageobjectmodels.HomePage;
import epiesa.utils.BaseTestClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ValidUserLogin extends BaseTestClass {

    // test data
    String testAccountEmail = "blocnarrecords1@gmail.com";
    String testAccountPassword = "Test123.";

    // precondition
    @Before
    public void openHomepageAndCloseCookies() {
        driver.get("https://www.epiesa.ro");

        // close cookies
        WebElement dismissPopup = driver.findElement(By.cssSelector(".cc-nb-okagree"));
        dismissPopup.click();
    }

    /**
     * Test Case 1: User Login
     * <p>
     * Objective: Verify that a registered user can successfully log in.
     * <p>
     * Steps:
     * Navigate to the login page.
     * <p>
     * Enter a valid username and password.
     * <p>
     * Click on the "LOGIN / CONT NOU" button.
     * <p>
     * Expected Result: User is redirected to their account dashboard and sees a welcome message.
     */
    @Test
    public void userLogin() {
        // Hover contul meu
        HomePage homePage = new HomePage(driver); // incep sa lucrez pe pagina de Homepage
        homePage.hoverOnMyAccount();

//        click pe login
       homePage.clickOnMyAccount();

//        enter adress email and password
homePage.enterUserName(testAccountEmail);

        driver.findElement(By.cssSelector("[name=\"login_utilizator\"]")).sendKeys("email@ceva.com");

        WebElement userPassword = driver.findElement(By.cssSelector("[name=\"login_parola\"]"));
        userPassword.sendKeys(testAccountPassword);

        WebElement authenticateButton = driver.findElement(By.cssSelector("[name=\"form_autentificare\"] [type=\"submit\"]"));
        authenticateButton.click();
        System.out.println();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement myAccountEmail = driver.findElement(By.cssSelector("[class=\"contul-meu-right\"] a"));
        Assert.assertEquals("Email: " + testAccountEmail, myAccountEmail.getText());
    }


    @Test
    public void testLogin2() {

        System.out.println("pasi test 2");
        // eroare

    }

    @Test
    public void loginTest3() {

        System.out.println("pasi test 3");

        driver.quit();
    }


////    @Test
//    public void testNewUserRegistration() {
//        // Navighează la pagina de înregistrare
//        driver.get("https://www.epiesa.ro"); // Înlocuiește cu URL-ul real al paginii de înregistrare
//
//        // Deschide meniul "Contul meu"
//        WebElement contulMeu = driver.findElement(By.cssSelector(".header-right .contul-meu a"));
//        contulMeu.click();
//
//        // Apasă pe butonul "CONT NOU" pentru înregistrare
//        WebElement registerButton = driver.findElement(By.linkText("LOGIN / CONT NOU"));
//        registerButton.click();
//
//        // Completează formularul de înregistrare
//
//
////      adresa de mail
//        driver.findElement(By.(".form-control")).sendKeys("blocnarrecords1@gmail.com");
//
////      nume
//        driver.findElement(By.(""))).sendKeys("Tacu");
//
////      prenume
//        driver.findElement(By.(""))).sendKeys("Sorin");
//
////       parola
//        driver.findElement(By.("")).sendKeys("Test123.");
//
////       confirma parola
//        driver.findElement(By.("")).sendKeys("Test123.");
//
//
//    }
}