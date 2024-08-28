import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario2Test extends BaseTest{
    @Test
    public void scenarioTwoTest(){
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
        Integer firstQty = womenKarmenYogaPantsPage.getCartItemQuantity();
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
        Integer secondQty = womenKarmenYogaPantsPage.getCartItemQuantity();
        //Check if cart quantity is increased
        Assertions.assertTrue(secondQty>firstQty,"The number of items in the cart did not increase");
        //2.5.
        
    }


}
