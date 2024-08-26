import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Scenario1Test extends BaseTest{

    @Test
    public void scenarioOneTest() throws InterruptedException {
        homePage.clickMenCategoryButton();
        menPage.clickhoodiesAndSweathirtsButton();
        //Check if section name is as expected
        Assertions.assertEquals("Hoodies & Sweatshirts", hoodiesAndSweatshirtsPage.getSectionName(),"Section name is incorrect");
        //Check if number per page is equal to the actual displayed number of items
        Assertions.assertEquals(hoodiesAndSweatshirtsPage.getPerPageNumber(),hoodiesAndSweatshirtsPage.getProductsCount(),"Products number is incorrect");
        hoodiesAndSweatshirtsPage.clickselectedOneItem();
        //Check if item name is correct
        Assertions.assertEquals("Frankie Sweatshirt", frankieSweatshirtPage.getItemName(), "Item name is incorrect");
        frankieSweatshirtPage.clickDetailsButton();
        //Select specific item size, calour and quantity
        frankieSweatshirtPage.clickItemSize();
        frankieSweatshirtPage.clickItemColour();
        frankieSweatshirtPage.enterItemQuantity(5);

        //Check the number of items in the cart
        Integer initialQty = frankieSweatshirtPage.getCartItemQuantity();
        frankieSweatshirtPage.clickAddToCart();
        Thread.sleep(5000);
        Integer updatedQty = frankieSweatshirtPage.getCartItemQuantity();
        System.out.println(updatedQty);
        System.out.println(initialQty);
        Assertions.assertTrue(updatedQty>initialQty,"The number of items in the cart did not increase");
    }

}
