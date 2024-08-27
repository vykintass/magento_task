import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.CSS;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".base")
    private WebElement getPageName;
    @FindBy(tagName= ".checkout.checkout-methods-items.items.methods  button[title='Proceed to Checkout']")
    private WebElement proceedToCheckoutButton;
    @FindBy(css  = " .col.item  strong > a")
    private WebElement getItemName;

    public String getPageName(){
        return getPageName.getText();
    }
    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
    public String getItemName(){
        return getItemName.getText();
    }
}
