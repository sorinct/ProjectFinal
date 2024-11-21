package epiesa.tests.end2end;

import epiesa.pageobjectmodels.HomePage;
import epiesa.utils.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static epiesa.utils.enums.CookiesActions.ACCEPT;

public class FilterProductsTests extends BaseTest {

    HomePage homePage;

    // precondition
    /**
     * Opening the Homepage and Accept the Cookies
     */
    @Before
    public void openHomepageAndAcceptCookies() {
        navigateToURL(HomePage.PATH);
        homePage = new HomePage(driver); // incep sa lucrez pe pagina de Login/Register

        // accept cookies
        homePage.handleCookieDialog(ACCEPT);
    }

    /**
     * Test Case 4: Filter Products by Category
     * <p>
     * Objective: Verify that a user can filter products within a category.
     * <p>
     * Steps:
     * Navigate to a product category (e.g., "Car Parts").
     * Apply a filter (e.g., "Brand").
     * Expected Result: Product list updates to show only items that match the selected filter criteria.
     */
    @Test
    public void filterProductsByCategory() {
        // todo in progress

    }
}
