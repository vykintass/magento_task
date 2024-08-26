import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrankieSweatshirtPage extends BasePage{

    public FrankieSweatshirtPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".base")
    private WebElement getItemName;
    @FindBy(linkText = "Details")
    private WebElement detailsButton;
    @FindBy(css = "div[role='listbox'] > div:nth-of-type(5)")
    private  WebElement itemSize;
    @FindBy(css=".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(3)")
    private WebElement itemColour;
    @FindBy(id ="qty")
    private WebElement itemQuantity;
    @FindBy(id="product-addtocart-button")
    private WebElement addToCart;
    @FindBy(css=".action.showcart > .counter.qty")
    private WebElement getCartQty;

    public String getItemName(){
        return getItemName.getText();
    }
    public void clickDetailsButton(){
        Scroller.scrollToElement(driver, detailsButton);
        detailsButton.click();
    }
    public void clickItemSize(){
        Scroller.scrollToElement(driver, itemSize);
        itemSize.click();
    }
    public void clickItemColour(){
        itemColour.click();
    }
    public void enterItemQuantity(int quantity){
        String quantityString = Integer.toString(quantity);
        itemQuantity.clear();
        itemQuantity.sendKeys(quantityString);
    }
    public void clickAddToCart(){
        addToCart.click();
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
