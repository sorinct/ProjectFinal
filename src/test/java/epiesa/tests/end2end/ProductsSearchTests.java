package epiesa.tests.end2end;

import epiesa.pageobjectmodels.CartPage;
import epiesa.pageobjectmodels.HomePage;
import epiesa.pageobjectmodels.SearchProductsPage;
import epiesa.utils.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static epiesa.utils.enums.CookiesActions.ACCEPT;
import static epiesa.utils.enums.CookiesActions.REJECT;

public class ProductsSearchTests extends BaseTest {

    public static final String TEST_SEARCH_TEXT = "placute frana";

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
//        homePage.hoverOnMyAccount();
//        CartPage cartPage = new CartPage(driver);
//        cartPage.hoverOnMyAccount();
//        cartPage.handleCookieDialog(REJECT);
    }

    /**
     * Test Case 3: Search for a Product
     * <p>
     * Objective: Verify that a user can search for a product.
     * <p>
     * Steps:
     * Enter a product name (e.g., "brake pads") into the search bar.
     * Click on the search icon.
     * Expected Result: Search results page displays products related to the entered term.
     */
    @Test
    public void verifyThatAUserCanSearchForAProduct() {
        // enter text in search bar and click on icon
        homePage.enterInSearchBar(TEST_SEARCH_TEXT);
        homePage.clickSearchIconButton(); // sunt redirectionat pe pagina de SearchProducts

        SearchProductsPage searchProductsPage = new SearchProductsPage(driver); // incep sa lucrez pe pagina de SearchProducts
        Assert.assertTrue("Products were not found", searchProductsPage.verifyProductsAreDisplayed());
    }
}
