package epiesa.tests.end2end;

import epiesa.pageobjectmodels.AccountPage;
import epiesa.pageobjectmodels.HomePage;
import epiesa.pageobjectmodels.AuthenticatePage;
import epiesa.utils.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static epiesa.utils.enums.CookiesActions.ACCEPT;

public class ValidUserLoginTests extends BaseTest {

    // test data
    public static final String TEST_ACCOUNT_EMAIL = "blocnarrecords1@gmail.com";
    public static final String TEST_ACCOUNT_PASSWORD = "Test123.";

    HomePage homePage;
    AccountPage accountPage;

    // precondition
    /**
     * Opening the Homepage and Accept the Cookies
     */
    @Before
    public void openHomepageAndAcceptCookies() {
        navigateToURL(HomePage.PATH);
        homePage = new HomePage(driver); // incep sa lucrez pe pagina de Home

        // accept cookies
        homePage.handleCookieDialog(ACCEPT);
    }

    /**
     * Test Case 1: User Login
     * <p>
     * Objective: Verify that a registered user can successfully log in.
     * <p>
     * Steps:
     * Navigate to the login page.
     * Enter a valid username and password.
     * Click on the "LOGIN / CONT NOU" button.
     * Expected Result: User is redirected to their account dashboard and sees a welcome message.
     */
    @Test
    public void verifyThatARegisteredUserCanSuccessfullyLogIn() {
        // Hover on my account
        homePage.hoverOnMyAccount();
        // click login
        homePage.clickOnLogin(); // sunt redirectionat pe pagina de Login

        AuthenticatePage loginPage = new AuthenticatePage(driver); // incep sa lucrez pe pagina de Login
        // enter address email and password
        loginPage.enterUserName(TEST_ACCOUNT_EMAIL);
        loginPage.enterPassword(TEST_ACCOUNT_PASSWORD);
        // click authenticate
        loginPage.clickOnAuthenticateButton(); // sunt redirectionat pe pagina de Account

        accountPage = new AccountPage(driver); // incep sa lucrez pe pagina de Account
        Assert.assertEquals("The email is not correct",
                "Email: " + TEST_ACCOUNT_EMAIL,
                accountPage.verifyMyAccountEmailIsCorrect());
    }

    /**
     * Test Case 10: Logout
     * <p>
     * Objective: Verify that a logged-in user can successfully log out.
     * <p>
     * Steps:
     * After logging in, click on the "Contul meu" dropdown.
     * Select the "Logout" option.
     * Expected Result: User is logged out and redirected to the homepage, or the login page, with the login option
     */
    @Test
    public void verifyThatALoggedInUserCanSuccessfullyLogOut() {
        // run test lof login first as an additional precondition
        verifyThatARegisteredUserCanSuccessfullyLogIn();
        // I am still on account page, so I click on Sign Out button
        homePage.hoverOnMyAccount(); // todo is confuzing but works
        // Click on Delogheza-ma
        accountPage.clickOnSignOut();

        Assert.assertEquals("Sign Out did not redirect to Homepage",
                baseURL + HomePage.PATH,
                driver.getCurrentUrl());
        Assert.assertTrue("Sign Out didn't work as expected",
                homePage.verifyLoginAndMyAccountHeaderIsDisplayed());
    }
}