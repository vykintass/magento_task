import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Scenario1Test extends BaseTest{

    @Test
    public void scenarioOneTest() throws InterruptedException {
        //1.1.
        homePage.clickMenCategoryButton();
        menPage.clickhoodiesAndSweathirtsButton();
        //Check if section name is as expected
        Assertions.assertEquals("Hoodies & Sweatshirts", hoodiesAndSweatshirtsPage.getSectionName(),"Section name is incorrect");
        //1.2.
        //Check if number per page is equal to the actual displayed number of items
        Assertions.assertEquals(hoodiesAndSweatshirtsPage.getPerPageNumber(),hoodiesAndSweatshirtsPage.getProductsCount(),"Products number is incorrect");
        //1.3.
        //Store name of the item for later use, 1.6.
        String itemNameInTheCatalogue =    hoodiesAndSweatshirtsPage.getItemName();
        hoodiesAndSweatshirtsPage.clickSelectedOneItem();
        //Check if item name is correct
        Assertions.assertEquals("Frankie Sweatshirt", frankieSweatshirtPage.getItemName(), "Item name is incorrect");
        frankieSweatshirtPage.clickDetailsButton();
        //1.4.
        //Select specific item size, colour and quantity
        frankieSweatshirtPage.clickItemSize();
        frankieSweatshirtPage.clickItemColour();
        frankieSweatshirtPage.enterItemQuantity(5);
        //1.5.
        //Check the number of items in the cart
        Integer initialQty = frankieSweatshirtPage.getCartItemQuantity();
        frankieSweatshirtPage.clickAddToCart();
        //Wait until cart quantity is updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            Integer updatedQty = frankieSweatshirtPage.getCartItemQuantity();
            return !updatedQty.equals(initialQty);  // Wait until the quantity changes
        });
        Integer updatedQty = frankieSweatshirtPage.getCartItemQuantity();
        //Check if confirmation text is displayed
        Assertions.assertTrue(frankieSweatshirtPage.getConfirmationText().contains("to your shopping cart"),"Incorrect confirmation message");
        //Check if cart quantity is increased
        Assertions.assertTrue(updatedQty>initialQty,"The number of items in the cart did not increase");
        //1.6
        frankieSweatshirtPage.clickShoppingCart();
        frankieSweatshirtPage.clickViewShoppingCart();
        //Check if the page name is correct
        Assertions.assertEquals("Shopping Cart", shoppingCartPage.getPageName(), "The page name is not correct");
        String itemNameInTheCart = shoppingCartPage.getItemName();
        //Check if the name of the item is the same as it was in the catalogue
        Assertions.assertEquals(itemNameInTheCatalogue, itemNameInTheCart, "The name of the item was changed");
        //1.7.
        shoppingCartPage.clickProceedToCheckoutButton();
        //Check if you navigated to the right page and if the page has the correct name.
        Assertions.assertEquals("Shipping Address",checkoutPage.getPageName(), "The page name is not correct");
        //1.8.
        // Wait until the email field is visible
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getEmailField()));
        //Input data
        checkoutPage.inputEmailField();
        checkoutPage.inputFirstnameField("TestFirst");
        checkoutPage.inputLastnameField("TestSecond");
        checkoutPage.inputAddressField("TestAddress");
        checkoutPage.inputCityField("TestCity");
        checkoutPage.inputProvinceField("TestProvince");
        checkoutPage.inputPostalCodeField("12345");
        checkoutPage.inputPhoneNumberField("12345678");
        checkoutPage.clickSelectShippingMethod();
        //Proceed to the next page
        checkoutPage.clickNextButton();
        //Check if page title is correct
        Assertions.assertEquals("Payment Method", checkoutPage.getPaymentPageText(), "The page name is not correct");


        // Click the "Place Order" button
        checkoutPage.clickPlaceOrderButton();
        //Check the confirmation message
        Assertions.assertTrue(checkoutPage.checkConfirmationText(), "Message is not displayed");
        Assertions.assertEquals("Thank for your purchase", checkoutPage.getConfirmationText(), "Incorrect confirmation message");
    }

}
