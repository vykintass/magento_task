import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario2Test extends BaseTest{
    @Test
    public void scenarioTwoTest() throws InterruptedException {
        //2.1.
        homePage.clickWomenCategoryButton();
        womenPage.clickPantsButton();
        //Check the name of the page
        Assertions.assertEquals("Pants", womenPantsPage.getPageName(), "The page name is not correct");
        //2.2.
        womenPantsPage.clickPriceList();
        womenPantsPage.clickLowestPriceRange();
        //Check filter values
        Assertions.assertEquals("$30.00 - $39.99", womenPantsPage.getFilterValues(), "Incorrect filter value");
        //2.3.
        //Select cheapest item from the list
        womenPantsPage.selectCheapestItemAndAddToCart();
        //Choose color, size
        womenKarmenYogaPantsPage.clickSelectSize28();
        womenKarmenYogaPantsPage.clickSelectColorWhite();
        womenKarmenYogaPantsPage.clickAddToCartButton();
        //Check if confirmation message was displayed
        Assertions.assertTrue(womenKarmenYogaPantsPage.getConfirmationText().contains("to your shopping cart"));
        //2.4.
        Integer initialQty = womenKarmenYogaPantsPage.getCartItemQuantity();
        womenKarmenYogaPantsPage.clickSelectColorGray();
        womenKarmenYogaPantsPage.clickAddToCartButton();
        //Wait until cart quantity is updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            Integer firstQty = womenKarmenYogaPantsPage.getCartItemQuantity();
            return !firstQty.equals(initialQty);  // Wait until the quantity changes
        });
        int firstQty = womenKarmenYogaPantsPage.getCartItemQuantity();
        //Check if cart quantity is increased
        Assertions.assertTrue(firstQty>initialQty,"The number of items in the cart did not increase");
        //Add second item
        womenKarmenYogaPantsPage.clickSelectColorBlack();
        womenKarmenYogaPantsPage.clickAddToCartButton();
        //Wait until cart quantity is updated
        wait.until(driver -> {
            Integer secondQty = womenKarmenYogaPantsPage.getCartItemQuantity();
            return !secondQty.equals(firstQty);  // Wait until the quantity changes
        });
       int secondQty = womenKarmenYogaPantsPage.getCartItemQuantity();
        //Check if cart quantity is increased
        Assertions.assertTrue(secondQty>firstQty,"The number of items in the cart did not increase");
        //2.5.
        //Navigate to the cart
        womenKarmenYogaPantsPage.clickShoppingCart();
        //Delete items from the shopping cart
        int initialCount = womenKarmenYogaPantsPage.getProductsSize();
        womenKarmenYogaPantsPage.clickItemOneDeleteButton();
        womenKarmenYogaPantsPage.clickConfirmDeleteButton();
        //Wait for system to delete one item
        wait.until(driver -> womenKarmenYogaPantsPage.getProductsSize() < initialCount);
        int updatedCount = womenKarmenYogaPantsPage.getProductsSize();
        //Check message after deleting items
        Assertions.assertTrue(initialCount>updatedCount, "Count did not change");
        //2.6.
        womenKarmenYogaPantsPage.clickProceedToCheckout();
        //2.7.
        //Go back to the previous page
        driver.navigate().back();
        //Check if this is the right page with recommended items
        Assertions.assertTrue(womenKarmenYogaPantsPage.getNameOfTheSection().contains("you might like"), "Incorrect page");
        womenKarmenYogaPantsPage.clickIdaWorkoutPants();
        //Check if it is the right page
        Assertions.assertTrue(womenIdaWorkoutPantsPage.getItemName().contains("Ida Workout"), "Incorrent item name");
        //Select item properties
        womenIdaWorkoutPantsPage.clickSize29();
        womenIdaWorkoutPantsPage.clickColourPink();

        int quantityBeforeAddingNewItem = womenIdaWorkoutPantsPage.getCartItemQuantity();
        //Check if number in the cart did not change going through the pages
        Assertions.assertEquals(updatedCount, quantityBeforeAddingNewItem, "Quantity have changed going from one page to another");
        //Add item to the cart
        womenIdaWorkoutPantsPage.clickAddToCart();
        //Wait until number is updated
        wait.until(driver -> {
            Integer quantityAfterAddingNewItem = womenIdaWorkoutPantsPage.getCartItemQuantity();
            return !quantityAfterAddingNewItem.equals(quantityBeforeAddingNewItem);  // Wait until the quantity changes
        });
        int quantityAfterAddingNewItem = womenIdaWorkoutPantsPage.getCartItemQuantity();
        //Check if the number increased
        Assertions.assertTrue(quantityAfterAddingNewItem>quantityBeforeAddingNewItem, "Quantity did not increase");
        //2.8.
        //Navigate to the checkout
        womenIdaWorkoutPantsPage.clickShoppingCart();
        womenIdaWorkoutPantsPage.clickProceedToCheckoutButton();
        //Check if you navigated to the right page and if the page has the correct name.
        Assertions.assertEquals("Shipping Address",checkoutPage.getPageName(), "The page name is not correct");
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

    }


}
