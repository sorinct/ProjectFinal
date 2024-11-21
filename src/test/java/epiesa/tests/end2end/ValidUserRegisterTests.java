package epiesa.tests.end2end;

import epiesa.pageobjectmodels.AccountPage;
import epiesa.pageobjectmodels.AuthenticatePage;
import epiesa.utils.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static epiesa.utils.enums.CookiesActions.ACCEPT;

public class ValidUserRegisterTests extends BaseTest {

    // test data
    public static final String RANDOM_TEST_ACCOUNT_EMAIL = "AUTOMATED_EMAIL_" + RandomStringUtils.randomAlphanumeric(15) + "@test.com";
    public static final String RANDOM_TEST_ACCOUNT_LAST_NAME = "AUTOMATED_LAST_NAME_" + RandomStringUtils.randomAlphanumeric(5);
    public static final String RANDOM_TEST_ACCOUNT_FIRST_NAME = "AUTOMATED_FIRST_NAME_" + RandomStringUtils.randomAlphanumeric(5);
    public static final String RANDOM_TEST_ACCOUNT_PASSWORD = RandomStringUtils.randomAlphanumeric(16);

    AuthenticatePage authenticatePage;

    // precondition
    /**
     * Opening the Register page and Accept the Cookies
     */
    @Before
    public void openAuthenticationPageAndAcceptCookies() {
        navigateToURL(AuthenticatePage.PATH);
        authenticatePage = new AuthenticatePage(driver); // incep sa lucrez pe pagina de Login/Register

        // accept cookies
        authenticatePage.handleCookieDialog(ACCEPT);
    }

    /**
     * !! VERY IMPORTANT: DO NOT RUN THIS TEST MULTIPLE TIMES, IT CAN CREATE TOO MANY ACCOUNTS FOR THE APPLICATION TO HANDLE
     * <p>
     * Test Case 2: New User Registration
     * <p>
     * Objective: Verify that a new user can successfully register.
     * <p>
     * Steps:
     * Navigate to the login page and select the "CONT NOU" option.
     * Fill in required registration fields (name, email, password, etc.).
     * Submit the registration form.
     * Expected Result: User is registered and redirected to the account dashboard with a welcome message.
     */
    @Test
    public void verifyThatANewUserCanSuccessfullyRegister() {
        // enter correct credentials
        authenticatePage.enterNewAccountEmail(RANDOM_TEST_ACCOUNT_EMAIL);
        authenticatePage.enterNewAccountLastName(RANDOM_TEST_ACCOUNT_LAST_NAME);
        authenticatePage.enterNewAccountFirstName(RANDOM_TEST_ACCOUNT_FIRST_NAME);
        authenticatePage.enterNewAccountPassword(RANDOM_TEST_ACCOUNT_PASSWORD);
        authenticatePage.enterNewAccountConfirmPassword(RANDOM_TEST_ACCOUNT_PASSWORD);
        authenticatePage.clickOnRegisterButton();// sunt redirectionat pe pagina de Account

        AccountPage accountPage = new AccountPage(driver); // incep sa lucrez pe pagina de Account
        Assert.assertEquals("User failed to register",
                "Email: " + RANDOM_TEST_ACCOUNT_EMAIL,
                accountPage.verifyMyAccountEmailIsCorrect());

        // add the users to a file for clean up purposes
        addCreatedAccountEmailsToAFileForCleanUp();
    }

    /**
     * utility method to add all new registered user emails to a file, to keep track of the new records created in the DB
     */
    private void addCreatedAccountEmailsToAFileForCleanUp() {
        File file = new File("src/test/resources/emails_generated_by_register_test.txt");
        try {
            // Check if file exists, if not create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // Append text with commas
            FileUtils.writeStringToFile(file, RANDOM_TEST_ACCOUNT_EMAIL + ",\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
