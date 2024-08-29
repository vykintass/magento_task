import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenIdaWorkoutPantsPage extends BasePage {

    public WomenIdaWorkoutPantsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    private WebElement size29;
    @FindBy(css = "div[role='listbox'] > div:nth-of-type(3)")
    private WebElement colourPink;
    @FindBy(css = "button#product-addtocart-button")
    private WebElement addToCart;
    @FindBy(css = ".base")
    private WebElement getItemName;
    @FindBy(css = ".counter.qty > .counter-number")
    private WebElement getCartQty;
    @FindBy(css = ".minicart-wrapper > .action.showcart")
    private WebElement shoppingCart;
    @FindBy(css = "button#top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;

    public void clickSize29() {
        size29.click();
    }

    public void clickColourPink() {
        colourPink.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public String getItemName() {
        return getItemName.getText();
    }

    public Integer getCartItemQuantity() {
        Scroller.scrollToElement(driver, getCartQty);

        try {
            // Attempt to get the text from the cart quantity element
            String text = getCartQty.getText();

            // Parse the text to an integer
            return Integer.parseInt(text);
        } catch (NoSuchElementException e) {
            // If the element is not found, return 0
            return 0;
        } catch (NumberFormatException e) {
            // If there is a problem parsing the text, also return 0
            return 0;
        }
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
