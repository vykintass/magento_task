import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class WomenPantsPage extends BasePage {

    public WomenPantsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1#page-title-heading > .base")
    private WebElement getPageName;
    @FindBy(css = "div:nth-of-type(11) > div[role='tab']")
    private WebElement priceList;
    @FindBy(css = "div:nth-of-type(11) > div[role='tabpanel'] > ol > li:nth-of-type(1) > a")
    private WebElement lowestPriceRange;
    @FindBy(css = ".filter-value")
    private WebElement filterValues;
    @FindBy(css = "li > .product-item-info  .price-box.price-final_price .price-wrapper > .price")
    private List<WebElement> productPrices;
    @FindBy(css = "li > .product-item-info")
    private static List<WebElement> productItems;

    @FindBy(css = "button.add-to-cart") // Assuming there is a button to add item to cart
    private WebElement addToCartButton;

    public String getPageName() {
        return getPageName.getText();
    }

    public void clickPriceList() {
        priceList.click();
    }

    public void clickLowestPriceRange() {
        lowestPriceRange.click();
    }

    public String getFilterValues() {
        return filterValues.getText();
    }

    public void selectCheapestItemAndAddToCart() {
        //Add to the list
//        List<Double> prices = productPrices.stream()
//                .map(WebElement::getText)
//                .map(priceText -> priceText.replaceAll("[^\\d.]", "")) // Remove non-numeric characters except dot
//                .map(Double::parseDouble) // Convert to Double
//                .collect(Collectors.toList());
//        // Find the minimum price
//        OptionalDouble minPrice = prices.stream()
//                .mapToDouble(Double::doubleValue)
//                .min();
//        return prices;
        if (productPrices.isEmpty()) {
            throw new RuntimeException("No products found");
        }

        double minPrice = Double.MAX_VALUE;
        WebElement cheapestItem = null;

        for (int i = 0; i < productPrices.size(); i++) {
            WebElement priceElement = productPrices.get(i);
            String priceText = priceElement.getText().replace("$", "").replace(",", "");
            double price = Double.parseDouble(priceText);

            if (price < minPrice) {
                minPrice = price;
                cheapestItem = productItems.get(i); // Assuming the order is the same
            }
        }

        if (cheapestItem != null) {
            // Click on the add to cart button for the cheapest item
            cheapestItem.click();
        } else {
            throw new RuntimeException("Cheapest item not found");
        }
    }

}
