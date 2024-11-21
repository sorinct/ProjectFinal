package epiesa.tests.end2end;

import epiesa.pageobjectmodels.CheckoutPage;
import epiesa.pageobjectmodels.ProductPage;
import epiesa.utils.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static epiesa.utils.enums.CookiesActions.ACCEPT;

public class CheckoutTests extends BaseTest {

    CartTests cartTests = new CartTests();
    CheckoutPage checkoutPage;

    // precondition
    /**
     * Opening the Homepage and Accept the Cookies
     */
    @Before
    public void openCheckoutPageAndAcceptCookies() {
        navigateToURL(ProductPage.PATH);
        ProductPage productPage = new ProductPage(driver); // incep sa lucrez pe pagina de ProductPage

        // accept cookies
        productPage.handleCookieDialog(ACCEPT);

        // add a product to cart and go to the cart page (using the test form CartTests)
        cartTests.productPage = productPage;
        cartTests.addProductToCart();
        navigateToURL(CheckoutPage.PATH);
    }

    /**
     * Test Case 9: Checkout Process
     * <p>
     * Objective: Verify that a user can complete the checkout process.
     * <p>
     * Steps:
     * Go to the cart and click "Checkout."
     * Enter shipping and payment information.
     * Review order and confirm the purchase.
     * Expected Result: User receives an order confirmation message, and order details are saved in their account.
     */
    @Test
    public void check() {
        // todo redefine this test case

    }
}
