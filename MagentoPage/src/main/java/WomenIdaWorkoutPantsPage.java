import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenIdaWorkoutPantsPage extends BasePage{

    public WomenIdaWorkoutPantsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css =".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    private WebElement size29;
    @FindBy(css = "div[role='listbox'] > div:nth-of-type(3)")
    private WebElement colourPink;
    @FindBy(css="button#product-addtocart-button")
    private WebElement addToCart;


    public void clickSize29(){
        size29.click();
    }
    public void clickColourPink(){
        colourPink.click();
    }
    public void clickAddToCart(){
        addToCart.click();
    }
}
