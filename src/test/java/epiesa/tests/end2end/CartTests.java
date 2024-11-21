package epiesa.tests.end2end;

import epiesa.pageobjectmodels.CartPage;
import epiesa.pageobjectmodels.ProductPage;
import epiesa.utils.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static epiesa.utils.enums.CookiesActions.ACCEPT;

public class CartTests extends BaseTest {

    // test data
    public static final String TEST_PRODUCT_NAME = "Scut motor ASAM 55260";
    public static final int TEST_PRODUCT_PRICE = 246;
    public static final String EMPTY_CART_TEXT_MESSAGE = "Cosul de cumparaturi este gol.";

    ProductPage productPage;
    CartPage cartPage;

    // precondition
    /**
     * Opening the Homepage and Accept the Cookies
     */
    @Before
    public void openProductPageAndAcceptCookies() {
        navigateToURL(ProductPage.PATH); // se duce direct pe pagina produsului
        productPage = new ProductPage(driver); // incep sa lucrez pe pagina de ProductPage

        // accept cookies
        productPage.handleCookieDialog(ACCEPT);
    }

    /**
     * Test Case 5: Add Product to Cart
     * <p>
     * Objective: Verify that a user can add a product to their cart.
     * <p>
     * Steps:
     * Select a product from a category or search results page.
     * Click on "Add to Cart" button.
     * Expected Result: Product is added to the cart, and cart icon updates to show the item count.
     */
    @Test
    public void addProductToCart() {
        // click on add to cart of that product page
        productPage.clickOnAddToCart();
        Assert.assertEquals("The Item was not added to cart correctly",
                1,
                productPage.getCartProductsNumberOfItems());

        // verify that item text is correct in the cart page
        // todo can be extended to another test that will have this test as precondition
        productPage.clickOnCart(); // sunt redirectionat pe pagina de Cart
        cartPage = new CartPage(driver); // incep sa lucrez pe pagina de Cart
        Assert.assertEquals("None or not the correct item was added to cart",
                TEST_PRODUCT_NAME,
                cartPage.verifyProductTextIsCorrect());
    }

    /**
     * Test Case 6: View Cart
     * <p>
     * Objective: Verify that a user can view their shopping cart.
     * <p>
     * Steps:
     * Click on the "Cosul meu" button/icon to go to the cart page.
     * Expected Result: Cart page displays all added products, their quantities, and prices.
     */
    @Test
    public void viewCart() {
        // todo redefine this test case

    }

    /**
     * Test Case 7: Update Product Quantity in Cart
     * <p>
     * Objective: Verify that a user can change the quantity of a product in the cart.
     * <p>
     * Steps:
     * Open the cart.
     * Adjust the quantity of a product.
     * Expected Result: Product quantity updates, and the total price reflects the change.
     */
    @Test
    public void updateProductQuantityInCart() {
        // precondition add a product to cart and go to the cart page
        addProductToCart();
        // set a variable to hold the price of one piece of that item
        int priceForOneItem = cartPage.verifySubTotalPrice();

        // click on plus sign to increase quantity
        cartPage.clickOnIncreaseQuantityPlusSign();
        Assert.assertEquals("The price for two pieces is not correct",
                priceForOneItem * 2,
                cartPage.verifySubTotalPrice());
    }

    /**
     * Test Case 8: Remove Product from Cart
     * <p>
     * Objective: Verify that a user can remove a product from their cart.
     * <p>
     * Steps:
     * Open the cart.
     * Click the "Remove" button next to a product.
     * Expected Result: Product is removed from the cart, and the total updates accordingly.
     */
    @Test
    public void removeProductFromCart() {
        // precondition add a product to cart and go to the cart page
        addProductToCart();

        // click on the delete button
        cartPage.clickOnItemDeleteButton();
        Assert.assertEquals("The cart message is not correct",
                EMPTY_CART_TEXT_MESSAGE,
                cartPage.verifyEmptyCartText());
    }
}
