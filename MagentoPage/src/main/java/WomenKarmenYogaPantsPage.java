import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WomenKarmenYogaPantsPage extends BasePage {
    public WomenKarmenYogaPantsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(1)")
    private WebElement selectSize28;
    @FindBy(css = "div[role='listbox'] > div:nth-of-type(3)")
    private WebElement selectColorWhite;
    @FindBy(css = ".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    private WebElement selectColorGray;
    @FindBy(css = ".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(1)")
    private WebElement selectColorBlack;
    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;
    @FindBy(css = "div[role='alert'] > div > div")
    private WebElement getConfirmationText;
    @FindBy(css = ".counter.qty > .counter-number")
    private WebElement getCartQty;
    @FindBy(css = ".minicart-wrapper > .action.showcart")
    private WebElement shoppingCart;
    @FindBy(css=".action.viewcart > span")
    private WebElement viewShoppingCart;
    @FindBy(css = "li:nth-of-type(1) > .product a[title='Remove item']")
    private WebElement itemOneDeleteButton;
    @FindBy(xpath = "//*[text()='\" + text + \"']\")")
    private WebElement confirmDeleteButton;
    @FindBy(css = "li > .product > .product-item-details")
    private List<WebElement> allProducts;
    @FindBy(css = "button#top-cart-btn-checkout")
    private WebElement proceedToCheckout;

    @FindBy(css="strong#block-upsell-heading")
    private WebElement getNameOfTheSection;

    @FindBy(css=".items.list.product-items.products > li:nth-of-type(2)")
    private WebElement idaWorkoutPants;
    public void clickSelectSize28() {
        selectSize28.click();
    }

    public void clickSelectColorWhite() {
        selectColorWhite.click();
    }

    public void clickSelectColorGray() {
        selectColorGray.click();
    }

    public void clickSelectColorBlack() {
        selectColorBlack.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getConfirmationText() {
        return getConfirmationText.getText();
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

    public void clickItemOneDeleteButton() {
        itemOneDeleteButton.click();
    }

    public void clickConfirmDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the OK button is clickable
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-primary.action-accept")));
        okButton.click();
    }

    public List<WebElement> getAllProducts(){
        return allProducts;
    }
    public int getProductsSize(){
        return allProducts.size();
    }
    public void clickProceedToCheckout(){
        proceedToCheckout.click();
    }
    public String getNameOfTheSection(){
        return getNameOfTheSection.getText();
    }
    public void clickIdaWorkoutPants(){
        idaWorkoutPants.click();
    }
}
