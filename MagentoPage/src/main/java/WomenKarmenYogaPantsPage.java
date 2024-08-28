import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenKarmenYogaPantsPage extends BasePage{
    public WomenKarmenYogaPantsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css=".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(1)")
    private WebElement selectSize28;
    @FindBy(css = "div[role='listbox'] > div:nth-of-type(3)")
    private WebElement selectColorWhite;
    @FindBy(css = ".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    private WebElement selectColorGray;
    @FindBy(css = ".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(1)")
    private WebElement selectColorBlack;
    @FindBy(id="product-addtocart-button")
    private WebElement addToCartButton;
    @FindBy(css="div[role='alert'] > div > div")
    private WebElement getConfirmationText;
    @FindBy(css=".counter.qty > .counter-number")
    private WebElement getCartQty;


    public void clickSelectSize28(){
        selectSize28.click();
    }
    public void clickSelectColorWhite(){
        selectColorWhite.click();
    }
    public void clickSelectColorGray(){
        selectColorGray.click();
    }
    public void clickSelectColorBlack(){
        selectColorBlack.click();
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public String getConfirmationText(){
        return getConfirmationText.getText();
    }
    public Integer getCartItemQuantity(){
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
}
